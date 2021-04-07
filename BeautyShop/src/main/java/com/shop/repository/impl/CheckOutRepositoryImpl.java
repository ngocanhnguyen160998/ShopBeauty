package com.shop.repository.impl;


import com.shop.model.entity.CheckOutEntity;
import com.shop.repository.CheckOutRepository;
import com.shop.util.pool.ConnectionPoolImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class CheckOutRepositoryImpl extends BasicQuery<CheckOutEntity, Integer> implements CheckOutRepository {
    @Override
    public int tongTien() {
        Connection connection = ((ConnectionPoolImpl)(connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder("select sum(tongtien) from donhang");
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            int a = 0;
            while (resultSet.next()){
                a=resultSet.getInt(1);
            }
            return a;
        } catch (SQLException e) {
            return 0;
        }finally {
            ((ConnectionPoolImpl)connectionPool).takeIn(connection);
        }
    }
}
