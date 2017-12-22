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

<title>申请信息管理</title>
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
<link rel="stylesheet" type="text/css" href="./css/sqxxgl.css">
<style>
#fileToUpload2 {
	display: none;
}
.Handerapply{
	background-color: rgba(33,117,232,0.9);
	color:#FFFFFF;
}
 .Handerapply:hover {
   	background-color: rgba(33,117,232,1);
   	color:#FFFFFF;
}
.Handerapply:active:focus,.Handerapply:active{
 	background-color: rgba(33,117,232,1);
	color:#FFFFFF;
}
.Checkapply{
	background-color: rgba(92,184,92,0.9);
	color:#FFFFFF;
}
 .Checkapply:hover {
 	background-color: rgba(92,184,92,0.9);	
   	color:#FFFFFF;
}
.Checkapply:active:focus,.Checkapply:active{
 	background-color: rgba(92,184,92,0.9);
	color:#FFFFFF;
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
					<h3 class="page-title">搭挂申请信息</h3>
					<div class="row">
						<div class="col-md-12">
							<!--申请信息表 TABLE Start -->
							<div class="panel" style="height:100%;">
								<!-- 表格信息主体 -->
								<div class="panel-body unitbody">
									<h4>申请信息表</h4>
									<div id="searchParam">
										<!-- 单位查找 -->
										<button class="btn btn-primary" type="button"
											id="ApplyUnitname">单位名称</button>
										<select id="ApplyUnittype" class="form-control">

										</select>
										<!-- 日期查找 -->
										<select id="TimeType" class="form-control">
											<option selected value='0'>申请日期</option>
											<option value='1'>批准日期</option>
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
									</div>
									<!-- 表格信息主体 -->
									<div id="SQXXGLTable" class="span10">
										<table id="sqxxgltable">

										</table>
									</div>
								</div>
							</div>
							<!-- END 申请信息 TABLE -->
						</div>
					</div>
				</div>
				<!-- END MAIN CONTENT -->
			</div>
			<!-- 处理申请 -->
			<div class="modal fade " id="HanderModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width:115%">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">处理申请信息</h4>
						</div>
						<div class="modal-body">
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h6 class="panel-title" style="font-size: 15px;margin:-8px;">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"> 申请信息 &nbsp;<i class="lnr lnr-user"></i></a>
										</h6>
									</div>
									<div id="collapseOne" class="panel-collapse collapse in">
										<div style="margin-top: 2%">
											<label for="HM_ApplyUser" class="control-label HM_ApplyUser">申请用户:</label> <input
											type="text" id="HM_ApplyUser" name="HM_ApplyUser" readonly>
											<label for="HM_ApplyUnit" class="control-label HM_ApplyUnit">申请单位:</label> <input
											type="text" id="HM_ApplyUnit" name="HM_ApplyUnit" readonly>
											</br>
											<label for="HM_ApplyContract" class="control-label HM_ApplyContract">联系人:</label> <input
											type="text" id="HM_ApplyContract" name="HM_ApplyContract" readonly>
											<label for="HM_ApplyPhone" class="control-label HM_ApplyPhone">单位电话:</label> <input
											type="text" id="HM_ApplyPhone" name="HM_ApplyPhone" readonly>
											</br>
											<label for="HM_ApplyHang" class="control-label HM_ApplyHang">搭挂线路:</label> 
											<select class="HM_SelectHang">
											</select>
											<input type="text" id="HM_ApplyHang" name="HM_ApplyHang"  readonly>
											<label for="HM_ApplyCode" class="control-label HM_ApplyCode">申请单号:</label> <input
											type="text" id="HM_ApplyCode" name="HM_ApplyCode" readonly>
											</br>
											<label for="HM_ApplyTime" class="control-label HM_ApplyTime">申请日期:</label> <input
											type="text" id="HM_ApplyTime" name="HM_ApplyTime" readonly>
											<label for="HM_ApplyStatus" class="control-label HM_ApplyStatus">申请状态:</label> <input
											type="text" id="HM_ApplyStatus" name="HM_ApplyStatus" readonly>
											</br>
											<label for="HM_ApplyMemo" class="control-label HM_ApplyMemo">申请描述:</label>
											</br>
											<textarea rows="2"
												 id="HM_ApplyMemo" name="HM_ApplyMemo" readonly></textarea>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h6 class="panel-title" style="font-size: 15px;margin:-8px; ">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseTwo"> 查勘信息  &nbsp;<i class="lnr lnr-layers"></i></a>
										</h6>
									</div>
									<div id="collapseTwo" class="panel-collapse collapse">
										<div class="panel-body">Nihil anim keffiyeh helvetica,
											craft beer labore wes anderson cred nesciunt sapiente ea
											proident. Ad vegan excepteur butcher vice lomo.</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h6 class="panel-title" style="font-size: 15px;margin:-8px;">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseThree"> 审核信息 &nbsp;<i class=" lnr lnr-database"></i></a>
										</h6>
									</div>
									<div id="collapseThree" class="panel-collapse collapse">
										<div class="panel-body">
											<table id="hangdertable">

											</table>
										</div>
									</div>
								</div>
							</div  >
										<!-- HM   Modal底部按钮 -->
										<div id="HM_BottonBtn">
											<button type="button" class="btn btn-primary HM_NoOK"
												>驳回</button>
											<button type="button" class="btn btn-default HM_OK">通过</button>
											<button type="button" class="btn btn-default HM_Cancel" data-dismiss="modal"
												>取消</button>
										</div>				​
							
						</div>
					</div>
				</div>
			</div>
			<!-- END MAIN -->
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
	<script src="./js/validate/bootstrapValidator.js"></script>
	<script src="./js/datetimepicker/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript">
		function initIndex() {
			$(".sqglchild .0sqgl0   a").addClass("active");
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
						response.sendRedirect("login.jsp");
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
	<script src="./js/table/SQXXGL.js"></script>
</body>

</html>
