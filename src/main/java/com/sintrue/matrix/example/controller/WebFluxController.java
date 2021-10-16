package com.sintrue.matrix.example.controller;

import com.sintrue.matrix.example.domain.Staff;
import liangchen.wang.matrix.framework.web.annotation.FormattedResponseIgnore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2021-10-09 15:43
 */
@RestController
@RequestMapping("/webflux")
public class WebFluxController {
    @GetMapping("staff")
    @FormattedResponseIgnore
    public Staff staff() {
        Staff staff = new Staff();
        staff.setStaffId(1111111111111111111L);
        staff.setStaffName("name" + staff.getStaffId());
        staff.setBirthday(LocalDateTime.now());
        return staff;
    }


    @GetMapping("staffList")
    public List<Staff> staffList() {
        List<Staff> list = new ArrayList<>();
        Staff staff = new Staff();
        staff.setStaffId(1111111111111111111L);
        staff.setStaffName("name" + staff.getStaffId());
        staff.setBirthday(LocalDateTime.now());
        list.add(staff);

        staff = new Staff();
        staff.setStaffId(1111111111111111112L);
        staff.setStaffName("name" + staff.getStaffId());
        staff.setBirthday(LocalDateTime.now());
        list.add(staff);
        return list;
    }

    @GetMapping("staffMono")
    @FormattedResponseIgnore
    public Mono<Staff> staffMono() {
        Staff staff = new Staff();
        staff.setStaffId(1111111111111111111L);
        staff.setStaffName("name" + staff.getStaffId());
        staff.setBirthday(LocalDateTime.now());
        return Mono.just(staff);
    }


    @GetMapping("staffFlux")
    public Flux<Staff> staffFlux() {
        List<Staff> list = new ArrayList<>();
        Staff staff = new Staff();
        staff.setStaffId(1111111111111111111L);
        staff.setStaffName("name" + staff.getStaffId());
        staff.setBirthday(LocalDateTime.now());
        list.add(staff);

        staff = new Staff();
        staff.setStaffId(1111111111111111112L);
        staff.setStaffName("name" + staff.getStaffId());
        staff.setBirthday(LocalDateTime.now());
        list.add(staff);
        return Flux.fromStream(list.parallelStream());
    }
}
