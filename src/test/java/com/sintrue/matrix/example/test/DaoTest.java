package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.authorization.domain.AuthorizationAllowlist;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;
import wang.liangchen.matrix.framework.data.dao.criteria.SubCriteria;
import wang.liangchen.matrix.framework.data.pagination.OrderByDirection;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-06-24 17:12
 */
@SpringBootTest
@EnableJdbc
public class DaoTest {
    @Inject
    private StandaloneDao standaloneDao;

    @Test
    public void list() {
        List<AuthorizationAllowlist> list = standaloneDao.list(
                // 构造条件对象
                Criteria.of(AuthorizationAllowlist.class)
                        // 指定返回的列
                        .resultFields(AuthorizationAllowlist::getAllowlistId, AuthorizationAllowlist::getTenantCode)
                        // 排序
                        .orderBy(AuthorizationAllowlist::getCreateDatetime, OrderByDirection.desc)
                        .orderBy(AuthorizationAllowlist::getModifyDatetime, OrderByDirection.asc)
                        // 分页
                        .pageNumber(2).pageSize(10)


        );
        list.forEach(System.out::println);
    }
}
