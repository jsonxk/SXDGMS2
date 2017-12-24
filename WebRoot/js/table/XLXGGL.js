/**
 * 线路/线杆管理
 */
/**
 * 用户id，
 * 单位id
 * 用户
 * 单位名称
 */
var userid=$(".userinfo span").text();
var unitid=$(".userinfo #p3").text();
var loginname=$(".userinfo #p1").text();
var unitname=$(".userinfo #p2").text();
var countNum=0;
var LineId=0;
/**
 * 线路对象
 */
var LineInit = function() {
}
/**
 * 线杆对象
 */
var PoleInit = function() {
}
LineInit.prototype = {
	/**
	 * 线路信息初始化
	 */
	LineInfoInit : function() {
		lineinfoinit();
	},
	/**
	 * 加载单位
	 */
	LineUnitInfo:function(status){
		lineunitinfo(status);
	},
	/**
	 * 加载类型信息
	 */
	LineTypeInfo:function(typename){
		linetypeinfo(typename);
	},
	/**
	 * 添加线路信息
	 */
	LineInsertInfo:function(){
		lineInsertInfo();
	},
	/**
	 * 查询所有线路信息
	 * @param{0,1,2}
	 */
	SelectAllLineName:function(index){
		selectAllLineName(index);
	}
};
PoleInit.prototype = {
	/**
	 * 线杆信息初始化
	 * 
	 * @param lineId{线路id}
	 */
	PoleInfoInit : function(lineId) {
		poleinfoinit(lineId);
	},
	/**
	 * 添加线杆信息
	 */
	PoleInfoInsert:function(){
		poleInfoInsert();
	},
	/**
	 * 添加线路线杆明细
	 * @param index
	 * @param poleid
	 */
	PoleLineDetail:function(index,poleid){
		poleLineDetail(index,poleid);
	},
	/**
	 * 加载所有线杆信息
	 * @param{0,1,2}
	 */
	SelectAllPole:function(index){
		selectAllPole(index);
	}
}
// 线路实例化
var lineinit = new LineInit();
// 线杆初始化
var poleinit = new PoleInit();
//表格偏移量
var fset=0;
$(function() {
	lineinit.LineInfoInit();
	poleinit.PoleInfoInit(0);
	lineinit.LineUnitInfo("正常");
	lineinit.LineTypeInfo("线路类别");
	lineinit.LineTypeInfo("线路状态");
	lineinit.LineTypeInfo("线杆类别");
	lineinit.LineTypeInfo("线杆状态");
	poleinit.SelectAllPole(LineId);
	lineinit.SelectAllLineName(0);
});
/**
 * 查找线路按钮
 */
$("#lineSearchBtn").click(function(){
	lineinit.LineInfoInit();
})
/**
 * 加载线路信息
 */
function lineinfoinit() {
	$('#lineInfoTable').bootstrapTable("destroy");
	$('#lineInfoTable')
			.bootstrapTable(
					{
						url : 'LinePole/selectAllLine.spring',
						method : 'post',
						cache : false,
						striped : true,
						pagination : true,
						pageSize : 10,
						pageNumber : 1,
						dataField : "rows",
						pageList : [ 10, 20, 40 ],
						sidePagination : "server",
						queryParams : function queryParams(params) {
							var param = {
								pageSize : params.limit,
								offset : params.offset,
								"unitid":Number(unitid),
								"name":$(".lineName").val()+"",
							};
							/*for ( var key in serarchInfo) {
								param[key] = serarchInfo[key]
							}*/
							// 偏移量
							fset = params.offset;
							return param;
						},
						responseHandler : function responseHandler(result) {
							// 如果没有错误则返回数据，渲染表格

							return {
								total : result[0].total, // 总页数,前面的key必须为"total"
								rows : result[0].rows
							// 行数据，前面的key要与之前设置的dataField的值一致.
							};
						},
						clickToSelect : true,
						paginationPreText : "上一页",
						paginationNextText : "下一页",
						columns : [ {
							title : "序号",
							align : "center",
							valign : "middle",
							formatter : function(value, row, index) {
								return index + fset + 1;
							}
						}, {
							field : "name",
							title : "线路名称",
							align : "center",
							valign : "middle",
						},{
							field : "statusname",
							title : "线路状态",
							align : "center",
							valign : "middle",
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
							// 点击加载某角色的功能
							// td父节点的兄弟节点的子节点颜色
							LineId=row.lineid;
							poleinit.PoleInfoInit(row.lineid);
							$($element).parent().siblings().children().css(
									"background-color", "inherit");
							// 设置本节点和兄弟节点颜色
							$($element).css("background-color", "#cdd3dc")
									.siblings().css("background-color",
											"#cdd3dc");
						},

					});
	$(window).resize(function() {
		$('#lineInfoTable').bootstrapTable('refresh');
	});
}
function operateFormatter(value, row, index) {
	return [
			'<button type="button" class="LineDetail btn btn-default  btn-sm" style="margin-right:15px;">详情</button>',
			'<button type="button" class="ModifyLine btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="DelLineBtn btn btn-default  btn-sm" style="margin-right:15px;background-color:red;color:white">删除</button>']
			.join('');
}
// 表格操作的按钮事件
window.operateEvents = {
	'click .LineDetail' : function(e, value, row, index) {
		/**
		 * 查看线路细节
		 */
		console.log(row);
		$("#LineDetailModal").modal("show");
		$("#LineNameInput2").val(row.name);
		$("#LineLength2").val(row.linelength);
		$("#LineNumber2").val(row.lineNum);
		$("#LineUnit2").val(row.unitname);
		$("#LineType2").val(row.typename);
		$("#LineStatus2").val(row.statusname);
		$("#LineTime2").val(row.time);
		$("#LineCode2").val(row.code);
		$("#LineMemo2").text(row.memo);
	},
	'click .ModifyLine' : function(e, value, row, index) {
		/**
		 * 修改线路信息
		 */
		$("#ModifyLineInfo").modal("show");
		$("#Modifylinename").val(row.name);
		$("#Modifylinememo").text(row.memo);
		var select = document.getElementById("modifylineunit2");
		for (var i = 0; i < select.options.length; i++) {
			if (select.options[i].value == row.unitid) {
				select.options[i].selected = true;
			}
		}
		var ModifyBtn=document.getElementById("ModifylineOk");
		ModifyBtn.onclick=function(){
			$.ajax({
				type:"post",
				data:JSON.stringify({
					lineid:row.lineid,
					name:$("#Modifylinename").val(),
					unitid:$(".modifylineunit2").val(),
					status:$(".modifylinestatus2").val(),
					type:$(".modifylinetype2").val(),
				}),
				url:"LinePole/modifyLineInfo.spring",
				datatype:"json",
				contentType : 'application/json',
				success:function(data){
					$("#ModifyLineInfo").modal("hide");
					$("#TS_Modal").modal("show");
					if(data)
						{
							$(".TS_Modal h4").text("修改信息成功");
						}
					else{
						$(".TS_Modal h4").text("修改信息失败");
					}
				}
			});
		}
	},
	'click .DelLineBtn' : function(e, value, row, index) {
		/**
		 * 删除线路信息
		 */
		$("#DelRtnModal").modal("show");
		$("#DelThisLine").css('display',"inline");
		$("#DelThisPole").css('display',"none");
		var DelLineBtn=document.getElementById("DelThisLine");
		DelLineBtn.onclick=function(){
			$.ajax({
				type:"post",
				data:{
					lineid:row.lineid,
				},
				url:"LinePole/delLineInfo.spring",
				datatype:"json",
				success:function(data){
					$("#DelRtnModal").modal("hide");
					$("#TS_Modal").modal("show");
					if(data)
						{
							$(".TS_Modal h4").text("删除线路成功");
							$('#lineInfoTable').bootstrapTable("refresh");
						}
					else{
						$(".TS_Modal h4").text("删除线路失败");
					}
				}
			});
		}
	}
	
};
/**
 * 加载所有的线路基本信息
 */
function selectAllLineName(index){
	$.ajax({
		type : "post",
		url : "LinePole/selectAllLineName.spring",
		datatype : "json",
		success : function(data){
			for(var i=0;i<data.length;i++)
				{
					$(".thirdLayer"+index+" "+".PoleForLine").append("<option value='" + data[i].lineid + "'>"
							+ data[i].name + "</option>");
				}
		}
	});
}
/**
 * 加载线杆信息
 * @param lineid{线路id}
 */
function poleinfoinit(lineid){
	$('#poleInfoTable').bootstrapTable("destroy");
	if(lineid==0)
		{
		
		}
	else{
		$('#poleInfoTable').bootstrapTable({
			url:'LinePole/selectpoleinfo.spring',
			method: 'post',
			cache: false,
			striped: true,
			pagination: true,
			pageSize: 10,
			pageNumber:1,
			pageList: [10, 20, 40],
			sidePagination:'client',
			queryParams: function paramsfunc(){
				var param={
					"lineid":lineid,
				}
				return param;
			},
			clickToSelect: true,
			paginationPreText: "上一页",
	    	paginationNextText: "下一页",
	    	contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							columns : [{
								field : "linedetailList",
								title : "线杆名称",
								align : "center",
								valign : "middle",
								formatter:function(value, row, index)
								{
									if(value.length>0)
										{
											return value[0].name;
										}
								}
							}, {
								field : "statusname",
								title : "线杆状态",
								align : "center",
								valign : "middle",
							},{
								title : "操作",
								align : "center",
								valign : "middle",
								events : operateEventspole,
								formatter : operateFormatterpole
							} ],
							onPageChange : function(size, number) {
							},
							formatNoMatches : function() {
								return '请选择线路';
							},
							onClickCell : function(field, value, row, $element) {
								// 点击加载某角色的功能
								// td父节点的兄弟节点的子节点颜色
							},

						});
		$(window).resize(function() {
			$('#poleInfoTable').bootstrapTable('resetView');
		});
	}
}
function operateFormatterpole(value, row, index) {
	return [
'<button type="button" class="photoImgBtn btn btn-default  btn-sm" style="margin-right:15px;">照片</button>',
'<button type="button" class="PoleDetail btn btn-default  btn-sm" style="margin-right:15px;">详情</button>',
'<button type="button" class="PoleModify btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
'<button type="button" class="DelLineBtn btn btn-default  btn-sm" style="margin-right:15px;background-color:red;color:white">删除</button>', ]
			.join('');
}
// 表格操作的按钮事件
window.operateEventspole = {
	'click .PoleModify' : function(e, value, row, index) {
		/**
		 * 修改线杆信息
		 */
		$("#AddPoleModal").modal("show");
		$(".OkModifyPole").css("display","inline");
		$(".OkPole").css("display","none");
		$("#thirdLayer1").remove();
		$("#thirdLayer2").remove();
		$("#PoleTime").val(NowDate());
		$("#PoleLon").val(row.longtitude);
		$("#PoleLat").val(row.latitude);
		countNum=row.linedetailList.length-1;
		for(var i=0;i<row.linedetailList.length;i++)
			{
				
				if(i>=1)
					{
					$("#thirdLayer").append("<div class='thirdLayer"+i+"'>"
							+"<label for='PolePre' class='control-label'>前一杆</label>"
							+" <select class='PolePre'></select>"
							+" <label for='PoleForLine' class='control-label'>所属线路</label>    <select class='PoleForLine' id='PoleForLine"+countNum+"'>"
							+"	</select>"
							+" <label for='PoleCode' class='control-label'>编码</label><input"
							+"  type='text' class='PoleCode' name='PoleCode' value='"+row.linedetailList[i].code+"'/>"
							+"<input type='button' value='删除' class='delLinePole' onclick='deldiv(this)'/>"
						+"</div>");
					poleinit.SelectAllPole(i);
					lineinit.SelectAllLineName(i);
					}
				else{
					$(".thirdLayer0 .PoleCode").val(row.linedetailList[0].code);
				}
			}
	},
	'click .PoleDetail' : function(e, value, row, index) {
		/**
		 * 查看该线杆详情
		 */
		$.ajax({
			type:"post",
			data:{
				poleid:row.poleid
			},
			url:"LinePole/selectPoleInfoByPoleid.spring",
			datatype:"json",
			success:function(data)
			{	
				$("#PoleDetailModal").modal("show");
				for(var i=0;i<data.length;i++)
					{
						$("#PoleStatus2").val(data[i].statusname);
						$("#PoleTimeString2").val(data[i].timeString);
						$("#PoleUnit2").val(data[i].unitname);
						$("#PoleType2").val(data[i].typename);
						$("#PoleLon2").val(data[i].longtitude);
						$("#PoleLat2").val(data[i].latitude);
						if(data[i].linedetailList.length>0)
							{
								$("#thirdLayer2").text("");
								for(var j=0;j<data[i].linedetailList.length;j++)
									{
									$("#thirdLayer2").append("<div class='thirdLayer0'>"
											+"<label for='PolePre2' class='control-label'>前一杆</label>"
											+"<input type='text' class='PolePre2' name='PolePre2' value='"+data[i].linedetailList[j].prepolename+"'/>"
											+"<label for='PoleForLine2' class='control-label'>所属线路</label>"
											+"<input type='text' class='PoleForLine2' name='PoleForLine2' value='"+data[i].linedetailList[j].linename+"'/>"
											+"<label for='PoleCode2' class='control-label'>编码</label><input"
											+" type='text' class='PoleCode2' name='PoleCode2' value='"+data[i].linedetailList[j].code+"'/>"
											+"</div>");
									}
							}
					}
			}
		})
	},
	'click .DelLineBtn' : function(e, value, row, index) {
		/**
		 * 删除线杆
		 */
		$("#DelRtnModal").modal("show");
		$("#DelThisLine").css('display',"none");
		$("#DelThisPole").css('display',"inline");
		var delthispole=document.getElementById("DelThisPole");
		delthispole.onclick=function(){
			$.ajax({
				type:"post",
				data:{
					poleid:row.poleid
				},
				url:"LinePole/delPoleByPoleId.spring",
				datatype:"json",
				success:function(data)
				{	
					$("#DelRtnModal").modal("hide");
					$("#TS_Modal").modal("show");
					$(".TS_Modal h4").text(data[0].msg);
					poleinit.PoleInfoInit(LineId);
				}
			});
		}
	},
	'click .photoImgBtn' : function(e, value, row, index) {
		$("#CheckPhotoModal").modal("show");
		/**
		 * 线杆基础信息
		 */
		$("#Photopolename").val(row.linedetailList[0].name);
		$("#Photopoleunit").val(row.unitname);
		$("#Photopoletype").val(row.typename);
		$("#Photopolestatus").val(row.statusname);
		$("#Photopolememo").text(row.memo);
		/**
		 * 线杆照片信息
		 */
		$.ajax({
			type:"post",
			url:"LinePole/selectPolePhoto.spring",
			data:{
				poleid:row.poleid
			},
			datatype:"json",
			success:function(data)
			{
				$("#CheckPhoto ul").text("");
				if(data.length>0)
					{
					$("#PhotoTime").val(data[0].stringcreatetime);
						var ImgHeight=$("#CheckPhoto").height()
						for (var i = 0; i < data.length; i++) {
							$("#CheckPhoto ul").append("<li><img src='"+data[i].photopath+"'></li>");
						}
						var num=0;
						var prevImg=document.getElementById("prevImg");
						/**
						 * 上一张下一张照片
						 */
						prevImg.onclick=function(){
							if (num <=0) {
								alert("第一张");
								num=0;
							} else {
								//在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
								//console.log(num);
								num--;
								$('#CheckPhoto ul').animate({marginTop :-(num)*ImgHeight},500);
								$("#PhotoTime").val(data[num].stringcreatetime);
							}
						}
						var nextImg=document.getElementById("nextImg");
						nextImg.onclick=function(){
							num++;
							if (num >= data.length) {
								alert("最后一张");
								num=data.length-1;
							} else {
								//在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
								//console.log(num);
									$('#CheckPhoto ul').animate({marginTop : -num * ImgHeight},500);
									$("#PhotoTime").val(data[num].stringcreatetime);
							}
						}
					}
				else{
					$("#CheckPhoto ul").append("<li><img alt='没有相关图片'></li>");
				}
			}
		});
	},
};
/**
 * 单位信息初始化
 */
function lineunitinfo(status){
	$.ajax({
		type : "post",
		url : "SQXXGL/selectallunit.spring",
		data : {
			"status" : status,
		},
		datatype : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				/**
				 * 添加线路modal
				 */
				$("#LineUnit").append(
						"<option value='" + data[i].unitid + "'>"
								+ data[i].unitname + "</option>");
				/**
				 * 添加线杆modal
				 */
				$("#PoleUnit").append(
						"<option value='" + data[i].unitid + "'>"
								+ data[i].unitname + "</option>");
				/**
				 * 修改线路单位
				 */
				$(".modifylineunit2").append(
						"<option value='" + data[i].unitid + "'>"
								+ data[i].unitname + "</option>");
			}
		}
	});
}
/**
 * 线路类型信息
 * @param typename{线路类别,线路状态，线杆类别,线杆状态}
 */
function linetypeinfo(typename){
	$.ajax({
		type : "post",
		url : "HangLine/selectHangStatus.spring",
		data : {
			typename : typename,
		},
		datatype : "json",
		success : function(data) {
			switch (typename) {
			case ("线路类别"):
				for (var i = 0; i < data.length; i++) {
					$("#LineType").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					$(".modifylinetype2").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			case ("线路状态"):
				for (var i = 0; i < data.length; i++) {
					$("#LineStatus").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
					$(".modifylinestatus2").append("<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
				}
				break;
			case ("线杆类别"):
				for (var i = 0; i < data.length; i++) {
					$("#PoleType").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			case ("线杆状态"):
				for (var i = 0; i < data.length; i++) {
					$("#PoleStatus").append(
							"<option value='" + data[i].dicitemid + "'>"
									+ data[i].item + "</option>");
					/*
					 * if (data[i].item == "提交申请") { ApplyStatus =
					 * data[i].dicitemid; }
					 */
				}
				break;
			}
		}
	});
}
/**
 * 点击添加线路
 */
$(".addLine").click(function(){
	$("#AddLineModal").modal("show");
	$("#LineTime").val(NowDate());
	$("#LineCode").val(new Date().getTime());
})
/**
 * 点击添加线杆
 */
$(".addPole").click(function(){
	$("#AddPoleModal").modal("show");
	$(".OkModifyPole").css("display","none");
	$(".OkPole").css("display","inline");
	$("#PoleTime").val(NowDate());
	$(".thirdLayer1").remove();
	$(".thirdLayer2").remove();
})
/**
 * 添加线杆modal隐藏式
 */
$('#AddPoleModal').on('hidden.bs.modal', function() {
	countNum=0;
});
/**
 * 线路
 * 点击modal上完成按钮
 */
$("#LineOK").click(function(){
	lineinit.LineInsertInfo();
	console.log(InsertLineInfoArr());
})
/**
 *  添加线路信息
 */
function lineInsertInfo(){
	/*$.ajax({
		type : "post",
		url : "LinePole/insertLineInfo.spring",
		data : JSON.stringify(InsertLineInfoArr()),
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			$("#AddLineModal").modal("hide");
			lineinit.LineInfoInit();
		},
	});*/
	var linedataildata=new Array();
	linedataildata.push({code:"01",longtitude:$("#LineFirstPolelon").val(),latitude:$("#LineFirstPolelat").val(),name:$("#LineNameInput").val()+"#01"});
	linedataildata.push({code:"02",longtitude:$("#LineLastPolelon").val(),latitude:$("#LineLastPolelat").val(),name:$("#LineNameInput").val()+"#02"});
	$.ajax({
		type : "post",
		url : "LinePole/insertNewLineAndDetail.spring",
		data : JSON.stringify({
			/**
			 * 电力线路详情
			 */
			poleList:linedataildata,
			/**
			 * 电力线路信息
			 */
			code:$("#LineCode").val(),
			timeString:$("#LineTime").val(),
			linelength:$("#LineLength").val(),
			memo:$("#LineMemo").val(),
			status:$("#LineStatus").val(),
			type:$("#LineType").val(),
			name:$("#LineNameInput").val(),
			unitid:$("#LineUnit").val(),
			/**
			 * 线杆状态
			 */
			polestatus:18,
		}),
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			$("#AddLineModal").modal("show");
			if(data!=null&& data!="")
				{
					$(".TS_Modal h4").text("添加线路成功");
					$('#lineInfoTable').bootstrapTable("refresh");
				}
			else{
				$(".TS_Modal h4").text("添加线路失败");
			}
		}
	});
}
/**
 * 线杆
 * 点击modal上完成按钮
 */
$(".OkPole").click(function(){
	poleinit.PoleInfoInsert();
})
/**
 * 添加线杆信息
 */
function poleInfoInsert(){
	$.ajax({
		type : "post",
		url : "LinePole/insertPoleInfo.spring",
		data : JSON.stringify(PoleInfoObject()),
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			$("#AddPoleModal").modal("hide");
			//poleinit.PoleInfoInit(0);
			var childDiv=$('#thirdLayer div').length;
			if(data[0].poleid!=null&&data[0].poleid!="")
				{
					for(var i=0;i<childDiv;i++)
						{
							poleinit.PoleLineDetail(i,data[0].poleid);
						}
				}
			else{
				alert("添加线杆信息失败");
			}
		},
	});
}
/**
 * 添加线路线杆明细
 * @param poleid
 */
function poleLineDetail(index,poleid){
	$.ajax({
		type : "post",
		url : "LinePole/insertPoleLineDetail.spring",
		data : JSON.stringify(LinePoleDetailObject(index,poleid)),
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			if(data)
				{
					
				}
			else{
				alert("添加线路明细失败!");
			}
		},
	});
}
/**
 * 加载所有线杆信息
 * @param index{0,1,2}
 */
function selectAllPole(index){
	$.ajax({
		type : "post",
		url : "LinePole/selectAllPole.spring",
		datatype : "json",
		success : function(data){
			for(var i=0;i<data.length;i++)
				{
					if(data[i].linedetailList!=null)
						{
							var polename=data[i].linedetailList[0].name;	
							$(".thirdLayer"+index+" "+".PolePre").append("<option value='" + data[i].poleid +"'>"
										+ polename + "</option>");
						}
				}
		}
	});
}
/**
 * 线路线杆明细数据
 * @param index
 */
function LinePoleDetailObject(index,poleid){
	var dataDetail={};
	var prepoleinfo=$(".thirdLayer"+index+" "+".PolePre").val();
	var lineforPole=$(".thirdLayer"+index+" "+".PoleForLine").val();
	var code=$(".thirdLayer"+index+" "+".PoleCode").val();
	var code2=code<10?("0"+code):code;
	var unitselect = document.getElementById("PoleForLine"+index);
	var linename="";
	for (var i = 0; i < unitselect.options.length; i++) {
		if (unitselect.options[i].value == lineforPole) {
			unitselect.options[i].selected = true;
			linename=unitselect.options[i].text;
		}
	}
	dataDetail["lineid"]=Number(lineforPole);
	dataDetail["poleid"]=poleid;
	dataDetail["prepoleid"]=Number(prepoleinfo);
	dataDetail["code"]=code2;
	dataDetail["name"]=linename+"#"+code2;
	console.log(dataDetail);
	return dataDetail;
}
/**
 * 线杆具体信息
 */
function PoleInfoObject(){
	var poleinfo={};
	//poleinfo["name"]=$("#PoleNameInput").val();
	poleinfo["unitid"]=$("#PoleUnit").val();
	poleinfo["timeString"]=$("#PoleTime").val();
	poleinfo["longtitude"]=$("#PoleLon").val();
	poleinfo["latitude"]=$("#PoleLat").val();
	poleinfo["height"]=$("#PoleLength").val();
	poleinfo["type"]=$("#PoleType").val();
	poleinfo["status"]=$("#PoleStatus").val();
	//poleinfo["memo"]=$("").val();
	//alert(poleinfo.name+poleinfo.latitude);
	return poleinfo;
}
/**
 * 添加杆所属线路和前一杆信息div样式
 */
$("#addPoleBtn").click(function(){
	countNum++;
	if(countNum>2)
		{
			countNum--;
			alert("最多添加两条!");
		}
	else{
		$("#thirdLayer").append("<div class='thirdLayer"+countNum+"'>"
				+"<label for='PolePre' class='control-label'>前一杆</label>"
				+" <select class='PolePre'></select>"
				+" <label for='PoleForLine' class='control-label'>所属线路</label>    <select class='PoleForLine' id='PoleForLine"+countNum+"'>"
				+"	</select>"
				+" <label for='PoleCode' class='control-label'>编码</label><input"
				+"  type='text' class='PoleCode' name='PoleCode' />"
				+"<input type='button' value='删除' class='delLinePole' onclick='deldiv(this)'/>"
			+"</div>");
		poleinit.SelectAllPole(countNum);
		lineinit.SelectAllLineName(countNum);
	}
})
/*
 * 删除线路线杆输入信息
 */
function deldiv(thisinfo){
	$(thisinfo).parent().remove();
	countNum--;
	$(".thirdLayer2").removeClass("thirdLayer2").addClass("thirdLayer1");
	$("#PoleForLine2").removeClass("PoleForLine2").addClass("PoleForLine1");
}
/**
 * 所有添加线路输入信息
 * @returns {}
 */
function InsertLineInfoArr() {
	var LineInfo = $("#LineForm").serializeArray();
	var LineData = {};
	$.each(LineInfo, function(i, info) {
		switch (info.name) {
		case ("LineNameInput"):
			LineData["name"] = info.value;
			break;
		case ("LineLength"):
			LineData["linelength"] = info.value;
			break;
		case ("LineNumber"):
			LineData["lineNum"] = info.value;
			break;
		case ("LineCode"):
			LineData["code"] = info.value;
			break;
		case ("LineFirstPolelon"):
			LineData["lineFirstPolelon"] = info.value;
			break;
		case ("LineFirstPolelat"):
			LineData["lineFirstPolelat"] = info.value;
			break;
		case ("LineLastPolelon"):
			LineData["lineLastPolelon"] = info.value;
			break;
		case ("LineLastPolelat"):
			LineData["lineLastPolelat"] = info.value;
			break;
		case ("LineTime"):
			LineData["timeString"] = info.value;
			break;
		case ("LineMemo"):
			LineData["memo"] = info.value;
			break;
		};
		
	})
	// select信息添加
	LineData["unitid"] = $("#LineUnit").val();
	LineData["type"] = $("#LineType").val();
	LineData["status"] = $("#LineStatus").val();;
	return LineData;
}
// 当前时间
function NowDate() {
	var d = new Date();
	var year = d.getFullYear();
	var mon = d.getMonth() + 1;
	var day = d.getDate();
	var Hour = d.getHours();
	var minutes = d.getMinutes();
	var second = d.getSeconds();
	return year + "-" + (mon < 10 ? ('0' + mon) : mon) + "-"
			+ (day < 10 ? ('0' + day) : day) + " " + Hour + ":" + minutes + ":"
			+ second;
}