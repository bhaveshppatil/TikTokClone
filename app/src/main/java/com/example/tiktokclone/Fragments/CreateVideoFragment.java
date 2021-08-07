package com.example.tiktokclone.Fragments;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.tiktokclone.CreateVideo.ApiService;
import com.example.tiktokclone.CreateVideo.Network;
import com.example.tiktokclone.CreateVideo.ResponseModel;
import com.example.tiktokclone.R;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CreateVideoFragment extends Fragment {
    private ImageView ivCreateVideo, ivOpenGallery, ivUploadVideo;
    private Button btnOK;
    private VideoView videoView;
    private CardView cardView;
    private String filePath;


    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getData() != null) {
                        Uri uri = result.getData().getData();
                        videoView.setVideoURI(uri);
                        videoView.setMediaController(new MediaController(getContext()));
                        getPath(uri);
                    }
                }
            });


    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        activityResultLauncher.launch(intent);

    }

    private boolean isPermissionGranted() {
        return ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

    }

    @NotNull
    private void getPath(Uri uri) {
        String[] videoPath = {MediaStore.Video.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(uri, videoPath,
                null, null, null);
        cursor.moveToFirst();
        int index = cursor.getColumnIndex(videoPath[0]);
        filePath = cursor.getString(index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
    }

    private void initviews(View view) {
        ivCreateVideo = view.findViewById(R.id.ivCreateVideo);
        ivOpenGallery = view.findViewById(R.id.openGallery);
        ivUploadVideo = view.findViewById(R.id.uploadVideo);
        videoView = view.findViewById(R.id.videoView);
        cardView = view.findViewById(R.id.cardSuccessView);

        ivCreateVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivOpenGallery.setVisibility(View.VISIBLE);
                ivUploadVideo.setVisibility(View.VISIBLE);
            }
        });

        ivOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPermissionGranted()) {
                    openGallery();
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                }
            }
        });

        ivUploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadVideoToApi();
            }
        });
    }

    private void uploadVideoToApi() {

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("please wait");
        progressDialog.show();

        ApiService apiServices = Network.getInstance().create(ApiService.class);
        File file = new File(filePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("video/*"), file);
        MultipartBody.Part multiBody = MultipartBody.Part.createFormData("video", file.getName(), requestBody);

        apiServices.uploadVideo(multiBody, "Video").enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                progressDialog.dismiss();
                cardView.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), "Video upload success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Video upload failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else {
                Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}