package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentAlbumBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class AlbumFragment : Fragment() {
    lateinit var binding : FragmentAlbumBinding // 설정
    private var gson: Gson = Gson() // HomeFragment에서 보낸 data 받기 위함

    private val information = arrayListOf("수록곡", "상세정보", "영상") // TabLayoutMediator에서 사용

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater,container,false) // 설정

        val albumJson = arguments?.getString("album")
        val album = gson.fromJson(albumJson, Album::class.java)
        setInit(album)

        binding.albumBackIv.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm,HomeFragment()).commitAllowingStateLoss() // HomeFragment로 돌아가기
        }

        val albumAdapter = AlbumVPAdapter(this) 
        binding.albumContenVp.adapter = albumAdapter
        TabLayoutMediator(binding.albumContentTb, binding.albumContenVp){ // TabLayout, ViewPager을 연결
            tab, position->
            tab.text = information[position]
        }.attach()

        return binding.root // 설정해줘야 화면이 나오더라
    }

    private fun setInit(album : Album){
      binding.albumAlbumIv.setImageResource(album.coverImg!!)
      binding.albumMusicTitleTv.text = album.title.toString()
      binding.albumSingerNameTv.text = album.title.toString()
    }
}

