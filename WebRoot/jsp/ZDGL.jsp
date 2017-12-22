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

<title>字典管理</title>
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
						class="collpsed"><i class="lnr lnr-file-empty"></i> <span></span>
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
					<h3 class="page-title">字典信息设置</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel" style="height:100%;">
								<div id="search">
									<button class="btn btn-primary btntypename" type="button">字典类型</button>
									<input type="text" class="form-control typename"
										placeholder="输入类型名称" name="searchname">
									<button class="btn btn-primary" type="button" id="searchBtn">查找</button>
								</div>
								<!-- 表格信息主体 -->
								<div class="panel-body typeleft">
									<h4>字典类型表</h4>
									<button class="btn btn-primary addbtn" type="button">
										<i class="fa fa-plus-square"></i>&nbsp;添加类型
									</button>
									<div id="ZDtype" class="span10">
										<table id="TypeTable" data-side-pagination="server">
										</table>
									</div>
								</div>
								<div class="panel-body itemright">
									<h4>类型项目表</h4>
									<button class="btn btn-primary addItem" type="button">
										<i class="fa fa-plus-square"></i>&nbsp;添加项目
									</button>
									<div id="ZDitem" class="span10">
										<table id="ItemTable">
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
	<!-- modal添加类型弹出框 -->
	<div class="modal fade " id="TypeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
	                        aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="exampleModalLabel">添加字典类型</h4>
	            </div>
	
	            <div class="modal-body">
	                <form id="updateform">
	                    <div class="form-group">
                        	<label for="ZDtypename" class="control-label">类型名称</label>
                        	<input type="text" id="ZDtypename" name="ZDtypename" class="form-control"/>
                   		</div>
	                    <div class="form-group">
	                        <label for="ZDmemo" class="control-label">类型描述</label>
							<textarea class="form-control textarea1" rows="3" placeholder="字典描述" id="ZDmemo" name="ZDmemo"></textarea>
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
		<!-- modal添加项目弹出框 -->
	<div class="modal fade " id="ItemModal" tabindex="-1" role="dialog" aria-labelledby="ModalLabelItem">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
	                        aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="ModalLabelItem">添加字典项目</h4>
	            </div>
	
	            <div class="modal-body">
	                <form id="ItemForm">
	                    <div class="form-group">
                        	<label for="ZDItemname" class="control-label">项目名称</label>
                        	<input type="text" id="ZDItemname" name="ZDItemname" class="form-control"/>
                   		</div>
                   		<div class="form-group">
                        	<label for="ZDItemname" class="control-label">所属类型</label>
							</br>
							<select id="ZDtypeInfo" class="form-control">
                       		</select>		
                   		</div>
                   		<div class="form-group">
                        	<label for="ZDItemCode" class="control-label">项目编号</label>
                        	<input type="text" id="ZDItemCode" name="ZDItemCode" class="form-control"/>
                   		</div>
	                    <div class="form-group">
	                        <label for="ZDItemmemo" class="control-label">项目描述</label>
							<textarea class="form-control textarea1" rows="3" placeholder="项目描述" id="ZDItemmemo" name="ZDItemmemo"></textarea>
	                    </div>
	                    <div class="text-right">
	                        <span id="returnMessage" class="glyphicon"> </span>
	                        <button type="button" class="btn btn-default right" data-dismiss="modal">取消</button>
	                        <button id="ItemSubmit" type="button" class="btn btn-primary">保存</button>
	
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
			$(".xtglchild .4xtgl1   a").addClass("active");
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
	<script src="./js/table/ZDGL.js"></script>
</body>

</html>
