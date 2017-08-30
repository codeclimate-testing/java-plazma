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

import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntry;
import org.plazmaforge.bsolution.finance.common.services.EntryCalculateFinder;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.dao.AbstractSQLExecutor;


/*
 * Created 01.10.2006
 */
public class EntryCalculateExecutorImpl extends AbstractSQLExecutor {

    private EntryCalculateProcessor calculateProcessor;

    /**
     * Calculate entries
     * 
     * @param documents
     * @param entryMap
     */
    public void calculate(List<FinanceDocument> documents, Map<Integer, TemplateEntry> entryMap) throws ApplicationException  {
	for (FinanceDocument doc : documents) {
	    Integer typeId = doc.getDocumentTypeId();
	    TemplateEntry entry = entryMap.get(typeId);
	    if (entry == null) {
		continue;
	    }
	    calculate(doc, entry, true);
	}
    }

    /**
     * Calculate entries by finance document end template entry
     * 
     * @param doc
     * @param entry
     */
    public void calculate(FinanceDocument doc, TemplateEntry entry)  throws ApplicationException {
	calculate(doc, entry, false);
    }

    /**
     * Calculate entries by finance document end template entry
     * 
     * @param doc
     * @param entry
     * @param isRemoveEntries
     */
    public void calculate(FinanceDocument doc, TemplateEntry entry, boolean isRemoveEntries)  throws ApplicationException {
	if (isRemoveEntries) {
	    doc.getEntryItems().clear();
	}
	getCalculateProcessor().calculate(doc, entry);
    }


    public EntryCalculateProcessor getCalculateProcessor() {
	if (calculateProcessor == null) {
	    calculateProcessor = new EntryCalculateProcessor();
	}
	return calculateProcessor;
    }

    public void setEntryCalculateFinder(EntryCalculateFinder finder) {
	this.getCalculateProcessor().setEntryCalculateFinder(finder);
    }
}
