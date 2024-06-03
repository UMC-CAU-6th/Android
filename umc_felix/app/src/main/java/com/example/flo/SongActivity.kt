package com.example.flo

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flo.databinding.ActivitySongBinding
import com.google.gson.Gson
import java.io.IOException


class SongActivity : AppCompatActivity() {
    lateinit var binding : ActivitySongBinding //나중에 초기화 하는 변수

    //lateinit var song : Song    //4주차(초기화해주기위해서)
    //7주차 이후로 주석, 어차피 songs[nowpos]가 같은 역할을 해주니 지움
    lateinit var timer: Timer
    private var mediaplayer: MediaPlayer? = null
    private var gson: Gson = Gson()

    //7주차
    val songs = arrayListOf<Song>()
    lateinit var songDB:SongDatabase
    var nowPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {//activity가 새롭게 생성될 떄, 무조건 실행시켜줘야 하는 함수
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        //xml에 있는 레이아웃들을 메모리상 객체화시키는 행동
        setContentView(binding.root)
        //우리가 ()안에 있는 xml content들을 다 사용하겠다. xml내에 있는 id를 괄호 안에 사용
        //root는 xml안에 있는 최상위 레이아웃


        initPlayList()//7주차
        initSong()//초기화 선언*///4주차 작업, 5주차때 생명주기로 대체 가능할 것 같아 수정.

        setPlayer(songs[nowPos])//4주차에서 text바꿔주는 작업을 함수로 만들기
        //5주차이후로 주석

        if(intent.hasExtra("title")&&intent.hasExtra("singer")){
            binding.songMusicTitleTv.text = intent.getStringExtra("title")!!
            binding.songSingerNameTv.text = intent.getStringExtra("singer")!!
        }

        initClickListener()
        binding.songDownIb.setOnClickListener{
            val song = Song()
            val intent = Intent(this, MainActivity::class.java).apply{
                putExtra("return_title",binding.songMusicTitleTv.text)
                putExtra("return_singer",binding.songSingerNameTv.text)
            }
            setResult(Activity.RESULT_OK, intent)
            if(!isFinishing) finish()
        }



    }




    private fun setPlayer(song: Song){  //onCreate에서initSong() -> setPlayer() -> timer가동
        binding.songMusicTitleTv.text = song.title
        binding.songSingerNameTv.text = song.singer
        binding.songStartTimeTv.text = String.format("%02d:%02d",song.second/60,song.second%60)
        binding.songEndTimeTv.text = String.format("%02d:%02d",song.playTime/60,song.playTime%60)
        binding.songAlbumIv.setImageResource(song.coverImg!!)
        binding.songProgressSb.progress = (song.second*100000/song.playTime).toInt()

        val music = resources.getIdentifier(song.music, "raw", this.packageName)//string값으로 raw파일에서 찾아오기.
        mediaplayer = MediaPlayer.create(this, music)
        mediaplayer?.seekTo(song.second*1000)
        if(song.isLike){
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_on    )
        }else{
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_off    )
        }

        setPlayerStatus(song.isPlaying)
    }

    private fun setPlayerStatus(isPlaying : Boolean){
        songs[nowPos].isPlaying = isPlaying
        timer.isPlaying = isPlaying
        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
            mediaplayer?.start()
        }
        else{
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
            if(mediaplayer?.isPlaying == true){
                mediaplayer?.pause()    //5주차 미디어 플레이어가 재생중이지 않을때 pause하면 오류터짐
            }
        }
    }

    private fun initPlayList(){
        songDB = SongDatabase.getInstance(this)!!
        songs.addAll(songDB.songDao().getSongs())
    }
    //7주차, 앞으로, 뒤로 노래를 옮기고 렌더링하는 함수
    private fun moveSong(direct:Int){
        if(nowPos + direct < 0){
            Toast.makeText(this, "first song", Toast.LENGTH_SHORT).show()
            return
        }
        if(nowPos + direct>= songs.size){
            Toast.makeText(this, "last song", Toast.LENGTH_SHORT).show()
            return
        }
        nowPos += direct
        timer.interrupt()
        startTimer()

        mediaplayer?.release()
        mediaplayer = null


        setPlayer(songs[nowPos])


    }

    private fun initClickListener(){
        binding.songPreviousIv.setOnClickListener {
            //resetPlayer() 누르면 다시 재생되는거 구현한건데, 7주차 강의내용이랑 겹침
            moveSong(-1)
        }
        binding.songNextIv.setOnClickListener {
            moveSong(1)
        }

        binding.songRepeatIv.setOnClickListener {
            setButtonColor(binding.songRepeatIv)
        }
        binding.songRandomIv.setOnClickListener {
            setButtonColor(binding.songRandomIv)
        }
        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(true)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songLikeIv.setOnClickListener {
            setLike(songs[nowPos].isLike)
        }
    }

    //7주차로 바뀜
    private fun initSong(){ //song변수 초기화 함수(4주차)
        val spf = getSharedPreferences("song", MODE_PRIVATE)
        val songId = spf.getInt("songId", 0)

        nowPos = getPlayingSongPosition(songId)//list의 index값을 받아옴
        Log.d("now Song ID",songs[nowPos].id.toString())

        //7주차 이후로 주석, song은 이제 nowpos로 받아온다.
        /*if(intent.hasExtra("title")&&intent.hasExtra("singer")){
            song = Song(
                intent.getStringExtra("title")!!,
                intent.getStringExtra("singer")!!,
                intent.getIntExtra("second",0),
                intent.getIntExtra("playTime",0),
                intent.getBooleanExtra("isPlaying",false),
                intent.getStringExtra("music")!!//string을 음악파일로 실행하기 위해선?

            )
        }*/
        startTimer()
        setPlayer(songs[nowPos])
    }

    private fun setLike(isLike : Boolean){
        songs[nowPos].isLike = !isLike
        songDB.songDao().updateIsLikeById(!isLike,songs[nowPos].id)
        if(!isLike){
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_on    )
        }else{
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_off    )
        }
    }

    private fun getPlayingSongPosition(songId: Int): Int{
        for(i in 0 until songs.size){
            if(songs[i].id == songId){
                return i
            }
        }
        return 0

        //song = songDB.songDao().getSong(songid)왜 이렇게 하는게 아니지??
        //songId랑 index의 값이 삭제작업중에 상이해질수있기 때문..?
    }

    private fun resetPlayer(){//5주차 미션 추가 다시 재생되는 부분
        timer.interrupt()
        songs[nowPos].second = 0
        mediaplayer?.seekTo(0)
        binding.songStartTimeTv.text = String.format("%02d:%02d",songs[nowPos].second/60,songs[nowPos].second%60)
        binding.songProgressSb.progress = (songs[nowPos].second*100000/songs[nowPos].playTime).toInt()
        startTimer()
    }
    private fun startTimer(){
        timer = Timer(songs[nowPos].playTime,songs[nowPos].second,songs[nowPos].isPlaying)
        timer.start()   //밑에 스레드 실행
    }

    inner class Timer(private val playTime : Int,var second : Int, var isPlaying: Boolean = true):Thread(){//4주차 progressBar thread
    private var mills: Float = second.toFloat()*1000//second초랑 mill초 구분해서 받게

        override fun run() {
            super.run()
            try {
                while(true){
                    if(second>=playTime) {
                        break
                    }

                    if(isPlaying){
                        sleep(50)
                        mills+=50
                        //너무 빈번하게는 안되고 mills초니깐 1말고 50으로 한듯
                        runOnUiThread{
                            binding.songProgressSb.progress = ((mills / playTime)*100).toInt()
                            //sb의 max는 mills초 계산을 위해 100*1000으로 설정

                        }
                        //mills 1000단위가 지날때마다 1초이므로 조건문 계산
                        if(mills >= (second*1000+1000).toFloat()){
                            runOnUiThread {
                                binding.songStartTimeTv.text = String.format("%02d:%02d",second/60,second%60)
                            }
                            second++
                        }
                    }
                }
            }catch (e : InterruptedException){
                Log.d("Song","쓰레드가 죽었습니다. ${e.message}")

            }
        }

    }

    fun setButtonColor(btn : ImageView){//랜덤버튼,반복버튼 클릭하면 불들어오게(3주차)

        if(btn.imageTintList == ColorStateList.valueOf(Color.parseColor("#4B0082"))){
            btn.imageTintList = null
        }
        else{
            btn.imageTintList = ColorStateList.valueOf(Color.parseColor("#4B0082"))
        }
    }
    //5주차, 사용자가 포커스를 잃었을 떄, 음악이 중지된다.
    override fun onPause() {
        super.onPause()
        setPlayerStatus(false)
        //song에 데이터 저장하기
        songs[nowPos].second = ((binding.songProgressSb.progress*songs[nowPos].playTime)/100)/1000
        //100은 진행도 백분율, 1000은 mil sec이라 정수로 나오게 나눠주기
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        //내부 저장소 역할을 해주는 sharedPreferences.
        //song은 sharedPreference의 이름을 말하며, MODE_PRIVATE은 말 그대로 모드를 private하여 자기 앱에서만 사용할 수 있게 설정하는것
        //대부분은 mode_private으로 하는듯
        val editor = sharedPreferences.edit()   //sPre를 조작해줄라면 에디터가 필요하다!
        //editor.putString("key","value") 근데 일일이 더럽게 넣지말고 json으로->gson(자바객체는 json, json은 자바객체로 바꿔줌)
        /*val songJson = gson.toJson(songs[nowPos])
        editor.putString("songData", songJson)*/
        //7주차 이후 주석, song 자체를 넣는게 아니고 songId만 넣으면 됨.

        editor.putInt("songId",songs[nowPos].id)
        editor.apply()//이 작업까지 해줘야 들어간것
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.interrupt()   //timer thread에서 액티비티가 종료돼었을때 thread도 같이 종료해주는 역할
        mediaplayer?.release()  //미디어플레이어가 갖고 있던 리소스 해제,
        mediaplayer = null //미디어 플레이어 자체도 해제, home 버튼 누르니깐 노래가 꺼지네
    }

    /*//onResume은 화면이 보여지고 난 후에 실행되므로 onStart가 안정적
    override fun onStart() {//액티비티 전환이 되면 onStart가 켜진다.
        super.onStart()
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val songJson = sharedPreferences.getString("songData",null)
        song = if(songJson == null){
            Song("라일락","아이유(IU)",0,60,false,"music_lilac")
        }else{
            gson.fromJson(songJson, Song::class.java)//song 데이터에 반영
        }

    }*/


}