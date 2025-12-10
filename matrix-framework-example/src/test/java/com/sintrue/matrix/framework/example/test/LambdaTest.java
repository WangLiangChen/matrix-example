package com.sintrue.matrix.framework.example.test;

import com.sintrue.matrix.framework.example.service.IExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.spring.boot.function.FunctionExecutor;

@SpringBootTest
public class LambdaTest {
    @Test
    public void testLambda() throws Throwable {
        // function
        String execute = FunctionExecutor.INSTANCE.execute(IExampleService::zeroParameter);
        System.out.println(execute);
        execute = FunctionExecutor.INSTANCE.execute(IExampleService::oneParameter, "1");
        System.out.println(execute);
        execute = FunctionExecutor.INSTANCE.execute(IExampleService::twoParameter, "1", "2");
        System.out.println(execute);
        execute = FunctionExecutor.INSTANCE.execute(IExampleService::threeParameter, "1", "2", "3");
        System.out.println(execute);

        FunctionExecutor.INSTANCE.execute(IExampleService::zeroVoid);
        FunctionExecutor.INSTANCE.execute(IExampleService::oneVoid, "1");

    }

}
