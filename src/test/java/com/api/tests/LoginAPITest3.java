package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;


@Listeners(com.api.listeners.TestListeners.class)
public class LoginAPITest3 {
	
@Test(description  = "Verify if Login API is working ..")
	public void loginTest() {
	
	LoginRequest loginRequest = new LoginRequest("uday1234", "uday12345");
	
	AuthService authService = new AuthService();
	Response response = authService.login(loginRequest);
	
	LoginResponse loginResponse = response.as(LoginResponse.class);
	//System.out.println(loginResponse.getToken());
	
	Assert.assertEquals(response.getStatusCode(), 200 ,"Status code is not matching");
	
	}
}
