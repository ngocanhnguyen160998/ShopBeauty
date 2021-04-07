package com.shop.controller.web.product;

import com.shop.autowire.BeanFactory;
import com.shop.model.entity.ProductEntity;
import com.shop.model.response.PageResponse;
import com.shop.model.response.ProductResponse;
import com.shop.paging.PageRequest;
import com.shop.repository.ProductRepository;
import com.shop.service.ProductService;
import com.shop.service.session.SessionUtil;
import com.shop.util.FormUtil;
import com.shop.util.HttpUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchController extends HttpServlet {
    private ProductService productService;
    private PageResponse<ProductResponse> pageResponse;
    public SearchController() {
        productService= (ProductService) BeanFactory.getBeans().get("productService");
        pageResponse= new PageResponse<>();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageResponse pageResponse = FormUtil.toModel(PageResponse.class, request);
        response.sendRedirect("/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten="+pageResponse.getTen()+"");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
