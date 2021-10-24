package com.sintrue.matrix.example.manager.impl;

import com.sintrue.matrix.example.dao.entity.StaffEntity;
import com.sintrue.matrix.example.manager.StaffManager;
import liangchen.wang.matrix.framework.data.annotation.DataSource;
import liangchen.wang.matrix.framework.data.annotation.DataSourceSwitchable;
import liangchen.wang.matrix.framework.data.dao.StandaloneCommandDao;
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
    private final StandaloneCommandDao standaloneCommandDao;

    @Inject
    public StaffManagerImpl(StandaloneCommandDao standaloneCommandDao) {
        this.standaloneCommandDao = standaloneCommandDao;
    }

    @Transactional
    @Override
    public void insert(StaffEntity entity) {
        standaloneCommandDao.insert(entity);
    }

    @Transactional
    @Override
    public void insertBatch(List<StaffEntity> entities) {
        standaloneCommandDao.insertBatch(entities);
    }

    @Override
    @Transactional
    public void delete(StaffEntity staff) {

    }
}
