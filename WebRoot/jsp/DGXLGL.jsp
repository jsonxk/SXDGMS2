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

<title>搭挂线路管理</title>
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
<style type="text/css">
#BasicPoleInfo {
	height: 450px;
	width: 35%;
	float: left;
}

#Checkphoto {
	height: 440px;
	width: 65%;
	float: left;
	overflow: hidden;
	box-shadow: 0 0 5px #000;
}

#Checkphoto ul li {
	height: 100%;
	list-style-type: none;
}

#CheckPhoto ul li img {
	width: 100%;
	height: 100%;
}

.prevImg {
	left: 38%;
	background: url(./images/left_right.png) no-repeat 0 0px;
	background-color: rgba(0, 0, 0, 0.11);
}

.nextImg {
	left: 94%;
	background: url(./images/left_right.png) no-repeat 0 -120px;
	background-color: rgba(0, 0, 0, 0.11);
}

.prevImg, .nextImg {
	width: 58px;
	height: 120px;
	top: 150px;
	position: absolute;
	cursor: pointer;
	border-radius: 5px;
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
					<li class="dropdown"><a
						class="dropdown-toggle dropdown userNameSpan"
						data-toggle="dropdown"><img src="assets/img/user.png"
							class="img-circle" alt="Avatar"> <span></span> <i
							class="icon-submenu lnr lnr-chevron-down"></i></a>
						<ul class="dropdown-menu dropUserInfo">
							<li><a id="modifyuserInfo"><i class="lnr lnr-user"></i> <span>修改信息</span></a></li>
							<li><a href="jsp/Quit.jsp"><i class="lnr lnr-exit"></i>
									<span>退出登录</span></a></li>
						</ul></li>
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
					<li class="indexpage"><a href="jsp/index.jsp"><i
							class="lnr lnr-home"></i> <span>首页</span></a></li>
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
					<h3 class="page-title">搭挂线路管理</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div id="search">
								<button class="btn btn-primary lineNameBtn" type="button">名称</button>
								<input type="text" class="form-control lineName"
									placeholder="输入搭挂线路名称" name="lineName">
								<button class="btn btn-primary lineUnitBtn" type="button">单位名称</button>
								<input type="text" class="form-control lineUnitName"
									placeholder="输入单位名称名称" name="lineUnitName">
								<button class="btn btn-primary" type="button" id="lineSearchBtn">查找</button>
							</div>
							<!-- 线路信息表 -->
							<div class="panel-body lineleft">
								<h4>搭挂线路信息</h4>
								<button class="btn btn-primary addLine" type="button">
									<i class="fa fa-plus-square"></i>&nbsp;添加线路
								</button>
								<div id="lineInfo" class="span10">
									<table id="lineInfoTable" data-side-pagination="server">
									</table>
								</div>
							</div>
							<!-- 线杆信息 -->
							<div class="panel-body poleRight">
								<h4>搭挂线杆信息</h4>
								<button class="btn btn-primary addPole" type="button">
									<i class="fa fa-plus-square"></i>&nbsp;添加线杆
								</button>
								<div id="poleInfo" class="span10">
									<table id="poleInfoTable">
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- END MAIN CONTENT -->
			</div>
			<!-- END MAIN -->
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- modal添加搭挂线路弹出框 -->
	<div class="modal fade " id="HangLineModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:80%;height:450px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">搭挂线路信息</h4>
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
								class="form-control HanglineUnit" id="HanglineUnit1">

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
								class="form-control HanglineType" id="HanglineType1">

							</select>
						</div>
						<div class="form-group HanglineStatus1">
							<label class="control-label">选择状态</label> <select
								class="form-control HanglineStatus" id="HanglineStatus1">

							</select>
						</div>
						<div class="form-group HanglineMemo">
							<label for="HanglineMemo" class="control-label">搭挂线路描述</label>
							<textarea class="form-control textarea1" rows="3"
								placeholder="搭挂线路描述" id="HanglineMemo" name="HanglineMemo"></textarea>
						</div>
						<div class="text-right HanglinemodalBtn">
							<span id="returnMessage" class="glyphicon"> </span>
							<button type="button" class="btn btn-default right"
								data-dismiss="modal">取消</button>
							<button id="HangLineOK" type="button" class="btn btn-primary">完成</button>
							<button id="HangLineModify" type="button" class="btn btn-primary">修改</button>
						</div>
					</form>
				</div>
			</div>
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
	<!-- modal添加搭挂线杆弹出框 -->
	<div class="modal fade " id="HangPoleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:80%;height:450px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">搭挂线杆信息</h4>
				</div>
				<div class="modal-body">
					<form id="AddHangPoleform">
						<div class="form-group HangPolename1">
							<label for="HangPolename" class="control-label">搭挂线路</label> <select
								class="form-control HangPolename" id="HangPolename">

							</select>
						</div>
						<div class="form-group HangPole1">
							<label for="HangPole" class="control-label">搭挂线杆</label> <select
								class="form-control HangPole" id="HangPole">

							</select>
						</div>
						<div class="form-group HangPolePre1">
							<label for="HangPolePre" class="control-label">上一杆</label> <select
								class="form-control HangPolePre" id="HangPolePre">

							</select>
						</div>
						<div class="form-group HangPoleCode1">
							<label class="control-label" for="HangPoleCode">编号</label> <input
								type="text" id="HangPoleCode" name="HangPoleCode"
								class="form-control" placeholder="搭挂线路编号" />
						</div>
						<div class="form-group HangPoleStatus1">
							<label class="control-label">选择状态</label> <select
								class="form-control HangPoleStatus" id="HangPoleStatus">

							</select>
						</div>
						<div class="form-group HangPoleMemo">
							<label for="HangPoleMemo" class="control-label">搭挂线路描述</label>
							<textarea class="form-control textarea1" rows="3"
								placeholder="搭挂线路描述" id="HangPoleMemo" name="HanglineMemo"></textarea>
						</div>
						<div class="text-right HangPolemodalBtn">
							<span id="returnMessage" class="glyphicon"> </span>
							<button type="button" class="btn btn-default right"
								data-dismiss="modal">取消</button>
							<button id="HangPoleOK" type="button" class="btn btn-primary">完成</button>
							<button id="HangPoleModify" type="button" class="btn btn-primary">修改</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
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
					<button type="button" class="btn btn-danger  btn-sm"
						style="margin-right:15px;" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 点击查看照片 弹出modal-->
	<div class="modal fade " id="CheckPhotoModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document"
			style="width:80%;margin-top:5%;">
			<div class="modal-content" style="width:75%;height:520px;">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">线杆照片信息</h4>
				</div>

				<div class="modal-body">
					<div id="BasicPoleInfo">
						<div style="width:80%;margin:10% auto;">
							<label for="Photopolename" class="control-label">线杆名称:</label> <input
								type="text" id="Photopolename" name="Photopolename"
								class="form-control" /><label for="Photopolestatu
										class="control-label">线杆状态:</label> <input type="text"
								id="Photopolestatus" name="Photopolestatus" class="form-control" />
							<label for="PhotoTime" class="control-label">拍摄时间:</label> <input
								type="text" id="PhotoTime" name="PhotoTime" class="form-control" />
							<label for="Photopolememo" class="control-label">线杆描述:</label>
							<textarea class="form-control textarea1" rows="3"
								placeholder="线杆描述" id="Photopolememo" name="Photopolememo"></textarea>
						</div>
					</div>
					<div id="CheckPhoto">
						<ul>

						</ul>
						<i class="prevImg" id="prevImg"></i> 
						<i class="nextImg" id="nextImg"></i>
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
			$(".tzglchild .1tzgl1   a").addClass("active");
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
	<script src="./js/table/DGXLGL.js"></script>
</body>

</html>
