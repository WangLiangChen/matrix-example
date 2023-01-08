package com.sintrue.matrix.example.service;

import com.sintrue.matrix.example.dao.entity.Example;
import com.sintrue.matrix.example.dao.entity.ExampleState;
import com.sintrue.matrix.example.dao.entity.Staff;
import com.sintrue.matrix.example.service.message_pl.ExampleRequest;
import com.sintrue.matrix.example.service.message_pl.ExampleResponse;
import com.sintrue.matrix.example.service.message_pl.StaffRequest;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.exception.ExceptionLevel;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.validation.InsertGroup;
import wang.liangchen.matrix.framework.commons.validation.UpdateGroup;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import java.util.Collection;
import java.util.List;

@Service
public class ExampleService {
    private final StandaloneDao standaloneDao;

    public ExampleService(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

    public void insert(ExampleRequest request) {
        // validate field by validator
        ValidationUtil.INSTANCE.validate(ExceptionLevel.INFO, request, InsertGroup.class);
        // transform to entity
        Example entity = Example.valueOf(request);
        entity.setState(ExampleState.CURRENT);
        // Initialize default value which value is null
        entity.initializeFields();
        this.standaloneDao.insert(entity);
    }

    public void insert(Collection<ExampleRequest> requests) {
        // validate empty
        ValidationUtil.INSTANCE.notEmpty(ExceptionLevel.INFO, requests);
        // transform to entities and process every entity
        Collection<Example> entities = Example.valuesOf(requests, (source, target) -> {
            target.setState(ExampleState.CURRENT);
            target.initializeFields();
        });
        this.standaloneDao.insert(entities);
    }

    public void delete(Long staffId) {
        DeleteCriteria<Example> criteria = DeleteCriteria.of(Example.class)
                // logically deleted
                .markDelete(Example::getState, ExampleState.DELETED)
                ._equals(Example::getStaffId, staffId);
        this.standaloneDao.delete(criteria);
    }

    public void update(ExampleRequest request) {
        ValidationUtil.INSTANCE.validate(ExceptionLevel.INFO, request, UpdateGroup.class);
        // validate primary key
        ValidationUtil.INSTANCE.notEmpty(ExceptionLevel.INFO, request.getStaffId());
        // transform to entity
        Example entity = Example.valueOf(request);
        // Two ways to set columns that force updates, such as updating to null
        // entity.addForceUpdateColumn();
        // entity.addExtendedField();
        this.standaloneDao.update(entity);
    }

    public int updateByCriteria(ExampleRequest request) {
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

    public ExampleResponse select(Long staffId) {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                // Specify the returned columns
                //.resultColumns()
                ._equals(Staff::getStaffId, staffId);
        Staff entity = this.standaloneDao.select(criteria);
        if (null == entity) {
            return null;
        }
        //transform Entity to Response
        return entity.to(ExampleResponse.class);
    }

    public boolean exists(Long staffId) {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                ._equals(Staff::getStaffId, staffId);
        return this.standaloneDao.exists(criteria);
    }

    public List<ExampleResponse> list(ExampleRequest request) {
        Criteria<Example> criteria = Criteria.of(Example.class);
        // TODO 构造查询条件
        List<Example> entities = this.standaloneDao.list(criteria);
        // return ObjectUtil.INSTANCE.copyProperties(entities, StaffResponse.class, (source, target) -> {});
        return ObjectUtil.INSTANCE.copyProperties(entities, ExampleResponse.class);
    }

    public PaginationResult<ExampleResponse> pagination(StaffRequest request) {
        Criteria<Staff> criteria = Criteria.of(Staff.class);
        // TODO 构造查询条件
        PaginationResult<Staff> entityPagination = this.standaloneDao.pagination(criteria);
        // transform Entity to Response
        // return entityPagination.to(StaffResponse.class, (source, target) -> {});
        return entityPagination.to(ExampleResponse.class);
    }
}
