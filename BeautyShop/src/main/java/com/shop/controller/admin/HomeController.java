package com.shop.controller.admin;

import com.shop.autowire.BeanFactory;
import com.shop.paging.PageRequest;
import com.shop.paging.Pageable;
import com.shop.repository.ProductRepository;
import com.shop.repository.impl.CheckOutRepositoryImpl;
import com.shop.service.CheckOutService;
import com.shop.service.ProductService;
import com.shop.service.impl.ProductServiceImpl;
import com.shop.util.FormUtil;
import com.opensymphony.module.sitemesh.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {
    private CheckOutService checkOutService;

    public HomeController() {
        checkOutService= (CheckOutService) BeanFactory.getBeans().get("checkOutService");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("order",checkOutService.findAll());
        request.setAttribute("revenue",checkOutService.tongTien());
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
