package com.shop.controller.admin.Order;

import com.shop.autowire.BeanFactory;
import com.shop.model.response.CheckOutResponse;
import com.shop.service.CheckOutService;
import com.shop.util.ObjectUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-table-order-detail")
public class OrderDetailController extends HttpServlet {
    private CheckOutService checkOutService;

    public OrderDetailController() {
        this.checkOutService = (CheckOutService) BeanFactory.getBeans().get("checkOutService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        CheckOutResponse checkOutResponse = checkOutService.findById(Integer.valueOf(id));
        req.setAttribute("model",checkOutResponse);
        req.setAttribute("product", ObjectUtil.convertStringToList(checkOutResponse.getListProduct()));
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/order/orderdetail.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
