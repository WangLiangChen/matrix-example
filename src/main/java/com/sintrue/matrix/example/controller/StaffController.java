package com.sintrue.matrix.example.controller;

import com.sintrue.matrix.example.service.StaffService;
import com.sintrue.matrix.example.service.message_pl.StaffRequest;
import com.sintrue.matrix.example.service.message_pl.StaffResponse;
import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.*;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import java.util.List;

/**
 * @author  2023-01-06 14:20:03
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffService service;

    @Inject
    public StaffController(StaffService service) {
        this.service = service;
    }

    @PostMapping("/insert")
    public void insert(@RequestBody StaffRequest request) {
        service.insert(request);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Long staffId) {
        service.delete(staffId);
    }

    @PostMapping("/update")
    public void update(@RequestBody StaffRequest request) {
        service.update(request);
    }

    @PostMapping("/updateByCriteria")
    public void updateByCriteria(@RequestBody StaffRequest request) {
        service.updateByCriteria(request);
    }

    @GetMapping("/select")
    public StaffResponse select(@RequestParam Long staffId) {
        return service.select(staffId);
    }

    @PostMapping("/list")
    public List<StaffResponse> list(@RequestBody StaffRequest request) {
        return service.list(request);
    }

    @PostMapping("/pagination")
    public PaginationResult<StaffResponse> pagination(@RequestBody StaffRequest request) {
        return service.pagination(request); 
    }
}