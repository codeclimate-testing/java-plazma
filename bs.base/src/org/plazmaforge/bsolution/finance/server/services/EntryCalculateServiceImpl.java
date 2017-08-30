package org.plazmaforge.bsolution.finance.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.base.common.beans.BusinessableHeader;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntry;
import org.plazmaforge.bsolution.finance.common.services.EntryCalculateService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.erm.LoadMode;
import org.plazmaforge.framework.ext.service.impl.AbstractService;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.util.DBUtils;

public class EntryCalculateServiceImpl extends AbstractService implements EntryCalculateService {

    
    public Map calculate(final Map parameters) throws ApplicationException {
	return calculate(getConnection(), parameters);
    }

    public Map calculate(Connection cn, Map parameters) throws ApplicationException {
	if (parameters == null) {
	    throw new ApplicationException("Parameters not found");
	}
	Integer periodId = (Integer) parameters.get("PERIOD_ID");
	if (periodId == null) {
	    throw new ApplicationException("[PERIOD_ID] is null");
	}
	Integer organizationId = (Integer) parameters.get("ORGANIZATION_ID");
	if (organizationId == null) {
	    throw new ApplicationException("[ORGANIZATION_ID] is null");
	}

	// Create special map for store message
	Map<String, String> outParameters = new HashMap<String, String>();
	
	try {

	    List<FinanceDocument> documents = getFinanceDocuments(organizationId, periodId);
	    if (documents == null || documents.size() == 0) {
		outParameters.put("MESSAGE", "No calculation: Count of Finanace document is 0");
		return outParameters;
	    }

	    EntryCalculateExecutorImpl executor = new EntryCalculateExecutorImpl();
	    CacheEntryCalculateFinder finder = new CacheEntryCalculateFinder();
	    executor.setEntryCalculateFinder(finder);

	    // Load all template entries
	    List<TemplateEntry> entries = getTemplateEntries();
	    
	    if (entries == null || entries.size() == 0) {
		outParameters.put("MESSAGE", "No calculation: Count of Accounting enty templates is 0");
		return outParameters;
	    }

	    Map documentTypeLedgerAccountMap = new HashMap();
	    Map<Integer, TemplateEntry> entryMap = new HashMap<Integer, TemplateEntry>();
	    for (TemplateEntry entry : entries) {
		Integer documentTypeId = entry.getFinanceDocumentType().getDocumentTypeId();
		entryMap.put(documentTypeId, entry);
		documentTypeLedgerAccountMap.put(documentTypeId, new Integer(1)); // TODO: Stub
	    }

	    finder.setDocumentTypeLedgerAccountMap(documentTypeLedgerAccountMap);

	    // SQL
	    finder.setBusinessableMap(createBusinessableMap());
	    finder.setAccountMap(createIdsMap(cn, "SELECT CODE, ID FROM LEDGER_ACCOUNT"));
	    
	    // SQL
	    finder.setPartnerLedgerAccountMap(createIdsMap(cn, "SELECT ID, LEDGER_ACCOUNT_ID FROM PARTNER"));
	    finder.setProductLedgerAccountMap(createIdsMap(cn, "SELECT ID, LEDGER_ACCOUNT_ID FROM PRODUCT"));

	    // Calculate entries
	    executor.calculate(documents, entryMap);

	    return outParameters;
	    
	} catch (SQLException ex) {
	    throw new ApplicationException(ex);
	}

    }

    protected List<FinanceDocument> getFinanceDocuments(Integer organizationId, Integer periodId) {
	Criteria criteria = new Criteria();
	criteria.addFilter("organizationId", organizationId);
	criteria.addFilter("periodId", periodId);
	//return getEntityManager().select(FinanceDocument.class, criteria, LoadMode.FORCE, "-documentType.relations, -documentType.statuses, -responsible, -contractDocument, -reasonDocument, -project, -partner, -entryItems, -partnerMoves, -productMoves, -warehouseMoves, -contractorMoves, -employeeMoves");
	return getEntityManager().findAll(FinanceDocument.class, criteria, LoadMode.FORCE, "-documentType.relations, -documentType.statuses, -responsible, -contractDocument, -reasonDocument");
    }

    protected List<TemplateEntry> getTemplateEntries() {
	return getEntityManager().findAll(TemplateEntry.class, new Criteria(), LoadMode.FORCE);
    }
    
    protected Map createBusinessableMap() {
	List<BusinessableHeader> list = getEntityManager().findAll(BusinessableHeader.class);
	Map<Integer, BusinessableHeader> map = new HashMap<Integer, BusinessableHeader>();
	if (list == null || list.size() == 0) {
	    return map;
	}
	for (int i = 0; i < list.size(); i++) {
	    BusinessableHeader row = (BusinessableHeader) list.get(i);
	    map.put(row.getId(), row);
	}
	return map;
    }
    
    protected Map createIdsMap(Connection cn, String queryString) throws SQLException {
	List<Object[]> list = DBUtils.getList(cn, queryString);
	Map map = new HashMap();
	for (int i = 0; i < list.size(); i++) {
	    Object[] row = (Object[]) list.get(i);
	    map.put(row[0], row[1]);
	}
	return map;
    }
    
    public void removeEntryItems(final Integer organizationId, final Integer periodId) throws ApplicationException {
	try {
	    removeEntryItems(getConnection(), organizationId, periodId);
	} catch (SQLException ex ){
	    throw new ApplicationException(ex);
	}
    }
    
    protected void removeEntryItems(Connection cn, Integer organizationId, Integer periodId) throws SQLException {
	// SQL
	String sql = "DELETE FROM ENTRY_ITEM WHERE ID IN (SELECT I.ID FROM ENTRY_ITEM I" +
	" INNER JOIN FINANCE_DOCUMENT FD ON FD.ID = I.OWNER_ID" +
	" INNER JOIN DOCUMENT D ON D.ID = FD.ID" +
	" WHERE D.ORGANIZATION_ID = " + organizationId.intValue() + " AND D.PERIOD_ID = " + periodId.intValue() + ")";
	DBUtils.execute(cn, sql);
    }

    @Override
    public void setInfo(String info) {
    }

    @Override
    public String getInfo() {
	return null;
    }


}
