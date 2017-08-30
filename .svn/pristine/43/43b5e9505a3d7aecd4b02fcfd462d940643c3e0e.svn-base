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
 * Created on 02.01.2008
 *
 */

package org.plazmaforge.bsolution.partner.server.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.base.server.services.BaseCompressionExecutor;
import org.plazmaforge.bsolution.partner.common.services.PartnerCompressionExecutor;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * Partner Compression Period
 * Insert PARTNER REST into momento PARTNER REGISTER
 */


/** 
 * @author Oleh Hapon
 * $Id: PartnerCompressionExecutorImpl.java,v 1.3 2010/12/05 07:56:00 ohapon Exp $
 */

public class PartnerCompressionExecutorImpl extends BaseCompressionExecutor implements PartnerCompressionExecutor {

    public void executeCompression(Statement stm, int periodId) throws SQLException {
	addPartner(stm, periodId);
    }

    public void beforeCompression(Statement stm, int periodId) throws SQLException, ApplicationException {
	stm.execute("DELETE FROM M_PARTNER_REGISTER");
    }

    public void afterCompression(Statement stm, int organizationId, int prevPeriodId, int curPeriodId, int newPeriodId) throws SQLException, ApplicationException {
	afterCompressionPartner(stm, organizationId, newPeriodId, prevPeriodId);
    }

    private void addPartner(Statement stm, int periodId) throws SQLException {
	stm.execute("INSERT INTO M_PARTNER_REGISTER (PARTNER_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)"
		+ " SELECT PARTNER_ID, AD.DEBIT_AMOUNT, AD.CREDIT_AMOUNT FROM V_PARTNER_REST AD"
		+ " WHERE AD.PERIOD_ID = " + periodId);
    }

    public void afterCompressionPartner(Statement stm, int organizationId, int newPeriodId, int prevPeriodId) throws SQLException, ApplicationException {

	// Delete from M_PARTNER_REGISTER_SUM
	stm.execute("DELETE FROM M_PARTNER_REGISTER_SUM");

	// Insert into M_PARTNER_REGISTER_SUM
	stm.execute("INSERT INTO M_PARTNER_REGISTER_SUM (PARTNER_ID, DEBIT_AMOUNT, CREDIT_AMOUNT) "
		+ " SELECT R.PARTNER_ID, SUM(R.DEBIT_AMOUNT), SUM(R.CREDIT_AMOUNT) FROM M_PARTNER_REGISTER R"
		+ " GROUP BY R.PARTNER_ID");

	// -------------------------------------------------------------------------------------------------
	// Populate temporable table M_PARTNER_REGISTER_ID
	// -------------------------------------------------------------------------------------------------

	// Delete from M_PARTNER_REGISTER_ID
	stm.execute("DELETE FROM M_PARTNER_REGISTER_ID");

	// Insert into M_PARTNER_REGISTER_ID from PARTNER_REGISTER
	stm.execute("INSERT INTO M_PARTNER_REGISTER_ID (PARTNER_ID) "
		+ "    SELECT P.PARTNER_ID FROM PARTNER_REGISTER P"
		+ "    WHERE P.ORGANIZATION_ID = " + organizationId
		+ " AND P.PERIOD_ID = " + prevPeriodId);

	// Insert into M_PARTNER_REGISTER_ID from M_PARTNER_REGISTER_SUM
	stm.execute("INSERT INTO M_PARTNER_REGISTER_ID (PARTNER_ID) "
		+ "    SELECT R.PARTNER_ID FROM M_PARTNER_REGISTER_SUM R "
		+ "    WHERE NOT (R.PARTNER_ID IN (SELECT I.PARTNER_ID FROM M_PARTNER_REGISTER_ID I))");

	stm.execute("DELETE FROM PARTNER_REGISTER WHERE "
		+ "ORGANIZATION_ID = " + organizationId + " AND "
		+ "PERIOD_ID = " + newPeriodId);

	addPartnerRegister(stm, organizationId, prevPeriodId, newPeriodId);
    }

    protected void addPartnerRegister(Statement stm, int organizationId, int prevPeriodId, int newPeriodId) throws SQLException {
	List<PartnerInfo> partnerInfoList = getPartnerRegister(stm, organizationId, prevPeriodId, newPeriodId);
	if (partnerInfoList == null || partnerInfoList.size() == 0) {
	    return;
	}
	String sql = "INSERT INTO PARTNER_REGISTER (" + " ID,"
	+ " ORGANIZATION_ID," + " PERIOD_ID," + " PARTNER_ID,"
	+ " DEBIT_AMOUNT," + " CREDIT_AMOUNT, " + " AMOUNT) "
	+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

	ResultSet rs = stm.executeQuery("SELECT MAX(ID) FROM PARTNER_REGISTER");
	rs.next();
	int id = rs.getInt(1);

	PreparedStatement ps = prepareStatement(sql);
	try {
	    for (PartnerInfo info : partnerInfoList) {
		id++;
		ps.setInt(1, id);
		ps.setInt(2, organizationId);
		ps.setInt(3, newPeriodId);
		ps.setInt(4, info.partnerId);

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

    protected List<PartnerInfo> getPartnerRegister(Statement stm, int organizationId, int prevPeriodId, int newPeriodId) throws SQLException {

	List<PartnerInfo> partnerInfoList = null;
	String sql = null;
	ResultSet rs = null;
	try {
	    if (prevPeriodId > 0) {
		sql = " SELECT "
		    + " U.PARTNER_ID,"
			+ " U1.DEBIT_AMOUNT,"
			+ " U2.DEBIT_AMOUNT,"
			+ " U1.CREDIT_AMOUNT,"
			+ " U2.CREDIT_AMOUNT"
			+ " FROM M_PARTNER_REGISTER_ID U "
			+ " LEFT JOIN PARTNER_REGISTER U1 ON U1.PARTNER_ID = U.PARTNER_ID AND U1.PERIOD_ID = "
			+ prevPeriodId
			+ " LEFT JOIN M_PARTNER_REGISTER_SUM U2 ON U2.PARTNER_ID = U.PARTNER_ID";

		rs = stm.executeQuery(sql);
		partnerInfoList = new ArrayList<PartnerInfo>();
		while (rs.next()) {
		    PartnerInfo info = new PartnerInfo();
		    info.partnerId = rs.getInt(1);

		    info.debitAmount = rs.getDouble(2) + rs.getDouble(3);
		    info.creditAmount = rs.getDouble(4) + rs.getDouble(5);

		    info.amount = info.creditAmount - info.debitAmount;

		    partnerInfoList.add(info);
		}

	    } else {

		sql = " SELECT " + " PARTNER_ID," + " DEBIT_AMOUNT,"
		+ " CREDIT_AMOUNT" + " FROM M_PARTNER_REGISTER_SUM";

		rs = stm.executeQuery(sql);
		partnerInfoList = new ArrayList<PartnerInfo>();
		while (rs.next()) {
		    PartnerInfo info = new PartnerInfo();
		    info.partnerId = rs.getInt(1);

		    info.debitAmount = rs.getDouble(2);
		    info.creditAmount = rs.getDouble(3);

		    info.amount = info.creditAmount - info.debitAmount;

		    partnerInfoList.add(info);
		}
	    }

	} finally {
	    close(rs);
	}

	return partnerInfoList;
    }

    private class PartnerInfo {

	int partnerId;

	double debitAmount;

	double creditAmount;

	double quantity;

	double amount;
    }
}
