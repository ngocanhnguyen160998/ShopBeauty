package com.shop.util;

import com.shop.common.annotation.Column;
import com.shop.common.annotation.Entity;
import com.shop.common.annotation.Id;

public class AnnotationUtil {
     public static String getTableName(Class<?> tClass){
         return tClass.getDeclaredAnnotation(Entity.class).name();
     }

     public static String getPrimarykey(Class<?> tClass , String fieldName) throws NoSuchFieldException {
         return tClass.getDeclaredField(fieldName).getDeclaredAnnotation(Id.class).value();
     }
     public static String getFields(Class<?> tClass , String fieldName) throws NoSuchFieldException {
         return tClass.getDeclaredField(fieldName).getDeclaredAnnotation(Column.class).value();
     }
}
