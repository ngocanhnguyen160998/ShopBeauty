<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Right side column. Contains the navbar and content of the page -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Order Detail
        </h1>
        <ol class="breadcrumb">
            <li><a href="/admin-home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/admin-table-order?type=list&page=1&maxPageItem=10&sortName=null&sortBy=null">Order</a></li>
            <li class="active">OrderDetail</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="invoice">
        <!-- title row -->
        <div class="row">
            <div class="col-xs-12">
                <h2 class="page-header">
                    <i class="fa fa-globe"></i> Admin
                </h2>
            </div><!-- /.col -->
        </div>
        <!-- info row -->
        <div class="row invoice-info">
            <div class="col-sm-4 invoice-col">
                From
                <address>
                    <strong>Admin, Inc.</strong><br>
                    Trường Đại học Công nghiệp Hà Nội<br>
                    Bắc Từ Liêm, Hà Nội<br>
                    Phone: 0914.663.198<br/>
                    Email: lanhuongmypham@gmail.com
                </address>
            </div><!-- /.col -->
            <div class="col-sm-4 invoice-col">
                To
                <address>
                    <strong>${model.firstName} ${model.lastName}</strong><br>
                    ${model.apartment} ${model.address}<br>
                    ${model.commune}, ${model.district}, ${model.province}<br>
                    Phone: ${model.phone}<br/>
                    Email: ${model.email}
                </address>
            </div><!-- /.col -->
            <div class="col-sm-4 invoice-col">
                <br/>
                <br>
                <b>Mã đơn hàng:</b> ${model.id}<br/>
                <b>Ngày:</b> ${model.modifiedDate}<br/>
                <b>Mã người dùng:</b> ${model.id_user}
            </div><!-- /.col -->
        </div><!-- /.row -->

        <!-- Table row -->
        <div class="row">
            <div class="col-xs-12 table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Product x Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                     <c:forEach var="item" items="${product}">
                         <tr>
                             <td>${item}</td>
                         </tr>
                     </c:forEach>
                    </tbody>
                </table>
            </div><!-- /.col -->
        </div><!-- /.row -->

        <div class="row">
            <!-- accepted payments column -->
            <div class="col-xs-6">
                <p class="lead">Phương thức thanh toán: ${model.paymentMethod}</p>
                <img src="<c:url value="/template/admin/dist/img/credit/visa.png"/>" alt="Visa"/>
                <img src="<c:url value="/template/admin/dist/img/credit/mastercard.png"/>" alt="Mastercard"/>
                <img src="<c:url value="/template/admin/dist/img/credit/american-express.png"/>" alt="American Express"/>
                <img src="<c:url value="/template/admin/dist/img/credit/paypal2.png"/>" alt="Paypal"/>
            </div><!-- /.col -->
            <div class="col-xs-6">
                <p class="lead">Ngày ${model.modifiedDate}</p>
                <div class="table-responsive">
                    <table class="table">
                        <tr>
                            <th style="width:20%">Tổng:</th>
                            <td><fmt:formatNumber value="${model.tongTien}" type="currency" ></fmt:formatNumber></td>
                        </tr>

                    </table>
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->

    </section><!-- /.content -->
    <div class="clearfix"></div>
</div><!-- /.content-wrapper -->

</body>
</html>
