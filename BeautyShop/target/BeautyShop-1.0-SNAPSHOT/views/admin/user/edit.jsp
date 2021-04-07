<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-admin-user"/>
<c:url var="Userurl" value="/admin-table"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            User
        </h1>
        <ol class="breadcrumb">
            <li><a href="/admin-home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/admin-table?type=list&page=1&maxPageItem=5&sortName=null&sortBy=null">User</a></li>
            <li class="active">Data tables</li>
        </ol>
    </section>
    <c:if test="${not empty messageResponse}">
        <div class="alert alert-${alert}">
                ${messageResponse}
        </div>
    </c:if>
    <form id="formSubmit" action="form-horizontal" method="">
        <div class="row">
            <div class="col-md-9">
                <div class="box box-primary">
                    <div class="box-header with-border">
                    </div><!-- /.box-header -->

                    <div class="box-body">
                        <div class="form-group">
                            <label>Tài khoản<span>*</span></label>
                            <div class="form-group">
                                <input type="text" class="form-control" id="userName" name="userName"
                                       placeholder="Tài khoản" value="${user.userName}" required >
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu<span>*</span></label>
                            <div class="form-group">
                                <input type="password" class="form-control" id="password" name="password"
                                       placeholder="Mật khẩu" value="${user.password}" required >
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Số điện thoại<span>*</span></label>
                            <div class="form-group">
                                <input type="text" class="form-control" id="phone" name="phone"
                                       placeholder="Số điện thoại" value="${user.phone}" required >
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Email<span>*</span></label>
                            <div class="form-group">
                                <input type="text" class="form-control" id="email" name="email" placeholder="Email"
                                       value="${user.email}" required />
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Quyền<span>*</span></label>
                            <div class="form-group">
                                <select class="form-control" name="roleId" id="roleId">
                                    <option value="" selected disabled hidden>Quyền</option>
                                    <c:if test="${empty user.roleId}">
                                        <c:forEach var="item" items="${role}">
                                            <option value="${item.id}">${item.name}</option>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty user.roleId}">
                                        <c:forEach var="item" items="${role}">
                                            <option value="${item.id}" <c:if
                                                    test="${item.id == user.roleId}"> selected value</c:if> >${item.name}</option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                        <% String result = "";%>
                        <c:if test="${empty user.roleId}">
                            <%result = "Thêm mới";%>
                        </c:if>
                        <c:if test="${not empty user.roleId}">
                            <%result = "Cập nhật";%>
                        </c:if>
                        <div class="box-footer">
                            <div class="pull-right">
                                <button id="btnAddOrUpdateNew" type="submit" class="btn btn-default"><%=result%></button>
                            </div>
                        </div><!-- /.box-footer -->
                        <p><br></p>
                        <input type="hidden" value="${user.id}" id="id" name="id">
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        var id = $('#id').val();
        if (id == "") {
            addUser(data);
        } else {
            updateUser(data);
        }
    });

    function addUser(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "admin-table?type=list&page=1&maxPageItem=5&sortName=null&sortBy=null";
            },
            error: function (error) {
                window.location.href = "${Userurl}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }

    function updateUser(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "admin-table?type=list&page=1&maxPageItem=5&sortName=null&sortBy=null";
            },
            error: function (error) {
                window.location.href = "${Userurl}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>
