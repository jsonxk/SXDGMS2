/*
 * 单位管理
 */
//偏移量用于分页查找是列序号
var fset=0;
$(function(){
	UnitInfoInit({"unitname":"","unitstatus":$("#unitstatus").val()});
	DicStatus("单位状态");
	DicItemInfo("单位类别");
})
//单位表格信息
function UnitInfoInit(serarchInfo){
	//alert(1);
	$('#unittable').bootstrapTable("destroy");
	$('#unittable').bootstrapTable({
		url : 'Unit/selectAllUnit.spring',
		method : 'post',
		cache : false,
		striped : true,
		pagination : true,
		pageSize : 10,
		pageNumber : 1,
		dataField:"rows",
		pageList : [ 10, 20, 40 ],
		sidePagination:"server",
		queryParams : function queryParams(params) {  
            var param = {  
                    pageSize: params.limit,    
                    offset: params.offset,
                }; 
                for(var key in serarchInfo){
                    param[key]=serarchInfo[key]
                } 
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
			field : "unitname",
			title : "单位名字",
			align : "center",
			valign : "middle",
		}, {
			field : "unitaddress",
			title : "单位地址",
			align : "center",
			valign : "middle",
		}, {
			field : "MSpeople",
			title : "主管人",
			align : "center",
			valign : "middle",
		}, {
			field : "MSphone",
			title : "主管电话",
			align : "center",
			valign : "middle",
		}, {
			field : "dicitem",
			title : "所属类型",
			align : "center",
			valign : "middle",
		}, {
			field : "unitmemo",
			title : "单位描述",
			align : "center",
			valign : "middle",
		}, {
			field : "status",
			title : "状态",
			align : "center",
			valign : "middle",
			formatter:function(value,row,index){
				var change="";
				if(value=="正常")
					{
						change= '<span style="color:#18fc24;font-weight:700">'+value+'</span>';
					}
				else if(value=="已删除")
					{
						change= '<span style="color:#ff4242;font-weight:700">'+value+'</span>';
					}
				else if(value=="")
					{
						change= '<span>'+value+'</span>';
					}
				return change;
			},
		},{
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
			//td父节点的兄弟节点的子节点颜色
			$($element).parent().siblings().children().css("background-color","inherit");
			//设置本节点和兄弟节点颜色
			$($element).css("background-color","#cdd3dc").siblings().css("background-color","#cdd3dc");
		},
		
	});
	$(window).resize(function() {
		$('#unittable').bootstrapTable('resetView');
	});
}
//查找单位信息
$("#Unitbtn").click(function(){
	var searchInfo={
			"unitname":$("input[name='searchname']").val(),
			"unitstatus":$("#unitstatus").val(),
	};
	UnitInfoInit(searchInfo);
});
function operateFormatter(value, row, index) {
	return [
			'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">删除</button>', ]
			.join('');
}
var unitid;
// 表格操作的按钮事件
window.operateEvents = {
	'click .RoleOfA' : function(e, value, row, index) {
		//点击修改信息
		$("#UnitModifyModal").modal("show");
		$(".Unitmodifyname").val(row.unitname);
		$(".UnitAddress").val(row.unitaddress);
		$(".people").val(row.MSpeople);
		$(".phone").val(row.MSphone);
		$(".Umemo").val(row.unitmemo);
		unitid=row.unitid;
	},
	'click .RoleOfB' : function(e, value, row, index) {
		//删除信息
		DelUnit(row.unitid);
	},
};

//点击添加单位
$(".addUnit").click(function(){
	$("#UnitModal").modal("show");
	modalUnitAdd();
});
//删除单位
function DelUnit(unitid){
	 $.ajax({
			type : "Post",
			url : "Unit/DelUnit.spring",
			data :{
				"unitid":unitid
			},
			dataType : 'json',
			error : function(data) {
				alert("角色添加失败！！:");
			},
			success:function(data){
				if(data)
					{
						$('#unittable').bootstrapTable('refresh');
					}
			}
		});
}
//modal隐藏触发
$('#UnitModal').on('hidden.bs.modal', function() {
    $("#unitform").data('bootstrapValidator').destroy();
    $('#unitform').data('bootstrapValidator', null);
    $("#unitform input").val("");
    $("#unitform textarea").val("");
});
$('#UnitModifyModal').on('hidden.bs.modal', function() {
    $("#unitModifyform input").val("");
    $("#unitModifyform textarea").val("");
});
//添加表单验证
var unitform = $('#unitform');
//bootstrap表单验证	
function modalUnitAdd() {
  unitform.bootstrapValidator({
      message: '输入值不合法',
      feedbackIcons: {
          valid: 'glyphicon glyphicon-ok',
          invalid: 'glyphicon glyphicon-remove',
          validating: 'glyphicon glyphicon-refresh'
      },
      fields: {
    	  Uname: {
              message: '用户名不合法',
              validators: {
                  notEmpty: {
                      message: '不能为空'
                  },
                  stringLength: {
                      min: 2,
                      max: 10,
                      message: '请输入2到10个字符'
                  },
                  regexp: {
                      regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                      message: '用户名只能由字母、数字、点、下划线和汉字组成 '
                  }
              }
          },UAddress: {
              validators: {
                  notEmpty: {
                      message: '地址不能为空'
                  }, stringLength: {
                      min: 3,
                      max: 60,
                      message: '请输入3到60个字符'
                  }
              }
          },MSpeople: {
              validators: {
                  notEmpty: {
                      message: '主管人不能为空'
                  }, stringLength: {
                      min: 2,
                      max: 10,
                      message: '请输入2到10个字符'
                  }
              }
          },MSphone: {
              validators: {
                  stringLength: {
                      min: 6,
                      max: 11,
                      message: '请输入6到11个字符'
                  },regexp: {
                      regexp: /(010\d{8})|(0[2-9]\d{9})|(13\d{9})|(14[57]\d{8})|(15[0-35-9]\d{8})|(18[0-35-9]\d{8})|(17[0-35-9]\d{8})/,
                      message: '输入正确电话号码'
                  }
              }
          },Umemo: {
              validators: {
                  notEmpty: {
                      message: '地址不能为空'
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
//提交添加信息
$("#submitBtn").click(function () {
	var form=$("#unitform");
	var uname=$('input[name=Uname]').val();
	var uaddress=$('input[name=UAddress]').val();
	var MSpeople=$('input[name=MSpeople]').val();
	var MSphone=$('input[name=MSphone]').val();
	var uType=$('.unittype').val();
	var Umemo=$('#Umemo').val();
	//var dataarray=$("#unitform").serializeArray();
	/*for(var i=0;i<dataarray.length;i++)
		{
			var paramname=dataarray[i].name;
			var value=dataarray[i].value;
			array.push({paramname:value});
		}*/
	var dataarray=[];
	var array={"unitname":uname,"dicitemid":uType,"address":uaddress,"mspeople":MSpeople,"msphone":MSphone+"","memo":Umemo};
	dataarray.push(array);
	var bv = form.data('bootstrapValidator');
	bv.validate();
	if (bv.isValid()) {
      console.log(form.serialize());
    //添加单位信息请求
     $.ajax({
			type : "Post",
			url : "Unit/InsertUnit.spring",
			data :JSON.stringify(dataarray),
			dataType : 'json',
			contentType:'application/json',
			error : function(data) {
				alert("角色添加失败！！:");
			},
			success:function(data){
				$("#UnitModal").modal("hide");
				//刷新表格
				$('#unittable').bootstrapTable("refresh");
				alert("角色添加成功");
			}
		});
  }
});
/*
 * 查找单位类型
 */
function DicItemInfo(param){
	$.ajax({
		type:"post",
		url:"Unit/SelectUnitType.spring",
		data:{
			"unittype":param,
		},
		datatype:"json",
		error:function(data){},
		success:function(data){
			for(var i=0;i<data.length;i++)
			{
				//添加
				$(".unittype").append("<option value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
				//修改
				$(".ModifyUnit").append("<option value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
			}
		}
	});
}
/*
 * 查找单位状态
 */
function DicStatus(param){
	$.ajax({
		type:"post",
		url:"Unit/SelectUnitType.spring",
		data:{
			"unittype":param,
		},
		datatype:"json",
		error:function(data){},
		success:function(data){
			for(var i=0;i<data.length;i++)
			{
				if(i==0)
				{
					$(".unitstatus").append("<option class='select' value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
				}
				else
					$(".unitstatus").append("<option value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");	
			}
		}
	});
}
/*
 * 修改单位信息
 */
$("#ModifyBtn").click(function(){
	var unitname=$(".Unitmodifyname").val();
	var address=$(".UnitAddress").val();
	var people=$(".people").val();
	var phone=$(".phone").val();
	var memo=$(".Umemo").val();
	var modifyparam=[unitname,address,people,phone,memo,unitid];
	ModifyUnitInfo(modifyparam);
});
function ModifyUnitInfo(array){
	var dicitemid=$(".ModifyUnit").val();
	var status=$(".unitstatus").val();
	var dataarray=[{unitid:array[5],unitname:array[0],dicitemid:dicitemid,address:array[1],mspeople:array[2],msphone:array[3],memo:array[4],status:status}];
	$.ajax({
		type:"post",
		url:"Unit/ModifyUnit.spring",
		data:JSON.stringify(dataarray),
		datatype:"json",
		contentType:'application/json',
		error:function(data){},
		success:function(data){
			if(data)
				{
					$("#UnitModifyModal").modal("hide");
					alert("信息修改成功");
					$('#unittable').bootstrapTable("refresh");
				}
		}
	});
}