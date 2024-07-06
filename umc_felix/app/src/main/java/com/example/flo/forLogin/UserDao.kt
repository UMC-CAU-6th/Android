package com.example.flo.forLogin

import androidx.room.*
import com.example.flo.forLogin.User


@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM UserTable")//모든 유저테이블의 정보를 가져오는 함수
    //List형태를 가져온다.
    fun getUsers(): List<User>?

    @Query("SELECT * FROM UserTable WHERE email = :email AND password = :password")
    fun getUser(email:String, password:String) : User?//이메일과 비밀번호가 같으면 불러온다.

}