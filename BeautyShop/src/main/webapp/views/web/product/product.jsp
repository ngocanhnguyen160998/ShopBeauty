<%@ page import="com.shop.repository.ProductRepository" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="com.shop.repository.impl.ProductRepositoryImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Product</title>
</head>
<body>
<%@ include file="/common/web/header.banner.1920x300.jsp" %>
<!-- product category -->
<%
    ProductRepository product = new ProductRepositoryImpl();
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMinimumIntegerDigits(0);
%>
<section id="aa-product-category">
    <form <c:url value='/product'/> id="formSubmit">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
                    <div class="aa-product-catg-content">
                        <div class="aa-product-catg-head">
                            <div class="aa-product-catg-head-right">
                                <a id="grid-catg" href="#"><span class="fa fa-th"></span></a>
                                <a id="list-catg" href="#"><span class="fa fa-list"></span></a>
                            </div>
                        </div>
                        <div class="aa-product-catg-body">
                            <ul class="aa-product-catg">
                                <c:forEach var="item" items="${model.listResult}">
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="/product/detail?id=${item.id}"><img
                                                    src="<c:url value="${item.hinhAnh}"/>" alt="${item.tenSanPham}"></a>
                                            <a class="aa-add-card-btn"
                                               href="/MyCart?maSp=${item.id}&action=insert"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a
                                                        href="/product/detail?id=${item.id}">${item.tenSanPham}</a></h4>
                                                <span class="aa-product-price"><fmt:formatNumber value="${item.giaBan}"
                                                                                                 type="currency"></fmt:formatNumber></span><span
                                                    class="aa-product-price"></span>
                                                <p class="aa-product-descrip">${item.thongTinChiTiet}</p>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="/WishList?id=${item.id}&page=1&maxPageItem=3&action=insert"
                                               data-toggle="tooltip" data-placement="top" title="Yêu thích"><span
                                                    class="fa fa-heart-o"></span></a>
                                            <a href="/product/detail?id=${item.id}" data-toggle="tooltip"
                                               data-placement="top" title="Chi tiết"><span
                                                    class="fa fa-exchange"></span></a>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <c:if test="${model.totalPage > 1}">
                            <div class="container">
                                <nav aria-label="Page navigation">
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="page" name="page">
                                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem">
                                    <input type="hidden" value="" id="sortBy" name="sortBy">
                                    <input type="hidden" value="" id="sortName" name="sortName">
                                    <input type="hidden" value="" id="ten" name="ten">
                                    <input type="hidden" value="" id="idMenuCon" name="idMenuCon">
                                </nav>
                            </div>
                        </c:if>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
                    <aside class="aa-sidebar">
                        <div class="aa-sidebar-widget">
                            <h3>Sắp xếp</h3>
                            <div class="tag-cloud">
                                <a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=${model.idMenuCon}">Mặc định</a>
                                <a href="/product?page=1&maxPageItem=9&sortName=asc&sortBy=null&ten=null&idMenuCon=${model.idMenuCon}">Tăng giần</a>
                                <a href="/product?page=1&maxPageItem=9&sortName=desc&sortBy=null&ten=null&idMenuCon=${model.idMenuCon}">Giảm dần</a>
                            </div>
                        </div>
                    </aside>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
                    <aside class="aa-sidebar">
                        <div class="aa-sidebar-widget">
                            <h3>Danh sách</h3>
                            <ul class="aa-catg-nav">
                                <li>
                                    <a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=1">Son</a>
                                </li>
                                <li>
                                    <a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=2">Chăm
                                        sóc da</a></li>
                                <li>
                                    <a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=3">Trang
                                        điểm</a></li>
                                <li>
                                    <a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=4">Nước
                                        hoa</a></li>
                            </ul>
                        </div>
                    </aside>
                </div>
            </div>
        </div>
    </form>
</section>
<script type="text/javascript">
    var totalPage = ${model.totalPage}; //tong so trang
    var currentPage = ${model.page};     //trang hien tai
    var visiblePages = ${model.maxPageItem};
    var sortName = '${model.sortName}';
    var sortBy = '${model.sortBy}';
    var ten = '${model.ten}';
    var idMenuCon = '${model.idMenuCon}'
    var limit = 9;   //so phan tu hien ra
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 10,        //tong so item tren 1 page
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val(sortName);
                    $('#sortBy').val(sortBy);
                    $('#ten').val(ten);
                    $('#idMenuCon').val(idMenuCon);
                    $('#formSubmit').submit();
                }
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>
<!-- / product category -->
<%@ include file="/common/web/subscribe.jsp" %>
</body>
</html>
