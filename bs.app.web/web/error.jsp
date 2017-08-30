<%@ page language="java" contentType="text/html; charset=cp1251" pageEncoding="cp1251"%>
<%@ page import="org.plazmaforge.bsolution.base. EnterpriseEnvironment"%>   
<%@ page import="org.plazmaforge.bsolution.base. EnterpriseContext"%>
<%@ page import="org.plazmaforge.framework.config.object.InterfaceConfig"%>
<%@ page import="org.plazmaforge.bsolution.security.common.beans.User"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.plazmaforge.bsolution.app.web.WEBContextManager"%><html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=cp1251">
<title>Error</title>
</head>
<body>

 <%
  String message = request.getParameter("message");
  String error = request.getParameter("error");
 %>
 
  <h2 align="center">Error Page</h2>
 <br>
 <hr>
 <table>
 	<tr><td><%= message == null ? "" : message %></td></tr>
 	<tr><td><%= error == null ? "" : error %></td></tr>
</table> 
<hr>

</body>
</html>