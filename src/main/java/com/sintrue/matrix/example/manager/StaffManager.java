package com.sintrue.matrix.example.manager;

import com.sintrue.matrix.example.dao.entity.StaffEntity;

/**
 * @author Liangchen.Wang 2021-10-19 16:50
 */
public interface StaffManager {
    void insert(StaffEntity domain);

    StaffEntity find(Long id);
}
