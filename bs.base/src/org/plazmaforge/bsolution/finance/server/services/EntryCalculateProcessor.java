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


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.base.common.beans.BusinessableHeader;
import org.plazmaforge.bsolution.finance.common.beans.EntryItem;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.beans.ProductMove;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntry;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntryItem;
import org.plazmaforge.bsolution.finance.common.services.EntryCalculateFinder;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.process.ICalculator;

/**
 * @author Oleh Hapon 
 * $Id: EntryCalculateProcessor.java,v 1.3 2010/12/05 07:55:57 ohapon Exp $
 */
public class EntryCalculateProcessor implements EntryCalculateConstants {

    private EntryCalculateFinder entryCalculateFinder;

    protected ICalculator getTemplateEntryCalculator(TemplateEntry entry) {
	// TODO: STUB
	return null;
    }

    protected ICalculator getTemplateEntryItemCalculator(TemplateEntryItem entryItem) {
	// TODO: STUB
	return null;
    }

    
    public void calculate(FinanceDocument doc, TemplateEntry entry) throws ApplicationException {

	if (doc == null || entry == null) {
	    return;
	}

	
	ICalculator entryCalculator = getTemplateEntryCalculator(entry);
	if (entryCalculator != null) {
	    Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put(FINANCE_DOCUMENT, doc);
	    parameters.put(TEMPLATE_ENTRY, entry);
	    entryCalculator.calculate(parameters);
	    return;
	}
	
	List<TemplateEntryItem> items = entry.getItems();
	if (items == null || items.size() == 0) {
	    // No template entry items
	    return;
	}
	for (TemplateEntryItem item : items) {
	    calculateItem(doc, item);
	}

    }

    /**
     * Calculate entry item of document by template entry item
     * 
     * @param doc
     * @param entryItem
     */
    protected void calculateItem(FinanceDocument doc, TemplateEntryItem entryItem) throws ApplicationException {
	
	ICalculator entryCalculator = getTemplateEntryItemCalculator(entryItem);
	if (entryCalculator != null) {
	    Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put(FINANCE_DOCUMENT, doc);
	    parameters.put(TEMPLATE_ENTRY_ITEM, entryItem);
	    entryCalculator.calculate(parameters);
	    return;
	}

	if (isItemProduct(entryItem)) {
	    List<ProductMove> productMoves = doc.getProductMoves();
	    if (productMoves == null || productMoves.size() == 0) {
		return;
	    }
	    for (ProductMove productMove : productMoves) {
		addEntryItem(doc, productMove, entryItem);
	    }
	} else {
	    addEntryItem(doc, null, entryItem);
	}
    }

    protected boolean isItemProduct(TemplateEntryItem entryItem) {
	String[] exp = entryItem.getExpressions();
	for (int i = 0; i < exp.length; i++) {
	    if (isItemProductExpression(exp[i])) {
		return true;
	    }
	}
	return false;

    }

    protected boolean isItemProductExpression(String expression) {
	return expression.startsWith(ITEM_PRODUCT);
    }

    // LEDGER ACCOUNT EXPRESSION
    protected LedgerAccount getLedgerAccountByExpression(String exp, FinanceDocument doc, ProductMove pcMove) {
	return isItemProductExpression(exp) ? getLedgerAccountByExpression(exp, pcMove) : getLedgerAccountByExpression(exp, doc);
    }

    protected LedgerAccount getLedgerAccountByExpression(String exp, FinanceDocument doc) {
	if (DOC_ACCOUNT.equals(exp)) {
	    return entryCalculateFinder.getDocumentLedgerAccount(doc.getDocumentTypeId());
	} else {
	    return entryCalculateFinder.getLedgerAccountByCode(exp);
	}
    }

    protected LedgerAccount getLedgerAccountByExpression(String exp, ProductMove pcMove) {
	if (ITEM_PRODUCT_ACCOUNT.equals(exp)) {
	    return entryCalculateFinder.getProductLedgerAccount(pcMove.getProductId());
	}
	return null;
    }

    // OBJECT EXPRESSION
    protected BusinessableHeader getObjectIdByExpression(String exp, FinanceDocument doc, ProductMove pcMove) {
	return isItemProductExpression(exp) ? getObjectIdByExpression(exp, pcMove) : getObjectIdByExpression(exp, doc);
    }

    protected BusinessableHeader getObjectIdByExpression(String exp, FinanceDocument doc) {
	if (DOC_PARTNER.equals(exp)) {
	    return entryCalculateFinder.getBusinessable(doc.getPartnerId());
	} else if (DOC_WAREHOUSE.equals(exp)) {
	    return entryCalculateFinder.getBusinessable(doc.getWarehouseId());
	}
	return null;
    }

    protected BusinessableHeader getObjectIdByExpression(String exp, ProductMove pcMove) {
	if (ITEM_PRODUCT.equals(exp)) {
	    return entryCalculateFinder.getBusinessable(pcMove.getProductId());
	}
	return null;
    }

    // AMOUNT EXPRESSION
    protected double getAmountByExpression(String exp, FinanceDocument doc, ProductMove pcMove) {
	return isItemProductExpression(exp) ? getAmountByExpression(exp, pcMove) : getAmountByExpression(exp, doc);
    }

    protected double getAmountByExpression(String exp, FinanceDocument doc) {
	if (DOC_AMOUNT.equals(exp)) {
	    return doc.getAmount();
	} else if (DOC_AMOUNT_WITH_TAX.equals(exp)) {
	    return doc.getAmountWithTax();
	} else if (DOC_TAX_AMOUNT.equals(exp)) {
	    return doc.getTaxAmount();
	}
	return 0d;
    }

    protected double getAmountByExpression(String exp, ProductMove pcMove) {
	if (ITEM_PRODUCT_AMOUNT.equals(exp)) {
	    return pcMove.getAmount();
	} else if (ITEM_PRODUCT_AMOUNT_WITH_TAX.equals(exp)) {
	    return pcMove.getAmountWithTax();
	} else if (ITEM_PRODUCT_TAX_AMOUNT.equals(exp)) {
	    return pcMove.getTaxAmount();
	}
	return 0d;
    }

    protected EntryItem addEntryItem(FinanceDocument doc, ProductMove pcMove, TemplateEntryItem teItem) {
	EntryItem entryItem = new EntryItem();

	// Set Ledger Account
	entryItem.setCreditLedgerAccount(getLedgerAccountByExpression(teItem.getCreditLedgerAccountExpression(), doc, pcMove));
	entryItem.setDebitLedgerAccount(getLedgerAccountByExpression(teItem.getDebitLedgerAccountExpression(), doc, pcMove));

	// Set Object
	entryItem.setCreditObject(getObjectIdByExpression(teItem.getCreditObjectExpression(), doc, pcMove));
	entryItem.setDebitObject(getObjectIdByExpression(teItem.getDebitObjectExpression(), doc, pcMove));

	// Set Amount
	entryItem.setAmount(getAmountByExpression(teItem.getAmountExpression(), doc, pcMove));

	// Set Content
	entryItem.setContent(teItem.getContent());

	addEntryItem(doc, entryItem);

	return entryItem;
    }
    
    protected void addEntryItem(FinanceDocument doc, EntryItem entryItem) {
	if (!isSupportLikeMode()) {
	    doc.addEntryItem(entryItem);
	    return;
	}
	
	EntryItem likeEntryItem = getLikeEntryItem(doc, entryItem);
	if (likeEntryItem == null) {
	    doc.addEntryItem(entryItem);
	    return;
	}
	likeEntryItem.setAmount(likeEntryItem.getAmount() + entryItem.getAmount());
    }
    
    protected boolean isSupportLikeMode() {
	return true;
    }
    
    protected EntryItem getLikeEntryItem(FinanceDocument doc, EntryItem newEntryItem) {
	List<EntryItem> entryItems = doc.getEntryItems();
	if (entryItems == null || entryItems.size() == 0) {
	    return null;
	}
	for (EntryItem entryItem : entryItems) {
	    if (isLike(newEntryItem, entryItem)) {
		return entryItem;
	    }
	}
	return null;
    }

    protected boolean isLike(EntryItem entryItem1, EntryItem entryItem2) {
	if (entryItem1 == null && entryItem2 == null) {
	    return false;
	} else if (entryItem1 == null || entryItem2 == null) {
	    return false;
	}
	
	boolean b1 = equals(entryItem1.getDebitLedgerAccount(), entryItem2.getDebitLedgerAccount());
	boolean b2 = equals(entryItem1.getCreditLedgerAccount(), entryItem2.getCreditLedgerAccount());
	
	boolean b3 = equals(entryItem1.getDebitObjectId(), entryItem2.getDebitObjectId());
	boolean b4 = equals(entryItem1.getCreditObjectId(), entryItem2.getCreditObjectId());

	boolean b5 = equals(entryItem1.getContent(), entryItem2.getContent());
	
	return (b1 && b2 && b3 && b4 && b5);
    }
    
    
    protected boolean equals(LedgerAccount a1, LedgerAccount a2) {
	if (a1 == null && a2 == null) {
	    return true;
	} else if (a1 == null || a2 == null) {
	    return false;
	}
	return equals(a1.getId(), a2.getId());
    }
    
    protected boolean equals(Object o1, Object o2) {
	if (o1 == null && o2 == null) {
	    return true;
	} else if (o1 == null || o2 == null) {
	    return false;
	}
	return o1.equals(o2);
    }
    
    public void setEntryCalculateFinder(EntryCalculateFinder finder) {
	this.entryCalculateFinder = finder;
    }

}
