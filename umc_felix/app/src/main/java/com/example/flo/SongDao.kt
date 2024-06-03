package com.example.flo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface SongDao{
    @Insert
    fun insert(song:Song)

    @Update
    fun update(song:Song)

    @Delete
    fun delete(song:Song)

    @Query("SELECT * FROM SongTable")
    fun getSongs(): List<Song>

    @Query("SELECT * FROM SongTable WHERE id = :id")
    fun getSong(id: Int): Song//where을 for문으로 해서, 받아온 매개변수 id값의 Song을 받아옴

    @Query("UPDATE SongTable SET isLike= :isLike WHERE id =:id")
    fun updateIsLikeById(isLike: Boolean, id:Int)

    @Query("SELECT * FROM SongTable WHERE isLike = :isLike")
    fun getLikedSongs(isLike : Boolean): List<Song>
}