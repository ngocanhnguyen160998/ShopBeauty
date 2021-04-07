<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
</head>
<body>
    <form action="<c:url value='/admin-report'/>"  method="get">
        <H1 style="text-align: center;">ĐƠN HÀNG</H1>
        <H3>Ngày xuất: ${date}</H3>
        <H3>Giờ xuất: ${time}</H3>
        <table border="1" style="font-size: 18px;">
            <tr>
                <th>Mã đơn</th>
                <th>Tên người mua</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Địa chỉ</th>
                <th>Xã/Thị trấn</th>
                <th>Quận/Huyện</th>
                <th>Tỉnh/Thành phố</th>
                <th>Ngày mua</th>
                <th>Thành tiền</th>
                <th>Phương thức thanh toán</th>
                <th>Lưu ý</th>
            </tr>
            <tbody>
            <c:forEach var="item" items="${model.listResult}">
            <tr>
                <th>${item.id}</th>
                <th>${item.firstName} ${item.lastName}</th>
                <th>${item.phone}</th>
                <th>${item.email}</th>
                <th>${item.address}</th>
                <th>${item.commune}</th>
                <th>${item.district}</th>
                <th>${item.province}</th>
                <th>${item.modifiedDate}</th>
                <th>${item.tongTien}</th>
                <th>${item.paymentMethod}</th>
                <th>${item.specialNotes}</th>
                </c:forEach>
            </tbody>
        </table>
    </form>
</body>
</html>
