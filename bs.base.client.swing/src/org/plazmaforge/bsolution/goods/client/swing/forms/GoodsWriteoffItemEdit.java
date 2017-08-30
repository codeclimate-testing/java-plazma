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

import org.plazmaforge.bsolution.inventory.common.beans.InventoryWriteoff;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryWriteoffItem;
import org.plazmaforge.bsolution.product.client.swing.forms.common.ProductUnitComboBox;
import org.plazmaforge.bsolution.product.common.beans.Product;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 28.06.2004
 * Time: 20:12:02
 * $Id: GoodsWriteoffItemEdit.java,v 1.4 2010/12/05 07:56:43 ohapon Exp $
 */
public class GoodsWriteoffItemEdit extends AbstractGoodsDocumentItemEdit {

    public GoodsWriteoffItemEdit() {
	super();
	initialize();
    }

    private void initialize() {
	this.setEntityClass(InventoryWriteoffItem.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));

	goodsLabel = new JLabel(getString("panel.label-goods.text"));
	quantityLabel = new JLabel(getString("panel.label-quantity.text"));
	unitLabel = new JLabel(getString("panel.label-unit.text"));
	unitRateLabel = new JLabel(getString("panel.label-unit-rate.text"));
	currencyPriceLabel = new JLabel(getString("panel.label-currency-price.text"));
	currencyAmountLabel = new JLabel(getString("panel.label-currency-amount.text"));

	goodsComboEdit = new XComboEdit();
	goodsComboEdit.setColumns(30);
	unitComboBox = new ProductUnitComboBox();
	unitRateField = new XNumberField(12);
	unitRateField.setEditable(false);
	quantityField = new XNumberField(12);
	currencyPriceField = new XCurrencyField();
	currencyAmountField = new XCurrencyField();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(goodsLabel);
	gbc.gridwidth = 2;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByY(goodsComboEdit);

	gbc.gridx = 0;
	editPanel.addByY(Box.createVerticalStrut(3));

	gbc.gridwidth = 1;
	gbc.gridx = 0;
	editPanel.addByY(unitLabel);
	editPanel.addByX(unitComboBox);

	gbc.gridx = 0;
	editPanel.addByY(unitRateLabel);
	editPanel.addByX(unitRateField);

	gbc.gridx = 0;
	editPanel.addByY(quantityLabel);
	editPanel.addByX(quantityField);

	gbc.gridx = 0;
	editPanel.addByY(currencyPriceLabel);
	editPanel.addByX(currencyPriceField);

	gbc.gridx = 0;
	editPanel.addByY(currencyAmountLabel);
	editPanel.addByX(currencyAmountField);

	/*
	 editPanel.add(goodsLabel);
	 editPanel.addByY(unitLabel);
	 editPanel.addByY(unitRateLabel);
	 editPanel.addByY(quantityLabel);
	 editPanel.addByY(currencyPriceLabel);
	 editPanel.addByY(currencyAmountLabel);

	 gbc.gridy = 0;
	 gbc.gridwidth = 2;
	 gbc.fill = GridBagConstraints.HORIZONTAL;
	 editPanel.addByX(goodsComboEdit);
	 gbc.gridwidth = 1;
	 editPanel.addByY(unitComboBox);
	 editPanel.addByY(unitRateField);
	 editPanel.addByY(quantityField);
	 editPanel.addByY(currencyPriceField);
	 editPanel.addByY(currencyAmountField);
	 */

	initControl();

	add(editPanel);
    }

    public InventoryWriteoff getGoodsWriteoff() {
	return (InventoryWriteoff) this.getProductDocument();
    }

    private InventoryWriteoffItem getGoodsWriteoffItem() {
	return (InventoryWriteoffItem) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getGoodsWriteoffItem().getProductName());
	goodsComboEdit.setValue(getGoodsWriteoffItem().getProduct());
	unitComboBox.initProduct(getGoodsWriteoffItem().getProduct());
	unitComboBox.setSelectedUnit(getGoodsWriteoffItem().getUnit());
	unitRateField.setValue(getGoodsWriteoffItem().getUnitRate());
	quantityField.setValue(getGoodsWriteoffItem().getQuantity());
	currencyPriceField.setValue(getGoodsWriteoffItem().getCurrencyPrice());
	currencyAmountField.setValue(getGoodsWriteoff().getCurrencyAmount());
    }

    protected void populateData() throws ApplicationException {
	getGoodsWriteoffItem().setProduct((Product) goodsComboEdit.getValue());
	getGoodsWriteoffItem().setUnit(unitComboBox.getSelectedUnit());
	getGoodsWriteoffItem().setUnitRate(unitRateField.floatValue());
	getGoodsWriteoffItem().setQuantity(quantityField.floatValue());
	getGoodsWriteoffItem().setCurrencyPrice(currencyPriceField.floatValue());
	//getDetails().setTaxAmount(vatField.floatValue());
	getGoodsWriteoffItem().setCurrencyAmount(currencyAmountField.floatValue());

	// Calculate national amount
	getGoodsWriteoffItem().calculateGeneral(getGoodsWriteoff().getCurrencyRate());

    }

    protected void calculateTaxAmount() {
	// 
    }

}