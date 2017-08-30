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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.base.server.services.BaseCompressionExecutor;
import org.plazmaforge.bsolution.finance.common.services.FinanceCompressionExecutor;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon Date: 04.01.2005 Time: 7:53:00 
 * $Id: FinanceCompressionExecutorImpl.java,v 1.3 2010/12/05 07:55:57 ohapon Exp $
 */
public class FinanceCompressionExecutorImpl extends BaseCompressionExecutor implements FinanceCompressionExecutor {

    public void executeCompression(Statement stm, int periodId) throws SQLException {
	addRest(stm, periodId);
	addIncome(stm, periodId);
	addOutcome(stm, periodId);
    }
    
    public void beforeCompression(Statement stm, int periodId) throws SQLException, ApplicationException {
	stm.execute("DELETE FROM M_LEDGER_ACCOUNT_REGISTER");

    }

    public void afterCompression(Statement stm, int organizationId, int prevPeriodId, int curPeriodId, int newPeriodId) throws SQLException, ApplicationException {
	afterCompressionLedgerAccount(stm, organizationId, newPeriodId, prevPeriodId);
    }

    private void addRest(Statement stm, int periodId) throws SQLException {
	stm.execute("INSERT INTO M_LEDGER_ACCOUNT_REGISTER (LEDGER_ACCOUNT_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)"
		+ " SELECT LEDGER_ACCOUNT_ID, AD.DEBIT_AMOUNT, AD.CREDIT_AMOUNT FROM LEDGER_ACCOUNT_REST AD"
		+ " WHERE AD.PERIOD_ID = " + periodId);
    }

    // + ENTRY ITEMS INCOME
    private void addIncome(Statement st, int periodId) throws SQLException {

        // LEDGER ACCOUNT
        st.execute(
        	"INSERT INTO M_LEDGER_ACCOUNT_REGISTER (LEDGER_ACCOUNT_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)"+
                " SELECT I.CREDIT_LEDGER_ACCOUNT_ID, 0, I.AMOUNT" +                
        	" FROM ENTRY_ITEM I" +
                " INNER JOIN FINANCE_DOCUMENT FD ON FD.ID = I.OWNER_ID" +
                " INNER JOIN DOCUMENT D ON D.ID = FD.ID" +
                " WHERE D.PERIOD_ID = " + periodId
        );
    }

    // + ENTRY ITEMS OUTCOME
    private void addOutcome(Statement st, int periodId) throws SQLException {

        // LEDGER ACCOUNT
        st.execute(
        	"INSERT INTO M_LEDGER_ACCOUNT_REGISTER (LEDGER_ACCOUNT_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)"+
                " SELECT I.DEBIT_LEDGER_ACCOUNT_ID, I.AMOUNT, 0" +                
        	" FROM ENTRY_ITEM I" +
                " INNER JOIN FINANCE_DOCUMENT FD ON FD.ID = I.OWNER_ID" +
                " INNER JOIN DOCUMENT D ON D.ID = FD.ID" +
                " WHERE D.PERIOD_ID = " + periodId
        );
    }

    public void afterCompressionLedgerAccount(Statement stm, int organizationId, int newPeriodId, int prevPeriodId) throws SQLException, ApplicationException {

	// Delete from M_LEDGER_ACCOUNT_REGISTER_SUM
	stm.execute("DELETE FROM M_LEDGER_ACCOUNT_REGISTER_SUM");

	// Insert into M_LEDGER_ACCOUNT_REGISTER_SUM
	stm.execute("INSERT INTO M_LEDGER_ACCOUNT_REGISTER_SUM (LEDGER_ACCOUNT_ID, DEBIT_AMOUNT, CREDIT_AMOUNT) "
		+ " SELECT R.LEDGER_ACCOUNT_ID, SUM(R.DEBIT_AMOUNT), SUM(R.CREDIT_AMOUNT) FROM M_LEDGER_ACCOUNT_REGISTER R"
		+ " GROUP BY R.LEDGER_ACCOUNT_ID");

	// -------------------------------------------------------------------------------------------------
	// Populate temporable table M_LEDGER_ACCOUNT_REGISTER_ID
	// -------------------------------------------------------------------------------------------------

	// Delete from M_LEDGER_ACCOUNT_REGISTER_ID
	stm.execute("DELETE FROM M_LEDGER_ACCOUNT_REGISTER_ID");

	// Insert into M_LEDGER_ACCOUNT_REGISTER_ID from LEDGER_ACCOUNT_REGISTER
	stm.execute("INSERT INTO M_LEDGER_ACCOUNT_REGISTER_ID (LEDGER_ACCOUNT_ID) "
		+ "    SELECT P.LEDGER_ACCOUNT_ID FROM LEDGER_ACCOUNT_REGISTER P"
		+ "    WHERE P.ORGANIZATION_ID = " + organizationId
		+ " AND P.PERIOD_ID = " + prevPeriodId);

	// Insert into M_LEDGER_ACCOUNT_REGISTER_ID from M_LEDGER_ACCOUNT_REGISTER_SUM
	stm.execute("INSERT INTO M_LEDGER_ACCOUNT_REGISTER_ID (LEDGER_ACCOUNT_ID) "
		+ "    SELECT R.LEDGER_ACCOUNT_ID FROM M_LEDGER_ACCOUNT_REGISTER_SUM R "
		+ "    WHERE NOT (R.LEDGER_ACCOUNT_ID IN (SELECT I.LEDGER_ACCOUNT_ID FROM M_LEDGER_ACCOUNT_REGISTER_ID I))");

	stm.execute("DELETE FROM LEDGER_ACCOUNT_REGISTER WHERE "
		+ "ORGANIZATION_ID = " + organizationId + " AND "
		+ "PERIOD_ID = " + newPeriodId);

	addLedgerAccountRegister(stm, organizationId, prevPeriodId, newPeriodId);
    }

    
    protected void addLedgerAccountRegister(Statement stm, int organizationId, int prevPeriodId, int newPeriodId) throws SQLException {
	List<LedgerAccountInfo> ledgerAccountInfoList = getLedgerAccountRegister(stm, organizationId, prevPeriodId, newPeriodId);
	if (ledgerAccountInfoList == null || ledgerAccountInfoList.size() == 0) {
	    return;
	}
	String sql = "INSERT INTO LEDGER_ACCOUNT_REGISTER (" + " ID,"
	+ " ORGANIZATION_ID," + " PERIOD_ID," + " LEDGER_ACCOUNT_ID,"
	+ " DEBIT_AMOUNT," + " CREDIT_AMOUNT, " + " AMOUNT) "
	+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

	ResultSet rs = stm.executeQuery("SELECT MAX(ID) FROM LEDGER_ACCOUNT_REGISTER");
	rs.next();
	int id = rs.getInt(1);

	PreparedStatement ps = prepareStatement(sql);
	try {
	    for (LedgerAccountInfo info : ledgerAccountInfoList) {
		id++;
		ps.setInt(1, id);
		ps.setInt(2, organizationId);
		ps.setInt(3, newPeriodId);
		ps.setInt(4, info.ledgerAccountId);

		ps.setDouble(5, info.debitAmount);
		ps.setDouble(6, info.creditAmount);

		ps.setDouble(7, info.amount);

		ps.execute();
	    }
	} finally {
	    close(rs);
	    close(ps);
	}

    }

    protected List<LedgerAccountInfo> getLedgerAccountRegister(Statement stm, int organizationId, int prevPeriodId, int newPeriodId) throws SQLException {

	List<LedgerAccountInfo> ledgerAccountInfoList = null;
	String sql = null;
	ResultSet rs = null;
	try {
	    if (prevPeriodId > 0) {
		sql = " SELECT "
			+ " U.LEDGER_ACCOUNT_ID,"
			+ " U1.DEBIT_AMOUNT,"
			+ " U2.DEBIT_AMOUNT,"
			+ " U1.CREDIT_AMOUNT,"
			+ " U2.CREDIT_AMOUNT"
			+ " FROM M_LEDGER_ACCOUNT_REGISTER_ID U "
			+ " LEFT JOIN LEDGER_ACCOUNT_REGISTER U1 ON U1.LEDGER_ACCOUNT_ID = U.LEDGER_ACCOUNT_ID AND U1.LEDGER_ACCOUNT_ID = "
			+ prevPeriodId
			+ " LEFT JOIN M_LEDGER_ACCOUNT_REGISTER_SUM U2 ON U2.LEDGER_ACCOUNT_ID = U.LEDGER_ACCOUNT_ID";

		rs = stm.executeQuery(sql);
		ledgerAccountInfoList = new ArrayList<LedgerAccountInfo>();
		while (rs.next()) {
		    LedgerAccountInfo info = new LedgerAccountInfo();
		    info.ledgerAccountId = rs.getInt(1);

		    info.debitAmount = rs.getDouble(2) + rs.getDouble(3);
		    info.creditAmount = rs.getDouble(4) + rs.getDouble(5);

		    info.amount = info.creditAmount - info.debitAmount;

		    ledgerAccountInfoList.add(info);
		}

	    } else {

		sql = "SELECT LEDGER_ACCOUNT_ID, DEBIT_AMOUNT, CREDIT_AMOUNT FROM M_LEDGER_ACCOUNT_REGISTER_SUM";

		rs = stm.executeQuery(sql);
		ledgerAccountInfoList = new ArrayList<LedgerAccountInfo>();
		while (rs.next()) {
		    LedgerAccountInfo info = new LedgerAccountInfo();
		    info.ledgerAccountId = rs.getInt(1);

		    info.debitAmount = rs.getDouble(2);
		    info.creditAmount = rs.getDouble(3);

		    info.amount = info.creditAmount - info.debitAmount;

		    ledgerAccountInfoList.add(info);
		}
	    }

	} finally {
	    close(rs);
	}

	return ledgerAccountInfoList;
    }
    

    private class LedgerAccountInfo {

	int ledgerAccountId;

	double debitAmount;

	double creditAmount;

	double amount;
    }
}
