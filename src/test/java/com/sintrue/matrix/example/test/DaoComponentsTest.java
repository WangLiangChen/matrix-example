package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.service.DaoComponentsService;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.data.dao.SequenceKey;

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
