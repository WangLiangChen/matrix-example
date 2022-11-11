package com.sintrue.matrix.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

/**
 * @author Liangchen.Wang 2022-10-26 14:21
 */
public class CommonTest {
    @Test
    public void testJackson() throws JsonProcessingException {
        String string ="123";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(string);
        System.out.println(jsonString);
        jsonString="\"\"";
        string = objectMapper.readValue(jsonString, String.class);
        System.out.println(string);
    }
}
