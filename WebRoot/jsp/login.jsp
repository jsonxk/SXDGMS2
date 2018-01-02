<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="./assets/img/favicon.png">
	<script src="./assets/vendor/jquery/jquery.min.js"></script>
<style type="text/css">
	body {
		padding:0px;
		margin:0px;
		background-image: url("images/login_back.jpg");
		background-repeat: no-repeat;
		background-size:100% 100%; 
	}
	@media screen and (min-width: 750px) { 
		#loginDiv span{
			width:54%;
			display:block;
			font-size: 30px;
			padding:15px 0 20px 24%;
			font-weight: 500;
		} 
	}
	@media screen and (max-width: 750px) { 
		#loginDiv span{
			width:54%;
			display:block;
			font-size: 10px;
			padding:15px 0 20px 24%;
			font-weight: 500;
		} 
	}
	#loginDiv{
		width:30%;
		height:280px;
		background-color: rgba(255,255,255,0.3);
		border-radius:5px;
		margin: 17% auto; 
	}
	#loginDiv input{
		width:60%;
		height:13%;
		border:1px solid gray;
		border-radius:5px;
		margin:10px 20%;
	}
	#loginDiv button{
		width:60%;
		border-radius:5px;
		height:13%;
		border:0px;
		background-color: #2b333e;
		margin:15px 20%;
		color:#FFFFFF;
		cursor: pointer;
	}
</style>	
  </head>
  
  <body>
    	<div id="loginDiv">
    		<span>三线搭挂管理系统</span>
    		<form action="Login/userLogin.spring" method="post">
    			<input type="text" name="username" id="username"/>
	    		<br>
	    		<input type="password" name="password" id="password">
				<br>
				<button type="submit" id="loginBtn">LOGIN</button>
    		</form>
    	</div>
	<script type="text/javascript">
		$(function(){
		var username=null;
		var password=null;
			$("#username").keydown(function(e){
				if(e.keyCode==13)
				{
					username=$("#username").val();
					password=$("#password").val();
					if(username!=null&&username!=""&&password!=null&&password!="")
					{
						
					}
					else{
						UserLogin(username,password);
					}
				}
			})
			$("#password").keydown(function(e){
				if(e.keyCode==13)
				{
					username=$("#username").val();
					password=$("#password").val();
					if(username!=null&&username!=""&&password!=null&&password!="")
					{
						
					}
					else{
						UserLogin(username,password);
					}
				}
			})
		})
		function UserLogin(Uname,Pwd){
			$.ajax({
				type:"post",
				data:{
					"username":Uname,
					"password":Pwd
				},
				url:"Login/userLogin.spring",
				datatype:"json",
				success:function(data){
					
				}
			})
		}
	</script>
  </body>
</html>
