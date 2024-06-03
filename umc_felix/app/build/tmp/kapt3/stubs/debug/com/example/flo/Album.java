package com.example.flo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u001d\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u00c6\u0003JP\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u00c6\u0001\u00a2\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0006H\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014\u00a8\u0006&"}, d2 = {"Lcom/example/flo/Album;", "", "title", "", "singer", "coverImg", "", "songs", "Ljava/util/ArrayList;", "Lcom/example/flo/Song;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getCoverImg", "()Ljava/lang/Integer;", "setCoverImg", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSinger", "()Ljava/lang/String;", "setSinger", "(Ljava/lang/String;)V", "getSongs", "()Ljava/util/ArrayList;", "setSongs", "(Ljava/util/ArrayList;)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/example/flo/Album;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Album {
    @org.jetbrains.annotations.Nullable
    private java.lang.String title;
    @org.jetbrains.annotations.Nullable
    private java.lang.String singer;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer coverImg;
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.example.flo.Song> songs;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo.Album copy(@org.jetbrains.annotations.Nullable
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String singer, @org.jetbrains.annotations.Nullable
    java.lang.Integer coverImg, @org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.example.flo.Song> songs) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Album() {
        super();
    }
    
    public Album(@org.jetbrains.annotations.Nullable
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.String singer, @org.jetbrains.annotations.Nullable
    java.lang.Integer coverImg, @org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.example.flo.Song> songs) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSinger() {
        return null;
    }
    
    public final void setSinger(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getCoverImg() {
        return null;
    }
    
    public final void setCoverImg(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.example.flo.Song> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.example.flo.Song> getSongs() {
        return null;
    }
    
    public final void setSongs(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.example.flo.Song> p0) {
    }
}