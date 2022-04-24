package com.sintrue.matrix.example.account.northbound_ohs.remote.controller;

import com.sintrue.matrix.example.account.northbound_ohs.local.AccountApplicationService;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.Remote;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.RemoteType;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-04-24 14:15
 */
@Remote(RemoteType.Controller)
public class AccountController {
    private final AccountApplicationService accountApplicationService;

    @Inject
    public AccountController(AccountApplicationService accountApplicationService) {
        this.accountApplicationService = accountApplicationService;
    }
}
