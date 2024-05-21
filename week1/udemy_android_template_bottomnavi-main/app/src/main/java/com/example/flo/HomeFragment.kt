package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.flo.databinding.FragmentHomeBinding
import com.google.gson.Gson

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    private var albumDatas = ArrayList<Album>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

//        binding.homeAlbumImgIv1.setOnClickListener{
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm,AlbumFragment())
//                .commitAllowingStateLoss() // 기존 Fragment를 대체한다
//        }

        // 데이터 리스트 생성 더미 데이터
        albumDatas.apply {
            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(Album("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
            add(Album("Next Level", "에스파 (AESPA)", R.drawable.img_album_exp3))
            add(Album("Boy with Luv", "방탄소년단 (BTS)", R.drawable.img_album_exp4))
            add(Album("BBoom BBoom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5))
            add(Album("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
        }

        // 더미데이터랑 Adapter 연결
        val albumRVAdapter = AlbumRVAdapter(albumDatas)
        // 리사이클러뷰에 Adapter 연결
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        albumRVAdapter.setMyItemClickListener(object : AlbumRVAdapter.MyItemClickListener{
            override fun onItemClick(album: Album) {
                changeAlbumFragment(album) // 기존 Fragment를 대체한다
            }

            override fun onRemoveAlbum(position: Int) {
                albumRVAdapter.removeItem(position)
            }


        })

        val bannerAdapter = BannerVPAdapter(this) // 3주차 과제. ViewPager2를 위한 설정
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp)) // 배너에 이미지 추가1
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2)) // 배너에 이미지 추가2
        binding.homeBannerVp.adapter = bannerAdapter // ViewPager와 adapter 연결
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL // Viewpager가 좌우로 스크롤 되게 설정


        return binding.root
    }

    private fun changeAlbumFragment(album: Album) {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AlbumFragment()).apply {
                arguments = Bundle().apply { // 앨범 사진 클릭시 data 같이 보내기 위함
                    val gson = Gson()
                    val albumJson = gson.toJson(album)
                    putString("album", albumJson)
                }
            }
            .commitAllowingStateLoss()
    }
}