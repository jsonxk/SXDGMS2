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
</head>

<body>
</body>
</html>
