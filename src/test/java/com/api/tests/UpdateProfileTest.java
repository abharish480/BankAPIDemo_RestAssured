package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "Update the profile details")
	public void updateProfile() {
		
		AuthService authService = new AuthService();
		Response response	=authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse =	response.as(LoginResponse.class);
		//System.out.println(loginResponse.getToken());
		
		System.out.println("-----------------------------------------------------------------------");
		
		UserManagementService managementService = new UserManagementService();
		System.out.println(response.asPrettyString());
		UserProfileResponse profileResponse =	response.as(UserProfileResponse.class);
		//System.out.println(profileResponse.getUsername());
		
		System.out.println("-----------------------------------------------------------------------");
		
//		ProfileRequest profileRequest = new ProfileRequest.Builder()
//			    .setFirstName("AlokTest")
//			    .setLastName("Yadav Last")
//			    .setEmail("aloktest@example.com")
//			    .setMobileNumber("9879879870")
//			    .build();
//		
		ProfileRequest profileRequest = ProfileRequest.builder()
			    .firstName("John")
			    .lastName("Doe")
			    .email("john.doe@example.com")
			    .mobileNumber("1234567890")
			    .build();


		response = managementService.updateProfile(loginResponse.getToken(), profileRequest);
		//System.out.println(response.asPrettyString());
	}
}
