<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色/权限管理</title>
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
	
	<link rel="stylesheet" type="text/css" href="./treeview/css/bootstrap-treeview.css">
	<!-- treeview -->
	<link rel="stylesheet" type="text/css" href="./treeview/css/bootstrap.min.css">
  </head>
  <style type="text/css">
#search {
	margin: 1% 0 2% 1%;
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
#reportTableDiv{
	width:60%;
	float:left;
}
#FunctionTree{
	width:38%;
	float:left;
	margin:-6% 1%;
}
.leftIndex li{
	display: none;
}
#ModifyRoleOk{
	background-color: #2B333E;
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
				<a href="index.html"><img src="assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
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
						<li class="sqgl">
							<a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages" class="collapse ">
								<ul class="nav sqglchild">
								</ul>
							</div>
						</li>
						<li class="tzgl">
							<a href="#subPages1" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages1" class="collapse ">
								<ul class="nav tzglchild">
								</ul>
							</div>
						</li>
						<li class="qxgl">
							<a href="#subPages2" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages2" class="collapse ">
								<ul class="nav qxglchild">
								</ul>
							</div>
						</li>
						<li class="dtgl">
							<a href="#subPages3" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages3" class="collapse ">
								<ul class="nav dtglchild">
								</ul>
							</div>
						</li>
						<li class="xtgl">
							<a href="#subPages4" data-toggle="collapse" class="active"><i class="lnr lnr-file-empty"></i> <span></span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages4" class="collapse in">
								<ul class="nav xtglchild">
								</ul>
							</div>
						</li>
						<li class="rcgl">
							<a href="#subPages5" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages5" class="collapse">
								<ul class="nav rcglchild">
								</ul>
							</div>
						</li>
					</ul>
				</nav>
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
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<h3 class="page-title">角色/权限管理</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">角色信息表</h3>
								</div>
								<div id="search">
									<button class="btn btn-primary btnsearch" type="button">姓名</button>
									<input type="text" class="form-control Rolename"
										placeholder="输入姓名">
									<button class="btn btn-primary" type="button" onClick=Search()>查找</button>
								</div>
								<div class="panel-body content-body">
									<div id="reportTableDiv" class="span10">
										<table id="JSQXinfo">
										</table>
									</div>
									<!-- 功能树 -->
									<div id="FunctionTree">
										<div id="treeview1"></div>
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
	<!-- 修改角色信息 -->
	<div class="modal fade " id="ModifyRoleInfo" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:50%;height:300px;margin:10% auto">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">修改角色信息</h4>
				</div>
				<div class="modal-body">
					<form id="mofidyroleinfo">
	                    <div class="form-group ModifyRolename">
                        	<label for="ModifyRolename" class="control-label">角色名称</label>
                        	<input type="text" id="ModifyRolename" name="ModifyRolename" class="form-control" placeholder="角色名称"/>
                   		</div>
                   		<div class="form-group Modifyrolememo">
                        	<label for="Modifyrolememo" class="control-label">线路名称</label>
                        	<textarea class="form-control textarea1" rows="2"
											placeholder="角色描述" id="Modifyrolememo" name="Modifyrolememo"></textarea></div>
	                    <div class="text-right ModifyRoleBtn">
	                        <button type="button" class="btn btn-default right" data-dismiss="modal">取消</button>
	                        <button id="ModifyRoleOk" type="button" class="btn btn-primary">修改</button>
	                    </div>
	                </form>
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
	<script src="./treeview/js/bootstrap-treeview.js" type="text/javascript"></script>
	<script type="text/javascript">
		function initIndex(){
			$(".xtglchild .4xtgl3 a").addClass("active");
		}
		function Search(){
			$('#JSQXinfo').bootstrapTable("refresh");
		}
		$(".userOp").mouseover(function(){
			$(".dropUserInfo").css("display","block");
		})
		$(".userOp").mouseout(function(){
			$(".dropUserInfo").css("display","none");
		})
	</script>
	<script src="./js/pageInit.js"></script>
	<!-- table信息和tree信息 -->
	<div class="userinfo" style="display:none">
				<%
					if (session.getAttribute("userid") == null) {
						response.sendRedirect("login.jsp");
					} else {
				%>
				<script type="text/javascript">
					$(".userNameSpan span").text("<%=session.getAttribute("loginname")%>")
				</script>
				<span><%=session.getAttribute("userid")%></span>
				<p id="p1"><%=session.getAttribute("loginname").toString()%></p>
				<p id="p2"><%=session.getAttribute("unitname").toString()%></p>
				<p id="p3"><%=session.getAttribute("unitid").toString()%></p>
				<%
					}
				%>
	</div>
	<script src="./js/table/JSQX.js"></script>
</body>

</html>
