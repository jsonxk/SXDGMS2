<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>单位管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="./css/style.css" rel="stylesheet">
<link href="./css/style-responsive.css" rel="stylesheet">
</head>
<body class="sticky-header">
	<section> <!-- left side start-->
	<div class="left-side sticky-left-side">

		<!--logo and iconic logo start-->
		<div class="logo">
			<a href="index.html"><img src="images/logo.png" alt=""></a>
		</div>

		<div class="logo-icon text-center">
			<a href="index.html"><img src="images/logo_icon.png" alt=""></a>
		</div>
		<!--logo and iconic logo end-->


		<div class="left-side-inner">
			<!--sidebar nav start-->
			<ul class="nav nav-pills nav-stacked custom-nav">
				<li class="sy"><a href="jsp/index.jsp"><i class="fa fa-home"></i> <span>首页</span></a></li>
				<li class="menu-list sqgl"><a href=""><i class="fa fa-laptop"></i>
						<span></span></a>
					<ul class="sub-menu-list">
						

					</ul>
				</li>
				<li class="menu-list tzgl"><a href=""><i class="fa fa-list-alt"></i>
						<span></span></a>
					<ul class="sub-menu-list">
						
					</ul>
				</li>
				<li class="menu-list qxgl"><a href=""><i class="fa fa-tasks"></i>
						<span></span></a>
					<ul class="sub-menu-list">
						
					</ul>
				</li>
				<li class="menu-list dtgl"><a href=""><i class="fa fa-suitcase"></i>
						<span></span></a>
					<ul class="sub-menu-list">
					

					</ul>
				</li>
				<li class="menu-list xtgl"><a href=""><i class="fa fa-cogs"></i>
						<span></span></a>
					<ul class="sub-menu-list">
						

					</ul>
				</li>
				<li class="menu-list rcgl"><a href=""><i class="fa fa-book"></i>
						<span></span></a>
					<ul class="sub-menu-list">
						

					</ul>
				</li>
			</ul>
			<!--sidebar nav end-->
		</div>
	</div>
	<!-- left side end--> <!-- main content start-->
	<div class="main-content">

		<!-- header section start-->
		<div class="header-section">

			<!--toggle button start-->
			<a class="toggle-btn"><i class="fa fa-bars"></i></a>
			<!--toggle button end-->

			<!--search start-->
			<form class="searchform" action="index.html" method="post">
				<input type="text" class="form-control" name="keyword"
					placeholder="Search here..." />
			</form>
			<!--search end-->

			<!--头像 -->
			<div class="menu-right">
				<ul class="notification-menu">
					<li><a href="#" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown"> <img
							src="images/photos/user-avatar.png" alt="" /><%=session.getAttribute("name").toString() %><span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
							<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
							<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
							<li><a href="#"><i class="fa fa-sign-out"></i> Log Out</a></li>
						</ul></li>

				</ul>
			</div>
			<!--notification menu end -->

		</div>
		<!-- header section end-->

		<!--body wrapper end-->

		<!--footer section start-->
		<footer> 2014 &copy; AdminEx by ThemeBucket </footer>
		<!--footer section end-->
		<div class="userinfo" style="display:none">
			<span><%=session.getAttribute("userid")%></span>
		</div>

	</div>
	<!-- main content end--> </section>
	<!-- Placed js at the end of the document so the pages load faster -->
	<script src="./js/jquery-1.10.2.min.js"></script>
	<script src="./js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="./js/jquery-migrate-1.2.1.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/modernizr.min.js"></script>
	<script src="./js/jquery.nicescroll.js"></script>

	<!--common scripts for all pages-->
	<script src="./js/scripts.js"></script>
	<script type="text/javascript">
  	function initIndex(){
  		$(".menu-list").removeClass("nav-active");
		$(".xtgl").addClass("nav-active");
		$(".sub-menu-list li").removeClass("active");
		$(".4xtgl4").addClass("active");
  	}
  </script>
  <script src="./js/page/pageInit.js"></script>
</body>

</html>
