$(function(){
	//所有用户信息
	$(function () {
		$('#reportTable').bootstrapTable({
			url:'SXDG/page.spring',
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
				field : "index",
				title : "序号",
				align : "center",
				valign : "middle",
			},
			{
				field : "name",
				title : "姓名",
				align : "center",
				valign : "middle",
			}, {
				field : "unit",
				title : "单位",
				align : "center",
				valign : "middle",
			}, {
				field : "phone",
				title : "电话",
				align : "center",
				valign : "middle",
			}, {
				field : "status",
				title : "状态",
				align : "center",
				valign : "middle",
			},{
				field : "type",
				title : "类型",
				align : "center",
				valign : "middle",
			}, {
				field : "memo",
				title : "备注",
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
             '<button type="button" class="RoleOfC btn btn-default  btn-sm" style="margin-right:15px;">角色</button>',
         ].join('');
     }
	//表格操作的按钮事件
     window.operateEvents = {
          'click .RoleOfA': function (e, value, row, index) {
        	  //弹出框
        	  $("#mymodal").modal("toggle"); 
        	  $(".updatename").val(row.name);
        	  $(".updatephone").val(row.phone);
          },
          'click .RoleOfB': function (e, value, row, index) {
        	  DelUser(row.userid);           
          },
          'click .RoleOfC': function (e, value, row, index) {
        	  $("#JSModel").modal("toggle"); 
        	  SelectRole(row.userid);
      }
     }
})
	//table搜索的参数设置
	function queryParams(params)
	{
		var username=$(".username").val();
		var unit=$("#unitselect .unit").val();
		var status=$("#status").val();
		var temp={
		 "username":username,
		 "unit":unit,
		 "status":status};
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
	//获取所有角色信息
	function SelectRole(userid)
	{
		//要多次请求只能通过destory这个表格
		$(".JSinfo").bootstrapTable('destroy'); 
		$('.JSinfo').bootstrapTable({
			url:'role/selectrole.spring',
			method: 'post',
			cache: false,
			striped: true,
			queryParams:queryRole(userid),
			clickToSelect: true,
        	contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			columns: [
			{
				//设置角色是否选中
				checkbox:true,
				field:"check",
				align : "center",
				valign : "middle",
				formatter:function(value, row, index){
					if(value==true)
						{
						return {
					            checked : true//设置选中
							   };
						}
				}
			},
			{
				field : "rolename",
				title : "角色名称",
				align : "center",
				valign : "middle",
			}, {
				field : "rolememo",
				title : "角色描述",
				align : "center",
				valign : "middle"
			},{
				field:"roleid",
				title:"roleid",
				align : "center",
				valign : "middle",
			}],
			onCheck:function(row){
				var flag=1;
				JScheck(row.roleid,row.rolename,flag,row.userid);
			},
			onUncheck:function(row)
			{
				var flag=0;
				JScheck(row.roleid,row.rolename,flag,row.userid);
			},
			onPageChange : function(size, number) {
			},
			formatNoMatches : function() {
				return '没有找到信息';
			}
		});
		//不知道为什么roleid colum只能放在后面如果放在前面1位置会乱2产生莫名的object
		$('.JSinfo').bootstrapTable('hideColumn', "roleid");
	}
	//查找角色参数
	function queryRole(params)
	{
		var temp={
		 "userid":params};
		return temp;
	}
	//用户角色设置方法
	function JScheck(roleid,rolename,flag,userid){
		$.ajax({
			type : "Post",
			url : "role/modifyrole.spring",
			data :{
				"roleid":roleid,
				"flag":flag,
				"userid":userid,
			},
			dataType : 'json',
			error : function(data) {
				alert("角色修改失败！！:");
			},
			success:function(data){
				alert("角色修改成功");
			}
		});
	}