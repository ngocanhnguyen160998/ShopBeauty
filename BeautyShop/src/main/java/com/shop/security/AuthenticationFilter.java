package com.shop.security;

import com.shop.common.constant.RoleConstant;
import com.shop.model.response.RoleResponse;
import com.shop.model.response.UserResponse;
import com.shop.service.RoleService;
import com.shop.service.impl.RoleServiceImpl;
import com.shop.service.session.SessionUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin-home", "/admin-table-order-detail", "/admin-table-order", "/admin-table-product", "/admin-table-product-insert", "/admin-home-email", "/admin-table", "/WishList", "/MyCart", "/checkout"})
public class AuthenticationFilter implements Filter {

    private RoleService roleService;

    public AuthenticationFilter() {
        roleService = new RoleServiceImpl();
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        RoleResponse roleResponse = null;

        String url = request.getRequestURI();
        UserResponse userResponse = (UserResponse) SessionUtil.getSession(request, "USER");
        if (userResponse != null) {
            if (url.startsWith(request.getContextPath() + "/admin")) {
                roleResponse = roleService.findById(userResponse.getRoleId());
                if (RoleConstant.ADMIN.getValue().equals(roleResponse.getName())) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (RoleConstant.USER.getValue().equals(roleResponse.getName())) {
                    response.sendRedirect((request.getContextPath() + "/index"));
                }
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            response.sendRedirect((request.getContextPath() + "/login?action=login"));
        }
    }

    @Override
    public void destroy() {

    }
}
