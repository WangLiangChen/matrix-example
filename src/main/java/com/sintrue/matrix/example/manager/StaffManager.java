package com.sintrue.matrix.example.manager;

import com.sintrue.matrix.example.dao.entity.Staff;

/**
 * @author Liangchen.Wang 2021-10-19 16:50
 */
public interface StaffManager {
    void insert(Staff domain);

    Staff find(Long id);
}
