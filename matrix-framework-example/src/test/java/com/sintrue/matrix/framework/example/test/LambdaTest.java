package com.sintrue.matrix.framework.example.test;

import com.sintrue.matrix.framework.example.service.IExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.spring.boot.context.SpringFunctionalExecutor;

@SpringBootTest
public class LambdaTest {
    @Test
    public void testLambda() throws Throwable {
        // function
        String execute = SpringFunctionalExecutor.INSTANCE.execute(IExampleService::zeroParameter);
        System.out.println(execute);
        execute = SpringFunctionalExecutor.INSTANCE.execute(IExampleService::oneParameter, "1");
        System.out.println(execute);
        execute = SpringFunctionalExecutor.INSTANCE.execute(IExampleService::twoParameter, "1", "2");
        System.out.println(execute);
        execute = SpringFunctionalExecutor.INSTANCE.execute(IExampleService::threeParameter, "1", "2", "3");
        System.out.println(execute);

        SpringFunctionalExecutor.INSTANCE.execute(IExampleService::zeroVoid);
        SpringFunctionalExecutor.INSTANCE.execute(IExampleService::oneVoid, "1");
        SpringFunctionalExecutor.INSTANCE.execute(IExampleService::twoVoid, "1", "2");

    }

}
