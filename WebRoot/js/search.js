$(function(){
	$.ajax({
		type : "POST",
		url : "SXDG/init.spring",
		data :{"userid":userid},
		dataType : 'json',
		error : function(data) {
			alert("出错了！！:");
		},
		success : function(data) {
			
		}
	});

})