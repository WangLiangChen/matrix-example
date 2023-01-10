package com.sintrue.matrix.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.springboot.jackson.DefaultObjectMapper;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class MainTest {
    @Test
    public void testMap() {
        Set<String> set = new HashSet<>();
        set.add("a");
        System.out.println(set);
    }

    @Test
    public void testJson() throws JsonProcessingException {
        LocalDate localDate = LocalDate.now();
        String string = DefaultObjectMapper.INSTANCE.objectMapper().writeValueAsString(localDate);
        System.out.println(string);
    }

    @Test
    public void testJavaVersion() {
        System.out.println(System.getProperty("java.specification.version"));
    }
}
