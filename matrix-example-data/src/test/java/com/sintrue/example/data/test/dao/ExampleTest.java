package com.sintrue.example.data.test.dao;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.DeleteCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.dao.entity.Entities;
import wang.liangchen.matrix.framework.data.dao.entity.JsonField;
import wang.liangchen.matrix.framework.data.enumeration.StateEnum;
import wang.liangchen.matrix.framework.data.pagination.OrderByDirection;
import wang.liangchen.matrix.framework.data.pagination.Pagination;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2023-04-28 11:28
 */
@SpringBootTest
public class ExampleTest {
    @Inject
    private StandaloneDao standaloneDao;

    @Test
    public void insert() {
        Example example = Example.newInstance();
        example.setStaffName("name");
        // 标注@ColumnJson的属性，会自动进行对象和JSON的转换
        JsonField jsonField = JsonField.newInstance();
        jsonField.put("a", 1);
        jsonField.put("b", 2);
        example.setStaffSettings(jsonField);
        // 将其它属性初始化为默认值
        example.initializeFields();
        example.setState(StateEnum.NORMAL);
        standaloneDao.insert(example);

        Long staffId = example.getStaffId();
        Example select = select(staffId);
        System.out.println("inserted:" + select);
    }

    @Test
    public void inertBulk() {
        List<Example> entities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Example example = Example.newInstance();
            example.setStaffName("name" + i);
            JsonField jsonField = JsonField.newInstance();
            jsonField.put("a", i);
            jsonField.put("b", i + 2);
            example.setStaffSettings(jsonField);
            example.initializeFields();
            example.setState(StateEnum.NORMAL);
            entities.add(example);
        }
        standaloneDao.insert(entities);
    }

    @Test
    public void delete() {
        Example entity = Example.newInstance();
        // 根据主键删除,如果对应的属性标注了@ColumnMarkDelete，则执行逻辑删除
        entity.setStaffId(0L);
        // 乐观锁,对应的属性需附加@Version注解
        entity.setVersion(0);
        standaloneDao.delete(entity);
    }

    @Test
    public void deleteByCriteria() {
        DeleteCriteria<Example> criteria = DeleteCriteria.of(Example.class)
                // 逻辑删除;标记删除
                .markDelete(Example::getState, "DELETED")
                // 乐观锁
                .optimisticLock(Example::getVersion, 5, 7)
                ._equals(Example::getStaffId, 10L);
        standaloneDao.delete(criteria);
    }

    @Test
    public void update() {
        Example entity = Example.newInstance();
        // 根据主键更新
        entity.setStaffId(100L);
        // 乐观锁,对应的属性需附加@Version注解
        entity.setVersion(5);
        // 只更新非null属性
        entity.setStaffName("newName");
        // 强制更新为null或者其它值
        entity.addForceUpdateColumn("create_datetime", null);
        entity.addForceUpdateField(Example::getModifyDatetime, null);
        standaloneDao.update(entity);
    }

    @Test
    public void updateByCriteria() {
        Example entity = Example.newInstance();
        // 只更新非null属性
        entity.setStaffName("newName");
        UpdateCriteria<Example> criteria = UpdateCriteria.of(entity)
                // 乐观锁
                .optimisticLock(Example::getVersion, 5, 7)
                // 强制更新为null或其它值
                .forceUpdate("create_datetime", null)
                .forceUpdate(Example::getModifyDatetime, null)
                ._equals(Example::getStaffId, 0L);
        standaloneDao.update(criteria);
    }

    @Test
    public void select() {
        Criteria<Example> criteria = Criteria.of(Example.class)
                //.forUpdate()
                // 指定返回的列
                .resultFields(Example::getStaffId, Example::getStaffName, Example::getState)
                ._equals(Example::getStaffId, 2L);
        Example example = standaloneDao.select(criteria);
        // 直接转换成其它对象
        ExampleResponse exampleResponse = example.to(ExampleResponse.class);
        System.out.println();
    }

    @Test
    public void entities() {
        Criteria<Example> criteria = Criteria.of(Example.class)
                //.distinct()
                // 排序
                .orderBy(Example::getModifyDatetime, OrderByDirection.desc)
                // 分页
                .pageNumber(1).pageSize(10)
                ._equals(Example::getStaffId, 0L)
                // 条件之间or
                ._or()._equals(Example::getOwner, Example::getCreator)
                // 条件组之间or
                ._or(sub -> sub._endWith(Example::getStaffName, "0")._or()._lessThan(Example::getCreateDatetime, LocalDateTime.now()));

        Entities<Example> entities = standaloneDao.entities(criteria);
        // 转换为list
        List<Example> entityList = entities.to();
        // 转换为其它对象集合,并进行过程处理
        List<ExampleResponse> exampleResponses = entities.to(ExampleResponse.class, (source, target) -> {
        });
        System.out.println();
    }

    @Test
    public void pagination() {
        Criteria<Example> criteria = Criteria.of(Example.class)
                // 分页和排序
                .pagination(Pagination.newInstance().setPageNumber(1).setPageSize(5).addOrderBy("modify_datetime", OrderByDirection.desc))
                ._equals(Example::getStaffId, 0L)
                // 条件之间or
                ._or()._equals(Example::getOwner, Example::getCreator)
                // 条件组之间or
                ._or(sub -> sub._endWith(Example::getStaffName, "0")._lessThan(Example::getCreateDatetime, LocalDateTime.now()));
        PaginationResult<Example> pagination = standaloneDao.pagination(criteria);
        // 直接转换为其它对象，并进行过程处理
        PaginationResult<ExampleResponse> paginationResponse = pagination.to(ExampleResponse.class, (source, target) -> {
        });
        System.out.println();
    }

    private Example select(Long staffId) {
        Criteria<Example> criteria = Criteria.of(Example.class)
                ._equals(Example::getStaffId, staffId);
        return standaloneDao.select(criteria);
    }
}
