<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/common/web/header.banner.1920x300.jsp" %>
<!-- Cart view section -->
<!-- Cart view section -->
<section id="checkout">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="checkout-area">
                    <form action="/checkout" method="post">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="checkout-left">
                                    <div class="panel-group" id="accordion">
                                        <!-- Shipping Address -->
                                        <div class="panel panel-default aa-checkout-billaddress">
                                            <div class="panel-heading">
                                                <h4 class="panel-title">
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                                                        Địa chỉ giao hàng
                                                    </a>
                                                </h4>
                                            </div>
                                            <div id="collapseFour" class="panel-collapse collapse">
                                                <div class="panel-body">
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="text" placeholder="Họ" name="firstName" required >
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="text" placeholder="Tên" name="lastName" required >
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="email" placeholder="Email" name="email" required >
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="tel" placeholder="Số điện thoại" name="phone" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <textarea cols="8" rows="3" name="address" placeholder="Địa chỉ" style="resize: none" required></textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <select name="province" id="country" required>
                                                                    <option value="" selected disabled hidden>Tỉnh/Thành phố</option>
                                                                    <option value="An Giang">An Giang
                                                                    <option value="Bà Rịa - Vũng Tàu">Bà Rịa - Vũng Tàu
                                                                    <option value="Bắc Giang">Bắc Giang
                                                                    <option value="Bắc Kạn">Bắc Kạn
                                                                    <option value="Bạc Liêu">Bạc Liêu
                                                                    <option value="Bắc Ninh">Bắc Ninh
                                                                    <option value="Bến Tre">Bến Tre
                                                                    <option value="Bình Định">Bình Định
                                                                    <option value="Bình Dương">Bình Dương
                                                                    <option value="Bình Phước">Bình Phước
                                                                    <option value="Bình Thuận">Bình Thuận
                                                                    <option value="Bình Thuận">Bình Thuận
                                                                    <option value="Cà Mau">Cà Mau
                                                                    <option value="Cao Bằng">Cao Bằng
                                                                    <option value="Đắk Lắk">Đắk Lắk
                                                                    <option value="Đắk Nông">Đắk Nông
                                                                    <option value="Điện Biên">Điện Biên
                                                                    <option value="Đồng Nai">Đồng Nai
                                                                    <option value="Đồng Tháp">Đồng Tháp
                                                                    <option value="Đồng Tháp">Đồng Tháp
                                                                    <option value="Gia Lai">Gia Lai
                                                                    <option value="Hà Giang">Hà Giang
                                                                    <option value="Hà Nam">Hà Nam
                                                                    <option value="Hà Tĩnh">Hà Tĩnh
                                                                    <option value="Hải Dương">Hải Dương
                                                                    <option value="Hậu Giang">Hậu Giang
                                                                    <option value="Hòa Bình">Hòa Bình
                                                                    <option value="Hưng Yên">Hưng Yên
                                                                    <option value="Khánh Hòa">Khánh Hòa
                                                                    <option value="Kiên Giang">Kiên Giang
                                                                    <option value="Kon Tum">Kon Tum
                                                                    <option value="Lai Châu">Lai Châu
                                                                    <option value="Lâm Đồng">Lâm Đồng
                                                                    <option value="Lạng Sơn">Lạng Sơn
                                                                    <option value="Lào Cai">Lào Cai
                                                                    <option value="Long An">Long An
                                                                    <option value="Nam Định">Nam Định
                                                                    <option value="Nghệ An">Nghệ An
                                                                    <option value="Ninh Bình">Ninh Bình
                                                                    <option value="Ninh Thuận">Ninh Thuận
                                                                    <option value="Phú Thọ">Phú Thọ
                                                                    <option value="Quảng Bình">Quảng Bình
                                                                    <option value="Quảng Bình">Quảng Bình
                                                                    <option value="Quảng Ngãi">Quảng Ngãi
                                                                    <option value="Quảng Ninh">Quảng Ninh
                                                                    <option value="Quảng Trị">Quảng Trị
                                                                    <option value="Sóc Trăng">Sóc Trăng
                                                                    <option value="Sơn La">Sơn La
                                                                    <option value="Tây Ninh">Tây Ninh
                                                                    <option value="Thái Bình">Thái Bình
                                                                    <option value="Thái Nguyên">Thái Nguyên
                                                                    <option value="Thanh Hóa">Thanh Hóa
                                                                    <option value="Thừa Thiên Huế">Thừa Thiên Huế
                                                                    <option value="Tiền Giang">Tiền Giang
                                                                    <option value="Trà Vinh">Trà Vinh
                                                                    <option value="Tuyên Quang">Tuyên Quang
                                                                    <option value="Vĩnh Long">Vĩnh Long
                                                                    <option value="Vĩnh Phúc">Vĩnh Phúc
                                                                    <option value="Yên Bái">Yên Bái
                                                                    <option value="Phú Yên">Phú Yên
                                                                    <option value="Tp. Cần Thơ">Tp. Cần Thơ
                                                                    <option value="Tp. Đà Nẵng">Tp. Đà Nẵng
                                                                    <option value="Tp. Hải Phòng">Tp. Hải Phòng
                                                                    <option value="Tp. Hà Nội">Tp. Hà Nội
                                                                    <option value="Tp. HCM">Tp. HCM
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="text" placeholder="Căn hộ, chung cư (nếu có)" name="apartment">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="text" placeholder="Xã/Thị trấn" name="commune" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="text" placeholder="Quận/Huyện" name="district" required>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <input type="text" placeholder="Mã bưu điện (nếu có)" name="postCode">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <textarea cols="8" rows="3" name="specialNotes" placeholder="Lưu ý (nếu có)" style="resize: none"></textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="checkout-right">
                                    <h4>Danh sách sản phẩm</h4>
                                    <div class="aa-order-summary-area">
                                        <table class="table table-responsive">
                                            <thead>
                                            <tr>
                                                <th>Tên sản phẩm</th>
                                                <th>Thành tiền</th>
                                            </tr>
                                            </thead>
                                            <c:forEach var="item" items="${model}">
                                            <tbody>
                                            <tr>
                                                <td>${item.ten}<strong> x ${item.soLuongMua}</strong></td>
                                                <td width="110px"><fmt:formatNumber value="${item.tongTien}" type="currency" ></fmt:formatNumber></td>
                                            </tr>
                                            </tbody>
                                            </c:forEach>
                                            <tfoot>
                                            <tr>
                                                <th>Tổng</th>
                                                <td><fmt:formatNumber value="${sum}" type="currency" ></fmt:formatNumber></td>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <h4>Phương thức thanh toán</h4>
                                    <div class="aa-payment-method">
                                        <label for="cashdelivery"><input type="radio" value="cashdelivery" id="cashdelivery" name="paymentMethod" checked> Thanh toán khi giao hàng </label>
                                        <label for="paypal"><input type="radio" value="paypal" id="paypal" name="paymentMethod" > Via Paypal </label>
                                        <img src="https://www.paypalobjects.com/webstatic/mktg/logo/AM_mc_vs_dc_ae.jpg" border="0" alt="PayPal Acceptance Mark">
                                        <input type="submit" value="Xác nhận" class="aa-browse-btn">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->
<!-- / Cart view section -->
<%@ include file="/common/web/subscribe.jsp" %>
</body>
</html>
