package com.shop.repository;

import com.shop.model.entity.SyntheticEntity;
import com.shop.model.entity.WishListEntity;
import com.shop.paging.Pageable;

import java.util.List;

public interface WishlistRepository extends JpaRepository<WishListEntity, Integer> {
    boolean kiemTraSanPhamCoTrongGioHangChua(int maSanPham, Integer id_user);
    List<SyntheticEntity> findAllByIdUser(Pageable pageable,String name , String idUser);
    void deleteByIds(int[] ids);
}
