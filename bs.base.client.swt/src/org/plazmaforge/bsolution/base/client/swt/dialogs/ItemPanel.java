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
 * Created on 15.02.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;

import java.util.Properties;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: ItemPanel.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class ItemPanel extends Composite {

    private PropertyManager propertyManager;
    
    private Properties properties;
    
 
    
    public ItemPanel(Composite parent, String title) {
	super(parent, SWT.NONE);

	setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	setLayout(new GridLayout());

	createTitle(title);
	createContent();

	loadData();
    }

    protected void createTitle(String title) {
	Label label = new Label(this, SWT.NONE);
	label.setText(title);
	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

	Label separator = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
	separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    }

    protected Composite createContent(Composite parent) {
	Composite content = new Composite(parent, SWT.NONE);
	content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	content.setLayout(new GridLayout());
	return content;
    }

    protected Button createButton(Composite parent, String text) {
	Button button = new Button(parent, SWT.PUSH);
	button.setText(text);
	button.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
	return button;
    }
    
    protected void createContent() {

    }

    public void loadData() {

    }

    public void storeData() {

    }
    
    public PropertyManager getPropertyManager() {
	if (propertyManager == null)  {
	    propertyManager = createPropertyManager();
	}
        return propertyManager;
    }  
    
    protected PropertyManager createPropertyManager() {
	return createPropertyManager(null);
    }    
    
    protected PropertyManager createPropertyManager(String fileName) {
	PropertyManager propertyManager = new PropertyManager(fileName, true);
	return propertyManager;
    }
    
    

    protected Properties getProperties() {
        return properties;
    }

    protected void setProperties(Properties properties) {
        this.properties = properties;
    }
    
    protected String getDefProperty(String key) {
	String value = getProperty(key);
	return value == null ? "" : value;
    }
    
    protected String getProperty(String key) {
	return getProperties().getProperty(key);
    }

    protected void setProperty(String key, String value) {
	getProperties().setProperty(key, value);
    }

    public void loadProperties() {
	try {
	    getPropertyManager().load();
	    setProperties(getPropertyManager().getProperties());
	} catch (ApplicationException ex) {
	    ex.printStackTrace();
	}
	if (getProperties() == null) {
	    setProperties(getPropertyManager().createProperties());
	}
    }
    
    public void storeProperties() {
	try {
	    getPropertyManager().setProperties(getProperties());
	    getPropertyManager().store();
	} catch (ApplicationException ex) {
	    ex.printStackTrace();
	}
    }
}
