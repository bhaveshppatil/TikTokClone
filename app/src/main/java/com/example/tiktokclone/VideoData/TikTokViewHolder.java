package com.example.tiktokclone.VideoData;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.R;


public class TikTokViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle, tvDesc;
    private VideoView videoView;
    private ProgressBar progressBar;

    public TikTokViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvTitle = itemView.findViewById(R.id.videoTitle);
        tvDesc = itemView.findViewById(R.id.videoDecs);
        videoView = itemView.findViewById(R.id.videoView);
        progressBar = itemView.findViewById(R.id.progressBar);

    }

    public void setData(VideoDataModel videoDataModel) {
        tvTitle.setText(videoDataModel.getTvTitle());
        tvDesc.setText(videoDataModel.getTvDecs());
        videoView.setVideoURI(videoDataModel.getVideoUrl());

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                progressBar.setVisibility(View.GONE);
                mediaPlayer.start();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.stop();
            }
        });
    }
}
