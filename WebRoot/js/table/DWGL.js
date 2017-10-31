/*
 * 单位管理
 */
$(function(){
	UnitInfoInit({"unitname":""});
})
//偏移量用于分页查找是列序号
var fset=0;
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
			field : "status",
			title : "状态",
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
			/*//点击加载某角色的功能
			//td父节点的兄弟节点的子节点颜色
			ItemInit(row.dictypeid);
			$($element).parent().siblings().children().css("background-color","inherit");
			//设置本节点和兄弟节点颜色
			$($element).css("background-color","#cdd3dc").siblings().css("background-color","#cdd3dc");*/
		},
		
	});
	$(window).resize(function() {
		$('#unittable').bootstrapTable('resetView');
	});
}
$("#searchBtn").click(function(){
	var searchInfo={
			"unitname":$("input[name='searchname']").val(),
	};
	UnitInfoInit(searchInfo);
});
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
		//DelTypeInfo(row.dictypeid);
		$('#unittable').bootstrapTable("refresh");
	},
};

//点击添加单位
$(".addUnit").click(function(){
	$("#UnitModal").modal("show");
	modalUnitAdd();
});
//modal隐藏触发
$('#UnitModal').on('hidden.bs.modal', function() {
    $("#unitform").data('bootstrapValidator').destroy();
    $('#unitform').data('bootstrapValidator', null);
    $("#unitform input").val("");
    $("#unitform textarea").val("");
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
                      min: 3,
                      max: 10,
                      message: '请输入3到10个字符'
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
                      message: '地址不能为空'
                  }, stringLength: {
                      min: 3,
                      max: 60,
                      message: '请输入3到60个字符'
                  }
              }
          },MSphone: {
              validators: {
                  notEmpty: {
                      message: '地址不能为空'
                  }, stringLength: {
                      min: 3,
                      max: 60,
                      message: '请输入3到60个字符'
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
$("#submitBtn").click(function () {
  var bv = form.data('bootstrapValidator');
  bv.validate();
  if (bv.isValid()) {
      console.log(form.serialize());
    /*//添加信息请求
      var typename=$("#ZDtypename").val();
      var memo=$("#ZDmemo").val();
      $.ajax({
			type : "Post",
			url : "ZDGL/InsertDictype.spring",
			data :{
				"typename":typename,
				"memo":memo,
			},
			dataType : 'json',
			error : function(data) {
				alert("角色修改失败！！:");
			},
			success:function(data){
				$("#TypeModal").modal("hide");
				alert("角色修改成功");
			}
		});*/
  }
});
