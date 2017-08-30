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

/* 
 * Created on 25.07.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.CodecUtils;
import org.plazmaforge.framework.util.StringUtils;

/** 
 * @author Oleh Hapon
 * $Id: LoginDialog.java,v 1.10 2010/12/05 07:57:20 ohapon Exp $
 */

public class LoginDialog extends TitleAreaDialog {

    private static final Logger logger = Logger.getLogger(LoginDialog.class);
    
    private boolean login;
    
    
    private Label loginLabel;
    private Label passwordLabel;
    
    private XTextField loginField;
    private XTextField passwordField;
    private Button rememberButton;
    
    private boolean rememberAccount;
    private String storeLogin;
    private String storePassword;
    private boolean firstLoad;
    
    public LoginDialog(Shell arg0) {
	super(arg0);
    }

    protected void configureShell(Shell newShell) {
	super.configureShell(newShell);
	newShell.setText(Messages.getString("LoginDialog.title")); //$NON-NLS-1$
    }
    
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, Messages.getString("LoginDialog.cancel"), false); //$NON-NLS-1$
    }
    
    protected Control createDialogArea(Composite parent) {

	Composite parentComposite = (Composite) super.createDialogArea(parent);
	
        Composite composite = new Composite(parentComposite, SWT.BORDER);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
        
        GridLayout layout = new GridLayout();
        layout.marginTop = 10;
        layout.marginBottom = 10;
        layout.horizontalSpacing = 10;
        layout.verticalSpacing = 10;
        layout.numColumns = 2;
        
        composite.setLayout(layout);
        
        GridData gridData = null;
        
	loginLabel = new Label(composite, SWT.NONE);
	loginLabel.setText(Messages.getString("LoginDialog.login")); //$NON-NLS-1$

    	loginField = new XTextField(composite, SWT.BORDER);
    	loginField.setLayoutData(new GridData(200, SWT.DEFAULT));
    	loginField.setTextLimit(30); //64
    	

    	passwordLabel = new Label(composite, SWT.NONE);
    	passwordLabel.setText(Messages.getString("LoginDialog.password")); //$NON-NLS-1$

    	passwordField = new XTextField(composite, SWT.BORDER);
    	passwordField.setLayoutData(new GridData(200, SWT.DEFAULT));
    	passwordField.getUIControl().setEchoChar('*');
    	passwordField.setTextLimit(30); //64

    	gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        gridData.horizontalSpan = 2;
    	rememberButton = new Button(composite, SWT.CHECK);
    	rememberButton.setLayoutData(gridData);
    	rememberButton.setText(Messages.getString("LoginDialog.remember"));

   	
	doLoadPreferences();
	doInitPreferences();
	
        composite.pack();
        
        return parentComposite;
    }    
    
    private void doInitPreferences() {
	
	// Only for AutoLogin or RememberAccount modes
	if (!AppEnvironment.isAutoLogin() && !isRememberAccount()) {
	    return;
	}
	
	if (AppEnvironment.isDemo() && isEmptyStoreAccount() && isFirstLoad()) {

	    // If it is first load and login and password are empty we set default values for DEMO mode.   
	    // Hard code !!!
	    loginField.setText("admin");
	    passwordField.setText("test");
	    setRememberAccount(true);

	} else {
	    loginField.setText(normalize(storeLogin));
	    if (isRememberAccount()) {
		passwordField.setText(normalize(storePassword));
	    }
	}

	rememberButton.setSelection(isRememberAccount());	
    }
    
    

    /*
    protected Point getInitialSize() {
	return new Point(300, 270); // 300, 230 // 300, 280
    }
    */
    
    
    protected Point getInitialSize() {
        Point shellSize = getShell().computeSize(-1, -1, true); //super.getInitialSize();
        return new Point(Math.max(convertHorizontalDLUsToPixels(100), shellSize.x), Math.max(convertVerticalDLUsToPixels(100), shellSize.y));
    }

    
    

    public boolean isLogin() {
        return login;
        
    }

    protected void okPressed() {
	login();
	
	if (!isLogin()) {
	    return;
	}
	boolean oldRememberAccount = isRememberAccount();
	setRememberAccount(rememberButton == null ? false : rememberButton.getSelection());
	
	// isAutoLogin         login/-
	// isRememberAccount() login/password
	// oldRememberAccount  -/-
	
	if (AppEnvironment.isAutoLogin() || isRememberAccount() || oldRememberAccount) {
	    modifyPreferences = true;
	    
	    if (!isRememberAccount()) {
		if (AppEnvironment.isAutoLogin()) {
		    storePassword = null;
		} else if (oldRememberAccount) {
		    storeLogin = null;
		    storePassword = null;
		}
	    }
	    
	    doStorePreferences();
	}
	
	super.okPressed();
    }
    
    private String getLoginInput() {
	return loginField.getText().trim();
    }
    
    private String getPasswordInput() {
	return passwordField.getText().trim();
    }
    
    private boolean isEmptyStoreAccount() {
	 return storeLogin == null &&  storePassword == null;
    }
    
    
    private void login() {
	
	try {
	    setControllerEnabled(false);
	    final String loginInput = getLoginInput();
	    final String passwordInput = getPasswordInput();
	    
	    
	    BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
	            public void run() {
	        	try {
	        	    
	        	    User user = EnterpriseEnvironment.login(loginInput, passwordInput);
	        	    SessionContext context = new SessionContext();
	        	    SessionEnvironment.setContext(context);
	        	    EnterpriseEnvironment.loadContext(context, user);
	        	    
	        	    
	        	    System.out.println("Welcome [" + loginInput + "] !");
	        	    login = true;
	        	} catch (AccessDeniedException ex) {
	        	    logger.error("Authentication error", ex);
	        	    Toolkit.openErrorDialog(Messages.getString("LoginDialog.application.error"), Messages.getString("LoginDialog.access.denied")); //$NON-NLS-1$ //$NON-NLS-2$
	        	} catch (ApplicationException ex) {
	        	    logger.error("Application error", ex);
	        	    Toolkit.openErrorDialog(Messages.getString("LoginDialog.system.error"), ex); //$NON-NLS-1$
	        	} catch (Exception ex) {
	        	    logger.error("System error", ex);
	        	    Toolkit.openErrorDialog(Messages.getString("LoginDialog.system.error"), ex); //$NON-NLS-1$
	        	}
            }});
	    
	    
	    
	} finally {
	     setControllerEnabled(true);
	     
	     storeLogin = loginField.getText().trim();
	     storePassword = passwordField.getText().trim();
	     
	     //statusBar.setText("");
	     
	     passwordField.setText("");
	}
	
    }
    
    
    private void setControllerEnabled(boolean enabled) {
	loginField.setEditable(enabled);
	passwordField.setEditable(enabled);
	Button okButton = getButton(IDialogConstants.OK_ID);
	if (okButton != null) {
	    okButton.setEnabled(enabled);
	}
    }
    
    
    ////
    
    
    private Properties preferences;

    private String preferencesFileName;

    private boolean modifyPreferences;

    private void doLoadPreferences() {
	try {
	    loadPreferences();
	} catch (Throwable t) {
	    logger.error("Loading preferences error", t);
	}
    }
    
    private void doStorePreferences() {
	try {
	    storePreferences();
	} catch (Throwable t) {
	    logger.error("Storing preferences error", t);
	}
    }
    
    
    private String getPreferencesFileName() {
	if (preferencesFileName == null) {
	    String folderName = System.getProperty("user.dir") + "/.settings";
	    File folder = new File(folderName);
	    if (!folder.exists()) {
		folder.mkdir();
	    }
	    preferencesFileName = folderName + "/" + getClass().getName()  + ".prefs";
	}
	return preferencesFileName;
    }

    private void loadPreferences() throws ApplicationException {

	preferences = new Properties();
	try {

	    String fileName = getPreferencesFileName();
	    File file = new File(fileName);
	    if (file.exists()) {
		FileInputStream fis = new FileInputStream(file);
		preferences.load(fis);
		fis.close();

		loadPreferences(preferences);
	    } else {
		// If file not found it is like first load
		firstLoad = true;
	    }
	    
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }

    private void loadPreferences(Properties preferences)  throws ApplicationException {
	rememberAccount = getPreferenceBoolean("plazma.platform.remember.account");
	storeLogin = decode(getPreference("plazma.platform.login"));
	storePassword = decode(getPreference("plazma.platform.password"));
    }

    private void storePreferences() throws ApplicationException {

	if (!modifyPreferences) {
	    return;
	}
	
	if (preferences == null) {
	    preferences = new Properties();
    	}	
	try {
	    storePreferences(preferences);
	    String fileName = getPreferencesFileName();
	    FileOutputStream fos = new FileOutputStream(fileName);
	    preferences.store(fos, "Plazma Preferences");
	    fos.flush();
	    fos.close();

	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }

    private void storePreferences(Properties preferences) throws ApplicationException {
	setPreference("plazma.platform.remember.account", rememberAccount ? "true" : "false");
	setPreference("plazma.platform.login", normalize(encode(storeLogin)));
	setPreference("plazma.platform.password", normalize(encode(storePassword)));
    }

    private void setPreference(String name, String value) {
	preferences.put(name, value);
	modifyPreferences = true;
    }

    private boolean isPreference(String name) {
	return preferences.get(name) != null;
    }

    private boolean getPreferenceBoolean(String name) {
	return "true".equals(preferences.get(name));
    }

    private String getPreference(String name) {
	Object obj = preferences.get(name);
	if (obj == null) {
	    return null;
	}
	String val = (String) obj;
	val = val.trim();
	if (val.length() == 0) {
	    return null;
	}
	return val;
    }

    private boolean isRememberAccount() {
        return rememberAccount;
    }

    private void setRememberAccount(boolean rememberAccount) {
        this.rememberAccount = rememberAccount;
    }

    private boolean isFirstLoad() {
        return firstLoad;
    }
    
    

    private String encode(String str) {
	if (isEmpty(str)) {
	    return null;
	}
	return CodecUtils.encode(str);
    }
    
    private String decode(String str) {
	if (isEmpty(str)) {
	    return null;
	}
	return CodecUtils.decode(str);
    }
    

    private String normalize(String str) {
	return StringUtils.emptyIfNull(str);
    }
    
    private boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }
    
}
