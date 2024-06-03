package com.example.flo.homefragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerVPAdapter (fragment : Fragment) :FragmentStateAdapter(fragment) {
    //adapter는 FragmentStateAdapter(fragment)클래스 상속 받아야함. 이때 fragment가 BVPAdapter에 들어가있는거 맞음 ㅇㅇ
    //이렇게 상속해줘도 빨간줄 뜨는데 alt enter로 확인해서 getItemCount()와 createFragment가 생성되게 해줘야 하나봐
    //외부에서 BannerVPAdapter.fragmentlist하면 참조가 되어버리니깐 private
    private val fragmentlist : ArrayList<Fragment> = ArrayList()//이러면 초기화



    override fun getItemCount(): Int = fragmentlist.size
    //데이터를 몇개를 전달할지 전달하는 함수, fragment list에 들어있다.
    override fun createFragment(position: Int): Fragment = fragmentlist[position]
        //Fragment를 생성해주는 함수
    //getItemCount의 값이 4라면 0, 1, 2, 3까지 실행이 됨

    fun addFragment(fragment: Fragment){
        fragmentlist.add(fragment)//fragmentlist에 하나를 추가해준다.
        notifyItemInserted(fragmentlist.size-1)
        //fragment에 새로 들어올때마다 viewpager에 새로 fragmentlist[szie-1]이위치에 들어왔다고 인식시켜줌

    }
    //    override fun getItemCount(): Int {
//        return fragmentlist.size
//    }//밑처럼 짧게 쓸수있다.

}