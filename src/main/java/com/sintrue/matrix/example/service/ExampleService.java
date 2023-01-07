package com.sintrue.matrix.example.service;

import com.sintrue.matrix.example.dao.entity.Example;
import com.sintrue.matrix.example.service.message_pl.ExampleRequest;
import com.sintrue.matrix.example.service.message_pl.ExampleResponse;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.exception.ExceptionLevel;
import wang.liangchen.matrix.framework.commons.validation.InsertGroup;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;

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
        // init default value which value is null
        entity.initializeFields();
        this.standaloneDao.insert(entity);
    }

    public List<ExampleResponse> list(ExampleRequest request) {
        Criteria<Example> criteria = Criteria.of(Example.class)._equals(Example::getStaffId, 0L);
        this.standaloneDao.list(criteria);
        return Collections.emptyList();
    }
}
