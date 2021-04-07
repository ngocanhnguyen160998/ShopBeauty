<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>Đăng nhập</h4>
                <form class="aa-login-form" action="<c:url value="/login?action=login"/>" method="post">
                    <label>Tài khoản<span>*</span></label>
                    <input type="text" name="userName">
                    <label>Mật khẩu<span>*</span></label>
                    <input type="password" name="password">
                    <button class="aa-browse-btn" type="submit">Đăng nhập</button>
                    <div><br></div>
                    <div class="aa-register-now">
                        Bạn chưa có tài khoản?<a href="<c:url value="/login?action=login" />">Đăng ký ngay!</a>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>