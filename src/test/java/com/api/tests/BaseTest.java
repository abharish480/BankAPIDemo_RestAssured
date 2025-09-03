package com.api.tests;

import org.testng.annotations.AfterMethod;

import com.api.builders.RequestSpecBuilder;

public class BaseTest {

	@AfterMethod
    public void tearDown() {
        RequestSpecBuilder.clearSpec(); // Always clean up after each test
    }

}
