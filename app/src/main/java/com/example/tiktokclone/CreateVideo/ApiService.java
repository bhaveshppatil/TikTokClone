package com.example.tiktokclone.CreateVideo;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @Headers("Authorization: Client-ID 983e36744a0267f")
    @POST("3/upload")
    @Multipart
    Call<ResponseModel> uploadVideo(
            @Part MultipartBody.Part file,
            @Part("title") String title
    );
}
