package com.api.builders;

import com.api.config.ConfigManager;
import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilder {

    private static final ThreadLocal<RequestSpecification> requestSpec = new ThreadLocal<>();

    static {
        RestAssured.filters(new LoggingFilter()); // Global filter
    }

    public static RequestSpecification getSpec() {
        RequestSpecification spec = requestSpec.get();
        if (spec == null) {
            spec = RestAssured.given()
                    .baseUri(ConfigManager.getBaseUrl())
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .relaxedHTTPSValidation(); // Optional for QA/UAT
            requestSpec.set(spec);
        }
        return spec;
    }

    public static void setAuthorization(String token) {
        getSpec().header("Authorization", "Bearer " + token);
    }

    public static void clearSpec() {
        requestSpec.remove();
    }
}