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

package org.plazmaforge.bsolution.sale.common.beans;

import org.plazmaforge.bsolution.finance.common.beans.IPayReasonDocument;
import org.plazmaforge.bsolution.finance.common.beans.IPartnerableDocument;
import org.plazmaforge.bsolution.product.common.beans.ProductDocument;



/**
 * @author Oleh Hapon
 * Date: 12.09.2004
 * Time: 15:50:02
 * $Id: SaleInvoice.java,v 1.3 2010/04/28 06:24:24 ohapon Exp $
 */
public class SaleInvoice extends ProductDocument implements IPartnerableDocument, IPayReasonDocument  {

    public static final String CLASS_ID = "SALE_INVOICE";
    
    private boolean paid;

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    
   
}