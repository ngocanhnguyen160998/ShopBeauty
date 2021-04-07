<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-user-wishlist"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- Start slider -->
<section id="aa-slider">
    <div class="aa-slider-area">
        <div id="sequence" class="seq">
            <div class="seq-screen">
                <ul class="seq-canvas">
                    <!-- single slide item -->
                    <li>
                        <div class="seq-model">
                            <img data-seq src="<c:url value="/template/web/img/slider/slide1.png"/>" alt="Men slide img" />
                        </div>
                    </li>
                    <!-- single slide item -->
                    <li>
                        <div class="seq-model">
                            <img data-seq src="<c:url value="/template/web/img/slider/slide4.jpg"/>"  />
                        </div>
                    </li>
                    <!-- single slide item -->
                    <li>
                        <div class="seq-model">
                            <img data-seq src="<c:url value="/template/web/img/slider/slide5.jpg"/>"  />
                        </div>
                    </li>
                    <!-- single slide item -->
                    <li>
                        <div class="seq-model">
                            <img data-seq src="<c:url value="/template/web/img/slider/slide2.jpg"/>"  />
                        </div>
                    </li>
                    <!-- single slide item -->
                    <li>
                        <div class="seq-model">
                            <img data-seq src="<c:url value="/template/web/img/slider/slide3.jpg"/>"  />
                        </div>
                    </li>
                </ul>
            </div>
            <!-- slider navigation btn -->
            <fieldset class="seq-nav" aria-controls="sequence" aria-label="Slider buttons">
                <a type="button" class="seq-prev" aria-label="Previous"><span class="fa fa-angle-left"></span></a>
                <a type="button" class="seq-next" aria-label="Next"><span class="fa fa-angle-right"></span></a>
            </fieldset>
        </div>
    </div>
</section>

<section id="aa-product">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="aa-product-area">
                        <div class="aa-product-inner">
                            <!-- start prduct navigation -->
                            <ul class="nav nav-tabs aa-products-tab">
                                <li class="active"><a href="#lips" data-toggle="tab">Son</a></li>
                                <li><a href="#skincare" data-toggle="tab">Chăm sóc da</a></li>
                                <li><a href="#makeup" data-toggle="tab">Trang điểm</a></li>
                                <li><a href="#perfume" data-toggle="tab">Nước hoa</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="lips">
                                    <ul class="aa-product-catg">
                                        <c:forEach var="item" items="${lips}">
                                            <li>
                                                <figure>
                                                    <a class="aa-product-img" href="/product/detail?id=${item.id}"><img src="<c:url value="${item.hinhAnh}"/>" alt="none"></a>
                                                    <a class="aa-add-card-btn"href="/MyCart?maSp=${item.id}&action=insert"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                                    <figcaption>
                                                        <h4 class="aa-product-title"><a href="/product/detail?id=${item.id}">${item.tenSanPham}</a></h4>
                                                        <span class="aa-product-price"><fmt:formatNumber value="${item.giaBan}" type="currency" ></fmt:formatNumber> </span>
                                                    </figcaption>
                                                </figure>
                                                <div class="aa-product-hvr-content">
                                                    <a href="/WishList?id=${item.id}&action=insert" data-toggle="tooltip" data-placement="top" title="Yêu thích"><span class="fa fa-heart-o"></span></a>
                                                    <a href="/product/detail?id=${item.id}" data-toggle="tooltip" data-placement="top" title="Chi tiết"><span class="fa fa-exchange"></span></a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <a class="aa-browse-btn" style="margin-left: 42%" href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=1">Tất cả sản phẩm <span class="fa fa-long-arrow-right"></span></a>
                                    <p><br></p>
                                </div>

                                <div class="tab-pane fade" id="skincare">
                                    <ul class="aa-product-catg">
                                        <c:forEach var="item" items="${skincare}">
                                            <li>
                                                <figure>
                                                    <a class="aa-product-img" href="/product/detail?id=${item.id}"><img src="<c:url value="${item.hinhAnh}"/>" alt="none"></a>
                                                    <a class="aa-add-card-btn"href="/MyCart?maSp=${item.id}&action=insert"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                                    <figcaption>
                                                        <h4 class="aa-product-title"><a href="/product/detail?id=${item.id}">${item.tenSanPham}</a></h4>
                                                        <span class="aa-product-price"><fmt:formatNumber value="${item.giaBan}" type="currency" ></fmt:formatNumber></span>
                                                    </figcaption>
                                                </figure>
                                                <div class="aa-product-hvr-content">
                                                    <a href="/WishList?id=${item.id}&page=1&maxPageItem=3&action=insert" data-toggle="tooltip" data-placement="top" title="Yêu thích"><span class="fa fa-heart-o"></span></a>
                                                    <a href="/product/detail?id=${item.id}" data-toggle="tooltip" data-placement="top" title="Chi tiết"><span class="fa fa-exchange"></span></a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <a class="aa-browse-btn" style="margin-left: 42%" href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=2">Tất cả sản phẩm <span class="fa fa-long-arrow-right"></span></a>
                                    <p><br></p>
                                </div>

                                <div class="tab-pane fade" id="makeup">
                                    <ul class="aa-product-catg">
                                        <c:forEach var="item" items="${makeup}">
                                            <li>
                                                <figure>
                                                    <a class="aa-product-img" href="/product/detail?id=${item.id}"><img src="<c:url value="${item.hinhAnh}"/>" alt="none"></a>
                                                    <a class="aa-add-card-btn"href="/MyCart?maSp=${item.id}&action=insert"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                                    <figcaption>
                                                        <h4 class="aa-product-title"><a href="/product/detail?id=${item.id}">${item.tenSanPham}</a></h4>
                                                        <span class="aa-product-price"><fmt:formatNumber value="${item.giaBan}" type="currency" ></fmt:formatNumber></span>
                                                    </figcaption>
                                                </figure>
                                                <div class="aa-product-hvr-content">
                                                    <a href="/WishList?id=${item.id}&page=1&maxPageItem=3&action=insert" data-toggle="tooltip" data-placement="top" title="Yêu thích"><span class="fa fa-heart-o"></span></a>
                                                    <a href="/product/detail?id=${item.id}" data-toggle="tooltip" data-placement="top" title="Chi tiết"><span class="fa fa-exchange"></span></a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <a class="aa-browse-btn" style="margin-left: 42%" href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=3">Tất cả sản phẩm <span class="fa fa-long-arrow-right"></span></a>
                                    <p><br></p>
                                </div>

                                <div class="tab-pane fade" id="perfume">
                                    <ul class="aa-product-catg">
                                        <c:forEach var="item" items="${perfume}">
                                            <li>
                                                <figure>
                                                    <a class="aa-product-img" href="/product/detail?id=${item.id}"><img src="<c:url value="${item.hinhAnh}"/>" alt="none"></a>
                                                    <a class="aa-add-card-btn"href="/MyCart?maSp=${item.id}&action=insert"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                                    <figcaption>
                                                        <h4 class="aa-product-title"><a href="/product/detail?id=${item.id}">${item.tenSanPham}</a></h4>
                                                        <span class="aa-product-price"><fmt:formatNumber value="${item.giaBan}" type="currency" ></fmt:formatNumber></span>
                                                    </figcaption>
                                                </figure>
                                                <div class="aa-product-hvr-content">
                                                    <a href="/WishList?id=${item.id}&page=1&maxPageItem=3&action=insert" data-toggle="tooltip" data-placement="top" title="Yêu thích"><span class="fa fa-heart-o"></span></a>
                                                    <a href="/product/detail?id=${item.id}" data-toggle="tooltip" data-placement="top" title="Chi tiết"><span class="fa fa-exchange"></span></a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <a class="aa-browse-btn" style="margin-left: 42%" href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=4">Tất cả sản phẩm <span class="fa fa-long-arrow-right"></span></a>
                                    <p><br></p>
                                </div>
                            </div>
                            <!-- quick view modal -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Products section -->
<!-- banner section -->
<section id="aa-banner">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="aa-banner-area">
                        <img src="<c:url value="/template/web/img/banner.jpg"/>" >
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="aa-support">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-support-area">
                    <!-- single support -->
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <div class="aa-support-single">
                            <span class="fa fa-truck"></span>
                            <h4>MIỄN PHÍ GIAO HÀNG</h4>
                        </div>
                    </div>
                    <!-- single support -->
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <div class="aa-support-single">
                            <span class="fa fa-clock-o"></span>
                            <h4>HOÀN TIỀN TRONG 3 NGÀY</h4>
                        </div>
                    </div>
                    <!-- single support -->
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <div class="aa-support-single">
                            <span class="fa fa-phone"></span>
                            <h4>TƯ VẤN, HỖ TRỢ 24/7</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Client Brand -->

<!-- / Cart view section -->
<%@ include file="/common/web/subscribe.jsp" %>
<%@ include file="/common/web/loginmodal.jsp" %>
</body>
</html>
