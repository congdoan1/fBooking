package com.tga.fbooking.dto;

import com.google.gson.annotations.SerializedName;

public class UserDTO {
	
	@SerializedName(value = "userId")
	private String id;
	
	@SerializedName(value = "id")
	private String facebookId;
	
	@SerializedName(value = "first_name")
	private String firstName;
	
	@SerializedName(value = "last_name")
	private String lastName;
	
	private String username;
	
	@SerializedName(value = "link")
	private String facebookUrl;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(String id, String facebookId, String firstName,
			String lastName, String username, String facebookUrl) {
		super();
		this.id = id;
		this.facebookId = facebookId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.facebookUrl = facebookUrl;
	}



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
