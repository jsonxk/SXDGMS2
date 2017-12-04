/**
 * 缺陷管理对象
 */
//图片数量
var ImgCount=0;
//图片宽度
var ImgWidth=$("#FaultPhoto").width();
var num=0;
var FaultMenage=function(){}; 
//流程任务Id
var TaskId=0;
var userid=$(".userinfo span").text();
//var unitid=$(".userinfo #p3").text();
//var loginname=$(".userinfo #p1").text();
//var unitname=$(".userinfo #p2").text();
FaultMenage.prototype={
		/**
		 * 缺陷信息初始化
		 */
		FaultInfoInit:function(){
			faultInfoInit();
		},
		/**
		 * 缺陷状态查询
		 * @param param
		 */
		FaultStatus:function(param){
			faultStatus(param);
		},
		/**
		 * 缺陷类型查询
		 */
		FaultType:function(){
			faultType();
		},
		/**
		 * 根据poleid查找所属单位，搭挂线路信息
		 * @param poleid
		 */
		FaultPoleOfLine:function(poleid)
		{
			faultPoleOfLine(poleid);
		},
		/**
		 * 查询某次搭挂线路检查上报的图片信息
		 * @param checkdtlid
		 */
		FaultPhoto:function(checkdtlid)
		{
			faultPhoto(checkdtlid);
		},
}
/**
 *初始化对象
 */
var faultinit=new FaultMenage();
$(function(){
	$(".fromtimeFault1").val(getBeforeDate(7));
	$(".dateFinishFault1").val(getBeforeDate(0));
	faultinit.FaultType();
})
/**
 * 初始化缺陷信息
 */
function faultInfoInit(){
	$('#Faulttable').bootstrapTable("destroy");
	$('#Faulttable')
			.bootstrapTable(
					{
						url : 'FaultMS/selectAllFaultInfo.spring',
						method : 'post',
						cache : false,
						striped : true,
						pagination : true,
						pageSize : 10,
						pageNumber : 1,
						//dataField : "rows",
						pageList : [ 10, 20, 40 ],
						sidePagination : "client",
						queryParams : function queryParams(params) {
							var param = {
								"starttime":$(".fromtimeFault1").val(),
								"finishtime":$(".dateFinishFault1").val(),
								"status":Number($("#FaultStatus").val()),
								"type":Number($("#FaultType").val())
							};
							return param;
						},
					/*	responseHandler : function responseHandler(result) {
							// 如果没有错误则返回数据，渲染表格

							return {
								total : result[0].total, // 总页数,前面的key必须为"total"
								rows : result[0].rows
							// 行数据，前面的key要与之前设置的dataField的值一致.
							};
						},*/
						clickToSelect : true,
						paginationPreText : "上一页",
						paginationNextText : "下一页",
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
						},{
							field : "timeString",
							title : "上报时间",
							align : "center",
							valign : "middle",
						},{
							field : "statusname",
							title : "缺陷状态",
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
							//hangpoleinit.HangPoleInfoInit(row.hanglineid);
							$($element).parent().siblings().children().css(
									"background-color", "inherit");
							// 设置本节点和兄弟节点颜色
							$($element).css("background-color", "#cdd3dc")
									.siblings().css("background-color",
											"#cdd3dc");
						},

					});
	$(window).resize(function() {
		$('#Faulttable').bootstrapTable('resetView');
	});
}
function operateFormatter(value, row, index) {
	var opvalue = [
			'<button type="button" class="checkApply btn btn-default  btn-sm" style="margin-right:15px;">查看</button>',
			'<button type="button" class="delapply btn btn-default  btn-sm" style="margin-right:15px;">删除</button>',
			'<button type="button" class="Submitapply btn btn-default  btn-sm" style="margin-right:15px;">发送通知</button>'];
	return opvalue.join('');
}
// 表格操作的按钮事件
window.operateEvents = {
	'click .checkApply' : function(e, value, row, index) {
		$("#CheckFaultModal").modal("show");
		$("#FaultPole").val(row.name);
		$("#FaultOfType").val(row.typename);
		$("#FaultPoleStatus").val(row.statusname);
		$("#FaultMemo").val(row.memo);
		/**
		 * 错误图片信息
		 */
		faultinit.FaultPhoto(row.checkdetailid);
		/**
		 * 缺陷搭挂线路信息
		 */
		faultinit.FaultPoleOfLine(row.poleid);
		TaskId=row.taskid;
	},
	'click .delapply' : function(e, value, row, index) {
	},
	'click .Submitapply' : function(e, value, row, index) {
		$("#SubmitRepairModal").modal("show");
		faultinit.FaultPoleOfLine(row.poleid);
	}
};
/**
 * 查询缺陷状态
 */
function faultStatus(param){
	$.ajax({
		type : "post",
		url : "HangLine/selectHangStatus.spring",
		data : {
			"typename" : param,
		},
		datatype : "json",
		success : function(data) {
			switch (param) {
			case ("缺陷状态"):
				$("#FaultStatus").append(
						"<option value='0'>全部状态</option>");
				for (var i = 0; i < data.length; i++) {
					$("#FaultStatus").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				faultinit.FaultInfoInit();
				break;
			}
		}
	});
}
/**
 * 查询缺陷类型
 */
function faultType(){
	$.ajax({
		type : "get",
		url : "FaultMS/SelectFaultType.spring",
		datatype : "json",
		success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$("#FaultType").append(
							"<option value='" + data[i].checktypeid + "'>"
									+ data[i].name + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				faultinit.FaultStatus("缺陷状态");
			}
	});
}
/**
 * 根据poleid查找单位，搭挂线路信息
 * @param poleid
 */
function faultPoleOfLine(poleid){
	$.ajax({
		type : "post",
		url : "FaultMS/faultPoleOfLine.spring",
		data:{
			"poleid":poleid
		},
		datatype : "json",
		success : function(data) {
				var linedata=[];
				var unitdata=[];
				$("#AdviceUnit").empty();
				for (var i = 0; i < data.length; i++) {
					linedata.push(data[i].hangname);
					unitdata.push(data[i].unitname);
					$("#AdviceUnit").append("<option value="+data[i].unitid+">"+data[i].unitname+"</option>");
				}
				$("#FaultLine").val(linedata);
				$("#FaultOfUnit").val(unitdata);
			}
	});
}
/**
 * 查找缺陷图片信息
 * @param checkdtlId
 */
function faultPhoto(checkdtlId){
	$.ajax({
		type : "post",
		url : "FaultMS/faultPhoto.spring",
		data:{
			"checkdetailid":checkdtlId
		},
		datatype : "json",
		success : function(data) {
				for (var i = 0; i < data.length; i++) {
					$("#FaultPhoto ul").append("<li><img src='"+data[i].photopath+"'></li>");
				}
				ImgCount=data.length;
			}
	});
}
/**
 * 点击发送通知
 */
$(".SubmitAdvicebtn").click(function(){
	$.ajaxFileUpload({
		url : 'FaultMS/submitRepairInfo.spring',
		type : "post",
		secureuri : false,
		data : {
			"type":$("#AdviceType").val(),
			"unitid":$("#AdviceUnit").val(),
			"subject":$("#AdviceHeader").val(),
			"context":$("#AdviceMemo").val(),
			"taskid":TaskId,
			"userid":userid,
		},
		fileElementId : "adviceFile",
		dataType : 'JSON',
		success : function(data) {
			$("#CheckFaultModal").modal("hide");
		},
	});
})
$('.fromtimeFault').datetimepicker({
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
$('.dateFinishFault').datetimepicker({
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
//日期前几天
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
$('.rightImg').click(function() {
	num++;
	if (num >= ImgCount) {
		alert("最后一张");
		num=ImgCount-1;
	} else {
		//在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
		//console.log(num);
			$('#FaultPhoto ul').animate({marginLeft : -num * ImgWidth},500);
	}
});
$('.leftImg').click(function() {
	if (num <=0) {
		alert("第一张");
		num=0;
	} else {
		//在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
		//console.log(num);
		num--;
		$('#FaultPhoto ul').animate({marginLeft :-(num)*ImgWidth},500);
	}
});
