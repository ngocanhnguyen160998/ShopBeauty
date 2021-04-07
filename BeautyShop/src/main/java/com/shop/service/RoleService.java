package com.shop.service;

import com.shop.model.response.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse findById(int id);
    List<RoleResponse> findAll();
}
