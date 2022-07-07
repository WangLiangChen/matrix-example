package com.sintrue.matrix.example.seckill.controller;

import com.sintrue.matrix.example.seckill.domain.Commodity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.commons.exception.MatrixInfoException;
import wang.liangchen.matrix.framework.commons.logging.MatrixLogger;
import wang.liangchen.matrix.framework.commons.logging.MatrixLoggerFactory;
import wang.liangchen.matrix.framework.commons.random.RandomUtil;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;
import wang.liangchen.matrix.framework.data.dao.criteria.SubCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.datasource.MultiDataSourceContext;
import wang.liangchen.matrix.framework.data.pagination.OrderByDirection;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.springboot.processor.AopProxyProcessor;
import wang.liangchen.matrix.framework.web.response.FormattedResponse;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-06-29 22:47
 */
@RestController
@RequestMapping("/")
public class CommodityController implements AopProxyProcessor.AopProxyAware {
    private static final MatrixLogger logger = MatrixLoggerFactory.getLogger(CommodityController.class);
    private final StandaloneDao standaloneDao;


    @Inject
    public CommodityController(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

    @GetMapping("success")
    public FormattedResponse success() {
        return FormattedResponse.success();
    }

    @GetMapping("failure")
    public FormattedResponse failure() {
        return FormattedResponse.failure();
    }

    @GetMapping("exception")
    public FormattedResponse exception() {
        return FormattedResponse.exception(new MatrixInfoException("I am Info"));
    }

    @GetMapping("handledException")
    public FormattedResponse handledException() {
        throw new MatrixErrorException("I am Error");
    }

    @GetMapping("insert")
    public FormattedResponse insert() {
        Commodity entity = createEntity();
        int rows = standaloneDao.insert(entity);
        logger.debug("insert: {}, entity: {}", rows, entity);
        return FormattedResponse.success();
    }

    @GetMapping("insertBulk")
    public FormattedResponse insertBulk() {
        List<Commodity> entities = new ArrayList<Commodity>() {{
            add(createEntity());
            add(createEntity());
            add(createEntity());
            add(createEntity());
            add(createEntity());
        }};
        int rows = standaloneDao.insert(entities);
        logger.debug("insertBulk:{},entities:{}", rows, entities);
        return FormattedResponse.success();
    }

    @GetMapping("delete")
    public FormattedResponse delete() {
        // 根据主键 逻辑删除 || 物理删除
        Commodity entity = Commodity.newInstance();
        entity.setCommodityId(0L);
        int rows = standaloneDao.delete(entity);
        logger.debug("delete:{},entity:{}", rows, entity);
        return FormattedResponse.success();
    }

    @GetMapping("deleteByCriteria")
    public FormattedResponse deleteByCriteria() {
        SubCriteria<Commodity> criteria = SubCriteria.of(Commodity.class)
                ._equals(Commodity::getCommodityId, SqlValue.of(0L))
                ._equals(Commodity::getState, SqlValue.of(Commodity::getCommodityName));
        int rows = standaloneDao.delete(criteria);
        logger.debug("delete:{}", rows);
        return FormattedResponse.success();
    }


    @GetMapping("update")
    public FormattedResponse update() {
        // 根据主键更新
        Commodity entity = Commodity.newInstance();
        entity.setCommodityId(0L);
        entity.setCommodityStock(5);
        // 空值默认不更新，可用下面的语句，强制更新为null
        entity.addForceUpdateField(Commodity::getState, null);
        int rows = standaloneDao.update(entity);
        logger.debug("update: {}, entity: {}", rows, entity);
        return FormattedResponse.success();
    }

    @GetMapping("updateByCriteria")
    public FormattedResponse updateByCriteria() {
        Commodity entity = Commodity.newInstance();
        entity.setCommodityPrice(100);
        UpdateCriteria<Commodity> criteria = UpdateCriteria.of(entity)
                ._equals(Commodity::getCommodityId, SqlValue.of(0L))
                ._equals(Commodity::getState, SqlValue.of(Commodity::getCommodityName))
                // 强制更新的列
                .forceUpdate(Commodity::getState, null);
        int rows = standaloneDao.update(criteria);
        logger.debug("update:{}", rows);
        return FormattedResponse.success();
    }

    @GetMapping("pagination")
    // @DataSourceAssign("primary")
    public FormattedResponse pagination() {
        Criteria<Commodity> criteria = Criteria.of(Commodity.class)
                // 指定返回的列
                .resultFields(Commodity::getCommodityId, Commodity::getCommodityName)
                // 排序
                .orderBy(Commodity::getCreateDatetime, OrderByDirection.desc)
                .orderBy(Commodity::getCommodityPrice, OrderByDirection.asc)
                // 分页
                .pageNumber(2).pageSize(5)
                // 结果去重.distinct() 悲观锁.forUpdate()
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
                ._equals(Commodity::getCommodityId, SqlValue.of(0L))
                // 列和列的条件
                ._notEquals(Commodity::getCommodityName, SqlValue.of(Commodity::getState));
        // 构造嵌套条件 支持OR AND
        //._OR(SubCriteria.of(AuthorizationAllowlist.class)._equals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(123L))
        //._notEquals(AuthorizationAllowlist::getAllowlistId, SqlValue.of(AuthorizationAllowlist::getAllowlistId)))
        PaginationResult<Commodity> pagination = standaloneDao.pagination(criteria);
        logger.debug("pagination: {}", pagination);
        // 嵌套数据源切换
        return FormattedResponse.success().payload(pagination);
    }

    @Override
    public void setAopProxy(Object proxy) {
        this.self = (CommodityController) proxy;
    }

    private Commodity createEntity() {
        Commodity entity = Commodity.newInstance();
        // Id 生成
        entity.setCommodityId(NumbericUid.INSTANCE.nextId());

        entity.setCommodityName(MultiDataSourceContext.INSTANCE.getDialect().getDataSourceType() + "商品" + RandomUtil.INSTANCE.random(1000, 9999));
        entity.setCommodityPrice(RandomUtil.INSTANCE.random(1000, 9999));
        entity.setCommodityStock(RandomUtil.INSTANCE.random(1, 5));
        entity.setCreateDatetime(LocalDateTime.now());
        entity.setState("NORMAL");
        return entity;
    }
}
