$(function() {
	$('#JSQXinfo').bootstrapTable({
		url : 'role/selectAllrole.spring',
		method : 'post',
		cache : false,
		striped : true,
		pagination : true,
		pageSize : 10,
		pageNumber : 1,
		pageList : [ 10, 20, 40 ],
		sidePagination : 'server',
		/*
		 * 服务器端分页
		 * 返回json格式
		 * {total:number,row:jsonarray}
		 */
		queryParams : queryParams,
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
			title : "单位名称",
			align : "center",
			valign : "middle",
		}, {
			field : "memo",
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
			//点击加载某角色的功能
			FunctionTree(row.roleid);
			//td父节点的兄弟节点的子节点颜色
			$($element).parent().siblings().children().css("background-color","inherit");
			//设置本节点和兄弟节点颜色
			$($element).css("background-color","#cdd3dc").siblings().css("background-color","#cdd3dc");
		},
		
	});
	$(window).resize(function() {
		$('#reportTable').bootstrapTable('resetView');
	});
});
// 自定义按钮
function operateFormatter(value, row, index) {
	return [
			'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">删除</button>', ]
			.join('');
}
// 表格操作的按钮事件
window.operateEvents = {
	'click .RoleOfA' : function(e, value, row, index) {
		alert(1);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		alert(2);
	},
}
// table角色搜索的参数设置
function queryParams(params) {
	var rolename = $(".Rolename").val();
	var temp = {
		"rolename" : rolename,
	};
	return temp;
}
// 功能树
var roleid = 0;
/*
 * 初始化树
 */
FunctionTree(roleid);
function FunctionTree(roleid) {
	// 获取功能信息
	$.ajax({
		type : "post",
		url : "func/AllFunc.spring",
		data : {
			"roleid" : roleid,
		},
		datatype : "json",
		error : function(data) {
			alert("功能信息查询失败")
		},
		success : function(data) {
			treeview(data,roleid);
		},
	});
}
function treeview(treedata,roleid) {
	$('#treeview1').treeview(
			{
				data : treedata,
				showCheckbox : true,
				levels :2,
				onNodeChecked : function(event, data) {
					if(roleid==0)
						{
							alert("请选择角色");
							$('#treeview1').treeview('uncheckNode',
									[ data.nodeId, {
										silent : true
									} ]);
						}
					else{
						// 选中父节点
						if (data.nodes != null) {
							/*
							 * 父节点信息不为空，获取所有子节点信息 轮流发送信息 发送信息id roleid
							 */
							var arrayInfo = data.nodes;
							var par=null;
							for (var i = 0; i < arrayInfo.length; i++) {
								// $('#treeview1').treeview('checkNode', [
								// arrayInfo[i].nodeId, { silent: true } ]);
								//遍历选中子节点
								$('#treeview1').treeview('checkNode',
										[ arrayInfo[i].nodeId, {
											silent : true
										} ]);
								//发送添加功能请求
								modifyRoleFunction(roleid,arrayInfo[i].id,data.id,1);
							}
							/*if(arrayInfo!=null)
								{
									for (var i = 0; i < arrayInfo.length; i++)
										{
										//父节点
										
										}
								}*/
						}
						else{
							//子节点
							par=$('#treeview1').treeview('getParent', data);
							//发送添加功能请求
							modifyRoleFunction(roleid,data.id,par.id,1);
						}
					}
				},
				onNodeUnchecked : function(event, data) {
					// 取消选中父节点，则自动取消选择子节点
					if (data.nodes != null) {
						var arrayInfo = data.nodes;
						for (var i = 0; i < arrayInfo.length; i++) {
							// $('#treeview1').treeview('checkNode', [
							// arrayInfo[i].nodeId, { silent: true } ]);
							$('#treeview1').treeview('uncheckNode',
									[ arrayInfo[i].nodeId, {
										silent : true
									} ]);
							modifyRoleFunction(roleid,arrayInfo[i].id,data.id,0);
						}
					}
					else{
						//子节点
						par=$('#treeview1').treeview('getParent', data);
						modifyRoleFunction(roleid,data.id,par.id,0);
					}
				}
			});
	/*$('#treeview1').on('nodeChecked', function(event, data) {
		var par=null;
		var arrayInfo = data.nodes;
		if(arrayInfo!=null)
			{
				for (var i = 0; i < arrayInfo.length; i++)
					{
					//父节点
						modifyRoleFunction(roleid,data.id,arrayInfo[i].id,1);
					}
			}
		else{
			//子节点
			par=$('#treeview1').treeview('getParent', data);
			modifyRoleFunction(roleid,par.id,data.id,1);
			alert(par.text+data.text);
		}
	});
	$('#treeview1').on('nodeUnchecked', function(event, data) {
		//var par=$('#treeview1').treeview('getParent', data);
		var arrayInfo = data.nodes;
		if(arrayInfo!=null)
			{
				for (var i = 0; i < arrayInfo.length; i++)
					{
						modifyRoleFunction(roleid,data.id,arrayInfo[i].id,0);
					}
			}
		else{
			//子节点
			par=$('#treeview1').treeview('getParent', data);
			modifyRoleFunction(roleid,par.id,data.id,0);
		}
	});*/
}
//修改角色功能
/*
 * @param roleid 角色id
 * @param childid 子功能id
 * @param parentid 父功能id
 * @param flag 标记（添加还是删除功能） 
 */
function modifyRoleFunction(roleid,childid,parentid,flag){
	//alert(childid+"fg"+parentid+"dd"+flag);
	var rolefunc=new Array();
	rolefunc.push({"roleid":roleid,"functionid":childid,"parentid":parentid,"flag":flag});
	$.ajax({
		type:"post",
		url:"func/modifyFunc.spring",
		contentType:'application/json',
		data:JSON.stringify(rolefunc),
		datatype:"json",
		error:function(data){
			alert("修改失败");
		},
		success:function(data){
			if(data)
				{
					alert("修改信息成功");
				}
			else
				alert("修改失败");
		}
	});
}
//删除信息
function DelUser(userid) {
	$.ajax({
		type : "Post",
		url : "user/deluser.spring",
		data : {
			"userid" : userid,
		},
		dataType : 'json',
		error : function(data) {
			alert("删除失败！！:");
		},
		success : function(data) {
			alert("删除成功");
			$('#reportTable').bootstrapTable('refresh');
		}
	});
}
