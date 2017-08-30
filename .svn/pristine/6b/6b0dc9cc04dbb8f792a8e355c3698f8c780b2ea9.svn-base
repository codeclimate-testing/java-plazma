/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
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

package org.plazmaforge.bsolution.base.client;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.bsolution.base.ApplicationManagerExecutor;
import org.plazmaforge.bsolution.base.EnterpriseConstants;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.base.client.swt.RCPEntityManager;
import org.plazmaforge.bsolution.base.client.swt.RCPServiceFactory;
import org.plazmaforge.bsolution.base.client.swt.dialogs.InputDialog;
import org.plazmaforge.bsolution.base.client.swt.dialogs.LoginDialog;
import org.plazmaforge.bsolution.base.client.swt.forms.SplashForm;
import org.plazmaforge.bsolution.security.common.services.PermissionService;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.client.Environment;
import org.plazmaforge.framework.client.actions.ActionCommandParser;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.help.HelpSystem;
import org.plazmaforge.framework.client.swt.SWTActionFactory;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.client.swt.SWTFormFactory;
import org.plazmaforge.framework.client.swt.SWTReportFactory;
import org.plazmaforge.framework.client.swt.app.SWTProcessRunner;
import org.plazmaforge.framework.client.swt.report.jasperreports.SWTReportPreview;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.association.PathAssociationCreator;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.platform.EntityEnvironment;
import org.plazmaforge.framework.platform.PlatfromClientApplicationManager;
import org.plazmaforge.framework.report.ReportProcessor;
import org.plazmaforge.framework.report.engine.jasperreports.JasperReportsEngine;
import org.plazmaforge.framework.security.AbstractSecureManager;
import org.plazmaforge.framework.security.SecureEnvironment;
import org.plazmaforge.framework.security.SecureManager;
import org.plazmaforge.framework.util.ErrorTranslator;
import org.plazmaforge.framework.util.IEntityManager;




/**
 * Rich Client Manager
 * 
 * @author Oleh Hapon
 */
public class SWTClientApplicationManager extends PlatfromClientApplicationManager implements EnterpriseConstants {
    
    protected final Log logger = LogFactory.getLog(getClass());
    
    protected ApplicationManagerExecutor executor = new ApplicationManagerExecutor();

    private Shell splash;
    
    private SplashForm splashForm;
 
    private Display display;
    
    private boolean isProcessing;
    
    
    /** Login dialog **/
    private LoginDialog loginDialog;
    
    /** Form to input start parameters **/
    private InputDialog inputDialog;
    
    
    
    public SWTClientApplicationManager() {
    }

    protected void splashShow() throws ApplicationException {
	
	
	display = Display.getDefault();
	splash = new Shell(SWT.ON_TOP);
	splash.setLayout(new FillLayout());
	
	splashForm = new SplashForm(splash, SWT.NONE);
	
	splash.pack();
	    
	    
	Rectangle splashRect = splash.getBounds();
	Rectangle displayRect = display.getBounds();
	int x = (displayRect.width - splashRect.width) / 2;
	int y = (displayRect.height - splashRect.height) / 2;
	splash.setLocation(x, y);
	splash.open();
	
     }
    
    protected void splashHide() throws ApplicationException {
	/*
    	splash.setVisible(false);
	splash.dispose();
	*/
    }
    
    protected void dialogShow() throws ApplicationException {

	if (errorLoadSystem) {
	    MessageDialog.openError(null, "Internal Error", "Initialize System Error. \nPlease see logs files");
	    return;
	}
	
	
	loginDialog = new LoginDialog(null); 
	loginDialog.open();
	
	if (!isLogin()) {
	    return;
	}

	if (!isSupportInputDialog()) {
	    AppEnvironment.setUserInterface(AppEnvironment.DEFAULT_USER_INTERFACE);
	    return;
	}
	
	if (!isAvailableCustomParameters()) {
	    return;
	}
	
	
	inputDialog = new InputDialog(null);
	inputDialog.open();
    }
    
    protected boolean isLogin() {
	if (loginDialog == null) {
	    return false;
	}
    	boolean isLogin = loginDialog.isLogin();
    	boolean isInputSelected = inputDialog == null ? true : inputDialog.isSelected();
    	return isLogin && isInputSelected; 
    }
    
    protected boolean isAvailableCustomParameters() {
	return EnterpriseEnvironment.isAvailableCustomParameters(SessionEnvironment.getContext());
    }

    protected boolean isSupportInputDialog() {
	return AppEnvironment.isInputDialog();
    }

    public void registerPackages() throws ApplicationException {
    	executor.registerPackages();
    }
    
    protected void initSystem() throws ApplicationException {
	executor.initSystem();
    }
    
    
    protected void loadEntities()  throws ApplicationException {
	executor.loadEntities();
    }
	
    protected void initEnvironment() throws ApplicationException {
	super.initEnvironment();
	executor.initEnvironment();
	updateStatusBar();
    }
 	
    public void updateStatusBar() {
	SWTEnvironment.getApplication().setStatusText(EnterpriseEnvironment.getStatusText(SessionEnvironment.getContext()));
    }    
    
   protected void initContext() throws ApplicationException {
	
       super.initContext();
	
	// ---------------------------------------------------------------------------------------
	//
	// INITIALIZE CONTEXT
	//
	// ---------------------------------------------------------------------------------------
       
	SWTFormFactory formFactory = new SWTFormFactory();
	Environment.setFormFactory(formFactory);
	
	SWTActionFactory actionFactory = new SWTActionFactory();
	actionFactory.setCommandParser(new ActionCommandParser());
	Environment.setActionFactory(actionFactory);
	
	SWTReportFactory reportFactory = new SWTReportFactory();
	Environment.setReportFactory(reportFactory);
	
	
	
	RCPServiceFactory serviceFactory = new RCPServiceFactory();
	Environment.setServiceFactory(serviceFactory);
	
	RCPEntityManager entityManager = new RCPEntityManager();
	Environment.setEntityManager(entityManager);
	
	// Initialize Association Creator
	EntityEnvironment.initAssociationManager();
	
	PathAssociationCreator associationCreator = (PathAssociationCreator) AssociationManager.getAssociationCreator();
	//
	
	// Insertion order is very important
	associationCreator.addType(IListForm.class, "client.swt.forms", IListForm.SUFFIX);
	associationCreator.addType(IEditForm.class, "client.swt.forms", IEditForm.SUFFIX);
	associationCreator.addType(IForm.class, "client.swt.forms", "Form");
	

	
	ErrorTranslator.setEntityManager(new IEntityManager() {
	    public String getEntityName(String id) {
		return EntityEnvironment.getEntityNameById(id);
	    }
	    
	    public boolean isMasterEntity(String id) {
		return EntityEnvironment.isMasterEntity(id);
	    }
	    
	});
	
	SecureEnvironment.setSecureManager(new RCPSecureManager());
	
	ReportProcessor.setProcessRunner(new SWTProcessRunner());
	
	JasperReportsEngine.setReportPreview(new SWTReportPreview());
	
	
	
	String helpSite = System.getProperty("plazma.platform.help.site");
	String helpLanguage = getHelpLanguage(System.getProperty("plazma.platform.help.language"));
	if (helpSite == null) {
	    helpSite = System.getProperty("user.dir") + "/docs/guide";
	}
	helpSite += "/" + helpLanguage;
	HelpSystem.setHelpSite(helpSite);
	HelpSystem.setHelpUrl(helpSite + "/usr-guide/index.html");
	
    } 
   
   protected String getHelpLanguage(String lan) {
       if (lan == null) {
	   lan = "ISO3";
       }
       String helpLanguage = lan.trim();
       String iso = helpLanguage.toUpperCase();
       int isoType = 0;
       if ("ISO2".equals(iso)) {
	   isoType = 2;
       } else if ("ISO3".equals(iso)) {
	   isoType = 3;
       }
       if (isoType == 0) {
	   return helpLanguage;
       }
       // TODO: Stub
       if (LocaleManager.xUSSR()) {
	   return isoType == 2 ? "ru" : "rus"; 
       }
       
       return isoType == 2 ? "en" : "eng";
   }
    
   public void loadSystemConfiguration() throws ApplicationException {
	isProcessing = true;
	
	/*
	display.asyncExec(new Runnable() {
	    public void run() {
		try {
		    processLoadSystemConfiguration();
		} catch (ApplicationException ex) {
		    ex.printStackTrace();
		} finally {
		    isProcessing = false;
		}
		splashForm.stop();
		splash.close();
	    }
	});
	*/
	
	splashForm.run(new Process());
	splash.close();
	

	while (isProcessing) {
	    if (!display.readAndDispatch())
		display.sleep();
	}

    }
   
   private boolean errorLoadSystem; 
   
   private class Process implements IRunnableWithProgress {
	public void run(IProgressMonitor monitor) {
	    errorLoadSystem = false;
	    monitor.beginTask("Processing...", -1);
	    try {
		processLoadSystemConfiguration();
	    } catch (Throwable ex) {
		errorLoadSystem = true;
		logger.error("LoadConfigurationError", ex);
	    } finally {
		isProcessing = false;
	    }
	}
    }
   

   
    protected void processLoadSystemConfiguration() throws ApplicationException {
	super.loadSystemConfiguration();
    }
    
    class RCPSecureManager extends AbstractSecureManager implements SecureManager {
	
	private PermissionService getPermissionSrvice() {
	    return (PermissionService) ServiceFactory.getService(PermissionService.class);
	}

	
	public void checkReadPermission(String secureObjectId, String  objectType) throws ApplicationException {
	    try {
		if (isCacheRoles) {
		    getPermissionSrvice().checkReadPermission(getRoleIds(), secureObjectId, objectType);
		}
		getPermissionSrvice().checkReadPermission(secureObjectId, objectType);
	    } catch (AccessDeniedException ex) {
		throw new ApplicationException(ex);
	    }
	}

	public void checkWritePermission(String secureObjectId, String  objectType) throws ApplicationException {
	    try {
		if (isCacheRoles) {
		    getPermissionSrvice().checkWritePermission(getRoleIds(), secureObjectId, objectType);
		}
		getPermissionSrvice().checkWritePermission(secureObjectId, objectType);
	    } catch (AccessDeniedException ex) {
		throw new ApplicationException(ex);
	    }
	}

	public void checkExecPermission(String secureObjectId, String  objectType) throws ApplicationException {
	    try {
		if (isCacheRoles) {
		    getPermissionSrvice().checkExecPermission(getRoleIds(), secureObjectId, objectType);
		}
		getPermissionSrvice().checkExecPermission(secureObjectId, objectType);
	    } catch (AccessDeniedException ex) {
		throw new ApplicationException(ex);
	    }
	}
	
	
	public void checkSecureObject(Class objectClass) throws ApplicationException {
	    checkReadPermission(objectClass);
	}
	
	protected Integer[] getRoleIds() {
	    List<Integer> l = new ArrayList<Integer>();
	    String[] rs = getContextRoleIds();
	    if (rs != null) {
		for (String r : rs) {
		    l.add(Integer.valueOf(r));
		}
	    }
	    return (Integer[]) l.toArray(new Integer[0]);
	}
	
	private boolean isCacheRoles = true;
	
	
    }
 
    
    
    
    
    ////

    public void reloadOrganization(Integer organizationId) throws ApplicationException {
	if (organizationId == null) {
	    return;
	}
	SessionContext context = SessionEnvironment.getContext();
    	if (!organizationId.equals(EnterpriseEnvironment.getOrganizationId(context))) {
    	    return;
    	}
    	reloadOrganization(context);
    }
    
    public void reloadOrganization() throws ApplicationException {
    	SessionContext context = SessionEnvironment.getContext();
    	reloadOrganization(context);
    }

    
    public void reloadOrganization(SessionContext context) throws ApplicationException {
	EnterpriseEnvironment.loadOrganization(context);
	updateStatusBar();
    }
    
}