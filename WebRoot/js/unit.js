$(function(){
	var unitname=$(".unit");
	$.ajax({
		type : "POST",
		url : "SXDG/unit.spring",
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
						unitname.append("<option class='select'>"+data[i].unitname+"</option>");
					}
					else
						unitname.append("<option>"+data[i].unitname+"</option>");	
				}
		}
  	});
})