package com.example.tiktokclone.json;

import java.util.List;

import com.example.tiktokclone.VideosModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("page")
	private int page;

	@SerializedName("per_page")
	private int perPage;

	@SerializedName("videos")
	private List<VideosModel> videos;

	@SerializedName("total_results")
	private int totalResults;

	@SerializedName("next_page")
	private String nextPage;

	@SerializedName("url")
	private String url;

	public int getPage(){
		return page;
	}

	public int getPerPage(){
		return perPage;
	}

	public List<VideosModel> getVideos(){
		return videos;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public String getNextPage(){
		return nextPage;
	}

	public String getUrl(){
		return url;
	}
}