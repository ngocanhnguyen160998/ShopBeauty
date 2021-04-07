package com.shop.controller.admin.Order;

import com.shop.autowire.BeanFactory;
import com.shop.common.constant.CRUD;
import com.shop.model.response.CheckOutResponse;
import com.shop.model.response.PageResponse;
import com.shop.paging.PageRequest;
import com.shop.repository.impl.RoleRepositoryImpl;
import com.shop.service.CheckOutService;
import com.shop.util.FormUtil;
import com.shop.util.MessageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/admin-report")
public class ReportController extends HttpServlet {

    private CheckOutService checkOutService;

    public ReportController() {
        this.checkOutService = (CheckOutService) BeanFactory.getBeans().get("checkOutService");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename = report_"+ LocalDate.now() +".xls");
        String time = LocalTime.now().toString();
        PageResponse<CheckOutResponse> pageResponse = FormUtil.toModel(PageResponse.class, request);
        pageResponse.setListResult(checkOutService.findAll());
        request.setAttribute("model", pageResponse);
        request.setAttribute("date", LocalDate.now());
        request.setAttribute("time", time.substring(0,5));
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/order/report.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
