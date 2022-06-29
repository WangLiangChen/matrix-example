package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.authorization.domain.AuthorizationAllowlist;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.commons.logging.MatrixLogger;
import wang.liangchen.matrix.framework.commons.logging.MatrixLoggerFactory;
import wang.liangchen.matrix.framework.commons.random.RandomUtil;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;
import wang.liangchen.matrix.framework.data.annotation.EnableJdbc;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;
import wang.liangchen.matrix.framework.data.dao.criteria.SubCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.enumeration.DataMode;
import wang.liangchen.matrix.framework.data.pagination.OrderByDirection;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-06-24 17:12
 */
@SpringBootTest
@EnableJdbc
public class DaoTest {
    private static final MatrixLogger logger = MatrixLoggerFactory.getLogger(DaoTest.class);
    @Inject
    private StandaloneDao standaloneDao;


    @Test
    public void insert() {
        AuthorizationAllowlist entity = createEntity();
        int rows = standaloneDao.insert(entity);
        logger.debug("insert:{},entity:{}", rows, entity);
    }

    @Test
    public void insertBulk() {
        List<AuthorizationAllowlist> entities = new ArrayList<AuthorizationAllowlist>() {{
            add(createEntity());
            add(createEntity());
            add(createEntity());
            add(createEntity());
            add(createEntity());
        }};
        int rows = standaloneDao.insert(entities);
        logger.debug("insertBulk:{},entities:{}", rows, entities);
    }

    @Test
    public void delete() {
        // 逻辑删除 || 物理删除
        AuthorizationAllowlist entity = AuthorizationAllowlist.newInstance();
        entity.setAllowlistId(1L);
        int rows = standaloneDao.delete(entity);
        logger.debug("delete:{},entity:{}", rows, entity);
    }

    @Test
    public void deleteByCriteria() {
        SubCriteria<AuthorizationAllowlist> criteria = SubCriteria.of(AuthorizationAllowlist.class)
                ._equals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(1))
                ._equals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(AuthorizationAllowlist::getAllowlistId));
        int rows = standaloneDao.delete(criteria);
        logger.debug("delete:{}", rows);
    }
    @Test
    public void update(){
        AuthorizationAllowlist entity = AuthorizationAllowlist.newInstance();
        entity.setAllowlistId(1L);
        entity.setSummary("modified summary");
        // 空值默认不更新，可用下面的语句，强制更新为null
        entity.addForceUpdateField(AuthorizationAllowlist::getModifier,null);
        int rows = standaloneDao.update(entity);
        logger.debug("update:{}", rows);
    }
    @Test
    public void updateByCriteria(){
        AuthorizationAllowlist entity = AuthorizationAllowlist.newInstance();
        entity.setSummary("modified summary");
        UpdateCriteria<AuthorizationAllowlist> criteria = UpdateCriteria.of(entity)
                ._equals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(1))
                ._equals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(AuthorizationAllowlist::getAllowlistId))
                // 强制更新的列
                .forceUpdate(AuthorizationAllowlist::getModifier,null);
        int rows = standaloneDao.update(criteria);
        logger.debug("update:{}", rows);
    }

    @Test
    public void pagination() {
        PaginationResult<AuthorizationAllowlist> pagination = standaloneDao.pagination(
                // 构造条件对象
                Criteria.of(AuthorizationAllowlist.class)
                        // 指定返回的列
                        .resultFields(AuthorizationAllowlist::getAllowlistId, AuthorizationAllowlist::getTenantCode)
                        // 排序
                        .orderBy(AuthorizationAllowlist::getCreateDatetime, OrderByDirection.desc)
                        .orderBy(AuthorizationAllowlist::getModifyDatetime, OrderByDirection.asc)
                        // 分页
                        .pageNumber(2).pageSize(5)
                // 结果去重.distinct()
                // 悲观锁.forUpdate()
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
                //._equals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(123L))
                // 列和列的条件
                //._notEquals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(AuthorizationAllowlist::getAllowlistId))
                // 构造嵌套条件 支持OR AND
                //._OR(SubCriteria.of(AuthorizationAllowlist.class)._equals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(123L))
                // 列和列的条件
                //._notEquals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(AuthorizationAllowlist::getAllowlistId)))

        );
        logger.debug("pagination:{}", pagination.toString());
    }
    @Test
    public void list(){
        // standaloneDao.list();
    }
    @Test
    public void select(){
        //standaloneDao.select();
    }
    @Test
    public void other(){

    }

    private AuthorizationAllowlist createEntity() {
        AuthorizationAllowlist entity = AuthorizationAllowlist.newInstance();
        entity.setAllowlistId(NumbericUid.INSTANCE.nextId());
        entity.setTenantCode("setTenantCode" + RandomUtil.INSTANCE.random(100, 999));
        entity.setAppCode("setAppCode" + RandomUtil.INSTANCE.random(100, 999));
        entity.setPermissionUri("setPermissionUri" + RandomUtil.INSTANCE.random(100, 999));
        entity.setDataMode(DataMode.A.getValue().shortValue());
        entity.setVersion(RandomUtil.INSTANCE.random(100, 999));
        entity.setSort(RandomUtil.INSTANCE.random(100, 999));
        entity.setOwner("setOwner" + RandomUtil.INSTANCE.random(100, 999));
        entity.setCreator("setCreator" + RandomUtil.INSTANCE.random(100, 999));
        entity.setCreateDatetime(LocalDateTime.now());
        entity.setModifier("setModifier" + RandomUtil.INSTANCE.random(100, 999));
        entity.setModifyDatetime(LocalDateTime.now());
        entity.setSummary("setSummary" + RandomUtil.INSTANCE.random(100, 999));
        entity.setState("NORMAL");
        return entity;
    }
}
