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
 * Created on 08.12.2007
 *
 */

package org.plazmaforge.bsolution.partner.client.swt.actions;

import org.plazmaforge.bsolution.sale.client.swt.forms.SaleOrderListForm;
import org.plazmaforge.framework.client.actions.AbstractListFormAction;


/** 
 * @author Oleh Hapon
 * $Id: PartnerSaleOrderListAction.java,v 1.2 2010/04/28 06:31:03 ohapon Exp $
 */

public class PartnerSaleOrderListAction extends AbstractListFormAction  {
    
    public Class getListFormClass() {
	return SaleOrderListForm.class;
    }
}