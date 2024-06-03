package com.example.flo.homefragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PannelBGVPAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    private val fragmentlist : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int = fragmentlist.size

    override fun createFragment(p0: Int): Fragment = fragmentlist[p0]

    fun addFragment(fragment : Fragment){
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1)
    }
}