package com.example.flo

import android.media.MediaPlayer
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flo.databinding.ActivitySongBinding
import com.google.gson.Gson

class SongActivity :AppCompatActivity() {

    lateinit var binding : ActivitySongBinding //lateinit은 선언은 지금 하고 초기화는 나중에 한다
    lateinit var timer : Timer
    private var mediaPlayer : MediaPlayer? = null // ?는 null이 들어올 수 있다는 뜻
    private var gson : Gson = Gson() // onPause의 앱 종료할 때 노래 정보를 저장하기 위함

    val songs = arrayListOf<Song>()
    lateinit var songDB: SongDatabase
    var nowPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater) // 설정
        setContentView(binding.root) // activity_song.xml의 맨 위로 이동

        initPlayList()
        initSong() // 데이터 받아오기

        initClickListener()

    }



    override fun onPause() { // 포커스 잃으면
        super.onPause()

        songs[nowPos].second = ((binding.songProgressbarSb.progress * songs[nowPos].playTime)/100)/1000
        songs[nowPos].isPlaying = false
        setPlayerStatus(false) // 음악 중단

        // sharedPreferences는 내부저장소에 저장해서 껐다켜도 남는다
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val editor = sharedPreferences.edit() // 저장된 값 사용하려면 editor 필요

        editor.putInt("songId",songs[nowPos].id)

        editor.apply() // GIT에서 push 역할
    }

    override fun onDestroy() { // 앱이 꺼질 때 실행되는 함수. try-catch문 테스트 하려고 씀
        super.onDestroy()
        timer.interrupt()
        mediaPlayer?.release() // mediaPlayer가 가지고 있던 resource 해제
        mediaPlayer = null // mediaPlayer 해제
    }

    private fun initPlayList(){
        songDB = SongDatabase.getInstance(this)!!
        songs.addAll(songDB.songDao().getSongs())
    }

    private fun initClickListener() {
        binding.songSettingBack.setOnClickListener { // Back 버튼 누르면 Fragment 종료
            finish()
        }
        binding.songPlayIv.setOnClickListener { // 재생버튼 누르면 일시정지 버튼 나오기
            setPlayerStatus(true)
        }

        binding.songPauseIv.setOnClickListener { // 일시정지 누르면 재생 버튼 나오기
            setPlayerStatus(false)
        }

        binding.songNextIv.setOnClickListener {
            moveSong(+1)
        }

        binding.songPreviousIv.setOnClickListener {
            moveSong(-1)
        }

        binding.songLikeIv.setOnClickListener {
            setLike(songs[nowPos].isLike)
        }
    }
    private fun initSong(){
        val spf = getSharedPreferences("song", MODE_PRIVATE)
        val songId = spf.getInt("songId",0)

        nowPos = getPlayingSongPosition(songId)

        Log.d("now Song ID",songs[nowPos].id.toString())

        startTimer()
        setPlayer(songs[nowPos])
    }


    private fun setLike(isLike: Boolean){
        songs[nowPos].isLike = !isLike
        songDB.songDao().updateIsLikeById(!isLike,songs[nowPos].id)

        if (!isLike){
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_on)
        } else{
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_off)
        }

    }

    private fun moveSong(direct: Int){
        if (nowPos + direct < 0){
            Toast.makeText(this,"first song",Toast.LENGTH_SHORT).show()
            return
        }

        if (nowPos + direct >= songs.size){
            Toast.makeText(this,"last song",Toast.LENGTH_SHORT).show()
            return
        }

        nowPos += direct

        timer.interrupt()
        startTimer()

        mediaPlayer?.release()
        mediaPlayer = null

        setPlayer(songs[nowPos])
    }


    private fun getPlayingSongPosition(songId: Int): Int{
        for (i in 0 until songs.size){
            if (songs[i].id == songId){
                return i
            }
        }
        return 0
    }

    private fun setPlayer(song : Song){ // 정보 받아오기
        binding.songTitleTv.text = song.title
        binding.songTitleSingerTv.text = song.singer
        binding.songStartTimeTv.text = String.format("%02d:%02d", song.second / 60, song.second%60)
        binding.songEndTimeTv.text = String.format("%02d:%02d", song.playTime / 60, song.playTime%60)
        binding.songAlbumIv.setImageResource(song.coverImg!!)
        binding.songProgressbarSb.progress = (song.second * 1000 / song.playTime)

        val music = resources.getIdentifier(song.music, "raw", this.packageName) // 5주차 내용, music 이름과 같은 mp3 파일을 찾는다
        mediaPlayer = MediaPlayer.create(this, music) // mediaplayer에서 이 음악을 재생할거야

        if (song.isLike){
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_on)
        } else{
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_off)
        }

        setPlayerStatus(song.isPlaying)
    }

    private fun setPlayerStatus(isPlaying : Boolean){ // songPlayIv 버튼 클릭시 실행되는 함수
        songs[nowPos].isPlaying = isPlaying
        timer.isPlaying = isPlaying

        if(isPlaying){ // 실행중이면
            binding.songPlayIv.visibility = View.GONE // 재생 버튼 숨기기
            binding.songPauseIv.visibility = View.VISIBLE // 일시정지 버튼 보이기
            mediaPlayer?.start() // mediaplayer 실행
        }
        else{ // 일시정지 되면
            binding.songPlayIv.visibility = View.VISIBLE // 재생 버튼 보이기
            binding.songPauseIv.visibility = View.GONE // 일시정지 버튼 숨기기
            if(mediaPlayer?.isPlaying == true){ // 재생중이 아닌데 pause하면 오류난다
                mediaPlayer?.pause()
            }
        }
    }

    private fun startTimer(){
        timer = Timer(songs[nowPos].playTime, songs[nowPos].isPlaying)
        timer.start()
    }

    inner class Timer(private val playTime: Int, var isPlaying: Boolean = true):Thread(){
        private var second : Int = 0
        private var mills : Float = 0f

        override fun run() {
            super.run()
            try { // 문제 없으면 실행
                while (true){ // 타이머는 계속 반복

                    if(second >= playTime){
                        break
                    }

                    if(isPlaying){
                        sleep(50)
                        mills += 50

                        runOnUiThread{ // 프로그레스 바를 건들려면 핸들러 or runOnUiThread 사용
                            binding.songProgressbarSb.progress = ((mills / playTime)*100).toInt()
                        }

                        if(mills % 1000 ==0f){ // mills가 1000 될 때마다 second 증가
                            runOnUiThread{
                                binding.songStartTimeTv.text = String.format("%02d:%02d", second / 60, second%60)
                            }
                            second++
                        }
                    }
                }
            }catch (e: InterruptedException){ // 예외 처리
                Log.d("Song", "쓰레드가 죽었습니다. ${e.message}")
            }

        }
    }
}
