package com.example.flo.database

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlbumDao {

    @Insert
    fun insert(album: Album)

    @Query("SELECT * FROM AlbumTable")//AlbumTable을 만들어주지 않았기 때문에 에러
    fun getAlbums():List<Album>//LikeTable과

    @Insert
    fun likeAlbum(like: Like)

    @Query("SELECT * FROM LIKETABLE")
    fun getLikeTable(): List<Like>?



    @Query("SELECT id FROM LikeTable WHERE userId = :userId AND albumId = :albumId")
    fun isLikedAlbum(userId:Int, albumId:Int) : Int?
    //album과 user를 찾아서, liketable의 id를 반환해라 정보가 없다면 null을 반환

    @Query("DELETE FROM LikeTable WHERE userId = :userId AND albumId = :albumId")
    fun disLikedAlbum(userId:Int, albumId:Int)//좋아요 취소하는 함수

    @Query("SELECT AT.* FROM LikeTable as LT LEFT JOIN AlbumTable as AT ON LT.albumId = AT.id WHERE LT.userId = :userId")
    fun getLikedAlbums(userId : Int): List<Album>?
    //여기서 LikeTable as LT는 LikeTable을 LT라고 부르겠다는 뜻, ALbumTable도 똑같다.
    //LEFT JOIN : 왼쪽에 있는 LikeTable을 기준으로 붙이겠다.

}