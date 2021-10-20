package com.sintrue.matrix.example.dao.impl;

import com.sintrue.matrix.example.dao.StaffDao;
import com.sintrue.matrix.example.dao.entity.StaffEntity;
import com.sintrue.matrix.example.dao.query.StaffQuery;
import liangchen.wang.matrix.framework.data.dao.AbstractDao;
import liangchen.wang.matrix.framework.data.dao.AbstractParameterizedDao;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Liangchen.Wang 2021-10-19 16:43
 */
@Component
public class StaffDaoImpl extends AbstractParameterizedDao<StaffEntity, StaffQuery> implements StaffDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(StaffEntity entity) {
        entityManager.persist(entity);
    }

    @Override
    public StaffEntity find(Long id) {
        StaffEntity staff = entityManager.find(StaffEntity.class, id);
        return staff;
    }
}
