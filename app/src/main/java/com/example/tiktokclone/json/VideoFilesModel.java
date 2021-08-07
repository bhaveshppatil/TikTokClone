package com.example.tiktokclone.json;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VideoFilesModel implements Serializable {

	@SerializedName("id")
	private int id;

	@SerializedName("quality")
	private String quality;

	@SerializedName("file_type")
	private String fileType;

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	@SerializedName("link")
	private String link;

	public int getId(){
		return id;
	}

	public String getQuality(){
		return quality;
	}

	public String getFileType(){
		return fileType;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public String getLink(){
		return link;
	}
}