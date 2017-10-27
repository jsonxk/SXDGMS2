$(function(){
	var userid=$(".userinfo span").text();
	//var username=$(".userinfo p").text();
	$(".slimScrollDiv").removeAttr("style");
	$(".slimScrollDiv").css("position","relative").css("overflow","hidden").css("width","auto").css("height","100%");
	$.ajax({
			type : "POST",
			url : "SXDG/init.spring",
			data :{"userid":userid},
			dataType : 'json',
			error : function(data) {
				alert("出错了！！:");
			},
			success : function(data) {
				var list=null;
				for(var i=0;i<data.length;i++)
				{
					list=data[i].flist;
					if(data[i].fid==1)
					{
						$(".sqgl span").append(data[i].fname);
						for(var j=0;j<list.length;j++)
						{
							$(".sqglchild").append("<li class='"+i+"sqgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
					}
					if(data[i].fid==2)
					{
						$(".tzgl span").append(data[i].fname);
						for(var j=0;j<list.length;j++)
						{
							$(".tzglchild").append("<li class='"+i+"tzgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
					}
					if(data[i].fid==3)
					{
						$(".qxgl span").append(data[i].fname);
						for(var j=0;j<list.length;j++)
						{
							$(".qxglchild").append("<li class='"+i+"qxgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
					}
					if(data[i].fid==4)
					{
						$(".dtgl span").append(data[i].fname);
						for(var j=0;j<list.length;j++)
						{
							$(".dtglchild").append("<li class='"+i+"dtgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
					}
					if(data[i].fid==5)
					{
						$(".xtgl span").append(data[i].fname);
						for(var j=0;j<list.length;j++)
						{
							$(".xtglchild").append("<li class='"+i+"xtgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
					}
					if(data[i].fid==6)
					{
						$(".rcgl span").append(data[i].fname);
						for(var j=0;j<list.length;j++)
						{
							$(".rcglchild").append("<li class='"+i+"rcgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
					}
				}
				initIndex();
			}
		});
})