package com.api.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        // First check system property (e.g., -Denv=UAT)
        String systemValue = System.getProperty(key);
        if (systemValue != null) {
            return systemValue;
        }

        // Then fallback to config file
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        String env = getProperty("env"); // No default here
        if (env == null) {
            throw new RuntimeException("Environment 'env' not specified in system properties or config file.");
        }

        String baseUrlKey = "baseUrl." + env;
        String baseUrl = getProperty(baseUrlKey);
        if (baseUrl == null) {
            throw new RuntimeException("Base URL for environment '" + env + "' not found.");
        }

        return baseUrl;
    }
}