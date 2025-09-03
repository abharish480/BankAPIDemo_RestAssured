package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileTest extends BaseTest {

	@Test(description = "Get profile details ...",groups = {"sanity", "smoke" ,"regression"})
	public void getProfileTest() {
		
		AuthService authService = new AuthService();
		Response response	=authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse =	response.as(LoginResponse.class);
		//System.out.println(loginResponse.getToken());
		
		UserManagementService managementService = new UserManagementService();
		response =	managementService.getProfile(loginResponse.getToken());
		//System.out.println(response.asPrettyString());
		UserProfileResponse profileResponse =	response.as(UserProfileResponse.class);
		//System.out.println(profileResponse.getFirstName());
		//System.out.println(profileResponse.getEmail());
		Assert.assertEquals(response.getStatusCode(), 200 ,"Status code is not matching");
		Assert.assertEquals(profileResponse.getFirstName(), "Alok" ,"First name is incorrect");
		Assert.assertEquals(profileResponse.getUsername(), "uday1234" ,"Username is incorrect");
		
	}
}
