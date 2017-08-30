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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.swt.controls.XTextField;

/** 
 * @author Oleh Hapon
 * $Id: WebPanel.java,v 1.2 2010/04/28 06:31:04 ohapon Exp $
 */

public class WebPanel extends Composite {

    private Label urlLabel;
    
    private XTextField urlField;
    
    public WebPanel(Composite parent, int style) {
	super(parent, style);
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 0;
	gridLayout.marginTop = 0;
    	gridLayout.numColumns = 2;
    	setLayout(gridLayout);
    	
    	urlLabel = new Label(this, SWT.NONE);
    	urlLabel.setText(Messages.getString("WebEditForm.urlLabel.text")); //$NON-NLS-1$
    	urlLabel.setLayoutData(new GridData());

    	urlField = new XTextField(this, SWT.BORDER);
    	urlField.setTextLimit(255);
    	
    	//GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	//gridData.widthHint = 300;
    	urlField.setLayoutData(gridData);
    	urlField.setTextLimit(255);
    	
    }

    public XTextField getUrlField() {
        return urlField;
    }

    public Label getUrlLabel() {
        return urlLabel;
    }
 
    public Control[] getFixedLabels() {
	return new Control[] {urlLabel};
    }

    
}