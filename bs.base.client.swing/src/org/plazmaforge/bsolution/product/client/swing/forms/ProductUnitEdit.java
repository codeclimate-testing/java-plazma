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
import javax.swing.JTextField;

import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.base.common.services.UnitService;
import org.plazmaforge.bsolution.product.client.swing.GUIProductEnvironment;
import org.plazmaforge.bsolution.product.common.beans.ProductUnit;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/**
 * @author Oleh Hapon
 * Date: 23.08.2004
 * Time: 20:08:29
 * $Id: ProductUnitEdit.java,v 1.3 2010/12/05 07:56:48 ohapon Exp $
 */


public class ProductUnitEdit extends AbstractProductEdit {

    private JLabel unitLabel;
    private JLabel rateLabel;
    private JLabel barCodeLabel;

    private XComboBox unitComboBox;
    private XNumberField rateField;
    private JTextField barCodeField;


    public ProductUnitEdit() throws ApplicationException {
        super(GUIProductEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(ProductUnit.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        unitLabel = new JLabel(getString("panel.label-unit.text"));
        rateLabel = new JLabel(getString("panel.label-rate.text"));
        barCodeLabel = new JLabel(getString("panel.label-bar-code.text"));

        unitComboBox = new XComboBox(getUnitService().findAll());
        rateField = new XNumberField(20);
        barCodeField = new JTextField();

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(unitLabel);
        editPanel.addByY(rateLabel);
        editPanel.addByY(barCodeLabel);

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        editPanel.addByX(unitComboBox);
        editPanel.addByY(rateField);
        editPanel.addByY(barCodeField);

        add(editPanel);
    }

    private ProductUnit getProductUnit() {
        return (ProductUnit) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getProductUnit().getUnitName());
        unitComboBox.setValue(getProductUnit().getUnit());
        rateField.setValue(getProductUnit().getRate());
        barCodeField.setText(getProductUnit().getBarCode());
    }

    private UnitService getUnitService() {
        return (UnitService) getSERVICE(UnitService.class);
    }

    protected void populateData() throws ApplicationException {
        getProductUnit().setUnit((Unit) unitComboBox.getValue());
        getProductUnit().setRate(rateField.floatValue());
        getProductUnit().setBarCode(barCodeField.getText());

    }

    protected void addChild() throws ApplicationException {
        getProduct().addUnit(getProductUnit());
    }

}
