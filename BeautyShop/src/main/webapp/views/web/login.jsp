<%@ include file="/common/admin/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="APIurl" value="/api-admin-user"/>
<html>
<head>
    <title>Login</title>
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
                        <div class="col-md-6">
                            <div class="aa-myaccount-login">
                                <h4>Đăng nhập</h4>
                                <form action="<c:url value="/login?action=login"/>" class="aa-login-form" method="post">
                                    <label>Tài khoản<span>*</span></label>
                                    <input type="text" name="userName" required>

                                    <label>Mật khẩu<span>*</span></label>
                                    <input type="password"  name="password" required>
                                    <input type="hidden" value="Đăng nhập" name="action" >

                                    <button type="submit" class="aa-browse-btn">Đăng nhập</button>
                                </form>
                            </div>
                            <div><font color="#ff0a00" >${message}</font></div>
                        </div>
                        <div class="col-md-6">
                            <div class="aa-myaccount-register">
                                <h4>Đăng kí</h4>
                                <form id="formSubmit" class="aa-login-form">

                                    <label>Tài khoản<span>*</span></label>
                                    <input type="text"  name="userName" required >
                                    <label>Mật khẩu<span>*</span></label>
                                    <input type="password"  name="password" required >
                                    <label>Số điện thoại<span>*</span></label>
                                    <input type="text"  name="phone" required >
                                    <label>Email<span>*</span></label>
                                    <input type="text"  name="email" required >

                                    <button id="btnChangePass" type="submit" class="aa-browse-btn">Đăng kí</button>
                                    <input type="hidden" value="2" name="roleId">
                                </form>
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
<script>
    $('#btnChangePass').click(function (e) {
        e.preventDefault();
        var data={};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i,v) {
            data[""+v.name+""] =v.value;
        });
        addUser(data);
    });
    function addUser(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "/index";
            },
            error: function (error) {
                window.location.href = "/index";
            }
        });
    }
</script>
</body>
</html>
