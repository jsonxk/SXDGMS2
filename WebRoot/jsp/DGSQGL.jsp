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

<title>搭挂申请管理</title>
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
<link rel="stylesheet" type="text/css" href="./css/tabletitle.css">
<style>
#myTab {
	width: 100%;
	height: 40px;
}

#myTab li {
	width: 55%;
	float: left;
	height: 40px;
	list-style: none;
	margin: 0px -10px;
}

#myTab li img {
	float: left;
	height: 100%;
}

.blue {
	background: #0f9af2;
}

.gray {
	background: #dfdfdf;
}

.tab-content {
	width: 90%;
	float: left;
	margin: 0 5%;
	border: solid 1px #000;
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
						class="active"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages" class="collapse in">
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
					<h3 class="page-title">搭挂申请</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel" style="height:100%;">
								<!-- 搭挂申请信息主体 -->
								<div class="panel-body unitbody">
									<h4>搭挂申请表</h4>
									<div id="searchParam">
										<!-- 日期查找 -->
										<select id="TimeType" class="form-control">
											<option  selected value='0'>申请日期</option>
											<option  value='1'>批准日期</option>
										</select>
										<div class="input-group date form_date" data-date=""
											data-date-format="dd MM yyyy" data-link-field="dtp_input2"
											data-link-format="yyyy-mm-dd">
											<input class="form-control timevalue" size="16" type="text"
												value="" readonly> <span class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span></span> <span
												class="form-control to">to</span>
										</div>
										<div class="input-group date dateFinish" data-date=""
											data-date-format="dd MM yyyy" data-link-field="dtp_input2"
											data-link-format="yyyy-mm-dd">
											<input class="form-control finishtime" size="16" type="text"
												value="" readonly> <span class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>
										<select id="HangStatus" class="form-control">

										</select>
										<button class="btn btn-primary" type="button" id="Hangbtn">查找</button>
										<button class="btn btn-primary" type="button" id="Refreshbtn">
											刷新<span class="glyphicon glyphicon-repeat"></span>
										</button>
										<button class="btn btn-primary addHang" type="button">
											<i class="fa fa-plus-square"></i>&nbsp;添加申请
										</button>
									</div>
									<div id="HangLineTable" class="span10">
										<table id="hanglinetable">
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
				<p id="p1"><%=session.getAttribute("loginname").toString()%></p>
				<p id="p2"><%=session.getAttribute("unitname").toString()%></p>
				<p id="p3"><%=session.getAttribute("unitid").toString()%></p>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- modal添加申请弹出框 -->
	<div class="modal fade " id="HangModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:100%">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">添加申请信息</h4>
				</div>

				<div class="modal-body">
					<div style="width:100%;height:84%;">
						<ul id="myTab" role="tablist">
							<li id="step1Li" class="active blue" style="width:45%"><span>1.基础信息录入</span>
							</li>
							<li id="step2Li" class="gray"><img id="step2Img"
								src="./step/images/blue_gray.png" /> <span>2.录入文件信息</span></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div id="step1" class="tab-pane fade active in">
								<form id="ApplyForm">
									<div class="form-group ApplyPeople">
										<label for="ApplyPeople" class="control-label">申请人</label> <input
											type="text" id="ApplyPeople" name="ApplyPeople"
											class="form-control" readonly />
									</div>
									<div class="form-group ApplyNumber">
										<label for="ApplyNumber" class="control-label">申请编号</label> <input
											type="text" id="ApplyNumber" name="ApplyNumber"
											class="form-control" readonly />
									</div>
									<div class="form-group ApplyUnit">
										<label for="ApplyUnit" class="control-label">单位名称</label> <input
											type="text" id="ApplyUnit" name="ApplyUnit"
											class="form-control" readonly />
									</div>
									<div class="form-group ApplyBuildType">
										<label for="ApplyBuildType" class="control-label">建设类型</label>
										</br> <select id="ApplyBuildType" class="form-control">
										</select>
									</div>
									<div class="form-group ApplyTime">
										<label for="ApplyTime" class="control-label">申请时间</label> <input
											type="text" id="ApplyTime" name="ApplyTime"
											class="form-control" readonly />
									</div>
									<div class="form-group ApplyContact">
										<label for="ApplyContact" class="control-label">联系人</label> <input
											type="text" id="ApplyContact" name="ApplyContact"
											placeholder="请输入联系人" class="form-control" />
									</div>
									<div class="form-group ApplyPhone">
										<label for="ApplyPhone" class="control-label">联系电话</label> <input
											type="text" id="ApplyPhone" name="ApplyPhone"
											placeholder="请输入联系电话" class="form-control" />
									</div>
									<div class="form-group ApplyMemo">
										<label for="ApplyMemo" class="control-label">申请描述</label>
										<textarea class="form-control textarea1" rows="3"
											placeholder="项目描述" id="ApplyMemo" name="ApplyMemo"></textarea>
									</div>
									<div class="text-right modalbutton">
										<button type="button" class="btn btn-default cancel"
											data-dismiss="modal">取消</button>
										<button id="NextSubmit" type="button" class="btn btn-primary"
											onclick="eventFun.next(2,0)">下一步</button>
										<button id="NextSubmit2" type="button" class="btn btn-primary"
											onclick="eventFun.next(2,1)">下一步</button>
									</div>
								</form>
							</div>
							<div id="step2" class="tab-pane fade ">
								<div class="span10">
									<table class="DocTypeTable">
									</table>
								</div>
								<div id="FilePromet" style="display:none">请完善必须信息</div>
								<div class="modalbutton">
									<button type="button" class="btn btn-primary prebtn"
										onclick="eventFun.pre(1)">上一步</button>
									<button type="button" class="btn btn-primary Upbtn"
										onclick="eventFun.SubmitInfo()">提交</button>
									<button type="button" class="btn btn-default cancel"
										data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary OKbtn"
										onclick="eventFun.complete()">完成</button>
								</div>
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
	<script src="./js/validate/bootstrapValidator.js"></script>
	<script src="./js/datetimepicker/bootstrap-datetimepicker.js"></script>
	<script src="./js/ajaxupload/ajaxfileupload.js"></script>
	<script type="text/javascript">
		function initIndex() {
			$(".sqglchild .0sqgl1   a").addClass("active");
		}
	</script>
	<script src="./js/pageInit.js"></script>
	<script src="./js/table/DGSQGL.js"></script>
</body>
</html>
