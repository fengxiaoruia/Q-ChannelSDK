package com.feng.config;

import com.alibaba.fastjson2.filter.ValueFilter;

public class EmptyValueFilter implements ValueFilter {

    @Override
    public Object apply(Object o, String s, Object o1) {
        if (o1 == null || o1.toString().isEmpty()) {
            return null;
        }
        return o1;
    }
}
