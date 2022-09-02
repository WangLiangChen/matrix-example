package com.sintrue.matrix.example.domain;

import com.sintrue.matrix.example.service.StaffRequest;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;

import javax.inject.Inject;
import java.util.List;

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

    public void add(Staff staff) {
        standaloneDao.insert(staff);
    }

    public PaginationResult<Staff> pagination(StaffRequest staffRequest) {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                ._startWith(Staff::getStaffText, staffRequest.getStaffText());
        return standaloneDao.pagination(criteria);
    }

    public List<Staff> list(StaffRequest staffRequest) {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                ._startWith(Staff::getStaffText, staffRequest.getStaffText());
        return standaloneDao.list(criteria);
    }

    public Staff find(Long staffId) {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                ._equals(Staff::getStaffId, SqlValue.of(staffId));
        return standaloneDao.select(criteria);
    }

}
