package com.example.flo.lockerfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentLockerSongBinding
import com.example.flo.databinding.FragmentLockerSongFileBinding

class LockerSongFileFragment : Fragment() {
    lateinit var binding: FragmentLockerSongFileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLockerSongFileBinding.inflate(inflater, container, false)
        return binding.root
    }
}