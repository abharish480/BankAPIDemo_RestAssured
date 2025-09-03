package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

	 private static final Logger logger = LogManager.getLogger(TestListeners.class);
	
	public void onTestStart(ITestResult result) {
		logger.info("Test Started: {}", result.getName());
	  }

	public void onTestSuccess(ITestResult result) {
		logger.info("Test Passed: {}", result.getName());
		  }
	public void onTestFailure(ITestResult result) {
		 logger.error("Test Failed: {}", result.getName());
	     logger.error("Exception: ", result.getThrowable());
		  }
	
	public void onStart(ITestContext context) {
		logger.info("Suite Started: {}");
	  }

}
