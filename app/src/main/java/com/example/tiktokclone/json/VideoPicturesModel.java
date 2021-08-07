package com.example.tiktokclone.json;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VideoPicturesModel implements Serializable {

	@SerializedName("id")
	private int id;

	@SerializedName("nr")
	private int nr;

	@SerializedName("picture")
	private String picture;

	public int getId(){
		return id;
	}

	public int getNr(){
		return nr;
	}

	public String getPicture(){
		return picture;
	}
}