package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest2 {
	
@Test(description  = "Verify if Login API is working ..")
	public void loginTest() {
	
	Response response =	given()
			.baseUri("http://64.227.160.186:8080/")
			.header("Content-Type", "application/json")
			.body("{\r\n"
		+ "  \"username\": \"uday1234\",\r\n"
		+ "  \"password\": \"uday12345\"\r\n"
		+ "}")
			.post("/api/auth/login");

System.out.println(response.asPrettyString());
Assert.assertEquals(response.getStatusCode(), 200 ,"Status code is not matching");
	
	}
}
