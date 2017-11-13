/*
 * 搭挂申请管理
 * */
var DGSQTableInit=function(){
	
}
DGSQTableInit.prototype={
		/**
		 * 初始化表格信息 
		 */
		DGInfoInit:function(){
			//alert("show");
			DGInit();
		},
		/**
		 * 状态初始化
		 */
		DGInfoStatus:function(typename){
			SelectStatus(typename);
		},
		/**
		 * 添加申请信息
		 */
		AddApplyInfo:function(){
			InsertApplyInfo();
		},
};
/**
 * 实例化表格对象
 */
var init=new DGSQTableInit();
//分页偏移量参数
var fset=0;
//添加申请信息表单验证
var form = $('#ApplyForm');
//提交申请状态的id
var ApplyId=0;
$(function(){
	TodayTime();
	init.DGInfoStatus("申请状态");
	init.DGInfoInit();
	init.DGInfoStatus("建设类型");
})
/**
 * 查找信息
 */
$("#Hangbtn").click(function(){
	init.DGInfoInit();
});
/**
 * 添加申请
 */
$(".addHang").click(function(){
	init.AddApplyInfo();
});
/**
 * 
 * @param 搜索参数(名称，类型， 申请日期，批准日期)
 */
function DGInit(serarchInfo){
	$('#hanglinetable').bootstrapTable("destroy");
	$('#hanglinetable').bootstrapTable({
		url : 'ZDGL/selectAllType.spring',
		method : 'post',
		cache : false,
		striped : true,
		pagination : true,
		pageSize : 10,
		pageNumber : 1,
		dataField:"rows",
		sidePagination:"server",
		queryParams : function queryParams(params) {  
            var param = {  
                    pageSize: params.limit,    
                    offset: params.offset,
                };
                //偏移量
                fset=params.offset;
                return param;                   
              },
        responseHandler:function responseHandler(result){
            //如果没有错误则返回数据，渲染表格
        	
        	return {
                total : result[0].total, //总页数,前面的key必须为"total"
                rows : result[0].rows //行数据，前面的key要与之前设置的dataField的值一致.
            };
        },
		clickToSelect : true,
		paginationPreText : "上一页",
		paginationNextText : "下一页",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		columns : [ {
			title : "序号",
			align : "center",
			valign : "middle",
			formatter : function(value, row, index) {
				return index + fset+1;
			}
		}, {
			field : "dicname",
			title : "字典名字",
			align : "center",
			valign : "middle",
		}, {
			field : "dicmemo",
			title : "字典描述",
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
			//点击加载某角色的功能
			//td父节点的兄弟节点的子节点颜色
			//ItemInit(row.dictypeid);
			//$($element).parent().siblings().children().css("background-color","inherit");
			//设置本节点和兄弟节点颜色
			//$($element).css("background-color","#cdd3dc").siblings().css("background-color","#cdd3dc");
		},
		
	});
	$(window).resize(function() {
		$('#hanglinetable').bootstrapTable('resetView');
	});
}
/**
 * 表格自定义操作
 * @param value
 * @param row
 * @param index
 * @returns
 */
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
	},
};
/**
 * 加载搭挂申请状态类型
 * @param typename(申请状态)
 */
function SelectStatus(typename){
	$.ajax({
		type:"post",
		url:"HangLine/selectHangStatus.spring",
		data:{
			typename:typename,
		},
		datatype:"json",
		success:function(data)
		{
			switch(typename)
			{
				case("申请状态"):
					$("#HangStatus").append("<option select value='all'> 全部分类</option>");
					for(var i=0;i<data.length;i++)
					{
						$("#HangStatus").append("<option value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
						if(data[i].item=="提交申请")
							{
								ApplyId=data[i].dicitemid;
							}
					}
					break;
				case("建设类型"):
					for(var i=0;i<data.length;i++)
					{
						$("#ApplyBuildType").append("<option value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
					}
					break;
			}
		}
	});
}
/**
 * 添加申请信息
 */
function InsertApplyInfo(){
	$("#HangModal").modal("show");
	modalApply();
	var applyname=$(".userinfo #p1").text();
	$("#ApplyPeople").val(applyname);
	$("#ApplyNumber").val(new Date().getTime());
	$("#ApplyUnit").val($(".userinfo #p2").text());
	$("#ApplyTime").val(NowDate());
}
/**
 * modal中step步骤条
 */
var eventFun = {
	setStep : function(index) {

	},
	next : function(index) {
		var ApplyInfo =$("#ApplyForm").serializeArray();
		var userid=$(".userinfo span").text();
		var unitid=$(".userinfo #p3").text();
		var ApplyData={};
		$.each(ApplyInfo,function(i,info){
			switch(info.name){
			case("ApplyPeople"):
				ApplyData["userid"]=userid;
				break;
			case("ApplyNumber"):
				ApplyData["num"]=info.value;
				break;
			case("ApplyUnit"):
				ApplyData["unitid"]=unitid;
				break;
			case("ApplyContact"):
				ApplyData["contactperson"]=info.value;
				break;
			case("ApplyPhone"):
				ApplyData["contactphone"]=info.value;
				break;
			case("ApplyTime"):
				ApplyData["applystringtime"]=info.value;
				break;
			case("ApplyMemo"):
				ApplyData["memo"]=info.value;
				break;
			};
		})
		//select信息添加
		ApplyData["buildtype"]=$("#ApplyBuildType").val();
		ApplyData["status"]=ApplyId;
		var bv = form.data('bootstrapValidator');
	    bv.validate();
	    if (bv.isValid()) {
	    	$("#step" + (index - 1) + "Li").removeClass("active");
			$("#step" + (index) + "Li").addClass("active blue")
					.removeClass("gray");
			$("#step" + index + "Img").attr("src",
					"./step/images/blue_blue.png");
			$("#step1").removeClass("active in");
			$("#step2").addClass("active in");
			/*
			 * 发送添加信息请求
			 */
			$.ajax({
				type:"post",
				url:"HangLine/InsertApplyInfo.spring",
				data:JSON.stringify(ApplyData),
				datatype:"json",
				contentType:'application/json',
				success:function(data){
					
				},
			});
	    }
	    else{
	    	alert("请根据提示完善信息");
	    }
	},
	pre : function(index) {
		$("#step" + (index + 1) + "Li").removeClass("active blue")
				.addClass("gray");
		$("#step" + (index) + "Li").addClass("active");
		$("#step" + (index + 1) + "Img").attr("src",
				"./step/images/blue_gray.png");
		$("#step2").removeClass("active in");
		$("#step1").addClass("active in");
	}
};
//bootstrap表单验证	
function modalApply() {
    form.bootstrapValidator({
        message: '输入值不合法',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	ApplyContact: {
                message: '用户名不合法',
                validators: {
                    notEmpty: {
                        message: '联系人不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 10,
                        message: '请输入3到10个字符'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                        message: '用户名只能由字母、数字、点、下划线和汉字组成 '
                    }
                }
            },ApplyPhone: {
                validators: {
                    notEmpty: {
                        message: '联系电话不能为空'
                    }, stringLength: {
                        min: 3,
                        max: 60,
                        message: '请输入3到60个字符'
                    }
                }
            },ApplyMemo: {
                validators: {
                    notEmpty: {
                        message: '申请描述不能为空'
                    }, stringLength: {
                        min: 3,
                        max: 60,
                        message: '请输入3到60个字符'
                    }
                }
            }
        }
    });
}
//modal隐藏时
$('#HangModal').on('hidden.bs.modal', function() {
    $("#ApplyForm").data('bootstrapValidator').destroy();
    $('#ApplyForm').data('bootstrapValidator', null);
    $("#ApplyForm input").val("");
    $("#ApplyForm textarea").val("");
});
//时间选择器
function TodayTime(){
		var today=new Date();
		$(".timevalue").val(getBeforeDate(7));
		$(".finishtime").val(getBeforeDate(0));
		$(".permittime").val(getBeforeDate(7));
		$(".permitfinish").val(getBeforeDate(0));
		var time1=$(".timevalue").val();
		var time2=$(".finishtime").val();
		var time3=$(".permittime").val();
		var time4=$(".permitfinish").val();
		if(time1>time2||time3>time4)
			{
				alert("开始时间不能大于结束时间!");
			}
	}
	function getBeforeDate(n) {
    var d = new Date();
    d.setDate(d.getDate() - n);
    var year = d.getFullYear();
    var mon = d.getMonth() + 1;
    var day = d.getDate();
    var s = year + "-" + (mon < 10 ? ('0' + mon) : mon) + "-" + (day < 10 ? ('0' + day) : day);
    return s;
}
	function NowDate(){
		 var d = new Date();
		 var year=d.getFullYear();
		 var mon = d.getMonth() + 1;
		 var day = d.getDate();
		 var Hour=d.getHours();
		 var minutes=d.getMinutes();
		 var second=d.getSeconds();
		 return year + "-" + (mon < 10 ? ('0' + mon) : mon) + "-" + (day < 10 ? ('0' + day) : day)+" "+Hour+":"+minutes+":"+second;
	}
	$('.form_date').datetimepicker({
    defaultDate:new Date(),
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: true,
	format: "yyyy-mm-dd",
});
$('.dateFinish').datetimepicker({
    defaultDate:new Date(),
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: true,
	format: "yyyy-mm-dd",
});