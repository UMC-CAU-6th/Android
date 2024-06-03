package com.example.flo.lockerfragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.Song
import com.example.flo.databinding.ItemLockerAlbumBinding

class LockerAlbumRVAdapter():RecyclerView.Adapter<LockerAlbumRVAdapter.ViewHolder>() {
    private val lockerAlbumList = ArrayList<Song>()
    interface MyItemClickListener{
        fun onDeleteClick(pos: Int)
        fun onPlayClick(lockerAlbum: Song)
    }

    private lateinit var mItemClickListener : MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val binding: ItemLockerAlbumBinding = ItemLockerAlbumBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun delete(pos :Int){

        lockerAlbumList.removeAt(pos)
        notifyDataSetChanged()
    }

    fun like(isLike: Boolean, pos: Int, ){
        val binding: ItemLockerAlbumBinding

    }
    @SuppressLint("NotifyDataSetChanged")
    fun addSongs(songs: ArrayList<Song>) {
        this.lockerAlbumList.clear()
        this.lockerAlbumList.addAll(songs)

        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bind(lockerAlbumList[pos])

        holder.binding.itemLockerAlbumLikeImgIv.setOnClickListener { mItemClickListener.onDeleteClick(pos) }
        //holder.binding.itemLockerAlbumLikeImgIv.setOnClickListener { holder.change(lockerAlbumList[pos]) }
        holder.binding.itemLockerAlbumPlayImgIv.setOnClickListener {
            mItemClickListener.onPlayClick(lockerAlbumList[pos])
        }
    }

    override fun getItemCount(): Int = lockerAlbumList.size

    inner class ViewHolder(val binding: ItemLockerAlbumBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(lockerAlbum: Song){
            binding.itemLockerAlbumTitleTv.text = lockerAlbum.title
            binding.itemLockerAlbumSingerTv.text = lockerAlbum.singer
            binding.itemLockerAlbumImgIv.setImageResource(lockerAlbum.coverImg!!)

        }
        /*fun change(lockerAlbum: LockerAlbum){
            if(lockerAlbum.isLike){
                binding.itemLockerAlbumLikeImgIv.setImageResource(R.drawable.ic_my_like_off)
                lockerAlbum.isLike = false
            }
            else{

                lockerAlbum.isLike = true
            }
        }*/
    }
}