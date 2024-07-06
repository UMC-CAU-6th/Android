package com.example.flo.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.flo.database.Song

@Entity(tableName = "AlbumTable")
data class Album(
    @PrimaryKey(autoGenerate = false) var id: Int = 0,
    var title : String? = "",
    var singer: String? = "",
    var coverImg: Int? =null

)
