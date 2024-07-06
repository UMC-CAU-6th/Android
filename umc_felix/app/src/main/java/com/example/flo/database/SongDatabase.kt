package com.example.flo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flo.forLogin.User
import com.example.flo.forLogin.UserDao

@Database(entities = [Song::class, User::class, Like::class, Album::class],version = 1)
abstract class SongDatabase: RoomDatabase() {
    abstract fun songDao(): SongDao
    abstract fun userDao(): UserDao
    abstract fun albumDao(): AlbumDao

    companion object{
        private var instance : SongDatabase? = null

        @Synchronized
        fun getInstance(context: Context): SongDatabase? {
            if (instance == null){
                synchronized(SongDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SongDatabase::class.java,
                        "song-databse"//다른 데이터 베이스랑 이름겹치면 안된다
                    ).allowMainThreadQueries().build()//메인 스레드의 작업을 넘기는것
                }//효율적인 작업을 위해서는 메인 스레드 외의 곳에서 해주는게 맞음.
            }
            return instance
        }



    }
}