package com.sintrue.matrix.example.domain;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-09-02 14:21
 */
@Service
@DomainService
public class ExampleManager {
    private final StandaloneDao standaloneDao;

    @Inject
    public ExampleManager(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

}
