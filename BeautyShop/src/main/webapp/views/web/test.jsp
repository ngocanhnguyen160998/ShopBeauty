<%@ page import="com.shop.model.entity.ProductEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shop.repository.impl.ProductRepositoryImpl" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.shop.util.MySqlConnectionUtil" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <nav aria-label="Page navigation">
        <ul class="pagination" id="pagination"></ul>
    </nav>
</div>
<script type="text/javascript">
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 35,
            visiblePages: 10,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>
</body>
</html>
