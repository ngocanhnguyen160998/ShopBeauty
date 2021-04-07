<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<c:url value="/template/admin/dist/img/user2-160x160.jpg"/>" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
                <p>${USER.userName}</p>

                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Tìm kiếm"/>
                <span class="input-group-btn">
                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" >
            <li class="header">Quản lý</li>
            <li class="treeview">
                    <a href="/admin-table?type=list&page=1&maxPageItem=5&sortName=null&sortBy=null"><i class="fa fa-table"></i>Người dùng</a>
                    <i class="fa fa-angle-left pull-right"></i>
            </li>
            <li class="treeview">
                    <a href="/admin-table-product?type=list&page=1&maxPageItem=10&sortName=null&sortBy=null"><i class="fa fa-table"></i>Sản phẩm</a>
                    <i class="fa fa-angle-left pull-right"></i>
            </li>
            <li class="treeview">
                    <a href="/admin-table-order?type=list&page=1&maxPageItem=5&sortName=null&sortBy=null"><i class="fa fa-table"></i>Đơn hàng</a>
                    <i class="fa fa-angle-left pull-right"></i>
            </li>
            <li>
                <a href="/admin-home-email">
                    <i class="fa fa-envelope"></i> <span>Email đăng ký </span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>