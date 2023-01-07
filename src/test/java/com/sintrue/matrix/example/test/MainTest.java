package com.sintrue.matrix.example.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainTest {
    @Test
    public void testMap() {
        Set<String> set = new HashSet<>();
        set.add("a");
        System.out.println(set);
    }
}
