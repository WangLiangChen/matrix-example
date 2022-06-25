package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.authorization.message_pl.AuthorizationAllowlistCommandRequest;
import com.sintrue.matrix.example.authorization.northbound_ohs.local.AuthorizationAllowlistApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.commons.uid.NanoIdUtil;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-06-15 13:59
 */
@SpringBootTest
@EnableJdbc
public class AuthorizationTest {
    @Inject
    private AuthorizationAllowlistApplicationService service;

    @Test
    public void insert() {
        AuthorizationAllowlistCommandRequest request = AuthorizationAllowlistCommandRequest.newInstance();
        request.setTenantCode("tenant_code");
        request.setAppCode("app_code");
        request.setPermissionUri("{uri}");
        request.setOwner("");
        request.setCreator("");
        request.setSummary("");
        service.insert(request);
    }

    @Test
    public void insertBatch() {
        AuthorizationAllowlistCommandRequest request;
        List<AuthorizationAllowlistCommandRequest> requestList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            request = AuthorizationAllowlistCommandRequest.newInstance();
            request.setTenantCode("tenant_code" + i);
            request.setAppCode("app_code" + i);
            request.setPermissionUri("{uri}" + i);
            request.setOwner("");
            request.setCreator("");
            request.setSummary("");
            requestList.add(request);
        }
        service.insert(requestList);

    }

    public static void main(String[] args) {
        String nanoId = NanoIdUtil.INSTANCE.randomNanoId();
        System.out.println(nanoId);
        // N54R4_mLn0-dq9AWTTsn0
    }


}

