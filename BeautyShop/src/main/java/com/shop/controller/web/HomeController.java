package com.shop.controller.web;

import com.shop.autowire.BeanFactory;
import com.shop.model.entity.ProductEntity;
import com.shop.model.response.UserResponse;
import com.shop.repository.ProductRepository;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.CardService;
import com.shop.service.CheckOutService;
import com.shop.service.ProductService;
import com.shop.service.session.SessionUtil;
import com.shop.util.HttpUtil;
import com.sun.xml.internal.fastinfoset.algorithm.BASE64EncodingAlgorithm;
import org.omg.PortableServer.POA;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class HomeController extends HttpServlet {
    private ProductService productService;
    public HomeController() {
        productService= (ProductService) BeanFactory.getBeans().get("productService");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpUtil.setCategory(request,productService);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
