package com.sintrue.matrix.example.account.southbound_acl.adapter.repository;

import com.sintrue.matrix.example.account.southbound_acl.port.repository.AccountRepository;
import org.springframework.stereotype.Repository;
import wang.liangchen.matrix.framework.ddd.southbound_acl.Adapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.PortType;

/**
 * @author Liangchen.Wang 2022-04-24 14:38
 */
@Adapter(PortType.Repository)
@Repository
public class AccountRepositoryAdapter implements AccountRepository {
}
