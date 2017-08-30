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
package org.plazmaforge.bsolution.product.client.swing.forms.common;




import java.util.List;

import javax.swing.JComboBox;

import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.product.common.beans.ProductHeader;
import org.plazmaforge.bsolution.product.common.beans.ProductUnit;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * @author Oleh Hapon
 * $Id: ProductUnitComboBox.java,v 1.3 2010/12/05 07:56:46 ohapon Exp $
 */



public class ProductUnitComboBox extends JComboBox {


    public ProductUnitComboBox() {
        super(new ProductUnitComboBoxModel());
    }

    private ProductUnitComboBoxModel getUnitModel() {
        return (ProductUnitComboBoxModel)this.getModel();
    }

    public void setSelectedUnitId(Integer id) {
        this.getUnitModel().setSelectedUnitId(id);
    }

    public void setSelectedUnit(Unit unit) {
        if (unit == null) {
            this.getUnitModel().setSelectedItem(null);
            return;
        }
        this.getUnitModel().setSelectedUnitId(unit.getId());
    }

    public Integer getSelectedUnitId() {
        return this.getUnitModel().getSelectedUnitId();
    }

    public Unit getSelectedUnit() {
        return this.getUnitModel().getSelectedUnit();
    }

    public double getSelectedUnitRate() {
        if (getUnitModel().getSelectedItem() == null) {
            return 0d;
        }
        return ((ProductUnit) getUnitModel().getSelectedItem()).getRate();
    }


    public void initProduct(ProductHeader product) throws ApplicationException {
        initProductId(product == null ? null: product.getId());
    }
    
    public void initProductId(Integer id) throws ApplicationException {
    	Integer unitId = this.getSelectedUnitId();
        this.getUnitModel().initProductId(id);
        this.initPosition(unitId);
    }

    private void initPosition(Integer unitId) {
        if (getModel().getSize() > 0) {
            if (unitId != null) {
                this.setSelectedUnitId(unitId);
                if (this.getSelectedIndex() < 0) {
                    this.setSelectedIndex(0);
                }
            } else {
                this.setSelectedIndex(0);
            }
        } else {
            this.setSelectedIndex(-1);
        }
    }

    public void initData(List data) throws ApplicationException {
        this.getUnitModel().initData(data);
    }

    public void clearData() {
        this.getUnitModel().clearData();
    }


}
