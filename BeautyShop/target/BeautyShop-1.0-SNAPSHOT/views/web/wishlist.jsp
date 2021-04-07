<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>WishList</title>
</head>
<body>
<%@ include file="/common/web/header.banner.1920x300.jsp" %>
<!-- Cart view section -->
<section id="cart-view">
    <form action="<c:url value='/WishList'/>" id="formSubmit" method="get">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="cart-view-area">
                    <div class="cart-view-table aa-wishlist-table">
                        <form action="">
                            <div class="table-responsive">
                                <H2 style="text-align: center">DANH SÁCH YÊU THÍCH</H2>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>Ảnh</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Giá</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${model.listResult}">
                                    <tr>
                                        <td><a class="remove" href="/WishList?maSp=${item.maSp}&action=delete"><fa class="fa fa-close"></fa></a></td>
                                        <td><a href="/product/detail?id=${item.maSp}"><img src="<c:url value="${item.hinhAnh}"/>" alt="img"></a></td>
                                        <td><a class="aa-cart-title" href="/product/detail?id=${item.maSp}">${item.ten}</a></td>
                                        <td><fmt:formatNumber value="${item.giaBan}" type="currency" ></fmt:formatNumber></td>
                                        <td><a href="/MyCart?maSp=${item.maSp}&action=insert" class="aa-add-to-cart-btn">Thêm vào giỏ</a></td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div class="container">
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination" id="pagination"></ul>
                                        <input type="hidden" value="" id="page" name="page">
                                        <input type="hidden" value="" id="maxPageItem" name="maxPageItem">
                                    </nav>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
</section>
<!-- / Cart view section -->
</body>
</html>
