package com.example.tiktokclone.ProfileRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.R;
import com.example.tiktokclone.VideoData.VideoDataModel;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private List<VideoDataModel> videoDataModelList;
    private ClickListener clickListener;

    public VideoAdapter(List<VideoDataModel> videoDataModelList, ClickListener clickListener) {
        this.videoDataModelList = videoDataModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_video_layout, parent, false);
        return new VideoViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        VideoDataModel videoDataModel = videoDataModelList.get(position);
        holder.setVideoView(videoDataModel);
    }

    @Override
    public int getItemCount() {
        return videoDataModelList.size();
    }
}
