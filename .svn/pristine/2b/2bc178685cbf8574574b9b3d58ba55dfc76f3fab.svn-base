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
 * Created on 16.02.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;



import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.plazmaforge.bsolution.base.client.swt.ConfigApplication;

/** 
 * @author Oleh Hapon
 * $Id: JDBCPanel.java,v 1.3 2010/07/06 14:36:25 ohapon Exp $
 */

public class JDBCPanel extends DialogItemPanel {

    public static final String PROPERTIES_FILE = "jdbc.properties";
    
    public static final String JDBC_DRIVER_CLASS_NAME = "jdbc.driverClassName";
    public static final String JDBC_URL = "jdbc.url";
    public static final String JDBC_USERNAME = "jdbc.username";
    public static final String JDBC_PASSWORD = "jdbc.password";
    public static final String HIBERNATE_DIALECT = "hibernate.dialect";


    
    ///
    
    private Text driverClassField;
    private Text urlField;
    private Text usernameField;
    private Text passwordField;
    private Text hibernateDialectField;
    
    
    public JDBCPanel(Composite parent, String title) {
	super(parent, title);
    }

    protected PropertyManager createPropertyManager() {
	return createPropertyManager(ConfigApplication.getConfDir() + "/" + ConfigApplication.getFilePrefix() +  PROPERTIES_FILE);
    }

 
    public void loadData() {
	loadProperties();
	updateControls();
    }
    
    public void storeData() {
	updateData();
	storeProperties();
    }
    
    protected void updateControls() {
	driverClassField.setText(getDefProperty(JDBC_DRIVER_CLASS_NAME));
	urlField.setText(getDefProperty(JDBC_URL));
	usernameField.setText(getDefProperty(JDBC_USERNAME));
	passwordField.setText(getDefProperty(JDBC_PASSWORD));
	hibernateDialectField.setText(getDefProperty(HIBERNATE_DIALECT));
    }
    
    protected void updateData() {
	setProperty(JDBC_DRIVER_CLASS_NAME, driverClassField.getText());
	setProperty(JDBC_URL, urlField.getText());
	setProperty(JDBC_USERNAME, usernameField.getText());
	setProperty(JDBC_PASSWORD, passwordField.getText());
	setProperty(HIBERNATE_DIALECT, hibernateDialectField.getText());
    }
    
  

    protected Composite createDialogContent(Composite parent) {
	Composite content = super.createContent(parent);
	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	content.setLayout(layout);
	
	driverClassField = addTextField(content, Messages.getString("ConfigPanel.jdbc.driver"), 200);
	urlField = addTextField(content, Messages.getString("ConfigPanel.jdbc.url"));
	usernameField = addTextField(content, Messages.getString("ConfigPanel.jdbc.username"));
	passwordField = addTextField(content, Messages.getString("ConfigPanel.jdbc.password"));
	hibernateDialectField = addTextField(content, Messages.getString("ConfigPanel.jdbc.hibernate.dialect"));
	
	return content;
    }
    
 
    
    protected void createContent() {
	createDialogContent(this);
    }
}
