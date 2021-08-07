package com.example.tiktokclone.ProfileRecyclerView;

import android.view.View;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tiktokclone.R;
import com.example.tiktokclone.VideoData.VideoDataModel;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    private VideoView videoView;
    private CardView cardView;
    private ClickListener clickListener;

    public VideoViewHolder(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        videoView = itemView.findViewById(R.id.videoViewProfile);
        cardView = itemView.findViewById(R.id.cardViewProfile);
    }
    public void setVideoView(VideoDataModel videoDataModel){
        videoView.setVideoURI(videoDataModel.getVideoUrl());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(videoDataModel, getAdapterPosition());
            }
        });

    }
}
