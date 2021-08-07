package com.example.tiktokclone.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tiktokclone.R;
import com.example.tiktokclone.VideoData.TikTokAdapter;
import com.example.tiktokclone.VideoData.VideoDataModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private ViewPager2 viewPager2;
    private TikTokAdapter tikTokAdapter;
    private List<VideoDataModel> videoDataModelList = new ArrayList<>();
    private EditText etQuery;
    private ImageView ivSearch;
    private LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        buildVideoData();
        setViewPager2();
    }

    private void initView(View view) {

        viewPager2 = view.findViewById(R.id.viewPager);
    }

    private void buildVideoData() {
        Uri uri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video3);
        Uri uri2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video2);
        Uri uri3 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video8);
        Uri uri4 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video4);
        Uri uri5 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video6);
        Uri uri6 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video8);
        Uri uri7 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video9);

        videoDataModelList.add(new VideoDataModel("Road Trip","#travelling, #trip, #enjoying", uri1 ));
        videoDataModelList.add(new VideoDataModel("Road Trip","#travelling, #trip, #enjoying", uri2 ));
        videoDataModelList.add(new VideoDataModel("Road Trip","#travelling, #trip, #enjoying", uri3 ));
        videoDataModelList.add(new VideoDataModel("Road Trip","#travelling, #trip, #enjoying", uri4 ));
        videoDataModelList.add(new VideoDataModel("Road Trip","#travelling, #trip, #enjoying", uri5 ));
        videoDataModelList.add(new VideoDataModel("Road Trip","#travelling, #trip, #enjoying", uri7 ));
        videoDataModelList.add(new VideoDataModel("Road Trip","#travelling, #trip, #enjoying", uri6 ));

    }

//        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", "https://vod-progressive.akamaized.net/exp=1628369724~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F3890%2F18%2F469452151%2F2087490384.mp4~hmac=564f366e9a0ca67723fb9facd25fe6806806dc30175a8ef773c2fb136c5d4e05/vimeo-prod-skyfire-std-us/01/3890/18/469452151/2087490384.mp4?filename=pexels-kokokara-5630868.mp4"));
//        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", "https://vod-progressive.akamaized.net/exp=1628366116~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1946%2F19%2F484732151%2F2170751195.mp4~hmac=5dca02786a7a6cb18041855e3d5a50545457b0d60fc4026580badcde9fe85ef4/vimeo-prod-skyfire-std-us/01/1946/19/484732151/2170751195.mp4?filename=pexels-tima-miroshnichenko-6010489.mp4"));
//        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", "https://vod-progressive.akamaized.net/exp=1628369342~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F2799%2F20%2F513995500%2F2380343441.mp4~hmac=d133267d738af929f66be172b71e39fe108ee71b9546886df7d7a0ebae35e621/vimeo-prod-skyfire-std-us/01/2799/20/513995500/2380343441.mp4?filename=pexels-olia-danilevich-6868307.mp4"));
//        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", "https://vod-progressive.akamaized.net/exp=1628369399~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F805%2F20%2F504027496%2F2304840685.mp4~hmac=dd7b0d16d4dc6e37083d617ecd3c008b91f20ff842d70c6c107dc4a7a09f6ab0/vimeo-prod-skyfire-std-us/01/805/20/504027496/2304840685.mp4?filename=pexels-artem-podrez-6584518.mp4"));
//        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", "https://vod-progressive.akamaized.net/exp=1628369516~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F3638%2F18%2F468190060%2F2080763710.mp4~hmac=05315324b3219150a9a2d6136ab18bb1030f2f51c6eb840d78f11c7a4c7ffa73/vimeo-prod-skyfire-std-us/01/3638/18/468190060/2080763710.mp4?filename=pexels-hadis-qr-5602372.mp4"));
//        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", "https://vod-progressive.akamaized.net/exp=1628369570~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F2799%2F20%2F513996442%2F2380350279.mp4~hmac=172d7acf07735b665d69cce0d6b6c053aa4754054af4dd813097b7cfc88989de/vimeo-prod-skyfire-std-us/01/2799/20/513996442/2380350279.mp4?filename=pexels-olia-danilevich-6868318.mp4"));
//        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", "https://vod-progressive.akamaized.net/exp=1628369618~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F2799%2F20%2F513998527%2F2380365619.mp4~hmac=77053b19fb45c34d5daeb26ea4f66c8c015f77196c2b9ffdc8a7b8a353c4d687/vimeo-prod-skyfire-std-us/01/2799/20/513998527/2380365619.mp4?filename=pexels-olia-danilevich-6868354.mp4"));
//        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", "https://vod-progressive.akamaized.net/exp=1628369686~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F2674%2F20%2F513373860%2F2375645369.mp4~hmac=1b3787bdbdabb42d7894591324243d0c389609367369585bbb2e12ef0405eda9/vimeo-prod-skyfire-std-us/01/2674/20/513373860/2375645369.mp4?filename=pexels-cottonbro-6853337.mp4"));
//        videoDataModelList.add(new VideoDataModel("Road Trip", "#travelling, #trip, #enjoying", "https://vod-progressive.akamaized.net/exp=1628369724~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F3890%2F18%2F469452151%2F2087490384.mp4~hmac=564f366e9a0ca67723fb9facd25fe6806806dc30175a8ef773c2fb136c5d4e05/vimeo-prod-skyfire-std-us/01/3890/18/469452151/2087490384.mp4?filename=pexels-kokokara-5630868.mp4"));
//    }

    private void setViewPager2() {
        tikTokAdapter = new TikTokAdapter(videoDataModelList);
        viewPager2.setAdapter(tikTokAdapter);
    }
}