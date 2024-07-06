package com.example.flo.database;

import java.lang.System;

@androidx.room.Database(entities = {com.example.flo.database.Song.class, com.example.flo.forLogin.User.class, com.example.flo.database.Like.class, com.example.flo.database.Album.class}, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/flo/database/SongDatabase;", "Landroidx/room/RoomDatabase;", "()V", "albumDao", "Lcom/example/flo/database/AlbumDao;", "songDao", "Lcom/example/flo/database/SongDao;", "userDao", "Lcom/example/flo/forLogin/UserDao;", "Companion", "app_debug"})
public abstract class SongDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull
    public static final com.example.flo.database.SongDatabase.Companion Companion = null;
    private static com.example.flo.database.SongDatabase instance;
    
    public SongDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.flo.database.SongDao songDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.flo.forLogin.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.flo.database.AlbumDao albumDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/flo/database/SongDatabase$Companion;", "", "()V", "instance", "Lcom/example/flo/database/SongDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.Synchronized
        public final synchronized com.example.flo.database.SongDatabase getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}