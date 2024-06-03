package com.example.flo.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentBannerBinding
import com.example.flo.databinding.FragmentHomeBinding

class BannerFragment(val imgRes : Int) : Fragment() {
    lateinit var binding: FragmentBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBannerBinding.inflate(inflater, container, false)


        binding.bannerImageIv.setImageResource(imgRes)
        //이미지 리소스값을 int로 받아와 변경 하 이미지 변경 이렇게 하는구나;;;;
        return binding.root
    }
}