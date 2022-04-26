package com.sintrue.matrix.example.test;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.commons.exception.MatrixErrorException;
import wang.liangchen.matrix.framework.data.dao.criteria.ColumnMeta;
import wang.liangchen.matrix.framework.data.datasource.ConnectionsManager;
import wang.liangchen.matrix.framework.generator.DomainGenerator;
import wang.liangchen.matrix.framework.generator.EntityTemplate;

import javax.inject.Inject;
import java.io.OutputStreamWriter;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-04-26 8:53
 */
@SpringBootTest
public class DomainGeneratorTests {
    @Inject
    DomainGenerator domainGenerator;

    @Test
    public void testMeta() throws Exception {
        String tableName = "matrix_authorization_subject";
        domainGenerator.doIt(tableName, "version", "state", "deleted");
    }


}
