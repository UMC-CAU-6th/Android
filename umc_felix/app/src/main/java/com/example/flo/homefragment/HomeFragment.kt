package com.example.flo.homefragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.flo.Album
import com.example.flo.AlbumFragment
import com.example.flo.MainActivity
import com.example.flo.R
import com.example.flo.databinding.FragmentHomeBinding
import com.google.gson.Gson
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

class HomeFragment : Fragment() {
    //
    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())
    //자동 슬라이드 기능용 변수
    lateinit var binding: FragmentHomeBinding

    private var albumDatas = ArrayList<Album>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val singerTV: TextView? = activity?.findViewById(R.id.main_miniplayer_singer_tv)
        val titleTV: TextView? = activity?.findViewById(R.id.main_miniplayer_title_tv)
        //////////////////////////////////////////////////////6주차 데이터 어댑터 설정
        albumDatas.apply{
            add(Album("Lilac", "아이유",R.drawable.lilac))
            add(Album("앨범1", "가수1",R.drawable.img_album_exp))
            add(Album("앨범2", "가수2",R.drawable.img_album_exp3))
            add(Album("앨범3", "가수3",R.drawable.img_album_exp4))

        }
        //원래는 데이터 서버에서 받아와야함
        val albumRVAdapter = AlbumRVAdapter(albumDatas)
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        //인터페이스 구현, fragment전환
        albumRVAdapter.setMyItemClickListener(object : AlbumRVAdapter.MyItemClickListener{
            override fun onItemClick(album: Album) {
                changeAlbum(album)
            }
            override fun onRemoveAlbum(pos: Int) {
                albumRVAdapter.delete(pos)
            }

            override fun onPlayClick(album: Album) {    //미니 플레이어에 반영   //다음에는 노래도 넣어야지 뭐..
                singerTV?.text = album.singer
                titleTV?.text = album.title
            }

        })
        //////////////////////////////////////////////////////

        //list안에 fragment를 추가해주기
        val bannerAdapter = BannerVPAdapter(this)//새로 클래스 만든거임
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))//아씨 이렇게하면 id가 int로 가는구나
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        //bannerFragment가 하나의 객체로 들어가고 있음.
        binding.homeBannerVp.adapter = bannerAdapter
        //viewpager가 adapter(사진에 대학 정보 갖고있음)에 연결됨
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        //viewpager가 좌우로 스크롤 할수있게 도와줌


        //////////////////////////////////////////////////////////////////////////////


        //배경 backgroundViewpager도 추가
        val pannelBGAdapter = PannelBGVPAdapter(this)
        pannelBGAdapter.addFragment(PannelBackgroundFragment(R.drawable.img_first_album_default))
        pannelBGAdapter.addFragment(PannelBackgroundFragment(R.drawable.img_second_album))
        pannelBGAdapter.addFragment(PannelBackgroundFragment(R.drawable.img_third_album))
        pannelBGAdapter.addFragment(PannelBackgroundFragment(R.drawable.img_fourth_album))
        pannelBGAdapter.addFragment(PannelBackgroundFragment(R.drawable.img_fifth_album))
        binding.homePannelBackgroundVp.adapter = pannelBGAdapter
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.homePannelIndicator.setViewPager(binding.homePannelBackgroundVp)
        //circleIndicator랑 viewpager랑 연결

        startAutoSlide(pannelBGAdapter)
        ////////////////////////////////////////////////////////////////////
        fun touchAlbum(album: String){//앨범 클릭 함수
            val fragment2 = AlbumFragment()
            val bundle = Bundle()
            bundle.putString("album", album)

            fragment2.arguments = bundle

            (context as MainActivity).supportFragmentManager.beginTransaction().
            replace(R.id.main_frm,fragment2).commit()
            //R.id.main_frm은 activity_main 안에 있는 프레임 레이아웃임
            //이때 replace는 framelayout 안에 있는 fragment를 변경해준다는 뜻
        }
        //6주차 이후로 주석, 앨범이 recyclerView로 대체됨
        /*binding.tdMsFirstLl.setOnClickListener{
            touchAlbum("1")
        }
        binding.tdMsSecondLl.setOnClickListener{
            touchAlbum("2")
        }
        binding.tdMsThirdLl.setOnClickListener{
            touchAlbum("3")
        }*/
///////////////////////////////////////////////////////////

        return binding.root
    }
    private fun changeAlbum(album: Album) {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AlbumFragment().apply {
                arguments = Bundle().apply {
                    val gson = Gson()
                    val albumJson = gson.toJson(album)
                    putString("album", albumJson)
                }
            }
            ).commitAllowingStateLoss()
    }
    private fun startAutoSlide(adapter : PannelBGVPAdapter){
        timer.scheduleAtFixedRate(3000,3000){
            handler.post{//이게 스레드
                val nextItem = binding.homePannelBackgroundVp.currentItem +1
                if(nextItem < adapter.itemCount){
                    binding.homePannelBackgroundVp.currentItem = nextItem
                }else{
                    binding.homePannelBackgroundVp.currentItem = 0
                }
            }
        }
    }

}


