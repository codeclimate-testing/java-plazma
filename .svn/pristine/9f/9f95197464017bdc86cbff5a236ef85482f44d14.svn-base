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
 * Created on 17.02.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;


import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.plazmaforge.bsolution.base.client.swt.ConfigApplication;

/** 
 * @author Oleh Hapon
 * $Id: JNDIPanel.java,v 1.2 2010/04/28 06:31:03 ohapon Exp $
 */

public class JNDIPanel extends DialogItemPanel {

    public static final String PROPERTIES_FILE = "jndi.properties";
    
    public static final String FACTORY_INITIAL = "java.naming.factory.initial";
    public static final String PROVIDER_URL = "java.naming.provider.url";
    public static final String FACTORY_URL_PKGS = "java.naming.factory.url.pkgs";


    
    ///
    
    private Text factoryInitialField;
    private Text providerUrlField;
    private Text factoryUrlPkgsField;
    
    
    public JNDIPanel(Composite parent, String title) {
	super(parent, title);
    }

    protected PropertyManager createPropertyManager() {
	return createPropertyManager(ConfigApplication.getConfDir() + "/" + ConfigApplication.getFilePrefix() + PROPERTIES_FILE);
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
	factoryInitialField.setText(getDefProperty(FACTORY_INITIAL));
	providerUrlField.setText(getDefProperty(PROVIDER_URL));
	factoryUrlPkgsField.setText(getDefProperty(FACTORY_URL_PKGS));
    }
    
    protected void updateData() {
	setProperty(FACTORY_INITIAL, factoryInitialField.getText());
	setProperty(PROVIDER_URL, providerUrlField.getText());
	setProperty(FACTORY_URL_PKGS, factoryUrlPkgsField.getText());
    }
    
  

    protected Composite createDialogContent(Composite parent) {
	Composite content = super.createContent(parent);
	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	content.setLayout(layout);
	
	factoryInitialField = addTextField(content, "java.naming.factory.initial", 200);
	providerUrlField = addTextField(content, "java.naming.provider.url");
	factoryUrlPkgsField = addTextField(content, "java.naming.factory.url.pkgs");
	return content;
    }
    
 
    
    protected void createContent() {
	createDialogContent(this);
    }
}
