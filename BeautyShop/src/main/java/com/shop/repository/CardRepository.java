package com.shop.repository;

import com.shop.model.entity.CardEntity;
import com.shop.model.entity.SyntheticEntity;
import com.shop.model.entity.WishListEntity;
import com.shop.model.response.WishListResponse;

import java.sql.SQLException;
import java.util.List;

public interface CardRepository extends JpaRepository<CardEntity, Integer> {
    boolean kiemTraSanPhamCoTrongCard(int maSanPham, String id_user);
    List<SyntheticEntity> findAllByIdUser(String name , String idUser);
    int tongTien(int id_User);
//    void insertCard()
    void updateCard(String soLuong,String id, String maSp) throws SQLException;

    void updateTinhTrang(String id, Integer tinhTrang);
}
