package com.sintrue.matrix.example.manager.impl;

import com.sintrue.matrix.example.dao.entity.StaffEntity;
import com.sintrue.matrix.example.dao.query.StaffQuery;
import com.sintrue.matrix.example.manager.StaffManager;
import liangchen.wang.matrix.framework.data.annotation.DataSource;
import liangchen.wang.matrix.framework.data.annotation.DataSourceSwitchable;
import liangchen.wang.matrix.framework.data.dao.StandaloneDao;
import liangchen.wang.matrix.framework.data.pagination.PaginationResult;
import liangchen.wang.matrix.framework.data.query.RootQuery;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Liangchen.Wang 2021-10-19 16:51
 */
@Component
@DataSourceSwitchable
public class StaffManagerImpl implements StaffManager {
    private final StandaloneDao standaloneDao;

    @Inject
    public StaffManagerImpl(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

    @Transactional
    @DataSource("one")
    @Override
    public void insert(StaffEntity entity) {
        standaloneDao.insert(entity);
    }

    @Transactional
    @Override
    public void insertBatch(List<StaffEntity> entities) {
        standaloneDao.insertBatch(entities);
    }

    @Override
    @Transactional
    public void delete(StaffEntity entity) {
        standaloneDao.delete(entity);
    }

    @Override
    @Transactional
    public void deleteByQuery(RootQuery query) {
        standaloneDao.deleteByQuery(query);
    }

    @Transactional
    @Override
    public void update(StaffEntity entity) {
        standaloneDao.update(entity);
    }

    @Transactional
    @Override
    public void update(StaffEntity entity, StaffQuery query) {
        standaloneDao.updateByQuery(entity, query);
    }

    @Override
    public List<StaffEntity> list(StaffQuery query, String... returnFields) {
        return standaloneDao.list(StaffEntity.class, query, returnFields);
    }

    @Override
    public int count(StaffQuery query) {
        return standaloneDao.count(query);
    }

    @Override
    public PaginationResult<StaffEntity> pagination(StaffQuery query, String... columns) {
        return standaloneDao.pagination(StaffEntity.class, query, columns);
    }
}
