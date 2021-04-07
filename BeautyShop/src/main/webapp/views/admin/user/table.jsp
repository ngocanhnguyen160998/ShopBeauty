<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-user"/>
<c:url var ="Userurl" value="/admin-table"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table User</title>
</head>
<body>
<!-- Right side column. Contains the navbar and content of the page -->
    <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Quản lý người dùng
        </h1>
        <ol class="breadcrumb">
            <li><a href="/admin-home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">User</li>
        </ol>
    </section>

    <!-- Main content -->
        <form action="<c:url value='/admin-table'/>" id="formSubmit" method="get">
            <section class="content">
        <div class="row">
            <div class="col-xs-12">

                <div class="box">


<%--                    sort --%>
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-${alert}">
                                ${messageResponse}
                        </div>
                    </c:if>
<%--                        sort --%>
                    </div>
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                            <tr>
<%--                                insert--%>
                                <th>
                                    <a float flag="info" class="btn-group-vertical" data-toggle="tooltip" title='Thêm' href='<c:url value="/admin-table?type=edit"/>'>
                                        <span>
                                            <i class="fa fa-plus" aria-hidden="true"></i>
                                        </span>
                                    </a>
                                </th>
                                <th>
<%--                                delete--%>
                                    <a class="btn-group-vertical" id="btnDelete" data-toggle="tooltip" title="Xóa">
                                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                                    </a>
                                </th>
                            </tr>
                            </thead>
                            <tr>
<%--                                <th><input type="checkbox" id="checkAll"></th>--%>
                                 <th></th> <%--mo tren dong duoi--%>
                                <th>Mã</th>
                                <th>Tên tài khoản</th>
                                <th>Số điện thoại</th>
                                <th>Email</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <tbody>
                            <c:forEach var="item" items="${model.listResult}">
                                <tr>
                                    <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                    <th>${item.id}</th>
                                    <th>${item.userName}</th>
                                    <th>${item.phone}</th>
                                    <th>${item.email}</th>
                                    <th>
                                        <c:url var="edit" value="/admin-table">
                                            <c:param name="type" value="edit"></c:param>
                                            <c:param name="id" value="${item.id}"></c:param>
                                        </c:url>
                                        <a class="btn-group-vertical" data-toggle="tooltip" title="Sửa" href="${edit}">
                                            <i class="fa fa-wrench" aria-hidden="true"></i>
                                        </a>
                                    </th>
                                    <th>
                                    </th>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="container">
                            <nav aria-label="Page navigation">
                                <ul class="pagination" id="pagination"></ul>
                                <input type="hidden" value="" id="page" name="page">
                                <input type="hidden" value="" id="maxPageItem" name="maxPageItem">
                                <input type="hidden" value="" id="sortName" name="sortName">
                                <input type="hidden" value="" id="sortBy" name="sortBy">
                                <input type="hidden" value="list" id="type" name="type">
                            </nav>
                        </div>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div><!-- /.col -->
    </section><!-- /.content -->
        </form>
    </div><!-- /.content-wrapper -->
</form>
<script>
    var totalPage = ${model.totalPage}; //tong so trang
    var currentPage = ${model.page};     //trang hien tai
    var visiblePages = ${model.maxPageItem};
    var sortName= '${model.sortName}';
    var sortBy= '${model.sortBy}';
    var limit =5;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 10,        //tong so item tren 1 page
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage!= page){
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val(sortName);
                    $('#sortBy').val(sortBy);
                    $('#formSubmit').submit();
                }
            }
        })
    });
    $("#btnDelete").click(function() {
        var data = {};
        var ids = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['ids'] = ids;
        deleteUser(data);
    });
    function deleteUser(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "${Userurl}?type=list&page=1&maxPageItem=5&message=delete_success";
            },
            error: function (error) {
                window.location.href = "${Userurl}?type=list&maxPageItem=5&page=1&message=error_system";
            }
        });
    }
</script>

</body>
</html>
