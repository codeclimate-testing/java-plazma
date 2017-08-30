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

package org.plazmaforge.bsolution.pim.client.swt.forms;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.pim.common.beans.PIMNote;
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class PIMNoteEditForm extends AbstractEditForm {

    private XTextArea textField;

    private Label textLabel;    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PIMNoteEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("PIMNoteEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
		
	gridLayout.numColumns = 1;
	setLayout(gridLayout);
    	
    	
    	textLabel = new Label(this, SWT.NONE);
	textLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    	textLabel.setText(Messages.getString("PIMNoteEditForm.textLabel.text")); //$NON-NLS-1$

    	textField = new XTextArea(this, SWT.BORDER | SWT.MULTI);
    	gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    	gridData.heightHint = 200;
    	gridData.widthHint = 500;
    	textField.setLayoutData(gridData);
    	textField.setTextLimit(255);
    	
    	this.setSize(new Point(600, 300));
    }
    
    private PIMNote getNote() {
	return (PIMNote) getEntity();
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getNote().setNoteDateTime(new Date());
	getNote().setUser(getCurrentUser());
    }
    
    protected void bindControls() {
	bindControl(textField, "text", textLabel, REQUIRED);	
    }

    protected User getCurrentUser() {
	return EnterpriseEnvironment.getUser(getEnterpriseContext());
    }
    
    protected SessionContext getEnterpriseContext() {
	return SessionEnvironment.getContext();
    }
}
