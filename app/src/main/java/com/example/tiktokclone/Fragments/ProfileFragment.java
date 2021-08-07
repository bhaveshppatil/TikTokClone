package com.example.tiktokclone.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.ProfileRecyclerView.ClickListener;
import com.example.tiktokclone.ProfileRecyclerView.VideoAdapter;
import com.example.tiktokclone.R;
import com.example.tiktokclone.VideoData.VideoDataModel;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment implements ClickListener{

    private RecyclerView recyclerView;
    private ClickListener clickListener;
    private VideoView videoView;
    private List<VideoDataModel> videoDataModelList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildData();
        setRecyclerView();
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        videoView = view.findViewById(R.id.videoViewProfile);
    }

    private void setRecyclerView() {
        VideoAdapter videoAdapter = new VideoAdapter(videoDataModelList, clickListener);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(videoAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void buildData() {
        Uri uri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video3);
        Uri uri2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video2);
        Uri uri3 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video8);
        Uri uri4 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video4);
        Uri uri5 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video6);
        Uri uri6 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video8);
        Uri uri7 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video9);

        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", uri1));
        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", uri2));
        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", uri3));
        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", uri4));
        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", uri5));
        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", uri7));
        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", uri6));

    }

    @Override
    public void onItemClick(VideoDataModel videoDataModel, int position) {
    }
}