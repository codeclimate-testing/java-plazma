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
package org.plazmaforge.bsolution.product.client.swing.forms;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.base.common.services.CurrencyService;
import org.plazmaforge.bsolution.base.common.services.UnitService;
import org.plazmaforge.bsolution.product.client.swing.GUIProductEnvironment;
import org.plazmaforge.bsolution.product.common.beans.PriceType;
import org.plazmaforge.bsolution.product.common.beans.ProductPrice;
import org.plazmaforge.bsolution.product.common.services.PriceTypeService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/**
 * @author Oleh Hapon
 * Date: 25.08.2004
 * Time: 9:46:03
 * $Id: ProductPriceEdit.java,v 1.4 2010/12/05 07:56:48 ohapon Exp $
 */


public class ProductPriceEdit extends AbstractProductEdit {

    private JLabel priceTypeLabel;
    private JLabel percentLabel;
    private JLabel priceLabel;
    private JLabel currencyLabel;
    private JLabel unitLabel;

    private XComboBox priceTypeComboBox;
    private XNumberField percentField;
    private XNumberField priceField;
    private XComboBox currencyComboBox;
    private XComboBox unitComboBox;



    public ProductPriceEdit() throws ApplicationException {
        super(GUIProductEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(ProductPrice.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        priceTypeLabel = new JLabel(getString("panel.label-price-type.text"));
        percentLabel = new JLabel(getString("panel.label-percent.text"));
        priceLabel = new JLabel(getString("panel.label-price.text"));
        currencyLabel = new JLabel(getString("panel.label-currency.text"));
        unitLabel = new JLabel(getString("panel.label-unit.text"));

        priceTypeComboBox = new XComboBox(getPriceTypeService().findAll());
        percentField = new XNumberField(20);
        priceField = new XNumberField(20);
        currencyComboBox = new XComboBox(getCurrencySservice().findAll());
        unitComboBox = new XComboBox(getUnitService().findAll());

        GridBagPanel editPanel = new GridBagPanel();
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(priceTypeLabel);
        editPanel.addByY(percentLabel);
        editPanel.addByY(priceLabel);
        editPanel.addByY(currencyLabel);
        editPanel.addByY(unitLabel);

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        
        editPanel.addByX(priceTypeComboBox);
        gbc.gridwidth = 1;        
        editPanel.addByY(percentField);
        editPanel.addByY(priceField);
        editPanel.addByY(currencyComboBox);
        editPanel.addByY(unitComboBox);

        add(editPanel);
    }

    private ProductPrice getProductPrice() {
        return (ProductPrice) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getProductPrice().getPriceTypeName());
        priceTypeComboBox.setValue(getProductPrice().getPriceType());
        percentField.setValue(getProductPrice().getPricePercent());
        priceField.setValue(getProductPrice().getPrice());
        currencyComboBox.setValue(getProductPrice().getCurrency());
        unitComboBox.setValue(getProductPrice().getUnit());
    }

    private PriceTypeService getPriceTypeService() {
        return (PriceTypeService) getSERVICE(PriceTypeService.class);
    }

    private UnitService getUnitService() {
        return (UnitService) getSERVICE(UnitService.class);
    }

    private CurrencyService getCurrencySservice() {
        return (CurrencyService) getSERVICE(CurrencyService.class);
    }

    protected void populateData() throws ApplicationException {
        getProductPrice().setPriceType((PriceType) priceTypeComboBox.getValue());
        getProductPrice().setPricePercent(percentField.floatValue());
        getProductPrice().setPrice(priceField.doubleValue());
        getProductPrice().setCurrency((Currency) currencyComboBox.getValue());
        getProductPrice().setUnit((Unit) unitComboBox.getValue());
    }

    protected void addChild() throws ApplicationException {
       getProduct().addPrice(getProductPrice());
    }

}
