package com.sintrue.matrix.example.manager;

import com.sintrue.matrix.example.dao.entity.StaffEntity;
import com.sintrue.matrix.example.dao.query.StaffQuery;
import liangchen.wang.matrix.framework.data.query.RootQuery;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Liangchen.Wang 2021-10-19 16:50
 */
public interface StaffManager {

    @Transactional
    void insert(StaffEntity entity);

    @Transactional
    void insertBatch(List<StaffEntity> entities);

    void delete(StaffEntity entity);

    @Transactional
    void deleteByQuery(RootQuery query);

    void update(StaffEntity entity);

    @Transactional
    void update(StaffEntity entity, StaffQuery query);
}
