package com.shop.service;

import com.shop.model.entity.ProductEntity;
import com.shop.model.entity.SyntheticEntity;
import com.shop.model.request.CheckOutRequest;
import com.shop.model.response.CardResponse;
import com.shop.model.response.CheckOutResponse;
import com.shop.model.response.ProductResponse;
import com.shop.paging.Pageable;

import java.util.List;

public interface CheckOutService {
    void insert(CheckOutRequest request);


    List<CheckOutResponse> findAll();

    List<SyntheticEntity> listNameProduct(int idUser);

    int tongTien();

    long count();

    List<CheckOutResponse> findAll(Pageable pageable);

    List<CheckOutResponse> findAll(Pageable pageable, String sortName, String sortBy,String nameProduct);

    CheckOutResponse findById(Integer id);
}
