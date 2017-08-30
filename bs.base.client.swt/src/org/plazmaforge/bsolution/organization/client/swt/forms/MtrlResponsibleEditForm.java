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
 * Created on 09.07.2007
 *
 */

package org.plazmaforge.bsolution.organization.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;

/** 
 * @author Oleh Hapon
 * $Id: ResponsibleEditForm.java,v 1.2 2010/04/28 06:31:06 ohapon Exp $
 */

public class MtrlResponsibleEditForm  extends AbstractOrganizableEditForm {

    private Label contactLabel;

    private Label warehouseLabel;
    
    
    private XComboEdit contactField;
    
    private XComboEdit warehouseField;

  
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public MtrlResponsibleEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("MtrlResponsibleEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	contactLabel = new Label(this, SWT.NONE);
	contactLabel.setText(Messages.getString("MtrlResponsibleEditForm.employeeLabel.text")); //$NON-NLS-1$

    	contactField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
    	contactField.setLayoutData(new GridData(300, SWT.DEFAULT));

    	warehouseLabel = new Label(this, SWT.NONE);
	warehouseLabel.setText(Messages.getString("MtrlResponsibleEditForm.warehouseLabel.text")); //$NON-NLS-1$

    	warehouseField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	warehouseField.setLayoutData(gridData);
    	
    	this.setSize(new Point(470, 108));
    	
    	initResponsibleField(contactField);
    }
    
    protected void bindControls() {
	bindControl(contactField, "contact", contactLabel, REQUIRED);
	bindControl(warehouseField, "warehouse");
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
