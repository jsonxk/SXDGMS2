$(function(){
	Paramtable();
	ParamType("参数类型");
});
//参数表格信息
function Paramtable(){
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
		queryParams :function queryParams(params) {
		        var param={
		        		"paramname":$("input[name='Paramname']").val(),
		        		"paramtype":$("#Paramstatus").val()
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
			field : "type",
			title : "参数类型",
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
window.operateEvents = {
	'click .RoleOfA' : function(e, value, row, index) {
		alert(1);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		alert(2);
	},
}
//查找参数信息
$("#Parambtn").click(function(){
	$('#paramtable').bootstrapTable("refresh");
});
//参数类型
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
					if(i==0)
					{
						$("#Paramstatus").append("<option  selected value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
					}
					else{
						$("#Paramstatus").append("<option  value='"+data[i].dicitemid+"'>"+data[i].item+"</option>");
					}
				}
		}
	});
}
$(".addParam").click(function(){
	$("#ParamModal").modal("show");
});
