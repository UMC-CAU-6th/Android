package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentAlbumBinding
import com.example.flo.databinding.FragmentHomeBinding
import com.example.flo.homefragment.HomeFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class AlbumFragment : Fragment() {//appcompatactivity 대신 안드로이드에서 fragment를 지원해주는 것을 상속 받음.
    lateinit var binding: com.example.flo.databinding.FragmentAlbumBinding
    lateinit var albumBinding: com.example.flo.databinding.FragmentHomeBinding

    private var gson: Gson = Gson()

    private val information = arrayListOf("수록곡", "상세정보", "영상")
    //이 변수가 table layout으로 연결되네..(버튼도 보이네) 수정하는건 이제 xml 파일의 tb를 건드린다.
    //app:tabIndicatorFullWidth="false"--> 이 함수가 글자 크기에 맞게 밑줄이 나타나게 한다.
    //app:tabSelectedTextColor="#3f3fff"
    //app:tabIndicatorColor="#3f3fff" 인디케이터(밑줄)와 글자의 색깔을 바꿔줌
    //app:tabRippleColor="#00ff0000" 버튼 눌렀을때 눌리는 효과 제거 color로 들어간게 투명색임 ㅇㅇ
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        albumBinding  = FragmentHomeBinding.inflate(inflater, container, false)

        //////////////////////////////////////////////6주차 앨범 데이터 반영
        val albumJson = arguments?.getString("album")
        val album = gson.fromJson(albumJson, Album::class.java)
        setInit(album)
        //////////////////////////////////////////////


        val albumAdapter = AlbumVPAdapter(this)
        binding.albumContentVp.adapter = albumAdapter
        TabLayoutMediator(binding.albumContentTb, binding.albumContentVp){
            tab, position ->
            tab.text = information[position]
        }.attach()
        //tablayout과 viewpager를 연결, 중재자역할(스크롤을 동기화)
        //tab과 position은 어디서 나온겨



        /*if(arguments?.getString("album").equals("1")){
            binding.albumSingerNameTv.text=albumBinding.tdMsFirstAlbumSinger.text
            binding.albumMusicTitleTv.text=albumBinding.tdMsFirstAlbumTitle.text
            binding.albumAlbumIv.setImageDrawable(albumBinding.tdMsFirstAlbumImg.drawable)


        }
        else if(arguments?.getString("album").equals("2")){
            binding.albumSingerNameTv.text=albumBinding.tdMsSecondAlbumSinger.text
            binding.albumMusicTitleTv.text=albumBinding.tdMsSecondAlbumTitle.text
            binding.albumAlbumIv.setImageDrawable(albumBinding.tdMsSecondAlbumImg.drawable)

        }
        else if(arguments?.getString("album").equals("3")){
            binding.albumSingerNameTv.text=albumBinding.tdMsThirdAlbumSinger.text
            binding.albumMusicTitleTv.text=albumBinding.tdMsThirdAlbumTitle.text
            binding.albumAlbumIv.setImageDrawable(albumBinding.tdMsThirdAlbumImg.drawable)
        }*/





        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
        }



        return binding.root
        return albumBinding.root
    }

    private fun setInit(album:Album){
        binding.albumSingerNameTv.text=album.singer
        binding.albumMusicTitleTv.text=album.title
        binding.albumAlbumIv.setImageResource(album.coverImg!!)
    }
}