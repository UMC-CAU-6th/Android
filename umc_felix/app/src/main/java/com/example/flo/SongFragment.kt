package com.example.flo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.flo.R.id.main_miniplayer_singer_tv
import com.example.flo.databinding.ActivityMainBinding
import com.example.flo.databinding.FragmentBannerBinding
import com.example.flo.databinding.FragmentDetailBinding
import com.example.flo.databinding.FragmentSongBinding

class SongFragment : Fragment() {
    lateinit var binding: FragmentSongBinding
    lateinit var mainbinding : ActivityMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(inflater, container, false)
        mainbinding = ActivityMainBinding.inflate(inflater, container, false)
        ActivityMainBinding.inflate(layoutInflater)

        val singerTV: TextView? = activity?.findViewById(R.id.main_miniplayer_singer_tv)
        val titleTV: TextView? = activity?.findViewById(R.id.main_miniplayer_title_tv)
        //밑 코드는 클릭시 미니플레이어에 반영되는 코드
        binding.songLalacLayout.setOnClickListener{
            if (singerTV != null) {
                singerTV.text=binding.songSingerName01Tv.text
            }
            if(titleTV!=null){
                titleTV.text=binding.songMusicTitle01Tv.text
            }
        }
        binding.songFluLayout.setOnClickListener{
            if (singerTV != null) {
                singerTV.text=binding.songSingerName02Tv.text
            }
            if(titleTV!=null){
                titleTV.text=binding.songMusicTitle02Tv.text
            }
        }
        binding.songCoinLayout.setOnClickListener{
            if (singerTV != null) {
                singerTV.text=binding.songSingerName03Tv.text
            }
            if(titleTV!=null){
                titleTV.text=binding.songMusicTitle03Tv.text
            }
        }

        binding.songMixoffTg.setOnClickListener {
            binding.songMixoffTg.visibility = View.GONE
            binding.songMixonTg.visibility = View.VISIBLE
        }
        binding.songMixonTg.setOnClickListener {
            binding.songMixoffTg.visibility = View.VISIBLE
            binding.songMixonTg.visibility = View.GONE
        }
        return binding.root

    }


}