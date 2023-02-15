package com.sintrue.matrix.example.test.criteria;

import org.junit.jupiter.api.Test;

/**
 * @author Liangchen.Wang 2023-02-15 16:58
 */
public class CriteriaTest {
    @Test
    public void testString() {
        Criterias root = new Criterias(AndOr.add);
        root.add(new Criteria("a", "=", 1));
        root.add(new Criteria("b", ">", 2));
        Criterias sub = new Criterias(AndOr.or);
        sub.add(new Criteria("c", "<", 3));
        sub.add(new Criteria("d", "!=", 4));
        root.add(sub);
        System.out.println(root.resolve());
    }
}
