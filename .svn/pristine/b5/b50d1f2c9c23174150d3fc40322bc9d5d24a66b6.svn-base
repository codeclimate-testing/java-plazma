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
 * Created on 12.07.2007
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.document.client.swt.forms.AbstractDocumentEditForm;
import org.plazmaforge.bsolution.employee.common.beans.Employee;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeVacation;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeVacationAverange;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;

/** 
 * @author Oleh Hapon
 * $Id: EmployeeVacationEditForm.java,v 1.4 2010/04/28 06:31:06 ohapon Exp $
 */

public class EmployeeVacationEditForm extends AbstractDocumentEditForm {



    private Label documentNoLabel;
    private Label documentDateLabel;    

    private Label employeeLabel;
    private Label startDateLabel; 
    private Label endDateLabel;
    private Label dayLabel; 
    private Label addDayLabel; 
    private Label workStartDateLabel; 
    private Label workEndDateLabel;
    
    private Label vacationTypeLabel;
    private Label vacationAverangeTypeLabel;
    private Label vacationCalculateLabel;
    private Label addVacationCalculateLabel;
    
    private Label quarterPremiumLabel;
    private Label singlePremiumLabel;
    private Label yearPremiumLabel;
    private Label averangeAmountLabel;
    private Label responsibleLabel;
 
    
    private XTextField documentNoField;
    private XDateCombo documentDateField;
 
    private XComboEdit employeeField; 
    private XDateCombo startDateField;
    private XDateCombo endDateField;
    private XIntegerField dayField;
    private XIntegerField addDayField;
    private XDateCombo workStartDateField;
    private XDateCombo workEndDateField;
    
    private XComboEdit vacationTypeField;
    private XComboEdit vacationAverangeTypeField;
    private XComboEdit vacationCalculateField;
    private XComboEdit addVacationCalculateField;
    
    private XCurrencyField quarterPremiumField;
    private XCurrencyField singlePremiumField;
    private XCurrencyField yearPremiumField;
    private XCurrencyField averangeAmountField;
    private XComboEdit responsibleField;
    
    private XTextArea noteField;
    
    private Composite itemsPanel;
    private TabFolder itemsTabFolder;
    private Table averangeTable;
    

    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public EmployeeVacationEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	TabItem noteTabItem;
	Composite composite;
	
	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	
	
	setTitle(Messages.getString("EmployeeVacationEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("EmployeeVacationEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("EmployeeVacationEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	documentNoField.setLayoutData(gridData);
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	documentDateLabel.setLayoutData(gridData);
	documentDateLabel.setText(Messages.getString("EmployeeVacationEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	documentDateField.setLayoutData(gridData);
    	
    	
    	employeeLabel = new Label(composite, SWT.NONE);
	employeeLabel.setText(Messages.getString("EmployeeVacationEditForm.employeeLabel.text")); //$NON-NLS-1$

    	employeeField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	employeeField.setLayoutData(gridData);
    	
	//    	
    	startDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	startDateLabel.setLayoutData(gridData);
    	startDateLabel.setText(Messages.getString("EmployeeVacationEditForm.startDateLabel.text")); //$NON-NLS-1$

    	startDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	startDateField.setLayoutData(gridData);

    	
    	
    	endDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	endDateLabel.setLayoutData(gridData);
    	endDateLabel.setText(Messages.getString("EmployeeVacationEditForm.endDateLabel.text")); //$NON-NLS-1$

    	endDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	endDateField.setLayoutData(gridData);
    	//
    	
    	
    	//
	dayLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	dayLabel.setLayoutData(gridData);
    	dayLabel.setText(Messages.getString("EmployeeVacationEditForm.dayLabel.text")); //$NON-NLS-1$

    	dayField = new XIntegerField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	dayField.setLayoutData(gridData);

    	
    	
    	addDayLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	addDayLabel.setLayoutData(gridData);
    	addDayLabel.setText(Messages.getString("EmployeeVacationEditForm.addDayLabel.text")); //$NON-NLS-1$

    	addDayField = new XIntegerField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	addDayField.setLayoutData(gridData);
    	//
    	
    	
    	
	//    	
    	workStartDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	workStartDateLabel.setLayoutData(gridData);
    	workStartDateLabel.setText(Messages.getString("EmployeeVacationEditForm.workStartDateLabel.text")); //$NON-NLS-1$

    	workStartDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	workStartDateField.setLayoutData(gridData);

    	
    	
    	workEndDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	workEndDateLabel.setLayoutData(gridData);
    	workEndDateLabel.setText(Messages.getString("EmployeeVacationEditForm.workEndDateLabel.text")); //$NON-NLS-1$

    	workEndDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	workEndDateField.setLayoutData(gridData);
    	
    	//
   	vacationTypeLabel = new Label(composite, SWT.NONE);
    	vacationTypeLabel.setText(Messages.getString("EmployeeVacationEditForm.vacationTypeLabel.text")); //$NON-NLS-1$

    	vacationTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	vacationTypeField.setLayoutData(gridData);
	
    	//
	vacationAverangeTypeLabel = new Label(composite, SWT.NONE);
	vacationAverangeTypeLabel.setText(Messages.getString("EmployeeVacationEditForm.vacationAverangeTypeLabel.text")); //$NON-NLS-1$

	vacationAverangeTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	vacationAverangeTypeField.setLayoutData(gridData);
    	
    	//
	vacationCalculateLabel = new Label(composite, SWT.NONE);
	vacationCalculateLabel.setText(Messages.getString("EmployeeVacationEditForm.vacationCalculateLabel.text")); //$NON-NLS-1$

	vacationCalculateField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	vacationCalculateField.setLayoutData(gridData);
    	
    	//
	addVacationCalculateLabel = new Label(composite, SWT.NONE);
	addVacationCalculateLabel.setText(Messages.getString("EmployeeVacationEditForm.addVacationCalculateLabel.text")); //$NON-NLS-1$

	addVacationCalculateField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	addVacationCalculateField.setLayoutData(gridData);
    	
	
	//
	quarterPremiumLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	quarterPremiumLabel.setLayoutData(gridData);
    	quarterPremiumLabel.setText(Messages.getString("EmployeeVacationEditForm.quarterPremiumLabel.text")); //$NON-NLS-1$

    	quarterPremiumField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	quarterPremiumField.setLayoutData(gridData);

    	
    	
    	singlePremiumLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	singlePremiumLabel.setLayoutData(gridData);
    	singlePremiumLabel.setText(Messages.getString("EmployeeVacationEditForm.singlePremiumLabel.text")); //$NON-NLS-1$

    	singlePremiumField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	singlePremiumField.setLayoutData(gridData);
    	//
    	
    	
    	
    	//
	yearPremiumLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	yearPremiumLabel.setLayoutData(gridData);
    	yearPremiumLabel.setText(Messages.getString("EmployeeVacationEditForm.yearPremiumLabel.text")); //$NON-NLS-1$

    	yearPremiumField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	yearPremiumField.setLayoutData(gridData);

    	
    	
    	averangeAmountLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	averangeAmountLabel.setLayoutData(gridData);
    	averangeAmountLabel.setText(Messages.getString("EmployeeVacationEditForm.averangeAmountLabel.text")); //$NON-NLS-1$

    	averangeAmountField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	averangeAmountField.setLayoutData(gridData);
    	
    	//
    	
	responsibleLabel = new Label(composite, SWT.NONE);
	responsibleLabel.setText(Messages.getString("EmployeeVacationEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	responsibleField.setLayoutData(gridData);    	
    	
    	//
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("EmployeeVacationEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);
    	
    	noteTabItem.setControl(noteField);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	
   	
    	this.setSize(new Point(600, 350));    	

 	
    	employeeField.setAssociationValueClass(Employee.class);
    	initResponsibleField(responsibleField);
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new AverangeItemProvider());
    }
    
   
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(employeeField, "employee", employeeLabel, REQUIRED);
	bindControl(startDateField, "startDate", startDateLabel, REQUIRED);
	bindControl(endDateField, "endDate", endDateLabel, REQUIRED);
	
	bindControl(dayField, "dayDate");
	bindControl(addDayField, "addDayDate");
	
	bindControl(workStartDateField, "workStartDate");
	bindControl(workEndDateField, "workEndDate");
	
	bindControl(vacationTypeField, "vacationType", vacationTypeLabel, REQUIRED);
	bindControl(vacationAverangeTypeField, "vacationAverangeType", vacationAverangeTypeLabel, REQUIRED);
	bindControl(vacationCalculateField, "vacationCalculate", vacationCalculateLabel, REQUIRED);
	bindControl(addVacationCalculateField, "addVacationCalculate");
	    
	    
	bindControl(quarterPremiumField ,"quarterPremium");
	bindControl(singlePremiumField, "singlePremium");
	bindControl(yearPremiumField, "yearPremium");
	bindControl(averangeAmountField, "averangeAmount");
	bindControl(responsibleField, "responsible");
	
	bindControl(noteField, "note");
    }

    
    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
 
        GridLayout gridLayout;
        TabItem averangeTabItem;
        
          
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 181;
        
        
        itemsPanel = new Composite(this, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        
        itemsPanel.setLayout(gridLayout);
        itemsPanel.setLayoutData(gridData);
        

        
        itemsTabFolder = new TabFolder(itemsPanel, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.widthHint = 520;
        itemsTabFolder.setLayoutData(gridData);

        averangeTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        averangeTabItem.setText(Messages.getString("EmployeeVacationEditForm.averangeTabItem.text")); //$NON-NLS-1$

         
        averangeTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        averangeTable.setHeaderVisible(true);
        averangeTable.setLinesVisible(true);
        averangeTabItem.setControl(averangeTable);

   
        TableColumn tableColumn = new TableColumn(averangeTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn monthColumn = new TableColumn(averangeTable, SWT.CENTER);
        monthColumn.setWidth(100);
        monthColumn.setText(Messages.getString("EmployeeVacationEditForm.monthColumn.text")); //$NON-NLS-1$

        TableColumn workDayColumn = new TableColumn(averangeTable, SWT.CENTER);
        workDayColumn.setWidth(100);
        workDayColumn.setText(Messages.getString("EmployeeVacationEditForm.workDayColumn.text")); //$NON-NLS-1$

        TableColumn vacationDayColumn = new TableColumn(averangeTable, SWT.CENTER);
        vacationDayColumn.setWidth(100);
        vacationDayColumn.setText(Messages.getString("EmployeeVacationEditForm.vacationDayColumn.text")); //$NON-NLS-1$

        TableColumn addVacationDayColumn = new TableColumn(averangeTable, SWT.CENTER);
        addVacationDayColumn.setWidth(100);
        addVacationDayColumn.setText(Messages.getString("EmployeeVacationEditForm.addVacationDayColumn.text")); //$NON-NLS-1$
         
        TableColumn amountColumn = new TableColumn(averangeTable, SWT.CENTER);
        amountColumn.setWidth(100);
        amountColumn.setText(Messages.getString("EmployeeVacationEditForm.amountColumn.text")); //$NON-NLS-1$
        
             
    
    }
    
    
       
    protected class AverangeItemProvider extends TableEntityProvider {
	
	public AverangeItemProvider() {
	    setParentEntityClass(EmployeeVacation.class); // OWNER
	    setEntityClass(EmployeeVacationAverange.class); // FORM ID
	    setListProperty("averangeItems");
	    setAddMethod("addAverangeItem");
	}
	
	protected Table getTable() {
	    return averangeTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "month");
	    bindColumn(2, "workDay");
	    bindColumn(3, "vacationDay");
	    bindColumn(4, "addVacationDay");
	    bindColumn(5, "amount", getCurrencyFormat());
	}
    }
    
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }
    
    

    
}  //  @jve:decl-index=0:visual-constraint="10,10"


