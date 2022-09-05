package com.sintrue.matrix.example.service;


import com.sintrue.matrix.example.domain.ExampleManager;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.ApplicationService;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-09-02 14:48
 */
@Service
@ApplicationService
public class ExampleService {
    private final ExampleManager exampleManager;

    @Inject
    public ExampleService(ExampleManager exampleManager) {
        this.exampleManager = exampleManager;
    }


}
