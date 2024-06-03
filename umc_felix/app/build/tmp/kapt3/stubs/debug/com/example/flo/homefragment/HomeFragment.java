package com.example.flo.homefragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/flo/homefragment/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "albumDatas", "Ljava/util/ArrayList;", "Lcom/example/flo/Album;", "binding", "Lcom/example/flo/databinding/FragmentHomeBinding;", "getBinding", "()Lcom/example/flo/databinding/FragmentHomeBinding;", "setBinding", "(Lcom/example/flo/databinding/FragmentHomeBinding;)V", "handler", "Landroid/os/Handler;", "timer", "Ljava/util/Timer;", "changeAlbum", "", "album", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "startAutoSlide", "adapter", "Lcom/example/flo/homefragment/PannelBGVPAdapter;", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    private final java.util.Timer timer = null;
    private final android.os.Handler handler = null;
    public com.example.flo.databinding.FragmentHomeBinding binding;
    private java.util.ArrayList<com.example.flo.Album> albumDatas;
    
    public HomeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.flo.databinding.FragmentHomeBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void changeAlbum(com.example.flo.Album album) {
    }
    
    private final void startAutoSlide(com.example.flo.homefragment.PannelBGVPAdapter adapter) {
    }
}