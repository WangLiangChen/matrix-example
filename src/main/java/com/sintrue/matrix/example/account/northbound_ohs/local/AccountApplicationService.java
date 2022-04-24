package com.sintrue.matrix.example.account.northbound_ohs.local;

import com.sintrue.matrix.example.account.domain.AccountDomainService;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.Local;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-04-24 14:15
 * 事务等横切关注点在这一层
 */
@Local
@Service
public class AccountApplicationService {
    private final AccountDomainService accountDomainService;

    @Inject
    public AccountApplicationService(AccountDomainService accountDomainService) {
        this.accountDomainService = accountDomainService;
    }
}
