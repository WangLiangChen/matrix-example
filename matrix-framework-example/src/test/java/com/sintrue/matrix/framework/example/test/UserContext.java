package com.sintrue.matrix.framework.example.test;

import com.alibaba.ttl.TransmittableThreadLocal;

public class UserContext {
    private static final TransmittableThreadLocal<String> currentUser = new TransmittableThreadLocal<>();

    public static void setUser(String username) {
        currentUser.set(username);
    }

    public static String getUser() {
        return currentUser.get();
    }

    public static void clear() {
        currentUser.remove();
    }
}
