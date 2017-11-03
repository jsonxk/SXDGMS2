$(function(){
	Paramtable({paramname:"",paramtype:""});
	ParamType("参数类型");
});
//参数表格信息
function Paramtable(param){
	$('#paramtable').bootstrapTable("destroy");
	$('#paramtable').bootstrapTable({
		url : 'CSGL/selectAllParam.spring',
		method : 'post',
		cache : false,
		striped : true,
		pagination : true,
		pageSize : 10,
		pageNumber : 1,
		pageList : [ 10, 20, 40 ],
		sidePagination : 'client',
		/*queryParams :function queryParams(params) {
		        var param={
		        		"paramname":$("input[name='Paramname']").val(),
		        		"paramtype":$("#Paramstatus").val()
		        };
		        return param;  
		},*/
		queryParams:param,
		clickToSelect : true,
		paginationPreText : "上一页",
		paginationNextText : "下一页",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		columns : [ {
			title : "序号",
			align : "center",
			valign : "middle",
			formatter : function(value, row, index) {
				return index + 1;
			}
		}, {
			field : "name",
			title : "参数名称",
			align : "center",
			valign : "middle",
		}, {
			field : "value",
			title : "参数要求",
			align : "center",
			valign : "middle",
		}, {
			field : "typeinfo",
			title : "参数类型",
			align : "center",
			valign : "middle",
		}, {
			field : "memo",
			title : "参数描述",
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
		},
		
	});
	$(window).resize(function() {
		$('#paramtable').bootstrapTable('resetView');
	});
}
// 自定义按钮
function operateFormatter(value, row, index) {
	return [
			'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">删除</button>', ]
			.join('');
}
// 表格操作的按钮事件
var paramid=0;
window.operateEvents = {
	'click .RoleOfA' : function(e, value, row, index) {
		$("#ModifyParamModal").modal("show");
		$("#ModifyParamname").val(row.name);
		$("#ModifyParamValue").val(row.value);
		$("#ModifyParammemo").val(row.memo);
		//参数id
		paramid=row.sysparamid;
	},
	'click .RoleOfB' : function(e, value, row, index) {
		DelParam(row.sysparamid)
	},
}
//查找参数信息
$("#Parambtn").click(function(){
	/*$('#paramtable').bootstrapTable("refresh");*/
	var paramname=$("input[name='Paramname']").val();
	var paramtype=$("#Paramstatus").val();
	Paramtable({paramname:paramname,paramtype:paramtype});
});
$("#Returnbtn").click(function(){
	Paramtable({paramname:"",paramtype:""});
})
//参数类型（select option） 
function ParamType(param){
	$.ajax({
		type:"post",
		url:"Unit/SelectUnitType.spring",
		data:{
			unittype:param,
		},
		datatype:"json",
		error:function(){},
		success:function(data){
			for(var i=0;i<data.length;i++)
				{
					$("#Paramstatus").append("<option    value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
					$(".Paramstatus").append("<option    value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
					$(".ModifyParamstatus").append("<option    value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
				}
		}
	});
}
//添加参数
$(".addParam").click(function(){
	$("#ParamModal").modal("show");
	modalParamAdd();
});
//隐藏时清空modal数据
$('#ParamModal').on('hidden.bs.modal', function() {
    $("#Paramform").data('bootstrapValidator').destroy();
    $('#Paramform').data('bootstrapValidator', null);
    $("#Paramform input").val("");
    $("#Paramform textarea").val("");
});
//添加参数验证
var Paramform = $('#Paramform');
//modal表单验证	
function modalParamAdd() {
	Paramform.bootstrapValidator({
      message: '输入值不合法',
      feedbackIcons: {
          valid: 'glyphicon glyphicon-ok',
          invalid: 'glyphicon glyphicon-remove',
          validating: 'glyphicon glyphicon-refresh'
      },
      fields: {
    	  Paramname: {
              message: '用户名不合法',
              validators: {
                  notEmpty: {
                      message: '名称不能为空'
                  }
              }
          },ParamValue: {
              validators: {
                  notEmpty: {
                      message: '要求不能为空'
                  }
              }
          },Parammemo: {
              validators: {
                  notEmpty: {
                      message: '描述不能为空'
                  }
              }
          }
      }
  });
}
//提交时表单验证
$("#submitBtn").click(function(){
	var bv = Paramform.data('bootstrapValidator');
	bv.validate();
	if (bv.isValid()) {
		var paramdata=$("#Paramform").serializeArray();
		var statusdata=$(".Paramstatus").val();
		var arraydata=dataparamFunc(paramdata,statusdata)
      //发送请求
      $.ajax({
    	  type:"post",
    	  url:"CSGL/InsertParam.spring",
    	  data:JSON.stringify(arraydata),
    	  datatype:"json",
    	  contentType:'application/json',
    	  success:function(data){
    		  if(data)
    			  {
    			  	$("#ParamModal").modal("hide");
    			  	Paramtable({paramname:"",paramtype:""});
    			  }
    	  },
    	  error:function(data){},
      });
	};
});
/*
 *修改参数信息
 */
  $("#ModifyBtn").click(function(){
	  var paramdata=$("#ModifyParamform").serializeArray();
	  var status=$(".ModifyParamstatus").val();
	  var dataparam=dataparamFunc(paramdata,status);
	  $.ajax({
		  type:"post",
		  url:"CSGL/ModifyParam.spring",
		  data:JSON.stringify(dataparam),
		  datatype:"json",
		  contentType:'application/json',
		  success:function(data){
			  if(data)
				  {
				  	$("#ModifyParamModal").modal('hide');
				  	Paramtable({paramname:"",paramtype:""});
				  }
		  },
		  error:function(data){},
	  });
  });
  //请求表单参数
  function dataparamFunc(paramdata,status){
	  var param;
	  param={
			  sysparamid:paramid,
			  name:paramdata[0].value,
			  value:paramdata[1].value,
			  type:status,
			  memo:paramdata[2].value
	  }
	  return param;
  }
  //删除参数信息
  function DelParam(sysparamid){
	  $.ajax({
		  type:"post",
		  url:"CSGL/DelParam.spring",
		  data:{
			  sysparamid:parseInt(sysparamid)
		  },
		  datatype:"json",
		  success:function(data){
			  if(data)
				  {
				  	alert("删除成功")
				  	Paramtable({paramname:"",paramtype:""});
				  }
		  },
		  error:function(data){},
	  });
  }