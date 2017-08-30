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
 * Created on 29.03.2008
 *
 */

package org.plazmaforge.bsolution.bank.client.swt.forms;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.bank.common.services.BankAccountService;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: BankAccountHelper.java,v 1.3 2010/12/05 07:57:18 ohapon Exp $
 */

public class BankAccountHelper {

    private static final Log logger = LogFactory.getLog(BankAccountHelper.class);
    
    private BankAccountHelperProvider provider;

    public BankAccountHelper(BankAccountHelperProvider provider) {
	if (provider == null) {
	    throw new IllegalArgumentException("Provider is null");
	}
	this.provider = provider;
    }

    public BankAccountHelperProvider getProvider() {
        return provider;
    }
    
    ////
    
    protected Integer getPartnerId(IPartnerTitle partner) {
	return partner == null ? null : partner.getId();
    }
    
    ////
    
    
    public List getBankAccountsByPartner(IPartnerTitle partner) {
	return getBankAccountsByPartnerId(getPartnerId(partner));
    }
    
    public List getBankAccountsByPartnerId(Integer partnerId) {
	if (partnerId == null) {
	    return null;
	}
	BankAccountService service = getProvider().getBankAccountService();
	if (service == null) {
	    return null;
	}
	try {
	    return service.findByPartnerId(partnerId);
	} catch (ApplicationException ex) {
	    logger.error(ex);
	    return null;
	}
    }
    
    public BankAccount getBankAccount(IPartnerTitle partner) {
	if (partner == null) {
	    return null;
	}
	return getBankAccount(partner.getId());
    }
    
    public BankAccount getBankAccount(Integer partnerId) {
	if (partnerId == null) {
	    return null;
	}
	try {
	    return getProvider().getPartnerService().findDefaultBankAccount(partnerId);
	} catch (ApplicationException ex) {
	    logger.error(ex);
	}
	return null;
    }
    
    ////
    
    public void loadBankAccountsByPartnerField(XComboEdit bankAccountField, IPartnerTitle partner) {
	List dataList = getBankAccountsByPartner(partner);
	if (dataList != null) {
	    bankAccountField.setDataList(dataList);  
	}
    }
}
