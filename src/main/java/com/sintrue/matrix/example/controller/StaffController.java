package com.sintrue.matrix.example.controller;

import com.sintrue.matrix.example.domain.Staff;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.exception.MatrixWarnException;
import wang.liangchen.matrix.framework.web.response.FormattedResponse;

/**
 * @author Liangchen.Wang 2022-09-07 15:25
 */

@RestController
@RequestMapping("staff")
public class StaffController {

    @GetMapping("/object")
    public Staff object() {
        Staff staff = new Staff();
        staff.setStaffId(999999999999999999L);
        return staff;
    }

    @GetMapping("/void")
    public void voidMethod() {
    }

    @GetMapping("/success")
    public FormattedResponse success() {
        Staff staff = new Staff();
        staff.setStaffId(1000L);
        return FormattedResponse.success().payload(staff);
    }

    @GetMapping("/failure")
    public FormattedResponse failure() {
        Staff staff = new Staff();
        staff.setStaffId(0L);
        return FormattedResponse.failure().payload(staff);
    }

    @GetMapping("/exceptionError")
    public void exceptionError() {
        throw new MatrixErrorException("I am Error Exception");
    }

    @GetMapping("/exceptionInfo")
    public void exceptionInfo() {
        throw new MatrixInfoException("I am Info Exception");
    }

    @GetMapping("/exceptionWarn")
    public void exceptionWarn() {
        throw new MatrixWarnException("I am Warn Exception");
    }

}
