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

package org.plazmaforge.framework.client.swt.dialogs;



import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.plazmaforge.framework.ext.model.ImageEntry;

public class ImageDialog extends Dialog {

    private static final int SIZING_TEXT_FIELD_WIDTH = 250;
    
    private Text nameField;

    private Text sizeField;

    private ImageEntry imageEntry;

    public ImageDialog(Shell shell, ImageEntry imageEntry) {
	super(shell);
	this.imageEntry = imageEntry;
    }
    
    
    protected Control createDialogArea(Composite parent) {

        Composite parentComposite = (Composite) super.createDialogArea(parent);

        Composite composite = new Composite(parentComposite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
        layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
        layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
        layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        composite.setFont(parentComposite.getFont());

        Composite nameGroup = new Composite(composite, SWT.NONE);
        layout = new GridLayout();
        layout.numColumns = 3;
        layout.marginWidth = 10;
        nameGroup.setLayout(layout);
        GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        nameGroup.setLayoutData(data);

        Label nameLabel = new Label(nameGroup, SWT.WRAP);
        nameLabel.setText("Name");
        nameField = new Text(nameGroup, SWT.BORDER);
        data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        data.horizontalSpan = 2;
        data.widthHint = SIZING_TEXT_FIELD_WIDTH;
        nameField.setLayoutData(data);
        //nameField.addKeyListener(validateListener);
        

        Label sizeLabel = new Label(nameGroup, SWT.WRAP);
        sizeLabel.setText("Size");
        sizeField = new Text(nameGroup, SWT.BORDER);
        data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        data.horizontalSpan = 2;
        data.widthHint = SIZING_TEXT_FIELD_WIDTH;
        sizeField.setLayoutData(data);
        sizeField.setEditable(false);
        sizeField.setEnabled(false);
        
        //sizeField.addKeyListener(validateListener);
        
        loadData();
        return parentComposite;
    } 

    
    private void loadData() {

        nameField.setText(imageEntry.getName() == null ? "" : imageEntry.getName());
        sizeField.setText(imageEntry.getSizeString());
        
    }

    private void storeData() {
	imageEntry.setName(nameField.getText());
    }

    protected void okPressed() {
	if (!validateData()) {
	    return;
	}
	storeData();
        close();
    }
    
    protected boolean validateData() {
	if (nameField.getText().trim().length() == 0) {
	    MessageDialog.openError(getShell(), "Error", "Name is empty");
	    return false;
	}
	return true;
    }

}
