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
	HangLineInfoInit : function() {
		hanglineinfoinit();
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
	hanglineinit.HangLineInfoInit();
	hangpoleinit.HangPoleInfoInit(0);
	hanglineinit.HangLineUnit("正常");
	hanglineinit.HangLineStatus("搭挂线路类别");
	hanglineinit.HangLineStatus("搭挂线路状态");
	hanglineinit.HangLineStatus("搭挂详情状态");
	hanglineinit.SelectAllLineInfo();
	hangpoleinit.SelectAllPoleInfo();
});
/**
 * 搭挂线路初始化
 */
function hanglineinfoinit(){
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
			'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">详情</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;background-color:#f27d7c;color:white">删除</button>']
			.join('');
}
// 表格操作的按钮事件
window.operateEvents = {
	'click .RoleOfA' : function(e, value, row, index) {
		alert(row.hanglineid);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		alert(row.hanglineid);
	},
};
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
						columns : [ {
							title : "序号",
							align : "center",
							valign : "middle",
							formatter : function(value, row, index) {
								return index+ 1;
							}
						}, {
							field : "name",
							title : "线杆名称",
							align : "center",
							valign : "middle",
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
'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">详情</button>',
'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;background-color:#f27d7c;color:white">删除</button>', ]
			.join('');
}
// 表格操作的按钮事件
window.operateEventspole = {
	'click .RoleOfA' : function(e, value, row, index) {
		alert(row.poleid);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		alert(row.poleid);
	},
};
/**
 * 点击添加线路
 * 显示modal
 */
$(".addLine").click(function(){
	$("#HangLineModal").modal("show");
	$("#HanglineTime").val(NowDate());
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
	LineData["nextpoleid"]=Number($(".HangPoleNext").val());
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
		url : "DGXLGL/selectAllHangPoleName.spring",
		datatype : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				/**
				 * 添加线杆modal
				 */
				$(".HangPole").append(
						"<option value='" + data[i].poleid + "'>"
								+ data[i].name + "</option>");
				$(".HangPolePre").append(
						"<option value='" + data[i].poleid + "'>"
								+ data[i].name + "</option>");
				$(".HangPoleNext").append(
						"<option value='" + data[i].poleid + "'>"
								+ data[i].name + "</option>");
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