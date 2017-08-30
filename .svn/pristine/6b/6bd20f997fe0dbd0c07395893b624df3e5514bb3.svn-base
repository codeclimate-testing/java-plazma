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
 * Created on 14.06.2007
 *
 */

package org.plazmaforge.bsolution.contact.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.client.swt.forms.AttributeValueView;
import org.plazmaforge.bsolution.base.client.swt.forms.FileView;
import org.plazmaforge.bsolution.contact.ContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.bsolution.contact.common.beans.ContactableItem;
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.Web;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractOrganizableEditForm;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.controls.XCombo;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.dialogs.ImagePanel;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: ContactEditForm.java,v 1.5 2010/12/05 07:57:22 ohapon Exp $
 */

public class ContactEditForm extends AbstractOrganizableEditForm {

    
    private Label codeLabel;
    private Label nameLabel;
    private Label titleNameLabel; 
    private Label firstNameLabel;
    private Label middleNameLabel;
    private Label lastNameLabel;
    private Label partnerLabel;
    private Label departmentLabel;
    private Label positionLabel;
    private Label birthDateLabel;  
    private Label genderLabel;
    private Label contactTypeLabel;
    private Label responsibleLabel;
    
    
    
    private XTextField codeField;
    private XTextField nameField;
    private XTextField titleNameField;
    private XTextField firstNameField;    
    private XTextField middleNameField;
    private XTextField lastNameField;    
    private XComboEdit partnerField;
    private XComboEdit departmentField;
    private XComboEdit positionField;
    private XDateCombo birthDateField;
    private XCombo genderField;
    private XComboEdit contactTypeField;
    private XComboEdit responsibleField;
    
    private ImagePanel imagePanel;
    
    private XTextArea noteField;
    private TabFolder itemTabFolder;
  
    
    
    private Table webTable;
    private Table emailTable;
    private Table phoneTable;
    private Table addressTable;
    

    private String nameVariant;
    
    public ContactEditForm(Composite parent, int style) {
	super(parent, style);
	
	initialize();
    }
    
    protected void initialize() {
	
	nameVariant = LocaleManager.getNameVariant();
	
	setTitle(Messages.getString("ContactEditForm.title")); //$NON-NLS-1$
	
	TabFolder tabFolder;
	GridData gridData;
	Composite composite;

	TabItem noteTabItem;
	GridLayout gridLayout;
	
	
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
    	generalTabItem.setText(Messages.getString("ContactEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	
  	
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	codeLabel = new Label(composite, SWT.NONE);
	codeLabel.setText(Messages.getString("ContactEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	codeField.setTextLimit(10);
	gridData = new GridData(200, SWT.DEFAULT);
    	codeField.setLayoutData(gridData);

    

    	titleNameLabel = new Label(composite, SWT.NONE);
	titleNameLabel.setText(Messages.getString("ContactEditForm.titleNameLabel.text")); //$NON-NLS-1$

	titleNameField = new XTextField(composite, SWT.BORDER);
	titleNameField.setTextLimit(30);
	titleNameField.setLayoutData(new GridData(200, SWT.DEFAULT));

	if (LocaleManager.LAST_FIRST_MIDDLE.equals(nameVariant)) {
	    addLFMName(composite);
	} else if (LocaleManager.FIRST_LAST_MIDDLE.equals(nameVariant)) {
	    addFLMName(composite);
	} else {
	    addFLName(composite);
	}
	
	nameLabel = new Label(composite, SWT.NONE);
	nameLabel.setText(Messages.getString("ContactEditForm.fullNameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(composite, SWT.BORDER);
    	nameField.setTextLimit(50);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	nameField.setLayoutData(gridData);
    	nameField.setEnabled(false);
    	
    	
    	partnerLabel = new Label(composite, SWT.NONE);
	partnerLabel.setText(Messages.getString("ContactEditForm.partnerLabel.text")); //$NON-NLS-1$

    	partnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	partnerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

       	
	departmentLabel = new Label(composite, SWT.NONE);
	departmentLabel.setText(Messages.getString("ContactEditForm.departmentLabel.text")); //$NON-NLS-1$

    	departmentField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	departmentField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

	positionLabel = new Label(composite, SWT.NONE);
	positionLabel.setText(Messages.getString("ContactEditForm.positionLabel.text")); //$NON-NLS-1$

    	positionField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	positionField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));


	//
	
    	birthDateLabel = new Label(composite, SWT.NONE);
	birthDateLabel.setText(Messages.getString("ContactEditForm.birthDateLabel.text"));   //$NON-NLS-1$

    	birthDateField = new XDateCombo(composite, SWT.BORDER);
    	birthDateField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	genderLabel = new Label(composite, SWT.RIGHT);
    	gridData = new GridData();
    	gridData.horizontalIndent = 100;
    	genderLabel.setLayoutData(gridData);
    	genderLabel.setText(Messages.getString("ContactEditForm.genderLabel.text"));   //$NON-NLS-1$

    	genderField = new XCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	genderField.setLayoutData(gridData);

	//
	
	contactTypeLabel = new Label(composite, SWT.NONE);
	contactTypeLabel.setText(Messages.getString("ContactEditForm.contactTypeLabel.text")); //$NON-NLS-1$

	contactTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
	contactTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

	//
	
	responsibleLabel = new Label(composite, SWT.NONE);
	responsibleLabel.setText(Messages.getString("ContactEditForm.responsibleLabel.text")); //$NON-NLS-1$

	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	
    	
	//////////////////////////////////////////////////////
    	
    	TabItem imageTabItem = new TabItem(tabFolder, SWT.NONE);
    	imageTabItem.setText(Messages.getString("Photo.text")); //$NON-NLS-1$
    	imagePanel = new ImagePanel(tabFolder, Messages.getString("Photo.text"));
    	imageTabItem.setControl(imagePanel);
    	
    	//////////////////////////////////////////////////////
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("ContactEditForm.noteTabItem.text")); //$NON-NLS-1$

    	
    	noteField = new XTextArea(tabFolder, SWT.NONE | SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

    	noteField.setTextLimit(255);
	noteTabItem.setControl(noteField);

     	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);

    	createItemPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemTabFolder, Contact.class);
    	FileView fileView = new FileView(itemTabFolder, Contact.class);


    	this.setSize(new Point(600, 350));
    	
    	registerEntityProvider(itemTabFolder.getItem(0), new AddressProvider());
    	registerEntityProvider(itemTabFolder.getItem(1), new PhoneProvider());
    	registerEntityProvider(itemTabFolder.getItem(2), new EmailProvider());
    	registerEntityProvider(itemTabFolder.getItem(3), new WebProvider());
    	registerEntityProvider(itemTabFolder.getItem(4), attributeView.getEntityProvider());
    	registerEntityProvider(itemTabFolder.getItem(5), fileView.getEntityProvider());
    	
    	initPartnerField(partnerField);
    	initResponsibleField(responsibleField);
   
    	//TODO
    	genderField.addValue((byte) 1, Messages.getString("ContactEditForm.0"));  //$NON-NLS-1$
    	genderField.addValue((byte) 2, Messages.getString("ContactEditForm.1"));  //$NON-NLS-1$

    }
    
    private void addFLName(Composite composite) {
	addFirstName(composite);
	addLastName(composite);
    }

    private void addLFMName(Composite composite) {
	addLastName(composite);
	addFirstName(composite);
	addMiddleName(composite);
    }

    private void addFLMName(Composite composite) {
	addFirstName(composite);
	addLastName(composite);
	addMiddleName(composite);
    }
    
    private void addFirstName(Composite composite) {
    	firstNameLabel = new Label(composite, SWT.NONE);
	firstNameLabel.setText(Messages.getString("ContactEditForm.firstNameLabel.text"));   //$NON-NLS-1$

    	firstNameField = new XTextField
    	(composite, SWT.BORDER);
    	firstNameField.setTextLimit(30);
    	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 350;
    	firstNameField.setLayoutData(gridData);
    	firstNameField.getUIControl().addModifyListener(new ModifyListener() {
	    public void modifyText(ModifyEvent e) {
		generateFullName();
	    }
    	});
    }

    private void addMiddleName(Composite composite) {
    	middleNameLabel = new Label(composite, SWT.NONE);
	middleNameLabel.setText(Messages.getString("ContactEditForm.middleNameLabel.text"));   //$NON-NLS-1$

	middleNameField = new XTextField(composite, SWT.BORDER);
	middleNameField.setTextLimit(30);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 350;
	middleNameField.setLayoutData(gridData);
	middleNameField.getUIControl().addModifyListener(new ModifyListener() {
	    public void modifyText(ModifyEvent e) {
		generateFullName();
	    }
    	});

    }

    
    private void addLastName(Composite composite) {
	lastNameLabel = new Label(composite, SWT.NONE);
	lastNameLabel.setText(Messages.getString("ContactEditForm.lastNameLabel.text"));   //$NON-NLS-1$

	lastNameField = new XTextField(composite, SWT.BORDER);
	lastNameField.setTextLimit(30);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 350;
	lastNameField.setLayoutData(gridData);
    	lastNameField.getUIControl().addModifyListener(new ModifyListener() {
	    public void modifyText(ModifyEvent e) {
		generateFullName();
	    }
    	});
    }

    
    protected void bindControls() {
	bindControl(codeField, "code");
	
	bindControl(firstNameField, "firstName");
	if (middleNameField != null) bindControl(middleNameField, "middleName");
	bindControl(lastNameField, "lastName");
	
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(titleNameField, "titleName");	
	bindControl(partnerField, "partner");	
	bindControl(departmentField, "department");	
	bindControl(positionField, "position");
	bindControl(birthDateField, "birthDate");
	bindControl(genderField, "gender", genderLabel, REQUIRED);
	bindControl(contactTypeField, "contactType", contactTypeLabel, REQUIRED);
	bindControl(responsibleField, "responsible");	
	bindControl(noteField, "note");	
    }
    
    private void createItemPanel() {
	
	TabItem addressTabItem;
	TabItem phoneTabItem;
	TabItem emailTabItem;
	TabItem webTabItem;

	
  	GridData gridData;
  	Composite itemPanel = new Composite(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    	gridData.heightHint = 150;
    	itemPanel.setLayoutData(gridData);
    	itemPanel.setLayout(new FillLayout());

    	itemTabFolder = new TabFolder(itemPanel, SWT.NONE);
	addressTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	addressTabItem.setText(Messages.getString("ContactEditForm.addressTabItem.text")); //$NON-NLS-1$

    	addressTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	addressTable.setLinesVisible(true);
    	addressTable.setHeaderVisible(true);
    	addressTabItem.setControl(addressTable);

    	TableColumn tableColumn = new TableColumn(addressTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn addressTypeColumn = new TableColumn(addressTable, SWT.NONE);
    	addressTypeColumn.setWidth(100);
    	addressTypeColumn.setText(Messages.getString("ContactEditForm.addressTypeColumn.text")); //$NON-NLS-1$

    	final TableColumn fullAddressStringColumn = new TableColumn(addressTable, SWT.NONE);
    	fullAddressStringColumn.setWidth(337);
    	fullAddressStringColumn.setText(Messages.getString("ContactEditForm.fullAddressStringColumn.text")); //$NON-NLS-1$

    	phoneTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	phoneTabItem.setText(Messages.getString("ContactEditForm.phoneTabItem.text")); //$NON-NLS-1$

    	phoneTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	phoneTable.setLinesVisible(true);
    	phoneTable.setHeaderVisible(true);
    	phoneTabItem.setControl(phoneTable);

    	tableColumn = new TableColumn(phoneTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn phoneTypeColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneTypeColumn.setWidth(100);
    	phoneTypeColumn.setText(Messages.getString("ContactEditForm.phoneTypeColumn.text")); //$NON-NLS-1$

    	final TableColumn phoneStringColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneStringColumn.setWidth(343);
    	phoneStringColumn.setText(Messages.getString("ContactEditForm.phoneStringColumn.text")); //$NON-NLS-1$

    	emailTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	emailTabItem.setText(Messages.getString("ContactEditForm.emailTabItem.text")); //$NON-NLS-1$

    	emailTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	emailTable.setLinesVisible(true);
    	emailTable.setHeaderVisible(true);
    	emailTabItem.setControl(emailTable);

    	tableColumn = new TableColumn(emailTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn emailColumn = new TableColumn(emailTable, SWT.NONE);
    	emailColumn.setWidth(349);
    	emailColumn.setText(Messages.getString("ContactEditForm.emailColumn.text")); //$NON-NLS-1$

    	webTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	webTabItem.setText(Messages.getString("ContactEditForm.webTabItem.text")); //$NON-NLS-1$

    	webTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	webTable.setLinesVisible(true);
    	webTable.setHeaderVisible(true);
    	webTabItem.setControl(webTable);

    	tableColumn = new TableColumn(webTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn urlColumn = new TableColumn(webTable, SWT.NONE);
    	urlColumn.setWidth(377);
    	urlColumn.setText(Messages.getString("ContactEditForm.urlColumn.text")); //$NON-NLS-1$

    }

    private Contact getContact() {
	return (Contact) getEntity();
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getContact().setContactType(ContactEnvironment.getContactType());
	getContact().setResponsible(getDefaultResponsible());
    }
    
    protected class AddressProvider extends TableEntityProvider {
	
	public AddressProvider() {
	    setParentEntityClass(Contact.class); // OWNER
	    setListProperty("addressList");
	    setAddMethod("addAddress");
	    
	    setEntityClass(Address.class); // FORM ID
	    setEntityFormClass(AddressEditForm.class);
	}
	
	protected Table getTable() {
	    return addressTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "addressTypeName");
	    bindColumn(2, "fullAddressString");
	}
    }
    
    protected class PhoneProvider extends TableEntityProvider {
	
	public PhoneProvider() {
	    setParentEntityClass(Contact.class); // OWNER
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
	    setParentEntityClass(Contact.class); // OWNER
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
    
    
    protected class WebProvider extends TableEntityProvider {
	
	public WebProvider() {
	    setParentEntityClass(Contact.class); // OWNER
	    setListProperty("webList");
	    setAddMethod("addWeb");
	    
	    setEntityClass(Web.class); // FORM ID
	    setEntityFormClass(WebEditForm.class);
	}
	
	protected Table getTable() {
	    return webTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "url");
	}
    }
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemTabFolder.getSelectionIndex();
        return itemTabFolder.getItem(index);
    }
    
    protected void afterModifyItem(Object item) throws ApplicationException {
	refreshEntityProviderViewByItemAndClass(item, ContactableItem.class);
    }

    public void updateForm() throws ApplicationException {
	super.updateForm();
	imagePanel.setData(getContact().getImageEntry().getBinaryData());
    }

    
    public void updateData() throws ApplicationException {
	getContact().getImageEntry().setBinaryData(imagePanel.getData());
	getContact().getImageEntry().setFileExt(imagePanel.getFileExt());
	super.updateData();
	getContact().setName(getContact().generateName());
    }
    
    private void generateFullName() {
	String firstName = firstNameField == null ? null : firstNameField.getText();
	String lastName = lastNameField == null ? null : lastNameField.getText();
	String middleName = middleNameField == null ? null : middleNameField.getText();
	String fullName = LocaleManager.getPersonName(firstName, lastName, middleName);
	nameField.setText(fullName);
    }
}
