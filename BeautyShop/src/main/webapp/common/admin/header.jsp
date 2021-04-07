<%@include file="/common/taglib.jsp"%>
<header class="main-header">
<!-- Logo -->
<a href="<c:url value="/admin-home" />" class="logo"><b>Admin</b>Home</a>
<!-- Header Navbar: style can be found in header.less -->
<nav class="navbar navbar-static-top" role="navigation">
    <!-- Sidebar toggle button-->
    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
    </a>
    <!-- Navbar Right Menu -->
    <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
            <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                    <img src="<c:url value='/template/admin/dist/img/user2-160x160.jpg'/>" class="user-image" alt="User Image"/>
                    <span class="hidden-xs">${USER.userName}</span>
                </a>
                <ul class="dropdown-menu">
                    <!-- User image -->
                    <li class="user-header">

                        <img src="<c:url value='/template/admin/dist/img/user2-160x160.jpg'/>" class="img-circle" alt="User Image" />
                        <p>
                            ${USER.userName}
                        </p>
                    </li>
                    <!-- Menu Footer-->
                    <li class="user-footer">
                        <div class="pull-right">
                            <a href="/login?action=logout" class="btn btn-default btn-flat">Sign out</a>
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
</header>