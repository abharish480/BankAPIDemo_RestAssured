package com.api.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
public class AllureLogger {

	@Attachment(value = "{0}", type = "text/plain")
    public static String logToAllure(String name, String content) {
        return content;
    }
	
	public static void logRequestInline(String request) {
        Allure.step("API Request:\n" + request);
    }

    public static void logResponseInline(String response) {
        Allure.step("API Response:\n" + response);
    }
    
    public static void log(String name, String body) {
        Allure.step(name +" ==> "+ body);
    }
    
    public static void log( String body) {
        Allure.step(body);
    }
}
