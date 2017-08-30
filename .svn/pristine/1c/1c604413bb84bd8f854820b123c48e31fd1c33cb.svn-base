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
 * Created on 15.05.2006
 *
 */

package org.plazmaforge.bsolution.finance.common.beans;

import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.framework.ext.model.Dictionary;


/**
 * @author Oleh Hapon
 * 
 * $Id: FinanceDocumentType.java,v 1.2 2010/04/28 06:24:25 ohapon Exp $
 */

public class FinanceDocumentType extends Dictionary {

    private DocumentType documentType;

    private String moveType;

    private boolean bothTaxAmount;

    private boolean includeTaxInAmount;

    public DocumentType getDocumentType() {
	return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
	this.documentType = documentType;
    }

    public Integer getDocumentTypeId() {
	return documentType == null ? null : documentType.getId();
    }
    
    public String getMoveType() {
	return moveType;
    }

    public void setMoveType(String moveType) {
	this.moveType = moveType;
    }

    public String getCode() {
	return documentType == null ? null : documentType.getCode();
    }

    public String getName() {
	return documentType == null ? null : documentType.getName();
    }

    public boolean isBothTaxAmount() {
	return bothTaxAmount;
    }

    public void setBothTaxAmount(boolean bothTaxAmount) {
	this.bothTaxAmount = bothTaxAmount;
    }

    public boolean isIncludeTaxInAmount() {
	return includeTaxInAmount;
    }

    public void setIncludeTaxInAmount(boolean includeTaxInAmount) {
	this.includeTaxInAmount = includeTaxInAmount;
    }

}
