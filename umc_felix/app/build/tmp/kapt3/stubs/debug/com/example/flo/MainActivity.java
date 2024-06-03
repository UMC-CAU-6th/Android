package com.example.flo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0014J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/flo/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/flo/databinding/ActivityMainBinding;", "getBinding", "()Lcom/example/flo/databinding/ActivityMainBinding;", "setBinding", "(Lcom/example/flo/databinding/ActivityMainBinding;)V", "gson", "Lcom/google/gson/Gson;", "mediaPlayer", "Landroid/media/MediaPlayer;", "song", "Lcom/example/flo/Song;", "initBottomNavigation", "", "inputDummySongs", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setMiniPlayer", "ThreadExample", "ThreadExample2", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.flo.databinding.ActivityMainBinding binding;
    private android.media.MediaPlayer mediaPlayer;
    private com.example.flo.Song song;
    private com.google.gson.Gson gson;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.flo.databinding.ActivityMainBinding p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    private final void initBottomNavigation() {
    }
    
    private final void setMiniPlayer(com.example.flo.Song song) {
    }
    
    private final void inputDummySongs() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/example/flo/MainActivity$ThreadExample;", "Ljava/lang/Thread;", "()V", "run", "", "app_debug"})
    public static final class ThreadExample extends java.lang.Thread {
        
        public ThreadExample() {
            super();
        }
        
        @java.lang.Override
        public void run() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/example/flo/MainActivity$ThreadExample2;", "Ljava/lang/Thread;", "()V", "run", "", "app_debug"})
    public static final class ThreadExample2 extends java.lang.Thread {
        
        public ThreadExample2() {
            super();
        }
        
        @java.lang.Override
        public void run() {
        }
    }
}