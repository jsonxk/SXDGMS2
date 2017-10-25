$(function(){
	$(function () {
		$('#JSQXinfo').bootstrapTable({
			url:'role/selectAllrole.spring',
			method: 'post',
			cache: false,
			striped: true,
			pagination: true,
			pageSize: 10,
			pageNumber:1,
			pageList: [10, 20, 40],
			sidePagination:'client',
			queryParams: queryParams,
			clickToSelect: true,
			paginationPreText: "上一页",
        	paginationNextText: "下一页",
        	contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			columns: [
			{
				title : "序号",
				align : "center",
				valign : "middle",
				formatter:function(value,row,index)
				{
					return index+1;
				}
			},
			{
				field : "name",
				title : "单位名称",
				align : "center",
				valign : "middle",
			}, {
				field : "memo",
				title : "单位描述",
				align : "center",
				valign : "middle",
			},{
				title : "操作",
				align : "center",
				valign : "middle",
				events: operateEvents,
             	formatter: operateFormatter
			} ],
			onPageChange : function(size, number) {
			},
			formatNoMatches : function() {
				return '没有找到信息';
			}
		});
		$(window).resize(function() {
			$('#reportTable').bootstrapTable('resetView');
		});
	});
	//自定义按钮
	function operateFormatter(value, row, index) {
         return [
             '<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
             '<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">删除</button>',
         ].join('');
     }
	//表格操作的按钮事件
     window.operateEvents = {
          'click .RoleOfA': function (e, value, row, index) {
        	alert(1);
          },
          'click .RoleOfB': function (e, value, row, index) {
        	alert(2);          
          },
     }
})
	//table角色搜索的参数设置
	function queryParams(params)
	{
		var rolename=$(".Rolename").val();
		var temp={
		 "rolename":rolename,
		 };
		return temp;
	}
	//删除信息
	function DelUser(userid){
		$.ajax({
			type : "Post",
			url : "user/deluser.spring",
			data :{
				"userid":userid,
			},
			dataType : 'json',
			error : function(data) {
				alert("删除失败！！:");
			},
			success:function(data){
				alert("删除成功");
				 $('#reportTable').bootstrapTable('refresh');
			}
		});
	}