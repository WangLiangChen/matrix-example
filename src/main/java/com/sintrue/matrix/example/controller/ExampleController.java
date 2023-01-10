package com.sintrue.matrix.example.controller;

import com.sintrue.matrix.example.service.ExampleService;
import com.sintrue.matrix.example.service.message_pl.ExampleRequest;
import com.sintrue.matrix.example.service.message_pl.ExampleResponse;
import org.springframework.web.bind.annotation.*;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.exception.MatrixWarnException;
import wang.liangchen.matrix.framework.commons.runtime.MessageWrapper;
import wang.liangchen.matrix.framework.commons.runtime.ReturnWrapper;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/example")
public class ExampleController {
    private final ExampleService service;

    @Inject
    public ExampleController(ExampleService service) {
        this.service = service;
    }

    /**
     * Void returns automatically wrapped
     */
    @GetMapping("/void")
    public void voidMethod() {
    }

    /**
     * Object returns automatically wrapped
     */
    @GetMapping("/object")
    public ExampleResponse object() {
        ExampleResponse response = ExampleResponse.newInstance();
        response.setStaffName("LiangchenWang");
        return response;
    }

    /**
     * Exception returns automatically wrapped
     * Use exceptions to control business logic
     *
     * @param level
     */
    @GetMapping("/exception")
    public void exception(@RequestParam String level) {
        switch (level) {
            case "WARN":
                throw new MatrixWarnException("I am a warn exception").code("warn_code");
            case "INFO":
                throw new MatrixInfoException("I am a info exception").code("info_code");
            case "ERROR":
                throw new MatrixErrorException("I am a error exception").code("error_code");
            default:
                throw new RuntimeException("I am a runtime exception");
        }
    }

    /**
     * ReturnWrapper returns automatically wrapped
     * Use ReturnWrapper to control business logic
     *
     * @param hasError
     * @return
     */
    @GetMapping("/returnWrapper")
    public ReturnWrapper<ExampleResponse> returnWrapper(@RequestParam Boolean hasError) {
        if (hasError) {
            return ReturnWrapper.failure(ExampleResponse.class).message(MessageWrapper.of("failure_code", "I am a message"));
        }
        ExampleResponse response = ExampleResponse.newInstance();
        response.setStaffName("LiangchenWang");
        return ReturnWrapper.success(response);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody ExampleRequest request) {
        this.service.insert(request);
    }

    @PostMapping("/list")
    public Collection<ExampleResponse> list(@RequestBody ExampleRequest request) {
        return this.service.list(request);
    }

}
