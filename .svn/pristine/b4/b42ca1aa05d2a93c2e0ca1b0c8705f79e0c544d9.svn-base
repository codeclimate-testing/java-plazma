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

package org.plazmaforge.bsolution.finance.common.acceptors;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.base.common.acceptors.OrganizationDialogAcceptor;
import org.plazmaforge.framework.core.data.Variable;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.ReportEngine;
import org.plazmaforge.framework.util.DateUtils;
import org.plazmaforge.framework.util.StringUtils;

public class BTaxReportByQuarterDialogAcceptor extends OrganizationDialogAcceptor {

    public Map<String, Object> readParameters() throws ApplicationException {
	Map<String, Object> parameters = super.readParameters();
	
	
	readIDNParameters(parameters);
	
	readSystemVariables(parameters);
	return parameters;
    }
    
    protected void readSystemVariables(Map<String, Object> parameters) throws ApplicationException {
	List<Variable> variables = getSystemVariables();
	if (variables == null || variables.isEmpty()) {
	    return;
	}

	// Tax organization
	parameters.put(GOV_TAX_ORGANIZATION_NAME, getSystemVariableStringValue(variables, GOV_TAX_ORGANIZATION_NAME));
	
	// Person name
	readPersonName(variables, parameters);
	
	// Organization activity
	readOrganizationActivity(variables, parameters);
	
	// Employee count
	readEmployeeCount(variables, parameters);
	
	// Bank account (TAX)
	parameters.put(BANK_ACCOUNTS, getBankAccounts(variables));
	
	// Document marker (TAX)
	parameters.put(GOV_TAX_DOCUMENT_MARKER, getSystemVariableStringValue(variables, GOV_TAX_DOCUMENT_MARKER));
	

    }

    
    
    protected void readPersonName(List<Variable> variables, Map<String, Object> parameters) throws ApplicationException {
	String personName = (String) parameters.get(ORGANIZATION_NAME);
	if (!isEmpty(personName)) {
	    
	    // Split: use only last 3 words (last name, first name, middle name)
	    personName = StringUtils.getLastWords(personName, 3);
	}

	String p = getSystemVariableStringValue(variables, PERSON_NAME);
	if (!isEmpty(p)) {
	    personName = p;
	}
	p = getSystemVariableStringValue(variables, PERSON_NAME + "_R");
	if (!isEmpty(p)) {
	    personName = p;
	}
	if (isEmpty(personName)) {
	    return;
	}
	
	parameters.put(PERSON_NAME, personName);
	String[] lines = StringUtils.getTwoLines(personName, 14);
	parameters.put(PERSON_NAME + "_1", lines[0]);
	parameters.put(PERSON_NAME + "_2", lines[1]);

    }
    
    protected void readOrganizationActivity(List<Variable> variables, Map<String, Object> parameters) throws ApplicationException {
	String organizationActivity = getOrganizationActivity(variables, parameters);
	if (isEmpty(organizationActivity)) {
	    return;
	}
	parameters.put(ORGANIZATION_ACTIVITY, organizationActivity);
	
	String[] lines = StringUtils.getTwoLines(organizationActivity, 90);
	parameters.put(ORGANIZATION_ACTIVITY + "_1", lines[0]);
	parameters.put(ORGANIZATION_ACTIVITY + "_2", lines[1]);
    }
    
    protected String getOrganizationActivity(List<Variable> variables, Map<String, Object> parameters) {
	

	// Activity variables by priority
	List<String> activityVars = new ArrayList<String>();
	
	// Get current YEAR
	Integer year = (Integer) parameters.get(YEAR);
	
	// Get current QUARTER
	Integer quarter = (Integer) parameters.get(QUARTER);
	
	if (year != null && quarter != null) {
	    // Variable by current YEAR and QUARTER - 1 priority
	    activityVars.add(ORGANIZATION_ACTIVITY + "_YQ_" + year + "_" + quarter);
	}
	if (year != null) {
	 // Variable by current YEAR - 2 priority
	    activityVars.add(ORGANIZATION_ACTIVITY + "_Y_" + year);
	}
	
	// Base variable - 3 priority
	activityVars.add(ORGANIZATION_ACTIVITY);
	
	return getSystemVariableStringValue(variables, activityVars, true);
    }
    
  
    
    protected void readEmployeeCount(List<Variable> variables, Map<String, Object> parameters) throws ApplicationException {
	
	// Get general EMPLOYEE_COUNT
	Integer employeeCount = getSystemVariableIntegerValue(variables, EMPLOYEE_COUNT);
	String prefix = EMPLOYEE_COUNT + "_";
	
	// Get current YEAR
	Integer year = (Integer) parameters.get(YEAR);
	if (year == null) {
	    putEmployeeCount(parameters, prefix, employeeCount);
	    return;
	}
	
	// Get EMPLOYEE_COUNT by YEAR
	Integer employeeCountYear = getSystemVariableIntegerValue(variables, EMPLOYEE_COUNT + "_Y_" + year);
	if (employeeCountYear != null) {
	    employeeCount = employeeCountYear; 
	}
	
	// Get current QUARTER
	Integer quarter = (Integer) parameters.get(QUARTER);
	
	// Get months by current QUARTER
	Integer[] month = getMonthListByQuarter(quarter);
	
	if (month == null || month.length == 0) {
	    putEmployeeCount(parameters, prefix, employeeCount);
	    return;
	}
	
	Integer employeeCountMonth_1 = getSystemVariableIntegerValue(variables, EMPLOYEE_COUNT + "_YM_" + year + "_" + month[0]);
	Integer employeeCountMonth_2 = getSystemVariableIntegerValue(variables, EMPLOYEE_COUNT + "_YM_" + year + "_" + month[1]);
	Integer employeeCountMonth_3 = getSystemVariableIntegerValue(variables, EMPLOYEE_COUNT + "_YM_" + year + "_" + month[2]);
	
	putEmployeeCount(parameters, prefix, employeeCount, employeeCountMonth_1, employeeCountMonth_2, employeeCountMonth_3);
	
    }
    
    protected void putEmployeeCount(Map<String, Object> parameters, String prefix, Integer employeeCount) {
	 parameters.put(prefix + "1", employeeCount);
	 parameters.put(prefix + "2", employeeCount);
	 parameters.put(prefix + "3", employeeCount);
    }
    
    protected void putEmployeeCount(Map<String, Object> parameters, String prefix, Integer employeeCount,
	    Integer employeeCountMonth_1, Integer employeeCountMonth_2, Integer employeeCountMonth_3) {
	
	parameters.put(prefix + "1", employeeCountMonth_1 == null ? employeeCount : employeeCountMonth_1);
	parameters.put(prefix + "2", employeeCountMonth_2 == null ? employeeCount : employeeCountMonth_2);
	parameters.put(prefix + "3", employeeCountMonth_3 == null ? employeeCount : employeeCountMonth_3);
	
    }
    
    protected void readIDNParameters(Map<String, Object> parameters) {
	String idn = (String) parameters.get(ORGANIZATION_IDN);
	if (isEmpty(idn)) {
	    return;
	}
	idn = idn.trim();
	parameters.put(ORGANIZATION_IDN, idn);
	parameters.put(IDN, idn);
    }
    
    protected Integer[] getBankAccounts(List<Variable> variables) {
	if (variables == null) {
	    return null;
	}
	List<Variable> accountVariables = getSystemVariablesByPrefix(variables, GOV_TAX_BANK_ACCOUNT_ID);
	if (accountVariables == null || accountVariables.isEmpty()) {
	    return null;
	}
	List<Integer> accounts = new ArrayList<Integer>(); 
	Integer accountId = null;
	for (Variable var: accountVariables) {
	    accountId = var.getIntegerValue();
	    if (accountId == null) {
		continue;
	    }
	    accounts.add(accountId);
	}
	if (accounts.isEmpty()) {
	    return null;
	}
	return (Integer[]) accounts.toArray(new Integer[0]);
    }
    
    
    public void prepareData(Map parameters) throws ApplicationException {
	
	Integer year = (Integer) parameters.get(YEAR);
	Integer quarter = (Integer) parameters.get(QUARTER);
	Integer[] months = getMonthListByQuarter(quarter);
	Integer[] progressMonths = getProgressMonthListByQuarter(quarter);
	Integer[] bankAccounts = (Integer[]) parameters.get(BANK_ACCOUNTS);
	String marker = (String) parameters.get(GOV_TAX_DOCUMENT_MARKER);
	
	String monthLine = getStringLine(months);
	String progressMonthLine = getStringLine(progressMonths);
	String accountLine = getStringLine(bankAccounts);
	
	parameters.put("SUBREPORT_DATA_SOURCE", createSubreportDataSource(year, monthLine, accountLine, marker, parameters));
	
	// BANK INCOME AMOUNT
	double paymentIncomeAmount = getPaymentIncomeAmount(year, progressMonthLine, parameters);
	
	// CASH INCOME AMOUNT
	double cashIncomeAmount = getCashIncomeAmount(year, progressMonthLine, parameters);
	
	// TOTAL INCOME AMOUNT
	double incomeAmount = paymentIncomeAmount + cashIncomeAmount;  
	parameters.put("SALE_AMOUNT", new BigDecimal(incomeAmount));
    }
    
    protected Integer[] getMonthListByQuarter(Integer quarter) {
	if (quarter == null || quarter < 1 || quarter > 4) {
	    return null;
	}
	Integer[] month = new Integer[3];
	DateUtils.populateMonthListByQuarter(quarter, month);
	
	return month;
    }

    protected Integer[] getProgressMonthListByQuarter(Integer quarter) {
	if (quarter == null || quarter < 1 || quarter > 4) {
	    return null;
	}
	Integer[] month = null;
	if (quarter == 1) {
	    month = new Integer[3];
	    DateUtils.populateMonthListByQuarter(quarter, month);
	    return month;
	}
	
	List<Integer> list = new ArrayList<Integer>(); 
	for (int q = 1; q <= quarter; q++) {
	    month = new Integer[3];
	    DateUtils.populateMonthListByQuarter(q, month);
	    list.add(month[0]);
	    list.add(month[1]);
	    list.add(month[2]);
	}
	
	return list.toArray(new Integer[0]);
    }

    
    protected Object createSubreportDataSource(Integer year, String monthLine, String accountsLine, String marker, Map parameters) throws ApplicationException {
	
	ReportEngine reportEngine = getReportEngine(parameters);
	if (reportEngine == null) {
	    return null;
	}
	int selectMode = (accountsLine != null && accountsLine.trim().length() > 0) ? SELECT_BANK_ACCOUNT_MODE : SELECT_MARKER_MODE;
	List<Object[]> paymentRows = getTaxDocumentRows(selectMode, "PAYMENT_OUTCOME", year, monthLine, accountsLine, parameters);
	List<Object[]> cashRows = getTaxDocumentRows(SELECT_MARKER_MODE, "CASH_OUTCOME", year, monthLine, null, parameters);
	List<Object[]> rows = new ArrayList<Object[]>();
	int rowCount = 0;
	Object[] row = null;
	int markedColumnIndex = 3;
	if (paymentRows != null && !paymentRows.isEmpty()) {
	    if (selectMode == SELECT_BANK_ACCOUNT_MODE) {
		rows.addAll(paymentRows);
	    } else {
		addDocumentsWithMarker(rows, paymentRows, marker, markedColumnIndex);
	    }
	    
	}
	if (cashRows != null && !cashRows.isEmpty()) {
	    addDocumentsWithMarker(rows, cashRows, marker, markedColumnIndex);
	}
	
	int MIN_ROW_COUNT = 3;
	rowCount = rows == null ? 0 : rows.size();
	
	String DOCUMENT_NO = "DOCUMENT_NO";
	String DOCUMENT_DATE = "DOCUMENT_DATE";
	String DOCUMENT_TYPE = "DOCUMENT_TYPE";
	String DOCUMENT_LINE = "DOCUMENT_LINE";
	Map<String, Object> array = null;
	
	List<Map> data = new ArrayList<Map>();
	double taxAmount = 0;
	
	for (int i = 0; i < rowCount; i++) {
	    
	    row = rows.get(i);
	    array = new HashMap<String, Object>();
	    
	    array.put(DOCUMENT_NO, row[0]);
	    array.put(DOCUMENT_DATE, row[1]);
	    if (row[2] != null) {
		taxAmount += ((Number) row[2]).doubleValue();
	    }
	    // row[3] ignore
	    array.put(DOCUMENT_TYPE, row[4]);
	    data.add(array);
	}
	
	if (rowCount < MIN_ROW_COUNT) {
	    for (int i = rowCount; i < MIN_ROW_COUNT; i++) {
		array = new HashMap<String, Object>();
		array.put(DOCUMENT_LINE, "");
		data.add(array);
	    }
	}
	
	parameters.put("TAX_AMOUNT", new BigDecimal(taxAmount));
	
	Object[] mapArray = data.toArray(new Object[0]);
	
	return reportEngine.createDataSourceByMapArray(mapArray);
	
    }
    
    
    
    protected String getStringLine(Integer[] elements) {
	if (elements == null || elements.length == 0) {
	    return null;
	}
	int k = 0;
	StringBuffer buf = null;
	Integer element = null;
	for (int i = 0; i < elements.length; i++) {
	    element = elements[i]; 
	    if (element == null) {
		continue;
	    }
	    k++;
	    if (buf == null) {
		buf = new StringBuffer();
	    }
	    if (k > 1) {
		buf.append(", ");
	    }
	    buf.append(element);
	}
	return buf == null ? null : buf.toString();
    }

    protected List<Object[]> getTaxDocumentRows(int mode, String table, Integer year, String monthLine, String accountsLine, Map parameters) throws ApplicationException {
	
	if (mode < SELECT_BANK_ACCOUNT_MODE || mode > SELECT_MARKER_MODE) {
	    return null;
	}
	if (year == null || monthLine == null) {
	    return null;
	}
	if (mode == SELECT_BANK_ACCOUNT_MODE && accountsLine == null) {
	    return null;
	}

	
	String sql = "SELECT D.DOCUMENT_NO, D.DOCUMENT_DATE, F.TOTAL_WITH_TAX, P.PAYMENT_MISSING, '" + table + "'"
		  + " FROM V_DOCUMENT D"
		  + " INNER JOIN FINANCE_DOCUMENT F ON F.ID = D.ID"
		  + " INNER JOIN "  + table + " P ON P.ID = D.ID"
		  + " WHERE D.DOCUMENT_YEAR = " + year + " AND D.DOCUMENT_MONTH IN (" + monthLine + ") " 
		  + (mode == SELECT_BANK_ACCOUNT_MODE ? "AND P.PARTNER_BANK_ACCOUNT_ID IN (" + accountsLine + ")" : "")
		  + " ORDER BY D.DOCUMENT_DATE";
	 return getSQLResult(sql, parameters);
    }
    
    
    protected double getPaymentIncomeAmount(Integer year, String monthLine, Map parameters) throws ApplicationException {
	return getAmount("PAYMENT_INCOME", year, monthLine, parameters);
    }
    
    protected double getCashIncomeAmount(Integer year, String monthLine, Map parameters) throws ApplicationException {
	return getAmount("CASH_INCOME", year, monthLine, parameters);
    }
    
    /**
     * Return total amount of finance documents by year and months
     * @param table
     * @param year
     * @param monthLine
     * @param parameters
     * @return
     * @throws ApplicationException
     */
    protected double getAmount(String table, Integer year, String monthLine, Map parameters) throws ApplicationException {
	if (table == null || year == null || monthLine == null) {
	    return 0.0;
	}
	
	String sql = "SELECT SUM(F.TOTAL_WITH_TAX)"
		  + " FROM V_DOCUMENT D"
		  + " INNER JOIN FINANCE_DOCUMENT F ON F.ID = D.ID"
		  + " INNER JOIN "  + table + " P ON P.ID = D.ID"
		  + " WHERE D.DOCUMENT_YEAR = " + year + " AND D.DOCUMENT_MONTH IN (" + monthLine + ")";
	 Object value =  getSQLValue(sql, parameters);
	 return value == null ? 0.0 : ((Number) value).doubleValue();
    }
    
}
