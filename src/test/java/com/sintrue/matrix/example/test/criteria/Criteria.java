package com.sintrue.matrix.example.test.criteria;

/**
 * @author Liangchen.Wang 2023-02-15 14:55
 */
public class Criteria extends AbstractCriteria {
    private final String field;
    private final String operator;
    private final Object value;

    public Criteria(String field, String operator, Object value) {
        super(AndOr.add);
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }
}