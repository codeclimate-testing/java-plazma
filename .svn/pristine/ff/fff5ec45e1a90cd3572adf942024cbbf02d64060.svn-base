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
 * Created on 25.09.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.data.Lookup;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 */

public class LookupEditForm extends AbstractEditForm {

    private Label codeLabel;
    private Label nameLabel;

    
    private XTextField codeField;
    private XTextField nameField;

    
    private Composite itemPanel;
    private TabFolder tabFolder;
   
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public LookupEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("LookupEditForm.title")); //$NON-NLS-1$
	
	Composite composite;
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
	setLayout(gridLayout);
    	
	composite = new Composite(this, SWT.NONE);
    	
    	gridLayout = new GridLayout();
       	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	composite.setLayoutData(gridData);
    	
    	
    	codeLabel = new Label(composite, SWT.NONE);
	codeLabel.setText(Messages.getString("LookupEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	codeField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	codeField.setTextLimit(30);

    	nameLabel = new Label(composite, SWT.NONE);
	nameLabel.setText(Messages.getString("LookupEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	
    	this.setSize(new Point(470, 108));
    	
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
  
    	createItemPanel();
    	
    	AttributeValueView attributeView = new AttributeValueView(tabFolder, Lookup.class);
    	
    	registerEntityProvider(tabFolder.getItem(0), attributeView.getEntityProvider());
    }
    
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(nameField, "name", nameLabel, REQUIRED);
    }
    
    
    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
        GridLayout gridLayout;

        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 120;
        itemPanel = new Composite(this, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        itemPanel.setLayout(gridLayout);
        itemPanel.setLayoutData(gridData);
        
        tabFolder = new TabFolder(itemPanel, SWT.NONE);
        tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
    }
    
    protected Lookup getReference() {
	return (Lookup) getEntity();
    }
    
    protected IEntityConfig getEntityConfig() {
	return (IEntityConfig) getParentEntity();
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	IEntityConfig entity = getEntityConfig();
	if (entity != null & entity.getConfigName() != null) {
	    setTitle(entity.getConfigName());
	}
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getReference().setEntity(getEntityConfig());
    }

    protected Object getSelectedEntityProviderKey() {
        int index = tabFolder.getSelectionIndex();
        return tabFolder.getItem(index);
    }
    
}  //  @jve:decl-index=0:visual-constraint="10,10"

