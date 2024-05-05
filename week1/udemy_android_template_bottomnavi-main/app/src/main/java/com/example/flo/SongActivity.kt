package com.example.flo

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flo.databinding.ActivitySongBinding

class SongActivity :AppCompatActivity() {

    lateinit var binding : ActivitySongBinding //lateinit은 선언은 지금 하고 초기화는 나중에 한다

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater) // 설정
        setContentView(binding.root) // activity_song.xml의 맨 위로 이동
        
        binding.songSettingBack.setOnClickListener { // Back 버튼 누르면 Fragment 종료
            finish()
        }
        binding.songPlayIv.setOnClickListener{ // 재생버튼 누르면 일시정지 버튼 나오기
            setPlayerStatus(false)
        }

        binding.songPauseIv.setOnClickListener{ // 일시정지 누르면 재생 버튼 나오기
            setPlayerStatus(true)
        }
        if(intent.hasExtra("title") && intent.hasExtra("singer")){// 물건이 올 수도 있고 안 올 수도 있으니 if문 사용
            binding.songTitleTv.text = intent.getStringExtra("title") // intent 택배 상자에서 title 키값을 가진 text로 바꾼다
            binding.songTitleSingerTv.text = intent.getStringExtra("singer")
        }
    }
    
    fun setPlayerStatus(isPlaying : Boolean){ // songPlayIv 버튼 클릭시 실행되는 함수
        if(isPlaying){
            binding.songPlayIv.visibility = View.VISIBLE // 재생 버튼 보이기
            binding.songPauseIv.visibility = View.GONE // 일시정지 버튼 숨기기
        }
        else{
            binding.songPlayIv.visibility = View.GONE // 재생 버튼 숨기기
            binding.songPauseIv.visibility = View.VISIBLE // 일시정지 버튼 보이기
        }
    }
}
