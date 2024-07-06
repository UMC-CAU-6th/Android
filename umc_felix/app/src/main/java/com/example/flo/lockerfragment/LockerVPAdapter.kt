package com.example.flo.lockerfragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.flo.SavedAlbumFragment

class LockerVPAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(p0: Int): Fragment {
        return when(p0){
            0-> LockerSongFragment()
            1 -> LockerSongFileFragment()
            else -> SavedAlbumFragment()
        }

    }
}