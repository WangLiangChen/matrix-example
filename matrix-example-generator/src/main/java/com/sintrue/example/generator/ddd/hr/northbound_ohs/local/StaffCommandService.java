package com.sintrue.example.generator.ddd.hr.northbound_ohs.local;

import com.sintrue.example.generator.ddd.hr.domain.staff.Staff;
import com.sintrue.example.generator.ddd.hr.domain.staff.StaffManager;
import com.sintrue.example.generator.ddd.hr.northbound_ohs.message_pl.StaffCommandRequest;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.validation.InsertGroup;
import wang.liangchen.matrix.framework.commons.validation.UpdateGroup;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.local.ApplicationService;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.local.IApplicationService;

import java.util.Collection;
/**
* @author  2023-05-06 16:39:10
*/
@Service
@ApplicationService
public class StaffCommandService implements IApplicationService {
    private final StaffManager manager;

    @Inject
    public StaffCommandService(StaffManager manager) {
        this.manager = manager;
    }

    public int create(StaffCommandRequest request) {
        ValidationUtil.INSTANCE.validate(request, InsertGroup.class);
        Staff entity = Staff.valueOf(request);
        return this.manager.create(entity);
    }

    public int create(Collection<StaffCommandRequest> requests) {
        Collection<Staff> entities = Staff.valuesOf(requests, Staff.class);
        return this.manager.create(entities);
    }

    public int delete(Long staffId) {
        return this.manager.delete(staffId);
    }

    public int delete(StaffCommandRequest request) {
        DeleteCriteria<Staff> criteria = DeleteCriteria.of(Staff.class);
        return this.manager.delete(criteria);
    }

    public int update(StaffCommandRequest request) {
        ValidationUtil.INSTANCE.validate(request, UpdateGroup.class);
        Staff entity = Staff.valueOf(request);
        return this.manager.update(entity);
    }

    public int updateMatching(StaffCommandRequest request) {
        ValidationUtil.INSTANCE.validate(request, UpdateGroup.class);
        UpdateCriteria<Staff> criteria = UpdateCriteria.of(Staff.class);
        return this.manager.update(criteria);
    }
}