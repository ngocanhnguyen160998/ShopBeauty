package com.shop.controller.admin.api;

import com.shop.autowire.BeanFactory;
import com.shop.model.entity.ProductEntity;
import com.shop.model.response.PageResponse;
import com.shop.repository.ProductRepository;
import com.shop.util.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/api-admin-product")
public class ProductApi extends HttpServlet {
    private ProductRepository productRepository;

    public ProductApi() {
        this.productRepository = (ProductRepository) BeanFactory.getBeans().get("productRepository");
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

        ProductEntity productEntity = HttpUtil.of(req.getReader()).toModel(ProductEntity.class);
        productEntity.setNgayDang(LocalDate.now());
        try {
            productEntity= productRepository.insert(productEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mapper.writeValue(resp.getOutputStream(),productEntity);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductEntity updateProduct = HttpUtil.of(req.getReader()).toModel(ProductEntity.class);
        updateProduct.setNgayDang(LocalDate.now());
        try {
            productRepository.update(updateProduct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mapper.writeValue(resp.getOutputStream(),updateProduct);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PageResponse pageResponse = HttpUtil.of(req.getReader()).toModel(PageResponse.class);
        ProductEntity productEntity = HttpUtil.of(req.getReader()).toModel(ProductEntity.class);
        int[] a = pageResponse.getIds();
        productRepository.deleteByIds(pageResponse.getIds());
        mapper.writeValue(resp.getOutputStream(),productEntity);
    }
}
