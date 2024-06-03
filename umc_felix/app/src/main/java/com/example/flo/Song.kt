package com.example.flo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "SongTable")
data class Song(
    var title : String = "",
    var singer : String = "",
    var second : Int =0,
    var playTime : Int = 0,
    var isPlaying : Boolean = false,
    var music : String = "",//5주차 음악이름
    var coverImg: Int? = null,
    var isLike: Boolean = false//7주차 DB에 필요한 정보 추가
    //처음에 이거 mainActivity에서 초기화한다.
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
