// Generated by view binder compiler. Do not edit!
package com.example.flo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.flo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySongBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView songAlbumIv;

  @NonNull
  public final ImageButton songDownIb;

  @NonNull
  public final TextView songEndTimeTv;

  @NonNull
  public final ImageButton songEqIb;

  @NonNull
  public final ImageView songInstagramIv;

  @NonNull
  public final ImageView songLikeIv;

  @NonNull
  public final LinearLayout songLikeIvLayout;

  @NonNull
  public final ImageView songListIv;

  @NonNull
  public final ImageView songMiniplayerIv;

  @NonNull
  public final ImageButton songMoreIb;

  @NonNull
  public final TextView songMusicLyrics01Iv;

  @NonNull
  public final TextView songMusicLyrics02Iv;

  @NonNull
  public final TextView songMusicTitleTv;

  @NonNull
  public final ImageView songNextIv;

  @NonNull
  public final ImageView songPauseIv;

  @NonNull
  public final LinearLayout songPlayerLayout;

  @NonNull
  public final ImageView songPreviousIv;

  @NonNull
  public final SeekBar songProgressSb;

  @NonNull
  public final ImageView songRandomIv;

  @NonNull
  public final ImageView songRelatedIv;

  @NonNull
  public final ImageView songRepeatIv;

  @NonNull
  public final ImageButton songSettingIb;

  @NonNull
  public final ImageView songSingerMoreIv;

  @NonNull
  public final TextView songSingerNameTv;

  @NonNull
  public final TextView songStartTimeTv;

  @NonNull
  public final ImageView songUnlikeIv;

  private ActivitySongBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView songAlbumIv,
      @NonNull ImageButton songDownIb, @NonNull TextView songEndTimeTv,
      @NonNull ImageButton songEqIb, @NonNull ImageView songInstagramIv,
      @NonNull ImageView songLikeIv, @NonNull LinearLayout songLikeIvLayout,
      @NonNull ImageView songListIv, @NonNull ImageView songMiniplayerIv,
      @NonNull ImageButton songMoreIb, @NonNull TextView songMusicLyrics01Iv,
      @NonNull TextView songMusicLyrics02Iv, @NonNull TextView songMusicTitleTv,
      @NonNull ImageView songNextIv, @NonNull ImageView songPauseIv,
      @NonNull LinearLayout songPlayerLayout, @NonNull ImageView songPreviousIv,
      @NonNull SeekBar songProgressSb, @NonNull ImageView songRandomIv,
      @NonNull ImageView songRelatedIv, @NonNull ImageView songRepeatIv,
      @NonNull ImageButton songSettingIb, @NonNull ImageView songSingerMoreIv,
      @NonNull TextView songSingerNameTv, @NonNull TextView songStartTimeTv,
      @NonNull ImageView songUnlikeIv) {
    this.rootView = rootView;
    this.songAlbumIv = songAlbumIv;
    this.songDownIb = songDownIb;
    this.songEndTimeTv = songEndTimeTv;
    this.songEqIb = songEqIb;
    this.songInstagramIv = songInstagramIv;
    this.songLikeIv = songLikeIv;
    this.songLikeIvLayout = songLikeIvLayout;
    this.songListIv = songListIv;
    this.songMiniplayerIv = songMiniplayerIv;
    this.songMoreIb = songMoreIb;
    this.songMusicLyrics01Iv = songMusicLyrics01Iv;
    this.songMusicLyrics02Iv = songMusicLyrics02Iv;
    this.songMusicTitleTv = songMusicTitleTv;
    this.songNextIv = songNextIv;
    this.songPauseIv = songPauseIv;
    this.songPlayerLayout = songPlayerLayout;
    this.songPreviousIv = songPreviousIv;
    this.songProgressSb = songProgressSb;
    this.songRandomIv = songRandomIv;
    this.songRelatedIv = songRelatedIv;
    this.songRepeatIv = songRepeatIv;
    this.songSettingIb = songSettingIb;
    this.songSingerMoreIv = songSingerMoreIv;
    this.songSingerNameTv = songSingerNameTv;
    this.songStartTimeTv = songStartTimeTv;
    this.songUnlikeIv = songUnlikeIv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySongBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySongBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_song, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySongBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.song_album_iv;
      ImageView songAlbumIv = ViewBindings.findChildViewById(rootView, id);
      if (songAlbumIv == null) {
        break missingId;
      }

      id = R.id.song_down_ib;
      ImageButton songDownIb = ViewBindings.findChildViewById(rootView, id);
      if (songDownIb == null) {
        break missingId;
      }

      id = R.id.song_end_time_tv;
      TextView songEndTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (songEndTimeTv == null) {
        break missingId;
      }

      id = R.id.song_eq_ib;
      ImageButton songEqIb = ViewBindings.findChildViewById(rootView, id);
      if (songEqIb == null) {
        break missingId;
      }

      id = R.id.song_instagram_iv;
      ImageView songInstagramIv = ViewBindings.findChildViewById(rootView, id);
      if (songInstagramIv == null) {
        break missingId;
      }

      id = R.id.song_like_iv;
      ImageView songLikeIv = ViewBindings.findChildViewById(rootView, id);
      if (songLikeIv == null) {
        break missingId;
      }

      id = R.id.song_like_iv_layout;
      LinearLayout songLikeIvLayout = ViewBindings.findChildViewById(rootView, id);
      if (songLikeIvLayout == null) {
        break missingId;
      }

      id = R.id.song_list_iv;
      ImageView songListIv = ViewBindings.findChildViewById(rootView, id);
      if (songListIv == null) {
        break missingId;
      }

      id = R.id.song_miniplayer_iv;
      ImageView songMiniplayerIv = ViewBindings.findChildViewById(rootView, id);
      if (songMiniplayerIv == null) {
        break missingId;
      }

      id = R.id.song_more_ib;
      ImageButton songMoreIb = ViewBindings.findChildViewById(rootView, id);
      if (songMoreIb == null) {
        break missingId;
      }

      id = R.id.song_music_lyrics_01_iv;
      TextView songMusicLyrics01Iv = ViewBindings.findChildViewById(rootView, id);
      if (songMusicLyrics01Iv == null) {
        break missingId;
      }

      id = R.id.song_music_lyrics_02_iv;
      TextView songMusicLyrics02Iv = ViewBindings.findChildViewById(rootView, id);
      if (songMusicLyrics02Iv == null) {
        break missingId;
      }

      id = R.id.song_music_title_tv;
      TextView songMusicTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (songMusicTitleTv == null) {
        break missingId;
      }

      id = R.id.song_next_iv;
      ImageView songNextIv = ViewBindings.findChildViewById(rootView, id);
      if (songNextIv == null) {
        break missingId;
      }

      id = R.id.song_pause_iv;
      ImageView songPauseIv = ViewBindings.findChildViewById(rootView, id);
      if (songPauseIv == null) {
        break missingId;
      }

      id = R.id.song_player_layout;
      LinearLayout songPlayerLayout = ViewBindings.findChildViewById(rootView, id);
      if (songPlayerLayout == null) {
        break missingId;
      }

      id = R.id.song_previous_iv;
      ImageView songPreviousIv = ViewBindings.findChildViewById(rootView, id);
      if (songPreviousIv == null) {
        break missingId;
      }

      id = R.id.song_progress_sb;
      SeekBar songProgressSb = ViewBindings.findChildViewById(rootView, id);
      if (songProgressSb == null) {
        break missingId;
      }

      id = R.id.song_random_iv;
      ImageView songRandomIv = ViewBindings.findChildViewById(rootView, id);
      if (songRandomIv == null) {
        break missingId;
      }

      id = R.id.song_related_iv;
      ImageView songRelatedIv = ViewBindings.findChildViewById(rootView, id);
      if (songRelatedIv == null) {
        break missingId;
      }

      id = R.id.song_repeat_iv;
      ImageView songRepeatIv = ViewBindings.findChildViewById(rootView, id);
      if (songRepeatIv == null) {
        break missingId;
      }

      id = R.id.song_setting_ib;
      ImageButton songSettingIb = ViewBindings.findChildViewById(rootView, id);
      if (songSettingIb == null) {
        break missingId;
      }

      id = R.id.song_singer_more_iv;
      ImageView songSingerMoreIv = ViewBindings.findChildViewById(rootView, id);
      if (songSingerMoreIv == null) {
        break missingId;
      }

      id = R.id.song_singer_name_tv;
      TextView songSingerNameTv = ViewBindings.findChildViewById(rootView, id);
      if (songSingerNameTv == null) {
        break missingId;
      }

      id = R.id.song_start_time_tv;
      TextView songStartTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (songStartTimeTv == null) {
        break missingId;
      }

      id = R.id.song_unlike_iv;
      ImageView songUnlikeIv = ViewBindings.findChildViewById(rootView, id);
      if (songUnlikeIv == null) {
        break missingId;
      }

      return new ActivitySongBinding((ConstraintLayout) rootView, songAlbumIv, songDownIb,
          songEndTimeTv, songEqIb, songInstagramIv, songLikeIv, songLikeIvLayout, songListIv,
          songMiniplayerIv, songMoreIb, songMusicLyrics01Iv, songMusicLyrics02Iv, songMusicTitleTv,
          songNextIv, songPauseIv, songPlayerLayout, songPreviousIv, songProgressSb, songRandomIv,
          songRelatedIv, songRepeatIv, songSettingIb, songSingerMoreIv, songSingerNameTv,
          songStartTimeTv, songUnlikeIv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
