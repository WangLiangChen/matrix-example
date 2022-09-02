package com.sintrue.matrix.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.liangchen.matrix.framework.commons.exception.Assert;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.exception.MatrixPromptException;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.web.response.FormattedResponse;

/**
 * @author Liangchen.Wang 2022-08-26 17:05
 */
@RestController
@RequestMapping("/")
public class ExampleController {
    private String name;

    public ExampleController() {
    }

    public ExampleController(String name) {
        // 优雅样式推荐
        // 赋值前判断
        this.name = ObjectUtil.INSTANCE.validateNotEmpty(name);
        // 使用断言异常
        Assert.INSTANCE.isBlank(this.name, "name can't be blank");
    }

    @GetMapping("void")
    public void voidMethod() {
        // 没有返回值的场景
    }

    @GetMapping("error")
    public void error() {
        throw new MatrixErrorException("I am a error");
    }

    @GetMapping("info")
    public void info() {
        throw new MatrixInfoException("I am a info");
    }

    @GetMapping("prompt")
    public void prompt() {
        throw new MatrixPromptException("I am a prompt");
    }

    @GetMapping("exception")
    public void exception() {
        throw new RuntimeException("I am a exception");
    }

    @GetMapping("success")
    public FormattedResponse success() {
        return FormattedResponse.success().code("110").payload("I am success payload");
    }

    @GetMapping("failure")
    public FormattedResponse failure() {
        return FormattedResponse.failure().code("500").payload("I am failure payload");
    }
}
