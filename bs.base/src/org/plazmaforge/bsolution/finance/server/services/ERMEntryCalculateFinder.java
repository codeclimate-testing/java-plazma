package org.plazmaforge.bsolution.finance.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.plazmaforge.bsolution.base.common.beans.BusinessableHeader;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.services.EntryCalculateFinder;
import org.plazmaforge.framework.erm.EntityManager;
import org.plazmaforge.framework.util.DBUtils;

public class ERMEntryCalculateFinder implements EntryCalculateFinder {

    private Connection connection;
    
    private EntityManager entityManager;

    public ERMEntryCalculateFinder(Connection connection, EntityManager entityManager) {
	this.connection = connection;
	this.entityManager = entityManager;
    }
    
    protected Connection getConnection() {
        return connection;
    }
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public LedgerAccount getLedgerAccountByCode(String code) {
	// Execute SQL
	return createLedgerAccount(getLedgerAccountId(getId("SELECT ID FROM LEDGER_ACCOUNT WHERE CODE = '" + code + "'")));
    }

    public LedgerAccount getDocumentLedgerAccount(Integer documentTypeId) {
	// TODO: Stub
	return createLedgerAccount();
    }

    public LedgerAccount getParntnerLedgerAccount(Integer partnerId) {
	// Execute SQL
	return createLedgerAccount(getLedgerAccountId(getId("SELECT LEDGER_ACCOUNT_ID FROM PARTNER WHERE ID = "	+ partnerId)));
    }

    public LedgerAccount getProductLedgerAccount(Integer productId) {
	// Execute SQL
	return createLedgerAccount(getLedgerAccountId(getId("SELECT LEDGER_ACCOUNT_ID FROM PRODUCT WHERE ID = " + productId)));
    }

    public BusinessableHeader getBusinessable(Integer ownerId) {
	return getEntityManager().load(BusinessableHeader.class, "ownerId", ownerId);
    }

    /**
     * Return object by SQL query
     * @param queryString
     * @return
     */
    protected Object getObject(String queryString) {
	return getValue(getConnection(), queryString);
    }

    /**
     * Return ID by SQL query 
     * @param queryString
     * @return
     */
    protected Integer getId(String queryString) {
	return (Integer) getValue(getConnection(), queryString);
    }

    protected LedgerAccount createLedgerAccount(Integer id) {
	if (id == null) {
	    return null;
	}
	LedgerAccount account = new LedgerAccount();
	account.setId(id);
	return account;
    }

    protected Integer getLedgerAccountId(Integer id) {
	// TODO: STUB
	return id;
    }

    // TODO: Stub
    private LedgerAccount createLedgerAccount() {
	LedgerAccount account = new LedgerAccount();
	account.setId(new Integer(1));
	return account;
    }

    ////
    
    protected List<Object[]> getList(Connection cn, String sql) {
	return getList(cn, sql, null);
    }
    
    protected List<Object[]> getList(Connection cn, String sql, Object[] parameters) {
	try {
	    return DBUtils.getList(cn, sql, parameters);
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.getMessage());
	}
    }
    
    ////
    
    protected Object getValue(Connection cn, String sql) {
	return getValue(cn, sql, null);
    }
    
    protected Object getValue(Connection cn, String sql, Object[] parameters) {
	try {
	    return DBUtils.getValue(cn, sql, parameters);
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.getMessage());
	}
    }
    
}
