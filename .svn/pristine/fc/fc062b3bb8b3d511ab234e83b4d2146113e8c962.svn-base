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
 * Created on 28.12.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author Oleh Hapon
 * $Id: TemplateEntryUtilities.java,v 1.2 2010/04/28 06:31:06 ohapon Exp $
 */

public class TemplateEntryUtilities {

    public static List getHelpElements() {
	List elements = new ArrayList();
	elements.add(createStringRow("Doc.Amount", Messages.getString("Doc.Amount")));
	elements.add(createStringRow("Doc.AmountWithTax", Messages.getString("Doc.Amount")));
	elements.add(createStringRow("Doc.TaxAmount", Messages.getString("Doc.TaxAmount")));
	elements.add(createStringRow("Doc.Partner", Messages.getString("Doc.Partner")));
	elements.add(createStringRow("Doc.Warehouse", Messages.getString("Doc.Warehouse")));
	elements.add(createStringRow("Item.Product", Messages.getString("Item.Product")));
	elements.add(createStringRow("Item.Product.Account", Messages.getString("Item.Product.Account")));
	elements.add(createStringRow("Item.Product.Amount", Messages.getString("Item.Product.Amount")));
	elements.add(createStringRow("Item.Product.AmountWithTax", Messages.getString("Item.Product.AmountWithTax")));	
	elements.add(createStringRow("Item.Product.TaxAmount", Messages.getString("Item.Product.TaxAmount")));	
	elements.add(createStringRow("01..02..NM", Messages.getString("Accounts")));
	
	return elements;
    }
    
    public static String[] createStringRow(String label, String value) {
	String[] row = new String[2];
	row[0] = label;
	row[1] = value;
	return row;
    }
}
