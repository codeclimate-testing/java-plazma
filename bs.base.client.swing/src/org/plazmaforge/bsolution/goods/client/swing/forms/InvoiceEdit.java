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
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.sale.common.beans.SaleInvoice;
import org.plazmaforge.bsolution.sale.common.beans.SaleInvoiceItem;
import org.plazmaforge.bsolution.sale.common.services.SaleInvoiceService;
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
import java.util.List;
import java.util.ArrayList;


/**
 * @author Oleh Hapon
 * Date: 12.09.2004
 * Time: 16:15:54
 * $Id: InvoiceEdit.java,v 1.5 2010/12/05 07:56:43 ohapon Exp $
 */
public class InvoiceEdit extends AbstractGoodsDocumentEdit implements
	IEnterValueHolder {

    private JLabel partnerLabel; // Partner

    private XComboEdit partnerComboEdit; // Partner

    public InvoiceEdit() {
	super();
	initialize();
    }

    private void initialize() {
	this.setEntityClass(SaleInvoice.class);
	this.setEntityServiceClass(SaleInvoiceService.class);
	this.setEntityCode(SaleInvoice.CLASS_ID);
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
	partnerLabel = new JLabel(getString("panel.label-partner.text"));
	currencyLabel = new JLabel(getString("panel.label-currency.text"));
	currencyRateLabel = new JLabel(getString("panel.label-currency-rate.text"));
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

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(codeLabel);
	//gbc.gridwidth = 2;
	editPanel.addByX(codeField);
	//gbc.gridwidth = 1;
	editPanel.addByX(dateLabel);
	//gbc.gridwidth = 2;
	editPanel.addByX(dateField);

	gbc.gridx = 0;
	editPanel.addByY(partnerLabel);
	gbc.gridwidth = 5;
	editPanel.addByX(partnerComboEdit);
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

	partnerComboEdit.initListFormAction(this, PartnerList.class);
	contractComboEdit.initListFormAction(this, ContractList.class, "title");
	reasonDocumentComboEdit.initListFormAction(this, DocumentList.class, "title");

	return editPanel;
    }

    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(700, 200);
	tp.addTab(getString("table-product-item.name"), createItemPanel());
	return tp;
    }

    private JComponent createItemPanel() throws ApplicationException {
	productItemTable = createChildTable(createItemTableModel());
	productItemTable.getColumn(getString("table-product-item.column-currency-price.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
	productItemTable.getColumn(getString("table-product-item.column-currency-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
	productItemTable.getColumn(getString("table-product-item.column-currency-tax-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
	JScrollPane scroll = new JScrollPane(productItemTable);
	registerEntityType(scroll, new ProductItemType());
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
	d.setColumnClass(Double.class);
	d.setSize(20);
	columns.add(d);

	return createObjectTableModel(SaleInvoiceItem.class, columns);
    }

    private SaleInvoice getInvoice() {
	return (SaleInvoice) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getInvoice().setPartner(EnterpriseEnvironment.getCustomer());
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getInvoice().getPartnerName());
	codeField.setText(getInvoice().getDocumentNo());
	dateField.setDate(getInvoice().getDocumentDate());
	partnerComboEdit.setValue(getInvoice().getPartner());
	currencyComboBox.setValue(getInvoice().getCurrency());
	currencyRateField.setValue(getInvoice().getCurrencyRate());
	currencyRateDateField.setDate(getInvoice().getCurrencyRateDate());
	noteField.setText(getInvoice().getNote());

	contractComboEdit.setValue(getInvoice().getContractDocument());
	reasonDocumentComboEdit.setValue(getInvoice().getReasonDocument());
	reasonField.setText(getInvoice().getReason());

	currencyTotalField.setValue(getInvoice().getCurrencyTotal());
	currencyTaxTotalField.setValue(getInvoice().getCurrencyTaxTotal());
	currencyTotalWithTaxField.setValue(getInvoice().getCurrencyTotalWithTax());

	AbstractStateTableModel productItemModel = (AbstractStateTableModel) productItemTable.getModel();
	productItemModel.addData(getInvoice().getProductItems());
    }

    private void updateAmount() {
	getInvoice().calculateGeneral();
	currencyTotalField.setValue(getInvoice().getCurrencyTotal());
	currencyTaxTotalField.setValue(getInvoice().getCurrencyTaxTotal());
	currencyTotalWithTaxField.setValue(getInvoice().getCurrencyTotalWithTax());
    }

    protected void afterRefreshChildData() throws ApplicationException {
	updateAmount();
    }

    protected void populateData() throws ApplicationException {
	getInvoice().setDocumentNo(codeField.getText());
	getInvoice().setDocumentDate(dateField.getDate());
	getInvoice().setPartner((PartnerHeader) partnerComboEdit.getValue());
	getInvoice().setCurrency((Currency) currencyComboBox.getValue());
	getInvoice().setCurrencyRate(currencyRateField.doubleValue());
	getInvoice().setCurrencyRateDate(currencyRateDateField.getDate());

	getInvoice().setContractDocument((DocumentHeader) contractComboEdit.getValue());
	getInvoice().setReasonDocument((DocumentHeader) reasonDocumentComboEdit.getValue());
	getInvoice().setReason(reasonField.getText());

	getInvoice().setCurrencyTotal(currencyTotalField.doubleValue());
	getInvoice().setCurrencyTaxTotal(currencyTaxTotalField.doubleValue());
	getInvoice().setCurrencyTotalWithTax(currencyTotalWithTaxField.doubleValue());

	getInvoice().setNote(noteField.getText());
	getInvoice().calculateGeneral();
    }

    protected class ProductItemType extends AbstractChildType {
	public JTable getTable() {
	    return productItemTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(InvoiceItemEdit.class);
	}
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getInvoice().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getInvoice().getPartner(), partnerLabel.getText());
	checkError(buf);
    }

}
