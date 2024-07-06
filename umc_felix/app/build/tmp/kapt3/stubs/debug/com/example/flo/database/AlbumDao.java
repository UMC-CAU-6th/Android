package com.example.flo.database;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\'J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH\'J\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bH\'\u00a8\u0006\u0013"}, d2 = {"Lcom/example/flo/database/AlbumDao;", "", "disLikedAlbum", "", "userId", "", "albumId", "getAlbums", "", "Lcom/example/flo/database/Album;", "getLikeTable", "Lcom/example/flo/database/Like;", "getLikedAlbums", "insert", "album", "isLikedAlbum", "(II)Ljava/lang/Integer;", "likeAlbum", "like", "app_debug"})
public abstract interface AlbumDao {
    
    @androidx.room.Insert
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.flo.database.Album album);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM AlbumTable")
    public abstract java.util.List<com.example.flo.database.Album> getAlbums();
    
    @androidx.room.Insert
    public abstract void likeAlbum(@org.jetbrains.annotations.NotNull
    com.example.flo.database.Like like);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM LIKETABLE")
    public abstract java.util.List<com.example.flo.database.Like> getLikeTable();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT id FROM LikeTable WHERE userId = :userId AND albumId = :albumId")
    public abstract java.lang.Integer isLikedAlbum(int userId, int albumId);
    
    @androidx.room.Query(value = "DELETE FROM LikeTable WHERE userId = :userId AND albumId = :albumId")
    public abstract void disLikedAlbum(int userId, int albumId);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT AT.* FROM LikeTable as LT LEFT JOIN AlbumTable as AT ON LT.albumId = AT.id WHERE LT.userId = :userId")
    public abstract java.util.List<com.example.flo.database.Album> getLikedAlbums(int userId);
}