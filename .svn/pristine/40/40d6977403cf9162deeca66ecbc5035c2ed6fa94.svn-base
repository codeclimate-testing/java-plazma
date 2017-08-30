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
 * Created on 28.03.2005
 *
 */
package org.plazmaforge.bsolution.bank.common.beans;

import org.plazmaforge.bsolution.partner.common.beans.DefPartnerAddress;
import org.plazmaforge.bsolution.partner.common.beans.DefPartnerPhone;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;

/**
 * @author hapon
 *
 */
public class BankHeader extends PartnerHeader implements IBankHeader {

    private String bic;
    
    private String correspondentAccount;

    private DefBankPhone defBankPhone;
    
    private DefBankAddress defBankAddress;

    
    
    public String getBic() {
        return bic;
    }
    
    public void setBic(String bic) {
        this.bic = bic;
    }
    
    public String getCorrespondentAccount() {
        return correspondentAccount;
    }
    
    public void setCorrespondentAccount(String correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    ////
    
    public DefBankAddress getDefBankAddress() {
        return defBankAddress;
    }

    public void setDefBankAddress(DefBankAddress defAddress) {
        this.defBankAddress = defAddress;
    }

    //
    
    public DefBankPhone getDefBankPhone() {
        return defBankPhone;
    }

    public void setDefBankPhone(DefBankPhone defBankPhone) {
        this.defBankPhone = defBankPhone;
    }

    // TODO: HACK !!!

    public DefPartnerPhone getDefPhone() {
	return getDefBankPhone();
    }

    public DefPartnerAddress getDefAddress() {
	return getDefBankAddress();
    }
    
}

