package org.plazmaforge.bsolution.base.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseServlet extends HttpServlet {


    protected void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	perform(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	perform(request, response);
    }

    protected WEBContextManager getManager(HttpSession session) {
        return new WEBContextManager(session);
    }
    
    
    protected void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
	response.sendRedirect(request.getContextPath() + url);
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
	getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    
    
}
