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
package org.plazmaforge.bsolution.bank.common.beans;

import org.plazmaforge.bsolution.partner.common.beans.Partner;


/**
 * @author Oleh Hapon
 * Date: 13.07.2004
 * Time: 7:48:00
 * $Id: Bank.java,v 1.2 2010/04/28 06:24:27 ohapon Exp $
 */
public class Bank extends Partner implements IBankHeader {

    /** Class ID **/
    public static final String CLASS_ID = "BANK";


    private String bic;

    private String correspondentAccount;

    private float stoppedPercent;

    public Bank() {
	super();
	setDescriminator(CLASS_ID);
    }

    protected String getClassId() {
	return CLASS_ID;
    }
    

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

    public float getStoppedPercent() {
	return stoppedPercent;
    }

    public void setStoppedPercent(float stoppedPercent) {
	this.stoppedPercent = stoppedPercent;
    }

    public String getDescriminator() {
	return CLASS_ID;
    }

    public BankHeader createBankHeader() {
	BankHeader bankHeader = new BankHeader();
	populate(bankHeader);
	return bankHeader;
    }

    public void populate(BankHeader bankHeader) {
	super.populate(bankHeader);
	bankHeader.setBic(getBic());
	bankHeader.setCorrespondentAccount(getCorrespondentAccount());
    }
}
