package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static <T> T readJsonAsObject(String filePath, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }
    
    public static <T> T readJsonObjectByKey(String resourcePath, String key, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) throw new FileNotFoundException("Resource not found: " + resourcePath);
            JsonNode rootNode = mapper.readTree(is);
            JsonNode targetNode = rootNode.get(key);
            if (targetNode == null) throw new IllegalArgumentException("Key not found: " + key);
            return mapper.treeToValue(targetNode, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON object by key from classpath: " + resourcePath, e);
        }
    }
}