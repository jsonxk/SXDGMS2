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

.panel-default>.panel-heading {
	background-color: gray
}

.markercontent {
	width: 200px;
}

.markercontent span {
	font-weight: 600;
}

.poleTab {
	width: 95%;
	position: absolute;
	display: none;
}

.main-content {
	padding: 20px 10px 10px 5px;
}

.panel {
	margin-bottom: 0px;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover
	{
	background-color: rgba(43, 52, 61, 1);
	color: white;
}

.SaveHang {
	background-color: #3887fc;
	color: white;
	border: 1px solid gray;
	margin-left: 5px;
}

.CancelHang {
	background-color: #fc1270;
	color: #FFFFFF;
	border: 1px solid gray;
	margin: 5px 0 0 5px;
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
			<div id="navbar-menu">
				<ul class="nav navbar-nav navbar-right userOp">
					<li class="dropdown">
							<a class="dropdown-toggle dropdown userNameSpan" data-toggle="dropdown"><img src="assets/img/user.png" class="img-circle" alt="Avatar"> <span></span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu dropUserInfo">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>修改信息</span></a></li>
								<li><a href="jsp/Quit.jsp"><i class="lnr lnr-exit"></i> <span>退出登录</span></a></li>
							</ul>
					</li>
				</ul>
			</div>
		</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
				<ul class="nav">
					<li class="indexpage"><a href="jsp/index.jsp"><i class="lnr lnr-home"></i> <span>首页</span></a></li>
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
								<div style="width:100%;height:78%">
									<div id="allmap">
										<div class="handerButton">
											<input type="button" class="button AddLineBtn" value="添加线路" />
											<input type="button" class="button AddPoleBtn" value="添加线杆" />
											<input type="button" class="button AddHangLine"
												value="添加搭挂线路" /> <input type="button" class="openEditPole"
												value="编辑线杆" /> <input type="button" class="openDelPole"
												value="删除线杆" onclick="" />  <input
												type="button" class="button" value="点击定位"
												onclick="PositionFunc()" />
										</div>
									</div>
									<div class="poleTab">
										<ul id="PoleMarkerClick" class="nav nav-tabs">
											<li><a data-toggle="tab">x</a></li>
											<li class="active"><a href="#home" data-toggle="tab">
													菜鸟教程 </a></li>
											<li><a href="#ios" data-toggle="tab">iOS</a></li>
										</ul>
										<div id="PoleMarkerClickCont" class="tab-content">
											<div class="tab-pane fade in active" id="home">
												<p>菜鸟教程是一个提供最新的web技术站点，本站免费提供了建站相关的技术文档，帮助广大web技术爱好者快速入门并建立自己的网站。菜鸟先飞早入行——学的不仅是技术，更是梦想。</p>
											</div>
											<div class="tab-pane fade" id="ios">
												<p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod
													Touch 和 Apple TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X
													操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
											</div>
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
		<div class="modal fade " id="AddLineModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width:125%;margin-left:-10%">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="exampleModalLabel">添加线路详情信息</h4>
					</div>

					<div class="modal-body">
						<div style="width:100%;height:340px;">
							<form id="LineForm">
								<div class="form-group">
									<div class="form-group LineNameInput">
										<label for="LineNameInput" class="control-label">线路名称</label>
										<input type="text" id="LineNameInput" name="LineNameInput"
											placeholder="请输入线路名称" class="form-control" />
									</div>
									<div class="form-group LineLength">
										<label for="LineLength" class="control-label">线路长度</label> <input
											type="text" id="LineLength" name="LineLength"
											placeholder="请输入线路长度" class="form-control" readonly />
									</div>
									<div class="form-group LineNumber">
										<label for="LineNumber" class="control-label">线杆数量</label> <input
											type="text" id="LineNumber" name="LineNumber"
											placeholder="请输入产生线杆数量" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<div class="form-group LineUnit">
										<label for="LineUnit" class="control-label">单位名称</label> </br> <select
											id="LineUnit" class="form-control">
										</select>
									</div>
									<div class="form-group LineType">
										<label for="LineType" class="control-label">线路类型</label> </br> <select
											id="LineType" class="form-control">
										</select>
									</div>
									<div class="form-group LineStatus">
										<label for="LineStatus" class="control-label">线路状态</label> </br> <select
											id="LineStatus" class="form-control">
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="form-group LineTime">
										<label for="LineTime" class="control-label">添加时间</label> <input
											type="text" id="LineTime" name="LineTime"
											class="form-control" readonly />
									</div>
									<div class="form-group LineCode">
										<label for="LineCode" class="control-label">编码</label> <input
											type="text" id="LineCode" name="LineCode"
											class="form-control" placeholder="请输入编码" />
									</div>
									<div class="form-group LinePoleStatus">
										<label for="LinePolestatus" class="control-label">线杆类型</label> </br> <select
											id="LinePolestatus" class="form-control">
										</select>
									</div>
								</div>
								<div id="form-group">
									<div class="form-group LineMemo">
										<label for="LineMemo" class="control-label">线路描述</label>
										<textarea class="form-control textarea1" rows="2"
											placeholder="项目描述" id="LineMemo" name="LineMemo"></textarea>
									</div>
								</div>
								<div class="text-right modalbutton">
									<button type="button" class="btn btn-default LineModalcancel"
										data-dismiss="modal">取消</button>
									<button id="LineOK" type="button" class="btn btn-primary"
										onclick="">完成</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- modal添加搭挂线路弹出框 -->
		<div class="modal fade " id="HangLineModal" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width:80%;height:450px">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="exampleModalLabel">添加搭挂线路信息</h4>
					</div>
					<div class="modal-body">
						<form id="AddHangLineform">
							<div class="form-group Hanglinename">
								<label for="Hanglinename" class="control-label">搭挂线路名称</label> <input
									type="text" id="Hanglinename" name="Hanglinename"
									class="form-control" placeholder="搭挂线路名称" />
							</div>
							<div class="form-group HanglineUnit1">
								<label class="control-label">选择单位</label> <select
									class="form-control HanglineUnit">

								</select>
							</div>
							<div class="form-group HanglineTime">
								<label class="control-label" for="HanglineTime">创建时间</label> <input
									type="text" id="HanglineTime" name="HanglineTime"
									class="form-control" readonly />
							</div>
							<div class="form-group HanglineCode">
								<label class="control-label" for="HanglineCode">编号</label> <input
									type="text" id="HanglineCode" name="HanglineCode"
									class="form-control" placeholder="搭挂线路编号" />
							</div>
							<div class="form-group HanglineType1">
								<label class="control-label">选择类型</label> <select
									class="form-control HanglineType">

								</select>
							</div>
							<div class="form-group HanglineStatus1">
								<label class="control-label">选择状态</label> <select
									class="form-control HanglineStatus">

								</select>
							</div>
							<div class="form-group HanglineMemo">
								<label for="HanglineMemo" class="control-label">搭挂线路描述</label>
								<textarea class="form-control textarea1" rows="3"
									placeholder="搭挂线路描述" id="HanglineMemo" name="HanglineMemo"></textarea>
							</div>
							<div class="text-right HanglinemodalBtn">
								<span id="returnMessage" class="glyphicon"> </span>
								<button id="HangLineCancel" type="button"
									class="btn btn-default right" data-dismiss="modal">取消</button>
								<button id="HangLineOK" type="button" class="btn btn-primary">完成</button>
							</div>
						</form>
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
		$(".userOp").mouseover(function(){
			$(".dropUserInfo").css("display","block");
		})
		$(".userOp").mouseout(function(){
			$(".dropUserInfo").css("display","none");
		})
	</script>
	<script src="./js/pageInit.js"></script>
	<div class="userinfo" style="display:none">
				<%
					if (session.getAttribute("userid") == null) {
						%>
							<script type="text/javascript">
								window.location.href="jsp/login.jsp";
							</script>
						<%
					} else {
				%>
				<script type="text/javascript">
					$(".userNameSpan span").text("<%=session.getAttribute("loginname")%>");
				</script>
				<span><%=session.getAttribute("userid")%></span>
				<p id="p1"><%=session.getAttribute("loginname").toString()%></p>
				<p id="p2"><%=session.getAttribute("unitname").toString()%></p>
				<p id="p3"><%=session.getAttribute("unitid").toString()%></p>
				<%
					}
				%>
	</div>
	<script src="./js/table/DTGL.js"></script>
</body>

</html>