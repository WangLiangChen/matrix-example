package com.sintrue.example.generator.ddd.hr.southbound_acl.adapter.repository;


import com.sintrue.example.generator.ddd.hr.domain.staff.Staff;
import com.sintrue.example.generator.ddd.hr.southbound_acl.port.repository.StaffRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Repository;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.EntityGetter;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.southbound_acl.adapter.Adapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.adapter.IRepositoryAdapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.port.PortType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
/**
 * @author  2023-05-06 16:39:10
 */
@Repository
@Adapter(PortType.Repository)
public class StaffRepositoryImpl implements StaffRepository, IRepositoryAdapter {
    private final StandaloneDao standaloneDao;

    @Inject
    public StaffRepositoryImpl(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

    @Override
    public int create(Staff entity) {
        return this.standaloneDao.insert(entity);
    }

    @Override
    public int create(Collection<Staff> entities) {
        return this.standaloneDao.insert(entities);
    }

    @Override
    public int delete(Long staffId) {
        DeleteCriteria<Staff> criteria = DeleteCriteria.of(Staff.class)
                ._equals(Staff::getStaffId, staffId);
        return this.standaloneDao.delete(criteria);
    }

    @Override
    public int delete(DeleteCriteria<Staff> criteria) {
        return this.standaloneDao.delete(criteria);
    }

    @Override
    public int update(Staff entity) {
        return this.standaloneDao.update(entity);
    }

    @Override
    public int update(UpdateCriteria<Staff> criteria) {
        return this.standaloneDao.update(criteria);
    }

    @Override
    public Optional<Staff> find(Long staffId, EntityGetter<Staff>... resultFields) {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                .resultFields(resultFields)
                ._equals(Staff::getStaffId, staffId);
         return Optional.ofNullable(this.standaloneDao.select(criteria));
    }

    @Override
    public List<Staff> find(Criteria<Staff> criteria) {
        return this.standaloneDao.list(criteria);
    }

    @Override
    public PaginationResult<Staff> pagination(Criteria<Staff> criteria) {
        return this.standaloneDao.pagination(criteria);
    }

    @Override
    public int stateTransfer(Long staffId, String to, String... from) {
        Staff entity = Staff.newInstance();
        entity.setState(to);
        UpdateCriteria<Staff> updateCriteria = UpdateCriteria.of(entity)
                ._equals(Staff::getStaffId, staffId)
                ._in(Staff::getState, from);
        return this.standaloneDao.update(updateCriteria);
    }

    @Override
    public List<Staff> byStates(String... states) {
        return this.standaloneDao.list(Criteria.of(Staff.class)._in(Staff::getState, states));
    }
}