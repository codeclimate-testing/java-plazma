/*
 * Copyright (C) 2005-2006 Oleh Hapon ohapon@users.sourceforge.net
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
 * Created on 06.02.2007
 *
 */

package org.plazmaforge.bsolution.pim.client.swt.forms;



import java.util.Date;

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
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.swt.forms.AttributeValueView;
import org.plazmaforge.bsolution.base.client.swt.forms.FileView;
import org.plazmaforge.bsolution.base.client.swt.forms.common.CalendarHelper;
import org.plazmaforge.bsolution.contact.client.swt.forms.ContactListForm;
import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractOrganizableEditForm;
import org.plazmaforge.bsolution.pim.PIMEnvironment;
import org.plazmaforge.bsolution.pim.common.beans.PIMAppointment;
import org.plazmaforge.bsolution.pim.common.beans.PIMAppointmentContact;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEntityProvider;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateTimeCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 */

public class PIMAppointmentEditForm extends AbstractOrganizableEditForm {

    
    private Label subjectLabel;

    private Label appointmentTypeLabel;
 
    private Label responsibleLabel;
    
    private Label startDateTimeLabel;
    
    private Label appointmentPriorityLabel;
    
    private Label endDateTimeLabel;
    
    private Label reminderDateTimeLabel;
    
    private Label projectLabel;
    

    
    private XTextField subjectField;
    
    private XComboEdit appointmentTypeField;
    
    private XComboEdit responsibleField;
    
    private XDateTimeCombo startDateTimeField;
    
    private XComboEdit appointmentPriorityField;
    
    private XDateTimeCombo endDateTimeField;
    
    private XDateTimeCombo reminderDateTimeField;
    
    private XComboEdit projectField;
    
    
    private XTextArea descriptionField;

   

    ////
    private Composite itemsPanel;

    private TabFolder itemsTabFolder;
    
    ////
    private TabItem contactTabItem;
    
    private Table contactTable;    
    
    ////
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PIMAppointmentEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	TabItem descriptionTabItem;
	Composite composite;
	GridLayout gridLayout;
	
	setTitle(Messages.getString("PIMAppointmentEditForm.title")); //$NON-NLS-1$
	
	gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	

	setLayout(gridLayout);
	GridData gridData;

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("PIMAppointmentEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	subjectLabel = new Label(composite, SWT.NONE);
    	subjectLabel.setText(Messages.getString("PIMAppointmentEditForm.subjectLabel.text")); //$NON-NLS-1$
    
    	subjectField = new XTextField(composite, SWT.BORDER);
    	subjectField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	subjectField.setTextLimit(50);


    	appointmentTypeLabel = new Label(composite, SWT.NONE);
    	appointmentTypeLabel.setText(Messages.getString("PIMAppointmentEditForm.appointmentTypeLabel.text")); //$NON-NLS-1$

    	appointmentTypeField = new XComboEdit(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 200;
    	appointmentTypeField.setLayoutData(gridData);

    	startDateTimeLabel = new Label(composite, SWT.NONE);
    	startDateTimeLabel.setLayoutData(new GridData());
    	startDateTimeLabel.setText(Messages.getString("PIMAppointmentEditForm.startDateTimeLabel.text")); //$NON-NLS-1$

    	startDateTimeField = new XDateTimeCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	startDateTimeField.setLayoutData(gridData);

    	
    	
    	appointmentPriorityLabel = new Label(composite, SWT.NONE);
    	appointmentPriorityLabel.setText(Messages.getString("PIMAppointmentEditForm.appointmentPriorityLabel.text")); //$NON-NLS-1$

    	appointmentPriorityField = new XComboEdit(composite, SWT.BORDER);
    	appointmentPriorityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	endDateTimeLabel = new Label(composite, SWT.NONE);
    	endDateTimeLabel.setText(Messages.getString("PIMAppointmentEditForm.endDateTimeLabel.text")); //$NON-NLS-1$

    	endDateTimeField = new XDateTimeCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	endDateTimeField.setLayoutData(gridData);

    	////
    	descriptionTabItem = new TabItem(tabFolder, SWT.NONE);
    	descriptionTabItem.setText(Messages.getString("PIMAppointmentEditForm.descriptionTabItem.text")); //$NON-NLS-1$

    	descriptionField = new XTextArea(tabFolder, SWT.MULTI);
    	descriptionField.setTextLimit(255);
    	descriptionField.setFixedHeight(100);
    	descriptionTabItem.setControl(descriptionField);
    	

    	Label label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));

    	
    	responsibleLabel = new Label(composite, SWT.NONE);
    	responsibleLabel.setText(Messages.getString("PIMAppointmentEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	
	reminderDateTimeLabel = new Label(composite, SWT.NONE);
    	reminderDateTimeLabel.setText(Messages.getString("PIMAppointmentEditForm.reminderDateTimeLabel.text")); //$NON-NLS-1$

    	reminderDateTimeField = new XDateTimeCombo(composite, SWT.BORDER);
    	reminderDateTimeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));



    	label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));

    	////
    	
    	projectLabel = new Label(composite, SWT.NONE);
    	projectLabel.setText(Messages.getString("PIMAppointmentEditForm.projectLabel.text")); //$NON-NLS-1$

    	projectField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	projectField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	projectField.setAssociationValueClass(Project.class);

    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);

    	createItemPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemsTabFolder, PIMAppointment.class);
    	FileView fileView = new FileView(itemsTabFolder, PIMAppointment.class);

    	this.setSize(new Point(590, 261));
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new AppointmentContactProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), attributeView.getEntityProvider());
    	registerEntityProvider(itemsTabFolder.getItem(2), fileView.getEntityProvider());
    	
    	initResponsibleField(responsibleField);

    }
    
    private PIMAppointment getAppointment() {
	return (PIMAppointment) getEntity();
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	
	Date activeDate = CalendarHelper.getActiveDate(this);
	Date date = activeDate == null ? EnterpriseEnvironment.getDate() : activeDate;
		
	getAppointment().setStartDateTime(date);
	getAppointment().setEndDateTime(date);

	getAppointment().setAppointmentType(PIMEnvironment.getAppointmentType());
	getAppointment().setAppointmentPriority(PIMEnvironment.getAppointmentPriority());
	getAppointment().setResponsible(getDefaultResponsible());
	//getAppointment().setProject(Environment.getProject());
	
    }
	
    protected void bindControls() {
	bindControl(subjectField, "subject", subjectLabel, REQUIRED);
	bindControl(appointmentTypeField, "appointmentType", appointmentTypeLabel, REQUIRED);	
	bindControl(responsibleField, "responsible", responsibleLabel, REQUIRED);	
	
	bindControl(startDateTimeField, "startDateTime", startDateTimeLabel, REQUIRED);	
	bindControl(endDateTimeField, "endDateTime");
	bindControl(reminderDateTimeField, "reminderDateTime");
	bindControl(appointmentPriorityField, "appointmentPriority", appointmentPriorityLabel, REQUIRED);
	bindControl(projectField, "project");
	bindControl(descriptionField, "description");
    }

    
    private void createItemPanel() {
	 
        GridLayout gridLayout;
          
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
        itemsTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        

        ////
        
        contactTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        contactTabItem.setText(Messages.getString("PIMAppointmentEditForm.contactTabItem.text")); //$NON-NLS-1$

         
        contactTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        contactTable.setHeaderVisible(true);
        contactTable.setLinesVisible(true);
        contactTabItem.setControl(contactTable);

        TableColumn newColumnTableColumn = new TableColumn(contactTable, SWT.NONE);
        newColumnTableColumn.setResizable(false);
        newColumnTableColumn.setWidth(20);

        TableColumn contactTableColumn = new TableColumn(contactTable, SWT.NONE);
        contactTableColumn.setWidth(300);
        contactTableColumn.setText(Messages.getString("PIMAppointmentEditForm.contactTableColumn.text")); //$NON-NLS-1$

    }
    
   protected class AppointmentContactProvider extends TableEntityProvider {
	
	public AppointmentContactProvider() {
	    setParentEntityClass(PIMAppointment.class); // OWNER
	    setListProperty("appointmentContacts");
	    setAddMethod("addAppointmentContact");
	    
	    setEntityClass(PIMAppointmentContact.class);
	    setSupportEditForm(false);
	}
	
	protected Table getTable() {
	    return contactTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "contactName");
	}
	
	public IEditForm getEditForm() {
	    return null;
	}
   }

   public void doItemAddAction() throws ApplicationException {
	IEntityProvider provider = getSelectedEntityProvider();
	if (provider instanceof AppointmentContactProvider) {
	    doItemAddListForm(ContactListForm.class);
	    return;
	}
	super.doItemAddAction();
   }
   
   public void doItemEditAction() throws ApplicationException {
	IEntityProvider provider = getSelectedEntityProvider();
	if (provider instanceof AppointmentContactProvider) {
	    return;
	}
	super.doItemEditAction();
   }
   
   
   protected Object getItemEntityFromListForm(IListForm listForm) {
	
  	Object entity = super.getItemEntityFromListForm(listForm);
  	if (entity == null) {
  	    return null;
  	}
  	
  	if (listForm instanceof ContactListForm) {
  	    ContactHeader contact = (ContactHeader) entity;
  	    PIMAppointmentContact appointmentContact = new PIMAppointmentContact();
  	    appointmentContact.setContact(contact);
  	    return appointmentContact;
  	}
  	return entity;
      }   

    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }

//    protected Date getActiveDate() {
//	return (Date) getData("activeDate");
//    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
