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
        standaloneDao.list(
                // 构造条件对象
                Criteria.of(AuthorizationAllowlist.class)
                        // 指定返回的列
                        .resultFields(AuthorizationAllowlist::getAllowlistId, AuthorizationAllowlist::getPermissionUri)
                        // 排序
                        .orderBy(AuthorizationAllowlist::getCreateDatetime, OrderByDirection.desc)
                        // 分页
                        .pageNumber(2).pageSize(10)
                        // 结果去重
                        .distinct()
                        // 悲观锁和乐观锁
                        .forUpdate().version(111)
                        /**
                         * 构造各种查询条件
                         * _equals         _notEquals
                         * _greaterThan    _greaterThanOrEquals
                         * _lessThan       _lessThanOrEquals
                         * _in             _notIn
                         * _isNull         _isNotNull
                         * _between        _notBetween
                         * _startWith      _notStartWith
                         * _endWith        _notEndWith
                         * _contains       _notContains
                         */
                        // 列和值的条件
                        ._equals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(123L))
                        // 列和列的条件
                        ._notEquals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(AuthorizationAllowlist::getAllowlistId))
                        // 构造嵌套条件 支持OR AND
                        ._OR(SubCriteria.of(AuthorizationAllowlist.class)._equals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(123L))
                                // 列和列的条件
                                ._notEquals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(AuthorizationAllowlist::getAllowlistId)))

        );
    }
}
