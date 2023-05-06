package com.sintrue.example.generator.ddd.hr.southbound_acl.port.repository;

import com.sintrue.example.generator.ddd.hr.domain.staff.Staff;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.EntityGetter;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.southbound_acl.port.IRepositoryPort;
import wang.liangchen.matrix.framework.ddd.southbound_acl.port.Port;
import wang.liangchen.matrix.framework.ddd.southbound_acl.port.PortType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
/**
 * @author  2023-05-06 16:39:10
 */
@Port(PortType.Repository)
public interface StaffRepository extends IRepositoryPort {

    int create(Staff entity);

    int create(Collection<Staff> entities);

    int delete(Long staffId);

    int delete(DeleteCriteria<Staff> criteria);

    int update(Staff entity);

    int update(UpdateCriteria<Staff> criteria);

    Optional<Staff> find(Long staffId, EntityGetter<Staff>... resultFields);

    List<Staff> find(Criteria<Staff> criteria);

    PaginationResult<Staff> pagination(Criteria<Staff> criteria);

    int stateTransfer(Long staffId, String to, String... from);

    List<Staff> byStates(String... states);
}