<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LanHuongBeauty | Home</title>
    <!-- Font awesome -->
    <link href="<c:url value="/template/web/css/font-awesome.css" />" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="<c:url value="/template/web/css/bootstrap.css" />" rel="stylesheet">
    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
    <link href="<c:url value="/template/web/css/jquery.smartmenus.bootstrap.css" />" rel="stylesheet">
    <!-- Product view slider -->
    <link type="text/css" href="<c:url value="/template/web/css/jquery.simpleLens.css" />" rel="stylesheet">
    <!-- slick slider -->
    <link href="<c:url value="/template/web/css/slick.css" />" rel="stylesheet" type="text/css">
    <!-- price picker slider -->
    <link href="<c:url value="/template/web/css/nouislider.css" />" rel="stylesheet" type="text/css">
    <!-- Theme color -->
    <link id="switcher" href="<c:url value="/template/web/css/theme-color/default-theme.css" />" rel="stylesheet">
    <!-- Top Slider CSS -->
    <link href="<c:url value="/template/web/css/sequence-theme.modern-slide-in.css" />" rel="stylesheet" media="all">
    <!-- Main style sheet -->
    <link href="<c:url value="/template/web/css/style.css" />" rel="stylesheet">
    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

</head>
<body>
<!-- wpf loader Two -->
<div id="wpf-loader-two">
    <div class="wpf-loader-two-inner">
        <span>Loading</span>
    </div>
</div>
<!-- / wpf loader Two -->
<!-- SCROLL TOP BUTTON -->
<a class="scrollToTop" href="#"><i class="fa fa-chevron-up"></i></a>
<!-- END SCROLL TOP BUTTON -->


<!-- Start header section -->
<header id="aa-header">
    <!-- start header top  -->
    <%@ include file="/common/web/headertop.jsp" %>
    <!-- / header top  -->

    <!-- start header bottom  -->
    <%@ include file="/common/web/headerbot.jsp" %>
    <!-- / header bottom  -->
</header>
<!-- / header section -->

<!-- menu -->
<%@ include file="/common/web/menu.jsp" %>
<!-- / menu -->

<%--body--%>
    <dec:body/>
<%----%>

<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- / footer -->

<!-- Login Modal -->
<%@ include file="/common/web/loginmodal.jsp" %>

<!-- jQuery library -->
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/template/web/js/bootstrap.js"/>"></script>

<!-- SmartMenus jQuery plugin -->
<script src="<c:url value="/template/web/js/jquery.smartmenus.js"/>"></script>

<!-- SmartMenus jQuery Bootstrap Addon -->
<script src="<c:url value="/template/web/js/jquery.smartmenus.bootstrap.js"/>"></script>

<!-- To Slider JS -->
<script src="<c:url value="/template/web/js/sequence.js"/>"></script>
<script src="<c:url value="/template/web/js/sequence-theme.modern-slide-in.js"/>"></script>
<!-- Product view slider -->
<script type="text/javascript" src="<c:url value="/template/web/js/jquery.simpleGallery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/template/web/js/jquery.simpleLens.js"/>"></script>

<!-- slick slider -->
<script type="text/javascript" src="<c:url value="/template/web/js/slick.js"/>"></script>
<!-- Price picker slider -->
<script type="text/javascript" src="<c:url value="/template/web/js/nouislider.js"/>"></script>

<!-- Custom js -->
<script src="<c:url value="/template/web/js/custom.js"/>"></script>

</body>
</html>