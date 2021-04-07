package com.shop.service.impl;

import com.shop.autowire.BeanFactory;
import com.shop.common.annotation.Service;
import com.shop.exception.ObjectNotFoundException;
import com.shop.model.entity.Role;
import com.shop.model.response.RoleResponse;
import com.shop.repository.RoleRepository;
import com.shop.repository.impl.RoleRepositoryImpl;
import com.shop.service.RoleService;
import com.shop.service.UserService;
import com.shop.util.ObjectUtil;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    public RoleServiceImpl(){
        roleRepository = (RoleRepository) BeanFactory.getBeans().get("roleRepository");
    }
    @Override
    public RoleResponse findById(int id)  {
        Role role = roleRepository.findById(id);
        if(role==null)
            try {
                throw new ObjectNotFoundException();
            } catch (ObjectNotFoundException e) {
                e.printStackTrace();
            }

        RoleResponse roleResponse = new RoleResponse();

        ObjectUtil.copyProperties(role,roleResponse);

        return roleResponse;
    }

    @Override
    public List<RoleResponse> findAll() {
        return null;
    }
    public static void main(String[] args) {
        UserService userService = (UserService) BeanFactory.getBeans().get("userService");//(RoleRepository) BeanFactory.getBeans().get("roleRepository");
        System.out.println(userService.findById(2));
    }
}
