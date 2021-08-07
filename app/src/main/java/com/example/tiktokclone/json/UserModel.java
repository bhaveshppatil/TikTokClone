package com.example.tiktokclone.json;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
public class UserModel implements Serializable {

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}