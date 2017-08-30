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
 * Created on 04.02.2007
 *
 */

package org.plazmaforge.bsolution.document.client.swt.forms;


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
import org.plazmaforge.bsolution.base.client.swt.forms.SystemEntityListForm;
import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.bsolution.document.DocumentEnvironment;
import org.plazmaforge.bsolution.document.common.beans.DocumentRelation;
import org.plazmaforge.bsolution.document.common.beans.DocumentStatus;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: DocumentTypeEditForm.java,v 1.3 2010/12/05 07:57:19 ohapon Exp $
 */

public class DocumentTypeEditForm extends AbstractEditForm {

    private Label entityLabel;
    
    private Label sectionLabel;
    
    private Label categoryLabel;
    
    private Label useNumeratorLabel;
    
    private Label documentNoPrefixLabel;
    
    private Label documentNoSuffixLabel;
    
    private Label lastDocumentNumberLabel;
    
    private Label documentNoReadOnlyLabel;
    
    private Label documentDateReadOnlyLabel;
    
    
    private XComboEdit entityField;
    
    private XTextField sectionField;
    
    private XTextField categoryField;
    
    private XCheckBox useNumeratorField;
    
    private XTextField documentNoPrefixField;
    
    private XTextField documentNoSuffixField;
    
    private XIntegerField lastDocumentNumberField;
    
    private XCheckBox documentNoReadOnlyField;
    
    private XCheckBox documentDateReadOnlyField;
    
    ////
    
    private TabFolder tabFolder;
    
    private TabItem generalTabItem;

    private TabItem dependencyTabItem;
    
    private TabItem statusTabItem;
    
    ////
    
    private Table dependencyTable;
    
    private Table statusTable;
    

    /**
     * Create the form
     * @param parent
     * @param style
     */
    public DocumentTypeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setTitle(Messages.getString("DocumentTypeEditForm.title")); //$NON-NLS-1$
	
	setLayout(new FillLayout());
	
	tabFolder = new TabFolder(this, SWT.NONE);

	// GENERAL
	createGenaralTab();
	
	// STATUSES
	createStatusesTab();
	
	// DEPENDENCIES
	createDependeciesTab();
	
	registerEntityProvider(tabFolder.getItem(1), new DocumentStatusProvider());
	registerEntityProvider(tabFolder.getItem(2), new DocumentRelationProvider());
    }
    
    private void createGenaralTab() {
	
	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("DocumentTypeEditForm.generalTabItem.text")); //$NON-NLS-1$

    	Composite composite = new Composite(tabFolder, SWT.NONE);
    	generalTabItem.setControl(composite);
    	
	GridData gridData;
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	composite.setLayout(gridLayout);
    	
    	
    	entityLabel = new Label(composite, SWT.NONE);
    	entityLabel.setText(Messages.getString("DocumentTypeEditForm.entityLabel.text")); //$NON-NLS-1$

    	entityField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	entityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	sectionLabel = new Label(composite, SWT.NONE);
    	sectionLabel.setText(Messages.getString("DocumentTypeEditForm.sectionLabel.text")); //$NON-NLS-1$

    	sectionField = new XTextField(composite, SWT.BORDER);
    	sectionField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	sectionField.setTextLimit(20);
    
    	categoryLabel = new Label(composite, SWT.NONE);
    	categoryLabel.setText(Messages.getString("DocumentTypeEditForm.categoryLabel.text")); //$NON-NLS-1$

    	categoryField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 300;
    	categoryField.setLayoutData(gridData);
    	categoryField.setTextLimit(20);

    	new Label(composite, SWT.NONE); new Label(composite, SWT.NONE);
    	
    	useNumeratorLabel = new Label(composite, SWT.NONE);
    	useNumeratorLabel.setText(Messages.getString("DocumentTypeEditForm.useNumeratorLabel.text")); //$NON-NLS-1$

    	useNumeratorField = new XCheckBox(composite, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	useNumeratorField.setLayoutData(gridData);
    	useNumeratorField.addSelectionListener(new SelectionAdapter() {
    	    public void widgetSelected(SelectionEvent e) {
    		setNumerationEnabled();
    	    }
    	});

    	///
    	
    	documentNoPrefixLabel = new Label(composite, SWT.NONE);
    	documentNoPrefixLabel.setText(Messages.getString("DocumentTypeEditForm.documentNoPrefixLabel.text")); //$NON-NLS-1$

    	documentNoPrefixField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 300;
    	documentNoPrefixField.setLayoutData(gridData);
    	documentNoPrefixField.setTextLimit(10);

    	////
    	documentNoSuffixLabel = new Label(composite, SWT.NONE);
    	documentNoSuffixLabel.setText(Messages.getString("DocumentTypeEditForm.documentNoSuffixLabel.text")); //$NON-NLS-1$

    	documentNoSuffixField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 300;
    	documentNoSuffixField.setLayoutData(gridData);
    	documentNoSuffixField.setTextLimit(10);

    	////
    	lastDocumentNumberLabel = new Label(composite, SWT.NONE);
    	lastDocumentNumberLabel.setText(Messages.getString("DocumentTypeEditForm.lastDocumentNumberLabel.text")); //$NON-NLS-1$

    	lastDocumentNumberField = new XIntegerField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    	gridData.widthHint = 100;
    	lastDocumentNumberField.setLayoutData(gridData);
    	lastDocumentNumberField.setPattern("#,###,###,##0");

    	////
    	new Label(composite, SWT.NONE); new Label(composite, SWT.NONE);
    	////
    	
    	documentNoReadOnlyLabel = new Label(composite, SWT.NONE);
    	documentNoReadOnlyLabel.setText(Messages.getString("DocumentTypeEditForm.documentNoReadOnlyLabel.text")); //$NON-NLS-1$

    	documentNoReadOnlyField = new XCheckBox(composite, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	documentNoReadOnlyField.setLayoutData(gridData);

    	////
    	documentDateReadOnlyLabel = new Label(composite, SWT.NONE);
    	documentDateReadOnlyLabel.setText(Messages.getString("DocumentTypeEditForm.documentDateReadOnlyLabel.text")); //$NON-NLS-1$

    	documentDateReadOnlyField = new XCheckBox(composite, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	documentDateReadOnlyField.setLayoutData(gridData);

    	this.setSize(new Point(470, 108));
    	
    	entityField.setServiceClass(SystemEntityService.class);
    	entityField.setListFormClass(SystemEntityListForm.class);
    	//entityField.setEditFormClass(SystemEntityEditForm.class);
    }
    
    
    
    
    private void createStatusesTab() {
	
	////
	statusTabItem = new TabItem(tabFolder, SWT.NONE);
	statusTabItem.setText(Messages.getString("DocumentTypeEditForm.statusTabItem.text")); //$NON-NLS-1$

       	Composite composite = new Composite(tabFolder, SWT.NONE);
       	GridLayout gridLayout = new GridLayout();
    	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
	
    	composite.setLayout(gridLayout);
    	statusTabItem.setControl(composite);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(composite, SWT.NONE, PWT.ADD_BUTTON | PWT.EDIT_BUTTON | PWT.DELETE_BUTTON);
    	itemToolPanel.setForm(this);
    	
    	
    	statusTable = new Table(composite, SWT.MULTI | SWT.FULL_SELECTION);
    	statusTable.setHeaderVisible(true);
    	statusTable.setLinesVisible(true);
    	statusTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
     
   
        TableColumn newColumnTableColumn = new TableColumn(statusTable, SWT.NONE);
        newColumnTableColumn.setResizable(false);
        newColumnTableColumn.setWidth(20);

        TableColumn statusCodeColumn = new TableColumn(statusTable, SWT.NONE);
        statusCodeColumn.setWidth(150);
        statusCodeColumn.setText(Messages.getString("DocumentTypeEditForm.statusCodeColumn.text")); //$NON-NLS-1$

        TableColumn statusNameColumn = new TableColumn(statusTable, SWT.NONE);
        statusNameColumn.setWidth(300);
        statusNameColumn.setText(Messages.getString("DocumentTypeEditForm.statusNameColumn.text")); //$NON-NLS-1$

    }

    private void createDependeciesTab() {
	
	////
	dependencyTabItem = new TabItem(tabFolder, SWT.NONE);
       	dependencyTabItem.setText(Messages.getString("DocumentTypeEditForm.dependencyTabItem.text")); //$NON-NLS-1$

       	Composite composite = new Composite(tabFolder, SWT.NONE);
       	GridLayout gridLayout = new GridLayout();
    	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
	
    	composite.setLayout(gridLayout);
    	dependencyTabItem.setControl(composite);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(composite, SWT.NONE, PWT.ADD_BUTTON | PWT.EDIT_BUTTON | PWT.DELETE_BUTTON);
    	itemToolPanel.setForm(this);
    	
    	
    	dependencyTable = new Table(composite, SWT.MULTI | SWT.FULL_SELECTION);
        dependencyTable.setHeaderVisible(true);
        dependencyTable.setLinesVisible(true);
        dependencyTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
     
   
        TableColumn newColumnTableColumn = new TableColumn(dependencyTable, SWT.NONE);
        newColumnTableColumn.setResizable(false);
        newColumnTableColumn.setWidth(20);

        TableColumn documentTypeCodeColumn = new TableColumn(dependencyTable, SWT.NONE);
        documentTypeCodeColumn.setWidth(150);
        documentTypeCodeColumn.setText(Messages.getString("DocumentTypeEditForm.documentTypeCodeColumn.text")); //$NON-NLS-1$

        TableColumn documentTypeNameColumn = new TableColumn(dependencyTable, SWT.NONE);
        documentTypeNameColumn.setWidth(300);
        documentTypeNameColumn.setText(Messages.getString("DocumentTypeEditForm.documentTypeNameColumn.text")); //$NON-NLS-1$

    }

    protected void bindControls() {
	bindControl(entityField, "entity", entityLabel, REQUIRED);
	bindControl(sectionField, "documentSection");
	bindControl(categoryField, "documentCategory");
	
	bindControl(useNumeratorField, "useNumerator");
	bindControl(documentNoPrefixField, "documentNoPrefix");
	bindControl(documentNoSuffixField, "documentNoSuffix");	
	bindControl(lastDocumentNumberField, "lastDocumentNumber");
	bindControl(documentNoReadOnlyField, "documentNoReadOnly");	
	bindControl(documentDateReadOnlyField, "documentDateReadOnly");

	
    }
    
    private boolean initNumeration;  
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	
	initNumeration = true;
	setNumerationEnabled();
    }
    
    private void setNumerationEnabled() {
	if (!initNumeration) {
	    return;
	}
	boolean useNumeration = useNumeratorField.booleanValue();
	documentNoPrefixField.setEnabled(useNumeration);
	documentNoSuffixField.setEnabled(useNumeration);
	lastDocumentNumberField.setEnabled(useNumeration);
	documentNoReadOnlyField.setEnabled(useNumeration);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    
    protected Object getSelectedEntityProviderKey() {
        int index = tabFolder.getSelectionIndex();
        return tabFolder.getItem(index);
    }

    protected class DocumentStatusProvider extends TableEntityProvider {
	
	public DocumentStatusProvider() {
	    setParentEntityClass(DocumentType.class); // OWNER
	    setEntityClass(DocumentStatus.class); // FORM ID
	    setListProperty("statuses");
	    setAddMethod("addStatus", DocumentStatus.class);
	}
	
	public IEditForm getEditForm() {
	    IEditForm editForm = super.getEditForm();
	    
	    // Set child mode 
	    if (editForm != null) {
		editForm.setChildFormMode(true);
	    }
	    
	    return editForm;
	}
	
	protected Table getTable() {
	    return statusTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "code");
	    bindColumn(2, "name");
	}
    }

    protected class DocumentRelationProvider extends TableEntityProvider {
	
	public DocumentRelationProvider() {
	    setParentEntityClass(DocumentType.class); // OWNER
	    setEntityClass(DocumentRelation.class); // FORM ID
	    setListProperty("relations");
	    setAddMethod("addRelation", DocumentRelation.class);
	}
	
	public IEditForm getEditForm() {
	    IEditForm editForm = super.getEditForm();
	    
	    // Set child mode 
	    if (editForm != null) {
		editForm.setChildFormMode(true);
	    }
	    
	    return editForm;
	}
	
	protected Table getTable() {
	    return dependencyTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "childTypeCode");
	    bindColumn(2, "childTypeName");
	}
    }

    protected void fireUpdateData() throws ApplicationException {
	super.fireUpdateData();
	DocumentEnvironment.refreshContext();
    }


}  //  @jve:decl-index=0:visual-constraint="10,10"