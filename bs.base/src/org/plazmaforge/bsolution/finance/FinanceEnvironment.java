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
 * Created on 06.03.2005
 *
 */
package org.plazmaforge.bsolution.finance;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.document.DocumentEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocumentType;
import org.plazmaforge.bsolution.finance.common.beans.ICurrencyHolder;
import org.plazmaforge.bsolution.finance.common.services.FinanceDocumentTypeService;
import org.plazmaforge.framework.config.ConfigUtils;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.config.EntityManager;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.platform.Environment;


/**
 * @author hapon
 * 
 */
public class FinanceEnvironment extends Environment {

    private static final double DEFAULT_CURRENCY_RATE = 1d;
    
    protected final static Logger logger = Logger.getLogger(FinanceEnvironment.class);    

    private FinanceEnvironment() {

    }

    private static Map<String, FinanceDocumentType> financeDocumentTypeMap = new HashMap<String, FinanceDocumentType>();

    private static Map<String, FinanceDocumentType> classFinanceDocumentTypeMap = new HashMap<String, FinanceDocumentType>();

    public static void addFinanceDocumenType(FinanceDocumentType type) {
	financeDocumentTypeMap.put(EntityManager.getEntityId(type.getDocumentType()), type);
    }

    public static boolean isCalculateAccountEntry() {
	return EnterpriseEnvironment.isCalculateAccounting();
    }
    
    
    public static void addFinanceDocumentTypes(List<FinanceDocumentType> types) {
	if (types == null) {
	    return;
	}
	for (FinanceDocumentType type : types) {
	    addFinanceDocumenType(type);
	}
    }

    public static boolean isBothTaxAmount(Class klass) {
	FinanceDocumentType type = getFinanceDocumentTypeByClass(klass);
	if (type == null) {
	    return false;
	}
	return type.isBothTaxAmount();
    }

    public static boolean isIncludeTaxInAmount(Class klass) {
	FinanceDocumentType type = getFinanceDocumentTypeByClass(klass);
	if (type == null) {
	    return false;
	}
	return type.isIncludeTaxInAmount();
    }

    private static FinanceDocumentType getFinanceDocumentTypeByClass(Class klass) {
	if (klass == null) {
	    return null;
	}
	String className = klass.getName();
	FinanceDocumentType type = classFinanceDocumentTypeMap.get(className);
	if (type != null) {
	    return type;
	}
	String classKey = getIdByClass(klass);
	if (classKey == null) {
	    return null;
	}
	Set<String> keys = financeDocumentTypeMap.keySet();
	for (String key : keys) {
	    // if (classKey.startsWith(key)) {
	    // TODO: Stub
	    if (classKey.equals(key) || classKey.equals(key + "_ITEM")) {
		type = financeDocumentTypeMap.get(key);
		if (type == null) {
		    continue;
		}
		classFinanceDocumentTypeMap.put(className, type);
		return type;
	    }
	}
	return null;
    }

    private static String getIdByClass(Class klass) {
	return ConfigUtils.createIdByClass(klass);
    }

    public static void loadContext() throws ApplicationException {
	logInfo(LOG_LINE);
	logInfo("Loading FinanceContext...");
	FinanceDocumentTypeService service = (FinanceDocumentTypeService) ServiceFactory.getService(FinanceDocumentTypeService.class);
	List<FinanceDocumentType> types = service.findAll();
	addFinanceDocumentTypes(types);
	logInfo("FinanceContext was loaded. Finance document type count = ["	+ types.size() + "]");
    }

    public static void clearContext() throws ApplicationException {
	financeDocumentTypeMap.clear();
	logInfo("FinanceContext was cleared.");
    }

    public static void refreshContext() throws ApplicationException {
	clearContext();
	loadContext();
    }

    public static void initFinanceDocument(FinanceDocument document, String entityCode, SessionContext context) {
	DocumentEnvironment.initDocument(document, entityCode, context);
	initCurrencyHolder(document);
    }
    
    public static void initCurrencyHolder(ICurrencyHolder currencyHolder) {
	currencyHolder.setCurrency(getDefaultCurrency());
	currencyHolder.setCurrencyRate(getDefaultCurrencyRate());
	currencyHolder.setCurrencyRateDate(getDefaultCurrencyRateDate());
    }

    public static Currency getDefaultCurrency() {
	return EnterpriseEnvironment.getCurrency();
    }
    
    public static Date getDefaultCurrencyRateDate() {
	return EnterpriseEnvironment.getDate();
    }
    
    public static double getDefaultCurrencyRate() {
	return DEFAULT_CURRENCY_RATE;
    }
    
    
    protected static void logInfo(Object message) {
	logInfo(logger, message);
    }

}
