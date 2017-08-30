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
 * Created on 10.08.2005
 *
 */
package org.plazmaforge.bsolution.goods.client.swing.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;

import org.plazmaforge.bsolution.base.client.swing.forms.common.XTaxComboBox;
import org.plazmaforge.bsolution.goods.client.swing.GUIGoodsEnvironment;
import org.plazmaforge.bsolution.goods.common.beans.Goods;
import org.plazmaforge.bsolution.product.client.swing.forms.ProductDocumentItemEdit;
import org.plazmaforge.bsolution.product.client.swing.forms.common.ProductUnitComboBox;
import org.plazmaforge.bsolution.product.common.beans.ProductDocument;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.forms.EXTChildEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;



/**
 * Abstract item edit of GOODS package
 * 
 * @author Oleh Hapon
 *
 */
public abstract class AbstractGoodsDocumentItemEdit extends EXTChildEditForm
	implements ProductDocumentItemEdit {

    protected JLabel goodsLabel;

    protected JLabel quantityLabel;

    protected JLabel unitLabel;

    protected JLabel unitRateLabel;

    protected JLabel currencyPriceLabel;

    protected JLabel taxPercentLabel;

    protected JLabel currencyAmountLabel;

    protected JLabel currencyTaxAmountLabel;

    protected XComboEdit goodsComboEdit;

    protected XNumberField quantityField;

    protected ProductUnitComboBox unitComboBox;

    protected XNumberField unitRateField;

    protected XCurrencyField currencyPriceField;

    protected XTaxComboBox taxPercentField;

    protected XCurrencyField currencyAmountField;

    protected XCurrencyField currencyTaxAmountField;

    private ProductDocument productDocument;

    public AbstractGoodsDocumentItemEdit() {
	super(GUIGoodsEnvironment.getResources());
    }

    public ProductDocument getProductDocument() {
	return productDocument;
    }

    public void setProductDocument(ProductDocument productDocument) {
	this.productDocument = productDocument;
    }

    public ProductDocumentItem getProductDocumentItem() {
	return (ProductDocumentItem) this.getEntity();
    }

    protected GoodsList getGoodsList() throws ApplicationException {
	return (GoodsList) getLIST(GoodsList.class, getDialog());
    }

    /**
     * Add child
     */
    protected void addChild() throws ApplicationException {
	this.getProductDocument().addProductItem(this.getProductDocumentItem());
    }

    /**
     * Initialize form control
     *
     */
    protected void initControl() throws ApplicationException {

	if (goodsComboEdit != null) {
	    goodsComboEdit.initListFormAction(this, GoodsList.class);
	    goodsComboEdit.addAfterListActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			Goods goods = (Goods) goodsComboEdit.getValue();
			if (goods == null)
			    return;
			unitComboBox.initProduct(goods);
			unitRateField.setValue(unitComboBox
				.getSelectedUnitRate());
		    } catch (Exception ex) {
			ex.printStackTrace();
		    }
		}
	    });

	}

	if (unitComboBox != null) {
	    unitComboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    unitRateField.setValue(unitComboBox.getSelectedUnitRate());
		}
	    });
	}

	if (taxPercentField != null) {
	    taxPercentField.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    calculateTaxAmount();
		}
	    });
	}

	quantityField.addFocusListener(new FocusListener() {
	    public void focusLost(FocusEvent e) {
		calculateAmount();
	    }

	    public void focusGained(FocusEvent e) {

	    }
	});

	currencyPriceField.addFocusListener(new FocusListener() {
	    public void focusLost(FocusEvent e) {
		calculateAmount();
	    }

	    public void focusGained(FocusEvent e) {

	    }
	});

	currencyAmountField.addFocusListener(new FocusListener() {
	    public void focusLost(FocusEvent e) {
		calculatePrice();
		calculateTaxAmount();
	    }

	    public void focusGained(FocusEvent e) {

	    }
	});

    }

    /**
     * Calculate price by quantity and amount
     *
     */
    protected void calculatePrice() {
	currencyPriceField.setValue(MoneyCalculator.calculatePrice(
		quantityField.floatValue(), currencyAmountField.floatValue()));
    }

    /**
     * Calculate amount by quantity and price
     * 
     */
    protected void calculateAmount() {
	currencyAmountField.setValue(MoneyCalculator.calculateAmount(
		quantityField.floatValue(), currencyPriceField.floatValue()));
	calculateTaxAmount();
    }

    /**
     * Calculate tax amount by tax percent and amount
     * 
     */
    protected void calculateTaxAmount() {
	currencyTaxAmountField.setValue(MoneyCalculator.calculateTaxAmount(
		taxPercentField.getSelectedPercent(), currencyAmountField
			.floatValue(), isIncludeTaxInAmount()));
    }

    protected boolean isIncludeTaxInAmount() {
	return getProductDocumentItem() == null ? false	: getProductDocumentItem().isIncludeTaxInAmount();
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getProductDocumentItem().getProduct(), goodsLabel.getText());
	validateRequiredField(buf, getProductDocumentItem().getUnit(), unitLabel.getText());
	checkError(buf);
    }

}
