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
 * $Id: RMIPanel.java,v 1.2 2010/04/28 06:31:03 ohapon Exp $
 */

public class RMIPanel extends DialogItemPanel {

    public static final String PROPERTIES_FILE = "rmi.properties";
    
    public static final String RMI_HOST = "rmi.host";
    public static final String RMI_PORT = "rmi.port";

    
    ///
    
    private Text driverClassField;
    private Text urlField;
    
    public RMIPanel(Composite parent, String title) {
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
	driverClassField.setText(getDefProperty(RMI_HOST));
	urlField.setText(getDefProperty(RMI_PORT));
    }
    
    protected void updateData() {
	setProperty(RMI_HOST, driverClassField.getText());
	setProperty(RMI_PORT, urlField.getText());
    }
    
  

    protected Composite createDialogContent(Composite parent) {
	Composite content = super.createContent(parent);
	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	content.setLayout(layout);
	
	driverClassField = addTextField(content, "RMI Host", 200);
	urlField = addTextField(content, "RMI Port");
	
	return content;
    }
    
 
    
    protected void createContent() {
	createDialogContent(this);
    }
}
