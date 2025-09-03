package com.api.utils;

import com.api.models.request.SignupRequest;

public class TestDataLoader {
	
	    public static SignupRequest getSignupPayload(String testCaseName) {
	        return JsonUtils.readJsonObjectByKey("payloads/signupPayloadsMultiple.json", testCaseName, SignupRequest.class);
	    }
	}

