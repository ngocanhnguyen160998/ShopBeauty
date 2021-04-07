<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- start header bottom -->
<div class="aa-header-bottom">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-header-bottom-area">
                    <!-- logo  -->
                    <div class="aa-logo">
                        <!-- Text based logo -->
                        <a href="/index">
                            <span class="fa fa-shopping-bag"></span>
                            <p>LH Beauty<span>Uy tín - Chất lượng</span></p>
                        </a>
                        <!-- img based logo -->
                        <!-- <a href="index.html"><img src="img/logo.jpg" alt="logo img"></a> -->
                    </div>
                    <!-- / logo  -->
                    <!-- cart box -->
                    <c:if test="${not empty USER}">
                        <div class="aa-cartbox">
                            <a class="aa-cart-link" href="/MyCart">
                                <span class="fa fa-shopping-basket"></span>
                                <span class="aa-cart-title">GIỎ HÀNG</span>
                                <span class="aa-cart-notify">?</span>
                            </a>
                            <div class="aa-cartbox-summary">
                                <ul>
                                    <li>
                                        <span class="aa-cartbox-total-price">
                                        </span>
                                    </li>
                                </ul>
                                <a class="aa-cartbox-checkout aa-primary-btn" href="/checkout">Thanh toán</a>
                            </div>
                        </div>
                    </c:if>
                    <!-- / cart box -->
                    <!-- search box -->
                    <div class="aa-search-box">
                        <form action="/search" method="get">
                            <input type="text" name="ten" placeholder="Tìm kiếm">
                            <button type="submit"><span class="fa fa-search"></span></button>
                        </form>
                    </div>
                    <!-- / search box -->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- / header bottom -->
