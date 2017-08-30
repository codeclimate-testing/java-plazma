/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

/**
 * 
 */
package org.plazmaforge.bs;

import java.util.List;

import org.plazmaforge.bs.base.client.dialogs.InputDialog;
import org.plazmaforge.bs.base.client.dialogs.LoginDialog;
import org.plazmaforge.bs.organization.shared.entities.OrganizationHeader;
import org.plazmaforge.bs.security.shared.entities.User;
import org.plazmaforge.framework.config.object.InterfaceConfig;
import org.plazmaforge.framework.core.data.Callback;
import org.plazmaforge.framework.core.service.ServiceCaller;
import org.plazmaforge.framework.core.service.ServiceCallerException;
import org.plazmaforge.framework.uwt.Application;
import org.plazmaforge.framework.uwt.ApplicationContext;
import org.plazmaforge.framework.uwt.ApplicationView;
import org.plazmaforge.framework.uwt.desktop.Desktop;
import org.plazmaforge.framework.uwt.form.FormProvider;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.CallbackHandler;
import org.plazmaforge.framework.uwt.widget.CallbackResult;
import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.widget.Frame;
import org.plazmaforge.framework.uwt.widget.MessageBox;
import org.plazmaforge.framework.uwt.widget.menu.MenuBar;
import org.plazmaforge.framework.uwt.widget.tool.ToolBar;

/**
 * @author ohapon
 *
 */
public abstract class ClientApplicationInitializer extends ApplicationInitializer {
    
    

    protected abstract ApplicationBuilder getApplicationBuilder();
    
//    public void initializeFormManager(Application application) {
//	// Initialize Application
//	FormManager.setFormCreator(new DesktopApplicationFormCreator());
//	FormManager.setFormProvider(new DesktopFormProvider(application));
//    }
//    
    public void populateFrame(Frame frame) {
	
	// Create application view
	ApplicationView appView = new ApplicationView();
	appView.create();
	frame.add(appView);
	populate(appView);
    }

    protected void populate(ApplicationView appView) {
	populateMenuBar(appView);
	populateToolBar(appView);
	populateContent(appView.getContent());
	appView.setStatusText("DEMO status");
    }

    protected void populateContent(Composite parent) {
	
	parent.setLayout(new FitLayout());
	
	final Desktop desktop = new Desktop();
	parent.add(desktop);

	// Get current application and assign desktop
	Application application = Application.getCurrent();
	application.setData(FormProvider.PROPERTY_DESKTOP, desktop);
	
    }
    
    
    protected void populateMenuBar(ApplicationView appView) {
	ApplicationBuilder builder = getApplicationBuilder(); 
	if (builder == null) {
	    return;
	}
	MenuBar menuBar = builder.createSystemMenu();
	if (menuBar == null) {
	    return;
	}
	appView.setMenuBar(menuBar);
    }
    
    
    protected void populateToolBar(ApplicationView appView) {
	ApplicationBuilder builder = getApplicationBuilder(); 
	if (builder == null) {
	    return;
	}
	List<ToolBar> toolBars = builder.createToolBars();
	if (toolBars == null) {
	    return;
	}
	for (ToolBar toolBar: toolBars) {
	    appView.setToolBar(toolBar);
	}
    }
    
    protected void loadApplication(final Application application, final Callback<Object> callback) {
	loadApplicationContext(application, new Callback<CallbackResult>() {

	    @Override
	    public void onFailure(Throwable error) {
		MessageBox.error("Load Application Error: " + error);
	    }

	    @Override
	    public void onSuccess(CallbackResult result) {
		processLoadApplication(application, callback);
	    }
	});
    }
    protected void processLoadApplication(final Application application, final Callback<Object> callback) {
	openLoginDialog(application, callback);
    }
    
    protected void loadApplicationContext(Application application, Callback<CallbackResult> callback) {
	callback.onSuccess(new CallbackResult("OK"));
    }
    
    protected void openLoginDialog(final Application application, final Callback<Object> callback) {
	
	// GET: saved username
	
	final LoginDialog loginDialog = new LoginDialog();
	loginDialog.open(new CallbackHandler() {
	    
	    @Override
	    public void handle(CallbackResult result) {
		if (!result.isConfirm()) {
		    doExit(application);
		    return;
		}
		loginDialog.setProcessing(true);
		login(loginDialog.getLogin(), loginDialog.getPassword(), new Callback<User>() {

		    @Override
		    public void onFailure(Throwable error) {
			loginDialog.setProcessing(false);
			// TODO: Must check AssesDeniedException and open special message
			MessageBox.error("LoginError: " + error);
		    }

		    @Override
		    public void onSuccess(User result) {
			loginDialog.setProcessing(false);
			loginDialog.close();
			processOpenInputDialog(application, callback);

		    }
		    
		});
	    }
	});
	log("Open LoginDialog");
    }
    
    protected void processOpenInputDialog(final Application application, final Callback<Object> callback) {
	call("organization/OrganizationService", "sysFindAll", null, new Callback<List<OrganizationHeader>>() {

	    @Override
	    public void onFailure(Throwable error) {
		MessageBox.error("Load organizations error: " + error);
	    }

	    @Override
	    public void onSuccess(List<OrganizationHeader> organizations) {
		application.getApplicationContext().setAttribute(ATTRIBUTE_ORGANIZATIONS, organizations);
		openInputDialog(application, callback);
	    }
	    
	});
    }

    protected void openInputDialog(final Application application, final Callback<Object> callback) {
	
	// GET: all organizations, user organizations, default user organization
	// GET: all interfaces, user interfaces, default user interface
	
	final InputDialog inputDialog = new InputDialog();

	// Add user organizations
	List<OrganizationHeader> organizations = (List<OrganizationHeader>) application.getApplicationContext().getAttribute(ATTRIBUTE_ORGANIZATIONS);
	if (organizations != null) {
	    inputDialog.setOrganizations(organizations);
	}
	
	// Add user interfaces
	List<InterfaceConfig> interfaces = (List<InterfaceConfig>) application.getApplicationContext().getAttribute(ATTRIBUTE_INTERFACES);
	if (interfaces != null) {
	    inputDialog.setInterfaces(interfaces);
	}
	
	inputDialog.open(new CallbackHandler() {
	    
	    @Override
	    public void handle(CallbackResult result) {
		if (!result.isConfirm()) {
		    doExit(application);
		    return;
		}
		final InterfaceConfig userInterface = inputDialog.getInterface(); //"All";
		//if (userInterface == null) {
		    //TODO
		//}
		final String ui = userInterface == null ? null : userInterface.getName();
		loadApplicationConfiguration(application, ui, callback);
	    }
	});
    }
    
    protected void loadApplicationConfiguration(Application application, String ui, Callback<Object> callback) {
	// do nothing by default
    }
    
    protected void configureFrame(Application application) {
	
    }
    
    protected void doExit(Application application) {
	application.stop();
    }
    
    protected void login(final String username, final String password, final Callback<User> callback) {
	call("security/UserService", "login", new Object[] {username, password}, callback);
    }
    
    protected <T> void call(String serviceName, String methodName, Object[] parameters, Callback<T> callback) {
	ServiceCaller serviceCaller = (ServiceCaller) Application.getCurrent().getApplicationContext().getAttribute(ApplicationContext.CONFIG_SERVICE_CALLER);
	if (serviceCaller == null) {
	    if (callback != null) {
		callback.onFailure(new ServiceCallerException("ServiceCaller is not initialized"));
	    }
	    return;
	}
	serviceCaller.call(serviceName, methodName, parameters, callback);
    }
    


}
