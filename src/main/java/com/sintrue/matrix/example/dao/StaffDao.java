package com.sintrue.matrix.example.dao;

import com.sintrue.matrix.example.dao.entity.Staff;

/**
 * @author Liangchen.Wang 2021-10-19 16:37
 */
public interface StaffDao {

    void insert(Staff entity);

    Staff find(Long id);
}
