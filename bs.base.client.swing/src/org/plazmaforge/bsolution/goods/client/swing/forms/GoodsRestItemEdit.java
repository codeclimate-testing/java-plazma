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

import org.plazmaforge.bsolution.inventory.common.beans.InventoryRest;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryRestItem;
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
 * Date: 29.05.2004
 * Time: 13:36:48
 * $Id: GoodsRestItemEdit.java,v 1.4 2010/12/05 07:56:43 ohapon Exp $
 */
public class GoodsRestItemEdit extends AbstractGoodsDocumentItemEdit {

    public GoodsRestItemEdit() {
	super();
	initialize();
    }

    private void initialize() {
	this.setEntityClass(InventoryRestItem.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	GridBagPanel editPanel = new GridBagPanel();

	goodsLabel = new JLabel(getString("panel.label-goods.text"));
	quantityLabel = new JLabel(getString("panel.label-quantity.text"));
	unitLabel = new JLabel(getString("panel.label-unit.text"));
	unitRateLabel = new JLabel(getString("panel.label-unit-rate.text"));
	currencyPriceLabel = new JLabel(getString("panel.label-currency-price.text"));
	currencyAmountLabel = new JLabel(getString("panel.label-currency-amount.text"));

	goodsComboEdit = new XComboEdit();
	goodsComboEdit.setColumns(30);
	quantityField = new XNumberField(12);
	unitComboBox = new ProductUnitComboBox();
	unitRateField = new XNumberField(12);
	unitRateField.setEditable(false);
	currencyPriceField = new XCurrencyField();
	currencyAmountField = new XCurrencyField();

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

    public InventoryRest getGoodsRest() {
	return (InventoryRest) this.getProductDocument();
    }

    private InventoryRestItem getGoodsRestItem() {
	return (InventoryRestItem) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getGoodsRestItem().getProductName());
	goodsComboEdit.setValue(getGoodsRestItem().getProduct());

	unitComboBox.initProduct(getGoodsRestItem().getProduct());
	unitComboBox.setSelectedUnit(getGoodsRestItem().getUnit());

	unitRateField.setValue(getGoodsRestItem().getUnitRate());
	quantityField.setValue(getGoodsRestItem().getQuantity());
	currencyPriceField.setValue(getGoodsRestItem().getCurrencyPrice());
	currencyAmountField.setValue(getGoodsRestItem().getCurrencyAmount());
    }

    protected void populateData() throws ApplicationException {
	getGoodsRestItem().setProduct((Product) goodsComboEdit.getValue());
	getGoodsRestItem().setUnit(unitComboBox.getSelectedUnit());
	getGoodsRestItem().setUnitRate(unitRateField.getValue());
	getGoodsRestItem().setQuantity(quantityField.getValue());
	getGoodsRestItem().setCurrencyPrice(currencyPriceField.getValue());
	getGoodsRestItem().setCurrencyAmount(currencyAmountField.getValue());

	//Calculate national amount
	getGoodsRestItem().calculateGeneral(getGoodsRest().getCurrencyRate());

    }

    protected void calculateTaxAmount() {
	// 
    }

}
