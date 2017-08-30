package org.plazmaforge.bsolution.finance.common;

import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.finance.common.beans.Contract;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class ContractDocumentCreator extends FinanceDocumentCreator {

    protected void populate(Document parentDocument, Document document) throws ApplicationException {
	if (parentDocument == null || document == null) {
	    return;
	}
	super.populate(parentDocument, document);
	Contract contract = (Contract) document;
	contract.setName("#" + parentDocument.getDocumentNo());
    }	
}
