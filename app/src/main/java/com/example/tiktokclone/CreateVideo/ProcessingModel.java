package com.example.tiktokclone.CreateVideo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ProcessingModel implements Serializable {

	@SerializedName("status")
	private String status;

	public String getStatus(){
		return status;
	}
}