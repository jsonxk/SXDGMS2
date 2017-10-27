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

<title>线路/线杆管理管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- VENDOR CSS -->
<link rel="stylesheet" href="./assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="./assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="./assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="./assets/css/demo.css">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="./assets/img/favicon.png">
	<link rel="stylesheet" href="./js/table/bootstrap-table.css" />
	<link rel="stylesheet" href="./js/table/bootstrap.css" />
	<!-- treeview -->
	<link rel="stylesheet" type="text/css" href="./treeview/css/bootstrap.min.css">
<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="brand">
			<a href="index.html"><img src="assets/img/logo-dark.png"
				alt="Klorofil Logo" class="img-responsive logo"></a>
		</div>
		<div class="container-fluid">
			<div class="navbar-btn">
				<button type="button" class="btn-toggle-fullwidth">
					<i class="lnr lnr-arrow-left-circle"></i>
				</button>
			</div>
			<form class="navbar-form navbar-left">
				<div class="input-group">
					<input type="text" value="" class="form-control"
						placeholder="Search dashboard..."> <span
						class="input-group-btn"><button type="button"
							class="btn btn-primary">Go</button></span>
				</div>
			</form>
			<div class="navbar-btn navbar-btn-right">
				<a class="btn btn-success update-pro"
					href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro"
					title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i>
					<span>UPGRADE TO PRO</span></a>
			</div>
			<div id="navbar-menu"></div>
		</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
				<ul class="nav">
					<li><a href="jsp/index.jsp"><i class="lnr lnr-home"></i> <span>首页</span></a></li>
					<li class="sqgl"><a href="#subPages" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages" class="collapse">
							<ul class="nav sqglchild">
							</ul>
						</div></li>
					<li class="tzgl"><a href="#subPages1" data-toggle="collapse"
						class="active"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages1" class="collapse in">
							<ul class="nav tzglchild">
							</ul>
						</div></li>
					<li class="qxgl"><a href="#subPages2" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages2" class="collapse ">
							<ul class="nav qxglchild">
							</ul>
						</div></li>
					<li class="dtgl"><a href="#subPages3" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages3" class="collapse ">
							<ul class="nav dtglchild">
							</ul>
						</div></li>
					<li class="xtgl"><a href="#subPages4" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages4" class="collapse">
							<ul class="nav xtglchild">
							</ul>
						</div></li>
					<li class="rcgl"><a href="#subPages5" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages5" class="collapse">
							<ul class="nav rcglchild">
							</ul>
						</div></li>
				</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<h3 class="page-title">用户信息表</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel">
								<div style="width:40%">
										
								</div>
							</div>
							<!-- END BASIC TABLE -->
						</div>
					</div>
				</div>
				<!-- END MAIN CONTENT -->
			</div>
			<!-- END MAIN -->
			<div class="userinfo" style="display:none">
				<span><%=session.getAttribute("userid")%></span>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- END WRAPPER -->
	<script src="./assets/vendor/jquery/jquery.min.js"></script>
	<script src="./assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="./assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="./assets/scripts/klorofil-common.js"></script>
	<script src="./assets/vendor/bootstrap/js/bootstrap.js"></script>
	<script src="./js/table/bootstrap-table.js"></script>
	<script src="./js/table/bootstrap-table-export.js"></script>
	<script src="./js/table/jquery.base64.js"></script>
	<script src="./js/table/tableExport.js"></script>
	<script type="text/javascript">
		function initIndex() {
			$(".tzglchild .1tzgl0   a").addClass("active");
		}
	</script>
	<script src="./js/pageInit.js"></script>
</body>

</html>
