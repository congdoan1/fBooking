package com.tga.fbooking.dto;

import com.google.gson.annotations.SerializedName;

public class UserDTO {
	
	@SerializedName(value = "userId")
	private String id;
	@SerializedName(value = "id")
	private String facebookId;
	private String firstName;
	private String lastName;
	private String username;
	private String facebookUrl;
	
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFacebookUrl() {
		return facebookUrl;
	}
	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	
	
}
