/**
 * 初始化地图
 */
var map;
var geolocation;
/**
 * 定位添加一个可编辑marker
 */
var LocationMarker;
map = new AMap.Map("allmap", {
	resizeEnable : true,
	center : [ 121.611746, 29.911096 ],
	zoom : 15,
	doubleClickZoom : false,
});
(function($) {
	PositionFunc();
	/**
	 * 加载所有线杆 并添加地图marker
	 */
	SelectAllPole(0);
	/**
	 * 加载搭挂线路
	 */
	SelectAllHangLine();

	lineunitinfo("正常");
	linetypeinfo("线杆状态");
	linetypeinfo("线杆类别");
	selectAllLineName(0);
})(jQuery)

/**
 * 点击定位
 */
function PositionFunc() {
	map.plugin('AMap.Geolocation', function() {
		geolocation = new AMap.Geolocation({
			enableHighAccuracy : true,// 是否使用高精度定位，默认:true
			timeout : 10000, // 超过10秒后停止定位，默认：无穷大
			maximumAge : 0, // 定位结果缓存0毫秒，默认：0
			convert : true, // 自动偏移坐标，偏移后的坐标为高德坐标，默认：true
			showButton : true, // 显示定位按钮，默认：true
			buttonPosition : 'LB', // 定位按钮停靠位置，默认：'LB'，左下角
			buttonOffset : new AMap.Pixel(10, 20),// 定位按钮与设置的停靠位置的偏移量，默认：Pixel(10,
													// 20)
			showMarker : true, // 定位成功后在定位到的位置显示点标记，默认：true
			showCircle : false, // 定位成功后用圆圈表示定位精度范围，默认：true
			panToLocation : true, // 定位成功后将定位到的位置作为地图中心点，默认：true
			zoomToAccuracy : true
		// 定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
		});
		map.addControl(geolocation);
		/**
		 * 回调方式获取精确位置
		 */
		geolocation.getCurrentPosition();
		/**
		 * 监听方式获取精确位置
		 */
		AMap.event.AddListener(geolocation, 'complete', onComplete);
	});
}
/**
 * 定位成功函数
 * 
 * @param data
 */
function onComplete(data) {
	LocationMarker = [ data.position.getLng(), data.getLat() ];
}
/**
 * 加载所有线杆
 */
function SelectAllPole(index) {
	$.ajax({
		type : "post",
		url : "LinePole/selectAllPole.spring",
		datatype : "json",
		// contentType:"application/json;charset=UTF-8",
		success : function(data) {
			if (index == 0) {
				for (var i = 0; i < data.length; i++) {
					/**
					 * 地图添加marker
					 */
					AutoAddMarker([ data[i].longtitude, data[i].latitude ],
							data[i].poleid, i);
					// polemarkers.push([data[i].longtitude,data[i].latitude]);
					/**
					 * 添加所属线路
					 */
					$(".thirdLayer" + index + " " + ".PolePre").append(
							"<option value='" + data[i].poleid + "'>"
									+ data[i].name + "</option>");
				}
			} else {
				for (var i = 0; i < data.length; i++) {
					$(".thirdLayer" + index + " " + ".PolePre").append(
							"<option value='" + data[i].poleid + "'>"
									+ data[i].name + "</option>");
				}
			}
		},
	});
}
/**
 * 地图所有的店添加覆盖物
 * 
 * @param AddPosition
 * @param poleid
 * @param index
 */
var polemarker;
var polemarkers = [];
function AutoAddMarker(AddPosition, poleid, index) {
	var poleindex = "pole" + poleid;
	polemarker = new AMap.Marker(
			{ // 添加自定义点标记
				map : map,
				position : AddPosition, // 基点位置
				offset : new AMap.Pixel(-6, -5), // 相对于基点的偏移位置
				content : "<div class='markerid'><div class='MarkercenterDiv'><span style='display:none' id='"
						+ poleindex + "'>" + poleid + "</span></div></div>" // 自定义点标记覆盖物内容
			});
	polemarker.setMap(map);
	/**
	 * 设置marker自定义属性
	 */
	polemarker.setExtData(poleid);
	polemarker.on('mouseover', function(e) {
		// mui('.mui-popover').popover('toggle',document.getElementById("popoverDiv"));
		infowindow.setContent(e.target.content);
		infowindow.open(map,this.getPosition());
		SelectHangLineByPoleid(this, e);
	});
	/**
	 * 所有点标记
	 */
	polemarkers.push(polemarker);
}
var infowindow = new AMap.InfoWindow();
/**
 * 查找搭挂线路信息
 * 有：显示搭挂线路
 * 无：显示线杆信息
 */
function SelectHangLineByPoleid(thismarker, thisevent) {
	$.ajax({
		type : "post",
		url : "HangLine/selectHangLineByPoleid.spring",
		data : {
			poleid : thismarker.getExtData(),
		},
		dataType : "json",
		success : function(data) {
			thismarker.content = "<div class='markercontent'></div>";
			$(".markercontent").text("");
			if (data.length > 0) {
				/**
				 * 显示搭挂线路信息
				 */
				$(".markercontent").append("<h5>所属搭挂线路详情</h5>");
				for (var i = 0; i < data.length; i++) {
					var num = i + 1;
					
					$(".markercontent").append(
							"<div>(" + num + ")" + data[i].hangname
									+ "<a href=''>详情</a></div>");
					/*
					 * for(var j=0;j<data[i].hangList.length;j++) {
					 * $(".hangname").append(data[i].hangList[j].name + ","); }
					 */
				}
			} else {
				/**
				 * 显示线杆信息
				 */
				$.ajax({
					type : "post",
					url : "LinePole/selectPoleInfoByPoleid.spring",
					data : {
						poleid : thismarker.getExtData(),
					},
					dataType : "json",
					success : function(data) {
						$(".markercontent").text("");
						infowindow.setContent(thisevent.target.content);
						infowindow.open(map, thismarker.getPosition());
						for (var i = 0; i < data.length; i++) {
							if(data[i].linedetailList.length>0)
								{
									for(var j=0;j<data[i].linedetailList.length;j++)
										{
											var polenum=j+1;
											$(".markercontent").append("<span>线杆名称["+polenum+"]：</span>"+data[i].linedetailList[j].name+"</br>");
										}
								}
							$(".markercontent").append(
									"<div><span>线杆状态：</span>" + data[i].statusname
											+ "</br><span>线杆类型：</span>" + data[i].typename
											+ "</br><span>线杆高度：</span>" + data[i].height
											+ "</br><span>所属单位：</span>" + data[i].unitname
											+ "</br><span>经度：</span>" + data[i].longtitude
											+ "</br><span>纬度：</span>" + data[i].latitude
											+ "</br><a href=''>跳转到线杆管理界面</a>"
											+ "</div>");
						}
					},
				});
			}
		},
	});

}
/**
 * 加载所有搭挂线路细节 并绘制搭挂线路
 */
function SelectAllHangLine() {
	$
			.ajax({
				type : "post",
				url : "HangLine/selectAllHangAndPole.spring",
				datatype : "json",
				// contentType:"application/json;charset=UTF-8",
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						// AutoAddMarker([data[i].longtitude, data[i].latitude],
						// data[i].poleid, i);
						// polemarkers.push([data[i].longtitude,data[i].latitude]);
						if (data[i].hangList.length > 0) {
							var hanglinelist = data[i].hangList;
							/**
							 * 每一个搭挂线路的poleid和prevpoleid
							 */
							var arr = new Array();
							for (var j = 0; j < hanglinelist.length; j++) {
								/**
								 * 绘制线路 一个poleid和prevpoleid绘线
								 */
								if (hanglinelist[j].prevpoleid != 0) {
									for (var k = 0; k < hanglinelist.length; k++) {
										if (hanglinelist[j].prevpoleid == hanglinelist[k].poleid) {
											arr = [];
											// AutoAddMarker([hanglinelist[j].poleList[0].longtitude,hanglinelist[j].poleList[0].latitude],hanglinelist[j].poleid,
											// i);
											// alert(hanglinelist[j].poleList[0].longtitude+"fdffd"+hanglinelist[j].poleList[0].latitude);
											// alert(hanglinelist[k].poleList[0].longtitude+"fdffd"+hanglinelist[k].poleList[0].latitude);
											arr
													.push(new AMap.LngLat(
															hanglinelist[j].poleList[0].longtitude,
															hanglinelist[j].poleList[0].latitude));
											arr
													.push(new AMap.LngLat(
															hanglinelist[k].poleList[0].longtitude,
															hanglinelist[k].poleList[0].latitude));
											EditMapLine(arr);
										}
									}
								} else {
									/**
									 * 添加marker
									 */
									// alert(hanglinelist[j].poleList[0].latitude);
									// AutoAddMarker([hanglinelist[j].poleList[0].longtitude,hanglinelist[j].poleList[0].latitude],hanglinelist[j].poleid,
									// i);
								}
							}
						}
					}
				},
			});
}
var polyline;
var polylines = [];
/**
 * 绘制线路
 * @param LocationArr
 */
function EditMapLine(LocationArr) {
	// 定义折线对象
	polyline = new AMap.Polyline({
		path : LocationArr, // 设置折线的节点数组
		strokeColor : "#4A4AFF",
		strokeOpacity : 0.8,// 透明度
		strokeWeight : 3,// 线宽
		strokeStyle : "solid",// 线样式
	// strokeDasharray:[10,5]
	});
	polyline.setMap(map);
	polylines.push(polyline);
}
/**
 * 开启编辑线杆操作
 */
var count = 0;
$(".openEditPole").click(function() {
	if (count == 0) {
		$(".openEditPole").css("background-color", "#4A4AFF");
		$(".openEditPole").val("关闭编辑");
		$(".openEditPole").css("color", "#FFFFFF");
		EditPolePosition(count);
		count++;
	} else {
		$(".openEditPole").css("color", "#000000");
		$(".openEditPole").css("background-color", "#FFFFFF");
		$(".openEditPole").val("线杆编辑");
		EditPolePosition(count);
		count = 0;
	}
});
/**
 * 线杆编辑点击事件
 * 
 * @param count{0表示开启编辑，1表示关闭编辑}
 */
function EditPolePosition(count) {
	if (count == 0) {
		for (var i = 0; i < polemarkers.length; i++) {
			polemarkers[i].setDraggable(true);
			polemarkers[i].on('dragend', function(e) {
				for (var j = 0; j < polylines.length; j++) {
					polylines[j].hide();
				}
				/**
				 * 修改经纬度
				 */
				ModifyPolePosition(this.getExtData(), e.lnglat.getLng(),
						e.lnglat.getLat());
			});
		}
	} else {
		for (var i = 0; i < polemarkers.length; i++) {
			polemarkers[i].setDraggable(false);
		}
	}
}
/**
 * 修改poleid位置
 */
function ModifyPolePosition(poleid, lng, lat) {
	$.ajax({
		type : "post",
		url : "LinePole/modifyPolePosition.spring",
		data : JSON.stringify({
			poleid : poleid,
			longtitude : lng,
			latitude : lat,
		}),
		datatype : "json",
		contentType : "application/json;charset=UTF-8",
		success : function(data) {
			SelectAllHangLine();
		}
	});
}
/**
 * 点击开启删除线杆操作
 */
var CountNum = 0;
$(".openDelPole").click(function() {
	if (CountNum == 0) {
		$(".openDelPole").css("background-color", "#4A4AFF");
		$(".openDelPole").val("关闭删除");
		$(".openDelPole").css("color", "#FFFFFF");
		DelPoleMarker(CountNum);
		CountNum++;
	} else {
		$(".openDelPole").css("color", "#000000");
		$(".openDelPole").css("background-color", "#FFFFFF");
		$(".openDelPole").val("线杆删除");
		DelPoleMarker(CountNum);
		CountNum = 0;
	}
})
/**
 * 为marker设置或移除点击事件
 * 
 * @param countnum
 */
function DelPoleMarker(countnum){
	if (countnum == 0) {
		for (var i = 0; i < polemarkers.length; i++) {
			polemarkers[i].on('click', MarkerClickDelFunc);
		}
	} else {
		for (var i = 0; i < polemarkers.length; i++) {
			polemarkers[i].off('click', MarkerClickDelFunc);
		}
	}
}
/**
 * this指的是调用此方法的对象
 */
var MarkerClickDelFunc = function(e) {
	var NowPoleid = this.getExtData();
	$("#DelPoleModal").modal("show");
	var poleElement = document.getElementById("DelPoleOk");
	poleElement.onclick = function() {
		DelNowPoleId(NowPoleid);
	};
}
/**
 * 执行删除操作 1删除线杆，2删除线路细节中包含此杆，3删除搭挂细节中包含此杆
 */
function DelNowPoleId(poleid) {
	$.ajax({
		type : "post",
		url : "LinePole/delPoleByPoleId.spring",
		data : {
			poleid : Number(poleid),
		},
		datatype : "json",
		// contentType:"application/json;charset=UTF-8",
		success : function(data) {
			if (data[0].msg == "删除线杆成功") {
				window.location.reload();
			} else {
				$(".delInfo h4").text(data[0].msg);
				$("#DelRtnModal").modal("show");
			}
		}
	});
}
/**
 * 点击添加线杆
 */
var AddPoleCount = 0;
$(".AddPoleBtn").click(function() {
	if (AddPoleCount == 0) {
		$(this).css("background-color", "#4A4AFF");
		$(this).css("color", "#FFFFFF");
		map.setDefaultCursor("crosshair");
		map.on('click', MapClickListener);
		AddPoleCount++;
	} else {
		$(this).css("background-color", "#FFFFFF");
		$(this).css("color", "#000000");
		map.setDefaultCursor("pointer");
		map.off('click', MapClickListener);
		AddPoleCount = 0;
	}
});
/**
 * 添加线杆点击事件
 */
var MapClickListener = function(e) {
	$("#MapAddPoleModal").modal("show");
	$("#PoleTime").val(NowDate());
	$("#PoleLon").val(e.lnglat.getLng());
	$("#PoleLat").val(e.lnglat.getLat());
	// alert( e.lnglat.getLng()+"w"+ e.lnglat.getLat());
}
/**
 * 点击添加线杆，所属线路
 */
$(".OkPole").click(function() {
	InsertPoleToDB();
});
function InsertPoleToDB() {
	$.ajax({
		type : "post",
		url : "LinePole/insertPoleInfo.spring",
		data : JSON.stringify(PoleInfoObject()),
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			$("#MapAddPoleModal").modal("hide");
			// poleinit.PoleInfoInit(0);
			var childDiv = $('#thirdLayer div').length;
			if (data[0].poleid != null && data[0].poleid != "") {
				for (var i = 0; i < childDiv; i++) {
					InsertLineDetailToDB(i, data[0].poleid);
				}
			} else {
				alert("添加线杆信息失败");
			}
		},
	});
}
/**
 * 添加线杆所属线路
 */
function InsertLineDetailToDB(index, poleid) {
	$.ajax({
		type : "post",
		url : "LinePole/insertPoleLineDetail.spring",
		data : JSON.stringify(LinePoleDetailObject(index, poleid)),
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			if (data) {

			} else {
				alert("添加线路明细失败!");
			}
		},
	});
}
/**
 * 线路线杆明细数据
 * 
 * @param index,poleid
 */
function LinePoleDetailObject(index, poleid) {
	var dataDetail = {};
	var prepoleinfo = $(".thirdLayer" + index + " " + ".PolePre").val();
	var lineforPole = $(".thirdLayer" + index + " " + ".PoleForLine").val();
	var code = $(".thirdLayer" + index + " " + ".PoleCode").val();
	dataDetail["lineid"] = Number(lineforPole);
	dataDetail["poleid"] = poleid;
	dataDetail["prepoleid"] = Number(prepoleinfo);
	dataDetail["code"] = Number(code);
	dataDetail["name"] = $("#PoleNameInput").val();
	;
	console.log(dataDetail);
	return dataDetail;
}
/**
 * 线杆输入信息对象
 * 
 * @returns {___anonymous9623_9624}
 */
function PoleInfoObject() {
	var poleinfo = {};
	// poleinfo["name"]=$("#PoleNameInput").val();
	poleinfo["unitid"] = $("#PoleUnit").val();
	poleinfo["timeString"] = $("#PoleTime").val();
	poleinfo["longtitude"] = $("#PoleLon").val();
	poleinfo["latitude"] = $("#PoleLat").val();
	poleinfo["height"] = $("#MapPoleLength").val();
	poleinfo["type"] = $("#PoleType").val();
	poleinfo["status"] = $("#MapPoleStatus").val();
	// poleinfo["memo"]=$("").val();
	// alert(poleinfo.name+poleinfo.latitude);
	return poleinfo;
}
/**
 * 点击添加搭挂线路信息
 */
var HangNum=0;
$(".AddHangLine").click(function(){
	if (HangNum == 0) {
		$(this).css("background-color", "#4A4AFF");
		$(this).css("color", "#FFFFFF");
		map.setDefaultCursor("crosshair");
		map.on('click', SelectPoleMarker);
		HangNum++;
	} else {
		$(this).css("background-color", "#FFFFFF");
		$(this).css("color", "#000000");
		map.setDefaultCursor("pointer");
		map.off('click', SelectPoleMarker);
		HangNum = 0;
	}
});
/**
 * 添加搭挂线杆点击marker触发事件
 */
var SelectPoleMarker=function(e)
{
	
};
/**
 * 单位信息初始化
 */
function lineunitinfo(status) {
	$.ajax({
		type : "post",
		url : "SQXXGL/selectallunit.spring",
		data : {
			"status" : status,
		},
		datatype : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				/**
				 * 添加线路modal
				 */
				/*
				 * $("#LineUnit").append( "<option value='" + data[i].unitid +
				 * "'>" + data[i].unitname + "</option>");
				 *//**
					 * 添加线杆modal
					 */
				$("#PoleUnit").append(
						"<option value='" + data[i].unitid + "'>"
								+ data[i].unitname + "</option>");
			}
		}
	});
}
/**
 * 获取线路线杆类型状态
 * @param typename
 */
function linetypeinfo(typename) {
	$.ajax({
		type : "post",
		url : "HangLine/selectHangStatus.spring",
		data : {
			typename : typename,
		},
		datatype : "json",
		success : function(data) {
			switch (typename) {
			case ("线路类别"):
				for (var i = 0; i < data.length; i++) {
					$("#LineType").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			case ("线路状态"):
				for (var i = 0; i < data.length; i++) {
					$("#LineStatus").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			case ("线杆类别"):
				for (var i = 0; i < data.length; i++) {
					$("#PoleType").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			case ("线杆状态"):
				for (var i = 0; i < data.length; i++) {
					$("#MapPoleStatus").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			}
		}
	});
}
/**
 * 加载所有的线路基本信息
 * 用于添加线杆时选择所属线路
 */
function selectAllLineName(index) {
	$.ajax({
		type : "post",
		url : "LinePole/selectAllLineName.spring",
		datatype : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				$(".thirdLayer" + index + " " + ".PoleForLine").append(
						"<option value='" + data[i].lineid + "'>"
								+ data[i].name + "</option>");
			}
		}
	});
}
/**
 * 点击添加多个所属线路
 */
var countLineNum = 0;
$("#addPoleBtn")
		.click(
				function() {
					countLineNum++;
					if (countLineNum > 2) {
						countLineNum--;
						alert("最多添加两条!");
					} else {
						$("#thirdLayer")
								.append(
										"<div class='thirdLayer"
												+ countLineNum
												+ "'>"
												+ "<label for='PolePre' class='control-label'>前一杆</label>"
												+ " <select class='PolePre'></select>"
												+ "  <label for='PoleForLine' class='control-label'>所属线路  </label>  <select class='PoleForLine'>"
												+ "	</select>"
												+ " <label for='PoleCode' class='control-label'>编码</label><input"
												+ "  type='text' class='PoleCode' name='PoleCode' />"
												+ "<input type='button' value='删除' class='delLinePole' onclick='deldiv(this)'/>"
												+ "</div>");
						SelectAllPole(countLineNum);
						selectAllLineName(countLineNum);
					}
				})
/*
 * 删除线路线杆输入信息
 */
function deldiv(thisinfo) {
	$(thisinfo).parent().remove();
	countLineNum--;
	$(".thirdLayer2").removeClass("thirdLayer2").addClass("thirdLayer1");
}
/**
 * 当前时间
 * 
 * @returns {String}
 */
function NowDate() {
	var d = new Date();
	var year = d.getFullYear();
	var mon = d.getMonth() + 1;
	var day = d.getDate();
	var Hour = d.getHours();
	var minutes = d.getMinutes();
	var second = d.getSeconds();
	return year + "-" + (mon < 10 ? ('0' + mon) : mon) + "-"
			+ (day < 10 ? ('0' + day) : day) + " " + Hour + ":" + minutes + ":"
			+ second;
}