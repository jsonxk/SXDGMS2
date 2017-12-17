/**
 * 申请信息管理
 */
var SQXXGLTable = function() {
};
SQXXGLTable.prototype = {
	/**
	 * 初始化加载申请信息
	 */
	TableInit : function() {
		tableinit();
	},
	/**
	 * 加载所有的申请状态item
	 * 
	 * @param typename{申请状态}
	 */
	TableStatus : function(typename) {
		SelectStatus(typename);
	},
	/**
	 * 查找所有单位信息
	 */
	TableUnitInfo : function(status) {
		SelectUnitInfo(status);
	},
	SelectAllHangLineInfo:function(){
		selectAllHangLineInfo();
	}
};

// 实例化表格对象
var sqxxtable = new SQXXGLTable();
// 用户id
var userid = $(".userinfo span").text();
// 偏移量
var fset = 0;
var ProcessId=0;
var ApplyId=0;
var ApplyUnitId=0;
var HangLineid=0;
var ApplyStatus="";
$(function() {
	TodayTime();
	sqxxtable.TableStatus("申请状态");
	sqxxtable.TableUnitInfo("正常");
	sqxxtable.SelectAllHangLineInfo();
})
/**
 * 初始化加载申请信息表格
 */
function tableinit() {
	$('#sqxxgltable').bootstrapTable("destroy");
	$('#sqxxgltable').bootstrapTable(
			{
				url : 'SQXXGL/selectApplyAndTask.spring',
				method : 'post',
				cache : false,
				striped : true,
				pagination : true,
				pageSize : 10,
				pageNumber : 1,
				dataField : "rows",
				sidePagination : "server",
				queryParams : function queryParams(params) {
					/**
					 * @param status=0表格加载全部申请类型
					 *            timestatus{0表示申请时间1表示批准时间}
					 */
					var status = $("#HangStatus").val();
					if (status == "") {
						status = 0
					}
					var timestatus = $("#TimeType").val();
					var timeinfo = {};
					if (timestatus == 0) {
						timeinfo = {
							"starttime" : $(".timevalue").val(),
							"finishtime" : $(".finishtime").val(),
						};
					} else {
						timeinfo = {
							"permittimestart" : $(".timevalue").val(),
							"permitfinishtime" : $(".finishtime").val(),
						}
					}
					var param = {
						pageSize : params.limit,
						offset : params.offset,
						"status" : Number(status),
						//"timestatus" : Number($("#TimeType").val()),
						"userid" : Number(userid),
						//"unitid" : Number($("#ApplyUnittype").val()),
					};
					for ( var key in timeinfo) {
						param[key] = timeinfo[key];
					}
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
					field : "username",
					title : "申请人",
					align : "center",
					valign : "middle",
				}, {
					field : "unitname",
					title : "申请单位",
					align : "center",
					valign : "middle",
				}, {
					field : "contactperson",
					title : "联系人",
					align : "center",
					valign : "middle",
				}, {
					field : "contactphone",
					title : "联系电话",
					align : "center",
					valign : "middle",
				}, {
					field : "applystringtime",
					title : "申请时间",
					align : "center",
					valign : "middle",
				}, {
					field : "permitStringtime",
					title : "批准时间",
					align : "center",
					valign : "middle",
				}, {
					field : "description",
					title : "申请描述",
					align : "center",
					valign : "middle",
				}, {
					field : "statusname",
					title : "申请状态",
					align : "center",
					valign : "middle",
				}, {
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
					// ItemInit(row.dictypeid);
					$($element).parent().siblings().children().css(
							"background-color", "inherit");
					// 设置本节点和兄弟节点颜色
					$($element).css("background-color", "#cdd3dc").siblings()
							.css("background-color", "#cdd3dc");
				},

			});
	$(window).resize(function() {
		$('#sqxxgltable').bootstrapTable('resetView');
	});
}
/**
 * 表格自定义操作
 * 
 * @param value
 * @param row
 * @param index
 * @returns
 */
function operateFormatter(value, row, index) {
	var opvalue = [
			'<button type="button" class="delapply btn btn-default  btn-sm" style="margin-right:15px;">删除</button>',
			'<button type="button" class="Handerapply btn btn-default  btn-sm" style="margin-right:15px;">处理</button>' ];
	if (row.statusname == "完成") {
		opvalue
				.push('<button type="button" class="Checkapply btn btn-default  btn-sm" style="margin-right:15px;">查看</button>');
	}
	return opvalue.join('');
}
// 表格操作的按钮事件
window.operateEvents = {
	'click .delapply' : function(e, value, row, index) {

	},
	'click .Handerapply' : function(e, value, row, index) {
		HanderApply(row);
	},
	'click .Checkapply' : function(e, value, row, index) {
	},
};
function HanderApply(row) {
	/**
	 * 处理的弹窗
	 */
	$("#HanderModal").modal("show");
	/**
	 * 加载申请信息
	 */
	$("#HM_ApplyUser").val(row.username);
	$("#HM_ApplyUnit").val(row.unitname);
	$("#HM_ApplyContract").val(row.contactperson);
	$("#HM_ApplyPhone").val(row.contactphone);
	//$("#HM_ApplyHang").val(row.hangname);
	$("#HM_ApplyCode").val(row.num);
	$("#HM_ApplyTime").val(row.applystringtime);
	$("#HM_ApplyStatus").val(row.statusname);
	$("#HM_ApplyMemo").text(row.description);
	if(row.statusname=="申请受理")
		{
			$(".HM_SelectHang").css("display","inline");
			$("#HM_ApplyHang").css("display","none");
		}
	else{
		$(".HM_SelectHang").css("display","none");
		$("#HM_ApplyHang").css("display","inline");
		$("#HM_ApplyHang").val(row.hangname);
		HangLineid=row.hanglineid;
	}
	if(row.statusname=="现场查勘"||row.statusname=="签证发放"||row.statusname=="施工"||row.statusname=="整改")
		{
			$(".HM_NoOK").css("visibility","hidden");
			$(".HM_OK").css("visibility","visible");
		}
	else if(row.statusname=="完成")
		{
			$(".HM_NoOK").css("visibility","hidden");
			$(".HM_OK").css("visibility","hidden");
		}
	else{
		$(".HM_NoOK").css("visibility","visible");
		$(".HM_OK").css("visibility","visible");
	}
	ProcessId=row.processid;
	ApplyId=row.applyid;
	ApplyUnitId=row.unitid;
	ApplyStatus=row.statusname;
	/*$.ajax({
		type : "post",
		url : "",
		data : {
			"taskid" : row.taskId,
			"userid":row.userid
		},
		datatype : "json",
		success : function(data) {
		}
	})*/
}
/**
 * 点击处理后点击通过
 */
$(".HM_OK").click(function(){
	/**
	 * 处理申请信息
	 */
	ApplyHander(1);
});
/**
 * 点击处理点击驳回
 */
$(".HM_NoOK").click(function(){
	ApplyHander(0);
});
function ApplyHander(handflag){
	var hangid=0;
	if(ApplyStatus=="申请受理")
		{
			hangid=$(".HM_SelectHang").val();
		}
	else{
		hangid=HangLineid;
	}
	$.ajax({
		type : "post",
		url : "SQXXGL/handerApply.spring",
		data : {
			"processid" : ProcessId,
			"applyid":ApplyId,
			"hanglineid":Number(hangid),
			"handtype":handflag,
			"userid":Number(userid),
			"unitid":ApplyUnitId,
		},
		datatype : "json",
		success : function(data) {
			$("#HanderModal").modal("hide");
			$('#sqxxgltable').bootstrapTable("refresh");
			alert(data[0].msg);
		}
	})
	
}
/**
 * 加载搭挂申请状态类型
 * 
 * @param typename(申请状态)
 */
function SelectStatus(typename) {
	$.ajax({
		type : "post",
		url : "HangLine/selectHangStatus.spring",
		data : {
			typename : typename,
		},
		datatype : "json",
		success : function(data) {
			switch (typename) {
			case ("申请状态"):
				$("#HangStatus").append(
						"<option selected value='0'> 全部分类</option>");
				for (var i = 0; i < data.length; i++) {
					$("#HangStatus").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			case ("建设类型"):
				for (var i = 0; i < data.length; i++) {
					$("#ApplyBuildType").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
				}
				break;
			}
		}
	});
}
/**
 * 查找信息
 * 
 * @param{unitid,time,applytype}
 */
$("#Hangbtn").click(function() {
	sqxxtable.TableInit();
})
/**
 * 加载所有单位信息 功能:用户查找
 */
function SelectUnitInfo(status) {
	$.ajax({
		type : "post",
		url : "SQXXGL/selectallunit.spring",
		data : {
			"status" : status,
		},
		datatype : "json",
		success : function(data) {
			$("#ApplyUnittype").append(
					"<option value='0' selected>全部单位</option>");
			for (var i = 0; i < data.length; i++) {
				$("#ApplyUnittype").append(
						"<option value='" + data[i].unitid + "'>"
								+ data[i].unitname + "</option>");
			}
			sqxxtable.TableInit();
		}
	});
}
/**
 * 查询所有的搭挂线路
 */
function selectAllHangLineInfo(){
	$.ajax({
		type : "post",
		url : "DGXLGL/selectAllHangLineName.spring",
		datatype : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				$(".HM_SelectHang").append(
						"<option value='" + data[i].hanglineid + "'>"
								+ data[i].hangname + "</option>");
			}
		}
	});
}
// 时间选择器
function TodayTime() {
	var today = new Date();
	$(".timevalue").val(getBeforeDate(7));
	$(".finishtime").val(getBeforeDate(-1));
	var time1 = $(".timevalue").val();
	var time2 = $(".finishtime").val();
	if (time1 > time2) {
		alert("开始时间不能大于结束时间!");
	}
}
// 日期前几天
function getBeforeDate(n) {
	var d = new Date();
	d.setDate(d.getDate() - n);
	var year = d.getFullYear();
	var mon = d.getMonth() + 1;
	var day = d.getDate();
	var s = year + "-" + (mon < 10 ? ('0' + mon) : mon) + "-"
			+ (day < 10 ? ('0' + day) : day);
	return s;
}
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
$('.form_date').datetimepicker({
	defaultDate : new Date(),
	weekStart : 1,
	todayBtn : 1,
	autoclose : 1,
	todayHighlight : 1,
	startView : 2,
	minView : 2,
	forceParse : true,
	format : "yyyy-mm-dd",
});
$('.dateFinish').datetimepicker({
	defaultDate : new Date(),
	weekStart : 1,
	todayBtn : 1,
	autoclose : 1,
	todayHighlight : 1,
	startView : 2,
	minView : 2,
	forceParse : true,
	format : "yyyy-mm-dd",
});