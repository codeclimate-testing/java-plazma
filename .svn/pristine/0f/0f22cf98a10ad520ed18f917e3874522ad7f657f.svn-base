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
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeSicklist;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeSicklistAverange;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;

/** 
 * @author Oleh Hapon
 * $Id: EmployeeSicklistEditForm.java,v 1.5 2010/04/28 06:31:06 ohapon Exp $
 */

public class EmployeeSicklistEditForm extends AbstractDocumentEditForm {



    private Label documentNoLabel;
    private Label documentDateLabel;    

    private Label employeeLabel;
    private Label startDateLabel; 
    private Label endDateLabel;
    
    private Label sickTypeLabel;
    private Label sicklisteAverangeTypeLabel;
    
    private Label quarterPremiumLabel;
    private Label singlePremiumLabel;
    private Label yearPremiumLabel;
    private Label averangeAmountLabel;
    
    private Label sicklistPercentLabel;
    private Label responsibleLabel;
 
    
    private XTextField documentNoField;
    private XDateCombo documentDateField;
 
    private XComboEdit employeeField; 
    private XDateCombo startDateField;
    private XDateCombo endDateField;
    
    private XComboEdit sickTypeField;
    private XComboEdit sicklistAverangeTypeField;
    
    private XCurrencyField quarterPremiumField;
    private XCurrencyField singlePremiumField;
    private XCurrencyField yearPremiumField;
    private XCurrencyField averangeAmountField;
	
    private XCurrencyField sicklistPercentField;
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
    public EmployeeSicklistEditForm(Composite parent, int style) {
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
	
	setTitle(Messages.getString("EmployeeSicklistEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("EmployeeSicklistEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("EmployeeSicklistEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	documentNoField.setLayoutData(gridData);
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	documentDateLabel.setLayoutData(gridData);
	documentDateLabel.setText(Messages.getString("EmployeeSicklistEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	documentDateField.setLayoutData(gridData);
    	
    	
    	employeeLabel = new Label(composite, SWT.NONE);
	employeeLabel.setText(Messages.getString("EmployeeSicklistEditForm.employeeLabel.text")); //$NON-NLS-1$

    	employeeField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	employeeField.setLayoutData(gridData);
    	
	//    	
    	startDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	startDateLabel.setLayoutData(gridData);
    	startDateLabel.setText(Messages.getString("EmployeeSicklistEditForm.startDateLabel.text")); //$NON-NLS-1$

    	startDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	startDateField.setLayoutData(gridData);

    	
    	
    	endDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	endDateLabel.setLayoutData(gridData);
    	endDateLabel.setText(Messages.getString("EmployeeSicklistEditForm.endDateLabel.text")); //$NON-NLS-1$

    	endDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	endDateField.setLayoutData(gridData);
    	//
    	
    	    	
    	//
   	sickTypeLabel = new Label(composite, SWT.NONE);
    	sickTypeLabel.setText(Messages.getString("EmployeeSicklistEditForm.sickTypeLabel.text")); //$NON-NLS-1$

    	sickTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	sickTypeField.setLayoutData(gridData);
	
    	//
	sicklisteAverangeTypeLabel = new Label(composite, SWT.NONE);
	sicklisteAverangeTypeLabel.setText(Messages.getString("EmployeeSicklistEditForm.sicklisteAverangeTypeLabel.text")); //$NON-NLS-1$

	sicklistAverangeTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	sicklistAverangeTypeField.setLayoutData(gridData);
    	    	
	
	//
	quarterPremiumLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	quarterPremiumLabel.setLayoutData(gridData);
    	quarterPremiumLabel.setText(Messages.getString("EmployeeSicklistEditForm.quarterPremiumLabel.text")); //$NON-NLS-1$

    	quarterPremiumField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	quarterPremiumField.setLayoutData(gridData);

    	
    	
    	singlePremiumLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	singlePremiumLabel.setLayoutData(gridData);
    	singlePremiumLabel.setText(Messages.getString("EmployeeSicklistEditForm.singlePremiumLabel.text")); //$NON-NLS-1$

    	singlePremiumField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	singlePremiumField.setLayoutData(gridData);
    	//
    	
    	
    	
    	//
	yearPremiumLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	yearPremiumLabel.setLayoutData(gridData);
    	yearPremiumLabel.setText(Messages.getString("EmployeeSicklistEditForm.yearPremiumLabel.text")); //$NON-NLS-1$

    	yearPremiumField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	yearPremiumField.setLayoutData(gridData);

    	
    	
    	averangeAmountLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 10;
    	averangeAmountLabel.setLayoutData(gridData);
    	averangeAmountLabel.setText(Messages.getString("EmployeeSicklistEditForm.averangeAmountLabel.text")); //$NON-NLS-1$

    	averangeAmountField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	averangeAmountField.setLayoutData(gridData);
    	//
    	
    	//
	sicklistPercentLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	sicklistPercentLabel.setLayoutData(gridData);
    	sicklistPercentLabel.setText(Messages.getString("EmployeeSicklistEditForm.sicklistPercentLabel.text")); //$NON-NLS-1$

    	sicklistPercentField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	sicklistPercentField.setLayoutData(gridData);
  
    	// 
    	new Label(composite, SWT.NONE); new Label(composite, SWT.NONE);
    	//
    	
	responsibleLabel = new Label(composite, SWT.NONE);
	responsibleLabel.setText(Messages.getString("EmployeeVacationEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	responsibleField.setLayoutData(gridData);
    	
    	//
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("EmployeeSicklistEditForm.noteTabItem.text")); //$NON-NLS-1$

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
	
		
	bindControl(sickTypeField, "sickType", sickTypeLabel, REQUIRED);
	bindControl(sicklistAverangeTypeField, "sicklistAverangeType", sicklisteAverangeTypeLabel, REQUIRED);
		    
	bindControl(quarterPremiumField ,"quarterPremium");
	bindControl(singlePremiumField, "singlePremium");
	bindControl(yearPremiumField, "yearPremium");
	bindControl(averangeAmountField, "averangeAmount");
	bindControl(sicklistPercentField, "sicklistPercent");
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
        averangeTabItem.setText(Messages.getString("EmployeeSicklistEditForm.averangeTabItem.text")); //$NON-NLS-1$

         
        averangeTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        averangeTable.setHeaderVisible(true);
        averangeTable.setLinesVisible(true);
        averangeTabItem.setControl(averangeTable);

   
        TableColumn tableColumn = new TableColumn(averangeTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn monthColumn = new TableColumn(averangeTable, SWT.CENTER);
        monthColumn.setWidth(100);
        monthColumn.setText(Messages.getString("EmployeeSicklistEditForm.monthColumn.text")); //$NON-NLS-1$

        TableColumn workDayColumn = new TableColumn(averangeTable, SWT.CENTER);
        workDayColumn.setWidth(100);
        workDayColumn.setText(Messages.getString("EmployeeSicklistEditForm.workDayColumn.text")); //$NON-NLS-1$

        TableColumn amountColumn = new TableColumn(averangeTable, SWT.CENTER);
        amountColumn.setWidth(100);
        amountColumn.setText(Messages.getString("EmployeeSicklistEditForm.amountColumn.text")); //$NON-NLS-1$
        
             
    
    }
    
    
       
    protected class AverangeItemProvider extends TableEntityProvider {
	
	public AverangeItemProvider() {
	    setParentEntityClass(EmployeeSicklist.class); // OWNER
	    setEntityClass(EmployeeSicklistAverange.class); // FORM ID
	    setListProperty("averangeItems");
	    setAddMethod("addAverangeItem");
	}
	
	protected Table getTable() {
	    return averangeTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "month");
	    bindColumn(2, "workDay");
	    bindColumn(3, "amount", getCurrencyFormat());
	}
    }
    
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }
    
    

    
}  //  @jve:decl-index=0:visual-constraint="10,10"


