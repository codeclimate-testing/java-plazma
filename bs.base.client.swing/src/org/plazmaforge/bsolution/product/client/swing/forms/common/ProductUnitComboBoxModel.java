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
import java.util.Iterator;

import javax.swing.ComboBoxModel;

import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.product.common.beans.ProductUnit;
import org.plazmaforge.bsolution.product.common.services.ProductService;
import org.plazmaforge.framework.client.swing.gui.XDefaultComboBoxModel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;

/**
 * @author Oleh Hapon
 * $Id: ProductUnitComboBoxModel.java,v 1.3 2010/12/05 07:56:46 ohapon Exp $
 */


public class ProductUnitComboBoxModel extends XDefaultComboBoxModel implements ComboBoxModel {


    public ProductUnitComboBoxModel() {

    }

    public ProductUnitComboBoxModel(List data) {
        super(data);
    }

    public Unit getSelectedUnit() {
        Object obj = getSelectedItem();
        if (obj == null) return null;
        return ((ProductUnit) obj).getUnit();
    }


    public void setSelectedUnitId(Integer id) {
        if (getData() == null) return;
        Iterator itr = getData().iterator();
        ProductUnit selected = null;
        ProductUnit item = null;
        while (itr.hasNext()) {
            item = (ProductUnit) itr.next();
            if ( item.getUnit().getId().equals(id) ) {
                selected = item;
                break;
            }
        }
        setSelectedItem(selected);
    }


    public Integer getSelectedUnitId() {
        Object obj = getSelectedItem();
        if (obj == null) return null;
        return ((ProductUnit) obj).getUnit().getId();
    }

    public void initProductId(Integer productId) throws ApplicationException {
        if (productId == null) {
            clearData();
            return;
        }
        initData(this.getService().findUnitByProductId(productId));
    }

    private ProductService service;

    private ProductService getService() {
        if (service == null) {
            service = (ProductService) ServiceFactory.getService(ProductService.class);
        }
        return service;
    }


}
