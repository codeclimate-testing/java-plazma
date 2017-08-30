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

package org.plazmaforge.bsolution.document.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.SWTUtils;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class DocumentRelationEditForm extends AbstractEditForm {

    private Label parentTypeLabel;
    
    private Label childTypeLabel;
    
    private Label creatorClassLabel;

    
    
    private XComboEdit parentTypeField;
    
    private XComboEdit childTypeField;
    
    private XTextField creatorClassField;
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public DocumentRelationEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	
	setTitle(Messages.getString("DocumentRelationEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	parentTypeLabel = new Label(this, SWT.NONE);
    	parentTypeLabel.setText(Messages.getString("DocumentRelationEditForm.parentDocumentLabel.text")); //$NON-NLS-1$
    	parentTypeLabel.setLayoutData(new GridData());

    	parentTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	parentTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	
    	childTypeLabel = new Label(this, SWT.NONE);
    	childTypeLabel.setText(Messages.getString("DocumentRelationEditForm.childDocumentLabel.text")); //$NON-NLS-1$
    	childTypeLabel.setLayoutData(new GridData());

    	childTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	childTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	
    	creatorClassLabel = new Label(this, SWT.NONE);
    	creatorClassLabel.setText(Messages.getString("DocumentRelationEditForm.creatorClassLabel.text")); //$NON-NLS-1$

    	creatorClassField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 400;
    	creatorClassField.setLayoutData(gridData);
    	creatorClassField.setTextLimit(128);

    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	SWTUtils.setVisible(parentTypeLabel, !isChildFormMode());
    	SWTUtils.setVisible(parentTypeField, !isChildFormMode());
    	layout();
    }
    
    protected void bindControls() {
	if (!isChildFormMode()) {
	    bindControl(parentTypeField, "parentType", parentTypeLabel, REQUIRED);
	}
	bindControl(childTypeField, "childType", childTypeLabel, REQUIRED);
	bindControl(creatorClassField, "creatorClassName", creatorClassLabel, REQUIRED);
    }


    
}
