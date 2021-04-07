package com.shop.controller;

import com.shop.common.constant.RoleConstant;
import com.shop.exception.ObjectNotFoundException;
import com.shop.model.request.Auth;
import com.shop.model.response.PageResponse;
import com.shop.model.response.ProductResponse;
import com.shop.model.response.RoleResponse;
import com.shop.security.Authen;
import com.shop.service.session.SessionUtil;
import com.shop.util.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {
    private PageResponse<ProductResponse> pageResponse;

    public LoginController() {
        this.pageResponse = new PageResponse<>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            String messsage = request.getParameter("message");
            if (messsage != null ) {
                request.setAttribute("message", "Wrong account or password");
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.removeSession(request, "USER");
            response.sendRedirect(request.getContextPath() + "/index");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Auth auth = FormUtil.toModel(Auth.class, request);
        try {
            String url = Authen.of().auth(auth, request);
            response.sendRedirect(url);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | SQLException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ObjectNotFoundException | NullPointerException e) {
            response.sendRedirect("/login?action=login&message=wrong_account_or_password");
        }
    }
}
