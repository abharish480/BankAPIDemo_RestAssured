package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	
@Test(description  = "Verify if Login API is working ..")
	public void loginTest() {
	
	baseURI ="http://64.227.160.186:8080/";
	RequestSpecification requestSpecification =	given();
	RequestSpecification y= requestSpecification.header("Content-Type", "application/json");
	RequestSpecification z =y.body("{\r\n"
			+ "  \"username\": \"uday1234\",\r\n"
			+ "  \"password\": \"uday12345\"\r\n"
			+ "}");
	
Response response =	z.post("/api/auth/login");

System.out.println(response.asPrettyString());
Assert.assertEquals(response.getStatusCode(), 200 ,"Status code is not matching");
	
	}

@Test(description = "Logging into app")
public void loginTestDuplicate() {
	
	//RestAssured.baseURI =;
	

	
	      Response response = given().baseUri("http://64.227.160.186:8080/").header("Content-Type", "application/json").body("{\r\n"
	  			+ "  \"username\": \"uday1234\",\r\n"
				+ "  \"password\": \"uday12345\"\r\n"
				+ "}").post("/api/auth/login");
	      
	      System.out.println(response.asPrettyString());
	
	Assert.assertEquals(response.getStatusCode(), 200 , "Status code is not matching!");
	
}


@Test(description = "Logging into app with invalid credentials")
public void loginTestInvalid() {
	
	baseURI ="http://64.227.160.186:8080/";
	
	RequestSpecification requestSpecification = given();
	RequestSpecification second =	requestSpecification.headers("Content-Type", "application/json");
	RequestSpecification third = second.body("{\r\n"
			+ "  \"username\": \"uday1234\",\r\n"
			+ "  \"password\": \"uday1235\"\r\n"
			+ "}");
	
	      Response response = third.post("/api/auth/login");
	      
	      System.out.println(response.asPrettyString());
	
	Assert.assertEquals(response.getStatusCode(), 200 , "Status code is not matching!");
	
}
}
