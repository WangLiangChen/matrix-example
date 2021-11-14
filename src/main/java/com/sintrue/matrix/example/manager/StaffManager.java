package com.sintrue.matrix.example.manager;

import com.sintrue.matrix.example.manager.domain.StaffDomain;

public interface StaffManager {
    StaffDomain find(Long staffId);
}
