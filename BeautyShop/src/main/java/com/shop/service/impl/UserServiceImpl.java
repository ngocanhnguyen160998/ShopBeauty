package com.shop.service.impl;

import com.shop.autowire.BeanFactory;
import com.shop.common.annotation.Service;
import com.shop.converter.UserConverter;
import com.shop.converter.extend.UserConverters;
import com.shop.exception.ObjectNotFoundException;
import com.shop.model.entity.ProductEntity;
import com.shop.model.entity.UserEntity;
import com.shop.model.request.Auth;
import com.shop.model.request.UserRequest;
import com.shop.model.response.UserResponse;
import com.shop.paging.Pageable;
import com.shop.repository.UserRepository;
import com.shop.repository.impl.UserRepositoryImpl;
import com.shop.service.UserService;
import com.shop.util.MySqlConnectionUtil;
import com.shop.util.ObjectUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserConverters userConverter;

    public UserServiceImpl() {
        userRepository = (UserRepository) BeanFactory.getBeans().get("userRepository");
        userConverter = new UserConverters();
    }

    @Override
    public void insert(UserRequest request) throws SQLException {
        UserEntity entity = UserConverter.converToEntity(request);
        new UserRepositoryImpl().insert(entity);
    }

    @Override
    public void update(UserRequest request, int id1){
        UserEntity entity = UserConverter.converToEntity(request, id1);
        new UserRepositoryImpl().update(entity);
    }

    @Override
    public UserResponse findUserByUserNameAndPassWord(Auth auth){
        Optional<UserEntity> userEntity = userRepository.findByUserNameAndPassWord(auth.getUserName(), auth.getPassword());

        UserResponse userResponse = new UserResponse();
        try {
            userEntity.orElseThrow(ObjectNotFoundException::new);
            ObjectUtil.copyProperties(userEntity.get(),userResponse);
            return userResponse;
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserResponse> findAll()  {
        List<UserEntity> userEntities= new UserRepositoryImpl().findAll();
        return userConverter.convertToListResponse(userEntities);
    }

    @Override
    public void delete(int id) {
        try {
            userRepository.delete(id);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserEntity findById(Integer id) {
        return new UserRepositoryImpl().findById(id);
    }

    @Override
    public void deleteByIds(int[] ids) {
        for (int id: ids) {
            new UserRepositoryImpl().delete(id);
        }
    }

    @Override
    public List<UserResponse> findAll(Pageable pageable) {
        List<UserEntity> userEntities= new UserRepositoryImpl().findAll(pageable);
        return userConverter.convertToListResponse(userEntities);
    }

    @Override
    public void update(String passN, int Id) {
        String sql = "update User set Password = "+passN+" where id="+Id+"";
        try {
            new MySqlConnectionUtil().thucThiCauLenhSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
