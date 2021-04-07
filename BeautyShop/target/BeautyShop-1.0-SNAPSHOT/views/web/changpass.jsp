<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/common/web/header.banner.1920x300.jsp" %>
<!-- Cart view section -->
<section id="aa-myaccount">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-myaccount-area">
                    <div class="row">
                        <div class="alert alert-${category}">
                            <strong>${message}</strong>
                        </div>
                        <div class="col-md-6">
                            <div class="aa-myaccount-login">
                                <h4>Đổi mật khẩu</h4>
                                <form action="/changepass" id="formSubmit" class="aa-login-form" method="post">
                                    <input type="password" placeholder="Mật khẩu cũ" name="passwordO">
                                    <input type="password" placeholder="Mật khẩu mới" name="passwordN">
                                    <input type="hidden" value="login" name="action">
                                    <button id="btnChangePass" type="submit" class="aa-browse-btn">Xác nhận</button>
                                </form>
                            </div>
                        </div>
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
</html>
