package com.sintrue.matrix.framework.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.runtime.I18nMessage;
import wang.liangchen.matrix.framework.commons.runtime.Message;
import wang.liangchen.matrix.framework.spring.web.annotation.Redirect;
import wang.liangchen.matrix.framework.spring.web.annotation.ReturnRawText;
import wang.liangchen.matrix.framework.spring.web.response.JsonResponse;

@RestController
@RequestMapping("example")
public class ExampleController {

    @Redirect
    @GetMapping("redirect")
    public String redirect() {
        return "https://www.baidu.com";
    }

    @ReturnRawText
    @GetMapping("string")
    public String string() {
        return "This is a raw string";
    }

    @GetMapping("nativeObject")
    public MatrixResponse nativeObject() {
        MatrixResponse response = new MatrixResponse();
        response.setResponseId("ResponseId");
        response.setResponseName("ResponseName");
        return response;
    }

    @GetMapping("jsonResponse")
    public JsonResponse<?> jsonResponse() {
        MatrixResponse response = new MatrixResponse();
        response.setResponseId("ResponseId");
        response.setResponseName("ResponseName");
        return JsonResponse.success(response, Message.of("切图仔,你自己扒拉数据").withCode("10000"));
    }

    @GetMapping("jsonResponseI18n")
    public JsonResponse<?> jsonResponseI18n() {
        MatrixResponse response = new MatrixResponse();
        response.setResponseId("ResponseId");
        response.setResponseName("ResponseName");
        return JsonResponse.success(response, I18nMessage.of("切图仔,你自己扒拉数据").withCode("10000"));
    }

    @GetMapping("exception")
    public void exception() {
        throw new MatrixInfoException("this is a exception! 这是一个异常!");
    }

    @GetMapping("exceptionI18n")
    public void exceptionI18n() {
        throw new MatrixInfoException("{exception.example}");
    }
}
