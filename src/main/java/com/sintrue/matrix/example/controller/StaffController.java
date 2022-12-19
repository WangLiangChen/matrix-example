package com.sintrue.matrix.example.controller;

import com.sintrue.matrix.example.service.staff.StaffCommandRequest;
import com.sintrue.matrix.example.service.staff.StaffResponse;
import com.sintrue.matrix.example.service.staff.StaffService;
import jakarta.inject.Inject;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.exception.MatrixWarnException;
import wang.liangchen.matrix.framework.commons.runtime.MessageWrapper;
import wang.liangchen.matrix.framework.commons.runtime.ReturnWrapper;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
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
    private final StaffService staffService;

    @Inject
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * 格式化空值，一般用于行为请求.如新增、删除
     * request:
     * {"staffName": "wanglc","summary": "I am a add summary","staffSettings": {"gender": "male"}}
     * response:
     * {"success":true,"level":"OFF","code":null,"message":null,"i18n":null,"locale":null,"payload":null,"requestId":"add_request","debug":null}
     * exception:
     * {"success":false,"level":"INFO","code":null,"message":"不能为空(staffName);不能为空(summary);","i18n":null,"locale":null,"payload":{},"requestId":"add_request","debug":null}
     */
    @PostMapping("add")
    public void add(@RequestBody StaffCommandRequest request) {
        staffService.insert(request);
    }

    /**
     * 格式化直接对象
     * response:
     * {"success":true,"level":"OFF","code":null,"message":null,"i18n":null,"locale":null,"payload":{"staffId":"453077515599085669","staffName":"wanglc_42","staffSettings":{"gender":"male"},"creator":"","createDatetime":"2022-12-13 15:20:43","state":"ACTIVE"},"requestId":"null","debug":null}
     * @return
     */
    @GetMapping("anyOne")
    public StaffResponse anyOne() {
        return staffService.anyOne();
    }

    /**
     * 使用ReturnWarpper处理流程，用于用户显式封装正常或异常的返回
     *
     * @param success
     * @return ReturnMapper
     */
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

    /**
     * 使用异常处理流程，全局处理并格式化异常
     *
     * @param level exception level
     */
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

    @GetMapping("pagination")
    public PaginationResult<StaffResponse> pagination() {
        return staffService.pagination();
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

    /**
     * 支持sse和deferredResult方式的长轮询
     *
     * @param queryParams
     * @param body
     * @return
     */

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
