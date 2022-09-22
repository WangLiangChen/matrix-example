package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.domain.Settings;
import com.sintrue.matrix.example.domain.Staff;
import com.sintrue.matrix.example.domain.StaffState;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlBuilder;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.enumeration.StateEnum;
import wang.liangchen.matrix.framework.data.pagination.OrderByDirection;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Liangchen.Wang 2022-08-31 22:55
 */
@SpringBootTest
public class StandaloneDaoTest {
    @Inject
    private StandaloneDao standaloneDao;
    @Inject
    private ApplicationContext applicationContext;

    @Test
    public void testChangeState() {

    }

    @Test
    public void testInsert() {
        Staff staff = new Staff();
        // ID根据主键策略生成
        // staff.setStaffId(0L);
        staff.setStaffDesc("staff15");
        staff.setCreateDatetime(LocalDateTime.now());
        staff.setCreateDate(LocalDate.now());
        // 枚举支持
        staff.setState(StaffState.STAFF_ONLY);
        // 自动转换JSON支持
        staff.setSettings(new Settings("male", LocalDate.of(2000, 1, 1)));
        standaloneDao.insert(staff);
    }

    @Test
    public void testInsertBatch() {
        Staff staff = new Staff();
        // ID根据主键策略生成
        // staff.setStaffId(0L);
        staff.setStaffDesc("staff15");
        staff.setCreateDatetime(LocalDateTime.now());
        staff.setCreateDate(LocalDate.now());
        // 枚举支持
        staff.setState(StaffState.STAFF_ONLY);
        // 自动转换JSON支持
        staff.setSettings(new Settings("male", LocalDate.of(2000, 1, 1)));
        standaloneDao.insert(new ArrayList<Staff>() {{
            add(staff);
            add((Staff) staff.clone());
        }});
    }

    @Test
    public void testDeleteById() {
        //@ColumnMarkDelete("DELETED") 逻辑删除
        Staff staff = new Staff();
        staff.setStaffId(100L);
        int rows = standaloneDao.delete(staff);
        System.out.println("deleted rows:" + rows);
    }

    @Test
    public void testDelete() {
        //@ColumnMarkDelete("DELETED") 逻辑删除
        Criteria<Staff> criteria = Criteria.of(Staff.class)._startWith(Staff::getStaffDesc, "wanglc");
        int rows = standaloneDao.delete(criteria);
        System.out.println("deleted rows:" + rows);
    }

    @Test
    public void testUpdateById() {
        Staff staff = new Staff();
        staff.setStaffId(100L);
        staff.setCreateDatetime(LocalDateTime.MAX);

        // 增加强制更新的列，会覆盖entity中对应属性值
        staff.addForceUpdateColumn("create_datetime", null);
        // 增加强制更新的属性
        staff.addForceUpdateField(Staff::getStaffDesc, null);
        int rows = standaloneDao.update(staff);
        System.out.println("deleted rows:" + rows);
    }

    @Test
    public void testUpdate() {
        Staff staff = new Staff();
        staff.setStaffId(100L);
        staff.setCreateDatetime(LocalDateTime.MAX);
        // 增加强制更新的列
        staff.addForceUpdateColumn("create_datetime", null);
        // 增加强制更新的属性
        staff.addForceUpdateField(Staff::getStaffDesc, null);

        UpdateCriteria<Staff> updateCriteria = UpdateCriteria.of(staff)
                // 设置强制更新
                .forceUpdate(Staff::getCreateDate, null)
                // 设置条件
                ._startWith(Staff::getStaffDesc, "abc");
        int rows = standaloneDao.update(updateCriteria);
        System.out.println("deleted rows:" + rows);
    }

    @Test
    public void testSelectWithClass() {
        Staff staff = standaloneDao.select(Criteria.of(Staff.class)
                ._equals(Staff::getStaffId, Staff::getStaffId)
                ._equals(Staff::getStaffId, 440767737397028965L)
                ._startWith(Staff::getStaffDesc, "staff")
                ._contains(Staff::getStaffDesc, "staff")
                ._between(Staff::getCreateDate, LocalDate.MIN, LocalDate.MAX)
                //._in(Staff::getState, StateEnum.NORMAL, StateEnum.DELETED)
                ._isNotNull(Staff::getCreateDatetime)
                ._greaterThan(Staff::getCreateDatetime, LocalDateTime.MIN)
        );
        System.out.println();
    }

    @Test
    public void testSelectWithObject() {
        Staff param = new Staff();
        param.setStaffId(438764791394248808L);
        Staff staff = standaloneDao.select(Criteria.of(param)
                // * 取对象的属性值比较
                ._equals(Staff::getStaffId)
                // * 两个列比较
                ._equals(Staff::getStaffId, Staff::getStaffId)
                ._startWith(Staff::getStaffDesc, "staff")
                ._contains(Staff::getStaffDesc, "staff")
                ._between(Staff::getCreateDate, LocalDate.MIN, LocalDate.MAX)
                ._in(Staff::getState, StateEnum.NORMAL, StateEnum.DELETED)
                ._isNotNull(Staff::getCreateDatetime)
                ._greaterThan(Staff::getCreateDatetime, LocalDateTime.MIN)
                // * 指定返回的列
                .resultFields(Staff::getStaffId, Staff::getStaffDesc, Staff::getSettings)
                // *  分页信息
                .pageSize(10).pageNumber(1)
        );
        System.out.println();
    }

    @Test
    public void testPagination() {
        standaloneDao.pagination(Criteria.of(Staff.class)
                ._startWith(Staff::getStaffDesc, "staff")
                // 分页
                .pageNumber(1).pageSize(5)
                // 排序
                .orderBy(Staff::getCreateDatetime, OrderByDirection.asc)
                .orderBy(Staff::getCreateDate, OrderByDirection.desc)
        );
    }

    @Test
    public void testSQL() {
        // 直接执行SQL
        SqlBuilder sqlBuilder = new SqlBuilder("update staff set version=version+1 where staff_id=?");
        sqlBuilder.addArgs(100L);
        standaloneDao.executeSql(sqlBuilder);

        // 直接SQL查询
        // standaloneDao.queryForList();
        // standaloneDao.queryForMap();
        // standaloneDao.queryForObject();

    }
}
