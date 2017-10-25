$(function() {
			$('#treeview1').treeview({
	          data: $("#treeviewVal").html(),
	          showCheckbox : true,
	          levels:0,
	          onNodeChecked: function(event, data){
	        	 //选中父节点，则自动选择子节点
	        	if(data.nodes != null)
	        	{
	        		/*
	        		 *父节点信息不为空，获取所有子节点信息
	        		 *轮流发送信息
	        		 *发送信息id roleid
	        		 */
	        		var arrayInfo = data.nodes;
	        		for (var i = 0; i < arrayInfo.length; i++) {
	        			// $('#treeview1').treeview('checkNode', [ arrayInfo[i].nodeId, { silent: true } ]);
	        			$('#treeview1').treeview('toggleNodeChecked', [ arrayInfo[i].nodeId, { silent: true } ]);
					}
	        	}
	        	else
	        	//直接发送信息
	        		alert(2);
			  },
			  onNodeUnchecked: function(event, data){
		        	 //取消选中父节点，则自动取消选择子节点
		        	 alert(1);
		        	if(data.nodes != null)
		        	{
		        		var arrayInfo = data.nodes;
		        		for (var i = 0; i < arrayInfo.length; i++) {
		        			// $('#treeview1').treeview('checkNode', [ arrayInfo[i].nodeId, { silent: true } ]);
		        			$('#treeview1').treeview('toggleNodeChecked', [ arrayInfo[i].nodeId, { silent: true } ]);
						}
		        	}
				  }
	    		});
		});