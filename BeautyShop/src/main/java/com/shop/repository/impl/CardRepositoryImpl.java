package com.shop.repository.impl;

import com.shop.common.annotation.Repository;
import com.shop.model.entity.CardEntity;
import com.shop.model.entity.SyntheticEntity;
import com.shop.model.entity.WishListEntity;
import com.shop.repository.CardRepository;
import com.shop.util.AnnotationUtil;
import com.shop.util.MySqlConnectionUtil;
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
public class CardRepositoryImpl extends BasicQuery<CardEntity, Integer> implements CardRepository {

    @Override
    public boolean kiemTraSanPhamCoTrongCard(int maSanPham, String id_user) {
        CardRepository cardRepository = new CardRepositoryImpl();
        List<CardEntity> entities = cardRepository.findByCondition(" tinhTrang = 0", id_user);
        for (CardEntity cardEntity : entities) {
            if (cardEntity.getMaSp() == maSanPham) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<SyntheticEntity> findAllByIdUser(String name, String idUser) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder("select SanPham.hinhAnh, SanPham.ten,SanPham.giaBan, soLuongMua , (soLuongMua*giaBan), SanPham.maSp, id_mycart from GIOHANG, sanpham").append(" where GIOHANG.maSp = SanPham.maSp and tinhTrang = 0")
                .append(Query.AND).append(name).append(" = ").append(idUser);
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            List<SyntheticEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                SyntheticEntity syntheticEntity = new SyntheticEntity();
                syntheticEntity.setHinhAnh(resultSet.getString(1));
                syntheticEntity.setTen(resultSet.getString(2));
                syntheticEntity.setGiaBan(resultSet.getInt(3));
                syntheticEntity.setSoLuongMua(resultSet.getInt(4));
                syntheticEntity.setTongTien(resultSet.getInt(5));
                syntheticEntity.setMaSp(resultSet.getString(6));
                syntheticEntity.setId_myCard(resultSet.getInt(7));
                list.add(syntheticEntity);
            }
            return list;
        } catch (SQLException e) {
            return null;
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    @Override
    public int tongTien(int id_User) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder("select sum((soLuongMua*GiaBan)) from giohang,sanpham where  GIOHANG.maSp = SanPham.maSp AND tinhTrang = 0 AND id_user = " + id_User + ";");
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            int a = 0;
            while (resultSet.next()) {
                a = resultSet.getInt(1);
            }
            return a;
        } catch (SQLException e) {
            return 0;
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    @Override
    public void updateCard(String soLuong, String id, String maSp) throws SQLException {
        String sql = "update GIOHANG set soLuongMua = " + soLuong + " where id_user=" + id + " and GIOHANG.maSp=" + maSp + "";
        try {
            new MySqlConnectionUtil().thucThiCauLenhSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTinhTrang(String id, Integer tinhTrang) {
        String sql = "update GIOHANG set tinhTrang = " + tinhTrang + " where id_user=" + id + "";
        try {
            new MySqlConnectionUtil().thucThiCauLenhSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public <S extends CardEntity> S findById(Integer integer) {
        return super.findById(integer);
    }


}
