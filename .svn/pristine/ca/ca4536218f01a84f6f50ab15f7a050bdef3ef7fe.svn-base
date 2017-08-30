<%@ page language="java" contentType="text/html; charset=cp1251" pageEncoding="cp1251"%>
<%@ page import="org.plazmaforge.bsolution.base. EnterpriseEnvironment"%>   
<%@ page import="org.plazmaforge.bsolution.base. SessionContext"%>
<%@ page import="org.plazmaforge.framework.config.object.IInterfaceConfig"%>
<%@ page import="org.plazmaforge.bsolution.security.common.beans.User"%>
<%@page import="org.plazmaforge.bsolution.base.web.WEBContextManager"%>
<%@page import="org.plazmaforge.bsolution.base.web.WEBApplicationBuilder"%>
<%@page import="org.plazmaforge.bsolution.base.web.JSGenerator"%>
<%@page import="org.plazmaforge.framework.config.object.IMenuBarConfig"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="org.plazmaforge.framework.config.object.MenuConfig"%>
<%@page import="org.plazmaforge.framework.config.object.MenuItemConfig"%><html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=cp1251">
<title>Main Page</title>

<link rel="stylesheet" type="text/css" href="/bs.standart.web/extjs/resources/css/ext-all.css" />

<script type="text/javascript" src="/bs.standart.web/extjs/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="/bs.standart.web/extjs/ext-all.js"></script>

<link rel="stylesheet" type="text/css" href="/bs.standart.web/extjs/tests/menu/menus.css" />
<link rel="stylesheet" type="text/css" href="/bs.standart.web/extjs/tests/shared/examples.css" />

<!--<script type="text/javascript" src="/bs.standart.web/extjs/tests/form/states.js"></script>-->
<!-- <script type="text/javascript" src="/bs.standart.web/extjs/tests/menu/menus.js"></script>-->

</head>
<body>

<!--<script type="text/javascript" src="/bs.standart.web/extjs/tests/menu/menus.js"></script>-->
<!--<script type="text/javascript" src="/bs.standart.web/extjs/tests/shared/examples.js"></script>--><!-- EXAMPLES -->

<%
  WEBContextManager manager = new WEBContextManager(session);
  if (!manager.isLogin()) {
      request.setAttribute("forward", "main");
      getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
      return;
  }
  
  String userDir = (String) getServletContext().getAttribute("user.dir");
  String defaultConfigName = (String) getServletContext().getAttribute("default.config.name");
  String defaultLogsDirName = (String) getServletContext().getAttribute("default.logs.dir.name");
  String defaultAppContextName = (String) getServletContext().getAttribute("default.app.context.name");  
  String defaultRootPropertyFile = (String) getServletContext().getAttribute("default.root.property.file");
  String defaultApplicationConfigFile = (String) getServletContext().getAttribute("default.application.config.file");
  String defaultSystemConfigFile = (String) getServletContext().getAttribute("default.system.config.file");
  
  
  SessionContext context = manager.getSessionContext();
  User user = context == null ? null : context.getUser();
  IInterfaceConfig ui = context == null ? null : context.getUserInterface();
  WEBApplicationBuilder builder = null;
  IMenuBarConfig menubar = null;
  if (ui != null && ui.getId() != null) {
      builder = new WEBApplicationBuilder(ui.getId());
      menubar = builder.createTreeMenu();
  }
  
  
 
 %>
 
 
<%
JSGenerator generator = new JSGenerator();
%>

<script type="text/javascript">
  <%=generator.generateMenuBarJS(menubar)%>
</script>

<script type="text/javascript" src="/bs.standart.web/extjs/tests/shared/examples.js"></script><!-- EXAMPLES -->



 <h2 align="left">Plazma ERP+CRM Main Page</h2>
 <table align="right"><tr><td><a href="<%= request.getContextPath() + "/logout" %>">Logout</a></td></tr></table>
 <br>

<div id="container-777">
    <div id="toolbar"></div>
</div>
 
 
 <br>
 <hr>
 <table>
 	<tr><td>USER_DIR</td><td><%= userDir %></td></tr>
  	<tr><td>DEFAULT_CONFIG_NAME</td><td><%= defaultConfigName %></td></tr>
  	<tr><td>DEFAULT_LOGS_DIR_NAME</td><td><%= defaultLogsDirName %></td></tr>
  	<tr><td>DEFAULT_APP_CONTEXT_NAME</td><td><%= defaultAppContextName %></td></tr>
  	<tr><td>DEFAULT_ROOL_PROPERTY_FILE</td><td><%= defaultRootPropertyFile %></td></tr>
  	<tr><td>DEFAULT_APPLICATION_CONFIG_FILE</td><td><%= defaultApplicationConfigFile %></td></tr>
  	<tr><td>DEFAULT_SYSTEM_CONFIG_FILE</td><td><%= defaultSystemConfigFile %></td></tr>
</table> 
<hr>
<table>
 	<tr><td>USER</td><td><%= user == null ? null : user.getLogin() %></td></tr>
  	<tr><td>UI</td><td><%= ui == null ? null : ui.getName() %></td></tr>
</table>
<hr>
 

</body>
</html>