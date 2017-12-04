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
	poleinit.SelectAllPole(0);
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
							field : "memo",
							title : "描述",
							align : "center",
							valign : "middle",
						},/* {
							field : "poleNumber",
							title : "线杆数量",
							align : "center",
							valign : "middle",
						}*/ {
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
		$('#lineInfoTable').bootstrapTable('resetView');
	});
}
function operateFormatter(value, row, index) {
	return [
			'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">详情</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
			'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;background-color:red;color:white">删除</button>']
			.join('');
}
// 表格操作的按钮事件
window.operateEvents = {
	'click .RoleOfA' : function(e, value, row, index) {
		alert(row.lineid);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		alert(row.lineid);
	},
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
						columns : [ {
							title : "序号",
							align : "center",
							valign : "middle",
							formatter : function(value, row, index) {
								return index+ 1;
							}
						}, {
							field : "name",
							title : "线杆名称",
							align : "center",
							valign : "middle",
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
function operateFormatterpole(value, row, index) {
	return [
'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">详情</button>',
'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;background-color:red;color:white">删除</button>', ]
			.join('');
}
// 表格操作的按钮事件
window.operateEventspole = {
	'click .RoleOfA' : function(e, value, row, index) {
		alert(row.poleid);
	},
	'click .RoleOfB' : function(e, value, row, index) {
		alert(row.poleid);
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
})
/**
 * 点击添加线杆
 */
$(".addPole").click(function(){
	$("#AddPoleModal").modal("show");
	$("#PoleTime").val(NowDate());
	$(".thirdLayer1").remove();
	$(".thirdLayer2").remove();
})
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
	$.ajax({
		type : "post",
		url : "LinePole/insertLineInfo.spring",
		data : JSON.stringify(InsertLineInfoArr()),
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			$("#AddLineModal").modal("hide");
			lineinit.LineInfoInit();
		},
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
					$(".thirdLayer"+index+" "+".PolePre").append("<option value='" + data[i].poleid + "'>"
							+ data[i].name + "</option>");
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
	dataDetail["lineid"]=Number(lineforPole);
	dataDetail["poleid"]=poleid;
	dataDetail["prepoleid"]=Number(prepoleinfo);
	dataDetail["code"]=Number(code);
	dataDetail["name"]=$("#PoleNameInput").val();;
	console.log(dataDetail);
	return dataDetail;
}
/**
 * 线杆具体信息
 */
function PoleInfoObject(){
	var poleinfo={};
	poleinfo["name"]=$("#PoleNameInput").val();
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
				+" <label for='PoleForLine' class='control-label'>所属线路</label><select class='PoleForLine'>"
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