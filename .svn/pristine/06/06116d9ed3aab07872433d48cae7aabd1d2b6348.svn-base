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
package org.plazmaforge.bsolution.finance.common.beans;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.ext.model.Dictionary;


/**
 * @author Oleh Hapon 
 * Date: 07.02.2003 
 * Time: 14:07:15
 */

/**
 * This template ledger account entry
 */
public class TemplateEntry extends Dictionary {

    private FinanceDocumentType financeDocumentType;

    private String content;
    
    private String entryClass;
    
    
    private List<TemplateEntryItem> items;

    public List<TemplateEntryItem> getItems() {
	if (items == null) {
	    items = new ArrayList<TemplateEntryItem>();
	}
	return items;
    }

    public void setItems(List<TemplateEntryItem> items) {
	this.items = items;
    }

    public FinanceDocumentType getFinanceDocumentType() {
	return financeDocumentType;
    }

    public void setFinanceDocumentType(FinanceDocumentType financeDocumentType) {
	this.financeDocumentType = financeDocumentType;
    }

    public String getFinanceDocumentTypeName() {
	return financeDocumentType == null ? null : getFinanceDocumentType().getName();
    }

    public void addItem(TemplateEntryItem item) {
	item.setTemplateEntry(this);
	getItems().add(item);
    }

    public void init() {
	getItems().size();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEntryClass() {
        return entryClass;
    }

    public void setEntryClass(String entryClass) {
        this.entryClass = entryClass;
    }

    
}
