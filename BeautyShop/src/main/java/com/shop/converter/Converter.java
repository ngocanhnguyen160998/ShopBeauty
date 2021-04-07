package com.shop.converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
                    //request - response - entity
public interface Converter<U,V,T> {
    T converToEntity(T t,U u);
    V converToResponse(V v,T t);
    List<V> convertToListResponse(List<T> ts);
}
