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
 * Created on 04.04.2007
 *
 */

package org.plazmaforge.bsolution.payroll.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/** 
 * @author Oleh Hapon
 * $Id: PayrollEditForm.java,v 1.4 2010/04/28 06:31:06 ohapon Exp $
 */

public class PayrollEditForm extends AbstractEditForm {


    private Label codeLabel;

    private Label nameLabel;
    
    private Label payrollTypeLabel;
    
    private Label payrollAlgoritmTypeLabel;
    
    private Label payrollAlgoritmLabel;
    
    private Label payrollGroupLabel;
    
    private Label priorityLabel;
    
    private Label payrollPercentLabel;
    
    private Label payrollModeLabel;

    
    private XTextField codeField;

    private XTextField nameField;
    
    private XComboEdit payrollTypeField;
    
    private XComboEdit payrollAlgoritmTypeField;

    private XComboEdit payrollAlgoritmField;
    
    private XComboEdit payrollGroupField;
    
    private XIntegerField priorityField;
    
    private XNumberField payrollPercentField;
    
    private XComboEdit payrollModeField;
    
    
    
    private XCheckBox timeField;

    private XCheckBox fundHelpField;

    private XCheckBox pensionField ;

    private XCheckBox fundInsuranceField;

    private XCheckBox taxField;

    private XCheckBox fundWorkField;

    private XCheckBox vacationField;

    private XCheckBox salary13Field;

    private XCheckBox sickField ;

    private XCheckBox salary12Field;

    private XCheckBox fundSalaryField;

    private XCheckBox addPayField;
    
    
   
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PayrollEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	TabItem noteTabItem;
	Composite generalComposite;
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	
	
	setTitle(Messages.getString("PayrollEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("PayrollEditForm.generalTabItem.text")); //$NON-NLS-1$

    	generalComposite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
     	
    	gridLayout.numColumns = 2;
    	generalComposite.setLayout(gridLayout);
    	generalTabItem.setControl(generalComposite);

    	codeLabel = new Label(generalComposite, SWT.NONE);
    	codeLabel.setText(Messages.getString("PayrollEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(generalComposite, SWT.BORDER);
    	final GridData gridData_1 = new GridData(200, SWT.DEFAULT);
    	codeField.setLayoutData(gridData_1);
    	codeField.setTextLimit(10);
    	
    	nameLabel = new Label(generalComposite, SWT.NONE);
    	nameLabel.setLayoutData(new GridData());
    	nameLabel.setText(Messages.getString("PayrollEditForm.nameLabel.text")); //$NON-NLS-1$
    
    	nameField = new XTextField(generalComposite, SWT.BORDER);
    	final GridData gridData_2 = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData_2.widthHint = 300;
    	nameField.setLayoutData(gridData_2);
    	nameField.setTextLimit(100);

    	payrollTypeLabel = new Label(generalComposite, SWT.NONE);
    	payrollTypeLabel.setLayoutData(new GridData());
    	payrollTypeLabel.setText(Messages.getString("PayrollEditForm.payrollTypeLabel.text")); //$NON-NLS-1$

    	payrollTypeField = new XComboEdit(generalComposite, SWT.BORDER);
    	final GridData gridData = new GridData(200, SWT.DEFAULT);
    	payrollTypeField.setLayoutData(gridData);

    	payrollAlgoritmTypeLabel = new Label(generalComposite, SWT.NONE);
    	payrollAlgoritmTypeLabel.setLayoutData(new GridData());
    	payrollAlgoritmTypeLabel.setText(Messages.getString("PayrollEditForm.payrollAlgoritmTypeLabel.text")); //$NON-NLS-1$

    	payrollAlgoritmTypeField = new XComboEdit(generalComposite, SWT.BORDER);
    	payrollAlgoritmTypeField.setLayoutData(new GridData(200, SWT.DEFAULT));

    	payrollAlgoritmLabel = new Label(generalComposite, SWT.NONE);
    	payrollAlgoritmLabel.setText(Messages.getString("PayrollEditForm.payrollAlgoritmLabel.text")); //$NON-NLS-1$

    	payrollAlgoritmField = new XComboEdit(generalComposite, SWT.BORDER);
    	payrollAlgoritmField.setLayoutData(new GridData(200, SWT.DEFAULT));

    	payrollGroupLabel = new Label(generalComposite, SWT.NONE);
    	payrollGroupLabel.setText(Messages.getString("PayrollEditForm.payrollGroupLabel.text")); //$NON-NLS-1$

    	payrollGroupField = new XComboEdit(generalComposite, SWT.BORDER);
    	payrollGroupField.setLayoutData(new GridData(200, SWT.DEFAULT));

    	priorityLabel = new Label(generalComposite, SWT.NONE);
    	priorityLabel.setText(Messages.getString("PayrollEditForm.priorityLabel.text")); //$NON-NLS-1$

    	priorityField = new XIntegerField(generalComposite, SWT.BORDER);
    	priorityField.setLayoutData(new GridData(200, SWT.DEFAULT));

    	payrollPercentLabel = new Label(generalComposite, SWT.NONE);
    	payrollPercentLabel.setText(Messages.getString("PayrollEditForm.payrollPercentLabel.text")); //$NON-NLS-1$

    	payrollPercentField = new XNumberField(generalComposite, SWT.BORDER);
    	payrollPercentField.setLayoutData(new GridData(200, SWT.DEFAULT));

    	payrollModeLabel = new Label(generalComposite, SWT.NONE);
    	payrollModeLabel.setText(Messages.getString("PayrollEditForm.payrollModeLabel.text")); //$NON-NLS-1$

    	payrollModeField = new XComboEdit(generalComposite, SWT.BORDER);
    	payrollModeField.setLayoutData(new GridData(200, SWT.DEFAULT));


    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("PayrollEditForm.noteTabItem.text")); //$NON-NLS-1$

    	final Composite acumulateComposite = new Composite(tabFolder, SWT.NONE);
    	final GridLayout gridLayout_1 = new GridLayout();
	gridLayout_1.marginBottom = 10;
	gridLayout_1.marginTop = 10;
	gridLayout_1.horizontalSpacing = 10;
	gridLayout_1.verticalSpacing = 10;
	gridLayout_1.marginHeight = 10;       	
    	gridLayout_1.numColumns = 2;
    	acumulateComposite.setLayout(gridLayout_1);
    	noteTabItem.setControl(acumulateComposite);

    	timeField = new XCheckBox(acumulateComposite, SWT.NONE);
    	timeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	timeField.setText(Messages.getString("PayrollEditForm.timeField.text")); //$NON-NLS-1$

    	fundHelpField = new XCheckBox(acumulateComposite, SWT.NONE);
    	fundHelpField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	fundHelpField.setText(Messages.getString("PayrollEditForm.fundHelpField.text")); //$NON-NLS-1$

    	pensionField = new XCheckBox(acumulateComposite, SWT.NONE);
    	pensionField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	pensionField.setText(Messages.getString("PayrollEditForm.pensionField.text")); //$NON-NLS-1$

    	fundInsuranceField = new XCheckBox(acumulateComposite, SWT.NONE);
    	fundInsuranceField.setText(Messages.getString("PayrollEditForm.fundInsuranceField.text")); //$NON-NLS-1$
    	fundInsuranceField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	taxField = new XCheckBox(acumulateComposite, SWT.NONE);
    	taxField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	taxField.setText(Messages.getString("PayrollEditForm.taxField.text")); //$NON-NLS-1$

    	fundWorkField = new XCheckBox(acumulateComposite, SWT.NONE);
    	fundWorkField.setText(Messages.getString("PayrollEditForm.fundWorkField.text")); //$NON-NLS-1$
    	fundWorkField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	vacationField = new XCheckBox(acumulateComposite, SWT.NONE);
    	vacationField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	vacationField.setText(Messages.getString("PayrollEditForm.vacationField.text")); //$NON-NLS-1$

    	salary13Field = new XCheckBox(acumulateComposite, SWT.NONE);
    	salary13Field.setText(Messages.getString("PayrollEditForm.salary13Field.text")); //$NON-NLS-1$
    	salary13Field.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	sickField = new XCheckBox(acumulateComposite, SWT.NONE);
    	sickField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	sickField.setText(Messages.getString("PayrollEditForm.sickField.text")); //$NON-NLS-1$

    	salary12Field = new XCheckBox(acumulateComposite, SWT.NONE);
    	salary12Field.setText(Messages.getString("PayrollEditForm.salary12Field.text")); //$NON-NLS-1$
    	salary12Field.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	fundSalaryField = new XCheckBox(acumulateComposite, SWT.NONE);
    	fundSalaryField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	fundSalaryField.setText(Messages.getString("PayrollEditForm.fundSalaryField.text")); //$NON-NLS-1$

    	addPayField = new XCheckBox(acumulateComposite, SWT.NONE);
    	addPayField.setText(Messages.getString("PayrollEditForm.addPayField.text")); //$NON-NLS-1$
    	addPayField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	
        	
    	this.setSize(new Point(590, 261));    	
    	
    }
    
   
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(payrollTypeField, "payrollType", payrollTypeLabel, REQUIRED);	
	bindControl(payrollAlgoritmTypeField, "payrollAlgoritmType", payrollAlgoritmTypeLabel, REQUIRED);
	bindControl(payrollAlgoritmField, "payrollAlgoritm");
	bindControl(payrollGroupField, "payrollGroup");
	bindControl(priorityField, "priority");
	bindControl(payrollPercentField, "payrollPercent");	
	bindControl(payrollModeField, "payrollMode", payrollModeLabel, REQUIRED);
	
	bindControl(timeField, "time", Boolean.TYPE);
	bindControl(fundHelpField, "fundHelp", Boolean.TYPE);
	bindControl(pensionField, "pension", Boolean.TYPE);
	bindControl(fundInsuranceField, "fundInsurance", Boolean.TYPE);	
	bindControl(taxField, "tax", Boolean.TYPE);
	bindControl(fundWorkField, "fundWork", Boolean.TYPE);
	bindControl(vacationField, "vacation", Boolean.TYPE);
	bindControl(salary13Field, "salary13", Boolean.TYPE);
	bindControl(sickField, "sick", Boolean.TYPE);
	bindControl(salary12Field, "salary12", Boolean.TYPE);
	bindControl(fundSalaryField, "fundSalary", Boolean.TYPE);
	bindControl(addPayField, "addPay", Boolean.TYPE);
   }

    
       
}  //  @jve:decl-index=0:visual-constraint="10,10"
