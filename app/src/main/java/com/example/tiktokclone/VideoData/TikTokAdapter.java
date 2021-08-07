package com.example.tiktokclone.VideoData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.R;

import java.util.List;

public class TikTokAdapter extends RecyclerView.Adapter<TikTokViewHolder> {

    private List<VideoModel> videoModels;

    public TikTokAdapter(List<VideoModel> videoModels) {
        this.videoModels = videoModels;
    }

    @NonNull
    @Override
    public TikTokViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item_layout, parent, false);
        return new TikTokViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TikTokViewHolder holder, int position) {
        VideoModel videoModel = videoModels.get(position);
        holder.setData(videoModel);
    }

    @Override
    public int getItemCount() {
        return videoModels.size();
    }
}
