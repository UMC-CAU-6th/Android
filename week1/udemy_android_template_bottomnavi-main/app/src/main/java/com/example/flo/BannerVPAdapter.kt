package com.example.flo

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerVPAdapter(fragment:Fragment) : FragmentStateAdapter(fragment){
    private val fragmentList : ArrayList<Fragment> = ArrayList()
    // 배너 사진들을 담아둘 리스트 초기화, private로 선언한 이유는 이 Class에서만 쓸 거니까


    override fun getItemCount(): Int = fragmentList.size // 몇 개를 반환할거냐
    // 아래 함수와 같은 함수
//    override fun getItemCount(): Int {
//        return fragmentList.size
//    }

    override fun createFragment(position: Int): Fragment = fragmentList[position] // 0부터 끝까지

    fun addFragment(fragment: Fragment){ // 함수가 처음 실행될 때 list에는 아무것도 없어서 homefragement에서 추가해줄 fragment를 쓰기 위해
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size-1) // list 안에 새로운 값이 추가 됐을 때 ViewPager에게 알려줌
        // 처음에 인덱스는 0, size는 1이니까 -1 붙인다고 한다
    }
}