<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<body>
<%@ include file="/common/web/header.banner.1920x300.jsp" %>
<%int i=1;%>
<!-- Cart view section -->
<section id="cart-view">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="cart-view-area">
                    <div class="cart-view-table">
                        <form action="/MyCart" method="post">
                            <div class="table-responsive">
                                <H2 style="text-align: center">GIỎ HÀNG</H2>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>Ảnh</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Giá</th>
                                        <th>Số lượng</th>
                                        <th>Thành tiền</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${model}">
                                    <tr>
                                        <td><a class="remove" href="/MyCart?id=${item.id_myCard}&action=delete"><fa class="fa fa-close"></fa></a></td>
                                        <td><a href="/product/detail?id=${item.maSp}"><img src="<c:url value="${item.hinhAnh}"/>" alt="img"></a></td>
                                        <td><a class="aa-cart-title" href="/product/detail?id=${item.maSp}">${item.ten}</a></td>
                                        <td><fmt:formatNumber value="${item.giaBan}" type="currency" ></fmt:formatNumber></td>
                                        <td><input class="aa-cart-quantity" type="number" min="1" step="1" value="${item.soLuongMua}" name="index<%=i%>" placeholder=""></td>
                                        <td><fmt:formatNumber value="${item.tongTien}" type="currency" ></fmt:formatNumber></td>
                                    </tr>
                                        <%i++;%>
                                    </c:forEach>
                                    <tr>
                                        <td colspan="6" class="aa-cart-view-bottom" align="center">
                                            <input class="aa-cart-view-btn" type="submit" value="Cập nhật giỏ hàng" align="center">
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </form>
                        <!-- Cart Total view -->
                        <div class="cart-view-total">
                            <h4>Tổng tiền</h4>
                            <table class="aa-totals-table">
                                <tbody>
                                <tr>
                                    <th>Tổng</th>
                                    <td><fmt:formatNumber value="${sum}" type="currency" ></fmt:formatNumber></td>
                                </tr>
                                </tbody>
                            </table>
                            <a href="/checkout" class="aa-cart-view-btn">Thanh toán</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->
<%@ include file="/common/web/subscribe.jsp" %>
</body>
<head>
    <title>Card</title>
</head>
</html>
