package com.sintrue.matrix.example.hr.domain.staff;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.enumeration.ConstantEnum;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;

import javax.inject.Inject;
import java.util.List;


/**
 * @author Liangchen.Wang
 */
@Service
@DomainService
public class StaffManager {
    private final StandaloneDao repository;

    @Inject
    public StaffManager(StandaloneDao repository) {
        this.repository = repository;
    }

    public int add(Staff entity) {
        return repository.insert(entity);
    }

    public int delete(Long staffId) {
        Staff entity = Staff.newInstance();
        entity.setStaffId(staffId);
        return repository.delete(entity);
    }

    public int update(Staff entity) {
        return repository.update(entity);
    }

    public Staff byKey(Long staffId, String... resultColumns) {
        return repository.select(Criteria.of(Staff.class)
                .resultColumns(resultColumns)
                ._equals(Staff::getStaffId, staffId))
                ;
    }

    public void stateTransition(Long staffId, String to, String... from) {
        Staff entity = Staff.newInstance();
        entity.setState(to);
        UpdateCriteria<Staff> updateCriteria = UpdateCriteria.of(entity)
                ._equals(Staff::getStaffId, staffId)
                ._in(Staff::getState, from);
        repository.update(updateCriteria);
    }

    public List<Staff> byStates(String... states) {
        return repository.list(Criteria.of(Staff.class)._in(Staff::getState, states));
    }
}