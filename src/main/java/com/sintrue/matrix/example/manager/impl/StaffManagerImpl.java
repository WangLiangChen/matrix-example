package com.sintrue.matrix.example.manager.impl;

import com.sintrue.matrix.example.dao.StaffDao;
import com.sintrue.matrix.example.dao.entity.Staff;
import com.sintrue.matrix.example.manager.StaffManager;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * @author Liangchen.Wang 2021-10-19 16:51
 */
@Component
public class StaffManagerImpl implements StaffManager {
    private final StaffDao dao;

    @Inject
    public StaffManagerImpl(StaffDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void insert(Staff domain) {
        dao.insert(domain);
    }

    @Override
    @Transactional
    public Staff find(Long id) {
        Staff staff = dao.find(id);
        return staff;
    }
}
