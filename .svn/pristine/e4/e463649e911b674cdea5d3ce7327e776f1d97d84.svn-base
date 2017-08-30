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
 * Created on 05.06.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.document.client.swt.forms.AbstractDocumentListForm;
import org.plazmaforge.bsolution.finance.FinanceEnvironment;
import org.plazmaforge.bsolution.finance.client.swt.actions.EntryItemsDialogAction;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;


/** 
 * @author Oleh Hapon
 * $Id: AbstractFinanceDocumentListForm.java,v 1.4 2010/05/26 07:38:36 ohapon Exp $
 */

public abstract class AbstractFinanceDocumentListForm extends AbstractDocumentListForm {

    public static final String NO_ENTRIES_MESSAGE = Messages.getString("AbstractFinanceDocumentListForm.noentries");
	
	
    public AbstractFinanceDocumentListForm(Composite parent, int style) {
	super(parent, style);
    }
    
    protected void initDocumentActions() {
	super.initDocumentActions();
	initEntryItemsAction();
    }

    protected void initEntryItemsAction() {
	if (!isEntryItemsAction()) {
	    return;
	}
	EntryItemsDialogAction action = new EntryItemsDialogAction();
	action.setName(Messages.getString("AbstractFinanceDocumentListForm.doEntryItemsDialogAction"));
	addAction(action);
    }

    protected boolean isEntryItemsAction() {
	return true;
    }

    protected boolean isIncludeTaxInAmount() {
	return FinanceEnvironment.isIncludeTaxInAmount(getEntityClass());
    }
    
    ////
    
    protected String getEnterTotalProperty() {
	return FinanceDocument.getEnterTotalProperty(getEntityClass());
    }
    
    protected String getCurrencyEnterTotalProperty() {
	return FinanceDocument.getCurrencyEnterTotalProperty(getEntityClass());
    }

    ////
    
    protected String getEnterAmountProperty() {
	return FinanceDocument.getEnterAmountProperty(getEntityClass());
    }
    
    protected String getCurrencyAmountTotalProperty() {
	return FinanceDocument.getCurrencyAmountTotalProperty(getEntityClass());
    }
	

    
    
    

}
