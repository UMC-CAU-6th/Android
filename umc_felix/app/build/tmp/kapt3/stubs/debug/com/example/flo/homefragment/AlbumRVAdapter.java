package com.example.flo.homefragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\tR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/flo/homefragment/AlbumRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/flo/homefragment/AlbumRVAdapter$ViewHolder;", "albumList", "Ljava/util/ArrayList;", "Lcom/example/flo/Album;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "mItemClickListener", "Lcom/example/flo/homefragment/AlbumRVAdapter$MyItemClickListener;", "add", "", "album", "delete", "pos", "", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "setMyItemClickListener", "itemClickListener", "MyItemClickListener", "ViewHolder", "app_debug"})
public final class AlbumRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.flo.homefragment.AlbumRVAdapter.ViewHolder> {
    private final java.util.ArrayList<com.example.flo.Album> albumList = null;
    private com.example.flo.homefragment.AlbumRVAdapter.MyItemClickListener mItemClickListener;
    
    public AlbumRVAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.example.flo.Album> albumList) {
        super();
    }
    
    public final void setMyItemClickListener(@org.jetbrains.annotations.NotNull
    com.example.flo.homefragment.AlbumRVAdapter.MyItemClickListener itemClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.flo.homefragment.AlbumRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup viewGroup, int p1) {
        return null;
    }
    
    public final void add(@org.jetbrains.annotations.NotNull
    com.example.flo.Album album) {
    }
    
    public final void delete(int pos) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.flo.homefragment.AlbumRVAdapter.ViewHolder holder, int pos) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/example/flo/homefragment/AlbumRVAdapter$MyItemClickListener;", "", "onItemClick", "", "album", "Lcom/example/flo/Album;", "onPlayClick", "onRemoveAlbum", "pos", "", "app_debug"})
    public static abstract interface MyItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull
        com.example.flo.Album album);
        
        public abstract void onRemoveAlbum(int pos);
        
        public abstract void onPlayClick(@org.jetbrains.annotations.NotNull
        com.example.flo.Album album);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/flo/homefragment/AlbumRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/flo/databinding/ItemAlbumBinding;", "(Lcom/example/flo/homefragment/AlbumRVAdapter;Lcom/example/flo/databinding/ItemAlbumBinding;)V", "getBinding", "()Lcom/example/flo/databinding/ItemAlbumBinding;", "bind", "", "album", "Lcom/example/flo/Album;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.flo.databinding.ItemAlbumBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.example.flo.databinding.ItemAlbumBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.flo.databinding.ItemAlbumBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.flo.Album album) {
        }
    }
}