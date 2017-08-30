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
 * Created on 27.05.2007
 *
 */

package org.plazmaforge.bsolution.employee.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.client.swt.forms.AttributeValueView;
import org.plazmaforge.bsolution.base.client.swt.forms.FileView;
import org.plazmaforge.bsolution.contact.client.swt.forms.EmailEditForm;
import org.plazmaforge.bsolution.contact.client.swt.forms.PhoneEditForm;
import org.plazmaforge.bsolution.contact.common.beans.ContactableItem;
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.employee.common.beans.Employee;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractOrganizableEditForm;
import org.plazmaforge.bsolution.personality.common.beans.Person;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: EmployeeEditForm.java,v 1.5 2010/12/05 07:57:21 ohapon Exp $
 */

public class EmployeeEditForm extends AbstractOrganizableEditForm {



    private Table phoneTable;
    private Table emailTable;    

    
    private Label codeLabel;
    private Label personLabel;
    private Label startDateLabel;  
    private Label endDateLabel;
    private Label departmentLabel;
    private Label positionLabel;
    private Label employeeCategoryLabel;
    private Label taxLabel;    
    
    private XTextField codeField;    
    
    private XComboEdit personField;
    private XDateCombo startDateField;
    private XDateCombo endDateField;
    private XComboEdit departmentField;
    private XComboEdit positionField;
    private XComboEdit employeeCategoryField;    
    private XCheckBox taxField;
    private XTextArea noteField;
 

    
    
    private TabFolder itemTabFolder;
    private Label payrollFormLabel;
    private XComboEdit payrollFormField;
    private Label employeeRankLabel;
    private XComboEdit employeeRankField;
    private Label salaryLabel;
    private XCurrencyField salaryField;
    private Label tariffLabel;
    private XCurrencyField tariffField;
    private Label advanceLabel;
    private XCurrencyField advanceField;
    private Label premiumPercentLabel;
    private XCurrencyField premiumPercentField;
    private Label sickPercentLabel;
    private XCurrencyField sickPercentField;
    private Label stockLabel;
    private XIntegerField stockField;
    private Label employeeAccountLabel;
    private XTextField employeeAccountField;
    private Label totalSeniorityLabel;
    private XIntegerField totalSeniorityYearField;
    private Label totalSeniorityYearLabel;
    private XIntegerField totalSeniorityMonthField;
    private Label totalSeniorityMonthLabel;
    private XIntegerField totalSeniorityDayField;
    private Label totalSeniorityDayLabel;
    private Label unbrokenSeniorityLabel;
    private XIntegerField unbrokenSeniorityYearField;
    private Label unbrokenSeniorityYearLabel;
    private XIntegerField unbrokenSeniorityMonthField;
    private Label unbrokenSeniorityMonthLabel;
    private XIntegerField unbrokenSeniorityDayField;
    private Label unbrokenSeniorityDayLabel;
    
    public EmployeeEditForm(Composite parent, int style) {
	super(parent, style);
	
	initialize();
    }
    
    protected void initialize() {
	setTitle(Messages.getString("EmployeeEditForm.title")); //$NON-NLS-1$
	
	TabFolder tabFolder;
	GridData gridData;
	Composite composite;
	TabItem noteTabItem;
	GridLayout gridLayout;

	Label label;
	gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;		
	setLayout(gridLayout);

       	tabFolder = new TabFolder(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
       	tabFolder.setLayoutData(gridData);

    	TabItem generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("EmployeeEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
		
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	codeLabel = new Label(composite, SWT.NONE);
	codeLabel.setText(Messages.getString("EmployeeEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	codeField.setTextLimit(10);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 100;
    	codeField.setLayoutData(gridData);
    	codeField.setTextLimit(10);
	
    	personLabel = new Label(composite, SWT.NONE);
	personLabel.setText(Messages.getString("EmployeeEditForm.personLabel.text")); //$NON-NLS-1$

    	personField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.EDIT_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	personField.setLayoutData(gridData);

	departmentLabel = new Label(composite, SWT.NONE);
    	departmentLabel.setText(Messages.getString("EmployeeEditForm.departmentLabel.text")); //$NON-NLS-1$

    	departmentField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	departmentField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	
	positionLabel = new Label(composite, SWT.NONE);
	positionLabel.setText(Messages.getString("EmployeeEditForm.positionLabel.text")); //$NON-NLS-1$

	positionField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	positionField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
    	
	employeeCategoryLabel = new Label(composite, SWT.NONE);
	employeeCategoryLabel.setText(Messages.getString("EmployeeEditForm.employeeCategoryLabel.text")); //$NON-NLS-1$

	employeeCategoryField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	employeeCategoryField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	
	
    	startDateLabel = new Label(composite, SWT.NONE);
	startDateLabel.setText(Messages.getString("EmployeeEditForm.startDateLabel.text")); //$NON-NLS-1$

    	startDateField = new XDateCombo(composite, SWT.BORDER);
    	startDateField.setLayoutData(new GridData(100, SWT.DEFAULT));

	//
    	endDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 50;
    	endDateLabel.setLayoutData(gridData);
       	endDateLabel.setText(Messages.getString("EmployeeEditForm.endDateLabel.text")); //$NON-NLS-1$

    	endDateField = new XDateCombo(composite, SWT.BORDER);
    	endDateField.setLayoutData(new GridData(100, SWT.DEFAULT));
	
    	
    	//


	taxLabel = new Label(composite, SWT.NONE);
	taxLabel.setText(Messages.getString("EmployeeEditForm.taxLabel.text")); //$NON-NLS-1$

    	taxField = new XCheckBox(composite, SWT.NONE);
      	
    	//
    	TabItem accountTabItem = new TabItem(tabFolder, SWT.NONE);
    	accountTabItem.setText(Messages.getString("EmployeeEditForm.accountTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
		
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	accountTabItem.setControl(composite);
    	
    	payrollFormLabel = new Label(composite, SWT.NONE);
	payrollFormLabel.setText(Messages.getString("EmployeeEditForm.payrollFormLabel.text")); //$NON-NLS-1$

    	payrollFormField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	payrollFormField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	
	employeeRankLabel = new Label(composite, SWT.NONE);
	employeeRankLabel.setText(Messages.getString("EmployeeEditForm.employeeRankLabel.text")); //$NON-NLS-1$

	employeeRankField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	employeeRankField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
	label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
    	
    	
	salaryLabel = new Label(composite, SWT.NONE);
	salaryLabel.setText(Messages.getString("EmployeeEditForm.salaryLabel.text")); //$NON-NLS-1$
	
	salaryField = new XCurrencyField(composite, SWT.BORDER);
	salaryField.setLayoutData(new GridData(100, SWT.DEFAULT));
	
	tariffLabel = new Label(composite, SWT.NONE);
	tariffLabel.setText(Messages.getString("EmployeeEditForm.tariffLabel.text")); //$NON-NLS-1$
	
	tariffField = new XCurrencyField(composite, SWT.BORDER);
	tariffField.setLayoutData(new GridData(100, SWT.DEFAULT));
	
	advanceLabel = new Label(composite, SWT.NONE);
	advanceLabel.setText(Messages.getString("EmployeeEditForm.advanceLabel.text")); //$NON-NLS-1$
	
	advanceField = new XCurrencyField(composite, SWT.BORDER);
	advanceField.setLayoutData(new GridData(100, SWT.DEFAULT));
	
	new Label(composite, SWT.NONE);
	new Label(composite, SWT.NONE);
	
	label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
    	
	premiumPercentLabel = new Label(composite, SWT.NONE);
	premiumPercentLabel.setText(Messages.getString("EmployeeEditForm.premiumPercentLabel.text")); //$NON-NLS-1$
	
	premiumPercentField = new XCurrencyField(composite, SWT.BORDER);
	premiumPercentField.setLayoutData(new GridData(100, SWT.DEFAULT));
	
	sickPercentLabel = new Label(composite, SWT.NONE);
	sickPercentLabel.setText(Messages.getString("EmployeeEditForm.sickPercentLabel.text")); //$NON-NLS-1$
	
	sickPercentField = new XCurrencyField(composite, SWT.BORDER);
	sickPercentField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	
    	
    	//
    	TabItem seniorityTabItem = new TabItem(tabFolder, SWT.NONE);
    	seniorityTabItem.setText(Messages.getString("EmployeeEditForm.seniorityTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	composite.setLayout(new GridLayout());
    	seniorityTabItem.setControl(composite);
        	
    	
    	Group identityGroup = new Group(composite, SWT.NONE);
    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
		
    	gridLayout.numColumns = 7;
    	
    	identityGroup.setLayout(gridLayout);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.heightHint = 80;
    	identityGroup.setLayoutData(gridData);
    	identityGroup.setText(Messages.getString("EmployeeEditForm.identityGroup.text")); //$NON-NLS-1$
    	
    	
    	totalSeniorityLabel = new Label(identityGroup, SWT.NONE);
	totalSeniorityLabel.setText(Messages.getString("EmployeeEditForm.totalSeniorityLabel.text")); //$NON-NLS-1$
	
	totalSeniorityYearField = new XIntegerField(identityGroup, SWT.BORDER);
	gridData = new GridData(30, SWT.DEFAULT);
	gridData.horizontalIndent = 20;
	totalSeniorityYearField.setLayoutData(gridData); 
	
	totalSeniorityYearLabel = new Label(identityGroup, SWT.NONE);
	totalSeniorityYearLabel.setText(Messages.getString("EmployeeEditForm.totalSeniorityYearLabel.text")); //$NON-NLS-1$
    	
    	totalSeniorityMonthField = new XIntegerField(identityGroup, SWT.BORDER);
	gridData = new GridData(30, SWT.DEFAULT);
	gridData.horizontalIndent = 20;
	totalSeniorityMonthField.setLayoutData(gridData); 
	
	totalSeniorityMonthLabel = new Label(identityGroup, SWT.NONE);
	totalSeniorityMonthLabel.setText(Messages.getString("EmployeeEditForm.totalSeniorityMonthLabel.text")); //$NON-NLS-1$
    	
    	totalSeniorityDayField = new XIntegerField(identityGroup, SWT.BORDER);
	gridData = new GridData(30, SWT.DEFAULT);
	gridData.horizontalIndent = 20;
	totalSeniorityDayField.setLayoutData(gridData); 
	
	totalSeniorityDayLabel = new Label(identityGroup, SWT.NONE);
	totalSeniorityDayLabel.setText(Messages.getString("EmployeeEditForm.totalSeniorityDayLabel.text")); //$NON-NLS-1$
    	
    	//
    	
    	unbrokenSeniorityLabel = new Label(identityGroup, SWT.NONE);
	unbrokenSeniorityLabel.setText(Messages.getString("EmployeeEditForm.unbrokenSeniorityLabel.text")); //$NON-NLS-1$
	
	unbrokenSeniorityYearField = new XIntegerField(identityGroup, SWT.BORDER);
	gridData = new GridData(30, SWT.DEFAULT);
	gridData.horizontalIndent = 20;
	unbrokenSeniorityYearField.setLayoutData(gridData); 
	
	unbrokenSeniorityYearLabel = new Label(identityGroup, SWT.NONE);
	unbrokenSeniorityYearLabel.setText(Messages.getString("EmployeeEditForm.unbrokenSeniorityYearLabel.text")); //$NON-NLS-1$
    	
    	unbrokenSeniorityMonthField = new XIntegerField(identityGroup, SWT.BORDER);
	gridData = new GridData(30, SWT.DEFAULT);
	gridData.horizontalIndent = 20;
	unbrokenSeniorityMonthField.setLayoutData(gridData); 
	
	unbrokenSeniorityMonthLabel = new Label(identityGroup, SWT.NONE);
	unbrokenSeniorityMonthLabel.setText(Messages.getString("EmployeeEditForm.unbrokenSeniorityMonthLabel.text")); //$NON-NLS-1$
    	
    	unbrokenSeniorityDayField = new XIntegerField(identityGroup, SWT.BORDER);
	gridData = new GridData(30, SWT.DEFAULT);
	gridData.horizontalIndent = 20;
	unbrokenSeniorityDayField.setLayoutData(gridData); 
	
	unbrokenSeniorityDayLabel = new Label(identityGroup, SWT.NONE);
	unbrokenSeniorityDayLabel.setText(Messages.getString("EmployeeEditForm.unbrokenSeniorityDayLabel.text")); //$NON-NLS-1$

	//
	
 	Group additionalGroup = new Group(composite, SWT.NONE);
    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
 	
    	gridLayout.numColumns = 4;
    	
    	additionalGroup.setLayout(gridLayout);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, true);
    	//gridData.heightHint = 100;
    	additionalGroup.setLayoutData(gridData);
    	//additionalGroup.setText("Identity");	
	
    	stockLabel = new Label(additionalGroup, SWT.NONE);
	stockLabel.setText(Messages.getString("EmployeeEditForm.stockLabel.text")); //$NON-NLS-1$
	
	stockField = new XIntegerField(additionalGroup, SWT.BORDER);
	stockField.setLayoutData(new GridData(100, SWT.DEFAULT));
	
	employeeAccountLabel = new Label(additionalGroup, SWT.NONE);
	employeeAccountLabel.setText(Messages.getString("EmployeeEditForm.employeeAccountLabel.text")); //$NON-NLS-1$
	
	employeeAccountField = new XTextField(additionalGroup, SWT.BORDER);
	employeeAccountField.setLayoutData(new GridData(100, SWT.DEFAULT));
	employeeAccountField.setTextLimit(10);
	
	
	//--
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("EmployeeEditForm.noteTabItem.text")); //$NON-NLS-1$

    	
    	noteField = new XTextArea(tabFolder, SWT.NONE | SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

	noteTabItem.setControl(noteField);

    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);

    	createItemPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemTabFolder, Employee.class);
    	FileView fileView = new FileView(itemTabFolder, Employee.class);
    	
    	personField.setAssociationValueClass(Person.class);
    	
     	registerEntityProvider(itemTabFolder.getItem(0), new PhoneProvider());
    	registerEntityProvider(itemTabFolder.getItem(1), new EmailProvider());
    	registerEntityProvider(itemTabFolder.getItem(2), attributeView.getEntityProvider());
    	registerEntityProvider(itemTabFolder.getItem(3), fileView.getEntityProvider());
     
    }
    
    protected void bindControls() {
	
	bindControl(codeField, "code");
	bindControl(personField, "person", personLabel, REQUIRED);
	bindControl(departmentField, "department");
	bindControl(positionField, "position");
	bindControl(employeeCategoryField, "employeeCategory");
	bindControl(startDateField, "startDate");
	bindControl(endDateField, "endDate");	
   	
	bindControl(payrollFormField, "payrollForm");
	bindControl(employeeRankField, "employeeRank");
	bindControl(salaryField, "salary");
	bindControl(tariffField, "tariff");
	bindControl(advanceField, "advance");
	bindControl(premiumPercentField, "premiumPercent");
	bindControl(sickPercentField, "sickPercent");
	
	//addMapControl(stockField, "stock");
	bindControl(employeeAccountField, "employeeAccount");	
	
	//
	
	bindControl(totalSeniorityYearField, "totalSeniorityYear");
	bindControl(totalSeniorityMonthField, "totalSeniorityMonth");
	bindControl(totalSeniorityDayField, "totalSeniorityDay");
    	
	bindControl(unbrokenSeniorityYearField, "unbrokenSeniorityYear");
	bindControl(unbrokenSeniorityMonthField, "unbrokenSeniorityMonth");
	bindControl(unbrokenSeniorityDayField, "unbrokenSeniorityDay");
    	
	//
	
	bindControl(noteField, "note");
	
    }
    
    private void createItemPanel() {
	
	TabItem phoneTabItem;
	TabItem emailTabItem;
	
	
  	GridData gridData;
  	Composite itemPanel = new Composite(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    	gridData.heightHint = 150;
    	itemPanel.setLayoutData(gridData);
    	itemPanel.setLayout(new FillLayout());

    	itemTabFolder = new TabFolder(itemPanel, SWT.NONE);
	
    	phoneTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	phoneTabItem.setText(Messages.getString("EmployeeEditForm.phoneTabItem.text")); //$NON-NLS-1$

    	phoneTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	phoneTable.setLinesVisible(true);
    	phoneTable.setHeaderVisible(true);
    	phoneTabItem.setControl(phoneTable);

    	TableColumn tableColumn = new TableColumn(phoneTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn phoneTypeColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneTypeColumn.setWidth(100);
    	phoneTypeColumn.setText(Messages.getString("EmployeeEditForm.phoneTypeColumn.text")); //$NON-NLS-1$

    	final TableColumn phoneStringColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneStringColumn.setWidth(343);
    	phoneStringColumn.setText(Messages.getString("EmployeeEditForm.phoneStringColumn.text")); //$NON-NLS-1$

    	emailTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	emailTabItem.setText(Messages.getString("EmployeeEditForm.emailTabItem.text")); //$NON-NLS-1$

    	emailTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	emailTable.setLinesVisible(true);
    	emailTable.setHeaderVisible(true);
    	emailTabItem.setControl(emailTable);

    	tableColumn = new TableColumn(emailTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn emailColumn = new TableColumn(emailTable, SWT.NONE);
    	emailColumn.setWidth(349);
    	emailColumn.setText(Messages.getString("EmployeeEditForm.emailColumn.text")); //$NON-NLS-1$

    
    }

    
  
    protected class PhoneProvider extends TableEntityProvider {
	
	public PhoneProvider() {
	    setParentEntityClass(Employee.class); // OWNER
	    setListProperty("phoneList");
	    setAddMethod("addPhone");
	    
	    setEntityClass(Phone.class); // FORM ID
	    setEntityFormClass(PhoneEditForm.class);
	}
	
	protected Table getTable() {
	    return phoneTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "phoneTypeName");
	    bindColumn(2, "phoneString");
	}
    }

    protected class EmailProvider extends TableEntityProvider {
	
	public EmailProvider() {
	    setParentEntityClass(Employee.class); // OWNER
	    setListProperty("emailList");
	    setAddMethod("addEmail");
	    
	    setEntityClass(Email.class); // FORM ID
	    setEntityFormClass(EmailEditForm.class);
	}
	
	protected Table getTable() {
	    return emailTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "emailAddress");
	}
    }
    
    
     
    protected Object getSelectedEntityProviderKey() {
        int index = itemTabFolder.getSelectionIndex();
        return itemTabFolder.getItem(index);
    }
    
    protected void beforeClose() throws ApplicationException {
	if (isModify()) {
	    return;
	}
	setModify(personField.isModify());
	
	super.beforeClose();
    }
    
    
    protected void afterModifyItem(Object item) throws ApplicationException {
	refreshEntityProviderViewByItemAndClass(item, ContactableItem.class);
    }
}

