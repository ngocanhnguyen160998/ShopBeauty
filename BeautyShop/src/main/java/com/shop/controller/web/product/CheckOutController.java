package com.shop.controller.web.product;

import com.shop.autowire.BeanFactory;
import com.shop.model.entity.CheckOutEntity;
import com.shop.model.request.Auth;
import com.shop.model.request.CheckOutRequest;
import com.shop.model.response.PageResponse;
import com.shop.model.response.UserResponse;
import com.shop.service.CardService;
import com.shop.service.CheckOutService;
import com.shop.service.WishListService;
import com.shop.service.impl.CheckOutServiceImpl;
import com.shop.service.session.SessionUtil;
import com.shop.util.FormUtil;
import com.shop.util.ObjectUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/checkout")
public class CheckOutController extends HttpServlet {
    private CardService cardService;
    private CheckOutService checkOutService;

    public CheckOutController() {
        cardService = (CardService) BeanFactory.getBeans().get("cardService");
        checkOutService = (CheckOutService) BeanFactory.getBeans().get("checkOutService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        UserResponse userResponse = (UserResponse) SessionUtil.getSession(req, "USER");
        req.setAttribute("model", checkOutService.listNameProduct(userResponse.getId()));
        req.setAttribute("sum", cardService.tongTien(userResponse.getId()));
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/checkout.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        UserResponse userResponse = (UserResponse) SessionUtil.getSession(req, "USER");
        CheckOutRequest checkOutRequest = FormUtil.toModel(CheckOutRequest.class, req);
        checkOutRequest.setModifiedDate(LocalDate.now());
        checkOutRequest.setListProduct(ObjectUtil.convertListToString(userResponse.getId()));
        checkOutRequest.setTongTien(cardService.tongTien(userResponse.getId()));
        checkOutRequest.setId_user(userResponse.getId());
        if (cardService.tongTien(userResponse.getId()) != 0) {
            checkOutService.insert(checkOutRequest);
            cardService.updateTinhTrang(userResponse.getId().toString(), 1);
        }
        resp.sendRedirect("/index");
    }
}
