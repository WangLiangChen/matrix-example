package com.sintrue.matrix.example.test.cache;

import com.sintrue.matrix.example.account.domain.Account;
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
public class CrudStandaloneDaoTests {
    // 使用StandaloneDao直接访问Dao
    @Inject
    private StandaloneDao standaloneDao;

    /**
     * 新增一条数据
     */
    @Test
    public void testInsert() {
        Account account = new Account();
        account.setAccount_id(1000000000L);
        account.setAccountName("name_one");
        account.setAccount_sex("male");
        account.setAccount_birthday(LocalDate.now());
        account.setState("NORMAL");
        account.setVersion(0L);
        int count = standaloneDao.insert(account);
        System.out.println("新增数据:" + count);
    }

    /**
     * 批量新增,采用一条SQL的形式快速批量insert
     * 批量太大请注意数据库允许的单条SQL大小
     */
    @Test
    public void testInsertBatch() {
        List<Account> entities = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Account account = new Account();
            account.setAccount_id((long) i);
            account.setAccountName("name" + i);
            account.setAccount_sex("male" + i);
            account.setAccount_birthday(LocalDate.now().minusDays(i));
            account.setState("NORMAL");
            account.setVersion(0L);
            entities.add(account);
        }
        int count = standaloneDao.insert(entities);
        System.out.println("新增数据:" + count);
    }

    /**
     * 根据主键删除,如果在实体中使用@ColumnDelete指定了列，则实施逻辑删除
     */
    @Test
    public void testDelete() {
        Account account = new Account();
        account.setAccount_id(0L);
        standaloneDao.delete(account);
    }

    /**
     * 根据条件批量删除,如果在实体中使用@ColumnDelete指定了列，则实施逻辑删除
     */
    @Test
    public void testDeleteBatch() {
        standaloneDao.delete(SubCriteria.of(Account.class)
                .equals(Account::getAccountName, SqlValue.of("ffff")));
    }

    /**
     * 根据主键更新
     * null值的列不更新
     * 通过addForceUpdateField可增加需要强制更新的列
     */
    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setAccount_id(1L);
        account.setAccountName("wanglc");
        // 增加强制更新的列
        account.addForceUpdateField(Account::getAccountName, null);
        standaloneDao.update(account);
    }

    /**
     * 根据条件更新
     * 通过forceUpdate增加需要强制更新的列
     */
    @Test
    public void testUpdateBatch() {
        Account account = new Account();
        account.setAccountName("wanglc");
        // 增加强制更新的列
        account.addForceUpdateField(Account::getAccountName, null);

        UpdateCriteria<Account> criteria = UpdateCriteria.of(account)
                .equals(Account::getAccount_id, SqlValue.of(123L))
                // 增加强制更新的列
                .forceUpdate(Account::getAccount_sex, null);
        standaloneDao.update(criteria);
    }


    /**
     * 根据条件计数
     * 本例列出所有支持的条件构造器
     * 使用OR和AND实现条件嵌套
     */
    @Test
    public void testCount() {
        Criteria<Account> criteria = Criteria.of(Account.class)
                .equals(Account::getAccountName, SqlValue.of("=name"))
                .notEquals(Account::getAccountName, SqlValue.of("!=name"))
                .greaterThan(Account::getAccount_id, SqlValue.of(0))
                .greaterThanOrEquals(Account::getAccount_id, SqlValue.of(1))
                .lessThan(Account::getAccount_id, SqlValue.of(2))
                .lessThanOrEquals(Account::getAccount_id, SqlValue.of(3))
                .isNull(Account::getAccountName)
                .isNotNull(Account::getAccountName)
                .in(Account::getAccountName, SqlValue.of("in0"), SqlValue.of("in1"), SqlValue.of("in2"))
                .notIn(Account::getAccountName, SqlValue.of("in3"), SqlValue.of("in4"), SqlValue.of("in5"))
                .between(Account::getAccount_id, SqlValue.of(1), SqlValue.of(10))
                .contains(Account::getAccountName, "contains")
                .notContains(Account::getAccountName, "not contains")
                .startWith(Account::getAccountName, "startWith")
                .notStartWith(Account::getAccountName, "not startWith")
                .endWith(Account::getAccountName, "endWith")
                .notEndWith(Account::getAccountName, "not endWith")
                // OR 嵌套
                .OR(SubCriteria.of(Account.class)
                        .equals(Account::getAccountName, SqlValue.of("=name"))
                        .notEquals(Account::getAccountName, SqlValue.of("!=name")))
                // AND 嵌套
                .AND(SubCriteria.of(Account.class)
                        .greaterThan(Account::getAccount_id, SqlValue.of(0))
                        .greaterThanOrEquals(Account::getAccount_id, SqlValue.of(1)));
        int count = standaloneDao.count(criteria);
        System.out.println(count);
    }

    /**
     * 根据条件查询数据集
     * 使用pageSize指定分页条数;pageNumber指定页号
     * 使用resultFields指定返回的列
     */
    @Test
    public void testList() {
        Criteria<Account> criteria = Criteria.of(Account.class)
                // 指定返回的列
                .resultFields(Account::getAccount_id)
                .equals(Account::getAccountName, SqlValue.of("name_2"));
        List<Account> list = standaloneDao.list(criteria);
        list.forEach(System.out::println);

    }

    /**
     * 查询返回分页结果
     */
    @Test
    /**
     * 根据条件查询并构造分页实体
     * copyTo方法可以方便的将属性复制到其它对象
     */
    public void testPagination() {
        Criteria<Account> criteria = Criteria.of(Account.class).
                equals(Account::getAccountName, SqlValue.of("name_2"))
                .resultFields(Account::getAccountName);
        PaginationResult<Account> pagination = standaloneDao.pagination(criteria);
        // 将属性复制到其它对象
        // pagination.copyTo()
    }

    /**
     * 直接执行sql
     */
    public void testExecuteSql(){
        //standaloneDao.executeSql()
    }
}
