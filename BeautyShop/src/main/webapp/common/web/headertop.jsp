<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- start header top  -->
<div class="aa-header-top">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-header-top-area">
                    <!-- start header top left -->
                    <div class="aa-header-top-left">

                    </div>
                    <!-- / header top left -->
                    <div class="aa-header-top-right">
                        <ul class="aa-head-top-nav-right">
                            <c:if test="${not empty USER}">
                                <li><a href="<c:url value="/changepass"/>">Đổi mật khẩu</a></li>
                            </c:if>
                            <li class="hidden-xs"><a href="<c:url value="/WishList"/>">Danh sách yêu thích</a></li>
                            <li class="hidden-xs"><a href="<c:url value="/MyCart"/>">Giỏ hàng</a></li>
                            <li class="hidden-xs"><a href="/checkout">Thanh toán</a></li>

                            <c:if test="${not empty USER}">
                                <li><a data-toggle="modal" data-target="">Hello, ${USER.userName}</a></li>
                                <li><a href="<c:url value="/login?action=logout"/>">Đăng xuất</a></li>
                            </c:if>
                            <c:if test="${empty USER}">
                                <li><a href="<c:url value="/login?action=login"/>">Đăng kí</a></li>
                            </c:if>
                            <c:if test="${empty USER}">
                                <li><a href="" data-toggle="modal" data-target="#login-modal">Đăng nhập
                                </a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- / header top  -->