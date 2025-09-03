package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test(description = "Forgot password test .." , groups = {"sanity", "smoke" ,"regression"})
	public void forgotPasswordTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("john@example.com");
		System.out.println(response.asPrettyString());
		
	}
}
