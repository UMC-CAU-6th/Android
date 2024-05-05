package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.flo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeAlbumImgIv1.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm,AlbumFragment())
            .commitAllowingStateLoss() // 기존 Fragment를 대체한다
        }

        val bannerAdapter = BannerVPAdapter(this) // 3주차 과제. ViewPager2를 위한 설정
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp)) // 배너에 이미지 추가1
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2)) // 배너에 이미지 추가2
        binding.homeBannerVp.adapter = bannerAdapter // ViewPager와 adapter 연결
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL // Viewpager가 좌우로 스크롤 되게 설정


        return binding.root
    }
}