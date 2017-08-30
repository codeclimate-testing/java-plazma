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
package org.plazmaforge.bsolution.payroll.server.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.dao.AbstractSQLExecutor;


/*
 * Created 01.10.2006
 */
public class PayrollCalculateExecutor extends AbstractSQLExecutor {

    /**
     * Total data form EMPLOYEE_TOTAL table
     */
    private class TotalData {

	Integer id;

	Integer employeeId;

	double startBalance;

	double incrementAmount;

	double decrementAmount;

	double payrollAmount;

	List<PayrollData> payrollDataList = new ArrayList<PayrollData>();
    }

    /**
     * Payroll data from EMPLOYEE_PAYROLL table
     */
    private class PayrollData {

	Integer id;

	Integer payrollTypeId;

	Integer payrollId;

	int payrollDay;

	float payrollHour;

	float percent;

	double amount;
    }

    /**
     * Calculate payroll
     * @param periodId
     * @param organizationId
     * @throws SQLException
     * @throws ApplicationException
     */
    public void calculate(Integer periodId, Integer organizationId) throws SQLException {
	List<Integer> emplyeeIds = checkEmployeeTotal(periodId, organizationId);
	insertEmployeeTotal(emplyeeIds, periodId, organizationId);
	List<TotalData> results = loadTotal(periodId, organizationId);
	calculateTotal(results);
	updateTotal(results);
    }

    /**
     * Check EMPLOYEE_TOTAL table
     * @param periodId
     * @param organizationId
     * @return list of IDs (not found IDs)
     * @throws SQLException
     */
    private List<Integer> checkEmployeeTotal(Integer periodId, Integer organizationId) throws SQLException {
	Statement st = null;
	ResultSet rs = null;
	List<Integer> emplyeeIds = new ArrayList<Integer>();
	try {

	    st = createStatement();
	    rs = st.executeQuery("SELECT E.ID, T.EMPLOYEE_ID FROM EMPLOYEE E"
		    + " LEFT JOIN EMPLOYEE_TOTAL T ON E.ID = T.EMPLOYEE_ID"
		    + " WHERE T.PERIOD_ID = " + periodId.intValue()
		    + " AND E.ORGANIZATION_ID = " + organizationId.intValue());

	    while (rs.next()) {
		Integer id = new Integer(rs.getInt(1));
		new Integer(rs.getInt(2)); // only for position at column
		if (rs.wasNull()) {
		    emplyeeIds.add(id);
		}
	    }

	} finally {
	    close(rs);
	    close(st);
	}
	return emplyeeIds;
    }

    /**
     * Insert to EMPLOYEE_TOTAL rows
     * @param employeeIds
     * @param periodId
     * @param organizationId
     * @throws SQLException
     */
    private void insertEmployeeTotal(List<Integer> employeeIds, Integer periodId, Integer organizationId) throws SQLException {
	if (employeeIds == null || employeeIds.size() == 0) {
	    return;
	}
	PreparedStatement st = null;
	try {
	    st = prepareStatement("INSERT INTO EMPLOYEE_TOTAL (ID, EMPLOYEE_ID, PERIOD_ID) VALUES (?, ?, ?)");
	    st.setInt(3, periodId.intValue());

	    for (Integer employeeId : employeeIds) {
		st.setInt(1, nextValueByTable(connection, "EMPLOYEE_TOTAL", "ID"));
		st.setInt(2, employeeId);
		st.executeUpdate();
	    }
	} finally {
	    close(st);
	}
    }

    /**
     * Load total data (EMPLOYEE_TOATL and EMPLOYEE_PAYROLL)
     * @param periodId
     * @param organizationId
     * @return
     * @throws SQLException
     */
    private List<TotalData> loadTotal(Integer periodId, Integer organizationId) throws SQLException {
	Statement st = null;
	ResultSet rs = null;
	List<TotalData> results = new ArrayList<TotalData>();
	try {

	    st = createStatement();

	    rs = st.executeQuery("SELECT" + " T.ID AS EMPPLOYEE_TOTAL_ID,"
		    + " T.EMPLOYEE_ID," + " T.START_BALANCE," +

		    " P.ID AS EMPLOYEE_PAYROLL_ID," + " R.PAYROLL_TYPE_ID, "
		    + " P.PAYROLL_ID," + " P.PAYROLL_DAY," + " P.PAYROLL_HOUR,"
		    + " P.PAYROLL_PERCENT," + " P.AMOUNT" +

		    " FROM EMPLOYEE E"
		    + " INNER JOIN EMPLOYEE_TOTAL T ON E.ID = T.EMPLOYEE_ID"
		    + " INNER JOIN EMPLOYEE_PAYROLL P ON E.ID = P.EMPLOYEE_ID"
		    + " INNER JOIN PAYROLL R ON R.ID = P.PAYROLL_ID"
		    + " WHERE T.PERIOD_ID = " + periodId.intValue()
		    + " AND E.ORGANIZATION_ID = " + organizationId.intValue()
		    + " ORDER BY T.EMPLOYEE_ID, R.PRIORITY"

	    );

	    Integer id = null;
	    TotalData totalData = null;
	    PayrollData payrollData = null;
	    while (rs.next()) {
		Integer currentId = new Integer(rs.getInt(1));
		if (!currentId.equals(id)) {
		    id = currentId;
		    totalData = new TotalData();
		    results.add(totalData);
		    totalData.id = id;
		    totalData.employeeId = new Integer(rs.getInt(2));
		    totalData.startBalance = rs.getDouble(3);
		}
		payrollData = new PayrollData();
		totalData.payrollDataList.add(payrollData);

		payrollData.id = new Integer(rs.getInt(4));
		payrollData.payrollTypeId = new Integer(rs.getInt(5));
		payrollData.payrollId = new Integer(rs.getInt(6));
		payrollData.payrollDay = rs.getInt(7);
		payrollData.payrollHour = rs.getFloat(8);
		payrollData.percent = rs.getFloat(9);
		payrollData.amount = rs.getFloat(10);

	    }

	} finally {
	    close(rs);
	    close(st);
	}
	return results;

    }

    /**
     * Calculate total data
     * @param results
     */
    private void calculateTotal(List<TotalData> results) {
	if (results == null || results.isEmpty()) {
	    return;
	}
	for (TotalData totalData: results) {

	    //Reset amount
	    totalData.incrementAmount = 0;
	    totalData.decrementAmount = 0;
	    totalData.payrollAmount = 0;

	    List<PayrollData> payrollDataList = totalData.payrollDataList;
	    for (PayrollData payrollData : payrollDataList) {
		if (payrollData.payrollTypeId.intValue() == 1) {
		    totalData.incrementAmount += payrollData.amount;
		} else {
		    totalData.decrementAmount += payrollData.amount;
		}
	    }

	    // Calculate payroll
	    totalData.payrollAmount = totalData.incrementAmount - totalData.decrementAmount;

	}

    }

    /**
     * Update EMPLOYEE_TOTAL
     * @param results
     * @throws SQLException
     */
    private void updateTotal(List<TotalData> results) throws SQLException {
	if (results == null || results.isEmpty()) {
	    return;
	}
	PreparedStatement st = null;
	try {
	    st = this.prepareStatement("UPDATE EMPLOYEE_TOTAL SET "
		    + " INCREMENT_AMOUNT = ?, " + " DECREMENT_AMOUNT = ?, "
		    + " PAYROLL_AMOUNT = ? " + " WHERE ID = ?");

	    TotalData totalData = null;
	    for (int i = 0; i < results.size(); i++) {
		totalData = results.get(i);

		st.setDouble(1, totalData.incrementAmount);
		st.setDouble(2, totalData.decrementAmount);
		st.setDouble(3, totalData.payrollAmount);

		st.setInt(4, totalData.id.intValue());

		st.executeUpdate();
	    }
	} finally {
	    close(st);
	}
    }

}
