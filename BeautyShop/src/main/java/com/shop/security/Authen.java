package com.shop.security;

import com.shop.autowire.BeanFactory;
import com.shop.common.constant.RoleConstant;
import com.shop.exception.ObjectNotFoundException;
import com.shop.model.request.Auth;
import com.shop.model.response.RoleResponse;
import com.shop.model.response.UserResponse;
import com.shop.service.RoleService;
import com.shop.service.UserService;
import com.shop.service.impl.RoleServiceImpl;
import com.shop.service.impl.UserServiceImpl;
import com.shop.service.session.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Authen {
    public static Authen of() {
        return new Authen();
    }

    public String auth(Auth auth, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException, ObjectNotFoundException, InstantiationException, SQLException, NoSuchMethodException, NoSuchFieldException {
        UserResponse userResponse = new UserServiceImpl().findUserByUserNameAndPassWord(auth);
        SessionUtil.setSession(request, "USER", userResponse);
        if (userResponse == null) {
            SessionUtil.removeSession(request, "USER");
        }
        String url = null;
        RoleResponse roleResponse = new RoleServiceImpl().findById(userResponse.getRoleId());
        if (RoleConstant.ADMIN.getValue().equals(roleResponse.getName())) {
            url = "/admin-home";
        } else if (RoleConstant.USER.getValue().equals(roleResponse.getName())) {
            url = "/index";
        }
        return url;
    }
}
