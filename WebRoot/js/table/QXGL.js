/**
 * 缺陷管理对象
 */
//图片数量
var ImgCount=0;
//图片宽度
var ImgWidth=$("#FaultPhoto").width();
var num=0;
var FaultMenage=function(){}; 
//流程实例Id
var ProcessId=0;
//错误id
var Faultid=0;
var Status=0;
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
	$(".fromtimeFault1").val(getBeforeDate(30));
	$(".dateFinishFault1").val(getBeforeDate(-1));
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
							field : "polename",
							title : "线杆名称",
							align : "center",
							valign : "middle",
						},{
							field : "stringtime",
							title : "上报时间",
							align : "center",
							valign : "middle",
						},{
							field : "statusname",
							title : "缺陷状态",
							align : "center",
							valign : "middle",
						},{
							field : "description",
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
	var opvalue;
	/**
	 * 当前缺陷状态
	 * {0：缺陷上报，1}
	 */
	if(row.statusname=='缺陷上报')
		{
		opvalue = [
					'<button type="button" class="checkApply btn btn-default  btn-sm" style="margin-right:15px;">查看</button>',
					'<button type="button" class="delapply btn btn-danger  btn-sm" style="margin-right:15px;">删除</button>',
					'<button type="button" class="startRepairAct btn btn-info  btn-sm" style="margin-right:15px;">开启整改流程</button>'];
		}
	else if(row.statusname=='发送整改通知书'){
		opvalue = [
					'<button type="button" class="checkApply btn btn-default  btn-sm" style="margin-right:15px;">查看</button>',
					'<button type="button" class="Submitapply btn btn-warning  btn-sm" style="margin-right:15px;">发送通知</button>'];
	}
	else if(row.statusname=="整改完成")
		{
		opvalue = [
					'<button type="button" class="checkApply btn btn-default  btn-sm" style="margin-right:15px;">查看</button>',
					'<button type="button" class="delapply btn btn-danger  btn-sm" style="margin-right:15px;">删除</button>',];
		}
	else{
		opvalue = [
					'<button type="button" class="checkApply btn btn-default  btn-sm" style="margin-right:15px;">查看</button>',
					'<button type="button" class="HandFault btn btn-default  btn-sm" style="margin-right:15px;">处理</button>'];
	}
	
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
		 * 上下图片按钮
		 */
		$(".leftImg").css("display","block");
		$(".rightImg").css("display","block");
		/**
		 * 错误图片信息
		 */
		faultinit.FaultPhoto(row.checkdetailid);
		/**
		 * 缺陷搭挂线路信息
		 */
		faultinit.FaultPoleOfLine(row.poleid);
	},
	'click .delapply' : function(e, value, row, index) {
		/**
		 * 删除缺陷
		 * 可以删除整改完成的或者未开启流程的缺陷
		 */
		$("#DelRtnModal").modal("show");
		var DelThisFault=document.getElementById("DelThisFault");
		DelThisFault.onclick=function(){
			$.ajax({
				type:"post",
				url:"FaultMS/delCheckDtlFault.spring",
				data:{
					"checkdetailid":row.checkdetailid,
				},
				datatype:"json",
				success:function(data){
					$("#DelRtnModal").modal("hide");
					$("#TS_Modal").modal("show");
					if(data)
						{
							$(".TS_Modal h4").text("删除信息成功");
							$('#Faulttable').bootstrapTable("refresh");
						}
					else{
						$(".TS_Modal h4").text("删除信息失败");
					}
				}
			});
		}
	},
	'click .Submitapply' : function(e, value, row, index) {
		/**
		 * 发送通知
		 */
		$("#SubmitRepairModal").modal("show");
		ProcessId=row.processid;
		Faultid=row.faultid;
		Status=row.status1;
		faultinit.FaultPoleOfLine(row.poleid);
	},
	'click .startRepairAct':function(e,value,row,index)
	{
		/**
		 * 开启整改流程
		 */
		//alert(row.unitid);
		StartRepairAct(row.checkdetailid,row.faultid,row.poleid,row.status1);
	},
	'click .HandFault':function(e,value,row,index)
	{
		/**
		 * 处理整改流程
		 */
		ProcessId=row.processid;
		Faultid=row.faultid;
		Status=row.status1;
		if(row.statusname=="整改验收")
			{
				$("#RepairModal").modal("show");
			}
		else{
				$("#WarnModal").modal("show");
		}
	}
};
/**
 * 开启审批流程
 * @param checkdetailid
 * @param faultid
 * @param poleid
 */
function StartRepairAct(checkdetailid,faultid,poleid,status){
	faultinit.FaultPoleOfLine(poleid);
	setTimeout(function(){
		var poleunitid=$("#AdviceUnit").val();
		$.ajax({
			type:"post",
			url:"FaultMS/startRepairAct.spring",
			data:{
				"userid":userid,
				"faultid":faultid,
				"checkdetailid":checkdetailid,
				"unitid":poleunitid,
				"status":status,
			},
			datatype:"json",
			success:function(data){
				faultinit.FaultInfoInit();
				alert(data[0].msg);
			}
		});
	},100);
	
}
/**
 * 处理流程
 * @param hangtype 1表示ok；0表示finish
 */
function HandRepairAct(handtype){
	$.ajax({
		type : "post",
		url : "FaultMS/handerRepairAct.spring",
		data : {
			"userid" : userid,
			"processid":ProcessId,
			"handtype":handtype,
			"faultid":Number(Faultid),
			"status":Number(Status),
		},
		datatype : "json",
		success : function(data) {
			$("#WarnModal").modal("hide");
			faultinit.FaultInfoInit();
			$("#TS_Modal h4").text(data[0].msg);
			$("#TS_Modal").modal("show");
		}
	});
}
/**
 * 点击处理弹窗
 */
$(".WarnOk").click(function(){
	HandRepairAct(1);
});
$(".Warncancel").click(function(){
	$("#WarnModal").modal("hide");
});
/**
 * 整改验收弹窗
 */
$(".RepairOk").click(function(){
	$("#RepairModal").modal("hide");
	HandRepairAct(1);
	
});
$(".RepatrNoOk").click(function(){
	$("#RepairModal").modal("hide");
	HandRepairAct(0);
});
/**
 * modal点击发送通知
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
			//"taskid":TaskId,
			"userid":userid,
			"processid":ProcessId,
			"faultid":Faultid,
			"status":Status,
		},
		fileElementId : "adviceFile",
		dataType : 'JSON',
		success : function(data) {
			$("#SubmitRepairModal").modal("hide");
			faultinit.FaultInfoInit();
			alert("邮件发送成功");
		},
	});
})
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
				$("#FaultPole").val(data[0].name);
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
			$("#FaultPhoto ul").text("");
				if(data.length>0)
					{
						for (var i = 0; i < data.length; i++) {
							$("#FaultPhoto ul").append("<li><img src='"+data[i].photopath+"'></li>");
						}
					}
				else{
					$("#FaultPhoto ul").append("<li><img alt='没有相关图片'></li>");
				}
				ImgCount=data.length;
			}
	});
}
/**
 * 查询
 */
$("#FaultSearch").click(function(){
	$('#Faulttable').bootstrapTable('refresh');
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
	if (num >= ImgCount) {
		$(".leftImg").css("display","block");
		$(".rightImg").css("display","none");
		num=ImgCount-1;
	} else {
		//在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
		//console.log(num);
		$(".leftImg").css("display","block");
		$(".rightImg").css("display","block");
			$('#FaultPhoto ul').animate({marginLeft : -num * ImgWidth},500);
	}
});
$('.leftImg').click(function() {
	if (num <=0) {
		$(".leftImg").css("display","none");
		$(".rightImg").css("display","block");
		num=0;
	} else {
		//在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
		//console.log(num);
		$(".leftImg").css("display","block");
		$(".rightImg").css("display","block");
		num--;
		$('#FaultPhoto ul').animate({marginLeft :-(num)*ImgWidth},500);
	}
});
