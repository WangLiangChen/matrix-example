package com.sintrue.matrix.example.authorization.northbound_ohs.local;

import com.sintrue.matrix.example.authorization.message_pl.AuthorizationAllowlistRequest;
import com.sintrue.matrix.example.authorization.southbound_acl.port.repository.AuthorizationAllowlistRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-06-15 8:17
 */
@Service
public class AuthorizationAllowlistApplicationService {
    private final AuthorizationAllowlistRepository authorizationAllowlistRepository;

    @Inject
    public AuthorizationAllowlistApplicationService(AuthorizationAllowlistRepository authorizationAllowlistRepository) {
        this.authorizationAllowlistRepository = authorizationAllowlistRepository;
    }
    public void insert(AuthorizationAllowlistRequest authorizationAllowlistRequest){

    }

}
