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

package org.plazmaforge.bsolution.project.client.swt.forms;



import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
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
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractOrganizableEditForm;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.project.ProjectEnvironment;
import org.plazmaforge.bsolution.project.TaskEnvironment;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.bsolution.project.common.beans.Task;
import org.plazmaforge.bsolution.project.common.beans.TaskContactLink;
import org.plazmaforge.bsolution.project.common.beans.TaskStatus;
import org.plazmaforge.bsolution.project.common.beans.TaskWorkerLink;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.CTimeSheet;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateTimeCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: TaskEditForm.java,v 1.6 2010/12/05 07:57:20 ohapon Exp $
 */

public class TaskEditForm extends AbstractOrganizableEditForm {

    
    private Label nameLabel;

    private Label taskNoLabel;
    
    private Label taskTypeLabel;
 
    private Label reporterLabel;
    
    private Label responsibleLabel;
    
    private Label partnerLabel;
    
    private Label taskStatusLabel;
    
    private Label startDateTimeLabel;
    
    private Label workTimeLabel;
    
    private Label taskPriorityLabel;
    
    private Label endDateTimeLabel;
    
    private Label actualEndDateTimeLabel;
    
    private Label actualTimeLabel;
    
    private Label reminderDateTimeLabel;
    
    private Label projectLabel;
    
    private Label documentLabel;
    
    private Label percentCompleteLabel;
    

    
    private XTextField nameField;
    
    private XTextField taskNoField;
    
    private XComboEdit taskTypeField;
    
    private XTextField reporterField;
    
    private XComboEdit responsibleField;
    
    private XComboEdit partnerField;
    
    private XComboEdit taskStatusField;
    
    private XDateTimeCombo startDateTimeField;
    
    private CTimeSheet workTimeField;
    
    private XComboEdit taskPriorityField;
    
    private XDateTimeCombo endDateTimeField;
    
    private XDateTimeCombo actualEndDateTimeField;
    
    private CTimeSheet actualTimeField;
    
    private XDateTimeCombo reminderDateTimeField;
    
    private XComboEdit projectField;
    
    private XComboEdit documentField;
    
    private XCurrencyField percentCompleteField;
    
    
    
    private XTextArea descriptionField;

   

    ////
    private Composite itemsPanel;

    private TabFolder itemsTabFolder;
    
    ////
    private TabItem workerTabItem;
    private TabItem contactTabItem;
    
    private Table workerTable;
    private Table contactTable;    
    
    ////
    
    private double percentComplete;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public TaskEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	TabItem descriptionTabItem;
	Composite composite;
	GridLayout gridLayout;
	
	setTitle(Messages.getString("TaskEditForm.title")); //$NON-NLS-1$
	
	gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	

	setLayout(gridLayout);
	//setLayout(new FillLayout());
	GridData gridData;
	
	int LABEL_SHIFT = 20;

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("TaskEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	nameLabel = new Label(composite, SWT.NONE);
    	nameLabel.setText(Messages.getString("TaskEditForm.nameLabel.text")); //$NON-NLS-1$
    
    	nameField = new XTextField(composite, SWT.BORDER);
    	nameField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	nameField.setTextLimit(50);

    	taskNoLabel = new Label(composite, SWT.NONE);
    	taskNoLabel.setText(Messages.getString("TaskEditForm.taskNoLabel.text")); //$NON-NLS-1$

    	taskNoField = new XTextField(composite, SWT.BORDER);
    	GridData gridData_2 = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData_2.widthHint = 200;
    	taskNoField.setLayoutData(gridData_2);
    	taskNoField.setTextLimit(20);

    	taskTypeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = LABEL_SHIFT;
    	taskTypeLabel.setLayoutData(gridData);
    	taskTypeLabel.setText(Messages.getString("TaskEditForm.taskTypeLabel.text")); //$NON-NLS-1$

    	taskTypeField = new XComboEdit(composite, SWT.BORDER);
    	GridData gridData_1 = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData_1.widthHint = 200;
    	taskTypeField.setLayoutData(gridData_1);

    	startDateTimeLabel = new Label(composite, SWT.NONE);
    	startDateTimeLabel.setLayoutData(new GridData());
    	startDateTimeLabel.setText(Messages.getString("TaskEditForm.startDateTimeLabel.text")); //$NON-NLS-1$

    	startDateTimeField = new XDateTimeCombo(composite, SWT.BORDER);
    	startDateTimeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	
    	
    	taskPriorityLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = LABEL_SHIFT;
    	taskPriorityLabel.setLayoutData(gridData);
    	taskPriorityLabel.setText(Messages.getString("TaskEditForm.taskPriorityLabel.text")); //$NON-NLS-1$

    	taskPriorityField = new XComboEdit(composite, SWT.BORDER);
    	taskPriorityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	endDateTimeLabel = new Label(composite, SWT.NONE);
    	endDateTimeLabel.setText(Messages.getString("TaskEditForm.endDateTimeLabel.text")); //$NON-NLS-1$

    	endDateTimeField = new XDateTimeCombo(composite, SWT.BORDER);
    	endDateTimeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	actualEndDateTimeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = LABEL_SHIFT;
    	actualEndDateTimeLabel.setLayoutData(gridData);
    	actualEndDateTimeLabel.setText(Messages.getString("ProjectEditForm.actualEndLabel.text")); //$NON-NLS-1$

    	actualEndDateTimeField = new XDateTimeCombo(composite, SWT.BORDER);
    	actualEndDateTimeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	////
    	
    	workTimeLabel = new Label(composite, SWT.NONE);
    	workTimeLabel.setText(Messages.getString("TaskWorkerLinkEditForm.workTimeLabel.text")); //$NON-NLS-1$

    	workTimeField = new CTimeSheet(composite, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	workTimeField.setLayoutData(gridData);

    	////

    	actualTimeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = LABEL_SHIFT;
    	actualTimeLabel.setLayoutData(gridData);
    	actualTimeLabel.setText(Messages.getString("TaskWorkerLinkEditForm.actualTimeLabel.text")); //$NON-NLS-1$

    	actualTimeField = new CTimeSheet(composite, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	actualTimeField.setLayoutData(gridData);

    	////
    	descriptionTabItem = new TabItem(tabFolder, SWT.NONE);
    	descriptionTabItem.setText(Messages.getString("TaskEditForm.descriptionTabItem.text")); //$NON-NLS-1$

    	descriptionField = new XTextArea(tabFolder, SWT.MULTI);
    	descriptionField.setTextLimit(255);
    	descriptionField.setFixedHeight(100);
    	descriptionTabItem.setControl(descriptionField);
    	
    	
    	

    	Label label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));

    	reporterLabel = new Label(composite, SWT.NONE);
    	reporterLabel.setLayoutData(new GridData());
    	reporterLabel.setText(Messages.getString("TaskEditForm.reporterLabel.text")); //$NON-NLS-1$

    	reporterField = new XTextField(composite, SWT.BORDER);
    	reporterField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	reporterField.setEditable(false);
    	
    	////
    	
    	responsibleLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = LABEL_SHIFT;
    	responsibleLabel.setLayoutData(gridData);
    	responsibleLabel.setText(Messages.getString("TaskEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	

    	projectLabel = new Label(composite, SWT.NONE);
    	projectLabel.setText(Messages.getString("TaskEditForm.projectLabel.text")); //$NON-NLS-1$

    	projectField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	projectField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	projectField.setAssociationValueClass(Project.class);

    	documentLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = LABEL_SHIFT;
    	documentLabel.setLayoutData(gridData);
    	documentLabel.setText(Messages.getString("TaskEditForm.documentLabel.text")); //$NON-NLS-1$

    	documentField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	documentField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));

    	taskStatusLabel = new Label(composite, SWT.NONE);
    	taskStatusLabel.setLayoutData(new GridData());
    	taskStatusLabel.setText(Messages.getString("TaskEditForm.projectStatusLabel.text")); //$NON-NLS-1$

    	taskStatusField = new XComboEdit(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 200;
    	taskStatusField.setLayoutData(gridData);
    	taskStatusField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    		updateTaskStatus();
    	    }
    	});

    	percentCompleteLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = LABEL_SHIFT;
    	percentCompleteLabel.setLayoutData(gridData);
    	percentCompleteLabel.setText(Messages.getString("TaskEditForm.percentCompleteLabel.text")); //$NON-NLS-1$

    	percentCompleteField = new XCurrencyField(composite, SWT.BORDER);
    	percentCompleteField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	percentCompleteField.addFocusListener(new FocusAdapter() {
    	    public void focusLost(FocusEvent evt) {
    		percentComplete = percentCompleteField.doubleValue();
    	    }
    	});
    	////
    	
	reminderDateTimeLabel = new Label(composite, SWT.NONE);
    	reminderDateTimeLabel.setText(Messages.getString("TaskEditForm.reminderDateTimeLabel.text")); //$NON-NLS-1$

    	reminderDateTimeField = new XDateTimeCombo(composite, SWT.BORDER);
    	reminderDateTimeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	partnerLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = LABEL_SHIFT;
    	partnerLabel.setLayoutData(gridData);
    	partnerLabel.setText(Messages.getString("TaskEditForm.partnerLabel.text")); //$NON-NLS-1$

    	partnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 200;
    	partnerField.setLayoutData(gridData);
    	partnerField.setAssociationValueClass(Partner.class);
    	
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);

    	createItemPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemsTabFolder, Task.class);
    	FileView fileView = new FileView(itemsTabFolder, Task.class);

    	this.setSize(new Point(590, 261));
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new TaskWorkerProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), new TaskContactProvider());
    	registerEntityProvider(itemsTabFolder.getItem(2), attributeView.getEntityProvider());
    	registerEntityProvider(itemsTabFolder.getItem(3), fileView.getEntityProvider());
    	
    	initDocumentField(documentField);
    	initResponsibleField(responsibleField);
    	

    }
    
    private Task getTask() {
	return (Task) getEntity();
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	
	Date activeDate = CalendarHelper.getActiveDate(this);
	Date date = activeDate == null ? EnterpriseEnvironment.getDate() : activeDate;

	getTask().setStartDateTime(date);
	getTask().setEndDateTime(date);

	getTask().setPartner(ProjectEnvironment.getPartner());
	getTask().setTaskType(TaskEnvironment.getDefaultTaskType());
	getTask().setTaskPriority(TaskEnvironment.getDefaultTaskPriority());
	getTask().setTaskStatus(TaskEnvironment.getDefaultTaskStatus());
	getTask().setReporter(getDefaultResponsible());
	getTask().setResponsible(getDefaultResponsible());
	getTask().setProject(TaskEnvironment.getProject());
	
    }
	
    protected void bindControls() {
	bindControl(taskNoField, "taskNo");
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(taskTypeField, "taskType", taskTypeLabel, REQUIRED);	
	bindControl(reporterField, "reporterName");
	bindControl(responsibleField, "responsible", responsibleLabel, REQUIRED);	
	bindControl(partnerField, "partner");	
	bindControl(taskStatusField, "taskStatus", taskStatusLabel, REQUIRED);
	
	bindControl(startDateTimeField, "startDateTime");	
	bindControl(endDateTimeField, "endDateTime");
	bindControl(actualEndDateTimeField, "actualEndDateTime");
	bindControl(reminderDateTimeField, "reminderDateTime");
	bindControl(taskPriorityField, "taskPriority", taskPriorityLabel, REQUIRED);
	bindControl(projectField, "project");
	bindControl(documentField, "document");
	bindControl(percentCompleteField, "percentComplete");
	bindControl(descriptionField, "description");
    }

    private void updateTaskStatus() {
	if (taskStatusField == null || percentCompleteField == null) {
	    return;
	}
	TaskStatus taskStatus = (TaskStatus) taskStatusField.getValue();
	boolean isCompleted = isCompletedTaskStatus(taskStatus);
	percentCompleteField.setEnabled(!isCompleted);
	percentCompleteField.setValue(isCompleted ? Task.PERCENT_COMPLETED : percentComplete);
    }
    
    private boolean isCompletedTaskStatus(TaskStatus taskStatus) {
	return taskStatus != null && TaskStatus.COMPLETED_STATUS.equals(taskStatus.getCode());
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
        
        workerTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        workerTabItem.setText(Messages.getString("TaskEditForm.workerTabItem.text")); //$NON-NLS-1$

         
        workerTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        workerTable.setHeaderVisible(true);
        workerTable.setLinesVisible(true);
        workerTabItem.setControl(workerTable);

        TableColumn newColumnTableColumn = new TableColumn(workerTable, SWT.NONE);
        newColumnTableColumn.setResizable(false);
        newColumnTableColumn.setWidth(20);

        TableColumn workerTableColumn = new TableColumn(workerTable, SWT.NONE);
        workerTableColumn.setWidth(300);
        workerTableColumn.setText(Messages.getString("TaskEditForm.workerTableColumn.text")); //$NON-NLS-1$

        TableColumn workTimeTableColumn = new TableColumn(workerTable, SWT.NONE);
        workTimeTableColumn.setWidth(120);
        workTimeTableColumn.setText(Messages.getString("TaskEditForm.workTimeTableColumn.text")); //$NON-NLS-1$

        TableColumn actualTimeTableColumn = new TableColumn(workerTable, SWT.NONE);
        actualTimeTableColumn.setWidth(120);
        actualTimeTableColumn.setText(Messages.getString("TaskEditForm.actualTimeTableColumn.text")); //$NON-NLS-1$

        TableColumn workCostTableColumn = new TableColumn(workerTable, SWT.RIGHT);
        workCostTableColumn.setWidth(120);
        workCostTableColumn.setText(Messages.getString("TaskEditForm.workCostTableColumn.text")); //$NON-NLS-1$

        ////
        
        contactTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        contactTabItem.setText(Messages.getString("TaskEditForm.contactTabItem.text")); //$NON-NLS-1$

         
        contactTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        contactTable.setHeaderVisible(true);
        contactTable.setLinesVisible(true);
        contactTabItem.setControl(contactTable);

        newColumnTableColumn = new TableColumn(contactTable, SWT.NONE);
        newColumnTableColumn.setResizable(false);
        newColumnTableColumn.setWidth(20);

        TableColumn contactTableColumn = new TableColumn(contactTable, SWT.NONE);
        contactTableColumn.setWidth(300);
        contactTableColumn.setText(Messages.getString("TaskEditForm.contactTableColumn.text")); //$NON-NLS-1$

        TableColumn contactRoleTableColumn = new TableColumn(contactTable, SWT.NONE);
        contactRoleTableColumn.setWidth(200);
        contactRoleTableColumn.setText(Messages.getString("TaskEditForm.contactRoleTableColumn.text")); //$NON-NLS-1$

    }
    
   protected class TaskWorkerProvider extends TableEntityProvider {
	
	public TaskWorkerProvider() {
	    setParentEntityClass(Task.class); // OWNER
	    setListProperty("taskWorkerLinks");
	    setAddMethod("addTaskWorkerLink");
	    
	    setEntityClass(TaskWorkerLink.class); // FORM ID
	}
	
	protected Table getTable() {
	    return workerTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "workerName");
	    bindColumn(2, "workTimeString");
	    bindColumn(3, "actualTimeString");
	    bindColumn(4, "workCost", getCurrencyFormat());
	}
    }

   protected class TaskContactProvider extends TableEntityProvider {
	
	public TaskContactProvider() {
	    setParentEntityClass(Task.class); // OWNER
	    setListProperty("taskContactLinks");
	    setAddMethod("addTaskContactLink");
	    
	    setEntityClass(TaskContactLink.class); // FORM ID
	}
	
	protected Table getTable() {
	    return contactTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "contactName");
	    bindColumn(2, "taskRole");
	}
   }



    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	workTimeField.setTimeSheet(getTask().getWorkTime());
	actualTimeField.setTimeSheet(getTask().getActualTime());
	percentComplete = getTask().getPercentComplete();
	updateTaskStatus();
    }
    
    public void updateData() throws ApplicationException {
	super.updateData();
	getTask().setWorkTime(workTimeField.getTimeSheet());
	getTask().setActualTime(actualTimeField.getTimeSheet());
    }    

}  //  @jve:decl-index=0:visual-constraint="10,10"
