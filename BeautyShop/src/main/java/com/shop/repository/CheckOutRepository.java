package com.shop.repository;


import com.shop.model.entity.CheckOutEntity;

public interface CheckOutRepository extends JpaRepository<CheckOutEntity, Integer> {
    int tongTien();
}
