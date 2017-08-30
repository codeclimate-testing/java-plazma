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

import org.plazmaforge.bsolution.inventory.common.beans.InventoryMove;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryMoveItem;
import org.plazmaforge.bsolution.inventory.common.services.InventoryMoveService;
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
 * Time: 20:05:03
 * $Id: GoodsMoveEdit.java,v 1.5 2010/12/05 07:56:43 ohapon Exp $
 */
public class GoodsMoveEdit extends AbstractGoodsDocumentEdit {

    private JLabel outcomeWarehouseLabel;            // Warehouse 1 (FROM)
    private JLabel incomeWarehouseLabel;             // Warehouse 2 (TO)

    private JLabel outcomeResponsibleLabel;         // Responsible 1 (FROM)   
    private JLabel incomeResponsibleLabel;          // Responsible 2 (TO)


    private XComboEdit outcomeWarehouseComboEdit;    // Warehouse 1 (FROM)
    private XComboEdit incomeWarehouseComboEdit;     // Warehouse 2 (TO)

    private XComboEdit outcomeResponsibleComboEdit; // Responsible 1 (FROM)  
    private XComboEdit incomeResponsibleComboEdit;  // Responsible 2 (TO)


    public GoodsMoveEdit() {
	super();
	initialize();
    }

    private void initialize() {
	this.setEntityClass(InventoryMove.class);
	this.setEntityServiceClass(InventoryMoveService.class);
	this.setEntityCode(InventoryMove.CLASS_ID);
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
	GridBagPanel editPanel = new GridBagPanel();

	codeLabel = new JLabel(getString("panel.label-code.text"));
	dateLabel = new JLabel(getString("panel.label-date.text"));
	outcomeWarehouseLabel = new JLabel(getString("panel.label-outcome-storable.text"));
	incomeWarehouseLabel = new JLabel(getString("panel.label-income-storable.text"));
	outcomeResponsibleLabel = new JLabel(getString("panel.label-outcome-responsible.text"));
	incomeResponsibleLabel = new JLabel(getString("panel.label-income-responsible.text"));

	currencyAmountLabel = new JLabel(getString("panel.label-currency-amount.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	dateField = new XDateField();

	outcomeWarehouseComboEdit = new XComboEdit();
	outcomeWarehouseComboEdit.setColumns(30);
	incomeWarehouseComboEdit = new XComboEdit();
	incomeWarehouseComboEdit.setColumns(30);

	outcomeResponsibleComboEdit = new XComboEdit(true);
	outcomeResponsibleComboEdit.setColumns(30);
	incomeResponsibleComboEdit = new XComboEdit(true);
	incomeResponsibleComboEdit.setColumns(30);

	currencyAmountField = new XCurrencyField();
	currencyAmountField.setEditable(false);

	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(codeField);
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByX(dateLabel);
	editPanel.addByX(dateField);

	// Outcome
	gbc.gridx = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(outcomeWarehouseLabel);
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(outcomeWarehouseComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(outcomeResponsibleLabel);
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(outcomeResponsibleComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 4;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByY(new JSeparator());

	// Income
	gbc.gridx = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(incomeWarehouseLabel);
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(incomeWarehouseComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(incomeResponsibleLabel);
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(incomeResponsibleComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	//gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(currencyAmountLabel);
	editPanel.addByX(currencyAmountField);

	outcomeWarehouseComboEdit.initListFormAction(this, StorableList.class, "warehouseId", "fullName");
	outcomeResponsibleComboEdit.initListFormAction(this, ResponsibleList.class, "employeeName");
	incomeWarehouseComboEdit.initListFormAction(this, StorableList.class, "warehouseId", "fullName");
	incomeResponsibleComboEdit.initListFormAction(this, ResponsibleList.class, "employeeName");

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
	d.setSize(65);
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

	return createObjectTableModel(InventoryMoveItem.class, columns);
    }

    private InventoryMove getGoodsMove() {
	return (InventoryMove) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getGoodsMove().getOutcomeWarehouseName());
	codeField.setText(getGoodsMove().getDocumentNo());
	dateField.setDate(getGoodsMove().getDocumentDate());
	outcomeWarehouseComboEdit.setValue(getGoodsMove().getOutcomeWarehouse());
	outcomeResponsibleComboEdit.setValue(getGoodsMove().getOutcomeMtrlResponsible());
	incomeWarehouseComboEdit.setValue(getGoodsMove().getIncomeWarehouse());
	incomeResponsibleComboEdit.setValue(getGoodsMove().getIncomeMtrlResponsible());
	currencyAmountField.setValue(getGoodsMove().getCurrencyAmount());
	noteField.setText(getGoodsMove().getNote());

	AbstractStateTableModel productItemModel = (AbstractStateTableModel) productItemTable.getModel();
	productItemModel.addData(getGoodsMove().getProductItems());
    }

    private void updateAmount() {
	getGoodsMove().calculateGeneral();
	currencyAmountField.setValue(getGoodsMove().getCurrencyAmount());
    }

    protected void afterRefreshChildData() throws ApplicationException {
	updateAmount();
    }

    protected void populateData() throws ApplicationException {
	getGoodsMove().setDocumentNo(codeField.getText());
	getGoodsMove().setDocumentDate(dateField.getDate());
	getGoodsMove().setOutcomeWarehouse((Warehouse) outcomeWarehouseComboEdit.getValue());
	getGoodsMove().setOutcomeMtrlResponsible((MtrlResponsible) outcomeResponsibleComboEdit.getValue());
	getGoodsMove().setIncomeWarehouse((Warehouse) incomeWarehouseComboEdit.getValue());
	getGoodsMove().setIncomeMtrlResponsible((MtrlResponsible) incomeResponsibleComboEdit.getValue());
	getGoodsMove().setCurrencyAmount(currencyAmountField.doubleValue());
	getGoodsMove().setNote(noteField.getText());
	getGoodsMove().calculate();
    }

    private class ProductItemType extends AbstractChildType {
	public JTable getTable() {
	    return productItemTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(GoodsMoveItemEdit.class);
	}
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getGoodsMove().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getGoodsMove().getOutcomeWarehouse(),	outcomeWarehouseLabel.getText());
	validateRequiredField(buf, getGoodsMove().getIncomeWarehouse(), incomeWarehouseLabel.getText());
	checkError(buf);
    }

}

