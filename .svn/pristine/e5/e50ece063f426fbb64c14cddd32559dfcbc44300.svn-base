package org.plazmaforge.bsolution.app.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.plazmaforge.bsolution.security.common.beans.User;


public class LogoutServlet extends BaseServlet {

    protected void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	WEBContextManager manager = getManager(request.getSession());
	User user = manager.getUser();
	String username = user == null ? null : user.getLogin();
	
	
	// TODO: Must clear resources
	manager.setSessionContext(null);
	
	
	String url = "/logout.jsp";
	if (username != null ) {
	    url = url + "?username=" + username; 
	}
	redirect(request, response, url);
    }
}
