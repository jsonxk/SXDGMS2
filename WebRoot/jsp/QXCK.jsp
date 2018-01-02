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

<title>缺陷管理</title>
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
	<link rel="stylesheet" type="text/css" href="./css/tabletitle.css">
	<style type="text/css">
		.HandFault{
			background-color: rgba(33,117,232,0.9);
			color:#FFFFFF;
		}
		 .HandFault:hover {
		   	background-color: rgba(33,117,232,1);
		   	color:#FFFFFF;
		}
		.HandFault:active:focus,.HandFault:active{
		 	background-color: rgba(33,117,232,1);
			color:#FFFFFF;
		}
		.checkApply{
			background-color: rgba(92,184,92,0.9);
			color:#FFFFFF;
		}
		 .checkApply:hover {
		 	background-color: rgba(92,184,92,0.9);	
		   	color:#FFFFFF;
		}
		.checkApply:active:focus,.checkApply:active{
		 	background-color: rgba(92,184,92,0.9);
			color:#FFFFFF;
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
						class="active"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages2" class="collapse in">
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
					<h3 class="page-title">缺陷管理</h3>
					<div class="row">
						<div class="col-md-12">
							<div class="panel">
								<!-- 缺陷信息主体 -->
								<div class="panel-body">
									<h4>缺陷信息表</h4>
									<div id="searchFault">
										<!-- 日期查找 -->
										<button class="btn btn-primary" type="button" id="TimeFault">创建时间</button>
										<div class="input-group date fromtimeFault" data-date=""
											data-date-format="dd MM yyyy" data-link-field="dtp_input2"
											data-link-format="yyyy-mm-dd">
											<input class="form-control fromtimeFault1" size="16" type="text"
												value="" readonly> <span class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span></span> <span
												class="form-control to">to</span>
										</div>
										<div class="input-group date dateFinishFault" data-date=""
											data-date-format="dd MM yyyy" data-link-field="dtp_input2"
											data-link-format="yyyy-mm-dd">
											<input class="form-control dateFinishFault1" size="16" type="text"
												value="" readonly> <span class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>
										<span class="form-control spanstatus">&nbsp;缺陷状态</span>
										<select id="FaultStatus" class="form-control">

										</select>
										<span class="form-control spantype">&nbsp;缺陷类型</span>
										<select id="FaultType" class="form-control">

										</select>
										<button class="btn btn-primary" type="button" id="FaultSearch">查找</button>
									</div>
									<div id="FaultTable" class="span10">
										<table id="Faulttable">
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
	<!-- 点击查看按钮 弹出modal-->
			<div class="modal fade " id="CheckFaultModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width:100%">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">缺陷信息</h4>
						</div>

						<div class="modal-body">
							<div id="FaultInfo">
								<label for="FaultPole" class="control-label">线杆名称</label> <input
								type="text" id="FaultPole" name="FaultPole" readonly /> 
								<!-- <label for="FaultOfType" class="control-label">检查类型</label> <input
								type="text" id="FaultOfType" name="FaultOfType"  readonly /> -->
								<label for="FaultPoleStatus" class="control-label">线杆状态</label> <input
								type="text" id="FaultPoleStatus" name="FaultPoleStatus"  readonly />
								</br>
								<label for="FaultLine" class="control-label">所属线路</label> <input
								type="text" id="FaultLine" name="FaultLine" readonly/>
								<label for="FaultOfUnit" class="control-label">单位名称</label> <input
								type="text" id="FaultOfUnit" name="FaultOfUnit"  readonly /> 
								<label for="FaultMemo" class="control-label FaultMemo">缺陷描述</label>
								<textarea class="form-control textarea1" rows="2"
								placeholder="缺陷描述" id="FaultMemo" name="FaultMemo"></textarea> 
								<label for="FaultMemo" class="control-label FaultMemo">缺陷图片</label>
							</div>
							<div id="FaultPhoto">
								<ul>
									
								</ul>
								<i class="leftImg"></i>
								<i class="rightImg"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 点击查看发送通知 弹出modal-->
			<div class="modal fade " id="SubmitRepairModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width:80%">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">发送通知</h4>
						</div>

						<div class="modal-body">
							<div id="FaultInfo">
								<label for="FaultPole" class="control-label">通知类型</label> 
								<select id="AdviceType">
									<option value="0">发送缺陷通知</option>
									<option value="1">发送整改通知</option>
								</select>
								</br>
								<label for="FaultPole" class="control-label">通知单位</label> 
								<select id="AdviceUnit">
									
								</select>
								</br>
								<label for="AdviceHeader" class="control-label">通知标题</label> 
								<input type="text" id="AdviceHeader" name="AdviceHeader" placeholder="请输入通知标题 "/>
								</br>
								<label for="adviceFile" class="control-label">通知文件</label>
								<input type="file" id="adviceFile" name="adviceFile"/>
								<label for="AdviceMemo" class="control-label">通知内容</label>
								<textarea class="form-control textarea1" rows="5"
								placeholder="缺陷描述" id="AdviceMemo" name="AdviceMemo"></textarea> 
							</div>
							<div class="Advicebutton">
									<button type="button" class="btn btn-default Advicecancel"
										data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary SubmitAdvicebtn">发送</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal fade " id="WarnModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width:40%;margin-top: 50%">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">是否确定处理当前任务?</h4>
						</div>
						<div class="modal-body">
									<button type="button" class="btn btn-default Warncancel"
										data-dismiss="modal">否</button>
									<button type="button" class="btn btn-primary WarnOk">是</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 整改是否合格 -->
			<div class="modal fade " id="RepairModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width:40%;margin-top: 50%">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">整改是够合格?</h4>
						</div>
						<div class="modal-body">
									<button type="button" class="btn btn-default RepatrNoOk"
										data-dismiss="modal">不合格</button>
									<button type="button" class="btn btn-primary RepairOk">合格</button>
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
							<button type="button" class="btn btn-danger  btn-sm" style="margin-right:15px;" data-dismiss="modal">关闭</button>
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
			$(".qxglchild .2qxgl1  a").addClass("active");
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
	<script src="./js/table/QXCK.js"></script>
</body>

</html>
