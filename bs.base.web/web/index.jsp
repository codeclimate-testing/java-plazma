<%@ page language="java" contentType="text/html; charset=cp1251" pageEncoding="cp1251"%>
<%@ page import="org.plazmaforge.bsolution.base. EnterpriseEnvironment"%>   
<%@ page import="org.plazmaforge.bsolution.base. EnterpriseContext"%>
<%@ page import="org.plazmaforge.framework.config.object.InterfaceConfig"%>
<%@ page import="org.plazmaforge.bsolution.security.common.beans.User"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.plazmaforge.bsolution.base.web.WEBContextManager"%><html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=cp1251">
<title>Index Page</title>
</head>
<body>
 <%
  WEBContextManager manager = new WEBContextManager(session);
  if (!manager.isLogin()) {
      request.setAttribute("forward", "main");
      getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
  } else {
      getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
  }
 %>

</body>
</html>