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

package org.plazmaforge.bsolution.finance.server.services;


import java.util.Map;

import org.plazmaforge.bsolution.base.common.beans.BusinessableHeader;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.services.EntryCalculateFinder;

/*
* Created 09.10.2006
*/
public class CacheEntryCalculateFinder implements EntryCalculateFinder {


    private Map businessableMap;

    private Map accountMap;


    private Map documentTypeLedgerAccountMap;

    private Map partnerLedgerAccountMap;

    private Map productLedgerAccountMap;




    public LedgerAccount getLedgerAccountByCode(String code) {
        return createLedgerAccount(getLedgerAccountId( (Integer) accountMap.get(code)) );
    }

    public LedgerAccount getDocumentLedgerAccount(Integer documentTypeId) {
        return createLedgerAccount(getLedgerAccountId( (Integer) documentTypeLedgerAccountMap.get(documentTypeId)) );
    }

    public LedgerAccount getParntnerLedgerAccount(Integer partnerId) {
        return createLedgerAccount(getLedgerAccountId( (Integer) partnerLedgerAccountMap.get(partnerId)) );
    }

    public LedgerAccount getProductLedgerAccount(Integer productId) {
        return createLedgerAccount(getLedgerAccountId( (Integer) productLedgerAccountMap.get(productId)) );
    }

    public BusinessableHeader getBusinessable(Integer ownerId) {
	return (BusinessableHeader) businessableMap.get(ownerId);
    }

    protected LedgerAccount createLedgerAccount(Integer id) {
        if (id == null) {
            return null;
        }
        LedgerAccount account = new LedgerAccount();
        account.setId(id);
        return account;
    }

    protected Integer getLedgerAccountId(Integer id) {
    	// TODO: STUB
        return id;
    }


    public void setBusinessableMap(Map businessableMap) {
        this.businessableMap = businessableMap;
    }

    public void setAccountMap(Map accountMap) {
        this.accountMap = accountMap;
    }

    public void setDocumentTypeLedgerAccountMap(Map documentTypeLedgerAccountMap) {
        this.documentTypeLedgerAccountMap = documentTypeLedgerAccountMap;
    }

    public void setPartnerLedgerAccountMap(Map partnerLedgerAccountMap) {
        this.partnerLedgerAccountMap = partnerLedgerAccountMap;
    }

    public void setProductLedgerAccountMap(Map productLedgerAccountMap) {
        this.productLedgerAccountMap = productLedgerAccountMap;
    }
}
