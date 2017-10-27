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

<title>用户/角色管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- VENDOR CSS -->
<link rel="stylesheet" href="./assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="./assets/vendor/linearicons/style.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="./assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="./assets/css/demo.css">
<!-- GOOGLE FONTS -->
<!-- <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet"> -->
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="./assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="./assets/img/favicon.png">
<link rel="stylesheet" href="./js/table/bootstrap-table.css" />
<link rel="stylesheet" href="./js/table/bootstrap.css" />
 
<style type="text/css">
.fixed-table-body {
	height: 68%;
}

#search {
	margin: 2% 0 2% 2%;
	height: 5%;
}

#search .form-control {
	float: left;
	width: 15%;
	margin-left: 1px;
}

#search .btn {
	float: left;
	margin-left: 2px;
}

#unitselect {
	width: 21%;
	float: left;
	margin-left: 5%;
}
#unitselect select {
	width: 70%;
	height: 36px;
	border-radius: 5px;
	margin-left: 1px;
}
.input-group{
	width:80%;
	margin: 4% auto;
}
.textarea1{
	width:80%;
	margin:4%  auto;
}
.modal-dialog{
	width:30%;
}
</style>
</head>

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
						<div id="subPages" class="collapse ">
							<ul class="nav sqglchild">
							</ul>
						</div></li>
					<li class="tzgl"><a href="#subPages1" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages1" class="collapse ">
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
						class="active"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages4" class="collapse in">
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
					<h3 class="page-title">用户/角色管理</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">用户信息表</h3>
								</div>
								<!-- 表格查找 -->
								<div id="search">
									<button class="btn btn-primary btnsearch" type="button">姓名</button>
									<input type="text" class="form-control username"
										placeholder="输入姓名">
									<div id="unitselect">
										<button class="btn btn-primary " type="button">单位</button>
										<select class="unit">

										</select>
									</div>
									<div id="unitselect">
										<button class="btn btn-primary " type="button">类型</button>
										<select id="status">
											<option class="select" value="管理者">管理者</option>
											<option value="员工">员工</option>
										</select>
									</div>
									<button class="btn btn-primary" type="button" onClick="Search()">查找</button>
								</div>
								<!-- 表格信息主体 -->
								<div class="panel-body content-body">
									<div id="reportTableDiv" class="span10">
										<table id="reportTable">
										</table>
									</div>
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
			<!-- 用户信息修改 -->
			<div class="modal" id="mymodal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">修改用户信息</h4>
						</div>
						<div class="modal-body">
						<div class="input-group">
							<span class="input-group-addon ">姓名</span>
							<input type="text" class="form-control updatename"/>
						</div>
						<div class="input-group">
							<span class="input-group-addon ">电话</span>
							<input type="text" class="form-control updatephone"/>
						</div>
						<div class="input-group">
							<span class="input-group-addon">单位</span>
							<select class="form-control unit">
								
							</select>				
						</div>
						<div class="input-group">
							<span class="input-group-addon">状态</span>
							<select class="form-control">
								<option class="select" value="管理者">管理者</option>
								<option value="员工">员工</option>
							</select>	
						</div>
						<div class="input-group">
							<span class="input-group-addon">类型</span>
							<select class="form-control">
								<option class="select" value="39">在岗</option>
								<option value="40">离职</option>
							</select>	
						</div>
						 <textarea class="form-control textarea1" rows="3" placeholder="备注"></textarea> 
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</div>
	</div>
	<!-- 角色设置 -->
	<div class="modal" id="JSModel">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">用户角色设置</h4>
						</div>
						<div class="modal-body">
							<div id="reportTableDiv" class="span10">
										<table class="JSinfo">
										</table>
							</div>
				          </div>
						</div>
					</div>
				</div>
	</div>				
	<!-- END WRAPPER -->
	<!-- Javascript -->
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

	<!-- 3.0 -->
	<script type="text/javascript">
		function initIndex(){
			$(".xtglchild .4xtgl2 a").addClass("active");
		}
		function Search(){
		$('#reportTable').bootstrapTable("refresh");
		
	}
	</script>
	<script src="./js/unit.js"></script>
	<script src="./js/pageInit.js"></script>
	<script src="./js/table/table.js"></script>
	
</body>

</html>
