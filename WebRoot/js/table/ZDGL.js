$(function(){
	typeInit({"typename":""});
});
function typeInit(serarchInfo){
	$('#TypeTable').bootstrapTable("destroy");
	$('#TypeTable').bootstrapTable({
		url : 'ZDGL/selectAllType.spring',
		method : 'post',
		cache : false,
		striped : true,
		pagination : true,
		pageSize : 2,
		pageNumber : 1,
		pageList : [ 10, 20, 40 ],
		sidePagination : 'server',
		queryParamsType:'',
		queryParams : function queryParams(params) {  
            var param = {  
                    pageNumber: params.pageNumber,    
                    pageSize: params.pageSize
                }; 
                for(var key in serarchInfo){
                    param[key]=serarchInfo[key]
                }  
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
		$('#TypeTable').bootstrapTable('resetView');
	});
}
$("#searchBtn").click(function(){
	var searchInfo={
			"typename":$("input[name='searchname']").val(),
	}
	
	typeInit(searchInfo);
	alert(1);
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
		alert(1);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		alert(2);
	},
};
// table角色搜索的参数设置
function queryParams(params) {
	var temp = {
		pageNumber: params.pageNumber,    
        pageSize: params.pageSize,
	};
	alert(params.offset);
	return temp;
}