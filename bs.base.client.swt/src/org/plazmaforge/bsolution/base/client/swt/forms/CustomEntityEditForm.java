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
 * Created on 21.09.2007
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
import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.client.forms.IEntityProvider;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.config.object.IEntityTypeConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: CustomEntityEditForm.java,v 1.5 2010/12/05 07:57:20 ohapon Exp $
 */

public class CustomEntityEditForm extends AbstractEditForm {

    private Label codeLabel;
    private Label nameLabel;
    private Label packageLabel;

    
    private XTextField codeField;
    private XTextField nameField;
    private XTextField packageField;

    private Composite itemPanel = null;

    private TabFolder tabFolder;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CustomEntityEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	getModel().setEntityClass(EntityConfig.class);
        getModel().setEntityServiceClass(SystemEntityService.class);

	Composite composite;

	GridData gridData;


	setTitle(Messages.getString("CustomEntityEditForm.title")); //$NON-NLS-1$

	
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
	codeLabel.setText(Messages.getString("CustomEntityEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	codeField.setLayoutData(new GridData(200, SWT.DEFAULT));
    	codeField.setTextLimit(30); //64
    	
    	
    	nameLabel = new Label(composite, SWT.NONE);
	nameLabel.setText(Messages.getString("CustomEntityEditForm.nameLabel.text")); //$NON-NLS-1$
	
    	nameField = new XTextField(composite, SWT.BORDER);
    	nameField.setLayoutData(new GridData(200, SWT.DEFAULT));
    	nameField.setTextLimit(30); //50
    	

    	packageLabel = new Label(composite, SWT.NONE);
    	packageLabel.setText(Messages.getString("CustomEntityEditForm.packageLabel.text")); //$NON-NLS-1$

    	packageField = new XTextField(composite, SWT.BORDER);
    	packageField.setLayoutData(new GridData(200, SWT.DEFAULT));
    	packageField.setTextLimit(30); //64
    	
    	this.setSize(new Point(470, 264));
    	
    	
    	////----
    	//if (!isEditableAttribute()) {
    	//    return;
    	//}
    	
    	itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
  
    	createItemPanel();
    	AttributeView attributeView = new AttributeView(tabFolder, EntityConfig.class);
    	
    	registerEntityProvider(tabFolder.getItem(0), attributeView.getEntityProvider());
    
    }
    
    ItemToolBar itemToolPanel;
    
    protected void bindControls() {
	bindControl(codeField, "code", codeLabel, REQUIRED);
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(packageField, "entityPackage");	
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
    
    protected IEntityConfig getEntityConfig() {
	return (IEntityConfig) getEntity();
    }

    public void updateForm() throws ApplicationException {
	boolean editableHeader = isEditableHeader();
	codeField.setEditable(editableHeader);
	nameField.setEditable(editableHeader);
	packageField.setEditable(editableHeader);
	
	if (editableHeader && !isAddMode()) {
	    codeField.setEditable(false);
	}
	
   	if (!isEditableAttribute()) {
   	    ((GridData) itemToolPanel.getLayoutData()).exclude = true;
   	    itemToolPanel.setVisible(false);
   	    
   	    ((GridData) itemPanel.getLayoutData()).exclude = true;
   	    itemPanel.setVisible(false);
   	    
   	    layout();
    	}
	
	super.updateForm();
    }
    
    public void updateData() throws ApplicationException {
	super.updateData();
	
	if (isAddMode()) {
	    IEntityConfig entityConfig = getEntityConfig();
	    entityConfig.setId(entityConfig.getCode());
	}
    }
    
    protected boolean isCustom() {
	return getEntityConfig().isCustom();
    }
    
    protected boolean isCustomAttribute() {
	return getEntityConfig().isCustomAttribute();
    }
    
    protected boolean isEditableHeader() {
	return isCustom();
    }
    
    protected boolean isEditableAttribute() {
	return isCustomAttribute();
    }
    
    protected String getCurrentEntityTypeCode() {
	IEntityProvider type = getCurrentEntityProvider();
	if (type == null || type.getEntityCode() == null) {
	    return null;
	}
	return type.getEntityCode();
    }
   
    
    protected void initData() throws ApplicationException {
	super.initData();

	//if (isCustom()) {
	    String code = getCurrentEntityTypeCode();
	    IEntityTypeConfig type = getSystemEntityService().findEntityTypeById(code);
	    
	    IEntityConfig entityConfig = (IEntityConfig) getEntity();
	    entityConfig.setEntityType(type);
	    
	    entityConfig.setEnabled(true);
	    
	    entityConfig.setMaster(true);
	    entityConfig.setBean(true);
	    entityConfig.setForm(true);
	    
	    entityConfig.setCustom(type.isCustom());
	    entityConfig.setCustomAttribute(type.isCustomAttribute());
	//};

    }
    
    protected Object getSelectedEntityProviderKey() {
        int index = tabFolder.getSelectionIndex();
        return tabFolder.getItem(index);
    }
    
    
    protected void createData() throws ApplicationException {
	super.createData();
    }
    
    protected void loadData() throws ApplicationException {
	super.loadData();
    }
    
    protected void storeData() throws ApplicationException {
	super.storeData();
    }
    
    protected SystemEntityService getSystemEntityService() {
	return (SystemEntityService) getService(SystemEntityService.class);
    }
    
    
}  //  @jve:decl-index=0:visual-constraint="10,10"

