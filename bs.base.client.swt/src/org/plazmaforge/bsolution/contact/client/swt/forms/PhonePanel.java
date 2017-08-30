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


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.swt.controls.XTextField;

/** 
 * @author Oleh Hapon
 * $Id: PhonePanel.java,v 1.2 2010/04/28 06:31:05 ohapon Exp $
 */

public class PhonePanel extends Composite {

    private Label phoneStringLabel;
    
    private XTextField phoneStringField;

    public PhonePanel(Composite parent, int style) {
	super(parent, style);
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
    	gridLayout.numColumns = 2;
    	setLayout(gridLayout);
    	
    	phoneStringLabel = new Label(this, SWT.NONE);
    	phoneStringLabel.setText(Messages.getString("PhoneEditForm.phoneStringLabel.text")); //$NON-NLS-1$
    	phoneStringLabel.setLayoutData(new GridData());

    	phoneStringField = new XTextField(this, SWT.BORDER);
    	phoneStringField.setTextLimit(255);
    	//GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	//gridData.widthHint = 300;
    	
    	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 100;
    	phoneStringField.setLayoutData(gridData);
    	phoneStringField.setTextLimit(255);
    	
    }

    public XTextField getPhoneStringField() {
        return phoneStringField;
    }

    public Label getPhoneStringLabel() {
        return phoneStringLabel;
    }

    
}
