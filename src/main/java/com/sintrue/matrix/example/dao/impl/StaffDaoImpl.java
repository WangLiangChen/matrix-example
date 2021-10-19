package com.sintrue.matrix.example.dao.impl;

import com.sintrue.matrix.example.dao.StaffDao;
import com.sintrue.matrix.example.dao.entity.Staff;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

/**
 * @author Liangchen.Wang 2021-10-19 16:43
 */
@Component
public class StaffDaoImpl implements StaffDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(Staff entity) {
        entityManager.persist(entity);
    }

    @Override
    public Staff find(Long id) {
        Staff staff = entityManager.find(Staff.class, id);
        return staff;
    }
}
