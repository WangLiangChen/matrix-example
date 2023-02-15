package com.sintrue.matrix.example.test.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangchen.Wang 2023-02-15 14:34
 */
public class Criterias extends AbstractCriteria {

    public Criterias(AndOr andOr) {
        super(andOr);
    }

    private List<AbstractCriteria> items = new ArrayList<>();

    public void add(Criteria criteria) {
        this.items.add(criteria);
    }

    public void add(Criterias criterias) {
        this.items.add(criterias);
    }

    public List<AbstractCriteria> getItems() {
        return items;
    }

    public String resolve() {
        return resolve(this,0);
    }

}
