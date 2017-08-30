package org.plazmaforge.bsolution.bank.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.bank.common.beans.PaymentDocument;
import org.plazmaforge.bsolution.bank.common.beans.PaymentDocumentLink;
import org.plazmaforge.bsolution.document.DocumentEnvironment;
import org.plazmaforge.bsolution.document.common.beans.DocumentStatus;
import org.plazmaforge.bsolution.document.common.beans.DocumentTitle;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.framework.erm.procedure.AbstractProcedure;
import org.plazmaforge.framework.util.DBUtils;
import org.plazmaforge.framework.util.StringUtils;

public class ERMPaymentLinkManager extends AbstractProcedure {

    public void execute(Connection cn, Map<String, Object> parameters) throws SQLException {
	try {
	    String entryPoint = getEntryPoint(parameters);
	    Object[] values = null;
	    PaymentDocument document = null;
	    setEntityManager(getEntityManager(parameters));
	    if ("loadLinks".equals(entryPoint)) {
		values = getParameterValues(parameters, 1, true);
		document = (PaymentDocument) values[0];
		loadLinks(cn, document);
	    } else if ("updateLinks".equals(entryPoint)) {
		values = getParameterValues(parameters, 1, true);
		document = (PaymentDocument) values[0];
		updateLinks(cn, document);
	    } else if ("deleteLinks".equals(entryPoint)) {
		values = getParameterValues(parameters, 1, true);
		document = (PaymentDocument) values[0];
		deleteLinks(cn, document);
	    } else if ("postSave".equals(entryPoint)) {
		values = getParameterValues(parameters, 1, true);
		PaymentDocumentLink documentLink = (PaymentDocumentLink) values[0];
		postSave(cn, documentLink);
	    } else if ("postDelete".equals(entryPoint)) {
		values = getParameterValues(parameters, 1, true);
		PaymentDocumentLink documentLink = (PaymentDocumentLink) values[0];
		postDelete(cn, documentLink);
	    } else {
		throw new RuntimeException("Entry point '" + entryPoint + "' not found");
	    }
	} catch (Exception ex) {
	    throw new RuntimeException(ex.getMessage());
	} finally {
	    setEntityManager(null);
	}
    }

    
    protected void loadLinks(Connection cn, PaymentDocument document) {
	if (document == null || document.getId() == null) {
	    return;
	}
	Integer id = document.getId();
	List<PaymentDocumentLink> links = findByOwner(id);
	List<FinanceDocument> reasonDocuments = new ArrayList<FinanceDocument>();
	document.setReasonDocuments(reasonDocuments);
	if (links == null) {
	    return;
	}
	for (PaymentDocumentLink link : links) {
	    Integer reasonDocumentId = link.getReasonDocument().getId();
	    FinanceDocument reasonDocument = findFinanceDocumentById(reasonDocumentId);
	    
	    reasonDocument.setLinkId(link.getId());
	    reasonDocuments.add(reasonDocument);
	}
    }
    
    protected void updateLinks(Connection cn, PaymentDocument document) {
	if (document == null) {
	    return;
	}
	List<PaymentDocumentLink> links = document.getPaymentDocumentLinks();
	for (PaymentDocumentLink link : links) {
	    Integer id = link.getId();
	    
	    if (id == null) {
		//if (link.isCreated()) {
		getEntityManager().insert(link);
		//}
	    } else {
		if (link.isDeleted()) {
		    getEntityManager().delete(link);
		} else {
		    getEntityManager().update(link);
		}
	    }
	}
	
	List<PaymentDocumentLink> dbLinks = getLinks(document);
	if (dbLinks == null) {
	    return;
	}
	for (PaymentDocumentLink dbLink : dbLinks) {
	    Integer id = dbLink.getId();
	    boolean found = false;
	    for (PaymentDocumentLink link : links) {
		if (id.equals(link.getId())) {
		    found = true;
		}
	    }
	    if (!found) {
		getEntityManager().delete(dbLink);
	    }
	}
    }
    
    protected void deleteLinks(Connection cn, PaymentDocument document) {
	if (document == null) {
	    return;
	}
	List<PaymentDocumentLink> links = getLinks(document);
	if (links == null || links.size() == 0) {
	    return;
	}
	for (PaymentDocumentLink link : links) {
	    getEntityManager().delete(link);
	}
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////

    protected void postSave(Connection cn, PaymentDocumentLink documentLink) {
	updateDocumentStatus(cn, getReasonDocument(documentLink), true);
    }
    
    protected void postDelete(Connection cn, PaymentDocumentLink documentLink) {
	updateDocumentStatus(cn, getReasonDocument(documentLink), false);
    }
    
    /**
     * Return reason document of the link
     * @param document
     * @return
     */
    protected DocumentTitle getReasonDocument(PaymentDocumentLink documentLink) {
	if (documentLink == null) {
	    return null;
	}
	return documentLink.getReasonDocument();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Return Finance Document by id
     * @param id
     * @return
     */
    protected FinanceDocument findFinanceDocumentById(Integer id) {
	return getEntityManager().loadById(FinanceDocument.class, id);
    }

    /**
     * Return links of document id
     * @param ownerId
     * @return
     */
    protected List<PaymentDocumentLink> findByOwner(Integer ownerId) {
	return getEntityManager().findAll(PaymentDocumentLink.class, "paymentDocument.id", ownerId);
    }


    /**
     * Return links of document
     * @param docuemnt
     * @return
     */
    protected List<PaymentDocumentLink> getLinks(PaymentDocument document) {
	if (document == null || document.getId() == null) {
	    return null;
	}
	List<PaymentDocumentLink> links = findByOwner(document.getId());
	return links;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Update pay document status
     * @param cn
     * @param document
     * @param isPaid
     */
    protected void updateDocumentStatus(Connection cn, DocumentTitle document, boolean isPaid) {
	if (document == null || document.getId() == null) {
	    return;
	}
	String tableName = document.getDocumentTypeCode();
	if (StringUtils.isEmpty(tableName)) {
	    return;
	}
	try {
	    String status = isPaid ? "Y" : "N";
	    String sql = "UPDATE " + tableName + " SET IS_PAID = '" + status + "' WHERE ID = " + document.getId();
	    DBUtils.execute(cn, sql);

	    List<DocumentStatus> documentStatuses = DocumentEnvironment.getDocumentStatusesByType(tableName);
	    DocumentStatus documentStatus = null;
	    if (documentStatuses != null && !documentStatuses.isEmpty()) {
		documentStatus = isPaid ? getPaidStatus(documentStatuses) : getDefaultStatus(documentStatuses); // TODO
	    }
	    if (documentStatus == null) {
		return;
	    }
	    sql = "UPDATE DOCUMENT SET DOCUMENT_STATUS_ID = " + documentStatus.getId();
	    DBUtils.execute(cn, sql);
	    
	} catch (Exception ex) {
	    throw new RuntimeException(ex.toString());
	}
    }
    
    protected DocumentStatus getDefaultStatus(List<DocumentStatus> documentStatuses) {
	if (documentStatuses == null) {
	    return null;
	}
	for (DocumentStatus status : documentStatuses) {
	    if (DocumentStatus.CREATED_STATUS.equals(status.getCode())) {
		return status;
	    }
	}
	return null;
    }
    
    protected DocumentStatus getPaidStatus(List<DocumentStatus> documentStatuses) {
	if (documentStatuses == null) {
	    return null;
	}
	for (DocumentStatus status : documentStatuses) {
	    if (DocumentStatus.PAID_STATUS.equals(status.getCode())) {
		return status;
	    }
	}
	return null;
    }
    
}
