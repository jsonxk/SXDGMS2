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

<title>地图管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="./assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="./assets/vendor/linearicons/style.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="./assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="./assets/css/demo.css">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="./assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="./assets/img/favicon.png">
<link rel="stylesheet" href="./js/table/bootstrap-table.css" />
<link rel="stylesheet" href="./js/table/bootstrap.css" />
<!-- treeview -->
<link rel="stylesheet" type="text/css"
	href="./treeview/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://cache.amap.com/lbs/static/main1119.css" />
<script
	src="http://webapi.amap.com/maps?v=1.4.1&key=e8fe2f8a5385cb0c048947ec75738cb0&plugin=AMap.MouseTool"></script>
<script type="text/javascript"
	src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
<link rel="stylesheet" type="text/css" href="./css/tabletitle.css">
<style type="text/css">
#allmap {
	width: 100%;
	height: 100%;
}

.handerButton {
	float: left;
	position: absolute;
	z-index: 1000;
	margin-top: 30px;
}
/* 地图 */
.markerid {
	width: 14px;
	height: 14px;
	border: 1px solid #E90000;
	border-radius: 50%;
	background-color: #2AC845;
}

.MarkercenterDiv {
	width: 6px;
	height: 6px;
	border-radius: 50%;
	margin: 3px;
	background-color: #007AFF;
}

.handerButton input {
	border: 1px solid #4A4AFF;
	background-color: #FFFFFF;
}

#MapPoleLength, #MapPoleStatus {
	border-radius: 3px;
	border: 1px solid #cccccc;
	height: 5%;
	width: 20%;
}
.panel-default>.panel-heading{
	background-color: gray
}
.markercontent{
	width:200px;
}
.markercontent span{
	font-weight: 600;
}
</style>
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
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages1" class="collapse">
							<ul class="nav tzglchild">
							</ul>
						</div></li>
					<li class="qxgl"><a href="#subPages2" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages2" class="collapse">
							<ul class="nav qxglchild">
							</ul>
						</div></li>
					<li class="dtgl"><a href="#subPages3" data-toggle="collapse"
						class="active"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages3" class="collapse in">
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
					<h3 class="page-title">地图信息管理</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel">
								<div style="width:100%;height:68%">
									<div id="allmap">
										<div class="handerButton">
											<input type="button" class="button" value="添加线路" onclick="" />
											<input type="button" class="button AddPoleBtn" value="添加线杆"
												onclick="" /> <input type="button" class="button AddHangLine"
												value="添加搭挂线路"/> <input type="button"
												class="openEditPole" value="编辑线杆" /> <input type="button"
												class="openDelPole" value="删除线杆" onclick="" /> <input
												type="button" class="button" value="关闭操作" onclick="" /> <input
												type="button" class="button" value="点击定位"
												onclick="PositionFunc()" />
										</div>
									</div>
								</div>
							</div>
							<!-- END BASIC TABLE -->
						</div>
					</div>
				</div>
				<!-- END MAIN CONTENT -->
			</div>
			<!-- 选择是否删除线杆pole -->
			<div class="modal fade " id="DelPoleModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width:40%;margin-top: 50%">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">是否删除当前线杆?</h4>
						</div>
						<div class="modal-body">
							<button type="button" class="btn btn-default DelPoleCancel"
								data-dismiss="modal">否</button>
							<button type="button" class="btn btn-primary " id="DelPoleOk">是</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 删除提示信息 -->
			<div class="modal fade " id="DelRtnModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width:40%;margin-top: 50%">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body delInfo">
							<h4></h4>
						</div>
					</div>
				</div>
			</div>
			<!-- END MAIN -->
			<div class="userinfo" style="display:none">
				<span><%=session.getAttribute("userid")%></span>
			</div>
			<div class="clearfix"></div>
		</div>
		<!-- modal地图添加线杆弹出框 -->
		<div class="modal fade " id="MapAddPoleModal" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width:125%;margin-left:-10%">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="exampleModalLabel">添加线杆信息</h4>
					</div>
					<div class="modal-body">
						<div>
							<div id="firstLayer">
								<label for="MapPoleLength" class="control-label">线杆高度</label> <input
									type="text" id="MapPoleLength" name="PoleLength" value="17"
									readonly /> <label for="MapPoleStatus" class="control-label">线杆状态</label>
								<select id="MapPoleStatus"></select> <label for="PoleTime"
									class="control-label">创建时间</label> <input type="text"
									id="PoleTime" name="PoleTime" readonly />
							</div>
							<div id="secondLayer">
								<label for="PoleUnit" class="control-label">单位名称</label> <select
									id="PoleUnit">
								</select> <label for="PoleType" class="control-label">线杆类型</label> <select
									id="PoleType">
								</select> <label for="PoleLon" class="control-label">经度</label> <input
									type="text" id="PoleLon" name="PoleLon" /> <label
									for="PoleLat" class="control-label">纬度</label> <input
									type="text" id="PoleLat" name="PoleLat" /> <input
									type="button" id="addPoleBtn" value="添加线路">
							</div>
							<div id="thirdLayer">
								<div class="thirdLayer0">
									<label for="PolePre" class="control-label">前一杆</label> <select
										class="PolePre">

									</select> <label for="PoleForLine" class="control-label">所属线路</label> <select
										class="PoleForLine">
									</select> <label for="PoleCode" class="control-label">编码</label><input
										type="text" class="PoleCode" name="PoleCode" />
								</div>
							</div>
							<div class="poleModalBtn">
								<button type="button" class="btn btn-primary cancelPole"
									data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary OkPole">完成</button>
							</div>
						</div>
					</div>
				</div>
			</div>
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
			$(".dtglchild .3dtgl0   a").addClass("active");
		}
	</script>
	<script src="./js/pageInit.js"></script>
	<script src="./js/table/DTGL.js"></script>
</body>

</html>