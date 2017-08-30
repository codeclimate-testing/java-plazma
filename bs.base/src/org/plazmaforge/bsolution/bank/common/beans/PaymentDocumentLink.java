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
 * Created on 22.08.2007
 *
 */

package org.plazmaforge.bsolution.bank.common.beans;

import org.plazmaforge.bsolution.document.common.beans.DocumentTitle;
import org.plazmaforge.framework.ext.model.BaseEntity;


/** 
 * @author Oleh Hapon
 * $Id: PaymentDocumentLink.java,v 1.3 2010/12/05 07:56:02 ohapon Exp $
 */

public class PaymentDocumentLink extends BaseEntity {

    private DocumentTitle paymentDocument;
    
    private DocumentTitle reasonDocument;
    
    

    public DocumentTitle getPaymentDocument() {
        return paymentDocument;
    }

    public void setPaymentDocument(DocumentTitle paymentDocument) {
        this.paymentDocument = paymentDocument;
    }

    public DocumentTitle getReasonDocument() {
        return reasonDocument;
    }

    public void setReasonDocument(DocumentTitle reasonDocument) {
        this.reasonDocument = reasonDocument;
    }
    
    
}
