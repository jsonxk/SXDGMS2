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

<title>线路/线杆管理管理</title>
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
<script
	src="https://webapi.amap.com/maps?v=1.4.0&key=e8fe2f8a5385cb0c048947ec75738cb0&plugin=AMap.PolyEditor,AMap.Autocomplete,AMap.PlaceSearch"></script>
<script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
<style type="text/css">
	.LineNameInput2,.LineLength2,.LineNumber2{
	float:left;
	width:25%;
	margin-left: 6%;
}
.LineUnit2,.LineType2,.LineStatus2{
	width:25%;
	float:left;
	margin-left: 6%;
}
.LineTime2{
	margin-left: 6%;
	float:left;
	width:21%;
}
.LineCode2{
	width: 21%;
	margin-left:2%;
	float:left;
}
.LineMemo2{
	width:87%;
	float:left;
	margin-left: 6%;
}
.PoleCode2,#PoleStatus2{
	border-radius:3px;
	border:1px solid #cccccc;
	height:5%;
	width:16%
}
#PoleTimeString2{
	border-radius:3px;
	border:1px solid #cccccc;
	height:5%;
	width:25%
}
#PoleLength2{
	order-radius:3px;
	border:1px solid #cccccc;
	height:5%;
	width:16%
}
#PoleUnit2,#PoleType2{
	border-radius:3px;
	border:1px solid #cccccc;
	height:5%;
	width:16%;
}
.PolePre2,.PoleForLine2{
	border-radius:3px;
	border:1px solid #cccccc;
	height:5%;
	width:25%;
}
#PoleLon2,#PoleLat2{
	border-radius:2px;
	border:1px solid #cccccc;
	height:5%;
	width:15%;
}
#BasicPoleInfo{
	height:450px;
	width:35%;
	float:left;
	border: 1px solid black;
}
#Checkphoto{
	height:440px;
	width:65%;
	float:left;
	overflow: hidden;
}
#Checkphoto ul li{
	height:100%;
	list-style-type:none;
}
#CheckPhoto ul li img{
	width:100%;
	height:100%;
}
.prevImg {
    left: 38%;
    background: url(./images/left_right.png) no-repeat 0 0px;
    background-color: rgba(0, 0, 0, 0.11);
}
.nextImg{
	left: 90%;
    background: url(./images/left_right.png) no-repeat 0 -120px;
    background-color: rgba(0, 0, 0, 0.11);
}
.prevImg,.nextImg {
    width: 58px;
    height: 120px;
    top:150px;
    position: absolute;
    cursor: pointer;
    border-radius: 5px;
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
					<h3 class="page-title">线路/线杆信息管理</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div id="search">
								<button class="btn btn-primary lineNameBtn" type="button">名称</button>
								<input type="text" class="form-control lineName"
									placeholder="输入线路名称" name="lineName">
								<button class="btn btn-primary" type="button" id="lineSearchBtn">查找</button>
							</div>
							<!-- 线路信息表 -->
							<div class="panel-body lineleft">
								<h4>线路信息表</h4>
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
								<h4>线杆信息表</h4>
								<button class="btn btn-primary addPole" type="button">
									<i class="fa fa-plus-square"></i>&nbsp;添加线杆
								</button>
								<div id="poleInfo" class="span10">
									<table id="poleInfoTable">
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
	<!-- modal添加线路弹出框 -->
	<div class="modal fade " id="AddLineModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:125%;margin-left:-10%">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">添加线路信息</h4>
				</div>

				<div class="modal-body">
					<div style="width:100%;height:100%;">
						<form id="LineForm">
							<div class="form-group">
								<div class="form-group LineNameInput">
									<label for="LineNameInput" class="control-label">线路名称</label> <input
										type="text" id="LineNameInput" name="LineNameInput" placeholder="请输入线杆名称"
										class="form-control" />
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
								<div class="form-group LineFirstPolelon">
									<label for="LineFirstPolelon" class="control-label">线路首杆</label>
									<input type="text" id="LineFirstPolelon"
										name="LineFirstPolelon" placeholder="首杆经度"
										class="form-control" readonly />
								</div>
								<div class="form-group LineFirstPolelat">
									<label for="LineFirstPolelat" class="control-label">&nbsp;</label>
									<input type="text" id="LineFirstPolelat"
										name="LineFirstPolelat" placeholder="首杆纬度"
										class="form-control" readonly />
								</div>
								<div class="form-group LineLastPolelon">
									<label for="LineLastPolelonlon" class="control-label">线路尾杆</label>
									<input type="text" id="LineLastPolelon" name="LineLastPolelon"
										placeholder="尾杆经度" class="form-control" readonly />
								</div>
								<div class="form-group LineLastPolelat">
									<label for="LineLastPolelat" class="control-label">&nbsp;</label>
									<input type="text" id="LineLastPolelat" name="LineLastPolelat"
										placeholder="尾杆经度" class="form-control" readonly />
								</div>
							</div>
							<div class="form-group">
								<div class="form-group LineTime">
									<label for="LineTime" class="control-label">添加时间</label> <input
										type="text" id="LineTime" name="LineTime" class="form-control"
										readonly />
								</div>
								<div class="form-group LineCode">
									<label for="LineCode" class="control-label">编码</label>
									<input type="text" id="LineCode"
										name="LineCode" class="form-control"  placeholder="请输入编码" readonly="readonly"/>
								</div>
								<div class="form-group LinePlace">
									<label for="LinePlace" class="control-label">添加地点</label> <input
										type="text" id="LinePlace" name="LinePlace"
										placeholder="请输入搜索地点" class="form-control" />
								</div>
								<div class="form-group LineBtnLocation">
									<label for="LineBtnLocation" class="control-label">&nbsp;</label>
									<input type="button" id="LineBtnLocation"
										name="LineBtnLocation" class="form-control" value="地点定位" />
								</div>
							</div>
							<div class="form-group LineMap" id="LineMap">
								<div id="mapbtn"></div>
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
	<!-- modal添加,编辑线杆弹出框 -->
	<div class="modal fade " id="AddPoleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
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
							<label for="PoleLength" class="control-label">线杆高度</label> <input
							type="text" id="PoleLength" name="PoleLength"
							value="17" readonly /> 
							<label for="PoleStatus" class="control-label">线杆状态</label> 
							<select id="PoleStatus"></select>
							<label for="PoleTime" class="control-label">创建时间</label> <input
							type="text" id="PoleTime" name="PoleTime"  readonly /> 
						</div>
						<div id="secondLayer">
							<label for="PoleUnit" class="control-label">单位名称</label>
							  <select id="PoleUnit">
									</select>
							<label for="PoleType" class="control-label">线杆类型</label>
							 <select id="PoleType">
									</select>
							<label for="PoleLon" class="control-label">经度</label>
							<input
							type="text" id="PoleLon" name="PoleLon" />
							<label for="PoleLat" class="control-label">纬度</label>
							<input
							type="text" id="PoleLat" name="PoleLat" />
							<input type="button" id="addPoleBtn" value="添加线路">
						</div>
						<div id="thirdLayer">
							<div class="thirdLayer0">
								<label for="PolePre" class="control-label">前一杆</label>
								<select class="PolePre" >
								
								</select>
								<label for="PoleForLine" class="control-label">所属线路</label>
							    <select class="PoleForLine" id="PoleForLine0">
									</select>
								<label for="PoleCode" class="control-label">编码</label><input
								   type="text" class="PoleCode" name="PoleCode" />
							</div>
						</div>
						<div id="mapdiv">
						
						</div>
						<div class="poleModalBtn">
							<button type="button" class="btn btn-primary cancelPole" data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-primary OkPole">完成</button>
							<button type="button" class="btn btn-primary OkModifyPole">修改</button>
						</div>
					</div>

				</div>
			</div>
		</div>
		</div>
		<div class="modal fade " id="LineDetailModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width:125%;margin-left:-10%">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="exampleModalLabel">线路详情信息</h4>
					</div>

					<div class="modal-body">
						<div style="width:100%;height:340px;">
							<form id="LineForm">
								<div class="form-group">
									<div class="form-group LineNameInput2">
										<label for="LineNameInput2" class="control-label">线路名称</label>
										<input type="text" id="LineNameInput2" name="LineNameInput2" class="form-control" readonly="readonly"/>
									</div>
									<div class="form-group LineLength2">
										<label for="LineLength2" class="control-label">线路长度</label> <input
											type="text" id="LineLength2" name="LineLength2"
											 class="form-control" readonly />
									</div>
									<div class="form-group LineNumber2">
										<label for="LineNumber2" class="control-label">线杆数量</label> <input
											type="text" id="LineNumber2" name="LineNumber2" value="2"
											placeholder="请输入产生线杆数量" class="form-control" readonly="readonly"/>
									</div>
								</div>
								<div class="form-group">
									<div class="form-group LineUnit2">
										<label for="LineUnit2" class="control-label">单位名称</label> </br> <input
											id="LineUnit2" class="form-control" readonly="readonly"/>
									</div>
									<div class="form-group LineType2">
										<label for="LineType2" class="control-label">线路类型</label> </br> <input
											id="LineType2" class="form-control" readonly="readonly"/>
									</div>
									<div class="form-group LineStatus2">
										<label for="LineStatus2" class="control-label">线路状态</label> </br> <input
											id="LineStatus2" class="form-control" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<div class="form-group LineTime2">
										<label for="LineTime2" class="control-label">添加时间</label> 
										<input
											id="LineTime2" class="form-control" readonly="readonly"/>
									</div>
									<div class="form-group LineCode2">
										<label for="LineCode2" class="control-label">编码</label> <input
											type="text" id="LineCode2" name="LineCode"
											class="form-control"/>
									</div>
								</div>
								<div id="form-group">
									<div class="form-group LineMemo2">
										<label for="LineMemo2" class="control-label">线路描述</label>
										<textarea class="form-control textarea1" rows="2"
											placeholder="项目描述" id="LineMemo2" name="LineMemo2"></textarea>
									</div>
								</div>
								<div class="text-right modalbutton">
									<button type="button" class="btn btn-default LineModalcancel2"
										data-dismiss="modal">关闭</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<!-- modal修改线路线路弹出框 -->
	<div class="modal fade " id="ModifyLineInfo" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:50%;height:525px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">修改线路信息</h4>
				</div>
				<div class="modal-body">
					<form id="mofidylineinfo">
	                    <div class="form-group Modifylinename">
                        	<label for="Modifylinename" class="control-label">线路名称</label>
                        	<input type="text" id="Modifylinename" name="Modifylinename" class="form-control" placeholder="搭挂线路名称"/>
                   		</div>
                   		<div class="form-group Modifylineunit">
	                        <label class="control-label">修改单位</label>
							<select class="form-control modifylineunit2" id="modifylineunit2" >
								
							</select>	
	                    </div>
	                    <div class="form-group Modifylinetype">
	                        <label class="control-label">线路类型</label>
							<select class="form-control modifylinetype2" >
								
							</select>	
	                    </div>
	                    <div class="form-group Modifylinestatus">
	                        <label class="control-label">线路状态</label>
							<select class="form-control modifylinestatus2" >
								
							</select>	
	                    </div>
	                    <div class="form-group Modifylinememo">
	                        <label for="Modifylinememo" class="control-label">线路描述</label>
							<textarea class="form-control textarea1" rows="3" placeholder="搭挂线路描述" id="Modifylinememo" name="Modifylinememo"></textarea>
	                    </div>
	                    <div class="text-right ModifylineBtn">
	                        <span id="returnMessage" class="glyphicon"> </span>
	                        <button type="button" class="btn btn-default right" data-dismiss="modal">取消</button>
	                        <button id="ModifylineOk" type="button" class="btn btn-primary">修改</button>
	                    </div>
	                </form>
				</div>
			</div>
		</div>
		</div>	<!-- 提示信息 -->
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
			<!-- 删除提示信息 -->
			<div class="modal fade " id="DelRtnModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width:35%;margin-top: 50%">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">确定删除此信息？</h4>
						</div>
						<div class="modal-body delInfo">
							<button type="button" id="DelThisLine" class="btn btn-danger  btn-sm" style="margin-right:15px;">删除</button>
							<button type="button" id="DelThisPole" class="btn btn-danger  btn-sm" style="margin-right:15px;">删除</button>
							<button type="button" class="btn btn-default  btn-sm" style="margin-right:15px;" data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
		<!-- modal查看线杆详情 -->
	<div class="modal fade " id="PoleDetailModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width:110%;margin-left:-5%">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">线杆详情信息</h4>
				</div>
				<div class="modal-body">
					<div>
						<div id="firstLayer">
							<label for="PoleLength2" class="control-label">线杆高度</label> <input
							type="text" id="PoleLength2" name="PoleLength2"
							value="17" readonly /> 
							<label for="PoleStatus2" class="control-label">线杆状态</label> 
							<input
							type="text" id="PoleStatus2" name="PoleStatus2"	readonly /> 
							<label for="PoleTimeString2" class="control-label">创建时间</label>
							 <input type="text" id="PoleTimeString2" name="PoleTimeString2"  readonly /> 
						</div>
						<div id="secondLayer">
							<label for="PoleUnit2" class="control-label">单位名称</label>
							 <input type="text" id="PoleUnit2" name="PoleUnit2"  readonly /> 
							<label for="PoleType2" class="control-label">线杆类型</label>
							<input type="text" id="PoleType2" name="PoleType2"  readonly /> 
							<label for="PoleLon2" class="control-label">经度</label>
							<input
							type="text" id="PoleLon2" name="PoleLon2" readonly="readonly"/>
							<label for="PoleLat2" class="control-label">纬度</label>
							<input
							type="text" id="PoleLat2" name="PoleLat2" readonly="readonly"/>
						</div>
						<div id="thirdLayer2">
							
						</div>
						<div class="poleModalBtn">
							<button type="button" class="btn btn-primary cancelPole" data-dismiss="modal">取消</button>
						</div>
					</div>

				</div>
			</div>
		</div>
		</div>
		<!-- 点击查看照片 弹出modal-->
			<div class="modal fade " id="CheckPhotoModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document" style="width:80%;margin-top:5%;">
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
									<label for="Photopolename" class="control-label">线杆名称:</label>
	                        		<input type="text" id="Photopolename" name="Photopolename" class="form-control" />
									<label for="Photopoleunit" class="control-label">所属单位:</label>
	                        		<input type="text" id="Photopoleunit" name="Photopoleunit" class="form-control" />
									<label for="Photopoletype" class="control-label">线杆类型:</label>
	                        		<input type="text" id="Photopoletype" name="Photopoletype" class="form-control"/>
									<label for="Photopolestatus" class="control-label">线杆状态:</label>
	                        		<input type="text" id="Photopolestatus" name="Photopolestatus" class="form-control"/>
									<label for="PhotoTime" class="control-label">拍摄时间:</label>
	                        		<input type="text" id="PhotoTime" name="PhotoTime" class="form-control"/>
									<label for="Photopolememo" class="control-label">线杆描述:</label>
									<textarea class="form-control textarea1" rows="3" placeholder="线杆描述" id="Photopolememo" name="Photopolememo"></textarea>
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
				$(".tzglchild .1tzgl0   a").addClass("active");
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
					if (session.getAttribute("userid") == null||session.getAttribute("userid") == "") {
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
	
	
	<script src="./js/table/XLXGGL.js"></script>
	<script src="./js/table/Linemap.js"></script>
</body>

</html>
