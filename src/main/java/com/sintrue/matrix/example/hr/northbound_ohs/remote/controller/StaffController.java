package com.sintrue.matrix.example.hr.northbound_ohs.remote.controller;

import com.sintrue.matrix.example.hr.domain.staff.Staff;
import com.sintrue.matrix.example.hr.message_pl.north.StaffRequest;
import com.sintrue.matrix.example.hr.northbound_ohs.local.StaffService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-10-11 11:29
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    /**
     * 推荐构造器注入
     * 推荐使用@inject
     */
    private final StaffService staffService;

    @Inject
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * Restful Get
     * 对象，直接序列化为特定的JSON格式
     *
     * @param staffId staffId
     * @return Staff By ID
     */
    @GetMapping("/{staffId}")
    public Staff get(@PathVariable Long staffId) {
        return this.staffService.byKey(staffId);
    }

    /**
     * Restful Post
     * void，直接序列化为特定的JSON格式
     */
    @PostMapping
    public void add(@RequestBody StaffRequest staffRequest) {
        this.staffService.add(staffRequest);
    }

}
