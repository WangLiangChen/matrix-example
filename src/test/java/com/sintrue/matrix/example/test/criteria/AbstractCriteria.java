package com.sintrue.matrix.example.test.criteria;

import java.util.List;

/**
 * @author Liangchen.Wang 2023-02-15 16:41
 */
public abstract class AbstractCriteria {
    private final AndOr andOr;

    protected AbstractCriteria(AndOr andOr) {
        this.andOr = andOr;
    }

    public AndOr getAndOr() {
        return andOr;
    }

    protected String resolve(AbstractCriteria abstractCriteria, int index) {
        if (null == abstractCriteria) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        if (index > 0) {
            builder.append(" ").append(abstractCriteria.getAndOr().name()).append(" ");
        }
        if (abstractCriteria instanceof Criteria) {
            Criteria criteria = (Criteria) abstractCriteria;
            builder.append(criteria.getField()).append(criteria.getOperator()).append(criteria.getValue());
        }
        if (abstractCriteria instanceof Criterias) {
            builder.append("(");
            Criterias criterias = (Criterias) abstractCriteria;
            List<AbstractCriteria> items = criterias.getItems();
            for (int i = 0, size = items.size(); i < size; i++) {
                builder.append(resolve(items.get(i), i));
            }
            builder.append(")");
        }
        return builder.toString();
    }
}
