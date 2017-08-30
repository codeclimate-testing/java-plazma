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

import java.awt.GridBagConstraints;

import javax.swing.Box;
import javax.swing.JLabel;

import org.plazmaforge.bsolution.base.client.swing.forms.common.XTaxComboBox;
import org.plazmaforge.bsolution.product.client.swing.forms.common.ProductUnitComboBox;
import org.plazmaforge.bsolution.product.common.beans.Product;
import org.plazmaforge.bsolution.sale.common.beans.SalePlan;
import org.plazmaforge.bsolution.sale.common.beans.SalePlanItem;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


/*
 * Created 24.07.2006
 */
public class SalePlanItemEdit extends AbstractGoodsDocumentItemEdit {

    public SalePlanItemEdit() {
	super();
	initialize();
    }

    private void initialize() {
	this.setEntityClass(SalePlanItem.class);
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
	quantityField = new XNumberField();
	unitComboBox = new ProductUnitComboBox();
	unitRateField = new XNumberField();
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

	/*
	 editPanel.add(goodsLabel);
	 editPanel.addByY(unitLabel);
	 editPanel.addByY(unitRateLabel);
	 editPanel.addByY(quantityLabel);
	 editPanel.addByY(currencyPriceLabel);
	 editPanel.addByY(taxPercentLabel);
	 editPanel.addByY(currencyAmountLabel);
	 editPanel.addByY(currencyTaxAmountLabel);

	 gbc.gridy = 0;
	 gbc.gridwidth = 2;
	 gbc.fill = GridBagConstraints.HORIZONTAL;
	 editPanel.addByX(goodsComboEdit);

	 gbc.gridwidth = 1;
	 editPanel.addByY(unitComboBox);
	 editPanel.addByY(unitRateField);
	 editPanel.addByY(quantityField);
	 editPanel.addByY(currencyPriceField);
	 editPanel.addByY(taxPercentField);
	 editPanel.addByY(currencyAmountField);
	 editPanel.addByY(currencyTaxAmountField);
	 */

	initControl();

	add(editPanel);
    }

    private SalePlan getSalePlan() {
	return (SalePlan) this.getProductDocument();
    }

    private SalePlanItem getSalePlanItem() {
	return (SalePlanItem) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getSalePlanItem().getProductName());
	goodsComboEdit.setValue(getSalePlanItem().getProduct());
	quantityField.setValue(getSalePlanItem().getQuantity());

	unitComboBox.initProduct(getSalePlanItem().getProduct());
	unitComboBox.setSelectedUnit(getSalePlanItem().getUnit());

	unitRateField.setValue(getSalePlanItem().getUnitRate());
	currencyPriceField.setValue(getSalePlanItem().getEnterCurrencyPrice());
	taxPercentField.setTaxId(getSalePlanItem().getTaxId());
	currencyAmountField.setValue(getSalePlanItem().getEnterCurrencyAmount());
	currencyTaxAmountField.setValue(getSalePlanItem().getCurrencyTaxAmount());
    }

    protected void populateData() throws ApplicationException {
	getSalePlanItem().setProduct((Product) goodsComboEdit.getValue());
	getSalePlanItem().setQuantity(quantityField.floatValue());
	getSalePlanItem().setUnit(unitComboBox.getSelectedUnit());
	getSalePlanItem().setUnitRate(unitRateField.doubleValue());
	getSalePlanItem().setEnterCurrencyPrice(currencyPriceField.doubleValue());
	getSalePlanItem().setTaxId(taxPercentField.getTaxId());
	getSalePlanItem().setEnterCurrencyAmount(currencyAmountField.doubleValue());
	getSalePlanItem().setCurrencyTaxAmount(currencyTaxAmountField.doubleValue());

	//TODO: Calculate national amount
	getSalePlanItem().calculateGeneral(getSalePlan().getCurrencyRate());
    }

}
