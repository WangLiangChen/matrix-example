package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MainTest {
    @Test
    public void testMap() {
        Set<String> set = new HashSet<>();
        set.add("a");
        System.out.println(set);
    }
}
