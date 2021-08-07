package com.example.tiktokclone.VideoData;

import android.net.Uri;

public class VideoModel {

    private String tvTitle, tvDecs;
    private Uri videoUrl;

    public VideoModel(String tvTitle, String tvDecs, Uri videoUrl) {
        this.tvTitle = tvTitle;
        this.tvDecs = tvDecs;
        this.videoUrl = videoUrl;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public String getTvDecs() {
        return tvDecs;
    }

    public Uri getVideoUrl() {
        return videoUrl;
    }
}
