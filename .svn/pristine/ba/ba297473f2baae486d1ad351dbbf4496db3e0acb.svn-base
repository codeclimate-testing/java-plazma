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
 * Created on 2 �� 2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;


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
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntry;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntryItem;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: TemplateEntryEditForm.java,v 1.5 2010/12/05 07:57:18 ohapon Exp $
 */

public class TemplateEntryEditForm extends AbstractEditForm {


    private Label codeLabel;
    
    private Label financeDocumentTypeLabel;
    
    private Label nameLabel;    
    
    private Label entryClassLabel;

    
    private XTextField codeField;
    
    private XComboEdit financeDocumentTypeField;
    
    private XTextField nameField;    
    
    private XTextField entryClassField;

    
    private XTextArea noteField;

    
    
    
    private Composite itemsPanel;

    private Table entryTable;
    
    private TabFolder itemsTabFolder;
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public TemplateEntryEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	TabItem noteTabItem;
	Composite composite;
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	
	
	setTitle(Messages.getString("TemplateEntryEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("TemplateEntryEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	  	
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	codeLabel = new Label(composite, SWT.NONE);
    	codeLabel.setText(Messages.getString("TemplateEntryEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	final GridData gridData_1 = new GridData(200, SWT.DEFAULT);
    	codeField.setLayoutData(gridData_1);
    	codeField.setTextLimit(10);

    	financeDocumentTypeLabel = new Label(composite, SWT.NONE);
    	financeDocumentTypeLabel.setText(Messages.getString("TemplateEntryEditForm.financeDocumentTypeLabel.text")); //$NON-NLS-1$

    	financeDocumentTypeField = new XComboEdit(composite, SWT.BORDER);
    	final GridData gridData = new GridData(200, SWT.DEFAULT);
    	financeDocumentTypeField.setLayoutData(gridData);
    	
    	nameLabel = new Label(composite, SWT.NONE);
    	nameLabel.setText(Messages.getString("TemplateEntryEditForm.nameLabel.text")); //$NON-NLS-1$
    
    	nameField = new XTextField(composite, SWT.BORDER);
    	nameField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
    	nameField.setTextLimit(50);

	entryClassLabel = new Label(composite, SWT.NONE);
	entryClassLabel.setText(Messages.getString("TemplateEntryEditForm.entryClassLabel.text")); //$NON-NLS-1$
    
	entryClassField = new XTextField(composite, SWT.BORDER);
	entryClassField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	entryClassField.setTextLimit(50);
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("TemplateEntryEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

    	noteTabItem.setControl(noteField);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	
    	this.setSize(new Point(590, 261));    	
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new TemplateEntryItemProvider());
    }
    
   
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(nameField, "name");
	bindControl(financeDocumentTypeField, "financeDocumentType", financeDocumentTypeLabel, REQUIRED);
	bindControl(entryClassField, "entryClass");
	bindControl(noteField, "note");
    }

    
    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
        TableColumn newColumnTableColumn;
        GridLayout gridLayout;

        TabItem entryTabItem;
        
        
        
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
        gridData.widthHint = 600;
        itemsTabFolder.setLayoutData(gridData);

        entryTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        entryTabItem.setText(Messages.getString("TemplateEntryEditForm.entryTabItem.text")); //$NON-NLS-1$

        entryTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        entryTable.setHeaderVisible(true);
        entryTable.setLinesVisible(true);
        entryTabItem.setControl(entryTable);

        newColumnTableColumn = new TableColumn(entryTable, SWT.NONE);
        newColumnTableColumn.setResizable(false);
        newColumnTableColumn.setWidth(20);

        final TableColumn debitLedgerAccountColumn = new TableColumn(entryTable, SWT.NONE);
        debitLedgerAccountColumn.setWidth(100);
        debitLedgerAccountColumn.setText(Messages.getString("TemplateEntryEditForm.debitLedgerAccountColumn.text")); //$NON-NLS-1$

        final TableColumn debitObjectColumn = new TableColumn(entryTable, SWT.NONE);
        debitObjectColumn.setWidth(100);
        debitObjectColumn.setText(Messages.getString("TemplateEntryEditForm.debitObjectColumn.text")); //$NON-NLS-1$

        final TableColumn creditLedgerAccountColumn = new TableColumn(entryTable, SWT.NONE);
        creditLedgerAccountColumn.setWidth(100);
        creditLedgerAccountColumn.setText(Messages.getString("TemplateEntryEditForm.creditLedgerAccountColumn.text")); //$NON-NLS-1$

        final TableColumn creditObjectColumn = new TableColumn(entryTable, SWT.NONE);
        creditObjectColumn.setWidth(100);
        creditObjectColumn.setText(Messages.getString("TemplateEntryEditForm.creditObjectColumn.text")); //$NON-NLS-1$

        final TableColumn amountColumn = new TableColumn(entryTable, SWT.NONE);
        amountColumn.setWidth(200);
        amountColumn.setText(Messages.getString("TemplateEntryEditForm.amountColumn.text")); //$NON-NLS-1$

        final TableColumn contentColumn = new TableColumn(entryTable, SWT.NONE);
        contentColumn.setWidth(300);
        contentColumn.setText(Messages.getString("TemplateEntryEditForm.contentColumn.text")); //$NON-NLS-1$
    }
    
    
    
    protected class TemplateEntryItemProvider extends TableEntityProvider {
	
	public TemplateEntryItemProvider() {
	    setParentEntityClass(TemplateEntry.class);
	    setListProperty("items");
	    setAddMethod("addItem");
	    
	    setEntityClass(TemplateEntryItem.class); // FORM ID
	}
	
	protected Table getTable() {
	    return entryTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "debitLedgerAccountExpression");
	    bindColumn(2, "debitObjectExpression");
	    bindColumn(3, "creditLedgerAccountExpression");
	    bindColumn(4, "creditObjectExpression");
	    bindColumn(5, "amountExpression");
	    bindColumn(6, "content");
	}
    }
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }
    
    public void doHelpAction() throws ApplicationException {
	openPropertiesDialog(TemplateEntryUtilities.getHelpElements());
    }
    
 
    
}  //  @jve:decl-index=0:visual-constraint="10,10"