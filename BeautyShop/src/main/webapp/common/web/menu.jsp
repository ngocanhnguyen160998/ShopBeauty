<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section id="menu">
    <div class="container">
        <div class="menu-area">
            <!-- Navbar -->
            <div class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <form action="/category" method="get">

                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="/index">Trang chủ</a></li>
                            <li><a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=1">Son </a></li>
                            <li><a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=2">Chăm sóc da </a></li>
                            <li><a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=3">Trang điểm </a></li>
                            <li><a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=4">Nước hoa </a></li>
                            <li><a href="/product?page=1&maxPageItem=9&sortName=null&sortBy=null&ten=null&idMenuCon=null">Tất cả </a>
                            <li><a href="<c:url value="/views/web/contact.jsp"/>">Liên hệ</a></li>
                            </li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>