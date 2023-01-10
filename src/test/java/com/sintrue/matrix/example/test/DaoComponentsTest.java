package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.component.DaoComponentsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.SequenceKey;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-12-10 11:20
 */
@SpringBootTest
public class DaoComponentsTest {
    @Inject
    private DaoComponentsService service;

    @Test
    public void testSequence() {
        service.sequence(SequenceKey.newSequence("group", "key", 0));
    }
}
