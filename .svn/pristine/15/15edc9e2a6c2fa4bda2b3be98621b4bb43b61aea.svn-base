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

package org.plazmaforge.bsolution.contact.client.swt.forms;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.plazmaforge.framework.client.swt.SWTUtils;

/** 
 * @author Oleh Hapon
 * $Id: ContactPanel.java,v 1.3 2010/04/28 06:31:05 ohapon Exp $
 */

public class ContactPanel extends Composite {

    private AddressPanel addressPanel;
    
    private PhoneGroupPanel phoneGroupPanel;
    
    private EmailPanel emailPanel;
    
    private WebPanel webPanel;
    
    public ContactPanel(Composite parent, int style) {
	super(parent, style);
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 0;
	gridLayout.marginTop = 0;
	gridLayout.numColumns = 2;
    	setLayout(gridLayout);
    	
    	GridData gridData = null;
    
    	addressPanel = new AddressPanel(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);    	
    	addressPanel.setLayoutData(gridData);
    	
    	phoneGroupPanel = new PhoneGroupPanel(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	phoneGroupPanel.setLayoutData(gridData);
    	
    	emailPanel = new EmailPanel(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	//gridData = new GridData(2, 1);
    	emailPanel.setLayoutData(gridData);
    	
    	webPanel = new WebPanel(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    	//gridData = new GridData(2, 1);
    	webPanel.setLayoutData(gridData);
    	
    	SWTUtils.setMaxWidth(getFixedLabels());
    }

    public AddressPanel getAddressPanel() {
        return addressPanel;
    }

    public EmailPanel getEmailPanel() {
        return emailPanel;
    }

    public PhoneGroupPanel getPhoneGroupPanel() {
        return phoneGroupPanel;
    }

    public WebPanel getWebPanel() {
        return webPanel;
    }

    public Control[] getFixedLabels() {
	
	Control[] c1 = addressPanel.getFixedLabels();
	Control[] c2 = emailPanel.getFixedLabels();
	Control[] c3 = webPanel.getFixedLabels();
	List<Control> baseList = new ArrayList<Control>();
	
	populate(baseList, c1);
	populate(baseList, c2);
	populate(baseList, c3);
	
	return (Control[]) baseList.toArray(new Control[0]);
    }
    
    protected void populate(List<Control> baseList, Control[] controls) {
	if (controls == null || controls.length == 0) {
	    return;
	}
	for (Control c: controls) {
	    baseList.add(c);
	}
    }

    
}
