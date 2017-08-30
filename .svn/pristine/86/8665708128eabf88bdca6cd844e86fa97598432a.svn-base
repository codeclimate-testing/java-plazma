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

package org.plazmaforge.bsolution.employee.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.bsolution.document.client.swt.forms.AbstractDocumentEditForm;
import org.plazmaforge.bsolution.personality.common.beans.Person;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextField;

/** 
 * @author Oleh Hapon
 * $Id: EmployeeReceptionEditForm.java,v 1.3 2010/04/28 06:31:04 ohapon Exp $
 */

public class EmployeeReceptionEditForm extends AbstractDocumentEditForm {



    private Label documentNoLabel;
    
    private Label documentDateLabel;
    
    private Label personLabel;
    
    private Label employeeCodeLabel;
    
    private Label departmentLabel;
    
    private Label receptionDateLabel;
    
    private Label employeeCategoryLabel;
    
    private Label employeeRankLabel;
    
    private Label payrollFormLabel;
    
    private Label salaryLabel;
    
    private Label tariffLabel;
    
    private Label premiumPercentLabel;
    
    private Label sickPercentLabel;
    
    private Label responsibleLabel;
    
    
    private XTextField documentNoField;
    
    private XDateCombo documentDateField;
    
    private XComboEdit personField;
    
    private XTextField employeeCodeField;
    
    private XComboEdit departmentField;
    
    private XDateCombo receptionDateField;
    
    private XComboEdit employeeCategoryField;
    
    private XComboEdit employeeRankField;
    
    private XComboEdit payrollFormField;
    
    private XCurrencyField salaryField;
    
    private XCurrencyField tariffField;
    
    private XCurrencyField premiumPercentField;
    
    private XCurrencyField sickPercentField;
    
    private XComboEdit responsibleField;
     
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public EmployeeReceptionEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	TabItem accountingTabItem;
	
	Composite composite;
	
	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	
	
	setTitle(Messages.getString("EmployeeReceptionEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("EmployeeReceptionEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	 	
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("EmployeeReceptionEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	documentNoField.setLayoutData(gridData);
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	documentDateLabel.setLayoutData(gridData);
    	documentDateLabel.setText(Messages.getString("EmployeeReceptionEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	documentDateField.setLayoutData(gridData);

    	personLabel = new Label(composite, SWT.NONE);
	personLabel.setText(Messages.getString("EmployeeReceptionEditForm.personLabel.text")); //$NON-NLS-1$

    	personField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	personField.setLayoutData(gridData);

    	employeeCodeLabel = new Label(composite, SWT.NONE);
    	employeeCodeLabel.setText(Messages.getString("EmployeeReceptionEditForm.employeeCodeLabel.text")); //$NON-NLS-1$

    	employeeCodeField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	employeeCodeField.setLayoutData(gridData);
    	employeeCodeField.setTextLimit(20);
    	
    	receptionDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	receptionDateLabel.setLayoutData(gridData);
 	receptionDateLabel.setText(Messages.getString("EmployeeReceptionEditForm.receptionDateLabel.text")); //$NON-NLS-1$

 	receptionDateField = new XDateCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	receptionDateField.setLayoutData(gridData);

    	
    	departmentLabel = new Label(composite, SWT.NONE);
    	departmentLabel.setText(Messages.getString("EmployeeReceptionEditForm.departmentLabel.text")); //$NON-NLS-1$

    	departmentField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	departmentField.setLayoutData(gridData);
   
 	
	responsibleLabel = new Label(composite, SWT.NONE);
	responsibleLabel.setText(Messages.getString("EmployeeDischargeEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	responsibleField.setLayoutData(gridData);

    	
    	
    	///---
    	
    	accountingTabItem = new TabItem(tabFolder, SWT.NONE);
    	accountingTabItem.setText(Messages.getString("EmployeeReceptionEditForm.accountingTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	 	
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	accountingTabItem.setControl(composite);
    	
    	employeeCategoryLabel = new Label(composite, SWT.NONE);
    	employeeCategoryLabel.setText(Messages.getString("EmployeeReceptionEditForm.employeeCategoryLabel.text")); //$NON-NLS-1$

    	employeeCategoryField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	gridData.widthHint = 100;
    	employeeCategoryField.setLayoutData(gridData);
    	

    	
    	employeeRankLabel = new Label(composite, SWT.NONE);
    	employeeRankLabel.setText(Messages.getString("EmployeeReceptionEditForm.employeeRankLabel.text")); //$NON-NLS-1$

    	employeeRankField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	gridData.widthHint = 100;
    	employeeRankField.setLayoutData(gridData);

    	
    	
 	payrollFormLabel = new Label(composite, SWT.NONE);
 	payrollFormLabel.setText(Messages.getString("EmployeeReceptionEditForm.payrollFormLabel.text")); //$NON-NLS-1$

 	payrollFormField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	gridData.widthHint = 100;
    	payrollFormField.setLayoutData(gridData);
    	
    	//
    	salaryLabel = new Label(composite, SWT.NONE);
    	salaryLabel.setText(Messages.getString("EmployeeReceptionEditForm.salaryLabel.text")); //$NON-NLS-1$

    	salaryField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	salaryField.setLayoutData(gridData);
    	
    	//
    	tariffLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	tariffLabel.setLayoutData(gridData);
    	tariffLabel.setText(Messages.getString("EmployeeReceptionEditForm.tariffLabel.text")); //$NON-NLS-1$

    	tariffField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	tariffField.setLayoutData(gridData);
    	
    	//
    	premiumPercentLabel = new Label(composite, SWT.NONE);
    	premiumPercentLabel.setText(Messages.getString("EmployeeReceptionEditForm.premiumPercentLabel.text")); //$NON-NLS-1$

    	premiumPercentField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	premiumPercentField.setLayoutData(gridData);
    	
    	//
    	sickPercentLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	sickPercentLabel.setLayoutData(gridData);
    	sickPercentLabel.setText(Messages.getString("EmployeeReceptionEditForm.sickPercentLabel.text")); //$NON-NLS-1$

    	sickPercentField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	sickPercentField.setLayoutData(gridData);
    	

    	this.setSize(new Point(600, 350));    	
    	
    	personField.setAssociationValueClass(Person.class);  
    	initResponsibleField(responsibleField);
    }
    
   
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(personField, "person", personLabel, REQUIRED);
	bindControl(employeeCodeField, "employeeCode");
	bindControl(departmentField, "department");
	bindControl(receptionDateField, "receptionDate", receptionDateLabel, REQUIRED);
	
	bindControl(employeeCategoryField, "employeeCategory");
	bindControl(employeeRankField, "employeeRank");
	bindControl(payrollFormField, "payrollForm");
	
	bindControl(salaryField, "salary");
	bindControl(tariffField, "tariff");
	bindControl(premiumPercentField, "premiumPercent");
	bindControl(sickPercentField, "sickPercent");
	bindControl(responsibleField, "responsible");
    }

    
}  //  @jve:decl-index=0:visual-constraint="10,10"


