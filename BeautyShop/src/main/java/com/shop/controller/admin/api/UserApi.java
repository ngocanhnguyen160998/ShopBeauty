package com.shop.controller.admin.api;

import com.shop.autowire.BeanFactory;
import com.shop.model.entity.UserEntity;
import com.shop.model.response.PageResponse;
import com.shop.repository.UserRepository;
import com.shop.repository.impl.UserRepositoryImpl;
import com.shop.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/api-admin-user")
public class UserApi extends HttpServlet {
    private UserRepository userRepository;

    public UserApi() {
        this.userRepository = (UserRepository) BeanFactory.getBeans().get("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        UserEntity userEntity = HttpUtil.of(req.getReader()).toModel(UserEntity.class);
        try {
            if(userEntity.getUserName() != "" && userEntity.getPassword() != "" && userEntity.getPhone() != "" && userEntity.getEmail() != ""){
                userEntity = userRepository.insert(userEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mapper.writeValue(resp.getOutputStream(),userEntity);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        UserEntity updateUser = HttpUtil.of(req.getReader()).toModel(UserEntity.class);
        try {
            if(updateUser.getUserName() != "" && updateUser.getPassword() != "" && updateUser.getPhone() != "" && updateUser.getEmail() != "") {
                userRepository.update(updateUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mapper.writeValue(resp.getOutputStream(),updateUser);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PageResponse pageResponse = HttpUtil.of(req.getReader()).toModel(PageResponse.class);
        UserEntity userEntity = HttpUtil.of(req.getReader()).toModel(UserEntity.class);
        int[] a = pageResponse.getIds();
        userRepository.deleteByIds(pageResponse.getIds());
        mapper.writeValue(resp.getOutputStream(),userEntity);
    }
}
