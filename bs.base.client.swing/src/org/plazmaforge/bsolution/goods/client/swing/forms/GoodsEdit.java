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

import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.base.common.services.CurrencyService;
import org.plazmaforge.bsolution.base.common.services.UnitService;
import org.plazmaforge.bsolution.finance.client.swing.forms.LedgerAccountList;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.goods.client.swing.GUIGoodsEnvironment;
import org.plazmaforge.bsolution.goods.common.beans.Goods;
import org.plazmaforge.bsolution.goods.common.beans.GoodsType;
import org.plazmaforge.bsolution.goods.common.services.GoodsService;
import org.plazmaforge.bsolution.goods.common.services.GoodsTypeService;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.product.client.swing.forms.ProductForm;
import org.plazmaforge.bsolution.product.client.swing.forms.ProductPriceEdit;
import org.plazmaforge.bsolution.product.client.swing.forms.ProductUnitEdit;
import org.plazmaforge.bsolution.product.common.beans.ProductGroup;
import org.plazmaforge.bsolution.product.common.beans.ProductPrice;
import org.plazmaforge.bsolution.product.common.beans.ProductUnit;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XLabel;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.AbstractChildType;
import org.plazmaforge.framework.client.swing.forms.EXTParentEditForm;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.StateTableModel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Oleh Hapon
 * Date: 31.03.2004
 * Time: 8:09:55
 * $Id: GoodsEdit.java,v 1.5 2010/12/05 07:56:43 ohapon Exp $
 */


public class GoodsEdit extends EXTParentEditForm {

    private XLabel codeLabel;

    private XLabel nameLabel;

    private XLabel productGroupLabel;

    private XLabel goodsTypeLabel;

    private XLabel currencyLabel;

    private XLabel unitLabel;

    private XLabel priceLabel;

    private XLabel taxPercentLabel;

    private XLabel addPricePercentLabel;

    private XLabel manufacturerLabel;

    private XLabel supplierLabel;

    private XLabel minQuantityLabel;

    private XLabel availabilityQuantityLabel;

    private XLabel reserveQuantityLabel;

    private XLabel awaitQuantityLabel;

    private XLabel ledgerAccountLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XComboEdit productGroupComboEdit;

    private XComboBox goodsTypeComboBox;

    private XComboBox currencyComboBox;

    private XComboBox unitComboBox;

    private XNumberField priceField;

    private XNumberField taxPercentField;

    private XNumberField addPricePercentField;

    private XComboEdit manufacturerComboEdit;

    private XComboEdit supplierComboEdit;

    private XNumberField minQuantityField;

    private XNumberField availabilityQuantityField;

    private XNumberField reserveQuantityField;

    private XNumberField awaitQuantityField;

    private XComboEdit ledgerAccountComboEdit;

    private XTextEdit noteField;

    protected JTable unitTable;

    protected JTable priceTable;

    public GoodsEdit() throws ApplicationException {
	super(GUIGoodsEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Goods.class);
	this.setEntityServiceClass(GoodsService.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));

	//getParentPane().add(editPanel);
	setParentTabbedPane(createMasterTabbedPane());
	addParentTabbedPane();

	setChildrenTabbedPane(createItems());
	getChildrenPane().add(getChildrenTabbedPane());

    }

    private JPanel createCommonPanel() throws ApplicationException {

	GridBagPanel editPanel = new GridBagPanel();
	codeLabel = new XLabel(getString("panel.label-code.text"));
	nameLabel = new XLabel(	getString("panel.label-name.text"));
	productGroupLabel = new XLabel(	getString("panel.label-product-card-group.text"));
	goodsTypeLabel = new XLabel(getString("panel.label-goods-type.text"));
	currencyLabel = new XLabel(getString("panel.label-currency.text"));
	unitLabel = new XLabel(getString("panel.label-unit.text"));
	priceLabel = new XLabel(getString("panel.label-price.text"));
	taxPercentLabel = new XLabel(getString("panel.label-taxpercent.text"));
	addPricePercentLabel = new XLabel(getString("panel.label-add-pricepercent.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	nameField = new XTextField(30);
	nameField.setMaxChar(30);
	goodsTypeComboBox = new XComboBox(getGoodsTypeService().findAll());
	currencyComboBox = new XComboBox(getCurrencyService().findAll());
	unitComboBox = new XComboBox(getUnitService().findAll());
	priceField = new XNumberField(20);
	taxPercentField = new XNumberField(20);
	addPricePercentField = new XNumberField(20);

	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(productGroupLabel);
	editPanel.addByY(goodsTypeLabel);
	editPanel.addByY(currencyLabel);
	editPanel.addByY(unitLabel);
	editPanel.addByY(priceLabel);
	editPanel.addByY(taxPercentLabel);
	editPanel.addByY(addPricePercentLabel);

	gbc.gridy = 0;
	gbc.gridwidth = 2;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(codeField);
	editPanel.addByY(nameField);
	editPanel.addByY(productGroupComboEdit);

	gbc.gridwidth = 1;
	editPanel.addByY(goodsTypeComboBox);
	editPanel.addByY(currencyComboBox);
	editPanel.addByY(unitComboBox);
	editPanel.addByY(priceField);
	editPanel.addByY(taxPercentField);
	editPanel.addByY(addPricePercentField);

	return editPanel;
    }

    private void fixedUnits() {
	Goods goods = getGoods();
	if (goods == null) {
	    return;
	}
	Unit unit = goods.getUnit();
	Integer newId = unit == null ? null : unit.getId();
	if (newId == null) {
	    return;
	}
	if (goods.isFoundUnit(newId)) {
	    return;
	}
	ProductUnit productUnit = new ProductUnit();
	productUnit.setUnit(unit);
	productUnit.setRate(1d);
	goods.addUnit(productUnit);

    }

    private JPanel createAdditionalPanel() throws ApplicationException {
	GridBagPanel editPanel = new GridBagPanel();

	manufacturerLabel = new XLabel(	getString("panel.label-manufacturer.text"));
	supplierLabel = new XLabel(getString("panel.label-supplier.text"));
	minQuantityLabel = new XLabel(getString("panel.label-min-quantity.text"));
	availabilityQuantityLabel = new XLabel(getString("panel.label-availability-quantity.text"));
	reserveQuantityLabel = new XLabel(getString("panel.label-reserve-quantity.text"));
	awaitQuantityLabel = new XLabel(getString("panel.label-await-quantity.text"));
	ledgerAccountLabel = new XLabel(getString("panel.label-ledger-account.text"));

	manufacturerComboEdit = new XComboEdit(true);
	manufacturerComboEdit.setColumns(30);
	supplierComboEdit = new XComboEdit(true);
	supplierComboEdit.setColumns(30);

	minQuantityField = new XNumberField(20);
	availabilityQuantityField = new XNumberField(20);
	reserveQuantityField = new XNumberField(20);
	awaitQuantityField = new XNumberField(20);
	ledgerAccountComboEdit = new XComboEdit(true);

	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(manufacturerLabel);
	editPanel.addByY(supplierLabel);
	editPanel.addByY(minQuantityLabel);
	editPanel.addByY(availabilityQuantityLabel);
	editPanel.addByY(reserveQuantityLabel);
	editPanel.addByY(awaitQuantityLabel);
	editPanel.addByY(ledgerAccountLabel);

	gbc.gridy = 0;
	gbc.gridwidth = 2;
	gbc.fill = GridBagConstraints.HORIZONTAL;

	editPanel.addByX(manufacturerComboEdit);
	editPanel.addByY(supplierComboEdit);
	editPanel.addByY(minQuantityField);
	editPanel.addByY(availabilityQuantityField);
	editPanel.addByY(reserveQuantityField);
	editPanel.addByY(awaitQuantityField);
	editPanel.addByY(ledgerAccountComboEdit);

	manufacturerComboEdit.initListFormAction(this, PartnerList.class);
	supplierComboEdit.initListFormAction(this, PartnerList.class);
	ledgerAccountComboEdit.initListFormAction(this,	LedgerAccountList.class, "accountName");

	return editPanel;
    }

    private JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private JTabbedPane createMasterTabbedPane() throws ApplicationException {
	JTabbedPane tp = new JTabbedPane();
	tp.addTab(getString("panel.title.common.text"), createCommonPanel());
	tp.addTab(getString("panel.title.additional.text"), createAdditionalPanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	return tp;
    }

    private JTabbedPane createItems() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(150);
	tp.addTab(getString("table-product-unit.name"),	createProductUnitPanel());
	tp.addTab(getString("table-product-price.name"), createProductPricePanel());
	return tp;
    }

    // ****************************************************************************************************************
    // Product Unit
    // ****************************************************************************************************************
    protected JComponent createProductUnitPanel() throws ApplicationException {
	unitTable = createChildTable(createProductUnitTableModel());
	JScrollPane scroll = new JScrollPane(unitTable);
	this.registerEntityType(scroll, new UnitItemType());
	return scroll;
    }

    protected TableModel createProductUnitTableModel()
	    throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();
	ColumnProperty d = new ColumnProperty();

	d.setName(getString("table-product-unit.column-unit-name.name"));
	d.setFieldName("unitName");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-unit.column-rate.name"));
	d.setFieldName("rate");
	d.setColumnClass(Float.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-unit.column-bar-code.name"));
	d.setFieldName("barCode");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	return createObjectTableModel(ProductUnit.class, columns);
    }

    // ****************************************************************************************************************
    // Product Price
    // ****************************************************************************************************************
    protected JComponent createProductPricePanel() throws ApplicationException {
	priceTable = createChildTable(createProductPriceTableModel());
	JScrollPane scroll = new JScrollPane(priceTable);
	this.registerEntityType(scroll, new PriceItemType());
	return scroll;
    }

    protected TableModel createProductPriceTableModel()
	    throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();
	ColumnProperty d = new ColumnProperty();

	d.setName(getString("table-product-price.column-price-type-name.name"));
	d.setFieldName("priceTypeName");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-price.column-currency-name.name"));
	d.setFieldName("currencyName");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-price.column-unit-name.name"));
	d.setFieldName("unitName");
	d.setColumnClass(String.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-product-price.column-price.name"));
	d.setFieldName("price");
	d.setColumnClass(Double.class);
	d.setSize(10);
	columns.add(d);

	return createObjectTableModel(ProductPrice.class, columns);
    }

    // ****************************************************************************************************************

    private Goods getGoods() {
	return (Goods) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	GUIGoodsEnvironment.initGoods(getGoods());
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getGoods().getName());
	codeField.setText(getGoods().getCode());
	nameField.setText(getGoods().getName());
	productGroupComboEdit.setValue(getGoods().getProductGroup());
	goodsTypeComboBox.setValue(getGoods().getGoodsType());
	currencyComboBox.setValue(getGoods().getCurrency());
	unitComboBox.setValue(getGoods().getUnit());
	priceField.setValue(getGoods().getPrice());
	taxPercentField.setValue(getGoods().getTaxPercent());
	addPricePercentField.setValue(getGoods().getAddPricePercent());

	manufacturerComboEdit.setValue(getGoods().getManufacturer());
	supplierComboEdit.setValue(getGoods().getSupplier());
	minQuantityField.setValue(getGoods().getMinQuantity());
	availabilityQuantityField.setValue(getGoods().getAvailableQuantity());
	reserveQuantityField.setValue(getGoods().getReservedQuantity());
	awaitQuantityField.setValue(getGoods().getExpectedQuantity());
	ledgerAccountComboEdit.setValue(getGoods().getLedgerAccount());

	noteField.setText(getGoods().getNote());

	((StateTableModel) unitTable.getModel()).addData(getGoods().getUnitList());
	((StateTableModel) priceTable.getModel()).addData(getGoods().getPriceList());

    }

    protected void populateData() throws ApplicationException {
	getGoods().setCode(codeField.getText());
	getGoods().setName(nameField.getText());
	getGoods().setProductGroup((ProductGroup) productGroupComboEdit.getValue());
	getGoods().setGoodsType((GoodsType) goodsTypeComboBox.getValue());
	getGoods().setUnit((Unit) unitComboBox.getValue());
	getGoods().setCurrency((Currency) currencyComboBox.getValue());
	getGoods().setPrice(priceField.floatValue());
	getGoods().setTaxPercent(taxPercentField.floatValue());
	getGoods().setAddPricePercent(addPricePercentField.floatValue());

	getGoods().setManufacturer((PartnerHeader) manufacturerComboEdit.getValue());
	getGoods().setSupplier((PartnerHeader) supplierComboEdit.getValue());
	getGoods().setAvailableQuantity(availabilityQuantityField.floatValue());
	getGoods().setReservedQuantity(reserveQuantityField.floatValue());
	getGoods().setExpectedQuantity(awaitQuantityField.floatValue());
	getGoods().setMinQuantity(minQuantityField.floatValue());
	getGoods().setLedgerAccount((LedgerAccount) ledgerAccountComboEdit.getValue());

	getGoods().setNote(noteField.getText());

	fixedUnits();
    }

    private GoodsTypeService getGoodsTypeService() {
	return (GoodsTypeService) getSERVICE(GoodsTypeService.class);
    }

    private UnitService getUnitService() {
	return (UnitService) getSERVICE(UnitService.class);
    }

    private CurrencyService getCurrencyService() {
	return (CurrencyService) getSERVICE(CurrencyService.class);
    }

    // ****************************************************************************************************************
    // Product Unit
    // ****************************************************************************************************************
    private class UnitItemType extends AbstractChildType {
	public JTable getTable() {
	    return unitTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(ProductUnitEdit.class);
	}
    }

    // ****************************************************************************************************************

    // ****************************************************************************************************************
    // Product Price
    // ****************************************************************************************************************
    private class PriceItemType extends AbstractChildType {
	public JTable getTable() {
	    return priceTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(ProductPriceEdit.class);
	}
    }

    // ****************************************************************************************************************

    // ****************************************************************************************************************
    // Common
    // ****************************************************************************************************************

    protected EditForm getEditChildForm() throws ApplicationException {
	EditForm form = super.getEditChildForm();
	if (form instanceof ProductForm) {
	    ((ProductForm) form).setProduct(getGoods());
	}
	return form;
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getGoods().getName(), nameLabel.getText());
	validateRequiredField(buf, getGoods().getGoodsType(), goodsTypeLabel.getText());
	checkError(buf);
    }

}
