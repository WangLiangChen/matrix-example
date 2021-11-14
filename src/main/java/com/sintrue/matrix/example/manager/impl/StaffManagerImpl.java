package com.sintrue.matrix.example.manager.impl;

import com.sintrue.matrix.example.manager.StaffManager;
import com.sintrue.matrix.example.manager.domain.StaffDomain;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

@Component
@EnableCaching
@Cacheable(value = "abc")
public class StaffManagerImpl implements StaffManager {

    @Override
    public StaffDomain find(Long staffId) {
        StaffDomain domain = new StaffDomain();
        domain.setStaffId(staffId);
        domain.setStaffName("Liangchen.Wang");
        System.out.println("-------invoke find--------");
        return domain;
    }
}
