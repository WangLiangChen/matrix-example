package com.sintrue.matrix.example.component;

import java.util.List;

/**
 * @author Liangchen.Wang 2022-08-16 16:38
 */
public class Policy {
    private String relation = "NONE";
    private String attribute;
    private String operator;
    private List<Object> values;
    private List<Policy> children;
    private int level;
}
