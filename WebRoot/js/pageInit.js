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
				$(".indexpage").css("display","block");
				for(var i=0;i<data.length;i++)
				{
					//alert(data.length);
					list=data[i].funList;
					if(data[i].functionid==1)
					{
						$(".sqgl").css("display","block");
						$(".sqgl span").append(data[i].name);
						for(var j=0;j<list.length;j++)
						{
							$(".sqglchild").append("<li class='"+i+"sqgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
						$(".sqgl .sqglchild li").css("display","block");
					}
					if(data[i].functionid==2)
					{
						$(".tzgl").css("display","blovk");
						$(".tzgl span").append(data[i].name);
						for(var j=0;j<list.length;j++)
						{
							$(".tzglchild").append("<li class='"+i+"tzgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
						$(".tzgl .tzglchild li").css("display","block");
					}
					if(data[i].functionid==3)
					{
						$(".qxgl").css("display","block");
						$(".qxgl span").append(data[i].name);
						for(var j=0;j<list.length;j++)
						{
							$(".qxglchild").append("<li class='"+i+"qxgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
						$(".qxgl .qxglchild li").css("display","block");
					}
					if(data[i].functionid==4)
					{
						$(".dtgl").css("display","block");
						$(".dtgl span").append(data[i].name);
						for(var j=0;j<list.length;j++)
						{
							$(".dtglchild").append("<li class='"+i+"dtgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
						$(".dtgl .dtglchild li").css("display","block");
					}
					if(data[i].functionid==5)
					{
						$(".xtgl").css("display","block");
						$(".xtgl span").append(data[i].name);
						for(var j=0;j<list.length;j++)
						{
							$(".xtglchild").append("<li class='"+i+"xtgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
						$(".xtgl .xtglchild li").css("display","block");
					}
					if(data[i].functionid==6)
					{
						$(".rcgl").css("display","block");
						$(".rcgl span").append(data[i].name);
						for(var j=0;j<list.length;j++)
						{
							$(".rcglchild").append("<li class='"+i+"rcgl"+j+"'><a href='"+list[j].url+"'>"+list[j].name+"</a></li>")
						}
						$(".rcgl .rcglchild li").css("display","block");
					}
				}
				initIndex();
			}
		});
})