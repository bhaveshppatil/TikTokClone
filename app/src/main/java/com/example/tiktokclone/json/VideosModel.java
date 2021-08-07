package com.example.tiktokclone.json;

import java.util.List;

import com.example.tiktokclone.json.UserModel;
import com.example.tiktokclone.json.VideoFilesModel;
import com.example.tiktokclone.json.VideoPicturesModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VideosModel implements Serializable {

	@SerializedName("id")
	private int id;

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	@SerializedName("duration")
	private int duration;

	@SerializedName("full_res")
	private Object fullRes;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("url")
	private String url;

	@SerializedName("image")
	private String image;

	@SerializedName("avg_color")
	private Object avgColor;

	@SerializedName("user")
	private UserModel user;

	@SerializedName("video_files")
	private List<VideoFilesModel> videoFiles;

	@SerializedName("video_pictures")
	private List<VideoPicturesModel> videoPictures;

	public int getId(){
		return id;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public int getDuration(){
		return duration;
	}

	public Object getFullRes(){
		return fullRes;
	}

	public List<Object> getTags(){
		return tags;
	}

	public String getUrl(){
		return url;
	}

	public String getImage(){
		return image;
	}

	public Object getAvgColor(){
		return avgColor;
	}

	public UserModel getUser(){
		return user;
	}

	public List<VideoFilesModel> getVideoFiles(){
		return videoFiles;
	}

	public List<VideoPicturesModel> getVideoPictures(){
		return videoPictures;
	}
}