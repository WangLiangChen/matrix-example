package com.sintrue.matrix.example.authorization.southbound_acl.adapter.repository;

import com.sintrue.matrix.example.authorization.domain.AuthorizationAllowlist;
import com.sintrue.matrix.example.authorization.southbound_acl.port.repository.AuthorizationAllowlistRepository;
import org.springframework.stereotype.Repository;
import wang.liangchen.matrix.framework.data.dao.AbstractParameterizedDao;

/**
 * @author Liangchen.Wang 2022-06-15 7:46
 */
@Repository
public class AuthorizationAllowlistRepositoryAdapter extends AbstractParameterizedDao<AuthorizationAllowlist> implements AuthorizationAllowlistRepository {

}
