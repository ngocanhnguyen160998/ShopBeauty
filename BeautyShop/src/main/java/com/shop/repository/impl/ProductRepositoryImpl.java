package com.shop.repository.impl;

import com.shop.common.annotation.Repository;
import com.shop.model.entity.ProductEntity;
import com.shop.paging.Pageable;
import com.shop.repository.ProductRepository;
import com.shop.util.AnnotationUtil;
import com.shop.util.ObjectUtil;
import com.shop.util.pool.ConnectionPoolImpl;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl extends BasicQuery<ProductEntity, Integer> implements ProductRepository {
    @Override
    public List<ProductEntity> findAll() {
        return super.findAll();
    }

    @Override
    public ProductEntity findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<ProductEntity> findAllLimit3() {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT).append(AnnotationUtil.getTableName(tClass));
        sql.append(" limit 3");
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            List<ProductEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                ProductEntity t = (ProductEntity) ObjectUtil.map(tClass, resultSet);
                list.add(t);

            }
            return (List<ProductEntity>) list;
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            return null;
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    @Override
    public void deleteByIds(int[] ids) {
        for (int id : ids) {
            new ProductRepositoryImpl().delete(id);
        }
    }

    @Override
    public List<ProductEntity> findAllByCategory(Pageable pageable, String sortName, String sortBy, String idMenuCon) {
//        String sql = "SELECT * FROM SANPHAM WHERE idMenuCon=?";
//        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setObject(1, idMenuCon);
//            ResultSet rs = preparedStatement.executeQuery();
//            List<ProductEntity> list = new ArrayList<>();
//            while (rs.next()) {
//                ProductEntity t = (ProductEntity) ObjectUtil.map(tClass, rs);
//                list.add(t);
//            }
//            return list;
//        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT)
                .append(AnnotationUtil.getTableName(tClass));
        if (idMenuCon != null && !idMenuCon.equals("") && !idMenuCon.equals("null")) {
            sql.append(Query.WHERE).append("idMenuCon = ").append(idMenuCon);
        }
        if (sortName != null && sortBy != null && StringUtils.isNotBlank(sortName) && StringUtils.isNotBlank(sortBy) && !sortName.equals("null") && !sortBy.equals("null")) {
            sql.append(Query.ORDER_BY).append(sortName).append(" ").append(sortBy);
        }
        sql.append(Query.LIMIT).append(pageable.getPage())
                .append(Query.OFFSET).append(pageable.getOffset());
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            List<ProductEntity> list = new ArrayList<>();
            while (rs.next()) {
                ProductEntity t = (ProductEntity) ObjectUtil.map(tClass, rs);
                list.add(t);
            }

            return list;
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
        return null;
    }

    @Override
    public <S extends ProductEntity> List<S> findAllById(String name, String idUser, String orderName, String orderBy) {
        return super.findAllById(name, idUser, orderName, orderBy);
    }

    @Override
    public <S extends ProductEntity> List<S> findAll(Pageable pageable) {
        return super.findAll(pageable);
    }

    @Override
    public <S extends ProductEntity> List<S> findAll(Pageable pageable, String sortName, String sortBy, String nameProduct) {
        return super.findAll(pageable, sortName, sortBy, nameProduct);
    }


    @Override
    public long count() {
        return super.count();
    }

    @Override
    public long countById(String name, String conditions) {
        return super.countById(name, conditions);
    }
}
