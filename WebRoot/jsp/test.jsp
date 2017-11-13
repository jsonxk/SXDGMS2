<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="./js/table/bootstrap.css" />
	<script src="./assets/vendor/jquery/jquery.min.js"></script>
	<script src="./assets/vendor/bootstrap/js/bootstrap.min.js"></script>

<style>

ul{
    margin: 0;
    padding: 0;
}
li{
    margin: 0;
    padding: 0;
}

#myTab li{
    width:25%;
    float:left;
    height:40px;    
    list-style: none;
    margin: 0;
    padding: 0;
}

#myTab li img{
    float:left;
    height: 40px;    
}

#myTab li a{
    color:white;
    text-align: center;
    position: relative;
    display: block;
    padding: 10px 15px;    
}

.blue{
    background:#0f9af2;
}
.gray{
    background: #dfdfdf;
}
#myTabContent{
margin:0 auto;}
.tab-content{
	width:80%;
	height:200px;
	border:solid 1px #000;
	float:left;
}
</style>
<script>
 $(document).ready(function(){
            
        });
        
        //dom操作
        var domFun={
            
        };
        
        //事件操作
        var eventFun={
            setStep:function(index){                
              
            },
            next:function(index){
            	var val1=$("#val1").val();
            	if(val1.length==0)
            	{
            		alert("请填入完整信息")
            	}
            	else{
            		$("#step"+(index-1)+"Li").removeClass("active");
            		$("#step"+(index)+"Li").addClass("active blue").removeClass("gray");
            		$("#step"+index+"Img").attr("src","./step/images/blue_blue.png");
            		$("#step1").removeClass("active in");
                	$("#step2").addClass("active in");
            	}
            },
            pre:function(index){
            		$("#step"+(index+1)+"Li").removeClass("active blue").addClass("gray");
            		$("#step"+(index)+"Li").addClass("active");
                    $("#step"+(index+1)+"Img").attr("src","./step/images/blue_gray.png");
                    $("#step2").removeClass("active in");
                    $("#step1").addClass("active in");
            }
        };
</script>
</head>

<body>
            <ul id="myTab" role="tablist">
                  <li id="step1Li" class="active blue">                      
                     <!--  <a href="#step1" role="tab" data-toggle="tab">
                          1.基础信息录入
                      </a>  -->
                      <span>1.基础信息录入</span>                     
                  </li>
                  <li id="step2Li"  class="gray">
                      <img id="step2Img" src="./step/images/blue_gray.png"/>
                      <!-- <a href="#step2"role="tab" data-toggle="tab">
                          2.录入文件信息
                      </a> -->
                      <span>2.录入文件信息</span>
                  </li>      
            </ul>
            <div id="myTabContent" class="tab-content">
                  <div id="step1" class="tab-pane fade active in">
                  <input type="text" id="val1">
                 	<button id="next" onclick="eventFun.next(2)">下一步 </button>
                  </div>
                  <div id="step2" class="tab-pane fade ">
                  	<input type="text" id="val2">
                    <button id="pre" onclick="eventFun.pre(1)">上一步 </button>
                  </div>
    	</div>
</body>
</html>
