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

<title>单位管理</title>
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
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages2" class="collapse">
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
					<h3 class="page-title">单位管理</h3>
					<div class="row">
						<div class="col-md-12">
							<!--单位 TABLE -->
							<div class="panel"  style="height:100%;">
								<!-- 表格信息主体 -->
								<div class="panel-body unitbody">
									<h4>单位信息表</h4>
									<div id="searchUnit">
										<button class="btn btn-primary unitlabel" type="button">单位名称</button>
										<input type="text" class="form-control unitname"
											placeholder="输入单位名称" name="searchname">
										<select id="unitstatus">
											<option value="正常"  selected>正常</option>
											<option value="已删除" class="delunit">已删除</option>
											<option value="" >待完善</option>
										</select>
										<button class="btn btn-primary" type="button" id="Unitbtn">查找</button>
										<button class="btn btn-primary addUnit" type="button">
											<i class="fa fa-plus-square"></i>&nbsp;添加单位
										</button>
									</div>
									<div id="UnitTable" class="span10">
										<table id="unittable" data-side-pagination="server">
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
	<!-- modal添加单位弹出框 -->
	<div class="modal fade " id="UnitModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
	                        aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="exampleModalLabel">添加单位</h4>
	            </div>
	
	            <div class="modal-body">
	                <form id="unitform">
	                    <div class="form-group">
                        	<label for="Uname" class="control-label">单位名称</label>
                        	<input type="text" id="Uname" name="Uname" class="form-control"/>
                   		</div>
	                    <div class="form-group">
	                        <label for="UAddress" class="control-label">单位地址</label>
							<input type="text" id="UAddress" name="UAddress" class="form-control"/>
	                    </div>
	                    <div class="form-group">
	                        <label for="MSpeople" class="control-label">主管人</label>
							<input type="text" id="MSpeople" name="MSpeople" class="form-control"/>
	                    </div>
	                     <div class="form-group">
	                        <label for="MSphone" class="control-label">主管电话</label>
							<input type="text" id="MSphone" name="MSphone" class="form-control"/>
	                    </div>
	                    <div class="form-group">
	                        <label class="control-label">所属类型</label>
							<select class="form-control unittype">
								
							</select>	
	                    </div>
	                    <div class="form-group">
	                        <label for="Umemo" class="control-label">项目描述</label>
							<textarea class="form-control textarea1" rows="3" placeholder="项目描述" id="Umemo" name="Umemo"></textarea>
	                    </div>
	                    <div class="text-right">
	                        <span id="returnMessage" class="glyphicon"> </span>
	                        <button type="button" class="btn btn-default right" data-dismiss="modal">取消</button>
	                        <button id="submitBtn" type="button" class="btn btn-primary">保存</button>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- modal修改单位弹出框 -->
	<div class="modal fade " id="UnitModifyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
	                        aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="exampleModalLabel">修改单位信息</h4>
	            </div>
	
	            <div class="modal-body">
	                <form id="unitModifyform">
	                    <div class="form-group">
	                        <label for="Unitmodifyname" class="control-label">单位名称</label>
							<input type="text" name="Unitmodifyname" class="form-control Unitmodifyname"/>
	                    </div>
	                    <div class="form-group">
	                        <label for="UnitAddress" class="control-label">单位地址</label>
							<input type="text" name="UnitAddress" class="form-control UnitAddress"/>
	                    </div>
	                    <div class="form-group">
	                        <label for="people" class="control-label">主管人</label>
							<input type="text" name="people" class="form-control people"/>
	                    </div>
	                     <div class="form-group">
	                        <label for="phone" class="control-label">主管电话</label>
							<input type="text" name="phone" class="form-control phone"/>
	                    </div>
	                    <div class="form-group">
	                        <label class="control-label">状态</label>
							<select class="form-control unitstatus">
								
							</select>	
	                    </div>
	                    <div class="form-group">
	                        <label class="control-label">所属类型</label>
							<select class="form-control ModifyUnit">
								
							</select>	
	                    </div>
	                    <div class="form-group">
	                        <label for="Umemo" class="control-label">项目描述</label>
							<textarea class="form-control textarea1 Umemo" rows="3" placeholder="项目描述"  name="Umemo"></textarea>
	                    </div>
	                    <div class="text-right">
	                        <span id="returnMessage" class="glyphicon"> </span>
	                        <button type="button" class="btn btn-default right" data-dismiss="modal">取消</button>
	                        <button id="ModifyBtn" type="button" class="btn btn-primary">修改</button>
	
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
	<script type="text/javascript">
		function initIndex() {
			$(".xtglchild .4xtgl4   a").addClass("active");
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
	<script src="./js/table/DWGL.js"></script>
</body>

</html>
