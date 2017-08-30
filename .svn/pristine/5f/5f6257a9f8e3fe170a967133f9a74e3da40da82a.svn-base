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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.base.common.acceptors.OrganizationDialogAcceptor;
import org.plazmaforge.framework.core.data.Variable;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.DateUtils;
import org.plazmaforge.framework.util.NumberUtils;
import org.plazmaforge.framework.util.StringUtils;

public class BPensionReportByYearDialogAcceptor extends OrganizationDialogAcceptor {

   public static final String TAX_AMOUNT = "TAX_AMOUNT";
    
    public static final String SALARY_AMOUNT = "SALARY_AMOUNT";
    
    public static final String PAY_AMOUNT = "PAY_AMOUNT";

    
    public static final String TAX_AMOUNT_STR = TAX_AMOUNT + "_STR";
    
    public static final String SALARY_AMOUNT_STR = SALARY_AMOUNT + "_STR";
    
    public static final String PAY_AMOUNT_STR = PAY_AMOUNT + "_STR";
    
    
    public static final String GOV_TAX_AMOUNT = "GOV_"+ TAX_AMOUNT;
    
    public static final String GOV_SALARY_AMOUNT = "GOV_"+ SALARY_AMOUNT;
    
   
    public static final String GOV_PENSION_PERCENT = "GOV_PENSION_PERCENT";
    
    public static final String GOV_PENSION_PERCENT_TAX = GOV_PENSION_PERCENT + "_TAX";
    

    public static final String GOV_TAX_AMOUNT_ARRAY = GOV_TAX_AMOUNT + "_ARRAY";
    
    public static final String GOV_SALARY_AMOUNT_ARRAY = GOV_SALARY_AMOUNT + "_ARRAY";
    
    
    public static final String GOV_PENSION_PERCENT_ARRAY = GOV_PENSION_PERCENT + "_ARRAY";
    
    public static final String GOV_PENSION_PERCENT_TAX_ARRAY = GOV_PENSION_PERCENT_TAX + "_ARRAY";

    
    public static final String REPORT_TYPE_08 = "08";
    
    public static final String REPORT_TYPE_12 = "12";
    
    
    public static final String START_WORK_DATE = "START_WORK_DATE";
    
    public static final String END_WORK_DATE = "END_WORK_DATE";
    
    public static final String DAYS = "DAYS";
    
    public static final String DAYS_STR = DAYS + "_STR";
    
    public static final String MONTHS = "MONTHS";
    
    public static final String MONTHS_STR = MONTHS + "_STR";


    public static final String FULL_MONTHS = "FULL_" + MONTHS;
    
    public static final String FULL_MONTHS_STR = FULL_MONTHS + "_STR";

    public static final String FULL_DAYS = "FULL_" + DAYS;
    
    public static final String FULL_DAYS_STR = FULL_DAYS + "_STR";
    
    
    
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
	parameters.put(GOV_PENSION_ORGANIZATION_NAME, getSystemVariableStringValue(variables, GOV_PENSION_ORGANIZATION_NAME));
	
	parameters.put(ORGANIZATION_TAX_TYPE, getSystemVariableStringValue(variables, ORGANIZATION_TAX_TYPE));
	parameters.put(ORGANIZATION_PENSION_REG_CODE, getSystemVariableStringValue(variables, ORGANIZATION_PENSION_REG_CODE));
	parameters.put(ORGANIZATION_PENSION_REG_DATE, getSystemVariableStringValue(variables, ORGANIZATION_PENSION_REG_DATE));
	
	// Person name
	readPersonName(variables, parameters);

	// Bank account (PENSION)
	parameters.put(BANK_ACCOUNTS, getBankAccounts(variables));
	
	// Document marker (PENSION)
	parameters.put(GOV_PENSION_DOCUMENT_MARKER, getSystemVariableStringValue(variables, GOV_PENSION_DOCUMENT_MARKER));
	
	// GOV values: amounts/percents 
	readGovValues(variables, parameters);
	

    }

    protected void readGovValues(List<Variable> variables, Map<String, Object> parameters) throws ApplicationException {
	
	Float govTaxAmount = getSystemVariableFloatValue(variables, GOV_TAX_AMOUNT);
	Float govPensionPercentTax = getSystemVariableFloatValue(variables, GOV_PENSION_PERCENT_TAX);
	Float govPensionPercent = getSystemVariableFloatValue(variables, GOV_PENSION_PERCENT);
	
	float[] govTaxAmountArray = createArray(govTaxAmount, 12);
	float[] govPensionPercentTaxArray = createArray(govPensionPercentTax, 12);
	float[] govPensionPercentArray = createArray(govPensionPercent, 12);
	
	parameters.put(GOV_TAX_AMOUNT_ARRAY, govTaxAmountArray);
	parameters.put(GOV_PENSION_PERCENT_TAX_ARRAY, govPensionPercentTaxArray);
	parameters.put(GOV_PENSION_PERCENT_ARRAY, govPensionPercentArray);
	 
	Integer year = (Integer) parameters.get(YEAR);
	if (year == null) {
	    return;
	}
	
	populateArrayByVariables(govTaxAmountArray, year, variables, GOV_TAX_AMOUNT, 12);
	populateArrayByVariables(govPensionPercentTaxArray, year, variables, GOV_PENSION_PERCENT_TAX, 12);
	populateArrayByVariables(govPensionPercentArray, year, variables, GOV_PENSION_PERCENT, 12);
	
    }
    
    protected float[] createArray(Float value, int size) {
	float[] array = new float[size];
	for (int i = 0; i < size; i++) {
	    if (value == null) {
		continue;
	    }
	    array[i] = value;
	}
	return array;
    }
    
    protected void populateArrayByVariables(float[] array, Integer year, List<Variable> variables, String baseVariable, int size) {
	if (array == null || year == null || baseVariable == null) {
	    return;
	}
	String variablePrefix = baseVariable + "_YM_" + year + "_";
	String variableName = null;
	int m = 0;
	Float value = null;
	for (int i = 0; i < size; i++) {
	    m = i + 1;
	    variableName = variablePrefix + m;
	    value = getSystemVariableFloatValue(variables, variableName);
	    if (value == null) {
		continue;
	    }
	    array[i] = value;
	}
    }
    
    protected float getValue(float[] array, int index) {
	if (array == null || array.length == 0 || index < 0 || index >= array.length) {
	    return 0;
	}
	return array[index];
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
	
	//p = getSystemVariableStringValue(variables, PERSON_NAME + "_R");
	//if (!isEmpty(p)) {
	//    personName = p;
	//}
	//if (isEmpty(personName)) {
	//    return;
	//}
	
	parameters.put(PERSON_NAME, personName);
	
	
	String[] words = StringUtils.getWords(personName);
	if (words == null || words.length == 0) {
	    return;
	}
	parameters.put(LAST_NAME, words[0]);
	if (words.length > 1) {
	    parameters.put(FIRST_NAME, words[1]);
	}
	if (words.length > 2) {
	    parameters.put(MIDDLE_NAME, words[2]);
	}
	
	

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
	List<Variable> accountVariables = getSystemVariablesByPrefix(variables, GOV_PENSION_BANK_ACCOUNT_ID);
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
	
	String reportType = (String) parameters.get(REPORT_TYPE);
	if (!isDataReportType(reportType)) {
	    return;
	}
	
	Integer year = (Integer) parameters.get(YEAR);
	Integer[] bankAccounts = (Integer[]) parameters.get(BANK_ACCOUNTS);
	String accountsLine = getStringLine(bankAccounts);
	String marker = (String) parameters.get(GOV_PENSION_DOCUMENT_MARKER);
	
	if (REPORT_TYPE_08.equals(reportType)) {

	    // Report type = 08
	    loadStaticData(year, parameters);
	    
	} else if (REPORT_TYPE_12.equals(reportType)) {
	    
	    // Report type = 12
	    // Load real payment (additional)
	    loadPaymentData(year, accountsLine, marker, parameters);
	}
	
	
    }
    
    protected boolean isDataReportType(String reportType) {
	if (reportType == null) {
	    return false;
	}
	return (REPORT_TYPE_08.equals(reportType) || REPORT_TYPE_12.equals(reportType));
    }
    
    protected void loadStaticData(Integer year, Map parameters) throws ApplicationException {
	float[] govTaxAmountArray = (float[]) parameters.get(GOV_TAX_AMOUNT_ARRAY);
	float[] govPensionPercentTaxArray = (float[]) parameters.get(GOV_PENSION_PERCENT_TAX_ARRAY);
	float[] govPensionPercentArray = (float[]) parameters.get(GOV_PENSION_PERCENT_ARRAY);
	
	int month = 0;

	
	float govTaxAmount = 0;
	float govPensionPercentTaxAmount = 0;
	float govPensionPercentAmount = 0;
	
	float taxAmount = 0;
	float salaryAmount = 0;
	float payAmount = 0;
	
	float totalTaxAmount = 0;
	float totalSalaryAmount = 0;
	float totalPayAmount = 0;


	Long[] days = loadDays(year, parameters);
	
	for (int i = 0; i < 12; i++) {
	    month = i + 1;
	    
	    // Amount only for days != 0
	    if (days[i] == null || days[i].intValue() == 0) {
		continue;
	    }
	    
	    govTaxAmount = getValue(govTaxAmountArray, i);
	    govPensionPercentTaxAmount = getValue(govPensionPercentTaxArray, i);
	    govPensionPercentAmount = getValue(govPensionPercentArray, i);
	    
	    taxAmount = govTaxAmount;
	    payAmount = NumberUtils.round(taxAmount * govPensionPercentTaxAmount / 100, 2);
	    salaryAmount = govPensionPercentAmount == 0 ? 0 : NumberUtils.round(payAmount * 100 / govPensionPercentAmount, 2);
	    
	    totalTaxAmount += taxAmount;
	    totalSalaryAmount += salaryAmount;
	    totalPayAmount += payAmount;
	    
	    
	    parameters.put(TAX_AMOUNT_STR + "_" + month, formatCurrency(taxAmount, 8));
	    parameters.put(SALARY_AMOUNT_STR + "_" + month, formatCurrency(salaryAmount, 8));
	    parameters.put(PAY_AMOUNT_STR + "_" + month, formatCurrency(payAmount, 8));
	    
	    
	    
	}
	
	parameters.put(TAX_AMOUNT, new BigDecimal(totalTaxAmount));
	parameters.put(SALARY_AMOUNT, new BigDecimal(totalSalaryAmount));
	parameters.put(PAY_AMOUNT, new BigDecimal(totalPayAmount));

	parameters.put(TAX_AMOUNT_STR, formatCurrency(totalTaxAmount, 8));
	parameters.put(SALARY_AMOUNT_STR, formatCurrency(totalSalaryAmount, 8));
	parameters.put(PAY_AMOUNT_STR, formatCurrency(totalPayAmount, 8));
	
	//loadDays(year, parameters);
    }
    
    protected Long[] loadDays(Integer year, Map parameters) throws ApplicationException {
	Long[] daysArray = new Long[12];
	if (year == null) {
	    return daysArray;
	}
	Date startWorkDate = DateUtils.getTruncDate((Date) parameters.get(START_WORK_DATE)); 
	Date endWorkDate = DateUtils.getTruncDate((Date) parameters.get(END_WORK_DATE));
	if (startWorkDate == null || endWorkDate == null) {
	    return daysArray;
	}
	long daysOfMonth = 0; 
	long days = 0;
	long totalDays = 0;
	int fullMonths = 0;
	int fullDays = 0;
	
	for (int month = 1; month <= 12; month++) {
    	    Date d1 = DateUtils.getFirstDateOfMonth(year, month);
	    Date d2 = DateUtils.getLastDateOfMonth(year, month);
	    daysOfMonth = DateUtils.getDaysBetween(d1, d2) + 1;
	    d1 = DateUtils.max(d1, startWorkDate);
	    d2 = DateUtils.min(d2, endWorkDate);
	    days = d1.getTime() <= d2.getTime() ? DateUtils.getDaysBetween(d1, d2) : -1;
	    if (days >= 0) {
		days++;
		totalDays += days;
		if (daysOfMonth == days) {
		    fullMonths++;
		} else {
		    fullDays += days;
		}
		daysArray[month - 1] = days;
		parameters.put(DAYS_STR + "_" + month, formatInteger(days, 3));
	    }
	    
	}
	
	if (totalDays > 0) {
	    parameters.put(DAYS_STR , formatInteger(totalDays, 3));
	}

	if (fullMonths > 0) {
	    parameters.put(FULL_MONTHS_STR , formatInteger(fullMonths, 2));
	}
	if (fullDays > 0) {
	    parameters.put(FULL_DAYS_STR , formatInteger(fullDays, 2));
	}

	return daysArray;
    }
    
    
    protected void loadPaymentData(Integer year, String accountsLine, String marker, Map parameters) throws ApplicationException {
	if (year == null) {
	    return;
	}
	
	//ReportEngine reportEngine = getReportEngine(parameters);
	//if (reportEngine == null) {
	//    return;
	//}
	
	int selectMode = (accountsLine != null && accountsLine.trim().length() > 0) ? SELECT_BANK_ACCOUNT_MODE : SELECT_MARKER_MODE;
	List<Object[]> paymentRows = getPensionDocumentRows(selectMode, "PAYMENT_OUTCOME", year, accountsLine, parameters);
	List<Object[]> cashRows = getPensionDocumentRows(SELECT_MARKER_MODE, "CASH_OUTCOME", year, accountsLine, parameters);
	List<Object[]> rows = new ArrayList<Object[]>();
	
	int markedColumnIndex = 3;
	int missingColumnIndex = 4;
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
	int rowCount = rows == null ? 0 : rows.size();
	
	//if (rowCount == 0) {
	//    return;
	//}
	
	Object[] row = null;
	
	
	double salaryAmount = 0;
	double payAmount = 0;
	
	double totalPayAmount = 0;
	double totalSalaryAmount = 0;
	
	String missing = null;
	//Integer payYear = null;
	//Integer payMonth = null;

	Date documentDate = null;
	for (int i = 0; i < rowCount; i++) {
	    
	    row = rows.get(i);
	    documentDate = (Date) row[1];
	    payAmount = row[2] == null ? 0 : ((Number) row[2]).doubleValue();
	    missing = (String) row[missingColumnIndex];
	    if (payAmount == 0 || missing == null) {
		continue;
	    }
	    
	    
	    ////////////////////////////////////////////////////////////////
	    /*
	    Integer[] array = parseYearAndMonth(missing);
	    payYear = array[0];
	    payMonth = array[1];
	    if (payYear == null || payMonth == null || !year.equals(payYear)) {
		continue;
	    }
	    String key = PAY_AMOUNT + "_" + payMonth;
	    String key2 = PAY_AMOUNT_STR + "_" + payMonth;
	    BigDecimal value = (BigDecimal) parameters.get(key);
	    if (value == null) {
		value = new BigDecimal(payAmount);
	    } else {
		value = new BigDecimal(value.doubleValue() + payAmount);
	    }
	    parameters.put(key, value);
	    parameters.put(key2, formatCurrency(value.doubleValue(), 8));
	    totalPayAmount += payAmount;
	    */
	    /////////////////////////////////////////////////////////////////
	    
	    List<PaymentInfo> paymentList = parsePayment(missing);
	    
	    if (isEmpty(paymentList)) {
		if (documentDate == null || year.intValue() != DateUtils.getYear(documentDate)) {
		    continue;
		}
		int month = DateUtils.getMonth(documentDate);
		////
		putPaymentAmount(parameters, month, payAmount);
		totalPayAmount += payAmount;
		////
		continue;
	    }
	    
	    
	    int size = paymentList.size();
	    for (PaymentInfo p : paymentList) {
		if (p.year == null || p.month == null || !year.equals(p.year) || p.month.intValue() < 1 || p.month.intValue() > 12) {
		    continue;
		}
		
		double amount = p.amount == null ? 0 : p.amount.doubleValue();
		
		////
		if (amount == 0) {
		    if (size == 1) {
			amount = payAmount;
		    } else {
			continue;
		    }
		}
		////
		
		////
		putPaymentAmount(parameters, p.month, amount);
		totalPayAmount += amount;
		////

	    }
	    
	}
	
	if (rowCount > 0) {
	    float[] govPensionPercentArray = (float[]) parameters.get(GOV_PENSION_PERCENT_ARRAY);
	    float govPensionPercentAmount = 0;
	    int month = 0;
	    for (int i = 0; i < 12; i++) {
		month = i + 1;
		govPensionPercentAmount = getValue(govPensionPercentArray, i);
		String key = PAY_AMOUNT + "_" + month;
		BigDecimal value = (BigDecimal) parameters.get(key);
		if (value == null) {
		    continue;
		}
		payAmount = value.doubleValue();
		if (payAmount == 0) {
		    continue;
		}
		salaryAmount = govPensionPercentAmount == 0 ? 0 : NumberUtils.round(payAmount * 100 / govPensionPercentAmount, 2);
		if (salaryAmount > 0) {
		    parameters.put(SALARY_AMOUNT_STR + "_" + month, formatCurrency(salaryAmount, 8));
		    totalSalaryAmount += salaryAmount;
		}
	    }
	}
	
	if (totalPayAmount > 0) {
	    parameters.put(PAY_AMOUNT, new BigDecimal(totalPayAmount));
	    parameters.put(PAY_AMOUNT_STR, formatCurrency(totalPayAmount, 8));
	}
	
	if (totalSalaryAmount > 0) {
	    parameters.put(SALARY_AMOUNT, new BigDecimal(totalSalaryAmount));
	    parameters.put(SALARY_AMOUNT_STR, formatCurrency(totalSalaryAmount, 8));
	}
	
	loadDays(year, parameters);
    }
    
    protected void putPaymentAmount(Map parameters, int month, double amount) {
	String key = PAY_AMOUNT + "_" + month;
	String key2 = PAY_AMOUNT_STR + "_" + month;
	BigDecimal value = (BigDecimal) parameters.get(key);
	if (value == null) {
	    value = new BigDecimal(amount);
	} else {
	    value = new BigDecimal(value.doubleValue() + amount);
	}
	parameters.put(key, value);
	parameters.put(key2, formatCurrency(value.doubleValue(), 8));
    }
    
    
    
    class PaymentInfo {
	
	Integer year;
	
	Integer month;
	
	Double amount;
    }
    
    protected String formatCurrency(double value, int len) {
	if (value == 0) {
	    return null;
	}
	String str =  getCurrencyFormat().format(value);
	int l = str.length();
	if (len > 0 && len != l) {
	    return (l > len) ? StringUtils.replicate("*", len) : StringUtils.lpad(str,len, " "); 
	}
	return str;
    }
    
    protected String formatCurrency(Double value, int len) {
	if (value == null) {
	    return null;
	}
	return formatCurrency(value.doubleValue(), len);
    }
    
    private DecimalFormat currencyFormat;
    
    protected  DecimalFormat getCurrencyFormat() {
	if (currencyFormat == null) {
	    currencyFormat = new DecimalFormat("###0.00"); 
	}
	return currencyFormat;
    }
    
    protected String formatInteger(long value, int len) {
	if (value == 0) {
	    return null;
	}
	String str =  "" + value;
	int l = str.length();
	if (len > 0 && len != l) {
	    return (l > len) ? StringUtils.replicate("*", len) : StringUtils.lpad(str,len, " "); 
	}
	return str;
    }
    

    
    protected List<PaymentInfo> parsePayment(String str) {
	if (isEmpty(str)) {
	    return null;
	}
	String[] array = str.trim().split(" ");
	if (isEmptyArray(array)) {
	    return null;
	}
	List<PaymentInfo> list = new ArrayList<PaymentInfo>(); 
	for (String paymentInfoStr : array) {
	    String[] dateAndAmount = paymentInfoStr.split(";"); // 2010-01;120.20
	    if (isEmptyArray(dateAndAmount)) {
		continue;
	    }
	    Integer[] yearAndMonth = parseYearAndMonth(dateAndAmount[0]);
	    if (yearAndMonth == null || yearAndMonth.length < 2) {
		continue;
	    }
	    Integer year = yearAndMonth[0];
	    Integer month = yearAndMonth[1];
	    if (year == null || month == null) {
		continue;
	    }
	    PaymentInfo p = new PaymentInfo();
	    p.year = year;
	    p.month = month;
	    list.add(p);
	    if (dateAndAmount.length < 2) {
		continue;
	    }
	    p.amount = parseAmount(dateAndAmount[1]);
	}
	return list;
    }
    
    protected Integer[] parseYearAndMonth(String str) {
	if (isEmpty(str)) {
	    return new Integer[2];
	}
	Integer[] yearAndMonth = new Integer[2];
	String[] array = str.trim().split("-");
	if (array == null || array.length < 2) {
	    return yearAndMonth;
	}
	yearAndMonth[0] = parseInteger(array[0]);
	yearAndMonth[1] = parseInteger(array[1]);
	return yearAndMonth;
    }
    
    protected Double parseAmount(String str) {
	if (isEmpty(str)) {
	    return null;
	}
	try {
	    return Double.valueOf(str);
	} catch (NumberFormatException ex) {
	    return null;
	}
    }

    protected boolean isEmptyArray(String[] array) {
	return array == null || array.length == 0;
    }
    
    protected Integer parseInteger(String str) {
	try {
	    return Integer.valueOf(str);
	} catch (NumberFormatException ex) {
	    return null;
	}
    }
    
    protected Integer[] getMonthByQuarter(Integer quarter) {
	if (quarter == null || quarter < 1 || quarter > 4) {
	    return null;
	}
	Integer[] month = new Integer[3];
	DateUtils.populateMonthListByQuarter(quarter, month);
	
	return month;
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

    protected List<Object[]> getPensionDocumentRows(int mode, String table, Integer year, String accountsLine, Map parameters) throws ApplicationException {
	
	if (mode < SELECT_BANK_ACCOUNT_MODE || mode > SELECT_MARKER_MODE) {
	    return null;
	}
	if (year == null) {
	    return null;
	}
	if (mode == SELECT_BANK_ACCOUNT_MODE && accountsLine == null) {
	    return null;
	}
	
	
	//TEST:
	/*
	List<Object[]> list = new ArrayList<Object[]>();
	int m = 0;
	Object[] array = new Object[12];
	for (int i= 0 ;  i < 12; i++) {
	    m = i +1;
	    array = new Object[4];
	    array[2] = 100 + m;
	    array[3] = "2010-" + m;
	    list.add(array);
	}
	return list;
	*/
	
	
	Integer nextYear = year + 1;
	String sql = "SELECT D.DOCUMENT_NO, D.DOCUMENT_DATE, F.TOTAL_WITH_TAX, P.PAYMENT_MISSING, O.NOTE"
		  + " FROM V_DOCUMENT D"
		  + " INNER JOIN DOCUMENT O ON O.ID = D.ID"
		  + " INNER JOIN FINANCE_DOCUMENT F ON F.ID = D.ID"
		  + " INNER JOIN "  + table + " P ON P.ID = D.ID"
		  + " WHERE (D.DOCUMENT_YEAR = " + year + " OR D.DOCUMENT_YEAR = " + nextYear + ") " 
		  + (mode == SELECT_BANK_ACCOUNT_MODE ? "AND P.PARTNER_BANK_ACCOUNT_ID IN (" + accountsLine + ")" : "")
		  + " ORDER BY D.DOCUMENT_DATE";
	 return getSQLResult(sql, parameters);
	 
    }
    
    
}
