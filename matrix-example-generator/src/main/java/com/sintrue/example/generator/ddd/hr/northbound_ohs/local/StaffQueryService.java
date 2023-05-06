package com.sintrue.example.generator.ddd.hr.northbound_ohs.local;

import com.sintrue.example.generator.ddd.hr.domain.staff.Staff;
import com.sintrue.example.generator.ddd.hr.domain.staff.StaffManager;
import com.sintrue.example.generator.ddd.hr.northbound_ohs.message_pl.StaffQueryRequest;
import com.sintrue.example.generator.ddd.hr.northbound_ohs.message_pl.StaffQueryResponse;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.EntityGetter;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.local.ApplicationService;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.local.IApplicationService;

import java.util.List;
import java.util.Optional;
/**
* @author Liangchen.Wang 2023-03-12 10:00
*/
@Service
@ApplicationService
public class StaffQueryService implements IApplicationService {
    private final StaffManager manager;

    @Inject
    public StaffQueryService(StaffManager manager) {
        this.manager = manager;
    }

    public StaffQueryResponse find(Long staffId) {
        EntityGetter<Staff>[] resultFields = new EntityGetter[0];
        Optional<Staff> optional = this.manager.find(staffId, resultFields);
        return optional.map(entity -> entity.to(StaffQueryResponse.class)).orElse(null);
    }

    public List<StaffQueryResponse> find(StaffQueryRequest request) {
        Criteria<Staff> criteria = Criteria.of(Staff.class);
        List<Staff> entities = this.manager.find(criteria);
        return ObjectUtil.INSTANCE.copyProperties(entities, StaffQueryResponse.class);
    }

    public PaginationResult<StaffQueryResponse> pagination(StaffQueryRequest request) {
        Criteria<Staff> criteria = Criteria.of(Staff.class);
        PaginationResult<Staff> pagination = this.manager.pagination(criteria);
        return pagination.to(StaffQueryResponse.class);
    }
    public List<Staff> byStates(String... states) {
        return this.manager.byStates(states);
    }
}