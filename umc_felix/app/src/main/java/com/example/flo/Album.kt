package com.example.flo

data class Album(
    var title : String? = "",
    var singer: String? = "",
    var coverImg: Int? =null,
    var songs: ArrayList<Song>? = null//앨범의 수록곡, 강의에선 안넣음

)
