package org.plazmaforge.bsolution.document.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.bsolution.document.common.services.DocumentTypeService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.service.OwnCriteriaService;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.util.DBUtils;

public class DocumentTypeServiceImpl extends AbstractEntityService<DocumentType, Integer> implements DocumentTypeService, OwnCriteriaService {

    protected Class getEntityClass() {
        return DocumentType.class;
    }
    
    protected void prepareERMCriteria(Criteria criteria) {
	criteria.addFilter("entity.id", "<SYS_ROW>", "<>");
    }

    public List<DocumentType> sysLoadDocumentTypes() throws DAOException {
        return findAll();
    }

    public void setNewDocumentNo(Document document) {
	String documentCode = generateDocumentNo(document);
	if (documentCode == null) {
	    return;
	}
	document.setDocumentNo(documentCode);
	
    }
    
    public String generateDocumentNo(Document document) {
	return generateDocumentNo(document.getDocumentType().getEntity().getId());
    }

    
    public String generateDocumentNo(DocumentType documentType) {
	return generateDocumentNo(documentType.getEntity().getId());
    }
    
    public String generateDocumentNo(String entityId) {
	return doGenerateDocumentNo(entityId);
    }
    
    ////
    
    protected String doGenerateDocumentNo(final String entityId) {
	try {
	    return doGenerateDocumentNo(getConnection(), entityId);
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }

    /**
     * Generate new Document No by <code>tableName</code>
     * If number is NULL then auto generation is not supports.
     */
    protected String doGenerateDocumentNo(Connection cn, String tableName) throws SQLException {
	
	String sql = "SELECT LAST_DOCUMENT_NUMBER, DOCUMENT_NO_PREFIX, DOCUMENT_NO_SUFFIX FROM DOCUMENT_TYPE WHERE ENTITY_ID = '" + tableName + "' AND IS_USE_NUMERATOR = 'Y'";
	List<Object[]> list = DBUtils.getList(cn, sql);
	if (list == null || list.isEmpty()) {
	    return null;
	}
	Object[] row = (Object[]) list.get(0);
	Integer lastNumber = (Integer) row[0];
	String prefix = (String) row[1];
	String suffix = (String) row[2];;
	
	////
	lastNumber++;
	sql = "UPDATE DOCUMENT_TYPE SET LAST_DOCUMENT_NUMBER = " + lastNumber + " WHERE ENTITY_ID = '" + tableName + "'";
	DBUtils.execute(cn, sql);
	
	////
	StringBuffer buf = new StringBuffer();
	if (prefix != null) {
	    buf.append(prefix.trim());
	}
	buf.append(lastNumber);
	if (suffix != null) {
	    buf.append(suffix.trim());
	}
	return buf.toString();
    }
}
