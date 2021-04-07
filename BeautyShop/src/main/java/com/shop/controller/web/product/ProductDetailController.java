package com.shop.controller.web.product;

import com.shop.autowire.BeanFactory;
import com.shop.model.entity.ProductEntity;
import com.shop.model.response.PageResponse;
import com.shop.model.response.ProductResponse;
import com.shop.service.ProductService;
import com.shop.util.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/detail")
public class ProductDetailController extends HttpServlet {
    private ProductService productService;
    public ProductDetailController() {
        productService= (ProductService) BeanFactory.getBeans().get("productService");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductEntity productEntity= productService.findById(id);
        productEntity.getIdMenuCon();
        request.setAttribute("entity",productEntity);
        request.setAttribute("related",productService.findAllById("idMenuCon", String.valueOf(productEntity.getIdMenuCon()),"null","null"));
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/product/product-detail.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
