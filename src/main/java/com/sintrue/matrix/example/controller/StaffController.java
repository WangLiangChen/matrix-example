package com.sintrue.matrix.example.controller;

import com.sintrue.matrix.example.service.staff.StaffResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.exception.MatrixWarnException;
import wang.liangchen.matrix.framework.commons.runtime.MessageWrapper;
import wang.liangchen.matrix.framework.commons.runtime.ReturnWrapper;
import wang.liangchen.matrix.framework.web.push.PushUtil;
import wang.liangchen.matrix.framework.web.push.PusherKey;
import wang.liangchen.matrix.framework.web.push.PusherType;
import wang.liangchen.matrix.framework.web.response.FormattedResponse;

import java.util.Map;

/**
 * @author Liangchen.Wang 2022-12-09 23:39
 */
@RestController
@RequestMapping("/")
public class StaffController {
    @GetMapping("void")
    public void doVoid() {

    }

    @GetMapping("object")
    public StaffResponse object() {
        StaffResponse staffResponse = new StaffResponse();
        staffResponse.setStaffName("name");
        return staffResponse;
    }

    @GetMapping("returnWrapper")
    public ReturnWrapper<StaffResponse> returnWrapper(@RequestParam boolean success) {
        if (success) {
            StaffResponse staffResponse = new StaffResponse();
            staffResponse.setStaffName("name");
            return ReturnWrapper.success(staffResponse);
        }
        return ReturnWrapper.failure(StaffResponse.class)
                .message(MessageWrapper.of("110", "I am {}", "a wrapper"));
    }

    @GetMapping("exception")
    public void exception(@RequestParam String level) {
        switch (level) {
            case "error":
                throw new MatrixErrorException("I am a error!").code("801");
            case "warn":
                throw new MatrixWarnException("I am a warn!").code("802");
            case "info":
                throw new MatrixInfoException("I am a info!").code("803");
            default:
                break;
        }
    }

    @GetMapping("formattedResponse")
    public FormattedResponse<?> formattedResponse(@RequestParam boolean success) {
        if (success) {
            StaffResponse staffResponse = new StaffResponse();
            staffResponse.setStaffName("name");
            return FormattedResponse.success().payload(staffResponse);
        }
        return FormattedResponse.failure().code("1001").message("a formatted error");
    }

    @GetMapping("/longPull")
    @PostMapping("/longPull")
    public DeferredResult<FormattedResponse<?>> longPull(@RequestParam Map<String, String> queryParams, @Nullable @RequestBody String body) {
        return PushUtil.INSTANCE.appendPusher(PusherType.DeferredResult, PusherKey.newInstance(queryParams, body));
    }

    @GetMapping("/longPullSender")
    public void longPullSender(@RequestParam Map<String, String> queryParams) {
        PushUtil.INSTANCE.unicast(PusherType.DeferredResult, PusherKey.newInstance(queryParams, null), queryParams.get("message"));
    }
}
