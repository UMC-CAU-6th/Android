package com.example.flo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Song::class],version = 1)
abstract class SongDatabase: RoomDatabase() {
    abstract fun songDao(): SongDao

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