package com.example.flo.forLogin

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "UserTable")//이 문법을 써줘야 데이터베이스 내의 테이블임을 알음
data class User(
    var email: String,
    var password: String
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
