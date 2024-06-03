package com.example.flo

import android.content.ContentValues.TAG
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.activity.result.contract.ActivityResultContracts
import com.example.flo.databinding.ActivityMainBinding
import com.example.flo.homefragment.HomeFragment
import com.example.flo.lockerfragment.LockerFragment
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null    //5주차

    private var song:Song = Song()
    private var gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //setTheme(R.style.Theme_FLO)//메인 액티비티가 로딩되었으니, 스플래시 테마에서 다시 flo테마로
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inputDummySongs()//7주차 더미데이터 삽입



        //val song = Song(binding.mainMiniplayerTitleTv.text.toString(), binding.mainMiniplayerSingerTv.text.toString(),0,60,false,"music_lilac")


        //2주차 정보 갖고오는 미션, 5주차에서 수정, Song에서 데이터 받아오는 느낌으로.
        val getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result->
            if(result.resultCode == RESULT_OK){//이부분이 결과를 받아오는 부분인듯
                if((result.data?.hasExtra("return_title") == true)&&(result.data?.hasExtra("return_singer") == true)) {
                    binding.mainMiniplayerTitleTv.text = result.data?.getStringExtra("return_title")
                    binding.mainMiniplayerSingerTv.text = result.data?.getStringExtra("return_singer")
                    song.title = result.data?.getStringExtra("return_title").toString()
                    song.singer = result.data?.getStringExtra("return_singer").toString()
                    Log.d(TAG, "good ww");

                }
            }
        }
        binding.mainPlayerCl.setOnClickListener{
            val editor = getSharedPreferences("song", MODE_PRIVATE).edit()
            editor.putInt("songId",song.id)
            editor.apply()

            val intent = Intent(this, SongActivity::class.java)
            startActivity(intent)

            //7주차 이후로 주석처리 DB에 맞는 id로 전송해야함.
            /*//startActivity(Intent(this, SongActivity::class.java)) 이거랑 똑같은 문장
            val intent = Intent(this, SongActivity::class.java)
            song.singer = binding.mainMiniplayerSingerTv.text.toString()
            song.title = binding.mainMiniplayerTitleTv.text.toString()
            intent.putExtra("title", song.title)
            intent.putExtra("singer",song.singer)
            intent.putExtra("second", song.second)//4주차 추가 데이터
            intent.putExtra("playTime",song.playTime)//4주차 추가 데이터
            Log.d("check",song.second.toString()+"second")

            intent.putExtra("isPlaying", song.isPlaying)//4주차 추가 데이터
            intent.putExtra("music",song.music)//5주차 노래 데이터
            //getResult부분도 반영되게 해야할듯???
            getResultText.launch(intent)
            //2주차 미션예제, 임의적인 STRING_INTENT_KEY랑*/
        }
        initBottomNavigation()

        Log.d("song", song.singer + song.title)
    }


    //onResume은 화면이 보여지고 난 후에 실행되므로 onStart가 안정적
    override fun onStart() {
        super.onStart()
        /*val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val songJson = sharedPreferences.getString("songData",null)
        song = if(songJson == null){
            Song("라일락","아이유(IU)",0,60,false,"music_lilac")
        }else{
            gson.fromJson(songJson, Song::class.java)//song 데이터에 반영
        }*/ //5주차 작업, 7주차 이후로 DB에서 더미데이터 받아오기 위한 주석
        val spf = getSharedPreferences("song", MODE_PRIVATE)
        val songId = spf.getInt("songId", 0)

        val songDB = SongDatabase.getInstance(this)!!

        song = if(songId == 0){
            songDB.songDao().getSong(1)
        } else{
            songDB.songDao().getSong(songId)
        }


        Log.d("song ID", song.id.toString())
        setMiniPlayer(song)
    }

    //2주차 미션
    private fun initBottomNavigation(){

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener{ item ->
            when (item.itemId) {

                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.lookFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LookFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.searchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.lockerFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LockerFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }


    class ThreadExample : Thread(){//4주차 스레드 실습
        override fun run() {
            super.run()//이 스레드를 실행한다는 뜻
            for(i in 1..1000){//for문이 신기하네
                Log.d("test","first : $i")
            }
        }
    }

    class ThreadExample2 : Thread(){//4주차 스레드 실습
        override fun run() {
            super.run()//이 스레드를 실행한다는 뜻
            for(i in 1000 downTo 1){//for문이 신기하네
                Log.d("test","second : $i")
            }
        }
    }//실행하고 싶으면 val a = ThreadExample(), val b = ThreadExample2()
    //A.start하면됨, 두개 동시 실행하면은 순차적으로 실행되지 않고, 1실행되다가 좀 후에 2실행되고 그럼(무작위 순서)
    //contextSwitching때문에 그러는 것
    //순서를 정하고 싶다면 Join 혹은 aSyncTest쓰라는듯
    //a.start() -> a.join() -> b.start()이러면 순차적으로

    private fun setMiniPlayer(song: Song){
        binding.mainMiniplayerTitleTv.text= song.title
        binding.mainMiniplayerSingerTv.text= song.singer
        binding.mainProgressSb.progress = (song.second*100000)/song.playTime
    }



    private fun inputDummySongs(){//7주차
        val songDB = SongDatabase.getInstance(this)!!
        val songs = songDB.songDao().getSongs()

        if(songs.isNotEmpty()) return//정보가 비어있지 않다면 그대로 적용해주면 될것
        //비어있다면 더미데이터 넣어줘야함.

        songDB.songDao().insert(
            Song(
                "Lilac",
                "아이유 (IU)",
                0,
                200,
                false,
                "music_lilac",
                R.drawable.img_album_exp2,
                false,
            )
        )

        songDB.songDao().insert(
            Song(
                "Flu",
                "아이유 (IU)",
                0,
                200,
                false,
                "music_flu",
                R.drawable.img_album_exp2,
                false,
            )
        )

        songDB.songDao().insert(
            Song(
                "Butter",
                "방탄소년단 (BTS)",
                0,
                190,
                false,
                "music_butter",
                R.drawable.img_album_exp,
                false,
            )
        )

        songDB.songDao().insert(
            Song(
                "Next Level",
                "에스파 (AESPA)",
                0,
                210,
                false,
                "music_next",
                R.drawable.img_album_exp3,
                false,
            )
        )


        songDB.songDao().insert(
            Song(
                "Boy with Luv",
                "music_boy",
                0,
                230,
                false,
                "music_lilac",
                R.drawable.img_album_exp4,
                false,
            )
        )


        songDB.songDao().insert(
            Song(
                "BBoom BBoom",
                "모모랜드 (MOMOLAND)",
                0,
                240,
                false,
                "music_bboom",
                R.drawable.img_album_exp5,
                false,
            )
        )


        val _songs = songDB.songDao().getSongs()

        Log.d("DB Data", _songs.toString())

    }


}