package com.sintrue.example.generator.ddd.hr.domain.staff;

import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.EntityGetter;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;
import wang.liangchen.matrix.framework.ddd.domain.IDomainService;
import com.sintrue.example.generator.ddd.hr.southbound_acl.port.repository.StaffRepository;
import com.sintrue.example.generator.ddd.hr.southbound_acl.port.client.StaffClient;
import com.sintrue.example.generator.ddd.hr.southbound_acl.port.publisher.StaffPublisher;
import com.sintrue.example.generator.ddd.hr.southbound_acl.port.file.StaffFile;
import com.sintrue.example.generator.ddd.hr.southbound_acl.port.oss.StaffOSS;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
/**
 * @author  2023-05-06 16:39:10
 */
@Service
@DomainService
public class StaffManager implements IDomainService {
    private final StaffRepository repository;
    private final StaffClient client;
    private final StaffPublisher publisher;
    private final StaffFile file;
    private final StaffOSS oss;
    @Inject
    public StaffManager(StaffRepository repository, StaffClient client, StaffPublisher publisher, StaffFile file, StaffOSS oss) {
        this.repository = repository;
        this.client = client;
        this.publisher = publisher;
        this.file = file;
        this.oss = oss;
    }

    public int create(Staff entity) {
        return this.repository.create(entity);
    }

    public int create(Collection<Staff> entities) {
        return this.repository.create(entities);
    }

    public int delete(Long staffId) {
        return this.repository.delete(staffId);
    }

    public int delete(DeleteCriteria<Staff> criteria) {
        return this.repository.delete(criteria);
    }

    public int update(Staff entity) {
        return this.repository.update(entity);
    }

    public int update(UpdateCriteria<Staff> criteria) {
        return this.repository.update(criteria);
    }

    public Optional<Staff> find(Long staffId, EntityGetter<Staff>... resultFields) {
        return this.repository.find(staffId, resultFields);
    }

    public List<Staff> find(Criteria<Staff> criteria) {
        return this.repository.find(criteria);
    }

    public PaginationResult<Staff> pagination(Criteria<Staff> criteria) {
        return this.repository.pagination(criteria);
    }

    public int stateTransfer(Long staffId, String to, String... from) {
        return this.repository.stateTransfer(staffId, to,from);
    }

    public List<Staff> byStates(String... states) {
        return this.repository.byStates(states);
    }
}