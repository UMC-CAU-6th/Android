package com.example.flo.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.ActivitySongBinding
import com.example.flo.databinding.FragmentPannelBackgroundBinding

class PannelBackgroundFragment(val imgRes : Int) :Fragment() {

    lateinit var binding: FragmentPannelBackgroundBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPannelBackgroundBinding.inflate(inflater, container, false)

        binding.pannelBackgroundImageIv.setImageResource(imgRes)
        return binding.root
    }
}