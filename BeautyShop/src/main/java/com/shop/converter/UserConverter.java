package com.shop.converter;

import com.shop.model.entity.UserEntity;
import com.shop.model.request.UserRequest;
import com.shop.model.response.UserResponse;
import com.shop.util.ObjectUtil;

public class UserConverter {
    public static UserEntity converToEntity(UserRequest userRequest){
        UserEntity userEntity = new UserEntity();

            ObjectUtil.copyProperties(userRequest, userEntity);

        return userEntity;
    }
    public static UserEntity converToEntity(UserRequest userRequest, int id){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);

            ObjectUtil.copyProperties(userRequest, userEntity);

        return userEntity;
    }
    public static UserResponse converToRespond(UserEntity entity) {
        UserResponse response = new UserResponse();

            ObjectUtil.copyProperties(entity, response);

        return response;
    }
}
