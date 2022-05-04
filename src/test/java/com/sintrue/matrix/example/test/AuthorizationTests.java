package com.sintrue.matrix.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.util.EntityPrototypeUtil;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectRequest;
import wang.liangchen.matrix.iam.authorization.northbound_ohs.local.AuthorizationApplicationService;

import javax.inject.Inject;

@SpringBootTest
public class AuthorizationTests {
    @Inject
    private AuthorizationApplicationService service;


    @Test
    public void testAdd() {
        AuthorizationSubjectRequest request = new AuthorizationSubjectRequest();
        request.setTenantCode("tenant")
                .setAppCode("app")
                .setSubjectOrigin("self")
                .setSubjectCode("wanglc");
        service.addAuthorizationSubject(request);
    }


}
