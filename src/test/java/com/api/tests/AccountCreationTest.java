package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.constants.TestDataPaths;
import com.api.models.request.SignupRequest;
import com.api.utils.JsonUtils;
import com.api.utils.TestDataLoader;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "Creat account .." , groups = {"sanity", "smoke" ,"regression"})
	public void accountCreationTest() {
		Faker faker = new Faker();
		SignupRequest request = new SignupRequest.Builder()
			    .setUsername(faker.name().username().replaceAll("[^a-zA-Z0-9]", ""))
			    .setPassword(faker.internet().password(8,12))
			    .setEmail(faker.internet().emailAddress())
			    .setFirstName(faker.name().firstName())
			    .setLastName(faker.name().lastName())
			    .setMobileNumber(faker.number().digits(10))
			    .build();
		
		AuthService authService = new AuthService();
		Response response = authService.signup(request);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200 ,"Status code is not matching");
		Assert.assertEquals(response.getBody().asPrettyString(), "User registered successfully!" ,"Response body is not matching");
	}
	
	
	
	@Test(description = "Create account using JSON payload")
	public void accountCreationTestViaJsonPayload() {
	    SignupRequest request = JsonUtils.readJsonAsObject(
	        "src/test/resources/payloads/signupPayload.json", SignupRequest.class);

	    AuthService authService = new AuthService();
	    Response response = authService.signup(request);

	    Assert.assertEquals(response.getStatusCode(), 200, "Status code is not matching");
	}
	
	
	@DataProvider(name = "signupData")
	public Object[][] signupDataProvider() {
	    SignupRequest request = JsonUtils.readJsonAsObject(
	        "src/test/resources/payloads/signupPayload.json", SignupRequest.class);
	    return new Object[][] { { request } };
	}
	

	@Test(dataProvider = "signupData")
	public void accountCreationTestViaTestNGDataProvider(SignupRequest request) {
	    AuthService authService = new AuthService();
	    Response response = authService.signup(request);
	    Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	

	@Test(description = "Create account using JSON payload")
	public void accountCreationTestViaJsonPayloadViaPaths() {
	    SignupRequest request = JsonUtils.readJsonAsObject(
	        TestDataPaths.SIGNUP_PAYLOAD, SignupRequest.class);

	    AuthService authService = new AuthService();
	    Response response = authService.signup(request);

	    Assert.assertEquals(response.getStatusCode(), 200, "Status code is not matching");
	}
	
	@Test(description = "Valid signup test -- json has multiple data")
	public void validSignupTest() {
	    SignupRequest request = TestDataLoader.getSignupPayload("validSignup");
	    Response response = new AuthService().signup(request);
	    Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(description = "Duplicate email test")
	public void duplicateEmailTest() {
	    SignupRequest request = TestDataLoader.getSignupPayload("duplicateEmail");
	    Response response = new AuthService().signup(request);
	    Assert.assertEquals(response.getStatusCode(), 409); // example conflict
	}
	
}
