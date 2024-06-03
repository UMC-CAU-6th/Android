package com.example.flo;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\'\u00a8\u0006\u0011"}, d2 = {"Lcom/example/flo/SongDao;", "", "delete", "", "song", "Lcom/example/flo/Song;", "getLikedSongs", "", "isLike", "", "getSong", "id", "", "getSongs", "insert", "update", "updateIsLikeById", "app_debug"})
public abstract interface SongDao {
    
    @androidx.room.Insert
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.flo.Song song);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    com.example.flo.Song song);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.example.flo.Song song);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM SongTable")
    public abstract java.util.List<com.example.flo.Song> getSongs();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM SongTable WHERE id = :id")
    public abstract com.example.flo.Song getSong(int id);
    
    @androidx.room.Query(value = "UPDATE SongTable SET isLike= :isLike WHERE id =:id")
    public abstract void updateIsLikeById(boolean isLike, int id);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM SongTable WHERE isLike = :isLike")
    public abstract java.util.List<com.example.flo.Song> getLikedSongs(boolean isLike);
}