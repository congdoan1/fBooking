package com.tga.fbooking.api;

import com.google.gson.Gson;
import com.tga.fbooking.dto.UserDTO;
import com.tga.fbooking.util.NetUtils;

public class APIWrapper {
	
	private static String appID = "438701402972639";
	private static String appSecret = "2f46ee65ec84e8ad708cb095d718a8c5";
	private static String redirectUrl = "http://localhost:8080/fbooking/login/facebook";
	private String accessToken;
	private Gson gson;
	
	public APIWrapper() {
		gson = new Gson();
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public static String getDialogLink() {
		String dialogLink = "https://www.facebook.com/dialog/oauth?"
				+ "client_id=%s"
				+ "&redirect_uri=%s";
		return String.format(dialogLink, appID, redirectUrl);
	}
	
	public String getAccessToken(String code) {
		String accessTokenLink = "https://graph.facebook.com/oauth/access_token?"
				+ "client_id=%s"
				+ "&client_secret=%s"
				+ "&redirect_uri=%s"
				+ "&code=%s";
		accessTokenLink = String.format(accessTokenLink, appID, appSecret, redirectUrl, code);
		String result = NetUtils.getResult(accessTokenLink);
		String token = result.substring(result.indexOf("=") + 1, result.indexOf("&"));
		return token;
	}
	
	public UserDTO getUserInfo() {
		String infoUrl = "https://graph.facebook.com/me?access_token=%s";
		infoUrl = String.format(infoUrl, this.accessToken);
		
		String result = NetUtils.getResult(infoUrl);
		UserDTO dto = gson.fromJson(result, UserDTO.class);
		return dto;
	}

}
