package org.plazmaforge.bsolution.base.web;

import javax.servlet.http.HttpSession;

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.security.common.beans.User;

public class WEBContextManager {

    public static final String SESSION_CONTEXT = "SESSION.CONTEXT";
    
    
    
    private HttpSession session;

    public WEBContextManager(HttpSession session) {
	super();
	if (session == null) {
	    throw new IllegalArgumentException();
	}
	this.session = session;
    }
    
    public HttpSession getSession() {
        return session;
    }



    public SessionContext getSessionContext() {
	return (SessionContext) getSession().getAttribute(SESSION_CONTEXT);
    }
    
    public void setSessionContext(SessionContext context) {
	getSession().setAttribute(SESSION_CONTEXT, context);
    }
    
    
    
    public User getUser() {
	SessionContext context = getSessionContext();
	return context == null ? null : context.getUser(); 
    }
    
    
    public boolean isLogin() {
	return getUser() != null;
    }
    
    
}
