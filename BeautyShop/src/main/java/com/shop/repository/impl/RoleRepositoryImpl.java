package com.shop.repository.impl;

import com.shop.common.annotation.Repository;
import com.shop.model.entity.Role;
import com.shop.model.entity.UserEntity;
import com.shop.repository.RoleRepository;

import java.util.List;

@Repository
public class RoleRepositoryImpl extends BasicQuery<Role, Integer> implements RoleRepository {
    @Override
    public <S extends Role> S findById(Integer integer) {
        return super.findById(integer);
    }

    @Override
    public <S extends Role> List<S> findAll() {
        return super.findAll();
    }
}
