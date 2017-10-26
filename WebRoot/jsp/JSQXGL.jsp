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
.fixed-table-body {
	height: 40%;
}
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
					<div class="input-group">
						<input type="text" value="" class="form-control" placeholder="Search dashboard...">
						<span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
					</div>
				</form>
				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
				</div>
				<div id="navbar-menu">
					
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="jsp/index.jsp"><i class="lnr lnr-home"></i> <span>首页</span></a></li>
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
										<div style="display: none;" id="treeviewVal">
											[{"id":9,"text":"汇总数据","level":0,"tag":0,"nodes":[{"id":1020,"text":"礼拜","level":0,"tag":0,"href":"calculation!edit.html"},{"id":1021,"text":"杜甫","level":0,"tag":0,"href":"calculationRecrd!list.html"}],"href":""},{"id":2,"text":"业务记录模块","level":0,"tag":0,"nodes":[{"id":1011,"text":"酒楼变更记录","level":0,"tag":0,"href":"hotelChange!list.html"},{"id":1013,"text":"吉拉拉","level":0,"tag":0,"href":"tdyhRecord!patBarcodeRecordList.html"},{"id":1014,"text":"窜货记录","level":0,"tag":0,"href":"tdyhRecord!tranGoodsRecordList.html"},{"id":1027,"text":"业务员调动记录","level":0,"tag":0,"href":"logInfo!personChange.html"},{"id":1029,"text":"组长调动记录","level":0,"tag":0,"href":"logInfo!groupLeaderChange.html"},{"id":1030,"text":"窜货统计","level":0,"tag":0,"href":"tdyhRecord!statTranGoodsList.html"},{"id":1031,"text":"窜货配置","level":0,"tag":0,"href":"tdyhRecord!tranSet.html"}],"href":""},{"id":3,"text":"账务信息模块","level":0,"tag":0,"nodes":[{"id":1015,"text":"组长待确认账单","level":0,"tag":0,"href":"td!groupLeaderStatementList.html?type=0"},{"id":1018,"text":"组长已确认账单","level":0,"tag":0,"href":"td!groupLeaderStatementList.html?type=1"},{"id":1019,"text":"组长已挂起账单","level":0,"tag":0,"href":"td!groupLeaderStatementList.html?type=2"}],"href":""},{"id":5,"text":"财务对账模块","level":0,"tag":0,"nodes":[{"id":5001,"text":"待确认账单","level":0,"tag":0,"href":"finance!list.html"},{"id":5002,"text":"已确认账单","level":0,"tag":0,"href":"finance!confirmList.html"}],"href":""},{"id":6,"text":"未兑换积分数据","level":0,"tag":0,"nodes":[{"id":5004,"text":"未兑换积分汇总","level":0,"tag":0,"href":"td!surplusSummary.html"}],"href":""},{"id":7,"text":"积分兑换数据","level":0,"tag":0,"nodes":[{"id":5003,"text":"积分兑换汇总","level":0,"tag":0,"href":"td!pointSummary.html"}],"href":""},{"id":8,"text":"积分数据","level":0,"tag":0,"nodes":[{"id":5005,"text":"积分汇总","level":0,"tag":0,"href":"td!integralSummary.html"},{"id":5006,"text":"积分记录","level":0,"tag":0,"href":"td!integralSummaryList.html"}],"href":""},{"id":10,"text":"微信管理","level":0,"tag":0,"nodes":[{"id":1023,"text":"微信红包设置","level":0,"tag":0,"href":"wx!list.html"},{"id":1024,"text":"微信积分配置","level":0,"tag":0,"href":"wxIntegral!list.html"},{"id":1025,"text":"拍码设置","level":0,"tag":0,"href":"patBarcode!edit.html"},{"id":1026,"text":"微信修改日志查询","level":0,"tag":0,"href":"logInfo!list.html"}],"href":""},{"id":11,"text":"微信兑换数据","level":0,"tag":0,"nodes":[{"id":1028,"text":"微信兑换记录","level":0,"tag":0,"href":"td!pointSummaryList1.html?pointType=2"}],"href":""},{"id":12,"text":"活动管理","level":0,"tag":0,"nodes":[{"id":1201,"text":"活动管理","level":0,"tag":0,"href":"activity!list.html"},{"id":1202,"text":"活动统计","level":0,"tag":0,"href":"activityPlay!list.html"}],"href":""}]
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
		<!-- END MAIN -->
		<div class="userinfo" style="display:none">
			<span><%=session.getAttribute("userid") %></span>
		</div>
		<div class="clearfix"></div>
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
	</script>
	<script src="./js/pageInit.js"></script>
	<!-- table信息和tree信息 -->
	<script src="./js/table/JSQX.js"></script>
</body>

</html>
