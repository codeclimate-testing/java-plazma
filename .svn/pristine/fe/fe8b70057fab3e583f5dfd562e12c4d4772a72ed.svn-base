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
 * Created on 13.06.2007
 *
 */

package org.plazmaforge.bsolution.product.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.product.common.beans.ProductGroup;
import org.plazmaforge.bsolution.product.common.beans.ProductType;
import org.plazmaforge.bsolution.product.common.services.ProductTypeService;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.controls.XTreeComboEdit;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.EntityService;

/** 
 * @author Oleh Hapon
 * $Id: ProductGroupEditForm.java,v 1.5 2010/12/05 07:57:23 ohapon Exp $
 */

public class ProductGroupEditForm extends AbstractEditForm {

    private Label codeLabel;

    private Label nameLabel;

    private Label productTypeLabel;

    private Label parentLabel;
    
    
    private XTextField codeField;
    
    private XTextField nameField;
    
    private XComboEdit productTypeField;
    
    private XTreeComboEdit parentField;

  
    private ProductType defaultProductType;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public ProductGroupEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("ProductGroupEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	codeLabel = new Label(this, SWT.NONE);
	codeLabel.setText(Messages.getString("ProductGroupEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(100, SWT.DEFAULT);
    	codeField.setLayoutData(gridData);
    	codeField.setTextLimit(20);
    	

    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("ProductGroupEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 300;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(100);

	productTypeLabel = new Label(this, SWT.NONE);
	productTypeLabel.setText(Messages.getString("ProductGroupEditForm.productTypeLabel.text")); //$NON-NLS-1$
    	
	productTypeField = new XComboEdit(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	productTypeField.setLayoutData(gridData);
    	
	parentLabel = new Label(this, SWT.NONE);
	parentLabel.setText(Messages.getString("ProductGroupEditForm.parentLabel.text")); //$NON-NLS-1$
    	
    	parentField = new XTreeComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	parentField.setLayoutData(gridData);
    	
    	parentField.setEntityClass(ProductGroup.class);
    	parentField.setValueClass(ProductGroup.class);
    	
      	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(productTypeField, "productType", productTypeLabel, REQUIRED);
    }

    public void updateForm() throws ApplicationException {
	super.updateForm();
	
	parentField.init();
	Integer parentId = getProductGroup().getParentId();
	ProductGroup parent = parentId == null ? null : (ProductGroup) getProductGroupService().findById(parentId);
	parentField.setValue(parent);
    }

    public void updateData() throws ApplicationException {
	super.updateData();
	ProductGroup parent = (ProductGroup) parentField.getValue();
	Integer parentId = parent == null ? null : parent.getId();
	getProductGroup().setParentId(parentId);
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	ProductType productType = getDefaultProductType();
	((ProductGroup) getEntity()).setProductType(productType);
    }
    private ProductGroup getProductGroup() {
	return (ProductGroup) getEntity();
    }
    
    private EntityService getProductGroupService() {
	return (EntityService) getEntityService();
    }
    
    private ProductType getDefaultProductType() throws ApplicationException {
	if (defaultProductType == null){
	    defaultProductType = (ProductType) ((EntityService) getService(ProductTypeService.class)).findById(ProductType.GOODS); 
	}
	return defaultProductType;
	
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
