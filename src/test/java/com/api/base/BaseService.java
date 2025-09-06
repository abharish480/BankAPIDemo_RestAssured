package com.api.base;

import com.api.builders.RequestSpecBuilder;
import com.api.utils.AllureLogger;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    protected RequestSpecification getRequestSpec() {
        return RequestSpecBuilder.getSpec();
    }

    protected void clearRequestSpec() {
        RequestSpecBuilder.clearSpec();
    }

    protected void setAuthorization(String token) {
        RequestSpecBuilder.setAuthorization(token);
    }

    protected Response postRequest(Object payload, String endpoint) {
    	AllureLogger.log("Request endpoint", endpoint);
    	AllureLogger.log("Request Body", payload.toString());
        return getRequestSpec()
                .body(payload)
                .post(endpoint);
    }

    protected Response getRequest(String endpoint) {
        return getRequestSpec().get(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint) {
    	AllureLogger.log("Request Body", payload.toString());
        return getRequestSpec()
                .body(payload)
                .put(endpoint);
    }
}