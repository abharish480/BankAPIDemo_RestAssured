package com.api.base;

import com.api.models.request.ProfileRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService {

	private final String BASE_PATH = "/api/users";
	
	public Response getProfile(String token) {
		setAuthorization(token);
		return getRequest(BASE_PATH+"/profile?id="+token);
	}
	
	public Response updateProfile(String token, ProfileRequest payload) {
		setAuthorization(token);
		return putRequest(payload, BASE_PATH+"/profile");
	}
	

}

