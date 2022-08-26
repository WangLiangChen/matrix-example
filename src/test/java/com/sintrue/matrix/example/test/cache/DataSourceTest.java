package com.sintrue.matrix.example.test.cache;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-08-25 14:55
 */
@SpringBootTest
public class DataSourceTest {
    @Inject
    private DataSource dataSource;

    @Test
    public void testPG() throws SQLException {
        //MultiDataSourceContext.INSTANCE.set("second");
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update matrix_lock set lock_owner=?");
            preparedStatement.setString(1, "matrix");
            int i = preparedStatement.executeUpdate();
            System.out.println("updated:"+i);
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into matrix_lock values(?,?,?,?)");
            preparedStatement.setString(1, "matrix");
            preparedStatement.setObject(2, LocalDateTime.now());
            preparedStatement.setObject(3, LocalDateTime.now());
            preparedStatement.setString(4, "matrix1");
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        connection.commit();
    }
}
