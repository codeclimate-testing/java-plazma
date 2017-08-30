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
package org.plazmaforge.bsolution.base.common.acceptors;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.services.SystemVariableService;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.framework.core.data.Variable;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.util.DateUtils;
import org.plazmaforge.framework.util.StringUtils;


/*
 * Created 30.10.2006
 */
public class OrganizationAcceptorUtilities implements OrganizationAcceptorConstants {

	private OrganizationAcceptorUtilities() {
	super();
    }

    public static void initOrganizationParameters(Map parameters, SessionContext context) {
	OrganizationHeader organization = EnterpriseEnvironment.getOrganization(context);
	if (organization == null) {
	    // CRITICAL SITUATION
	    return;
	}
	parameters.put(ORGANIZATION_ID, organization.getId());
	parameters.put(ORGANIZATION_NAME, organization.getName());
	parameters.put(ORGANIZATION_IDN, organization.getIdn());
	parameters.put(ORGANIZATION_NEC, organization.getNec());
	
	parameters.put(ORGANIZATION_ADDRESS, organization.getFullAddressString());
	parameters.put(ORGANIZATION_PHONE, organization.getPhoneString());
	
    }

    public static void initPeriodParameters(Map parameters) {
	parameters.put(PERIOD_ID, EnterpriseEnvironment.getPeriodId());
	initPeriodParameters(parameters, EnterpriseEnvironment.getPeriodStartDate(), EnterpriseEnvironment.getPeriodEndDate());
    }

    public static void initPeriodParameters(Map parameters, Date startDate, Date endDate) {
	parameters.put(PERIOD_START_DATE, startDate);
	parameters.put(PERIOD_END_DATE, endDate);
	
	initDayPosParameter(parameters, START_DAY_POS, startDate);
	initDayPosParameter(parameters, END_DAY_POS, endDate);
	
	 initYearParameterByStartDate(parameters);
	 initQuarterParameterByStartDate(parameters);
    }

    public static void initDayPosParameter(Map parameters, String parameter,
	    Date date) {
	if (parameter == null || date == null) {
	    return;
	}
	SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
	parameters.put(parameter, Integer.valueOf(fmt.format(date)));
    }

    public static void initYearParameter(Map parameters, Integer year) {
	parameters.put(YEAR, year);
    }

    public static void initYearParameter(Map parameters, int year) {
	if (year <= 0) {
	    return;
	}
	initYearParameter(parameters, new Integer(year));
    }
    
    public static void initQuarterParameter(Map parameters, Integer quarter) {
	parameters.put(QUARTER, quarter);
    }


    public static void initYearParameterByStartDate(Map parameters) {
	Date startDate = (Date) parameters.get(PERIOD_START_DATE);
	initYearParameterByStartDate(parameters, startDate);
//	Integer year = null;
//	if (startDate != null) {
//	    Calendar calendar = Calendar.getInstance();
//	    calendar.setTime(startDate);
//	    year = calendar.get(Calendar.YEAR);
//	}
//	initYearParameter(parameters, year);
    }
    
    
    public static void initYearParameterByStartDate(Map parameters, Date startDate) {
	Integer year = null;
	if (startDate != null) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(startDate);
	    year = calendar.get(Calendar.YEAR);
	}
	initYearParameter(parameters, year);
    }
    

    public static void initQuarterParameterByStartDate(Map parameters) {
	Date startDate = (Date) parameters.get(PERIOD_START_DATE);
	Integer quarter = null;
	if (startDate != null) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(startDate);
	    int month = calendar.get(Calendar.MONTH) + 1; // Gregorian calendar
	    quarter = DateUtils.getQuarterByMonth(month);
	}
	initQuarterParameter(parameters, quarter);
    }

    
    public static void initPartnerId(Map parameters, Integer partnerId) {
	parameters.put(PARTNER_ID, partnerId);
    }

    public static void initPartnerName(Map parameters, String partnerName) {
	parameters.put(PARTNER_NAME, partnerName);
    }
    

    public static void initBankAccountId(Map parameters, Integer bankAccountId) {
	parameters.put(BANK_ACCOUNT_ID, bankAccountId);
    }

    public static void initBankAccountNo(Map parameters, String bankAccountNo) {
	parameters.put(BANK_ACCOUNT_NO, bankAccountNo);
    }
    
    
    protected static Object getService(Class serviceInterface) {
	return ServiceFactory.getService(serviceInterface);
    }
    
    public static List<Variable> getSystemVariables() {
	try {
	    SystemVariableService service = (SystemVariableService) getService(SystemVariableService.class);
	    return service.findAll();
	    
	} catch (ApplicationException ex) {
	    ex.printStackTrace();
	}
	return new ArrayList<Variable>();
    }
    
    public static List<Variable> getSystemVariablesByPrefix(List<Variable> variables, String prefix) {
	List<Variable> result = new ArrayList<Variable>();
	if (isEmpty(prefix) || isEmpty(variables)) {
	    return result;
	}
	for (Variable var : variables) {
	    if (!startsWithVaraibleCode(var, prefix)) {
		continue;
	    }
	    result.add(var);
	}
	return result;
    }
    
    public static Variable getSystemVariable(List<Variable> variables, String code) {
	if (isEmpty(code) || isEmpty(variables)) {
	    return null;
	}
	for (Variable var : variables) {
	    if (equalsVaraibleCode(var, code)) {
		return var;
	    }
	}
	return null;
    }
    
    /**
     * Return variables by codes and priority
     * @param variables
     * @param codes
     * @return
     */
    public static List<Variable> getSystemVariablesByCodes(List<Variable> variables, List<String> codes) {
	List<Variable> result = new ArrayList<Variable>();
	if (codes == null || codes.isEmpty() || isEmpty(variables)) {
	    return result;
	}
	for (String code : codes) {
	    for (Variable var : variables) {
		if (!equalsVaraibleCode(var, code)) {
		    continue;
		}
		result.add(var);
	    }
	}
	return result;
    }
    
    public static Object getSystemVariableValue(List<Variable> variables, String code) {
	Variable var = getSystemVariable(variables, code);
	return var == null ? null : var.getValue();
    }

    public static String getSystemVariableStringValue(List<Variable> variables, String code) {
	Variable var = getSystemVariable(variables, code);
	return var == null ? null : var.getStringValue();
    }

    public static Boolean getSystemVariableBooleanValue(List<Variable> variables, String code) {
	Variable var = getSystemVariable(variables, code);
	return var == null ? null : var.getBooleanValue();
    }

    public static Integer getSystemVariableIntegerValue(List<Variable> variables, String code) {
	Variable var = getSystemVariable(variables, code);
	return var == null ? null : var.getIntegerValue();
    }

    public static Float getSystemVariableFloatValue(List<Variable> variables, String code) {
	Variable var = getSystemVariable(variables, code);
	return var == null ? null : var.getFloatValue();
    }

    public static Date getSystemVariableDateValue(List<Variable> variables, String code) {
	Variable var = getSystemVariable(variables, code);
	return var == null ? null : var.getDateValue();
    }

    ////
    
    public static String getSystemVariableStringValue(List<Variable> variables, List<String> codes) {
	return getSystemVariableStringValue(variables, codes, false);
    }
	    
    /**
     * Return first non empty value
     * @param variables
     * @param codes
     * @param nonEmpty
     * @return
     */
    public static String getSystemVariableStringValue(List<Variable> variables, List<String> codes, boolean nonEmpty) {
	List<Variable> result = getSystemVariablesByCodes(variables, codes);
	if (result == null || result.isEmpty()) {
	    return null;
	}
	String value = null;
	for (Variable variable: result) {
	    value = variable.getStringValue();
	    if (value == null || (nonEmpty && isEmpty(value))) {
		continue;
	    }
	    return value;
	}
	return null;
    }
    
    ////
    
    public static boolean equalsVaraibleCode(Variable var, String code) {
	if (var == null || isEmpty(code)) {
	    return false;
	}
	return code.equals(var.getCode());
    }
    
    public static boolean startsWithVaraibleCode(Variable var, String prefix) {
	if (var == null || isEmpty(var.getCode()) || isEmpty(prefix)) {
	    return false;
	}
	return var.getCode().startsWith(prefix);
    }
    
    
    public static boolean isEmpty(List list) {
	return list == null || list.isEmpty();
    }
    
    public static boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }
    
    
  
}
