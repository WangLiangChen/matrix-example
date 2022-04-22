package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.domain.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;
import wang.liangchen.matrix.framework.data.dao.criteria.SubCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-04-17 14:29
 */
@SpringBootTest
public class ExampleTests {
    // 使用StandaloneDao直接访问Dao
    @Inject
    private StandaloneDao standaloneDao;

    /**
     * 新增一条数据
     */
    @Test
    public void testInsert() {
        Staff staff = new Staff();
        staff.setStaff_id(123L);
        staff.setStaffName("name123");
        staff.setStaff_sex("male");
        staff.setStaff_birthday(LocalDate.now());
        int count = standaloneDao.insert(staff);
        System.out.println(count);
    }

    /**
     * 批量新增,采用一条SQL的形式快速批量insert
     * 批量太大请注意数据库允许的单条SQL大小
     */
    @Test
    public void testInsertBatch() {
        List<Staff> entities = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Staff staff = new Staff();
            staff.setStaff_id((long) i);
            staff.setStaffName("name" + i);
            staff.setStaff_sex("male" + i);
            staff.setStaff_birthday(LocalDate.now().minusDays(i));
            staff.setState("NORMAL");
            entities.add(staff);
        }
        int count = standaloneDao.insert(entities);
        System.out.println(count);
    }

    /**
     * 根据主键删除,如果在实体中使用@ColumnDelete指定了列，则实施逻辑删除
     */
    @Test
    public void testDelete() {
        Staff staff = new Staff();
        staff.setStaff_id(0L);
        // 根据主键删除
        standaloneDao.delete(staff);
    }

    /**
     * 根据条件批量删除,如果在实体中使用@ColumnDelete指定了列，则实施逻辑删除
     */
    @Test
    public void testDeleteBatch() {

        standaloneDao.delete(SubCriteria.of(Staff.class).equals(Staff::getStaff_id, SqlValue.of(1l)).equals(Staff::getStaffName, SqlValue.of("ffff")));
    }

    /**
     * 根据主键更新
     * null不更新
     * 通过addForceUpdateField增加需要强制更新的列
     */
    @Test
    public void testUpdate() {
        Staff staff = new Staff();
        staff.setStaffName("wanglc");
        staff.addForceUpdateField(Staff::getStaffName, null);
        staff.setStaff_id(1L);
        standaloneDao.update(staff);
    }

    /**
     * 根据条件更新
     * 通过forceUpdate增加需要强制更新的列
     */
    @Test
    public void testUpdateBatch() {
        Staff staff = new Staff();
        staff.setStaffName("wanglc");
        UpdateCriteria<Staff> criteria = UpdateCriteria.of(staff)
                .equals(Staff::getStaff_id, SqlValue.of(123L))
                .forceUpdate(Staff::getStaffName, null);
        standaloneDao.update(criteria);
    }


    /**
     * 根据条件计数
     * 本例列出所有支持的条件构造器，支持条件嵌套(AND,OR)
     */
    @Test
    public void testCount() {
        Criteria<Staff> criteria = Criteria.of(Staff.class)
                .equals(Staff::getStaffName, SqlValue.of("=name"))
                .notEquals(Staff::getStaffName, SqlValue.of("!=name"))
                .greaterThan(Staff::getStaff_id, SqlValue.of(0))
                .greaterThanOrEquals(Staff::getStaff_id, SqlValue.of(1))
                .lessThan(Staff::getStaff_id, SqlValue.of(2))
                .lessThanOrEquals(Staff::getStaff_id, SqlValue.of(3))
                .isNull(Staff::getStaffName)
                .isNotNull(Staff::getStaffName)
                .in(Staff::getStaffName, SqlValue.of("in0"), SqlValue.of("in1"), SqlValue.of("in2"))
                .notIn(Staff::getStaffName, SqlValue.of("in3"), SqlValue.of("in4"), SqlValue.of("in5"))
                .between(Staff::getStaff_id, SqlValue.of(1), SqlValue.of(10))
                .contains(Staff::getStaffName, "contains")
                .notContains(Staff::getStaffName, "not contains")
                .startWith(Staff::getStaffName, "startWith")
                .notStartWith(Staff::getStaffName, "not startWith")
                .endWith(Staff::getStaffName, "endWith")
                .notEndWith(Staff::getStaffName, "not endWith");
        int count = standaloneDao.count(criteria);
        System.out.println(count);
    }

    /**
     * 根据条件查询数据集
     * 使用pageSize指定分页条数;pageNumber指定页号
     */
    @Test
    public void testList() {
        Criteria<Staff> criteria = Criteria.of(Staff.class).
                equals(Staff::getStaffName, SqlValue.of("name_2"))
                .equals(Staff::getStaff_id, SqlValue.of(123L))
                .OR(SubCriteria.of(Staff.class).equals(Staff::getStaff_id, SqlValue.of("fff")));

        List<Staff> list = standaloneDao.list(criteria);
        list.forEach(System.out::println);

    }

    /**
     * 查询返回分页结果
     */
    @Test
    public void testPagination(){
        Criteria<Staff> criteria = Criteria.of(Staff.class).
                equals(Staff::getStaffName, SqlValue.of("name_2"))
                .resultFields(Staff::getStaffName);
        PaginationResult<Staff> pagination = standaloneDao.pagination(criteria);
    }
}
