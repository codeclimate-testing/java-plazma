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
package org.plazmaforge.bsolution.base.client.swing.forms.common;

import java.util.List;

import javax.swing.*;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Tax;
import org.plazmaforge.bsolution.base.common.services.TaxService;
import org.plazmaforge.framework.core.exception.ApplicationError;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.EntityService;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.resources.Resources;


/**
 * @author Oleh Hapon Date: 20.06.2004 Time: 9:34:04 $Id: XTaxComboBox.java,v 1.4 2010/12/05 07:56:47 ohapon Exp $
 */
public class XTaxComboBox extends JComboBox {

    private Resources resources;

    private List items;

    public XTaxComboBox() {
	this.resources = GUIBaseEnvironment.getResources();
	init();
    }

    private void init() {
	try {
	    EntityService<Tax, Integer> service = (EntityService<Tax, Integer>) ServiceFactory.getService(TaxService.class);
	    items = service.findAll();
	    for (int i = 0; i < items.size(); i++) {
		Tax tax = (Tax) items.get(i);
		addItem(tax.getTaxPercent() + "%");
	    }
	    addItem(resources.getString("tax.no"));

	} catch (ApplicationException ex) {
	    throw new ApplicationError(ex);
	}
    }

    public Tax getTax(int index) {
	return (Tax) items.get(index);
    }

    public float getSelectedPercent() {
	int index = getSelectedIndex();
	if (index > -1 && index < getItemCount() - 1) {
	    return getTax(index).getTaxPercent();
	}
	return 0;
    }

    public void setTaxId(Integer taxId) {
	if (taxId == null || items == null || items.size() == 0) {
	    // Set no tax
	    setSelectedNoTax();
	    return;
	}
	for (int i = 0; i < items.size(); i++) {
	    if (taxId.equals(getTax(i).getId())) {
		setSelectedIndex(i);
		return;
	    }
	}
	// Set no tax
	setSelectedNoTax();
    }

    public Integer getTaxId() {
	int index = getSelectedIndex();
	if (index > -1 && index < getItemCount() - 1) {
	    return getTax(index).getId();
	}
	return null;
    }

    public void setSelectedNoTax() {
	setSelectedIndex(getItemCount() - 1);
    }

    // public void setTax(boolean isTax) {
    // //TODO: Stub
    // setSelectedIndex(isTax ? 0 : getItemCount() - 1);
    // }
}
