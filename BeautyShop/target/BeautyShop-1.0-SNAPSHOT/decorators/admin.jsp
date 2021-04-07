<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><dec:title default="Trang chủ" /></title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="<c:url value='/template/admin/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="<c:url value='/template/admin/plugins/morris/morris.css'/>" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="<c:url value='/template/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css'/>" rel="stylesheet" type="text/css" />
    <!-- Daterange picker -->
    <link href="<c:url value='/template/admin/plugins/daterangepicker/daterangepicker-bs3.css'/>" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="<c:url value='/template/admin/dist/css/AdminLTE.min.css'/>" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link href="<c:url value='/template/admin/dist/css/skins/_all-skins.min.css'/>" rel="stylesheet" type="text/css" />



    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

<%--    paging--%>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
</head>
<body class="skin-blue">
<div class="wrapper">

    <%--header--%>
    <%@ include file="/common/admin/header.jsp" %>
    <%----%>
    <!-- Left side column. contains the logo and sidebar -->
        <%@ include file="/common/admin/menu.jsp" %>

    <!-- Right side column. Contains the navbar and content of the page -->
        <dec:body/>
        <!-- /.content-wrapper -->

<%--footer--%>
    <%@ include file="/common/admin/footer.jsp" %>
<%----%>
</div><!-- ./wrapper -->

<!-- jQuery 2.1.3 -->
<%--<script type='text/javascript' src='<c:url value="/template/adminDemo/js/jquery-2.2.3.min.js" />'></script>--%>

<!-- Bootstrap 3.3.2 JS -->
<script src="<c:url value='/template/admin/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>

<!-- FastClick -->
<script src='<c:url value='/template/admin/plugins/fastclick/fastclick.min.js'/>'></script>

<!-- AdminLTE App -->
<script src="<c:url value='/template/admin/dist/js/app.min.js'/>" type="text/javascript"></script>

<!-- Sparkline -->
<script src="<c:url value='/template/admin/plugins/sparkline/jquery.sparkline.min.js'/>" type="text/javascript"></script>

<!-- jvectormap -->
<script src="<c:url value='/template/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'/>" type="text/javascript"></script>

<script src="<c:url value='/template/admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'/>" type="text/javascript"></script>

<!-- daterangepicker -->
<script src="<c:url value='/template/admin/plugins/daterangepicker/daterangepicker.js'/>" type="text/javascript"></script>

<!-- datepicker -->
<script src="<c:url value='/template/admin/plugins/datepicker/bootstrap-datepicker.js'/>" type="text/javascript"></script>

<!-- iCheck -->
<script src="<c:url value='/template/admin/plugins/iCheck/icheck.min.js'/>" type="text/javascript"></script>

<!-- SlimScroll 1.3.0 -->
<script src="<c:url value='/template/admin/plugins/slimScroll/jquery.slimscroll.min.js'/>" type="text/javascript"></script>

<!-- ChartJS 1.0.1 -->
<script src="<c:url value='/template/admin/plugins/chartjs/Chart.min.js'/>" type="text/javascript"></script>

<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<c:url value='/template/admin/dist/js/pages/dashboard2.js'/>" type="text/javascript"></script>

<!-- AdminLTE for demo purposes -->
<script src="<c:url value='/template/admin/dist/js/demo.js'/>" type="text/javascript"></script>
<script>

</script>
</body>
</html>