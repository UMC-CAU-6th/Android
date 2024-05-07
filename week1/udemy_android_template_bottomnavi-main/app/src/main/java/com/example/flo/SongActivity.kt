package com.example.flo

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flo.databinding.ActivitySongBinding

class SongActivity :AppCompatActivity() {

    lateinit var binding : ActivitySongBinding //lateinit은 선언은 지금 하고 초기화는 나중에 한다
    lateinit var song : Song
    lateinit var timer : Timer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater) // 설정
        setContentView(binding.root) // activity_song.xml의 맨 위로 이동

        initSong() // 데이터 받아오기
        setPlayer(song)

        binding.songSettingBack.setOnClickListener { // Back 버튼 누르면 Fragment 종료
            finish()
        }
        binding.songPlayIv.setOnClickListener{ // 재생버튼 누르면 일시정지 버튼 나오기
            setPlayerStatus(true)
        }

        binding.songPauseIv.setOnClickListener{ // 일시정지 누르면 재생 버튼 나오기
            setPlayerStatus(false)
        }

    }

    override fun onDestroy() { // 앱이 꺼질 때 실행되는 함수. try-catch문 테스트 하려고 씀
        super.onDestroy()
        timer.interrupt()
    }

    private fun initSong(){ // 4주차 내용
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            song = Song(
                intent.getStringExtra("title")!!,
                intent.getStringExtra("singer")!!,
                intent.getIntExtra("second", 0),
                intent.getIntExtra("playTime",0),
                intent.getBooleanExtra("isPlaying", false)
            )
        }
        startTimer()
    }

    private fun setPlayer(song : Song){ // 정보 받아오기
        binding.songTitleTv.text = intent.getStringExtra("title")!! // intent 택배 상자에서 title 키값을 가진 text로 바꾼다
        binding.songTitleSingerTv.text = intent.getStringExtra("singer")!!
        binding.songStartTimeTv.text = String.format("%02d:%02d", song.second / 60, song.second%60)
        binding.songEndTimeTv.text = String.format("%02d:%02d", song.playTime / 60, song.playTime%60)
        binding.songProgressbarSb.progress = (song.second * 1000 / song.playTime)

        setPlayerStatus(song.isPlaying)
    }

    private fun setPlayerStatus(isPlaying : Boolean){ // songPlayIv 버튼 클릭시 실행되는 함수
        song.isPlaying = isPlaying
        timer.isPlaying = isPlaying

        if(isPlaying){ // 실행중이면
            binding.songPlayIv.visibility = View.GONE // 재생 버튼 숨기기
            binding.songPauseIv.visibility = View.VISIBLE // 일시정지 버튼 보이기
        }
        else{ // 일시정지 되면
            binding.songPlayIv.visibility = View.VISIBLE // 재생 버튼 보이기
            binding.songPauseIv.visibility = View.GONE // 일시정지 버튼 숨기기
        }
    }

    private fun startTimer(){
        timer = Timer(song.playTime, song.isPlaying)
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
