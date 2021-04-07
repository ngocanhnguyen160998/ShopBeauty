package com.shop.repository.impl;

import com.shop.common.annotation.Repository;
import com.shop.model.entity.CardEntity;
import com.shop.model.entity.SyntheticEntity;
import com.shop.model.entity.WishListEntity;
import com.shop.paging.Pageable;
import com.shop.repository.WishlistRepository;
import com.shop.util.pool.ConnectionPoolImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class WistlistRepositoryImpl extends BasicQuery<WishListEntity, Integer> implements WishlistRepository {
    @Override
    public <S extends WishListEntity> List<S> findAll(){
        return super.findAll();
    }
    @Override
    public boolean kiemTraSanPhamCoTrongGioHangChua(int maSanPham, Integer id_user){
        WishlistRepository wishlistRepository = new WistlistRepositoryImpl();
        List<WishListEntity>  entities = wishlistRepository.findByCondition(id_user.toString());
        for (WishListEntity wishListEntity : entities) {
            if (wishListEntity.getId() == maSanPham){
                return true;
            }
        }
        return false;
    }
    @Override
    public List<SyntheticEntity> findAllByIdUser(Pageable pageable,String name, String idUser) {
        Connection connection = ((ConnectionPoolImpl)(connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder("Select SanPham.maSp,hinhAnh,ten,giaBan, soLuongBan,id from SanPham, DANHSACHYEUTHICH").append(" where SanPham.maSp = DANHSACHYEUTHICH.maSp")
                .append(Query.AND).append(name).append(" = ").append(idUser);
        if (pageable.getPage() !=0){
            sql.append(Query.LIMIT).append(pageable.getPage())
                    .append(Query.OFFSET).append(pageable.getOffset());
        }
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            List<SyntheticEntity> list = new ArrayList<>();
            while (resultSet.next()){
                SyntheticEntity syntheticEntity= new SyntheticEntity();
                syntheticEntity.setMaSp(resultSet.getString(1));
                syntheticEntity.setHinhAnh(resultSet.getString(2));
                syntheticEntity.setTen(resultSet.getString(3));
                syntheticEntity.setGiaBan(resultSet.getInt(4));
                syntheticEntity.setSoLuongBan(resultSet.getInt(5));
                syntheticEntity.setId(resultSet.getInt(6));
                list.add(syntheticEntity);
            }
            return list;
        } catch (SQLException e) {
            return null;
        }finally {
            ((ConnectionPoolImpl)connectionPool).takeIn(connection);
        }
    }

    @Override
    public void deleteByIds(int[] ids) {
        for (int id: ids) {
            new UserRepositoryImpl().delete(id);
        }
    }

}
