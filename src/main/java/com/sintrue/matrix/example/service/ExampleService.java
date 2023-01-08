package com.sintrue.matrix.example.service;

import com.sintrue.matrix.example.dao.entity.Example;
import com.sintrue.matrix.example.dao.entity.ExampleState;
import com.sintrue.matrix.example.service.message_pl.ExampleRequest;
import com.sintrue.matrix.example.service.message_pl.ExampleResponse;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.exception.ExceptionLevel;
import wang.liangchen.matrix.framework.commons.validation.InsertGroup;
import wang.liangchen.matrix.framework.commons.validation.UpdateGroup;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;

import java.util.Collection;
import java.util.Collections;
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
                .markDelete(Example::getState,ExampleState.DELETED)
                ._equals(Example::getStaffId, staffId);
        this.standaloneDao.delete(criteria);
    }

    public List<ExampleResponse> list(ExampleRequest request) {
        Criteria<Example> criteria = Criteria.of(Example.class)._equals(Example::getStaffId, 0L);
        this.standaloneDao.list(criteria);
        return Collections.emptyList();
    }

    public void update(ExampleRequest request) {
        ValidationUtil.INSTANCE.validate(ExceptionLevel.INFO, request, UpdateGroup.class);
        // validate primary key
        ValidationUtil.INSTANCE.notEmpty(ExceptionLevel.INFO,request.getStaffId());
        // transform to entity
        Example entity = Example.valueOf(request);
        this.standaloneDao.update(entity);
    }
}
