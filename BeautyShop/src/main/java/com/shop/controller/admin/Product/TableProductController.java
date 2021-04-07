package com.shop.controller.admin.Product;

import com.shop.autowire.BeanFactory;
import com.shop.common.constant.CRUD;
import com.shop.model.entity.ProductEntity;
import com.shop.model.entity.UserEntity;
import com.shop.model.response.PageResponse;
import com.shop.model.response.ProductResponse;
import com.shop.paging.PageRequest;
import com.shop.repository.impl.RoleRepositoryImpl;
import com.shop.service.ProductService;
import com.shop.util.FormUtil;
import com.shop.util.MessageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-table-product")
public class TableProductController extends HttpServlet {
    private ProductService productService;
    public TableProductController() {
        this.productService = (ProductService) BeanFactory.getBeans().get("productService");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PageResponse<ProductResponse> pageResponse = FormUtil.toModel(PageResponse.class, request);
        String url = "";
        if (pageResponse.getType().equalsIgnoreCase(String.valueOf(CRUD.LIST))){
            pageResponse.setTotalItem((int) productService.count());
            pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getMaxPageItem()));
            PageRequest pageRequest = new PageRequest(pageResponse.getPage(), pageResponse.getMaxPageItem());
            pageResponse.setListResult(productService.findAll(pageRequest,pageResponse.getSortBy(),pageResponse.getSortName(),pageResponse.getTen()));
            request.setAttribute("model",pageResponse);
            url= "/views/admin/product/table.jsp";
        }else if (pageResponse.getType().equalsIgnoreCase(String.valueOf(CRUD.EDIT))){
            String id = request.getParameter("id");
            if (id != null){
                ProductEntity productEntity = productService.findById(Integer.valueOf(id));
                request.setAttribute("product",productEntity);
            }
            url="/views/admin/product/edit.jsp";
            request.setAttribute("model",pageResponse);
            request.setAttribute("role", new RoleRepositoryImpl().findAll());
        }
        MessageUtil.showMessage(request);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
