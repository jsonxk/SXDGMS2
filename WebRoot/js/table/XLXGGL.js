/**
 * 线路/线杆管理
 */
/**
 * 用户id，
 * 单位id
 * 用户
 * 单位名称
 */
var userid=$(".userinfo span").text();
var unitid=$(".userinfo #p3").text();
var loginname=$(".userinfo #p1").text();
var unitname=$(".userinfo #p2").text();
/**
 * 线路对象
 */
var LineInit = function() {
}
/**
 * 线杆对象
 */
var PoleInit = function() {
}
LineInit.prototype = {
	/**
	 * 线路信息初始化
	 */
	LineInfoInit : function() {
		lineinfoinit();
	},
	LineUnitInfo:function(status){
		lineunitinfo(status);
	},
	LineTypeInfo:function(typename){
		linetypeinfo(typename);
	},
};
PoleInit.prototype = {
	/**
	 * 线杆信息初始化
	 * 
	 * @param lineId{线路id}
	 */
	PoleInfoInit : function(lineId) {
		poleinfoinit(lineId);
	}
}
// 线路实例化
var lineinit = new LineInit();
// 线杆初始化
var poleinit = new PoleInit();
//表格偏移量
var fset=0;
$(function() {
	lineinit.LineInfoInit();
	poleinit.PoleInfoInit(0);
});
/**
 * 加载线路信息
 */
function lineinfoinit() {
	$('#lineInfoTable').bootstrapTable("destroy");
	$('#lineInfoTable')
			.bootstrapTable(
					{
						url : 'LinePole/selectAllLine.spring',
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
							field : "name",
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
							poleinit.PoleInfoInit(row.lineid);
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
			'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">删除</button>', ]
			.join('');
}
// 表格操作的按钮事件
window.operateEvents = {
	'click .RoleOfA' : function(e, value, row, index) {
		alert(row.dictypeid);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		DelTypeInfo(row.dictypeid);
		$('#TypeTable').bootstrapTable("refresh");
	},
};
/**
 * 加载线杆信息
 * @param lineid{线路id}
 */
function poleinfoinit(lineid){
	$('#poleInfoTable').bootstrapTable("destroy");
	$('#poleInfoTable').bootstrapTable({
		url:'LinePole/selectpoleinfo.spring',
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
				"lineid":lineid,
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
			'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">删除</button>', ]
			.join('');
}
// 表格操作的按钮事件
window.operateEventspole = {
	'click .RoleOfA' : function(e, value, row, index) {
		alert(row.dictypeid);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		DelTypeInfo(row.dictypeid);
		$('#TypeTable').bootstrapTable("refresh");
	},
};
/**
 * 单位信息初始化
 */
function lineunitinfo(status){
	$.ajax({
		type : "post",
		url : "SQXXGL/selectallunit.spring",
		data : {
			"status" : status,
		},
		datatype : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				$("#LineUnit").append(
						"<option value='" + data[i].unitid + "'>"
								+ data[i].unitname + "</option>");
			}
		}
	});
}
/**
 * 线路类型信息
 * @param typename{线路类别}
 */
function linetypeinfo(typename){
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
			}
		}
	});
}
/**
 * 点击添加线路
 */
$(".addLine").click(function(){
	$("#AddLineModal").modal("show");
	$("#LineTime").val(NowDate());
	lineinit.LineUnitInfo("正常");
	lineinit.LineTypeInfo("线路类别");
	lineinit.LineTypeInfo("线路状态");
})
// 当前时间
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