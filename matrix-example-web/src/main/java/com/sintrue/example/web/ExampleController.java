package com.sintrue.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.liangchen.matrix.framework.commons.exception.ExceptionLevel;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.exception.MatrixWarnException;
import wang.liangchen.matrix.framework.commons.runtime.MessageWrapper;
import wang.liangchen.matrix.framework.commons.runtime.ReturnWrapper;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.springboot.context.MessageSourceUtil;

/**
 * @author Liangchen.Wang 2023-05-04 11:35
 */
@RestController
@RequestMapping("/example")
public class ExampleController {
    @GetMapping("/i18nValidation")
    public void i18nValidation() {
        ValidationUtil.INSTANCE.isTrue(ExceptionLevel.INFO, false, "{say.hello}");
    }

    @GetMapping("/i18nMessageSource")
    public void i18nMessageSource() {
        String message = MessageSourceUtil.INSTANCE.getMessage("say.hello");
        throw new MatrixInfoException(message);
    }

    @GetMapping("/void")
    public void voidResponse() {
    }

    @GetMapping("/returnWrapperSuccess")
    public ReturnWrapper<String> returnWrapperSuccess() {
        return ReturnWrapper.success("do it").message(MessageWrapper.of("1001", "操作成功"));
    }

    @GetMapping("/returnWrapperFailure")
    public ReturnWrapper<String> returnWrapperFailure() {
        return ReturnWrapper.failure(String.class).message(MessageWrapper.of("1002", "操作失败"));
    }

    @GetMapping("/object")
    public Object object() {
        return "I'm a object";
    }

    @GetMapping("/exception")
    public void exception(ExceptionLevel level) {
        switch (level) {
            case INFO:
                throw new MatrixInfoException("info exception");
            case WARN:
                throw new MatrixWarnException("warn exception");
            case ERROR:
                throw new MatrixErrorException("error exception");
        }
    }
}
