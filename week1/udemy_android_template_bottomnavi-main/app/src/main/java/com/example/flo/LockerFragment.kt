package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentLockerBinding
import com.google.android.material.tabs.TabLayoutMediator

class LockerFragment : Fragment() {

    class LockerFragment : Fragment() {
        lateinit var binding: FragmentLockerBinding
        private val information = arrayListOf("저장한곡", "음악파일", "저장앨범")

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentLockerBinding.inflate(inflater, container, false)

            val lockerAdapter = LockerVPAdapter(this)
            binding.lockerContentVp.adapter = lockerAdapter
            TabLayoutMediator(binding.lockerContentTb, binding.lockerContentVp) { tab, position ->
                tab.text = information[position]
            }.attach()

            return binding.root
        }

    }
}