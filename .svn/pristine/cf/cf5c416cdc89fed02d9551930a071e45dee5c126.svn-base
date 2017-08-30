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
 * Created on 11.04.2007
 *
 */

package org.plazmaforge.bsolution.partner.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.swt.forms.AttributeValueView;
import org.plazmaforge.bsolution.base.client.swt.forms.FileView;
import org.plazmaforge.bsolution.contact.client.swt.forms.AddressTableView;
import org.plazmaforge.bsolution.contact.client.swt.forms.ContactPanel;
import org.plazmaforge.bsolution.contact.client.swt.forms.EmailTableView;
import org.plazmaforge.bsolution.contact.client.swt.forms.PhoneTableView;
import org.plazmaforge.bsolution.contact.client.swt.forms.WebTableView;
import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.bsolution.contact.common.beans.ContactableItem;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.beans.PartnerActivityTypeLink;
import org.plazmaforge.bsolution.partner.common.beans.PartnerCategoryLink;
import org.plazmaforge.bsolution.partner.common.beans.PartnerGroup;
import org.plazmaforge.bsolution.partner.common.beans.PartnerType;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.dialogs.ImagePanel;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.RegionMessages;


/** 
 * @author Oleh Hapon
 * $Id: PartnerEditForm.java,v 1.13 2010/12/05 07:57:19 ohapon Exp $
 */

public class PartnerEditForm extends AbstractEditForm {

    
    private Label codeLabel;
    private Label nameLabel;
    private Label nameEnLabel;
    
    private Label formPropertyLabel;
    private Label necLabel;
    private Label idnLabel;
    private Label taxDocNoLabel;
    private Label taxLabel;
    private Label industryLabel;
    private Label partnerGroupLabel;
    private Label partnerTypeLabel;
    private Label responsibleLabel;
   
    
    
    private XTextField codeField;
    private XTextField nameField;
    private XTextField nameEnField;
    
    private Label fullNameLabel;
    private XTextField fullNameField;
    private XComboEdit formPropertyField;
    private XTextField necField;
    private XTextField idnField;
    private XTextField taxDocNoField;
    private XComboEdit partnerGroupField;
    private XComboEdit industryField;
    private XTextArea noteField;
    private XCheckBox taxField;
    private TabFolder itemTabFolder;
    private XComboEdit partnerTypeField;
    private XComboEdit responsibleField;
    
    
    private ContactPanel contactPanel;
    private Table activityTable;
    private Table categoryTable;
    
    private AddressTableView addressTableView;
    private PhoneTableView phoneTableView;
    private EmailTableView emailTableView;
    private WebTableView webTableView; 
    
    private AttributeValueView attributeTableView;
    private FileView fileTableView;
    
    
    private Composite commonPanel;
    
    
    ////
    
    
    private ImagePanel imagePanel;

    
    public PartnerEditForm(Composite parent, int style) {
	super(parent, style);
	
	initialize();
    }
    
    protected void initialize() {
	
	setTitle(Messages.getString("PartnerEditForm.title")); //$NON-NLS-1$
	
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
    	
    	//DISABLE: 2010-05-29 - form size problems
    	//gridData.widthHint = 500; // WARNING !!! GENERAL WIDTH OF FORM // oha
    	
       	tabFolder.setLayoutData(gridData);

    	TabItem generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("PartnerEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	commonPanel = composite;
    	gridLayout = new GridLayout();
    	
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	codeLabel = new Label(composite, SWT.NONE);
    	codeLabel.setText(Messages.getString("PartnerEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	codeField.setTextLimit(10);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
	gridData.widthHint = 150;
    	codeField.setLayoutData(gridData);

    	
    	////
    	
    	
    	partnerTypeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	partnerTypeLabel.setLayoutData(gridData);
    	partnerTypeLabel.setText(Messages.getString("PartnerEditForm.partnerTypeLabel.text")); //$NON-NLS-1$

    	partnerTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 150;
    	partnerTypeField.setLayoutData(gridData);
    	partnerTypeField.addSelectionListener(new SelectionAdapter() {
    	    public void widgetSelected(SelectionEvent event) {
    		int index = partnerTypeField.getSelectionIndex() + 1;
    		setPartnerTypeMode(index);
    	    }
    	});


    	
    	////
    	
    	
    	nameLabel = new Label(composite, SWT.NONE);
	nameLabel.setText(Messages.getString("PartnerEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(composite, SWT.BORDER);
    	nameField.setTextLimit(50);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	nameField.setLayoutData(gridData);


    	if (isIntertationalAttributes()) {
        	nameEnLabel = new Label(composite, SWT.NONE);
        	nameEnLabel.setText(Messages.getString("PartnerEditForm.nameLabel.text") + " (En)"); //$NON-NLS-1$

            	nameEnField = new XTextField(composite, SWT.BORDER);
            	nameEnField.setTextLimit(50);
        	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
            	nameEnField.setLayoutData(gridData);
    	}

    	fullNameLabel = new Label(composite, SWT.NONE);
	fullNameLabel.setText(Messages.getString("PartnerEditForm.fullNameLabel.text")); //$NON-NLS-1$

	fullNameField = new XTextField(composite, SWT.BORDER);
	fullNameField.setTextLimit(100);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	fullNameField.setLayoutData(gridData);
	//fullNameField.setLayoutData(new GridData(400, SWT.DEFAULT));

    	

	////
	
	necLabel = new Label(composite, SWT.NONE);
	necLabel.setText(RegionMessages.getString(RegionMessages.NEC_KEY) /*Messages.getString("PartnerEditForm.necLabel.text")*/); //$NON-NLS-1$

	
    	necField = new XTextField(composite, SWT.BORDER);
    	necField.setTextLimit(20);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 150;
    	necField.setLayoutData(gridData);
	//necField.setLayoutData(new GridData(200, SWT.DEFAULT));
	
	////

    	
 	formPropertyLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	formPropertyLabel.setLayoutData(gridData);
	formPropertyLabel.setText(Messages.getString("PartnerEditForm.formPropertyLabel.text")); //$NON-NLS-1$

    	formPropertyField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 150;
    	formPropertyField.setLayoutData(gridData);
    	
    	
    	
    	
    
	
	////

    	idnLabel = new Label(composite, SWT.NONE);
	idnLabel.setText(Messages.getString("PartnerEditForm.idnLabel.text")); //$NON-NLS-1$

    	idnField = new XTextField(composite, SWT.BORDER);
    	idnField.setTextLimit(12);
	idnField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
	
	
	
    
	////
	
	
    	taxDocNoLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	taxDocNoLabel.setLayoutData(gridData);
	taxDocNoLabel.setText(Messages.getString("PartnerEditForm.taxDocNoLabel.text")); //$NON-NLS-1$
	
	taxDocNoField = new XTextField(composite, SWT.BORDER);
    	taxDocNoField.setTextLimit(20);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 150;
    	taxDocNoField.setLayoutData(gridData);
	//taxDocNoField.setLayoutData(new GridData(200, SWT.DEFAULT));
	
	new Label(composite, SWT.NONE); new Label(composite, SWT.NONE);
	
    	taxLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	taxLabel.setLayoutData(gridData);
	taxLabel.setText(Messages.getString("PartnerEditForm.taxLabel.text")); //$NON-NLS-1$

    	taxField = new XCheckBox(composite, SWT.NONE);
    	
    	
    	
	partnerGroupLabel = new Label(composite, SWT.NONE);
	partnerGroupLabel.setText(Messages.getString("PartnerEditForm.partnerGroupLabel.text")); //$NON-NLS-1$

    	partnerGroupField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	partnerGroupField.setLayoutData(gridData);
	//partnerGroupField.setLayoutData(new GridData(400, SWT.DEFAULT));

    	industryLabel = new Label(composite, SWT.NONE);
    	industryLabel.setText(Messages.getString("PartnerEditForm.industryLabel.text")); //$NON-NLS-1$

    	industryField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	industryField.setLayoutData(gridData);
	//industryField.setLayoutData(new GridData(400, SWT.DEFAULT));
	
	
    	
   

    	
	// DISABLE 
    	//additionalTabItem = new TabItem(tabFolder, SWT.NONE);
    	//additionalTabItem.setText(Messages.getString("PartnerEditForm.additionalTabItem.text")); //$NON-NLS-1$

    	//composite = new Composite(tabFolder, SWT.NONE);
    	//composite.setLayout(new GridLayout());
    	//additionalTabItem.setControl(composite);
    	
    	

	if (isSupportContactPanel()) {
	    TabItem contactTabItem = new TabItem(tabFolder, SWT.NONE);
	    contactTabItem.setText("Contact"/*Messages.getString("PartnerEditForm.noteTabItem.text")*/); //$NON-NLS-1$
	    contactPanel = new ContactPanel(tabFolder, SWT.NONE);
	    contactTabItem.setControl(contactPanel);
	}

	//
	
	responsibleLabel = new Label(composite, SWT.NONE);
	responsibleLabel.setText(Messages.getString("PartnerEditForm.responsibleLabel.text")); //$NON-NLS-1$

	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	
	
    	//////////////////////////////////////////////////////
    	
    	TabItem imageTabItem = new TabItem(tabFolder, SWT.NONE);
    	imageTabItem.setText(Messages.getString("Image.text")); //$NON-NLS-1$
    	imagePanel = new ImagePanel(tabFolder, Messages.getString("Image.text"));
    	imageTabItem.setControl(imagePanel);
    	
    	//////////////////////////////////////////////////////

    	
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("PartnerEditForm.noteTabItem.text")); //$NON-NLS-1$

    	
    	noteField = new XTextArea(tabFolder, SWT.NONE | SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);
	noteTabItem.setControl(noteField);

	
    	
	//ScrolledComposite s = new ScrolledComposite(tabFolder, SWT.NO_RADIO_GROUP | SWT.V_SCROLL | SWT.H_SCROLL);
	//s.setMinWidth(100);
	//s.setMinHeight(100);
	//s.setAlwaysShowScrollBars(true);
	//s.setExpandHorizontal(true);
	//s.setExpandVertical(true);
	
	//noteField = new XTextField(s, SWT.NONE | SWT.MULTI);
	//noteField.setTrimText(false);
	//s.setContent(noteField);
    	//noteField.setTextLimit(255);
    	//noteTabItem.setControl(s);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);

    	createItemPanel();
    	


    	this.setSize(new Point(600, 350));
    	
    	registerEntityProvider(itemTabFolder.getItem(0), addressTableView.getEntityProvider());
    	registerEntityProvider(itemTabFolder.getItem(1), phoneTableView.getEntityProvider());
    	registerEntityProvider(itemTabFolder.getItem(2), emailTableView.getEntityProvider());
    	registerEntityProvider(itemTabFolder.getItem(3), webTableView.getEntityProvider());
    	
    	registerEntityProvider(itemTabFolder.getItem(4), new CategoryProvider());
    	registerEntityProvider(itemTabFolder.getItem(5), new ActivityProvider());
    	
    	registerEntityProvider(itemTabFolder.getItem(6), attributeTableView.getEntityProvider());
    	registerEntityProvider(itemTabFolder.getItem(7), fileTableView.getEntityProvider());
    
    	initResponsibleField(responsibleField);
    }
    
    	
    // TODO: Must up 
    protected void initResponsibleField(XComboEdit responsibleField) {
	if (responsibleField == null) {
	    return;
	}
	responsibleField.setAssociationValueClass(Contact.class);
    }
    
    protected boolean isSupportContactPanel() {
	return false;
    }
    
    protected void bindControls() {
	bindControl(partnerTypeField, "partnerType");	
	
	bindControl(codeField, "code");
	
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(nameEnField, "nameEn");
	
	bindControl(fullNameField, "fullName");	
	bindControl(formPropertyField, "formProperty");	
	bindControl(necField, "nec");
	bindControl(idnField, "idn");	
	bindControl(taxDocNoField, "taxDocNo");
	bindControl(taxField, "tax", Boolean.TYPE);
	
	bindControl(partnerGroupField, "partnerGroup");	
	bindControl(industryField, "industry");
	bindControl(responsibleField, "responsible");
	bindControl(noteField, "note");	
	
    }
    
    private int partnerTypeMode = PartnerType.DEFAULT_TYPE_ID;
    
    
    
    private void setPartnerTypeMode(Integer partnerTypeMode) {
	setPartnerTypeMode(partnerTypeMode == null ? PartnerType.DEFAULT_TYPE_ID : partnerTypeMode);
    }
    
    private void setPartnerTypeMode(int partnerTypeMode) {
	this.partnerTypeMode = partnerTypeMode < PartnerType.COMPANY_TYPE_ID || partnerTypeMode > PartnerType.PERSON_TYPE_ID ? PartnerType.DEFAULT_TYPE_ID : partnerTypeMode;
	updatePartnerTypeMode();
    }
    
    private int getPartnerTypeMode() {
	return partnerTypeMode;
    }
    
    private void updatePartnerTypeMode() {
	if (getPartnerTypeMode() == PartnerType.COMPANY_TYPE_ID) {
	    setPartnerTypeModeVisible(true);
	} else if (getPartnerTypeMode() == PartnerType.PERSON_TYPE_ID) {
	    setPartnerTypeModeVisible(false);
	}
    }
    
    private void setPartnerTypeModeVisible(boolean visible) {
	setVisibleControl(necLabel, visible);
	setVisibleControl(necField, visible);
	setVisibleControl(formPropertyLabel, visible);
	setVisibleControl(formPropertyField, visible);
	//commonPanel.layout();
	layout();
    }
    
    
    
    private void createItemPanel() {
	

	TabItem categoryTabItem;
	TabItem activityTabItem;
	//TabItem representativeTabItem;
	
	
  	GridData gridData;
  	Composite itemPanel = new Composite(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    	gridData.heightHint = 150;
    	itemPanel.setLayoutData(gridData);
    	itemPanel.setLayout(new FillLayout());

    	itemTabFolder = new TabFolder(itemPanel, SWT.NONE);
    	
	addressTableView = new AddressTableView(itemTabFolder, Partner.class);
    	phoneTableView = new PhoneTableView(itemTabFolder, Partner.class);
    	emailTableView = new EmailTableView(itemTabFolder, Partner.class);
    	webTableView = new WebTableView(itemTabFolder, Partner.class);
    	
    	// CATEGORY TABLE
    	categoryTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	categoryTabItem.setText(Messages.getString("PartnerEditForm.categoryTabItem.text")); //$NON-NLS-1$

    	categoryTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	categoryTable.setLinesVisible(true);
    	categoryTable.setHeaderVisible(true);
    	categoryTabItem.setControl(categoryTable);

    	final TableColumn partnerCategoryColumn = new TableColumn(categoryTable, SWT.NONE);
    	partnerCategoryColumn.setWidth(434);
    	partnerCategoryColumn.setText(Messages.getString("PartnerEditForm.partnerCategoryColumn.text")); //$NON-NLS-1$

    	// ACTIVITY TABLE
    	activityTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	activityTabItem.setText(Messages.getString("PartnerEditForm.activityTabItem.text")); //$NON-NLS-1$

    	activityTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	activityTable.setLinesVisible(true);
    	activityTable.setHeaderVisible(true);
    	activityTabItem.setControl(activityTable);

    	final TableColumn activityTypeColumn = new TableColumn(activityTable, SWT.NONE);
    	activityTypeColumn.setWidth(454);
    	activityTypeColumn.setText(Messages.getString("PartnerEditForm.activityTypeColumn.text")); //$NON-NLS-1$
    	
    	
    	// REPRESENTATIVE TABLE
    	//representativeTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	//representativeTabItem.setText(Messages.getString("PartnerEditForm.representativeTabItem.text")); //$NON-NLS-1$

    	//representativeTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	//representativeTable.setLinesVisible(true);
    	//representativeTable.setHeaderVisible(true);
    	//representativeTabItem.setControl(representativeTable);


    	//final TableColumn representativeNameColumn = new TableColumn(representativeTable, SWT.NONE);
    	//representativeNameColumn.setWidth(250);
    	//representativeNameColumn.setText(Messages.getString("PartnerEditForm.representativeNameColumn.text")); //$NON-NLS-1$

    	//final TableColumn representativeCodeColumn = new TableColumn(representativeTable, SWT.NONE);
    	//representativeCodeColumn.setWidth(60);
    	//representativeCodeColumn.setText(Messages.getString("PartnerEditForm.representativeCodeColumn.text")); //$NON-NLS-1$

    	//final TableColumn representativeDocumentColumn = new TableColumn(representativeTable, SWT.NONE);
    	//representativeDocumentColumn.setWidth(80);
    	//representativeDocumentColumn.setText(Messages.getString("PartnerEditForm.representativeDocumentColumn.text")); //$NON-NLS-1$

    	/*
    	final TableColumn representativeAddressColumn = new TableColumn(representativeTable, SWT.NONE);
    	representativeAddressColumn.setWidth(200);
    	representativeAddressColumn.setText(Messages.getString("PartnerEditForm.representativeAddressColumn.text")); //$NON-NLS-1$
    	*/
    	
    	//final TableColumn representativePhoneColumn = new TableColumn(representativeTable, SWT.NONE);
    	//representativePhoneColumn.setWidth(80);
    	//representativePhoneColumn.setText(Messages.getString("PartnerEditForm.representativePhoneColumn.text")); //$NON-NLS-1$
    	

    	attributeTableView = new AttributeValueView(itemTabFolder, Partner.class);
    	fileTableView = new FileView(itemTabFolder, Partner.class);

    }

    
    protected class CategoryProvider extends TableEntityProvider {
	
	public CategoryProvider() {
	    setParentEntityClass(Partner.class); // OWNER
	    setListProperty("partnerCategoryLinkList");
	    setAddMethod("addPartnerCategoryLink");
	    
	    setEntityClass(PartnerCategoryLink.class); // FORM ID
	    setEntityFormClass(PartnerCategoryLinkEditForm.class);
	}
	
	protected Table getTable() {
	    return categoryTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "partnerCategoryName");
	}
    }
    
    protected class ActivityProvider extends TableEntityProvider {
	
	public ActivityProvider() {
	    setParentEntityClass(Partner.class); // OWNER
	    setListProperty("partnerActivityTypeLinkList");
	    setAddMethod("addPartnerActivityTypeLink");
	    
	    setEntityClass(PartnerActivityTypeLink.class); // FORM ID
	    setEntityFormClass(PartnerActivityTypeLinkEditForm.class);
	}
	
	protected Table getTable() {
	    return activityTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "activityTypeName");
	}
    }
    
    
    /*
    protected class RepresentativeProvider extends TableEntityProvider {
	
	public RepresentativeProvider() {
	    setParentEntityClass(Partner.class); // OWNER
	    setListProperty("partnerRepresentativeList");
	    setAddMethod("addPartnerRepresentative");
	    
	    setEntityClass(PartnerRepresentative.class); // FORM ID
	    //setEntityFormClass(PartnerRepresentativeEditForm.class);
	}
	
	protected Table getTable() {
	    return representativeTable;
	}
	
	protected void bindTable() {

	    bindColumn(0, "name");
	    bindColumn(1, "code");
	    bindColumn(2, "document");
	    bindColumn(3, "phone");
	    
	    //bindColumn(3, "address");
	    //bindColumn(4, "phone");
	}
    }
    */
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemTabFolder.getSelectionIndex();
        return itemTabFolder.getItem(index);
    }
    
    protected void afterModifyItem(Object item) throws ApplicationException {
	refreshEntityProviderViewByItemAndClass(item, ContactableItem.class);
    }
    
    
    protected boolean isIntertationalAttributes() {
	return EnterpriseEnvironment.isInternationalAttributes();
    }
    
    protected Partner getPartner() {
	return (Partner) getEntity();
    }
    
    
    protected void initData() throws ApplicationException {
        super.initData();
        
        Partner partner = getPartner();
        
        // Fixed partner type if it is null
        if (partner.getPartnerType() == null) {
            partner.setPartnerType(EnterpriseEnvironment.getDefualtPartnerType());
        }
        
        
        // Set default partner group (group is selection of tree)
        Object category = getCategoryEntity();
        if (category != null && category instanceof PartnerGroup) {
            partner.setPartnerGroup((PartnerGroup) category);
        }
    }
    

    public void updateForm() throws ApplicationException {
	super.updateForm();
	setPartnerTypeMode(((Partner) getEntity()).getPartnerTypeId());
	imagePanel.setData(getPartner().getImageEntry().getBinaryData());
    }


    public void updateData() throws ApplicationException {
	getPartner().getImageEntry().setBinaryData(imagePanel.getData());
	getPartner().getImageEntry().setFileExt(imagePanel.getFileExt());
	super.updateData();
    }
    
}
