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
 * Created on 04.06.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms.common;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.base.common.beans.Tax;
import org.plazmaforge.bsolution.base.common.services.TaxService;
import org.plazmaforge.framework.client.Environment;
import org.plazmaforge.framework.client.swt.controls.XCombo;
import org.plazmaforge.framework.ext.service.EntityService;


/** 
 * @author Oleh Hapon
 * $Id: XTaxCombo.java,v 1.3 2010/04/28 06:31:07 ohapon Exp $
 */

public class XTaxCombo extends XCombo {

    
    public XTaxCombo(Composite parent, int style) {
	super(parent, style);
    }

    public XTaxCombo(Composite parent, int style, int toolStyle) {
	super(parent, style, toolStyle);
    }
    
    public void init() {
	super.init();
	setDisplayValueProperty("taxPercent");
	setNullTextValue(Messages.getString("XTaxCombo.null.nullTextValue")); //$NON-NLS-1$
	loadData();
    }
    
    protected void loadData() {
	try {
	    EntityService<Tax, Integer> service = (EntityService<Tax, Integer>) Environment.getServiceFactory().getService(TaxService.class);
	    List dataList = service.findAll();
	    setFlatDataList(dataList);
	    
	    addValue(null, getNullTextValue());

	    
	} catch (Exception ex) {
	    logger.error(ex);
	}
	
    }
    
    
    public String getFormatText(String value) {
	if (value == null) {
	    return getNullTextValue();
	}
	return super.getFormatText(value);
    }
    
    public float getTaxPercent() {
	Object refValue = getRefValue();
	if (refValue == null) {
	    return 0f;
	}
	if (!(refValue instanceof Tax)) {
	    return 0f;
	}
	return ((Tax) refValue).getTaxPercent();
    }
    
}
