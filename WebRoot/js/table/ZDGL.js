$(function(){
	typeInit({"typename":""});
	ItemInit(0);
});
//分页偏移量参数
var fset=0;
//左边字典类型表格
function typeInit(serarchInfo){
	$('#TypeTable').bootstrapTable("destroy");
	$('#TypeTable').bootstrapTable({
		url : 'ZDGL/selectAllType.spring',
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
			ItemInit(row.dictypeid);
			$($element).parent().siblings().children().css("background-color","inherit");
			//设置本节点和兄弟节点颜色
			$($element).css("background-color","#cdd3dc").siblings().css("background-color","#cdd3dc");
		},
		
	});
	$(window).resize(function() {
		$('#TypeTable').bootstrapTable('resetView');
	});
}
$("#searchBtn").click(function(){
	var searchInfo={
			"typename":$("input[name='searchname']").val(),
	};
	typeInit(searchInfo);
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
		DelTypeInfo(row.dictypeid);
		$('#TypeTable').bootstrapTable("refresh");
	},
};
// table字典类型搜索的参数设置
function queryParams(params) {
	var temp = {
		pageNumber: params.pageNumber,    
        pageSize: params.pageSize,
	};
	return temp;
}
function DelTypeInfo(dictypeid){
	$.ajax({
		url:"ZDGL/DelDictype.spring",
		method:"post",
		data:{
			"dictypeid":dictypeid
		},
		datatype:"json",
		error:function(data){},
		success:function(data){}
	});
}
//左边添加字典类型
var form = $('#updateform');
//bootstrap表单验证	
function modalZDtype() {

    form.bootstrapValidator({
        message: '输入值不合法',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            ZDtypename: {
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
            },ZDmemo: {
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
      //添加信息请求
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
		});
    }
});
$(".addbtn").click(function(){
	$("#TypeModal").modal("show");
	modalZDtype(); 
})
$('#TypeModal').on('hidden.bs.modal', function() {
    $("#updateform").data('bootstrapValidator').destroy();
    $('#updateform').data('bootstrapValidator', null);
    $("#updateform input").val("");
    $("#updateform textarea").val("");
});


//右边字典类型详细情况表
function ItemInit(dictypeid){
	$('#ItemTable').bootstrapTable("destroy");
	$('#ItemTable').bootstrapTable({
		url : 'ZDGL/SelectItemByTypeId.spring',
		method : 'post',
		cache : false,
		striped : true,
		pagination : true,
		pageSize : 10,
		pageNumber : 1,
		pageList : [ 10, 20, 40 ],
		sidePagination:"client",
		queryParams : function queryParams(params) {  
            var param = {  
                    pageSize: params.limit,    
                    offset: params.offset,
                    "dictypeid":dictypeid,
                }; 
                return param;                   
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
				return index + 1;
			}
		}, {
			field : "item",
			title : "项目名字",
			align : "center",
			valign : "middle",
		}/*, {
			field : "dicmemo",
			title : "字典描述",
			align : "center",
			valign : "middle",
		},*/, {
			title : "操作",
			align : "center",
			valign : "middle",
			events : operateEventsItem,
			formatter : operateFormatterItem
		} ],
		onPageChange : function(size, number) {
		},
		formatNoMatches : function() {
			return '没有找到信息';
		},
		onClickCell : function(field, value, row, $element) {
			//点击加载某角色的功能
			//td父节点的兄弟节点的子节点颜色
			$($element).parent().siblings().children().css("background-color","inherit");
			//设置本节点和兄弟节点颜色
			$($element).css("background-color","#cdd3dc").siblings().css("background-color","#cdd3dc");
		},
		
	});
	$(window).resize(function() {
		$('#ItemTable').bootstrapTable('resetView');
	});
}
function operateFormatterItem(value, row, index) {
	return [
			'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">删除</button>', ]
			.join('');
}
// 表格操作的按钮事件
window.operateEventsItem = {
	'click .RoleOfA' : function(e, value, row, index) {
		alert(1);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		DelItem(row.dicitemid);
	},
};

//表单
var item = $('#ItemForm');

/*
 * 表单验证
 */
function modalZDItem() {
  item.bootstrapValidator({
      message: '输入值不合法',
      feedbackIcons: {
          valid: 'glyphicon glyphicon-ok',
          invalid: 'glyphicon glyphicon-remove',
          validating: 'glyphicon glyphicon-refresh'
      },
      fields: {
          ZDItemname: {
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
          },
          ZDItemCode: {
              message: '编号只能为数字',
              validators: {
                  notEmpty: {
                      message: '不能为空'
                  },
                  stringLength: {
                      min: 2,
                      max: 10,
                      message: '请输入2到10数字'
                  },
                  regexp: {
                      regexp: /^[1-9]\d*|0$/,
                      message: '请输入数字 '
                  }
              }
          },ZDItemmemo: {
              validators: {
                  notEmpty: {
                      message: '描述不能为空'
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
//所有类型信息
function ALLType(){
	var typeinfo=$("#ZDtypeInfo");
	$.ajax({
		type : "POST",
		url : "ZDGL/selectAllTypeNoParam.spring",
		data :{},
		dataType : 'json',
		error : function(data) {
			alert("出错了！！:");
		},
		success:function(data){
			for(var i=0;i<data.length;i++)
				{
					if(i==0)
					{
						typeinfo.append("<option class='select' value='"+data[i].dictypeid+"'>"+data[i].dicname+"</option>");
					}
					else
						typeinfo.append("<option  value='"+data[i].dictypeid+"'>"+data[i].dicname+"</option>");;	
				}
			//alert(typeinfo.val());
		}
  	});
}
//添加项目
$("#ItemSubmit").click(function(){
  var bv = item.data('bootstrapValidator');
  bv.validate();
  if (bv.isValid()) {
      console.log(item.serialize());
    //添加项目请求
      var itemname=$("#ZDItemname").val();
      var typeid=$("#ZDtypeInfo").val();
      var itemmemo=$("#ZDItemmemo").val();
      var itemcode=$("#ZDItemCode").val();
      $.ajax({
			type : "Post",
			url : "ZDGL/InsertDicItem.spring",
			data :{
				"itemname":itemname,
				"itemmemo":itemmemo,
				"typeid":typeid,
				"itemcode":itemcode,
			},
			dataType : 'json',
			error : function(data) {
				alert("角色修改失败！！:");
			},
			success:function(data){
				$("#ItemModal").modal("hide");
				alert("角色修改成功");
			}
		});
  }
});
$(".addItem").click(function(){
	$("#ItemModal").modal("show");
	//加载表单
	modalZDItem(); 
	//发送字典类型查找请求
	ALLType();
})
$('#ItemModal').on('hidden.bs.modal', function() {
  $("#ItemForm").data('bootstrapValidator').destroy();
  $('#ItemForm').data('bootstrapValidator', null);
  $("#ItemForm input").val("");
  $("#ItemForm textarea").val("");
});
//删除项目
function DelItem(itemid){
	
}