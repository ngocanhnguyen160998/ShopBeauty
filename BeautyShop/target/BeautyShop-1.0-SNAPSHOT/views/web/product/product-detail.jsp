<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/common/web/header.banner.1920x300.jsp" %>
<section id="aa-product-details">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-product-details-area">
                    <div class="aa-product-details-content">
                        <div class="row">
                            <div class="col-md-5 col-sm-5 col-xs-12">
                                <div class="aa-product-view-slider">
                                    <div id="demo-1" class="simpleLens-gallery-container">
                                        <div class="simpleLens-container">
                                            <div class="simpleLens-big-image-container"><a data-lens-image="img/view-slider/large/polo-shirt-1.png" class="simpleLens-lens-image"><img src="<c:url value="${entity.hinhAnh}"/>"></a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-7 col-sm-7 col-xs-12">
                                <div class="aa-product-view-content">
                                    <h3>${entity.tenSanPham}</h3>
                                    <div class="aa-price-block">
                                        <span class="aa-product-view-price">Giá bán: <h2 style="color: orangered"><fmt:formatNumber value="${entity.giaBan}" type="currency" ></fmt:formatNumber></h2></span>
                                    </div>
                                    <p>${entity.thongTinChiTiet}</p>
                                    <div class="aa-prod-view-bottom">
                                        <a class="aa-add-to-cart-btn" href="/MyCart?maSp=${entity.id}&action=insert">Thêm vào giỏ</a>
                                        <a class="aa-add-to-cart-btn" href="/WishList?id=${entity.id}&action=insert">Yêu thích</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="aa-product-related-item">
                        <h3>Các sản phẩm liên quan</h3>
                        <ul class="aa-product-catg aa-related-item-slider">
                            <c:forEach var="item" items="${related}">
                                <li>
                                    <figure>
                                        <a class="aa-product-img" href="/product/detail?id=${item.id}"><img src="<c:url value="${item.hinhAnh}"/>" ></a>
                                        <a class="aa-add-card-btn"href="#"><span class="fa fa-shopping-cart"></span>Add To Cart</a>
                                        <figcaption>
                                            <h4 class="aa-product-title"><a href="/product/detail?id=${item.id}">${item.tenSanPham}</a></h4>
                                            <span class="aa-product-price"><fmt:formatNumber value="${entity.giaBan}" type="currency" ></fmt:formatNumber></span>
                                        </figcaption>
                                    </figure>
                                    <div class="aa-product-hvr-content">
                                        <a href="#" data-toggle="tooltip" data-placement="top" title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
                                        <a href="/product/detail?id=${item.id}" data-toggle="tooltip" data-placement="top" title="View detail"><span class="fa fa-exchange"></span></a>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@ include file="/common/web/subscribe.jsp" %>
</body>
</html>
