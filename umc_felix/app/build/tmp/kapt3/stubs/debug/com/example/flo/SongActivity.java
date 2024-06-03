package com.example.flo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001=B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020\'H\u0002J\b\u0010)\u001a\u00020\'H\u0002J\u0010\u0010*\u001a\u00020\'2\u0006\u0010+\u001a\u00020\u000eH\u0002J\u0012\u0010,\u001a\u00020\'2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\'H\u0014J\b\u00100\u001a\u00020\'H\u0014J\b\u00101\u001a\u00020\'H\u0002J\u000e\u00102\u001a\u00020\'2\u0006\u00103\u001a\u000204J\u0010\u00105\u001a\u00020\'2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\'2\u0006\u00109\u001a\u00020\u001bH\u0002J\u0010\u0010:\u001a\u00020\'2\u0006\u0010;\u001a\u000207H\u0002J\b\u0010<\u001a\u00020\'H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00060\u001fR\u00020\u0000X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006>"}, d2 = {"Lcom/example/flo/SongActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/flo/databinding/ActivitySongBinding;", "getBinding", "()Lcom/example/flo/databinding/ActivitySongBinding;", "setBinding", "(Lcom/example/flo/databinding/ActivitySongBinding;)V", "gson", "Lcom/google/gson/Gson;", "mediaplayer", "Landroid/media/MediaPlayer;", "nowPos", "", "getNowPos", "()I", "setNowPos", "(I)V", "songDB", "Lcom/example/flo/SongDatabase;", "getSongDB", "()Lcom/example/flo/SongDatabase;", "setSongDB", "(Lcom/example/flo/SongDatabase;)V", "songs", "Ljava/util/ArrayList;", "Lcom/example/flo/Song;", "getSongs", "()Ljava/util/ArrayList;", "timer", "Lcom/example/flo/SongActivity$Timer;", "getTimer", "()Lcom/example/flo/SongActivity$Timer;", "setTimer", "(Lcom/example/flo/SongActivity$Timer;)V", "getPlayingSongPosition", "songId", "initClickListener", "", "initPlayList", "initSong", "moveSong", "direct", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "resetPlayer", "setButtonColor", "btn", "Landroid/widget/ImageView;", "setLike", "isLike", "", "setPlayer", "song", "setPlayerStatus", "isPlaying", "startTimer", "Timer", "app_debug"})
public final class SongActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.flo.databinding.ActivitySongBinding binding;
    public com.example.flo.SongActivity.Timer timer;
    private android.media.MediaPlayer mediaplayer;
    private com.google.gson.Gson gson;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.example.flo.Song> songs = null;
    public com.example.flo.SongDatabase songDB;
    private int nowPos = 0;
    
    public SongActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo.databinding.ActivitySongBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.flo.databinding.ActivitySongBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo.SongActivity.Timer getTimer() {
        return null;
    }
    
    public final void setTimer(@org.jetbrains.annotations.NotNull
    com.example.flo.SongActivity.Timer p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.example.flo.Song> getSongs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo.SongDatabase getSongDB() {
        return null;
    }
    
    public final void setSongDB(@org.jetbrains.annotations.NotNull
    com.example.flo.SongDatabase p0) {
    }
    
    public final int getNowPos() {
        return 0;
    }
    
    public final void setNowPos(int p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setPlayer(com.example.flo.Song song) {
    }
    
    private final void setPlayerStatus(boolean isPlaying) {
    }
    
    private final void initPlayList() {
    }
    
    private final void moveSong(int direct) {
    }
    
    private final void initClickListener() {
    }
    
    private final void initSong() {
    }
    
    private final void setLike(boolean isLike) {
    }
    
    private final int getPlayingSongPosition(int songId) {
        return 0;
    }
    
    private final void resetPlayer() {
    }
    
    private final void startTimer() {
    }
    
    public final void setButtonColor(@org.jetbrains.annotations.NotNull
    android.widget.ImageView btn) {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/example/flo/SongActivity$Timer;", "Ljava/lang/Thread;", "playTime", "", "second", "isPlaying", "", "(Lcom/example/flo/SongActivity;IIZ)V", "()Z", "setPlaying", "(Z)V", "mills", "", "getSecond", "()I", "setSecond", "(I)V", "run", "", "app_debug"})
    public final class Timer extends java.lang.Thread {
        private final int playTime = 0;
        private int second;
        private boolean isPlaying;
        private float mills;
        
        public Timer(int playTime, int second, boolean isPlaying) {
            super();
        }
        
        public final int getSecond() {
            return 0;
        }
        
        public final void setSecond(int p0) {
        }
        
        public final boolean isPlaying() {
            return false;
        }
        
        public final void setPlaying(boolean p0) {
        }
        
        @java.lang.Override
        public void run() {
        }
    }
}