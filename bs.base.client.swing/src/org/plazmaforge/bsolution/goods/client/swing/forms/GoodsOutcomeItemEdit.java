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

import org.plazmaforge.bsolution.base.client.swing.forms.common.XTaxComboBox;
import org.plazmaforge.bsolution.goods.common.beans.GoodsOutcome;
import org.plazmaforge.bsolution.goods.common.beans.GoodsOutcomeItem;
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
 * Date: 19.06.2004
 * Time: 20:08:39
 * $Id: GoodsOutcomeItemEdit.java,v 1.4 2010/12/05 07:56:43 ohapon Exp $
 */
public class GoodsOutcomeItemEdit extends AbstractGoodsDocumentItemEdit {

    public GoodsOutcomeItemEdit() {
	super();
	initialize();
    }

    private void initialize() {
	this.setEntityClass(GoodsOutcomeItem.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	GridBagPanel editPanel = new GridBagPanel();

	goodsLabel = new JLabel(getString("panel.label-goods.text"));
	quantityLabel = new JLabel(getString("panel.label-quantity.text"));
	unitLabel = new JLabel(getString("panel.label-unit.text"));
	unitRateLabel = new JLabel(getString("panel.label-unit-rate.text"));
	currencyPriceLabel = new JLabel(getString("panel.label-currency-price.text"));
	taxPercentLabel = new JLabel(getString("panel.label-tax-percent.text"));
	currencyAmountLabel = new JLabel(getString("panel.label-currency-amount.text"));
	currencyTaxAmountLabel = new JLabel(getString("panel.label-currency-tax-amount.text"));

	goodsComboEdit = new XComboEdit();
	goodsComboEdit.setColumns(30);
	quantityField = new XNumberField(12);
	unitComboBox = new ProductUnitComboBox();
	unitRateField = new XNumberField(12);
	unitRateField.setEditable(false);
	currencyPriceField = new XCurrencyField();
	taxPercentField = new XTaxComboBox();
	currencyAmountField = new XCurrencyField();
	currencyTaxAmountField = new XCurrencyField();

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
	editPanel.addByY(taxPercentLabel);
	editPanel.addByX(taxPercentField);

	gbc.gridx = 0;
	editPanel.addByY(currencyAmountLabel);
	editPanel.addByX(currencyAmountField);

	gbc.gridx = 0;
	editPanel.addByY(currencyTaxAmountLabel);
	editPanel.addByX(currencyTaxAmountField);

	initControl();

	add(editPanel);
    }

    public GoodsOutcome getGoodsOutcome() {
	return (GoodsOutcome) this.getProductDocument();
    }

    private GoodsOutcomeItem getGoodsOutcomeItem() {
	return (GoodsOutcomeItem) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getGoodsOutcomeItem().getProductName());
	goodsComboEdit.setValue(getGoodsOutcomeItem().getProduct());
	quantityField.setValue(getGoodsOutcomeItem().getQuantity());

	unitComboBox.initProduct(getGoodsOutcomeItem().getProduct());
	unitComboBox.setSelectedUnit(getGoodsOutcomeItem().getUnit());

	unitRateField.setValue(getGoodsOutcomeItem().getUnitRate());
	currencyPriceField.setValue(getGoodsOutcomeItem().getEnterCurrencyPrice());
	taxPercentField.setTaxId(getGoodsOutcomeItem().getTaxId());
	currencyAmountField.setValue(getGoodsOutcomeItem().getEnterCurrencyAmount());
	currencyTaxAmountField.setValue(getGoodsOutcomeItem().getCurrencyTaxAmount());
    }

    protected void populateData() throws ApplicationException {
	getGoodsOutcomeItem().setProduct((Product) goodsComboEdit.getValue());
	getGoodsOutcomeItem().setQuantity(quantityField.getValue());
	getGoodsOutcomeItem().setUnit(unitComboBox.getSelectedUnit());
	getGoodsOutcomeItem().setUnitRate(unitRateField.getValue());
	getGoodsOutcomeItem().setEnterCurrencyPrice(currencyPriceField.getValue());
	getGoodsOutcomeItem().setTaxId(taxPercentField.getTaxId());
	getGoodsOutcomeItem().setEnterCurrencyAmount(currencyAmountField.getValue());
	getGoodsOutcomeItem().setCurrencyTaxAmount(currencyTaxAmountField.getValue());

	// Calculate national amount
	getGoodsOutcomeItem().calculateGeneral(getGoodsOutcome().getCurrencyRate());
    }

}
