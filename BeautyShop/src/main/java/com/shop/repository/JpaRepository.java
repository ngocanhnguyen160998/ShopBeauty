package com.shop.repository;

import com.shop.paging.Pageable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface JpaRepository<T, ID> {

    <S extends T> S insert(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    <S extends T> S findById(ID id);

    <S extends T> List<S> findAll(Pageable pageable);

    <S extends T> List<S> findAll(Pageable pageable, String sortName, String sortBy,String nameProduct);

    <S extends T> List<S> findAll(Pageable pageable, String sortName, String sortBy,int idMenuCon);

    long count();

    long countByCondition(String idMenuCon);

    long countById(String name, String conditions);

    void delete(ID id) throws NoSuchFieldException;

    <S extends T> List<S> findByProperties(Map<String , Object> filter);

    <S extends T> List<S> findAll();

    <S extends T> List<S> findByCondition(String condition, String id_user);

    <S extends T> List<S> findByCondition(String condition);

    void update(T entity, int ID) throws SQLException;

    <S extends T> List<S> findAllById(String name ,String idUser, String orderName, String orderBy);
}
