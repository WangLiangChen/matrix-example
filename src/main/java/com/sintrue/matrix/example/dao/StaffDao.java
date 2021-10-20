package com.sintrue.matrix.example.dao;

import com.sintrue.matrix.example.dao.entity.StaffEntity;

/**
 * @author Liangchen.Wang 2021-10-19 16:37
 */
public interface StaffDao {

    void insert(StaffEntity entity);

    StaffEntity find(Long id);
}
