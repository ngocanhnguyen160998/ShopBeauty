package com.shop.repository;

import com.shop.common.annotation.Repository;
import com.shop.model.entity.ProductEntity;
import com.shop.paging.Pageable;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findAll();
    ProductEntity findById(Integer id);
    List<ProductEntity> findAllLimit3();
    void deleteByIds(int[] ids);
    List<ProductEntity> findAllByCategory(Pageable pageable, String sortName, String sortBy, String idMenuCon);
}
