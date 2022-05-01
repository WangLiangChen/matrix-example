package com.sintrue.matrix.example.test;

import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectRequest;

public class AuthorTests {
    public static void main(String[] args) {
        AuthorizationSubjectRequest request = new AuthorizationSubjectRequest();
        ValidationUtil.INSTANCE.validate(request);
    }
}
