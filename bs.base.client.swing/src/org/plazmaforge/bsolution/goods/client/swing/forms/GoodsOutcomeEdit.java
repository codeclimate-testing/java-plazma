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
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.document.client.swing.forms.DocumentList;
import org.plazmaforge.bsolution.document.common.beans.DocumentHeader;
import org.plazmaforge.bsolution.finance.client.swing.forms.ContractList;
import org.plazmaforge.bsolution.finance.common.beans.IEnterValueHolder;
import org.plazmaforge.bsolution.goods.common.beans.GoodsOutcome;
import org.plazmaforge.bsolution.goods.common.services.GoodsOutcomeService;
import org.plazmaforge.bsolution.organization.client.swing.forms.ResponsibleList;
import org.plazmaforge.bsolution.organization.client.swing.forms.StorableList;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
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
 * Date: 19.06.2004
 * Time: 20:01:07
 * $Id: GoodsOutcomeEdit.java,v 1.5 2010/12/05 07:56:43 ohapon Exp $
 */
public class GoodsOutcomeEdit extends AbstractGoodsDocumentEdit implements
	IEnterValueHolder {

    private JLabel warehouseLabel;

    private JLabel responsibleLabel; // Responsible

    private JLabel partnerLabel;

    private XComboEdit warehouseComboEdit;

    private XComboEdit responsibleComboEdit; // Responsible

    private XComboEdit partnerComboEdit;

    public GoodsOutcomeEdit() {
	super();
	initialize();
    }

    private void initialize() {
	this.setEntityClass(GoodsOutcome.class);
	this.setEntityServiceClass(GoodsOutcomeService.class);
	this.setEntityCode(GoodsOutcome.CLASS_ID);
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

	GridBagPanel editPanel = new GridBagPanel();

	codeLabel = new JLabel(getString("panel.label-code.text"));
	dateLabel = new JLabel(getString("panel.label-date.text"));

	warehouseLabel = new JLabel(getString("panel.label-storable.text"));
	responsibleLabel = new JLabel(getString("panel.label-responsible.text"));
	partnerLabel = new JLabel(getString("panel.label-partner.text"));

	currencyLabel = new JLabel(getString("panel.label-currency.text"));
	currencyRateLabel = new JLabel(	getString("panel.label-currency-rate.text"));
	currencyRateDateLabel = new JLabel(getString("panel.label-currency-rate-date.text"));
	contractLabel = new JLabel(getString("panel.label-contract.text"));
	reasonDocumentLabel = new JLabel(getString("panel.label-reason-documnet.text"));
	reasonLabel = new JLabel(getString("panel.label-reason.text"));

	currencyTotalLabel = new JLabel(getString("panel.label-currency-total.text"));
	currencyTaxTotalLabel = new JLabel(getString("panel.label-currency-tax-total.text"));
	currencyTotalWithTaxLabel = new JLabel(getString("panel.label-currency-total-with-tax.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	dateField = new XDateField();
	partnerComboEdit = new XComboEdit();
	partnerComboEdit.setColumns(30);
	warehouseComboEdit = new XComboEdit();
	warehouseComboEdit.setColumns(30);
	responsibleComboEdit = new XComboEdit(true);
	responsibleComboEdit.setColumns(30);
	currencyComboBox = new XComboBox(getCurrencyService().findAll());
	currencyRateField = new XNumberField();
	currencyRateDateField = new XDateField();
	contractComboEdit = new XComboEdit(true);
	contractComboEdit.setColumns(30);
	reasonDocumentComboEdit = new XComboEdit(true);
	reasonDocumentComboEdit.setColumns(30);
	reasonField = new XTextField();
	currencyTotalField = new XCurrencyField();
	currencyTotalField.setEditable(false);
	currencyTaxTotalField = new XCurrencyField();
	currencyTaxTotalField.setEditable(false);
	currencyTotalWithTaxField = new XCurrencyField();
	currencyTotalWithTaxField.setEditable(false);

	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(codeLabel);
	editPanel.addByX(codeField);
	editPanel.addByX(dateLabel);
	editPanel.addByX(dateField);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(partnerLabel);
	gbc.gridwidth = 5;
	editPanel.addByX(partnerComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(warehouseLabel);
	gbc.gridwidth = 5;
	editPanel.addByX(warehouseComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(responsibleLabel);
	gbc.gridwidth = 5;
	editPanel.addByX(responsibleComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(currencyLabel);
	editPanel.addByX(currencyComboBox);
	editPanel.addByX(currencyRateLabel);
	editPanel.addByX(currencyRateField);
	editPanel.addByX(currencyRateDateLabel);
	editPanel.addByX(currencyRateDateField);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(contractLabel);
	gbc.gridwidth = 5;
	editPanel.addByX(contractComboEdit);
	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(reasonDocumentLabel);
	gbc.gridwidth = 5;
	editPanel.addByX(reasonDocumentComboEdit);
	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(reasonLabel);
	gbc.gridwidth = 5;
	editPanel.addByX(reasonField);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(currencyTotalLabel);
	editPanel.addByX(currencyTotalField);
	editPanel.addByX(currencyTaxTotalLabel);
	editPanel.addByX(currencyTaxTotalField);
	editPanel.addByX(currencyTotalWithTaxLabel);
	editPanel.addByX(currencyTotalWithTaxField);

	warehouseComboEdit.initListFormAction(this, StorableList.class, "warehouseId", "fullName");
	responsibleComboEdit.initListFormAction(this, ResponsibleList.class, "employeeName");
	partnerComboEdit.initListFormAction(this, PartnerList.class);

	contractComboEdit.initListFormAction(this, ContractList.class, "title");
	reasonDocumentComboEdit.initListFormAction(this, DocumentList.class, "title");

	return editPanel;
    }

    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(650, 200);
	tp.addTab(getString("table-product-item.name"), createItemPanel());
	return tp;
    }

    private JComponent createItemPanel() throws ApplicationException {
	productItemTable = createChildTable(createItemTableModel());
	productItemTable.getColumn(getString("table-product-item.column-currency-price.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
	productItemTable.getColumn(getString("table-product-item.column-currency-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
	productItemTable.getColumn(getString("table-product-item.column-currency-tax-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
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
	d.setFieldName("enterCurrencyPrice");
	d.setColumnClass(Float.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-item.column-currency-amount.name"));
	d.setFieldName("enterCurrencyAmount");
	d.setColumnClass(Double.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-item.column-currency-tax-amount.name"));
	d.setFieldName("currencyTaxAmount");
	d.setColumnClass(Float.class);
	d.setSize(15);
	columns.add(d);

	return createObjectTableModel(ProductDocumentItem.class, columns);
    }

    private GoodsOutcome getGoodsOutcome() {
	return (GoodsOutcome) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getGoodsOutcome().setPartner(EnterpriseEnvironment.getCustomer());
	getGoodsOutcome().setMtrlResponsible(EnterpriseEnvironment.getMtrlResponsible());
	getGoodsOutcome().setWarehouse(EnterpriseEnvironment.getOutcomeWharehouse());
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getGoodsOutcome().getPartnerName());
	codeField.setText(getGoodsOutcome().getDocumentNo());
	dateField.setDate(getGoodsOutcome().getDocumentDate());
	partnerComboEdit.setValue(getGoodsOutcome().getPartner());
	warehouseComboEdit.setValue(getGoodsOutcome().getWarehouse());
	responsibleComboEdit.setValue(getGoodsOutcome().getMtrlResponsible());
	currencyComboBox.setValue(getGoodsOutcome().getCurrency());
	currencyRateField.setValue(getGoodsOutcome().getCurrencyRate());
	currencyRateDateField.setDate(getGoodsOutcome().getCurrencyRateDate());

	contractComboEdit.setValue(getGoodsOutcome().getContractDocument());
	reasonDocumentComboEdit.setValue(getGoodsOutcome().getReasonDocument());
	reasonField.setText(getGoodsOutcome().getReason());

	currencyTotalField.setValue(getGoodsOutcome().getCurrencyTotal());
	currencyTaxTotalField.setValue(getGoodsOutcome().getCurrencyTaxTotal());
	currencyTotalWithTaxField.setValue(getGoodsOutcome().getCurrencyTotalWithTax());

	noteField.setText(getGoodsOutcome().getNote());

	AbstractStateTableModel productItemModel = (AbstractStateTableModel) productItemTable.getModel();
	productItemModel.addData(getGoodsOutcome().getProductItems());
    }

    private void updateAmount() {
	getGoodsOutcome().calculateGeneral();
	currencyTotalField.setValue(getGoodsOutcome().getCurrencyTotal());
	currencyTaxTotalField.setValue(getGoodsOutcome().getCurrencyTaxTotal());
	currencyTotalWithTaxField.setValue(getGoodsOutcome().getCurrencyTotalWithTax());
    }

    protected void afterRefreshChildData() throws ApplicationException {
	updateAmount();
    }

    protected void populateData() throws ApplicationException {
	getGoodsOutcome().setDocumentNo(codeField.getText());
	getGoodsOutcome().setDocumentDate(dateField.getDate());
	getGoodsOutcome().setPartner((PartnerHeader) partnerComboEdit.getValue());
	getGoodsOutcome().setWarehouse((Warehouse) warehouseComboEdit.getValue());
	getGoodsOutcome().setMtrlResponsible((MtrlResponsible) responsibleComboEdit.getValue());
	getGoodsOutcome().setCurrency((Currency) currencyComboBox.getValue());
	getGoodsOutcome().setCurrencyRate(currencyRateField.doubleValue());
	getGoodsOutcome().setCurrencyRateDate(currencyRateDateField.getDate());

	getGoodsOutcome().setContractDocument((DocumentHeader) contractComboEdit.getValue());
	getGoodsOutcome().setReasonDocument((DocumentHeader) reasonDocumentComboEdit.getValue());
	getGoodsOutcome().setReason(reasonField.getText());

	getGoodsOutcome().setCurrencyTotal(currencyTotalField.doubleValue());
	getGoodsOutcome().setCurrencyTaxTotal(currencyTaxTotalField.doubleValue());
	getGoodsOutcome().setCurrencyTotalWithTax(currencyTotalWithTaxField.doubleValue());

	getGoodsOutcome().setNote(noteField.getText());
	getGoodsOutcome().calculateGeneral();

    }

    private class ProductItemType extends AbstractChildType {
	public JTable getTable() {
	    return productItemTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(GoodsOutcomeItemEdit.class);
	}
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getGoodsOutcome().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getGoodsOutcome().getPartner(), partnerLabel.getText());
	validateRequiredField(buf, getGoodsOutcome().getWarehouse(), warehouseLabel.getText());
	checkError(buf);
    }

}
