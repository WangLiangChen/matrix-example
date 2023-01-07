package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.service.ExampleService;
import com.sintrue.matrix.example.service.message_pl.ExampleRequest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExampleTest {
    @Inject
    private ExampleService service;


    @Test
    public void testInsert() {
        ExampleRequest request = ExampleRequest.newInstance();

        this.service.insert(request);
    }
}
