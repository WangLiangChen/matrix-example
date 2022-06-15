package com.sintrue.matrix.example.authorization.northbound_ohs.local;

import com.sintrue.matrix.example.authorization.domain.AuthorizationAllowlist;
import com.sintrue.matrix.example.authorization.message_pl.AuthorizationAllowlistCommandRequest;
import com.sintrue.matrix.example.authorization.southbound_acl.port.repository.AuthorizationAllowlistRepository;
import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.string.StringUtil;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;
import wang.liangchen.matrix.framework.data.enumeration.DataMode;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

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

    public void insert(AuthorizationAllowlistCommandRequest authorizationAllowlistCommandRequest) {
        AuthorizationAllowlist entity = AuthorizationAllowlist.valueOf(authorizationAllowlistCommandRequest);
        populateEntity(entity);
        authorizationAllowlistRepository.insert(entity);
    }

    public void insert(Collection<AuthorizationAllowlistCommandRequest> authorizationAllowlistCommandRequests) {
        List<AuthorizationAllowlist> entities = ObjectUtil.INSTANCE.copyProperties(authorizationAllowlistCommandRequests, AuthorizationAllowlist.class, this::populateEntity);
        authorizationAllowlistRepository.insert(entities);
    }

    public void delete(Long allowlistId) {
        AuthorizationAllowlist entity = AuthorizationAllowlist.newInstance();
        entity.setAllowlistId(allowlistId);
        authorizationAllowlistRepository.delete(entity);
    }


    private void populateEntity(AuthorizationAllowlist entity) {
        entity.setAllowlistId(NumbericUid.INSTANCE.nextId());
        entity.setDataMode(DataMode.A.getValue().shortValue());
        entity.setVersion(0);
        entity.setSort(0);
        entity.setCreateDatetime(LocalDateTime.now());
        entity.setModifier(StringUtil.INSTANCE.blankString());
        entity.setModifyDatetime(LocalDateTime.now());
        entity.setState("normal");
    }

}
