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
 * Created on 22 ��� 2007
 *
 */

package org.plazmaforge.bsolution.bank.client.swt.forms;


import org.eclipse.swt.SWT;
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
import org.plazmaforge.bsolution.bank.BankEnvironment;
import org.plazmaforge.bsolution.bank.common.beans.Bank;
import org.plazmaforge.bsolution.base.client.swt.forms.AttributeValueView;
import org.plazmaforge.bsolution.base.client.swt.forms.FileView;
import org.plazmaforge.bsolution.contact.client.swt.forms.AddressEditForm;
import org.plazmaforge.bsolution.contact.client.swt.forms.EmailEditForm;
import org.plazmaforge.bsolution.contact.client.swt.forms.PhoneEditForm;
import org.plazmaforge.bsolution.contact.client.swt.forms.WebEditForm;
import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.ContactableItem;
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.Web;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.beans.PartnerType;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.RegionMessages;


/** 
 * @author Oleh Hapon
 * $Id: BankEditForm.java,v 1.10 2010/12/05 07:57:18 ohapon Exp $
 */

public class BankEditForm extends AbstractEditForm {

  
    
    private Label codeLabel;
    private Label nameLabel;
    private Label fullNameLabel;
    private Label necLabel;
    private Label idnLabel;
    private Label taxDocNoLabel;
    private Label bicLabel;
    private Label correspondentAccountLabel;
    
    
    private XTextField codeField;
    private XTextField nameField;
    private XTextField fullNameField;
    private XTextField necField;
    private XTextField idnField;
    private XTextField taxDocNoField;
    
    private XTextField bicField;
    private XTextField correspondentAccountField;    
    
    private XTextArea noteField;
    private TabFolder itemTabFolder;
    
    private Table webTable;
    private Table emailTable;
    private Table phoneTable;
    private Table addressTable;
    
    public BankEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    protected void initialize() {
	setTitle(Messages.getString("BankEditForm.title")); //$NON-NLS-1$
	
	TabFolder tabFolder;
	GridData gridData;
	Composite composite;
	
	//DISABLE
	//TabItem additionalTabItem;
	
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
    	generalTabItem.setText(Messages.getString("BankEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
	
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	codeLabel = new Label(composite, SWT.NONE);
	codeLabel.setText(Messages.getString("BankEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	codeField.setTextLimit(10);
	gridData = new GridData(200, SWT.DEFAULT);
    	codeField.setLayoutData(gridData);

    	nameLabel = new Label(composite, SWT.NONE);
	nameLabel.setText(Messages.getString("BankEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(composite, SWT.BORDER);
    	nameField.setTextLimit(50);
	gridData = new GridData(400, SWT.DEFAULT);
    	nameField.setLayoutData(gridData);
    
    	fullNameLabel = new Label(composite, SWT.NONE);
	fullNameLabel.setText(Messages.getString("BankEditForm.fullNameLabel.text")); //$NON-NLS-1$

	fullNameField = new XTextField(composite, SWT.BORDER);
	fullNameField.setTextLimit(100);
	fullNameField.setLayoutData(new GridData(400, SWT.DEFAULT));

    	necLabel = new Label(composite, SWT.NONE);
	necLabel.setText(RegionMessages.getString(RegionMessages.NEC_KEY) /*Messages.getString("BankEditForm.necLabel.text")*/); //$NON-NLS-1$

    	necField = new XTextField(composite, SWT.BORDER);
    	necField.setTextLimit(20);
	necField.setLayoutData(new GridData(200, SWT.DEFAULT));

    	idnLabel = new Label(composite, SWT.NONE);
	idnLabel.setText(Messages.getString("BankEditForm.idnLabel.text")); //$NON-NLS-1$

    	idnField = new XTextField(composite, SWT.BORDER);
    	idnField.setTextLimit(12);
	idnField.setLayoutData(new GridData(200, SWT.DEFAULT));

    	taxDocNoLabel = new Label(composite, SWT.NONE);
	taxDocNoLabel.setText(Messages.getString("BankEditForm.taxDocNoLabel.text")); //$NON-NLS-1$

    	taxDocNoField = new XTextField(composite, SWT.BORDER);
    	taxDocNoField.setTextLimit(20);
	taxDocNoField.setLayoutData(new GridData(200, SWT.DEFAULT));

    	bicLabel = new Label(composite, SWT.NONE);
	bicLabel.setText(RegionMessages.getString(RegionMessages.BIC_KEY) /*Messages.getString("BankEditForm.bicLabel.text")*/); //$NON-NLS-1$

	bicField = new XTextField(composite, SWT.BORDER);
	bicField.setTextLimit(10);
	bicField.setLayoutData(new GridData(200, SWT.DEFAULT));

	correspondentAccountLabel = new Label(composite, SWT.NONE);
	correspondentAccountLabel.setText(Messages.getString("BankEditForm.correspondentAccountLabel.text")); //$NON-NLS-1$

	correspondentAccountField = new XTextField(composite, SWT.BORDER);
	correspondentAccountField.setTextLimit(BankEnvironment.BANK_ACCOUNT_SIZE);
	correspondentAccountField.setLayoutData(new GridData(200, SWT.DEFAULT));
	//
	
	// DISABLE
    	//additionalTabItem = new TabItem(tabFolder, SWT.NONE);
    	//additionalTabItem.setText(Messages.getString("BankEditForm.additionalTabItem.text")); //$NON-NLS-1$

    	//composite = new Composite(tabFolder, SWT.NONE);
    	//composite.setLayout(new GridLayout());
    	//additionalTabItem.setControl(composite);

    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("BankEditForm.noteTabItem.text")); //$NON-NLS-1$

    	
    	noteField = new XTextArea(tabFolder, SWT.NONE | SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);
    	
	noteTabItem.setControl(noteField);

    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);

    	createItemPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemTabFolder, Bank.class);
    	FileView fileView = new FileView(itemTabFolder, Bank.class);

    	this.setSize(new Point(600, 350));
    	
    	registerEntityProvider(itemTabFolder.getItem(0), new AddressProvider());
    	registerEntityProvider(itemTabFolder.getItem(1), new PhoneProvider());
    	registerEntityProvider(itemTabFolder.getItem(2), new EmailProvider());
    	registerEntityProvider(itemTabFolder.getItem(3), new WebProvider());
    	registerEntityProvider(itemTabFolder.getItem(4), attributeView.getEntityProvider());
    	registerEntityProvider(itemTabFolder.getItem(5), fileView.getEntityProvider());
    }
    
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(fullNameField, "fullName");	
	bindControl(necField, "nec");
	bindControl(idnField, "idn");	
	bindControl(taxDocNoField, "taxDocNo");
	    
	bindControl(bicField, "bic");	    
	bindControl(correspondentAccountField, "correspondentAccount");
	
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
    	addressTabItem.setText(Messages.getString("BankEditForm.addressTabItem.text")); //$NON-NLS-1$

    	addressTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	addressTable.setLinesVisible(true);
    	addressTable.setHeaderVisible(true);
    	addressTabItem.setControl(addressTable);

    	TableColumn tableColumn = new TableColumn(addressTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn addressTypeColumn = new TableColumn(addressTable, SWT.NONE);
    	addressTypeColumn.setWidth(100);
    	addressTypeColumn.setText(Messages.getString("BankEditForm.addressTypeColumn.text")); //$NON-NLS-1$

    	final TableColumn fullAddressStringColumn = new TableColumn(addressTable, SWT.NONE);
    	fullAddressStringColumn.setWidth(337);
    	fullAddressStringColumn.setText(Messages.getString("BankEditForm.fullAddressStringColumn.text")); //$NON-NLS-1$

    	phoneTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	phoneTabItem.setText(Messages.getString("BankEditForm.phoneTabItem.text")); //$NON-NLS-1$

    	phoneTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	phoneTable.setLinesVisible(true);
    	phoneTable.setHeaderVisible(true);
    	phoneTabItem.setControl(phoneTable);

    	tableColumn = new TableColumn(phoneTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn phoneTypeColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneTypeColumn.setWidth(100);
    	phoneTypeColumn.setText(Messages.getString("BankEditForm.phoneTypeColumn.text")); //$NON-NLS-1$

    	final TableColumn phoneStringColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneStringColumn.setWidth(343);
    	phoneStringColumn.setText(Messages.getString("BankEditForm.phoneStringColumn.text")); //$NON-NLS-1$

    	emailTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	emailTabItem.setText(Messages.getString("BankEditForm.emailTabItem.text")); //$NON-NLS-1$

    	emailTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	emailTable.setLinesVisible(true);
    	emailTable.setHeaderVisible(true);
    	emailTabItem.setControl(emailTable);

    	tableColumn = new TableColumn(emailTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn emailColumn = new TableColumn(emailTable, SWT.NONE);
    	emailColumn.setWidth(349);
    	emailColumn.setText(Messages.getString("BankEditForm.emailColumn.text")); //$NON-NLS-1$

    	webTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	webTabItem.setText(Messages.getString("BankEditForm.webTabItem.text")); //$NON-NLS-1$

    	webTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	webTable.setLinesVisible(true);
    	webTable.setHeaderVisible(true);
    	webTabItem.setControl(webTable);

    	tableColumn = new TableColumn(webTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn urlColumn = new TableColumn(webTable, SWT.NONE);
    	urlColumn.setWidth(377);
    	urlColumn.setText(Messages.getString("BankEditForm.urlColumn.text")); //$NON-NLS-1$

    }

    
    protected class AddressProvider extends TableEntityProvider {
	
	public AddressProvider() {
	    setParentEntityClass(Partner.class); // OWNER
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
	    setParentEntityClass(Partner.class); // OWNER
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
	    setParentEntityClass(Partner.class); // OWNER
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
	    setParentEntityClass(Partner.class); // OWNER
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
    
    protected void initData() throws ApplicationException {
        super.initData();
        Bank bank = (Bank) getEntity();
        PartnerType partnerType = new PartnerType();
        partnerType.setId(PartnerType.DEFAULT_TYPE_ID);
        bank.setPartnerType(partnerType);
    }  
}
