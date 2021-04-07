package com.shop.converter.extend;

import com.shop.converter.impl.ConverterImpl;
import com.shop.model.entity.ProductEntity;
import com.shop.model.entity.UserEntity;
import com.shop.model.request.ProductRequest;
import com.shop.model.request.UserRequest;
import com.shop.model.response.ProductResponse;
import com.shop.model.response.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class UserConverters extends ConverterImpl<UserRequest, UserResponse, UserEntity>{

    @Override
    public UserEntity converToEntity(UserEntity userEntity, UserRequest userRequest) {
        return super.converToEntity(userEntity, userRequest);
    }

    @Override
    public UserResponse converToResponse(UserResponse userResponse, UserEntity userEntity) {
        return super.converToResponse(userResponse, userEntity);
    }
    @Override
    public List<UserResponse> convertToListResponse(List<UserEntity> ts){
        List<UserResponse> vs = new ArrayList<>();
            for (UserEntity userEntity: ts) {
                UserResponse userResponse = new UserResponse();
                userResponse= converToResponse(userResponse,userEntity);
                vs.add(userResponse);
            }
        return vs;
    }
}
