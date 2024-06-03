package com.example.flo.homefragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.Album
import com.example.flo.databinding.ItemAlbumBinding

class AlbumRVAdapter(private val albumList: ArrayList<Album>): RecyclerView.Adapter<AlbumRVAdapter.ViewHolder>() {
    //처음만들때는 VIewHolder가 없어서 오류남

    interface MyItemClickListener{
        //외부에서 클릭리스너를 받아오고, 어댑터에서 리스너를 사용하기 위해 따로 저장해야함.
        fun onItemClick(album: Album)
        fun onRemoveAlbum(pos: Int)
        fun onPlayClick(album: Album)
    }

    private lateinit var mItemClickListener : MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }//홈프래그먼트에서 리스너 객체를 받아온다.

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): AlbumRVAdapter.ViewHolder {
        val binding: ItemAlbumBinding = ItemAlbumBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
        //뷰홀더 생성함수 : 아이템 뷰 객체를 뷰홀더에 넣고 리턴.
        //뷰홀더를 화면에 띄울만큼 생성하기 때문에 초반에 몇번만 호출됨
    }

    fun add(album: Album){
        albumList.add(album)
        notifyDataSetChanged()
    }
    fun delete(pos:Int){
        albumList.removeAt(pos)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AlbumRVAdapter.ViewHolder, pos: Int) {
        //데이터를 뷰홀더에 바인딩할때마다 호출 되는 함수,스크롤할때마다 호출됨
        //pos는 index역할, 얘만 인덱스를 갖고있기 때문에 클릭이벤트는 보통 여기서 처리
        holder.bind(albumList[pos])

        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick(albumList[pos]) }
        holder.binding.itemAlbumTitleTv.setOnClickListener { mItemClickListener.onRemoveAlbum(pos) }
        holder.binding.itemAlbumPlayImgIv.setOnClickListener { mItemClickListener.onItemClick(albumList[pos]) }
        //인터페이스 실행
    }

    //데이터 세트 크기를 알려주는 함수, Recycler가 마지막이 언제인지를 알려줌
    override fun getItemCount(): Int = albumList.size

    inner class ViewHolder(val binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(album:Album){
            binding.itemAlbumTitleTv.text = album.title
            binding.itemAlbumSingerTv.text = album.singer
            binding.itemAlbumCoverImgIv.setImageResource(album.coverImg!!)
        }
    }
}