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
 * Created on 15.05.2006
 *
 */

package org.plazmaforge.bsolution.finance.client.swing.forms;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.finance.client.swing.GUIFinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocumentType;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntry;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntryItem;
import org.plazmaforge.bsolution.finance.common.services.FinanceDocumentTypeService;
import org.plazmaforge.bsolution.finance.common.services.TemplateEntryService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.AbstractChildType;
import org.plazmaforge.framework.client.swing.forms.EXTParentEditForm;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.StateTableModel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class TemplateEntryEdit extends EXTParentEditForm {

    private JLabel codeLabel;

    private JLabel documentTypeLabel;

    private JLabel nameLabel;

    private XTextField codeField;

    private XComboBox documentTypeField;

    private XTextField nameField;

    private XTextEdit noteField;

    public TemplateEntryEdit() throws ApplicationException {
	super(GUIFinanceEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(TemplateEntry.class);
	this.setEntityServiceClass(TemplateEntryService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	getParentPane().setLayout(new BorderLayout());
	setParentTabbedPane(createMasterTabbedPane());
	addParentTabbedPane();

	setChildrenTabbedPane(createItemsTabbedPane());
	addChildrenTabbedPane();

    }

    private JPanel createCommonPanel() throws ApplicationException {
	codeLabel = new JLabel(getString("panel.label-code.text"));
	documentTypeLabel = new JLabel(getString("panel.label-document-type.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	documentTypeField = new XComboBox(getDocumentTypeService().findAll());
	nameField = new XTextField(40);
	nameField.setMaxChar(50);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(documentTypeLabel);
	editPanel.addByY(nameLabel);

	gbc.gridy = 0;
	editPanel.addByX(codeField);
	editPanel.addByY(documentTypeField);
	editPanel.addByY(nameField);

	return editPanel;
    }

    protected JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private JTabbedPane createMasterTabbedPane() throws ApplicationException {
	JTabbedPane tp = new JTabbedPane();
	tp.addTab(getString("panel.title.common.text"), createCommonPanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	return tp;
    }

    private FinanceDocumentTypeService getDocumentTypeService() {
	return (FinanceDocumentTypeService) getSERVICE(FinanceDocumentTypeService.class);
    }

    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(700, 200);
	tp.addTab(getString("table-entry-item.name"), createItemPanel());
	return tp;
    }

    private JTable entryItemTable;

    private JComponent createItemPanel() throws ApplicationException {
	entryItemTable = createChildTable(createItemTableModel());
	JScrollPane scroll = new JScrollPane(entryItemTable);
	this.registerEntityType(scroll, new EntryItemType());
	return scroll;
    }

    protected TableModel createItemTableModel() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();

	d.setName(getString("table-entry-item.column-debit-account-exp.name"));
	d.setFieldName("debitLedgerAccountExpression");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-entry-item.column-debit-object-exp.name"));
	d.setFieldName("debitObjectExpression");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-entry-item.column-credit-account-exp.name"));
	d.setFieldName("creditLedgerAccountExpression");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-entry-item.column-credit-object-exp.name"));
	d.setFieldName("creditObjectExpression");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-entry-item.column-amount-exp.name"));
	d.setFieldName("amountExpression");
	d.setColumnClass(String.class);
	d.setSize(70);
	columns.add(d);

	return createObjectTableModel(TemplateEntryItem.class, columns);
    }

    protected class EntryItemType extends AbstractChildType {
	public JTable getTable() {
	    return entryItemTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(TemplateEntryItemEdit.class);
	}
    }

    protected EditForm getEditChildForm() throws ApplicationException {
	EditForm form = super.getEditChildForm();
	((TemplateEntryItemEdit) form).setTemplateEntry(getTemplateEntry());
	return form;
    }

    private TemplateEntry getTemplateEntry() {
	return (TemplateEntry) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getTemplateEntry().getName());
	codeField.setText(getTemplateEntry().getCode());
	documentTypeField.setValue(getTemplateEntry().getFinanceDocumentType());
	nameField.setText(getTemplateEntry().getName());
	noteField.setText(getTemplateEntry().getNote());
	((StateTableModel) entryItemTable.getModel()).addData(getTemplateEntry().getItems());
    }

    protected void populateData() throws ApplicationException {
	getTemplateEntry().setCode(codeField.getText());
	getTemplateEntry().setFinanceDocumentType((FinanceDocumentType) documentTypeField.getValue());
	getTemplateEntry().setName(nameField.getText());
	getTemplateEntry().setNote(noteField.getText());

    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getTemplateEntry().getCode(), codeLabel.getText());
	checkError(buf);
    }

}
