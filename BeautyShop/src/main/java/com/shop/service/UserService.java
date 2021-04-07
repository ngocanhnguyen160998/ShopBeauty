package com.shop.service;

import com.shop.exception.ObjectNotFoundException;
import com.shop.model.entity.ProductEntity;
import com.shop.model.entity.UserEntity;
import com.shop.model.request.Auth;
import com.shop.model.request.UserRequest;
import com.shop.model.response.ProductResponse;
import com.shop.model.response.UserResponse;
import com.shop.paging.Pageable;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void insert(UserRequest request) throws SQLException;

    void update(UserRequest request, int id) throws SQLException;

    UserResponse findUserByUserNameAndPassWord(Auth auth);

    List<UserResponse> findAll();

    void delete (int id) throws NoSuchFieldException;

    UserEntity findById(Integer id);

    void deleteByIds(int[] ids);

    List<UserResponse> findAll(Pageable pageable);

    void update(String passN, int Id);
}
