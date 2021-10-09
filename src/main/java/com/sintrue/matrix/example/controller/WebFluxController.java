package com.sintrue.matrix.example.controller;

import com.sintrue.matrix.example.domain.Staff;
import liangchen.wang.matrix.framework.web.response.FormattedResponse;
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
    @GetMapping("/staff")
    public Staff staff() {
        Staff staff = new Staff();
        staff.setStaffId(1234567890098765432L);
        staff.setStaffName("staff");
        staff.setBirthday(LocalDateTime.now());
        return staff;
    }

    @GetMapping("/staffList")
    public List<Staff> staffList() {
        List<Staff> staffList = new ArrayList<Staff>() {{
            Staff staff = new Staff();
            staff.setStaffId(1234567890098765432L);
            staff.setStaffName("staff");
            staff.setBirthday(LocalDateTime.now());
            add(staff);
            staff = new Staff();
            staff.setStaffId(1234567890098765433L);
            staff.setStaffName("staff");
            staff.setBirthday(LocalDateTime.now());
            add(staff);
        }};
        return staffList;
    }

    @GetMapping("/staffMono")
    public Mono<Staff> staffMono() {
        Staff staff = new Staff();
        staff.setStaffId(1234567890098765432L);
        staff.setStaffName("staff");
        staff.setBirthday(LocalDateTime.now());
        return Mono.just(staff);
    }

    @GetMapping("/staffFlux")
    public Flux<Staff> staffFlux() {
        List<Staff> staffList = new ArrayList<Staff>() {{
            Staff staff = new Staff();
            staff.setStaffId(1234567890098765432L);
            staff.setStaffName("staff");
            staff.setBirthday(LocalDateTime.now());
            add(staff);
            staff = new Staff();
            staff.setStaffId(1234567890098765433L);
            staff.setStaffName("staff");
            staff.setBirthday(LocalDateTime.now());
            add(staff);
        }};
        return Flux.just(staffList.toArray(new Staff[staffList.size()]));
    }

    @GetMapping("/staffResponseEntity")
    public FormattedResponse staffResponseEntity() {
        Staff staff = new Staff();
        staff.setStaffId(1234567890098765432L);
        staff.setStaffName("staff");
        staff.setBirthday(LocalDateTime.now());
        return FormattedResponse.success().payload(staff);
    }

    @GetMapping("/staffResponseEntityList")
    public List<FormattedResponse<Staff>> staffResponseEntityList() {
        List<FormattedResponse<Staff>> staffList = new ArrayList<FormattedResponse<Staff>>() {{
            Staff staff = new Staff();
            staff.setStaffId(1234567890098765432L);
            staff.setStaffName("staff");
            staff.setBirthday(LocalDateTime.now());
            add(FormattedResponse.success().payload(staff));
            staff = new Staff();
            staff.setStaffId(1234567890098765433L);
            staff.setStaffName("staff");
            staff.setBirthday(LocalDateTime.now());
            add(FormattedResponse.success().payload(staff));
        }};
        return staffList;
    }

    @GetMapping("/staffResponseEntityMono")
    public Mono<FormattedResponse> staffResponseEntityMono() {
        Staff staff = new Staff();
        staff.setStaffId(1234567890098765432L);
        staff.setStaffName("staff");
        staff.setBirthday(LocalDateTime.now());
        return Mono.just(FormattedResponse.success().payload(staff));
    }
}
