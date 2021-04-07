package com.shop.service;

import com.shop.model.entity.ProductEntity;
import com.shop.model.request.ProductRequest;
import com.shop.model.request.UserRequest;
import com.shop.model.response.ProductResponse;
import com.shop.model.response.UserResponse;
import com.shop.paging.Pageable;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    void insert(ProductRequest request);

    void update(ProductRequest request);

    void delete (int id);

    List<ProductResponse> findAll();

    List<ProductResponse> findAllById(String name, String idUser,String orderName, String ordeBy);

    List<ProductResponse> findAll(Pageable pageable);

    List<ProductResponse> findAll(Pageable pageable, String sortName, String sortBy,String nameProduct);

    long count();

    long countByCondition(String idMenuCon);

    long countById(String name, String conditions);

    ProductEntity findById(Integer id);

    void deleteByIds(int[] ids);

    List<ProductResponse> findAllByCategory(Pageable pageable, String sortName, String sortBy, String idMenuCon);
}
