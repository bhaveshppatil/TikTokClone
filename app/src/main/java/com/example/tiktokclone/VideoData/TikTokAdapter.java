package com.example.tiktokclone.VideoData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.R;

import java.util.List;

public class TikTokAdapter extends RecyclerView.Adapter<TikTokViewHolder> {

    private List<VideoDataModel> videoDataModels;

    public TikTokAdapter(List<VideoDataModel> VideoDataModels) {
        this.videoDataModels = VideoDataModels;
    }

    @NonNull
    @Override
    public TikTokViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item_layout, parent, false);
        return new TikTokViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TikTokViewHolder holder, int position) {
        VideoDataModel videoDataModel = videoDataModels.get(position);
        holder.setData(videoDataModel);
    }

    @Override
    public int getItemCount() {
        return videoDataModels.size();
    }
}
