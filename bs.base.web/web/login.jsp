<%@ page language="java" contentType="text/html; charset=cp1251" pageEncoding="cp1251"%>
<%@ page import="org.plazmaforge.bsolution.base. EnterpriseEnvironment"%>   
<%@ page import="org.plazmaforge.bsolution.base. EnterpriseContext"%>
<%@ page import="org.plazmaforge.framework.config.object.InterfaceConfig"%>
<%@ page import="org.plazmaforge.bsolution.security.common.beans.User"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.plazmaforge.bsolution.base.web.WEBContextManager"%><html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=cp1251">
<title>Insert title here</title>
</head>
<body>
 <h2>Login Page</h2>
 
 
 <br>
 <hr>
 <form action="<%= request.getContextPath() + "/login" %>" method = "POST">
 <table>
 	<tr><td>Username</td><td><input name="username"/></td></tr>
  	<tr><td>Password</td><td><input name="password"/></td></tr>
  	<tr><td></td><td><input type=submit value="Login"></td></tr>
  	
  	
</table>
</form>
 
<hr>

</body>
</html>