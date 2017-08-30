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
 * Created on 21 Тра 2007
 *
 */

package org.plazmaforge.bsolution.partner.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;


/** 
 * @author Oleh Hapon
 * $Id: PartnerActivityTypeLinkEditForm.java,v 1.2 2010/04/28 06:31:07 ohapon Exp $
 */

public class PartnerActivityTypeLinkEditForm extends AbstractEditForm {

    
    private Label activityTypeLabel;
    
    private XComboEdit activityTypeField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PartnerActivityTypeLinkEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("PartnerActivityTypeLinkEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	   	
    	gridLayout.numColumns = 2;
    	
    	setLayout(gridLayout);
    	
    	activityTypeLabel = new Label(this, SWT.NONE);
    	activityTypeLabel.setText(Messages.getString("PartnerActivityTypeLinkEditForm.activityTypeLabel.text")); //$NON-NLS-1$

    	activityTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	activityTypeField.setLayoutData(gridData);
    
    	this.setSize(new Point(574, 298));
    }
    
    
    protected void bindControls() {
	bindControl(activityTypeField, "activityType", activityTypeLabel, REQUIRED);
    }
    
   
    

}  //  @jve:decl-index=0:visual-constraint="10,10"

