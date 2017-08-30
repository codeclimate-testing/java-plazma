package org.plazmaforge.bsolution.base.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.config.object.IInterfaceConfig;


public class LoginServlet extends BaseServlet {

    
    protected void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String forward = (String) request.getAttribute("forward");
	
	try {
	    
	    User user = EnterpriseEnvironment.login(username, password);
	    SessionContext context = new SessionContext();
	    
	    WEBContextManager manager = getManager(request.getSession());
	    manager.setSessionContext(context);
	
	    EnterpriseEnvironment.loadContext(context, user);
	    
		
	    
	    
	    IInterfaceConfig ui = context.getUserInterface();
	    if (ui == null) {
		List<IInterfaceConfig> uis = EnterpriseEnvironment.getUserInterfacesByUser(user);
		if (uis != null && !uis.isEmpty()) {
		    ui = uis.get(0);
		    context.setUserInterface(ui);
		}
	    }
	    
		
	    System.out.println("user = [" + (user == null ? null : user.getLogin()) + "]");
	    System.out.println("ui = [" + (ui == null ? null : ui.getName()) + "]");
	    
	    String url = "/main.jsp";
	    if ("index".equals(forward) || "main".equals(forward)) {
		url = "/" + forward + ".jsp";
	    }

	    redirect(request, response, url);
	    
	} catch (AccessDeniedException ex) {
	    redirect(request, response, "/error.jsp?message=Access Denied");
	} catch (Throwable ex) {
	    redirect(request, response, "/error.jsp?message=System Error&error=" + ex.toString());
	}
    }
    

}
