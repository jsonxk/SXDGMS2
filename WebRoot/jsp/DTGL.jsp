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
<script
	src="https://webapi.amap.com/maps?v=1.4.0&key=e8fe2f8a5385cb0c048947ec75738cb0&plugin=AMap.PolyEditor,AMap.Autocomplete,AMap.PlaceSearch"></script>
<script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
<style type="text/css">
#allmap {
	width: 100%;
	height: 100%;
}

.handerButton {
	float: left;
	position: absolute;
	z-index: 1000;
	margin-top: 30px;
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
						class="active"><i class="lnr lnr-file-empty"></i> <span></span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages3" class="collapse in">
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
					<h3 class="page-title">地图信息管理</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel">
								<div style="width:100%;height:68%">
									<div id="allmap">
										<div class="handerButton">
											<select>
												<option>1</option><option>1</option>
											</select>
											<input type="button" class="button" value="添加线路"
												onClick="editor.startEditLine()" /> <input type="button"
												class="button" value="添加线杆" onClick="editor.closeEditLine()" />
											<input type="button" class="button" value="添加搭挂线路"
												onClick="editor.dingwei()" /> <input type="button"
												class="button" value="编辑线杆位置" onClick="editor.dingwei()" />
											<input type="button" class="button" value="删除线杆"
												onClick="editor.dingwei()" /> <input type="button"
												class="button" value="关闭操作" onClick="editor.dingwei()" /> <input
												type="button" class="button" value="点击定位"
												onClick="editor.dingwei()" />
												<input
												type="text" class="button" id="tipinput"
												/>
										</div>
									</div>
									<div id="tip"></div>
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
			</div>
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
	<script type="text/javascript">
		function initIndex() {
			$(".dtglchild .3dtgl0   a").addClass("active");
		}
	</script>
	<script src="./js/pageInit.js"></script>
<!-- <script type="text/javascript">
		//创建地图
		var map, geolocation;
		map = new AMap.Map('allmap', {
			resizeEnable : true,
			zoom : 50,
			center : [121.61122,29.91092 ],
		});
		 //输入提示
    var autoOptions = {
        input: "tipinput"
    };
    var auto = new AMap.Autocomplete(autoOptions);
    var placeSearch = new AMap.PlaceSearch({
        map: map
    });  //构造地点查询类
    AMap.event.addListener(auto, "select", select);//注册监听，当选中某条记录时会触发
    function select(e) {
        placeSearch.setCity(e.poi.adcode);
        placeSearch.search(e.poi.name);  //关键字查询查询
    }
		/* map.plugin(["AMap.ToolBar"],function(){   //在地图中添加ToolBar插件      
        	toolBar = new AMap.ToolBar();  
        	map.addControl(toolBar);       
    	});  */
		//解析定位结果
		function onComplete(data) {
			var str = [ '定位成功' ];
			str.push('经度：' + data.position.getLng());
			str.push('纬度：' + data.position.getLat());
			if (data.accuracy) {
				str.push('精度：' + data.accuracy + ' 米');
			}//如为IP精确定位结果则没有精度信息
			str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
			document.getElementById('tip').innerHTML = str.join('<br>');
		}
		//解析定位错误信息
		function onError(data) {
			document.getElementById('tip').innerHTML = '定位失败';
		}
		//在地图上绘制折线
		var editor = {};
		editor._line = (function() {
			var lineArr = [ [ 116.37, 39.91 ], [ 116.38, 39.90 ],
					[ 116.39, 39.91 ], [ 116.39, 39.90 ] ];
			return new AMap.Polyline({
				map : map,
				path : lineArr,
				strokeColor : "#FF33FF",//线颜色
				strokeOpacity : 1,//线透明度
				strokeWeight : 3,//线宽
				strokeStyle : "solid"//线样式
			});
		})();
		map.setFitView();
		editor._lineEditor = new AMap.PolyEditor(map, editor._line);
		editor.startEditLine = function() {
			editor._lineEditor.open();
		}
		editor.closeEditLine = function() {
			editor._lineEditor.close();
		}
		editor.dingwei = function() {
			 map.plugin('AMap.Geolocation', function() {
				geolocation = new AMap.Geolocation({
					enableHighAccuracy: true,//是否使用高精度定位，默认:true
           	 		timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            		buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            		zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            		uttonPosition:'RB',
					panToLocation : true,
				});
				map.addControl(geolocation);
				geolocation.getCurrentPosition();
				AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
				AMap.event.addListener(geolocation, 'error', onError); //返回定位出错信息
			}); 
		};
		//为地图注册click事件获取鼠标点击出的经纬度坐标
		var clickEventListener = map.on('click', function(e) {
			alert(e.lnglat.getLng() + ',' + e.lnglat.getLat());
		}); 
	</script> -->
	<script type="text/javascript">
/***************************************
由于Chrome、IOS10等已不再支持非安全域的浏览器定位请求，为保证定位成功率和精度，请尽快升级您的站点到HTTPS。
***************************************/
    var map, geolocation;
    //加载地图，调用浏览器定位服务
    map = new AMap.Map('allmap', {
        resizeEnable: true
    });
    map.plugin('AMap.Geolocation', function() {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            buttonPosition:'RB'
        });
        map.addControl(geolocation);
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
    });
    //解析定位结果
    function onComplete(data) {
        var str=['定位成功'];
        str.push('经度：' + data.position.getLng());
        str.push('纬度：' + data.position.getLat());
        if(data.accuracy){
             str.push('精度：' + data.accuracy + ' 米');
        }//如为IP精确定位结果则没有精度信息
        str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
        document.getElementById('tip').innerHTML = str.join('<br>');
    }
    //解析定位错误信息
    function onError(data) {
        document.getElementById('tip').innerHTML = '定位失败';
    }
</script>
</body>

</html>
