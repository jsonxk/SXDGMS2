/**
 * 搭挂线路管理
 */
var userid=$(".userinfo span").text();
var unitid=$(".userinfo #p3").text();
var loginname=$(".userinfo #p1").text();
var unitname=$(".userinfo #p2").text();
/**
 * 搭挂线路对象
 */
var HangLineInit = function() {
}
/**
 * 搭挂线杆对象
 */
var HangPoleInit = function() {
}
HangLineInit.prototype = {
	/**
	 * 搭挂线路信息初始化
	 */
	HangLineInfoInit : function(hanglineid) {
		hanglineinfoinit(hanglineid);
	},
	/**
	 * 查询所有单位
	 */
	HangLineUnit:function(status){
		hangLineUnit(status);
	},
	/**
	 * 查询所有状态，类型
	 * @param {搭挂线路类别，搭挂线路状态}
	 */
	HangLineStatus:function(param){
		hangLineStatus(param);
	},
	SelectAllLineInfo:function(){
		selectAllLineInfo();
	}
};
HangPoleInit.prototype = {
	/**
	 * 搭挂线杆信息初始化
	 * 
	 * @param lineId{线路id}
	 */
	HangPoleInfoInit : function(lineId) {
		hangpoleinfoinit(lineId);
	},
	SelectAllPoleInfo:function(){
		selectAllPoleInfo();
	}
}
// 搭挂线路实例化
var hanglineinit = new HangLineInit();
// 搭挂线杆初始化
var hangpoleinit = new HangPoleInit();
//表格偏移量
var fset=0;
$(function() {
	/**
	 * 获取地图详情传递过来的参数
	 */
	var DThanglineid=GetQueryString("hanglineid");
	var DTpoleid=GetQueryString("poleidid");
	hanglineinit.HangLineInfoInit(DThanglineid);
	hangpoleinit.HangPoleInfoInit(0);
	hanglineinit.HangLineUnit("正常");
	hanglineinit.HangLineStatus("搭挂线路类别");
	hanglineinit.HangLineStatus("搭挂线路状态");
	hanglineinit.HangLineStatus("搭挂详情状态");
	hanglineinit.SelectAllLineInfo();
	hangpoleinit.SelectAllPoleInfo();
});
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
/**
 * 搭挂线路初始化
 */
function hanglineinfoinit(hanglineid){
	$('#lineInfoTable').bootstrapTable("destroy");
	$('#lineInfoTable')
			.bootstrapTable(
					{
						url : 'DGXLGL/selectAllHangLine.spring',
						method : 'post',
						cache : false,
						striped : true,
						pagination : true,
						pageSize : 10,
						pageNumber : 1,
						dataField : "rows",
						pageList : [ 10, 20, 40 ],
						sidePagination : "server",
						queryParams : function queryParams(params) {
							var param = {
								pageSize : params.limit,
								offset : params.offset,
								"unitid":Number(unitid),
								"name":$(".lineName").val()+"",
								"hanglineid":hanglineid,
								"unitname":$(".lineUnitName").val()+""
							};
							/*for ( var key in serarchInfo) {
								param[key] = serarchInfo[key]
							}*/
							// 偏移量
							fset = params.offset;
							return param;
						},
						responseHandler : function responseHandler(result) {
							// 如果没有错误则返回数据，渲染表格

							return {
								total : result[0].total, // 总页数,前面的key必须为"total"
								rows : result[0].rows
							// 行数据，前面的key要与之前设置的dataField的值一致.
							};
						},
						clickToSelect : true,
						paginationPreText : "上一页",
						paginationNextText : "下一页",
						columns : [ {
							title : "序号",
							align : "center",
							valign : "middle",
							formatter : function(value, row, index) {
								return index + fset + 1;
							}
						}, {
							field : "hangname",
							title : "线路名称",
							align : "center",
							valign : "middle",
						},{
							field : "statusname",
							title : "线路状态",
							align : "center",
							valign : "middle",
						},{
							field : "memo",
							title : "描述",
							align : "center",
							valign : "middle",
						},/* {
							field : "poleNumber",
							title : "线杆数量",
							align : "center",
							valign : "middle",
						}*/ {
							title : "操作",
							align : "center",
							valign : "middle",
							events : operateEvents,
							formatter : operateFormatter
						} ],
						onPageChange : function(size, number) {
						},
						formatNoMatches : function() {
							return '没有找到信息';
						},
						onClickCell : function(field, value, row, $element) {
							// 点击加载某角色的功能
							// td父节点的兄弟节点的子节点颜色
							hangpoleinit.HangPoleInfoInit(row.hanglineid);
							$($element).parent().siblings().children().css(
									"background-color", "inherit");
							// 设置本节点和兄弟节点颜色
							$($element).css("background-color", "#cdd3dc")
									.siblings().css("background-color",
											"#cdd3dc");
						},

					});
	$(window).resize(function() {
		$('#lineInfoTable').bootstrapTable('resetView');
	});
}
function operateFormatter(value, row, index) {
	return [
			'<button type="button" class="HangDetail btn btn-default  btn-sm" style="margin-right:15px;">详情</button>',
			'<button type="button" class="HangModify btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="HangDel btn btn-default  btn-sm" style="margin-right:15px;background-color:#f27d7c;color:white">删除</button>']
			.join('');
}
// 表格操作的按钮事件
window.operateEvents = {
	'click .HangDetail' : function(e, value, row, index) {
		/**
		 * 查看细节
		 */
		$("#HangLineModal").modal("show");
		$("#HangLineOK").css("display","none");
		$("#HangLineModify").css("display","none");
		$("#HanglineCode").val(row.code);
		$("#Hanglinename").val(row.hangname);
		$("#HanglineTime").val(row.timeString);
		$("#HanglineMemo").val(row.memo);
		var HanglineUnit1=document.getElementById("HanglineUnit1");
		for (var i = 0; i < HanglineUnit1.options.length; i++) {
			if (HanglineUnit1.options[i].value == row.unitid) {
				HanglineUnit1.options[i].selected = true;
				$("#HanglineUnit1").attr("disabled","disabled");
			}
		}
		var HanglineType1=document.getElementById("HanglineType1");
		for (var i = 0; i < HanglineType1.options.length; i++) {
			if (HanglineType1.options[i].value == row.type) {
				HanglineType1.options[i].selected = true;
				$("#HanglineType1").attr("disabled","disabled");
			}
		}
		var HanglineStatus1=document.getElementById("HanglineStatus1");
		for (var i = 0; i < HanglineUnit1.options.length; i++) {
			if (HanglineStatus1.options[i].value == row.status) {
				HanglineStatus1.options[i].selected = true;
				$("#HanglineStatus1").attr("disabled","disabled");
			}
		}
	},
	'click .HangModify' : function(e, value, row, index) {
		/**
		 * 修改搭挂线路信息
		 */
		$("#HangLineModal").modal("show");
		$("select").attr("disabled",false);
		$("#HanglineTime").val(NowDate());
		$("#HanglineCode").val(row.code);
		$("#Hanglinename").val(row.hangname);
		$("#HanglineMemo").val(row.memo);
		$("#HangLineModify").css("display","inline");
		$("#HangLineOK").css("display","none");
		var HangLineModify=document.getElementById("HangLineModify");
		/**
		 * 修改搭挂线路信息
		 */
		HangLineModify.onclick=function(){
			var modifyinfo=InsertHangLineArr();
			modifyinfo["hanglineid"]=row.hanglineid;
			$.ajax({
				type : "post",
				url : "DGXLGL/modifyHangLine.spring",
				data : JSON.stringify(modifyinfo),
				datatype : "json",
				contentType : 'application/json',
				success : function(data) {
					$("#HangLineModal").modal("hide");
					$("#TS_Modal").modal("show");
					if(data)
						{
							$(".TS_Modal h4").text("修改信息成功");
						}
					else{
						$(".TS_Modal h4").text("修改信息失败");
					}
				}
			});
		}
	},
	'click .HangDel' : function(e, value, row, index) {
		/**
		 * 删除搭挂线路
		 *  删除hangline
		 *  hangdetail
		 */
		$.ajax({
			type : "post",
			url : "DGXLGL/delHangLine.spring",
			data : {
				hanglineid:row.hanglineid
			},
			datatype : "json",
			success : function(data) {
				$("#HangLineModal").modal("hide");
				$("#TS_Modal").modal("show");
				if(data)
					{
						$(".TS_Modal h4").text("删除搭挂线路成功");
						$('#lineInfoTable').bootstrapTable("refresh");
					}
				else{
					$(".TS_Modal h4").text("删除搭挂失败");
				}
			}
		});
	},
}
/**
 * 点击查找搭挂线杆
 */
$("#lineSearchBtn").click(function(){
	$('#lineInfoTable').bootstrapTable("refresh");
});
/**
 * 搭挂线杆初始化
 * @param lineid{线路id}
 */
function hangpoleinfoinit(hanglineid){
	$('#poleInfoTable').bootstrapTable("destroy");
	$('#poleInfoTable').bootstrapTable({
		url:'DGXLGL/selectHangPole.spring',
		method: 'post',
		cache: false,
		striped: true,
		pagination: true,
		pageSize: 10,
		pageNumber:1,
		pageList: [10, 20, 40],
		sidePagination:'client',
		queryParams: function paramsfunc(){
			var param={
				"hanglineid":hanglineid,
			}
			return param;
		},
		clickToSelect: true,
		paginationPreText: "上一页",
    	paginationNextText: "下一页",
    	contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						columns : [{
							field : "linedetailList",
							title : "线杆名称",
							align : "center",
							valign : "middle",
							formatter:function(value, row, index){
								if(value.length>0)
								{
									return value[0].name;
								}
							}
						}, {
							field : "statusname",
							title : "线杆状态",
							align : "center",
							valign : "middle",
						},{
							title : "操作",
							align : "center",
							valign : "middle",
							events : operateEventspole,
							formatter : operateFormatterpole
						} ],
						onPageChange : function(size, number) {
						},
						formatNoMatches : function() {
							return '请选择线路';
						},
						onClickCell : function(field, value, row, $element) {
							// 点击加载某角色的功能
							// td父节点的兄弟节点的子节点颜色
						},

					});
	$(window).resize(function() {
		$('#poleInfoTable').bootstrapTable('resetView');
	});
}
function operateFormatterpole(value, row, index) {
	return [
'<button type="button" class="PhotoBtn btn btn-default  btn-sm" style="margin-right:15px;">照片</button>',
'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">详情</button>',
'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
'<button type="button" class="PoleDel btn btn-default  btn-sm" style="margin-right:15px;background-color:#f27d7c;color:white">删除</button>']
			.join('');
}
// 表格操作的按钮事件
window.operateEventspole = {
	'click .PhotoBtn' : function(e, value, row, index) {
		$("#CheckPhotoModal").modal("show");
		/**
		 * 线杆基础信息
		 */
		$("#Photopolename").val(row.linedetailList[0].name);
		//$("#Photopoleunit").val(row.unitname);
		//$("#Photopoletype").val(row.typename);
		$("#Photopolestatus").val(row.statusname);
		$("#Photopolememo").text(row.memo);
		/**
		 * 线杆照片信息
		 */
		$.ajax({
			type:"post",
			url:"LinePole/selectPolePhoto.spring",
			data:{
				poleid:row.poleid
			},
			datatype:"json",
			success:function(data)
			{
				$("#CheckPhoto ul").text("");
				$("#prevImg").css("display","block");
				$("#nextImg").css("display","block");
				if(data.length>0)
					{
					$("#PhotoTime").val(data[0].stringcreatetime);
						var ImgHeight=$("#CheckPhoto").height()
						for (var i = 0; i < data.length; i++) {
							$("#CheckPhoto ul").append("<li><img src='"+data[i].photopath+"'></li>");
						}
						var num=0;
						$('#CheckPhoto ul').animate({marginTop :-(num)*ImgHeight},200);
						var prevImg=document.getElementById("prevImg");
						/**
						 * 上一张下一张照片
						 */
						prevImg.onclick=function(){
							if (num <=0) {
								//alert("第一张");
								$("#prevImg").css("display","none");
								$("#nextImg").css("display","block");
								num=0;
							} else {
								//在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
								//console.log(num);
								$("#prevImg").css("display","block");
								$("#nextImg").css("display","block");
								num--;
								$('#CheckPhoto ul').animate({marginTop :-(num)*ImgHeight},500);
								$("#PhotoTime").val(data[num].stringcreatetime);
							}
						}
						var nextImg=document.getElementById("nextImg");
						nextImg.onclick=function(){
							num++;
							if (num >= data.length) {
								//alert("最后一张");
								$("#prevImg").css("display","block");
								$("#nextImg").css("display","none");
								num=data.length-1;
							} else {
								//在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
								//console.log(num);
								$("#prevImg").css("display","block");
								$("#nextImg").css("display","block");
								$('#CheckPhoto ul').animate({marginTop : -num * ImgHeight},500);
								$("#PhotoTime").val(data[num].stringcreatetime);
							}
						}
					}
				else{
					$("#CheckPhoto ul").append("<li><img alt='没有相关图片'></li>");
				}
			}
		});
	},		
	'click .RoleOfA' : function(e, value, row, index) {
		/**
		 * 查看搭挂线杆详情
		 */
		$("#HangPoleModal").modal("show");
		$("#HangPoleOK").css("display","none");
		$("#HangPoleModify").css('display',"none");
		console.log(row);
		$("#HangPoleCode").val(row.linedetailList[0].code);
		$("#HangPoleMemo").text(row.linedetailList[0].memo);
		var HangPolename=document.getElementById("HangPolename");
		for (var i = 0; i < HanglineUnit1.options.length; i++) {
			if (HangPolename.options[i].value == row.hanglineid) {
				HangPolename.options[i].selected = true;
				$("#HangPolename").attr("disabled","disabled");
			}
		}
		var HangPole=document.getElementById("HangPole");
		for (var i = 0; i < HangPole.options.length; i++) {
			if (HangPole.options[i].value == row.poleid) {
				HangPole.options[i].selected = true;
				$("#HangPole").attr("disabled","disabled");
			}
		}
		var HangPolePre=document.getElementById("HangPolePre");
		HangPolePre.options[0].selected = true;
		$("#HangPolePre").attr("disabled","disabled");
		for (var i = 0; i < HangPolePre.options.length; i++) {
			if (HangPolePre.options[i].value == row.prevpoleid) {
				HangPolePre.options[i].selected = true;
				$("#HangPolePre").attr("disabled","disabled");
			}
		}
		var HangPole=document.getElementById("HangPole");
		for (var i = 0; i < HangPole.options.length; i++) {
			if (HangPole.options[i].value == row.poleid) {
				HangPole.options[i].selected = true;
				$("#HangPole").attr("disabled","disabled");
			}
		}
		var HangPoleStatus=document.getElementById("HangPoleStatus");
		for (var i = 0; i < HangPoleStatus.options.length; i++) {
			if (HangPoleStatus.options[i].value == row.status) {
				HangPoleStatus.options[i].selected = true;
				$("#HangPoleStatus").attr("disabled","disabled");
			}
		}
	},
	'click .RoleOfB' : function(e, value, row, index) {
		/**
		 * 修改搭挂线杆信息
		 */
		$("#HangPoleModal").modal("show");
		$("#HangPoleOK").css("display", "none");
		$("#HangPoleModify").css("display", "inline");
		$("select").attr("disabled", false);
		var hanglineModify = document.getElementById("HangPoleModify");
		hanglineModify.onclick = function() {
			var modifypoleinfo = InsertHangPoleArr();
			modifypoleinfo["handdetailid"] = row.handdetailid;
			$.ajax({
				type : "post",
				url : "DGXLGL/modifyHangPole.spring",
				data : JSON.stringify(modifypoleinfo),
				datatype : "json",
				contentType : 'application/json',
				success : function(data) {
					$("#HangPoleModal").modal("hide");
					$("#TS_Modal").modal("show");
					if (data) {
						$(".TS_Modal h4").text("修改搭挂线杆成功");
					} else {
						$(".TS_Modal h4").text("修改搭挂线杆失败");
					}
				}
			});
		}
	},
	'click .PoleDel' : function(e, value, row, index) {
		/**
		 * 根据hangdetailid删除搭挂线杆信息
		 */
		$.ajax({
			type : "post",
			url : "DGXLGL/delHangPole.spring",
			data : {
				handdetailid : row.handdetailid
			},
			datatype : "json",
			success : function(data) {
				$("#TS_Modal").modal("show");
				if (data) {
					$(".TS_Modal h4").text("删除搭挂线杆成功");
					$('#poleInfoTable').bootstrapTable("refresh");
				} else {
					$(".TS_Modal h4").text("删除搭挂线杆失败");
				}
			}
		});
	},
};
/**
 * 点击添加线路 显示modal
 */
$(".addLine").click(function(){
	$("#HangLineModal").modal("show");
	$("#HangLineOK").css("display","inline");
	$("#HangLineModify").css("display","none");
	$("select").attr("disabled",false);
	$("#HanglineTime").val(NowDate());
	$("#HanglineCode").val(new Date().getTime());
	$("#Hanglinename").val("");
	$("#HanglineMemo").val("");
})
/**
 * 添加搭挂线路modal
 * btn ok-->insert
 */
$("#HangLineOK").click(function(){
	$("#HangLineModal").modal("hide");
	$.ajax({
		type : "post",
		url : "DGXLGL/insertHangLine.spring",
		data : JSON.stringify(InsertHangLineArr()),
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			if(data)
				{
				$('#lineInfoTable').bootstrapTable("refresh");
				alert("添加搭挂线路成功");
				}
			else{
				alert("添加失败!");
			}
		},
	});
})
/**
 * 点击添加线路
 * 显示modal
 */
$(".addPole").click(function(){
	$("#HangPoleModal").modal("show");
	//$("#HanglineTime").val(NowDate());
	$("#HangPoleOK").css('display',"inline");
	$("#HangPoleModify").css('display',"none");
	$("select").attr("disabled",false);
	$("#HangPoleCode").val("");
	$("#HangPoleMemo").text("");
})
$("#HangPoleOK").click(function(){
	$("#HangPoleModal").modal("hide");
	$.ajax({
		type : "post",
		url : "DGXLGL/InsertHangPoleDetail.spring",
		data : JSON.stringify(InsertHangPoleArr()),
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			if(data)
				{
				alert("添加搭挂线杆成功");	
				$('#poleInfoTable').bootstrapTable("refresh");
				}
			else{
				alert("添加失败!");
			}
		},
	});
})
/**
 * 所有添加搭挂线路输入信息
 * @returns {}
 */
function InsertHangLineArr(){
	var LineInfo = $("#AddHangLineform").serializeArray();
	var LineData = {};
	$.each(LineInfo, function(i, info) {
		switch (info.name) {
		case ("Hanglinename"):
			LineData["hangname"] = info.value;
			break;
		case ("HanglineTime"):
			LineData["timeString"] = info.value;
			break;
		case ("HanglineCode"):
			LineData["code"] = info.value;
			break;
		case ("HanglineMemo"):
			LineData["memo"] = info.value;
			break;
		};
	})
	LineData["type"]=$(".HanglineType").val();
	LineData["status"]=$(".HanglineStatus").val();
	LineData["unitid"]=$(".HanglineUnit").val();
	console.log(JSON.stringify(LineData));
	return LineData;
}
/**
 * 所欲添加搭挂线杆的信息
 * @returns {___anonymous8591_8592}
 */
function InsertHangPoleArr(){
	var LineData = {};
	LineData["poleid"]=Number($(".HangPole").val());
	LineData["code"]=$("#HangPoleCode").val();
	LineData["hanglineid"]=Number($(".HangPolename").val());
	LineData["prevpoleid"]=Number($(".HangPolePre").val());
	LineData["status"]=Number($(".HangPoleStatus").val());
	LineData["memo"]=$("#HangPoleMemo").val();
	console.log(JSON.stringify(LineData));
	return LineData;
}
/**
 * 查询所有单位
 */
function hangLineUnit(status){
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
				$(".HanglineUnit").append(
						"<option value='" + data[i].unitid + "'>"
								+ data[i].unitname + "</option>");
			}
		}
	});
}
/**
 * 查询所有类型，状态
 */
function hangLineStatus(param){
	$.ajax({
		type : "post",
		url : "HangLine/selectHangStatus.spring",
		data : {
			"typename" : param,
		},
		datatype : "json",
		success : function(data) {
			switch (param) {
			case ("搭挂线路类别"):
				for (var i = 0; i < data.length; i++) {
					$(".HanglineType").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			case ("搭挂线路状态"):
				for (var i = 0; i < data.length; i++) {
					$(".HanglineStatus").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			case ("搭挂详情状态"):
				for (var i = 0; i < data.length; i++) {
					$(".HangPoleStatus").append(
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
 * 查询所有线路
 * @returns {String}
 */
function selectAllLineInfo(){
	$.ajax({
		type : "post",
		url : "DGXLGL/selectAllHangLineName.spring",
		datatype : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				/**
				 * 添加线路modal
				 */
				$(".HangPolename").append(
						"<option value='" + data[i].hanglineid + "'>"
								+ data[i].hangname + "</option>");
			}
		}
	});
}
/**
 * 查询所有线杆
 * @returns {String}
 */
function selectAllPoleInfo(){
	$.ajax({
		type : "post",
		url : "LinePole/selectAllPole.spring",
		datatype : "json",
		success : function(data) {
			$(".HangPolePre").append(
					"<option value='0'>无</option>");
			for (var i = 0; i < data.length; i++) {
				/**
				 * 添加线杆modal
				 */
				$(".HangPole").append(
						"<option value='" + data[i].poleid + "'>"
								+ data[i].linedetailList[0].name + "</option>");
				$(".HangPolePre").append(
						"<option value='" + data[i].poleid + "'>"
								+ data[i].linedetailList[0].name + "</option>");
				/*$(".HangPoleNext").append(
						"<option value='" + data[i].poleid + "'>"
								+ data[i].linedetailList[0].name + "</option>");*/
			}
		}
	});
}
//当前时间
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