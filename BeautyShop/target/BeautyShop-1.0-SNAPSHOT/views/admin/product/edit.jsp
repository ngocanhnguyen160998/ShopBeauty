<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-admin-product"/>
<c:url var ="Userurl" value="/admin-table-product"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Product
        </h1>
        <ol class="breadcrumb">
            <li><a href="/admin-home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/admin-table-product?type=list&page=1&maxPageItem=10&sortName=null&sortBy=null">Product</a></li>
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
                        <label>Tên sản phẩm<span>*</span></label>
                        <div class="form-group">
                            <div class="form-group">
                                <input class="form-control" id="tenSanPham" name="tenSanPham"
                                       placeholder="Tên sản phẩm:" value="${product.tenSanPham}" required/>
                            </div>
                        </div>
                        <label>File hình ảnh<span>*</span></label>
                        <div class="form-group">
                            <div class="form-group">
                                <input class="form-control" id="hinhAnh" name="hinhAnh" placeholder="File hình ảnh:"
                                       value="${product.hinhAnh}" required />
                            </div>
                        </div>
                        <label>Thông tin chi tiết<span>*</span></label>
                        <div class="form-group">
                            <input id="thongTinChiTiet" name="thongTinChiTiet" class="form-control" type="text"
                                   placeholder="Thông tin chi tiết: " value="${product.thongTinChiTiet}" required />
                        </div>
                        <label>Giá bán<span>*</span></label>
                        <div class="form-group">
                            <input class="form-control" id="giaBan" name="giaBan" placeholder="Giá bán:"
                                   value="${product.giaBan}" required />
                        </div>
                        <label>Số lượng<span>*</span></label>
                        <div class="form-group">
                            <input class="form-control" id="soLuong" name="soLuong" placeholder="Số lượng:"
                                   value="${product.soLuong}" required />
                        </div>
                        <label>Màu sắc<span>*</span></label>
                        <div class="form-group">
                            <input class="form-control" id="mauSac" name="mauSac" placeholder="Màu sắc:"
                                   value="${product.mauSac}" required />
                        </div>
                        <label>Trạng thái<span>*</span></label>
                        <div class="form-group">
                            <input class="form-control" id="trangThai" name="trangThai" placeholder="Trạng thái:"
                                   value="${product.trangThai}" required />
                        </div>
                        <label>Loại sản phẩm<span>*</span></label>
                        <div class="form-group">
                            <select class="form-control" name="idMenuCon" id="idMenuCon">
                                <option value="" selected disabled hidden>Loại sản phẩm</option>
                                <option value="1">Lips</option>
                                <option value="2">Skincare</option>
                                <option value="3">Makeup</option>
                                <option value="4">Perfume</option>
                            </select>
                        </div>
                        <% String result = "";%>
                        <c:if test="${empty product.id}">
                            <%result = "Thêm mới";%>
                        </c:if>
                        <c:if test="${not empty product.id}">
                            <%result = "Cập nhật";%>
                        </c:if>
                        <div class="box-footer">
                            <div class="pull-right">
                                <button id="btnAddOrUpdateNew" type="submit" class="btn btn-default"><%=result%>
                                </button>
                            </div>
                        </div><!-- /.box-footer -->
                        <p><br></p>
                        <input type="hidden" value="${product.id}" id="id" name="id">
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
            addProduct(data);
        } else {
            updateProduct(data);
        }
    });

    function addProduct(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "admin-table-product?type=list&page=1&maxPageItem=10&sortName=null&sortBy=null";
            },
            error: function (error) {
                window.location.href = "${Userurl}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }

    function updateProduct(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "admin-table-product?type=list&page=1&maxPageItem=10&sortName=null&sortBy=null";
            },
            error: function (error) {
                window.location.href = "${Userurl}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>
