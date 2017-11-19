/*
 * 搭挂申请管理
 * */
var userid=$(".userinfo span").text();
var unitid=$(".userinfo #p3").text();
var loginname=$(".userinfo #p1").text();
var unitname=$(".userinfo #p2").text();
var DGSQTableInit = function() {

}
DGSQTableInit.prototype = {
	/**
	 * 初始化表格信息
	 */
	DGInfoInit : function() {
		// alert("show");
		DGInit();
	},
	/**
	 * 状态初始化
	 */
	DGInfoStatus : function(typename) {
		SelectStatus(typename);
	},
	/**
	 * 添加申请信息
	 */
	AddApplyInfo : function() {
		InsertApplyInfo();
	},
	/**
	 * 提交申请
	 */
	SubmitApplyInfo : function(row) {
		SubmitApply(row);
	},
	DelApplyInfo : function(applyid) {
		DelApplyInfoFunc(applyid);
	}
};
/**
 * 实例化表格对象
 */
var init = new DGSQTableInit();
// 分页偏移量参数
var fset = 0;
// 添加申请信息表单验证
var form = $('#ApplyForm');
// 提交申请状态id
var ApplyStatus = 0;
// 申请id
var ApplyId = 0;
// 文件标记
var fileflag = 0;
// 文件上传返回标记
var Filereturndata = "";
$(function() {
	TodayTime();
	init.DGInfoStatus("申请状态");
	init.DGInfoInit();
	init.DGInfoStatus("建设类型");
	DocTypeTable();
})
/**
 * 查找信息
 */
$("#Hangbtn").click(function() {
	init.DGInfoInit();
});
/**
 * 添加申请
 */
$(".addHang").click(function() {
	init.AddApplyInfo();
	$("#FilePromet").css("display", "none");
});
/**
 * 申请信息表格
 * 
 * @param 搜索参数(类型，
 *            申请日期，批准日期)
 */
function DGInit(serarchInfo) {
	$('#hanglinetable').bootstrapTable("destroy");
	$('#hanglinetable').bootstrapTable({
		url : 'HangLine/SelectApplyInfo.spring',
		method : 'post',
		cache : false,
		striped : true,
		pagination : true,
		pageSize : 10,
		pageNumber : 1,
		dataField : "rows",
		sidePagination : "server",
		queryParams : function queryParams(params) {
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
				"timestatus" : Number($("#TimeType").val()),
				"userid":Number(userid),
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
			// $($element).parent().siblings().children().css("background-color","inherit");
			// 设置本节点和兄弟节点颜色
			// $($element).css("background-color","#cdd3dc").siblings().css("background-color","#cdd3dc");
		},

	});
	$(window).resize(function() {
		$('#hanglinetable').bootstrapTable('resetView');
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
			'<button type="button" class="checkApply btn btn-default  btn-sm" style="margin-right:15px;">查看</button>',
			'<button type="button" class="delapply btn btn-default  btn-sm" style="margin-right:15px;">删除</button>' ];
	if (row.statusname == "提交申请") {
		opvalue
				.push('<button type="button" class="Upapply btn btn-default  btn-sm" style="margin-right:15px;">提交</button>');
	}
	return opvalue.join('');
}
// 表格操作的按钮事件
window.operateEvents = {
	'click .checkApply' : function(e, value, row, index) {
	},
	'click .delapply' : function(e, value, row, index) {
	},
	'click .Upapply' : function(e, value, row, index) {
		init.SubmitApplyInfo(row);
	},
};
/**
 * 提交按钮
 * @param row{基本信息applyid,applystringtime,applytime,buildcontact,buildphone,contactphone,,hanglineid,文件信息applydocid,docname,docpath}
 */
function SubmitApply(row) {
	ApplyId=row.applyid;
	$(".cancel").css("display", "block");
	$("#NextSubmit").css("display", "none");
	$("#NextSubmit2").css("display", "block");
	$("#HangModal").modal("show");
	/*
	 * 开启表单验证
	 */
	modalApply();
	/**
	 * 表单数据
	 */
	$("#ApplyPeople").val(row.username);
	$("#ApplyNumber").val(row.num);
	$("#ApplyUnit").val(row.unitname);
	$("#ApplyTime").val(row.applystringtime);
	$("#ApplyContact").val(row.contactperson);
	$("#ApplyPhone").val(row.contactphone);
	$("#ApplyMemo").val(row.description);
	/**
	 * 设置建设类型
	 */
	var select = document.getElementById("ApplyBuildType");
	for (var i = 0; i < select.options.length; i++) {
		if (select.options[i] == row.buildtype) {
			select.options[i].selected = true;
		}
	}
	/**
	 * 文件基本信息
	 */
	for(var j=0;j<row.listDoc.length;j++)
		{
			$('.tablefiles'+row.listDoc[j].doctypeid).val(row.listDoc[j].docname);
		}
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
					if (data[i].item == "提交申请") {
						ApplyStatus = data[i].dicitemid;
					}
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
 * 添加申请信息(Modal)
 */
function InsertApplyInfo() {
	$("#HangModal").modal("show");
	/*
	 * 表单验证
	 */
	modalApply();
	var applyname = loginname;
	$("#ApplyPeople").val(applyname);
	$("#ApplyNumber").val(new Date().getTime());
	$("#ApplyUnit").val(unitname);
	$("#ApplyTime").val(NowDate());
	$(".cancel").css("display", "block");
	$("#NextSubmit").css("display", "block");
	$("#NextSubmit2").css("display", "none");
}
/**
 * modal中step步骤条
 */
var eventFun = {
	/**
	 * modal 下一步功能
	 * 
	 * @param index
	 *            下一页参数
	 * @param flag
	 *            判断第一次下一步还是第二次
	 */
	next : function(index, flag) {
		var bv = form.data('bootstrapValidator');
		bv.validate();
		if (bv.isValid()) {
			$("#step" + (index - 1) + "Li").removeClass("active");
			$("#step" + (index) + "Li").addClass("active blue").removeClass(
					"gray");
			$("#step" + index + "Img").attr("src",
					"./step/images/blue_blue.png");
			$("#step1").removeClass("active in");
			$("#step2").addClass("active in");
			/*
			 * flag=0||1 0 添加 1 修改
			 */
			if (flag == 0) {
				$.ajax({
					type : "post",
					url : "HangLine/InsertApplyInfo.spring",
					data : JSON.stringify(InsertFormInfo()),
					datatype : "json",
					contentType : 'application/json',
					success : function(data) {
						ApplyId = data[0].Insert;
					},
				});

			} else {
				$.ajax({
					type : "post",
					url : "HangLine/ModifyApplyInfo.spring",
					data : JSON.stringify(InsertFormInfo()),
					datatype : "json",
					contentType : 'application/json',
					success : function(data) {
					},
				});

			}
			// $(".Modalheight").attr("height","84%");
		} else {
			alert("请根据提示完善信息");
		}
	},
	/**
	 * 1.cancel 取消 2.NextSubmit 添加申请第一次下一步用户添加信息 3.NextSubmit2 返回基础信息录入后下一步用户信息
	 * 
	 * @param index
	 */
	pre : function(index) {
		$("#step" + (index + 1) + "Li").removeClass("active blue").addClass(
				"gray");
		$("#step" + (index) + "Li").addClass("active");
		$("#step" + (index + 1) + "Img").attr("src",
				"./step/images/blue_gray.png");
		$("#step2").removeClass("active in");
		$("#step1").addClass("active in");
		$(".cancel").css("display", "block");
		$("#NextSubmit").css("display", "none");
		$("#NextSubmit2").css("display", "block");
	},
	/**
	 * 完成输入
	 */
	complete : function() {
		fileflag = 0;
		// 所有文件信息
		var fileinfo = document.getElementsByName("tablefiles");
		var filename =document.getElementsByName("filenameInfo")
		// 文件信息的标记Must是否必选
		var FileMust = document.getElementsByName("FileMust");
		for (var i = 0; i < FileMust.length; i++) {
			if (FileMust[i].value == "必须") {
				if (filename[i].value == "") {
					fileflag = 1;
				}
			}
		}

		if (fileflag == 1) {
			$("#FilePromet").css("display", "block");
		} else {
			for (var j = 0; j < fileinfo.length; j++) {
				if (fileinfo[j].value != "") {
					FileUpload(j);
				}
			}
			$("#HangModal").modal("hide");
			/*
			 * 延迟加载等待文件上传完成
			 */
			if (setTimeout(Filereturndata == "success", 100)) {
				alert("上传成功");
			} else {
				alert("上传失败");
			}
		}
	},
	/**
	 * Modal提交按钮用户开启流程
	 */
	SubmitInfo:function(){
		var param={
				"applyid":ApplyId,
				"userid":Number(userid),
				"unitid":Number(unitid),
			};
		$.ajax({
			type:"post",
			url:"HangLine/SubmitApply.spring",
			data:JSON.stringify(param),
			datatype:"json",
			contentType : 'application/json',
			success:function(){},	
		});
	}
};
/**
 * 文件上传信息
 * 
 * @param IdInfo(用于查找dictypeid)
 */
function FileUpload(IdInfo) {
	var dictypeid = $('.doctypeid' + IdInfo).val();
	$.ajaxFileUpload({
		url : 'ApplyFile/UploadFile.spring',
		type : "post",
		secureuri : false,
		data : {
			"applyid" : ApplyId,
			"doctime" : NowDate(),
			"doctype" : dictypeid,
		},
		fileElementId : "tablefiles" + dictypeid,
		dataType : 'JSON',
		success : function(data) {
			Filereturndata = data;
		},
	});
}
/**
 * 需要上传的文件表格
 */
function DocTypeTable() {
	$('.DocTypeTable')
			.bootstrapTable(
					{
						url : 'HangLine/SelectDoctype.spring',
						method : 'post',
						cache : false,
						striped : true,
						pagination : true,
						pageSize : 10,
						pageNumber : 1,
						pageList : [ 10, 20, 40 ],
						sidePagination : 'client',
						queryParams : function(params) {
							var temp = {
								"Applytype" : "申请状态"
							};
							return temp;
						},
						clickToSelect : true,
						paginationPreText : "上一页",
						paginationNextText : "下一页",
						contentType : "application/x-www-form-urlencoded; charset=UTF-8",
						columns : [
								{
									title : "序号",
									align : "center",
									valign : "middle",
									formatter : function(value, row, index) {
										return index + 1;
									}
								},
								{
									field : "docname",
									title : "类型名称",
									align : "center",
									valign : "middle",
								},
								{
									field : "must",
									title : "是否必须",
									align : "center",
									valign : "middle",
									formatter : function(value, row, index) {
										var change = "";
										if (value == "必须") {
											change = '<span style="color:#ff4242;font-weight:700">'
													+ value + '</span>';
										} else
											change = '<span style="font-weight:700">'
													+ value + '</span>';
										return change;
									}
								}, {
									title : "操作",
									align : "center",
									valign : "middle",
									formatter : operateFormatter1
								} ],
						onPageChange : function(size, number) {
						},
						formatNoMatches : function() {
							return '没有找到信息';
						}
					});
	$(window).resize(function() {
		$('.DocTypeTable').bootstrapTable('resetView');
	});
}
// 自定义按钮
function operateFormatter1(value, row, index) {
	var param = "tablefiles" + row.doctypeid;
	return [
			"<label for=" + param + ">选择文件</label><input type='text' class="
					+ param +  " name='filenameInfo'/><input type='file'  style='display:none' id="
					+ param + " name='tablefiles' onchange='FileValChange("
					+ row.doctypeid + ")'/>"
					+ "<input type='text' name='FileMust' value=" + row.must
					+ " style='display:none'/>",
			"<input type='text' class='doctypeid" + index + "' value="
					+ row.doctypeid + " style='display:none'/>" ].join('');
}
/**
 * 选择文件时触发
 * 
 * @param fileid
 */
function FileValChange(fileid) {
	var filename = "tablefiles" + fileid;
	var file = $("#" + filename).val();
	var fileName = getFileName(file);
	$("." + filename).val(fileName);
}
/*
 * 划分文件名
 */
function getFileName(o) {
	var pos = o.lastIndexOf("\\");
	return o.substring(pos + 1);
}
/**
 * 所有的输入信息
 * 
 * @returns {输入信息对象}
 */
function InsertFormInfo() {
	var ApplyInfo = $("#ApplyForm").serializeArray();
	var userid = $(".userinfo span").text();
	var unitid = $(".userinfo #p3").text();
	var ApplyData = {};
	$.each(ApplyInfo, function(i, info) {
		switch (info.name) {
		case ("ApplyPeople"):
			ApplyData["userid"] = userid;
			break;
		case ("ApplyNumber"):
			ApplyData["num"] = info.value;
			break;
		case ("ApplyUnit"):
			ApplyData["unitid"] = unitid;
			break;
		case ("ApplyContact"):
			ApplyData["contactperson"] = info.value;
			break;
		case ("ApplyPhone"):
			ApplyData["contactphone"] = info.value;
			break;
		case ("ApplyTime"):
			ApplyData["applystringtime"] = info.value;
			break;
		case ("ApplyMemo"):
			ApplyData["description"] = info.value;
			break;
		}
		;
	})
	// select信息添加
	ApplyData["buildtype"] = $("#ApplyBuildType").val();
	ApplyData["status"] = ApplyStatus;
	ApplyData["applyid"] = ApplyId;
	return ApplyData;
}
// bootstrap表单验证
function modalApply() {
	form.bootstrapValidator({
		message : '输入值不合法',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			ApplyContact : {
				message : '用户名不合法',
				validators : {
					notEmpty : {
						message : '联系人不能为空'
					},
					stringLength : {
						min : 3,
						max : 10,
						message : '请输入3到10个字符'
					},
					regexp : {
						regexp : /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
						message : '用户名只能由字母、数字、点、下划线和汉字组成 '
					}
				}
			},
			ApplyPhone : {
				validators : {
					notEmpty : {
						message : '联系电话不能为空'
					},
					stringLength : {
						min : 5,
						max : 11,
						message : '请输入5到11个数字'
					},
					regexp : {
						regexp : /^[0-9]*$/,
						message : '请输入正确电话'
					}
				}
			},
			ApplyMemo : {
				validators : {
					notEmpty : {
						message : '申请描述不能为空'
					},
					stringLength : {
						min : 3,
						max : 60,
						message : '请输入3到60个字符'
					}
				}
			}
		}
	});
}
/**
 * 删除申请信息
 * 
 * @param applyid
 */
function DelApplyInfoFunc(applyid) {
	alert(applyid);
}
// 添加信息modal隐藏时
$('#HangModal').on('hidden.bs.modal', function() {
	$("#ApplyForm").data('bootstrapValidator').destroy();
	$('#ApplyForm').data('bootstrapValidator', null);
	$("#ApplyForm input").val("");
	$("#ApplyForm textarea").val("");
	$("#ApplyForm textarea").val("");
	$("input[name='tablefiles']").val("");
	$("input[name='filenameInfo']").val("");
	$("#step" + 2 + "Li").removeClass("active blue").addClass("gray");
	$("#step" + 1 + "Li").addClass("active");
	$("#step" + 2 + "Img").attr("src", "./step/images/blue_gray.png");
	$("#step2").removeClass("active in");
	$("#step1").addClass("active in");
	$(".cancel").css("display", "block");
	$("#NextSubmit").css("display", "block");
	$("#NextSubmit2").css("display", "none");
	
});
// 时间选择器
function TodayTime() {
	var today = new Date();
	$(".timevalue").val(getBeforeDate(7));
	$(".finishtime").val(getBeforeDate(0));
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