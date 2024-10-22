package com.gold.start.study;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

public class CommonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Java 객체를 JSON 문자열로 변환
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null; // 적절한 예외 처리를 할 수 있습니다.
        }
    }

    // JSON 문자열을 Java 객체로 변환
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null; // 적절한 예외 처리를 할 수 있습니다.
        }
    }

}
