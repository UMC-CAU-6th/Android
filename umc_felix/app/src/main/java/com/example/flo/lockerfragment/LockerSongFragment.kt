package com.example.flo.lockerfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flo.R
import com.example.flo.Song
import com.example.flo.SongDatabase
import com.example.flo.databinding.FragmentLockerSongBinding


@Suppress("UNREACHABLE_CODE")
class LockerSongFragment : Fragment() {
    lateinit var binding: FragmentLockerSongBinding

    lateinit var lockerAlbumRVAdapter: LockerAlbumRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLockerSongBinding.inflate(inflater, container, false)


        val songDB = SongDatabase.getInstance(requireContext())!!

        /*lockerAlbumData.apply {
            add(LockerAlbum("앨범1", "가수1",R.drawable.img_album_exp,false))
            add(LockerAlbum("앨범2", "가수2",R.drawable.img_album_exp2,false))
            add(LockerAlbum("앨범3", "가수3",R.drawable.img_album_exp3,false))
            add(LockerAlbum("앨범4", "가수4",R.drawable.img_album_exp4,false))
            add(LockerAlbum("앨범5", "가수5",R.drawable.img_album_exp5,false))
            add(LockerAlbum("앨범6", "가수6",R.drawable.img_album_exp6,false))
            add(LockerAlbum("앨범7", "가수7",R.drawable.img_album_exp7,false))
            add(LockerAlbum("앨범8", "가수8",R.drawable.img_album_exp8,false))
            add(LockerAlbum("앨범9", "가수9",R.drawable.img_album_exp9,false))
            add(LockerAlbum("앨범10", "가수10",R.drawable.img_album_exp10,false))
        }*/

        //val lockerAlbumRVAdapter = LockerAlbumRVAdapter(lockerAlbumData)




        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val singerTV: TextView? = activity?.findViewById(R.id.main_miniplayer_singer_tv)
        val titleTV: TextView? = activity?.findViewById(R.id.main_miniplayer_title_tv)
        val songDB = SongDatabase.getInstance(requireContext())!!
        binding.lockerAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        lockerAlbumRVAdapter = LockerAlbumRVAdapter()


        var songs = songDB.songDao().getLikedSongs(true) as ArrayList<Song>
        binding.lockerAlbumRv.adapter = lockerAlbumRVAdapter
        lockerAlbumRVAdapter.addSongs(songs)

        lockerAlbumRVAdapter.setMyItemClickListener(object :
            LockerAlbumRVAdapter.MyItemClickListener {
            override fun onDeleteClick(pos: Int) {
                lockerAlbumRVAdapter.delete(pos)
                songDB.songDao().updateIsLikeById(false, songs[pos].id)

            }
            override fun onPlayClick(lockerAlbum: Song) {
                singerTV?.text = lockerAlbum.singer
                titleTV?.text = lockerAlbum.title
            }
        })

    }
}