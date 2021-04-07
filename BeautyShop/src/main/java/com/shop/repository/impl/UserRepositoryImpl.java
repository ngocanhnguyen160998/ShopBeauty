package com.shop.repository.impl;

import com.shop.common.annotation.Repository;
import com.shop.model.entity.UserEntity;
import com.shop.paging.PageRequest;
import com.shop.repository.UserRepository;
import com.shop.util.ObjectUtil;
import com.shop.util.pool.ConnectionPoolImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends BasicQuery<UserEntity, Integer> implements UserRepository {
    @Override
    public Optional<UserEntity> findByUserNameAndPassWord(String userName, String password) {
        String sql = "SELECT * FROM user WHERE user_name = ? AND password = ?";
        Connection connection = ((ConnectionPoolImpl)(connectionPool)).takeOut();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, userName);
            ps.setObject(2, password);
            ResultSet rs = ps.executeQuery();
            UserEntity userEntity = null;
            while (rs.next()) {
                userEntity = (UserEntity) ObjectUtil.map(tClass, rs);
            }
            ((ConnectionPoolImpl)(connectionPool)).takeIn(connection);
            return Optional.ofNullable(userEntity);
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <S extends UserEntity> S insert(UserEntity entity) throws SQLException {
        return super.insert(entity);
    }

    @Override
    public <S extends UserEntity> List<S> findAll(){
        return super.findAll();
    }

    @Override
    public <S extends UserEntity> S findById(Integer integer) {
        return super.findById(integer);
    }

    @Override
    public void update(UserEntity entity, int ID) {
        super.update(entity);
    }

    @Override
    public void deleteByIds(int[] ids) {
        for (int id: ids) {
            new UserRepositoryImpl().delete(id);
        }
    }


}
