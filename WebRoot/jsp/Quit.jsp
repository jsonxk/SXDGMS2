<%@ page contentType="text/html; charset=GBK"%>
<%
session.invalidate();
%>
<script>
	window.opener = null;
    window.close();
    window.location.href="login.jsp";
</script>