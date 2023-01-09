package com.sintrue.matrix.example.service;

import com.sintrue.matrix.example.dao.entity.Staff;
import com.sintrue.matrix.example.service.message_pl.StaffRequest;
import com.sintrue.matrix.example.service.message_pl.StaffResponse;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.exception.ExceptionLevel;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.validation.UpdateGroup;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import java.util.Collection;
import java.util.List;

/**
 * @author  2023-01-08 09:34:52
 */
@Service
public class StaffService {
    private final StandaloneDao standaloneDao;

    @Inject
    public StaffService(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

    public void insert(StaffRequest request) {
        // validate fields by validator
        ValidationUtil.INSTANCE.validate(ExceptionLevel.INFO, request);
        // transform to entity
        Staff entity = Staff.valueOf(request);
        // TODO Assign values to fields

        // Initialize default value which value is null
        entity.initializeFields();
        this.standaloneDao.insert(entity);
    }

    public void insert(Collection<StaffRequest> requests) {
        // validate empty by validator
        ValidationUtil.INSTANCE.notEmpty(ExceptionLevel.INFO, requests);
        // transform to entities and process every entity
        Collection<Staff> entities = Staff.valuesOf(requests, (source, target) -> {
            // TODO Assign values to fields

            // Initialize default value which value is null
            target.initializeFields();
        });
        this.standaloneDao.insert(entities);
    }

    public void delete(Long staffId) {
        DeleteCriteria<Staff> criteria = DeleteCriteria.of(Staff.class)
                // logically deleted
                // .markDelete()
                ._equals(Staff::getStaffId, staffId);
        this.standaloneDao.delete(criteria);
    }

    public void update(StaffRequest request) {
        ValidationUtil.INSTANCE.validate(ExceptionLevel.INFO, request, UpdateGroup.class);
        // validate primary key
        ValidationUtil.INSTANCE.notEmpty(ExceptionLevel.INFO, request.getStaffId());
        // transform to entity
        Staff entity = Staff.valueOf(request);
        this.standaloneDao.update(entity);
    }

    public int updateByCriteria(StaffRequest request) {
        ValidationUtil.INSTANCE.notNull(request);
        // transform to entity
        Staff entity = Staff.newInstance();
        // TODO 将要更新的字段设置到entity
        // entity.
        UpdateCriteria<Staff> criteria = UpdateCriteria.of(entity);
        // 强制更新,比如将值更新为null
        // .forceUpdate()
        // TODO 构造更新条件
        return this.standaloneDao.update(criteria);
    }

    public StaffResponse select(Long staffId) {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                // Specify the returned columns
                //.resultColumns()
                ._equals(Staff::getStaffId, staffId);
        Staff entity = this.standaloneDao.select(criteria);
        if (null == entity) {
            return null;
        }
        //transform Entity to Response
        return entity.to(StaffResponse.class);
    }

    public boolean exists(Long staffId) {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                ._equals(Staff::getStaffId, staffId);
        return this.standaloneDao.exists(criteria);
    }

    public List<StaffResponse> list(StaffRequest request) {
        Criteria<Staff> criteria = Criteria.of(Staff.class);
        // TODO 构造查询条件
        List<Staff> entities = this.standaloneDao.list(criteria);
        // return ObjectUtil.INSTANCE.copyProperties(entities, StaffResponse.class, (source, target) -> {});
        return ObjectUtil.INSTANCE.copyProperties(entities, StaffResponse.class);
    }

    public PaginationResult<StaffResponse> pagination(StaffRequest request) {
        Criteria<Staff> criteria = Criteria.of(Staff.class);
        // TODO 构造查询条件
        PaginationResult<Staff> entityPagination = this.standaloneDao.pagination(criteria);
        // transform Entity to Response
        // return entityPagination.to(StaffResponse.class, (source, target) -> {});
        return entityPagination.to(StaffResponse.class);
    }
}