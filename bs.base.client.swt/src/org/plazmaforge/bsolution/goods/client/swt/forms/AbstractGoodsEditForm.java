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
 * Created on 20.11.2008
 *
 */

package org.plazmaforge.bsolution.goods.client.swt.forms;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.goods.common.beans.Goods;
import org.plazmaforge.bsolution.goods.common.beans.GoodsType;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractOrganizableEditForm;
import org.plazmaforge.bsolution.product.common.beans.ProductInstance;
import org.plazmaforge.bsolution.product.common.beans.ProductPrice;
import org.plazmaforge.bsolution.product.common.beans.ProductUnit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyEnvironment;

/** 
 * @author Oleh Hapon
 * $Id: AbstractGoodsEditForm.java,v 1.4 2010/12/05 07:57:19 ohapon Exp $
 */

public abstract class AbstractGoodsEditForm extends AbstractOrganizableEditForm {


    protected Composite itemsPanel;

    protected TabFolder itemsTabFolder;
    
    protected Table productUnitTable;
    
    protected Table productPriceTable;
    
    protected Table productInstanceTable;
    
    
    public AbstractGoodsEditForm(Composite parent, int style) {
	super(parent, style);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }

    protected Goods getGoods() {
	return (Goods) getEntity();
    }
    
    protected abstract GoodsType getDefaultGoodsType();
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////


    protected void initCurrencyPriceField(final XCurrencyField currencyPriceField, final XCurrencyField priceField, final XNumberField currencyRateField) {
	if (currencyPriceField == null || priceField == null) {
	    return;
	}
	currencyPriceField.addFocusListener(new FocusAdapter() {
	    public void focusLost(FocusEvent e) {
		if (priceField == null || currencyRateField == null) {
		    return;
		}
		double currencyPrice = currencyPriceField.doubleValue();
		double currencyRate = currencyRateField.doubleValue();
		priceField.setValue(MoneyEnvironment.roundPrice(currencyPrice * currencyRate));
	    }
	});
    } 
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void initData() throws ApplicationException {
	super.initData();
	getGoods().setGoodsType(getDefaultGoodsType());
	getGoods().setCurrency(EnterpriseEnvironment.getCurrency());
	getGoods().setCurrencyRate(1d);
	getGoods().setUnit(EnterpriseEnvironment.getUnit());
    }

    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    protected class ProductUnitProvider extends TableEntityProvider {

	public ProductUnitProvider() {
	    setParentEntityClass(Goods.class); // OWNER
	    setListProperty("unitList");
	    setAddMethod("addUnit");

	    setEntityClass(ProductUnit.class); // FORM ID
	}

	protected Table getTable() {
	    return productUnitTable;
	}

	protected void bindTable() {
	    bindColumn(1, "unitName");
	    bindColumn(2, "rate", getCoefficientFormat());
	    bindColumn(3, "barCode");
	}
    }

    protected class ProductPriceProvider extends TableEntityProvider {

	public ProductPriceProvider() {
	    setParentEntityClass(Goods.class); // OWNER
	    setListProperty("priceList");
	    setAddMethod("addPrice");

	    setEntityClass(ProductPrice.class); // FORM ID
	}

	protected Table getTable() {
	    return productPriceTable;
	}

	protected void bindTable() {
	    bindColumn(1, "priceTypeName");
	    bindColumn(2, "currencyName");
	    bindColumn(3, "unitName");
	    bindColumn(4, "price", getCurrencyFormat());
	}
    }

    protected class ProductInstanceProvider extends TableEntityProvider {

	public ProductInstanceProvider() {
	    setParentEntityClass(Goods.class); // OWNER
	    setListProperty("instanceList");
	    setAddMethod("addInstance");

	    setEntityClass(ProductInstance.class); // FORM ID
	}

	protected Table getTable() {
	    return productInstanceTable;
	}

	protected void bindTable() {
	    bindColumn(1, "serialNumber");
	    bindColumn(2, "name");
	}
    }        
}
