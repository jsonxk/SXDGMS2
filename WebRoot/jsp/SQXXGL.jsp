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
.panel-group{
	margin-bottom: 10px;
}
#LineCheckPhoto{
	height:280px;
	margin:10px 0 10px 1%;
	width:64%;
	border:0px;
	float:left;
	box-shadow: 0 0 5px #000;
	overflow: hidden;
}
#LineCheckPhoto img{
	width:100%;
	height:100%;
}
#CheckDtlinfo{
	height:250px;
	width:30%;
	float:left;
	border: 0px;
	margin: 5% 0 0 2%;
}
#LineCheckPhoto ul {
	width:100%;
	height:100%;
	margin: 0;
	padding:0;
}
textarea{
	resize:none;
}
#LineCheckPhoto ul li{
	width:100%;
	height:100%;
	list-style-type:none;
	display:inline-block;
}
#LineCheckPhoto ul li span{
	display: none;
}
.M_name,.M_userunit,.M_username,.M_pwd,.M_userphone
{
	width:50%;
	float:left;
} 
.M_usermemo{
	width:100%;
	float:left;
}
.usermodalBtn{
	float:left;
	width: 100%;
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
				
			</form>
			<div id="navbar-menu">
				<ul class="nav navbar-nav navbar-right userOp">
					<li class="dropdown">
							<a class="dropdown-toggle dropdown userNameSpan" data-toggle="dropdown"><img src="assets/img/user.png" class="img-circle" alt="Avatar"> <span></span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu dropUserInfo">
								<li><a id="modifyuserInfo"><i class="lnr lnr-user"></i> <span>修改信息</span></a></li>
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
										<table id="applyDoctable">

										</table>
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
										<div class="panel-body">
											<div style="height:300px;box-shadow:0 0 20px #000">
												<div id="LineCheckPhoto">
													<ul>
															
													</ul>
													<i class="ChkleftImg" id="ChkleftImg"></i>
													<i class="ChkrightImg" id="ChkrightImg"></i>
												</div>
												<div id="CheckDtlinfo">
													<label for="CheckPoleName" class="control-label">查勘线杆名称:</label>
													<input type="button" id="CheckPoleName"
														name="CheckPoleName" class="form-control" />
													<label for="CheckDtlMemo" class="control-label">查勘描述:</label>
													<textarea class="form-control" rows="2"
														placeholder="查勘描述" id="CheckDtlMemo" name="CheckDtlMemo"></textarea>
													<label for="CheckPhotoMemo" class="control-label">照片描述:</label>
													<textarea class="form-control" rows="2"
														placeholder="照片描述" id="CheckPhotoMemo" name="CheckPhotoMemo"></textarea>
												</div>
											</div>
										</div>
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
							<div id="handerTextArea">
								<textarea rows="2" placeholder="处理意见" style="width: 100%;border:1px solid gray;border-radius:3px;margin-bottom: 5px"></textarea>
							</div>
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
			<!-- 提示信息 -->
			<div class="modal fade " id="TS_Modal" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content" style="width:35%;margin-top: 50%">
	
							<div class="modal-header TS_Modal">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="exampleModalLabel"></h4>
							</div>
							<div class="modal-body delInfo">
								
							</div>
						</div>
					</div>
				</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="modal fade " id="modifyUserInfoModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:80%;height:450px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">个人信息</h4>
				</div>
				<div class="modal-body">
					<form id="userinfoForm">
						<div class="form-group M_name">
							<label for="M_name" class="control-label">用户姓名:</label> <input
								type="text" id="M_name" name="M_name"
								class="form-control" placeholder="用户姓名" />
						</div>
						<div class="form-group M_userunit">
							<label class="control-label">用户单位:</label> 
							</br>
							<select
								class="form-control" id="M_userunit">

							</select>
						</div>
						<div class="form-group M_username">
							<label class="control-label" for="M_username">登录名:</label> <input
								type="text" id="M_username" name="M_username"
								class="form-control" />
						</div>
						<div class="form-group M_pwd">
							<label class="control-label" for="M_pwd">密码:</label> <input
								type="password" id=M_pwd name="M_pwd"
								class="form-control" placeholder="密码" />
						</div>
						<div class="form-group M_userphone">
							<label class="control-label" for="M_userphone">电话:</label> <input
								type="text" id="M_userphone" name="M_userphone"
								class="form-control" />
						</div>
						<div class="form-group M_usermemo">
							<label for="M_usermemo" class="control-label">用户描述</label>
							<textarea class="form-control textarea1" rows="3"
								placeholder="用户描述" id="M_usermemo" name="M_usermemo"></textarea>
						</div>
						<div class="text-right usermodalBtn">
							<span id="returnMessage" class="glyphicon"> </span>
							<button type="button" class="btn btn-default right"
								data-dismiss="modal">取消</button>
							<button id="userModifyBtn" type="button" class="btn btn-primary">修改</button>
						</div>
					</form>
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
