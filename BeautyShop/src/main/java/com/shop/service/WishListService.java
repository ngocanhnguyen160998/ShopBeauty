package com.shop.service;

import com.shop.model.entity.SyntheticEntity;
import com.shop.model.entity.WishListEntity;
import com.shop.model.request.WishListRequest;
import com.shop.model.response.WishListResponse;
import com.shop.paging.Pageable;

import java.util.List;

public interface WishListService {
    void insert(WishListRequest request);

    void update(WishListRequest request);

    void delete (int id);

    List<WishListResponse> findAll();

    WishListEntity findById(Integer id);

    List<WishListResponse> findAllById(String name , String idUser, String orderName, String orderBy);

    List<SyntheticEntity> findAllByIdUser(Pageable pageable, String name , String idUser);

    boolean kiemTraSanPhamCoTrongCard(int maSanPham, Integer id_user);
    long count();
    void deleteByIds(int[] ids);
}
