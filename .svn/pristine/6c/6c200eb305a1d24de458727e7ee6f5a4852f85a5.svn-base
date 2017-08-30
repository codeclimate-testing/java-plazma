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

package org.plazmaforge.bsolution.goods.client.swing.forms;


import javax.swing.*;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryWriteoff;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryWriteoffItem;
import org.plazmaforge.bsolution.inventory.common.services.InventoryWriteoffService;
import org.plazmaforge.bsolution.organization.client.swing.forms.ResponsibleList;
import org.plazmaforge.bsolution.organization.client.swing.forms.StorableList;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.AbstractChildType;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.GUIEnvironment;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.client.swing.gui.table.AbstractStateTableModel;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleh Hapon
 * Date: 28.06.2004
 * Time: 20:05:17
 * $Id: GoodsWriteoffEdit.java,v 1.5 2010/12/05 07:56:43 ohapon Exp $
 */
public class GoodsWriteoffEdit extends AbstractGoodsDocumentEdit {

    private JLabel warehouseLabel; // Warehouse WRITE OFF

    private JLabel responsibleLabel; // Responsible

    private JLabel currencyAmountLabel;

    private XComboEdit warehouseComboEdit; // Warehouse WRITE OFF

    private XComboEdit responsibleComboEdit; // Responsible Employee

    public GoodsWriteoffEdit() {
	super();
	initialize();
    }

    private void initialize() {
	this.setEntityClass(InventoryWriteoff.class);
	this.setEntityServiceClass(InventoryWriteoffService.class);
	this.setEntityCode(InventoryWriteoff.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	getParentPane().setLayout(new BorderLayout());
	setParentTabbedPane(createMasterTabbedPane());
	setChildrenTabbedPane(createItemsTabbedPane());
	addParentTabbedPane();
	addChildrenTabbedPane();
    }

    private JTabbedPane createMasterTabbedPane() throws ApplicationException {
	JTabbedPane tp = new JTabbedPane();
	tp.addTab(getString("panel.title.common.text"), createCommonPanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	return tp;
    }

    private JPanel createCommonPanel() throws ApplicationException {
	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	dateLabel = new JLabel(getString("panel.label-date.text"));
	warehouseLabel = new JLabel(getString("panel.label-storable.text"));
	responsibleLabel = new JLabel(getString("panel.label-responsible.text"));
	currencyAmountLabel = new JLabel(getString("panel.label-currency-amount.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	dateField = new XDateField();
	warehouseComboEdit = new XComboEdit();
	warehouseComboEdit.setColumns(30);
	responsibleComboEdit = new XComboEdit(true);
	responsibleComboEdit.setColumns(30);

	currencyAmountField = new XCurrencyField();
	currencyAmountField.setEditable(false);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(codeField);
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByX(dateLabel);
	editPanel.addByX(dateField);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(warehouseLabel);
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(warehouseComboEdit);

	gbc.gridx = 0;
	editPanel.addByY(responsibleLabel);
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(responsibleComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(currencyAmountLabel);
	editPanel.addByX(currencyAmountField);

	warehouseComboEdit.initListFormAction(this, StorableList.class, "warehouseId", "fullName");
	responsibleComboEdit.initListFormAction(this, ResponsibleList.class, "employeeName");
	return editPanel;
    }

    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(600, 200);
	tp.addTab(getString("table-product-item.name"), createItemPanel());
	return tp;
    }

    private JComponent createItemPanel() throws ApplicationException {
	productItemTable = createChildTable(createItemTableModel());
	productItemTable.getColumn(getString("table-product-item.column-currency-price.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
	productItemTable.getColumn(getString("table-product-item.column-currency-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
	JScrollPane scroll = new JScrollPane(productItemTable);
	this.registerEntityType(scroll, new ProductItemType());
	return scroll;
    }

    protected TableModel createItemTableModel() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table-product-item.column-product-name.name"));
	d.setFieldName("productName");
	d.setColumnClass(String.class);
	d.setSize(45);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-item.column-unit.name"));
	d.setFieldName("unitName");
	d.setColumnClass(String.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-item.column-unit-rate.name"));
	d.setFieldName("unitRate");
	d.setColumnClass(Double.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-item.column-quantity.name"));
	d.setFieldName("quantity");
	d.setColumnClass(Float.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-item.column-currency-price.name"));
	d.setFieldName("currencyPrice");
	d.setColumnClass(Float.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-item.column-currency-amount.name"));
	d.setFieldName("currencyAmount");
	d.setColumnClass(Double.class);
	d.setSize(20);
	columns.add(d);

	return createObjectTableModel(InventoryWriteoffItem.class, columns);
    }

    private InventoryWriteoff getGoodsWriteoff() {
	return (InventoryWriteoff) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getGoodsWriteoff().setMtrlResponsible(EnterpriseEnvironment.getMtrlResponsible());
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getGoodsWriteoff().getWarehouseName());
	codeField.setText(getGoodsWriteoff().getDocumentNo());
	dateField.setDate(getGoodsWriteoff().getDocumentDate());
	warehouseComboEdit.setValue(getGoodsWriteoff().getWarehouse());
	responsibleComboEdit.setValue(getGoodsWriteoff().getMtrlResponsible());

	currencyAmountField.setValue(getGoodsWriteoff().getCurrencyAmount());

	noteField.setText(getGoodsWriteoff().getNote());
	AbstractStateTableModel productItemModel = (AbstractStateTableModel) productItemTable.getModel();
	productItemModel.addData(getGoodsWriteoff().getProductItems());
    }

    private void updateAmount() {
	getGoodsWriteoff().calculateGeneral();
	currencyAmountField.setValue(getGoodsWriteoff().getCurrencyAmount());
    }

    protected void afterRefreshChildData() throws ApplicationException {
	updateAmount();
    }

    protected void populateData() throws ApplicationException {
	getGoodsWriteoff().setDocumentNo(codeField.getText());
	getGoodsWriteoff().setDocumentDate(dateField.getDate());
	getGoodsWriteoff().setWarehouse((Warehouse) warehouseComboEdit.getValue());
	getGoodsWriteoff().setMtrlResponsible((MtrlResponsible) responsibleComboEdit.getValue());

	getGoodsWriteoff().setCurrencyAmount(currencyAmountField.doubleValue());

	getGoodsWriteoff().setNote(noteField.getText());
	getGoodsWriteoff().calculate();
    }

    protected class ProductItemType extends AbstractChildType {
	public JTable getTable() {
	    return productItemTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(GoodsWriteoffItemEdit.class);
	}
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getGoodsWriteoff().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getGoodsWriteoff().getWarehouse(), warehouseLabel.getText());
	checkError(buf);
    }

}
