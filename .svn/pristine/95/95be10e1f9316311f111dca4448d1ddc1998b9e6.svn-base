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
package org.plazmaforge.bsolution.base;


import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.plazmaforge.bsolution.bank.BankEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.beans.Period;
import org.plazmaforge.bsolution.base.common.beans.SystemInfo;
import org.plazmaforge.bsolution.base.common.beans.SystemPreference;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.base.common.services.EnterpriseContextService;
import org.plazmaforge.bsolution.base.common.services.PeriodService;
import org.plazmaforge.bsolution.base.common.services.PeriodTypeService;
import org.plazmaforge.bsolution.base.common.services.SystemInfoService;
import org.plazmaforge.bsolution.base.common.services.SystemPreferenceService;
import org.plazmaforge.bsolution.contact.ContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.contact.common.services.ContactService;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.organization.common.services.OrganizationService;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.bsolution.partner.common.beans.PartnerType;
import org.plazmaforge.bsolution.partner.common.services.PartnerTypeService;
import org.plazmaforge.bsolution.project.ProjectEnvironment;
import org.plazmaforge.bsolution.project.TaskEnvironment;
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.bsolution.security.common.services.UserService;
import org.plazmaforge.framework.config.InterfaceConfigManager;
import org.plazmaforge.framework.config.object.IInterfaceConfig;
import org.plazmaforge.framework.core.SystemFormat;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.security.UserContext;
import org.plazmaforge.framework.ext.security.UserContextHolder;
import org.plazmaforge.framework.platform.Environment;
import org.plazmaforge.framework.platform.PlatformEnvironment;
import org.plazmaforge.framework.resources.LibraryResources;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.StringUtils;





/**
 * @author Oleh Hapon
 * Date: 28.02.2004
 * Time: 15:21:27
 * $Id: EnterpriseEnvironment.java,v 1.14 2010/12/05 07:55:56 ohapon Exp $
 */


public class EnterpriseEnvironment extends Environment {

    private static final Logger logger = Logger.getLogger(EnterpriseEnvironment.class);
    
    private static EnterpriseEnvironment instance;

    /** System information **/
    private SystemInfo systemInfo;
    
    /** EnterpriseContext **/
    private EnterpriseContext context;
    
    

    private EnterpriseEnvironment() {

    }

    /**
     * Get instance
     * 
     * @return
     */
    public static EnterpriseEnvironment getInstance() {
	if (instance == null) {
	    instance = new EnterpriseEnvironment();
	}
	return instance;

    }
    
    public static SystemInfo getSystemInfo() {
	return getInstance().systemInfo;
    }

    public static void setSystemInfo(SystemInfo sytemInfo) {
	getInstance().systemInfo = sytemInfo;
    }
    
    
    public static EnterpriseContext getContext() {
	return getInstance().context;
    }

    public static void setContext(EnterpriseContext context) {
	getInstance().context = context;
    }
    
    
    private static SessionContext getSessionContext() {
	return (SessionContext) SessionEnvironment.getContext();
    }

    
    public static OrganizationHeader getOrganization(SessionContext context) {
	return getSessionContext().getOrganization();
    }

    public static String getOrganizationName(SessionContext context) {
	return getSessionContext().getOrganization().getName();
    }
    
    public static Integer getOrganizationId(SessionContext context) {
	return getSessionContext().getOrganization().getId();
    }
    
    public static User getUser(SessionContext context) {
	return getSessionContext().getUser();
    }

    public static Integer getUserId(SessionContext context) {
	return getSessionContext().getUser().getId();
    }

    public static String getUserName(SessionContext context) {
	return getSessionContext().getUser().getName();
    }

    public static IInterfaceConfig getUserInterface(SessionContext context) {
	return getSessionContext().getUserInterface();
    }
    
    public static String getUserInterfaceName(SessionContext context) {
	return getUserInterface(context) == null ? null : getUserInterface(context).getName();
    }

    
    //
    
    public static Integer getContactId(SessionContext context) {
	return getSessionContext().getUser().getContactId();
    }
    
    public static Integer getResponsibleId(SessionContext context) {
	return getContactId(context);
    }
    
    public static Integer getDefaultResponsibleId(SessionContext context) {
	Integer contextResponsibleId = getResponsibleId(context);
	if (contextResponsibleId != null ) {
	    return contextResponsibleId;
	}
	ContactTitle responsible = getResponsible();
	return responsible == null ? null : responsible.getId();
    }
    
    //
    
    public static ContactTitle getContact(SessionContext context) {
	return getSessionContext().getUser().getContact();
    }
    
    public static ContactTitle getResponsible(SessionContext context) {
	return getContact(context);
    }
    
    public static ContactTitle getDefaultResponsible(SessionContext context) {
	ContactTitle contextResponsible = getResponsible(context);
	if (contextResponsible != null ) {
	    return contextResponsible;
	}
	return getResponsible();
    }

    
    
    /*
    public static Integer getEmployeeId(EnterpriseContext context) {
	return getContext().getUser().getOwnerId("EMPLOYEE");
    }
    */
    
    
    
    

    public static OrganizationHeader getSystemOrganization() {
	return getSystemInfo().getOrganization();
    }

    public static Integer getSystemOrganizationId() {
	return getSystemInfo().getOrganizationId();
    }

    
    public static Period getPeriod() {
	return getContext().getPeriod();
    }

    public static Period getPayrollPeriod() {
	return getContext().getPayrollPeriod();
    }

 

    
    public static User login(String username, String password) throws AccessDeniedException, ApplicationException {
	

	UserService userService = (UserService) getService(UserService.class);
	User user = userService.login(username, password);
	
	setUserContext(user);
	
	return user;
    }
    
    private static void setUserContext(User user) {
	
	String username = user.getLogin();
	String password = user.getPassword();
	
	UserContext userContext = new UserContext();
	
	userContext.setUserId(user.getId().toString());
	userContext.setUsername(username);
	userContext.setPassword(password);
	userContext.setRoles(user.getRoleIds());
	
	UserContextHolder.setContext(userContext);
	
	/*
         * UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password);
         * SecureContextImpl secureContext = new SecureContextImpl();
         * secureContext.setAuthentication(auth);
         * SecureContextHolder.setContext(secureContext);
         */
    }
    
    
    public static void updateUser(User user) throws ApplicationException {
	setUserContext(user);
	loadContext(user, false);
    }
    
    
    public static void loadContext(SessionContext context, User user) throws ApplicationException {
	loadContext(context, user, true);
    }
    
    public static void loadContext(SessionContext context, User user, boolean isLoadOrganization) throws ApplicationException {
	
	context.setUser(user);
	
	loadUserDetails(context);
	
	if (!isLoadOrganization) {
	    return;
	}
	loadOrganization(context, context.getDefaultUserOrganizationId());
	
    }
    
    public static void loadContext(User user) throws ApplicationException {
	loadContext(user, true);
    }
    
    public static void loadContext(User user, boolean isLoadOrganization) throws ApplicationException {
	SessionContext context = getSessionContext(); 
	loadContext(context, user, isLoadOrganization);
    }
    
    public static boolean isCurrentUser(User user) throws ApplicationException {
	return getSessionContext().isCurrentUser(user);
    }

    protected static void loadUserDetails(SessionContext context) throws ApplicationException {
	
	User user = context.getUser();
	context.setAvailableOrganizations(getOrganizationsByUser(user));
	context.setAvailableUserInterfaces(getUserInterfacesByUser(user));
	
	if (user.getContactId() == null) {
	    return;
	}
	ContactTitle contact = getContactService().findById(user.getContactId());
	if (contact != null) {
	    user.setContact(contact);
	}
    }

    
    public static void loadOrganization(SessionContext context, Integer organizationId) throws ApplicationException {
	OrganizationService service = getOrganizationService();
	OrganizationHeader org = organizationId == null ? null : (OrganizationHeader) service.sysFindHeaderById(organizationId);

	context.setOrganization(org);

	if (org == null && !isAvailableOrganizations(context)) {
	    logger.warn("Organization is null");
	}
    }
    
    public static void loadOrganization(SessionContext context) throws ApplicationException {
	Integer organizationId = context.getOrganizationId();
	loadOrganization(context, organizationId);
    }
    
    /*
    public static void loadOrganization(EnterpriseContext context) throws ApplicationException {

	User user = context.getUser();

	OrganizationService service = getOrganizationService();
	OrganizationHeader org = (OrganizationHeader) service.sysFindHeaderById(user.getOrganizationId());

	context.setOrganization(org);

	if (org == null && !isAvailableOrganizations(context)) {
	    logger.warn("Organization is null");
	}
    }
    */
    
    public static boolean isAvailableOrganizations(SessionContext ctx) {
	if (ctx == null) {
	    return false;
	}
	return ctx.getAvailableOrganizations() != null && ctx.getAvailableOrganizations().size() > 0; 
    }
    
    public static boolean isAvailableUserInterfaces(SessionContext ctx) {
	if (ctx == null) {
	    return false;
	}
	return ctx.getAvailableUserInterfaces() != null && ctx.getAvailableUserInterfaces().size() > 0; 
    }
    
    public static boolean isAvailableCustomParameters(SessionContext ctx) {
	return isAvailableOrganizations(ctx) || isAvailableUserInterfaces(ctx);
    }
    
    private static OrganizationService getOrganizationService() {
	return (OrganizationService) getService(OrganizationService.class);
    }

    
    private static UserService getUserService() {
	return (UserService) getService(UserService.class);
    }

    private static ContactService getContactService() {
	return (ContactService) getService(ContactService.class);
    }
    
    public static List<OrganizationHeader> getOrganizationsByUser(User user) throws ApplicationException {
	
	// Get IDs of organizations of the user
	List<Integer> orgIds = getUserService().sysGetOrganizationIds(user);
	 
	// Get all organizations
	List<OrganizationHeader> orgs = getOrganizations();
	List<OrganizationHeader> result = new ArrayList<OrganizationHeader>();
	
	// If list of organizations of user is empty we use the system organization
	if (orgIds == null || orgIds.isEmpty()) {
	    OrganizationHeader systemOrganization = getSystemOrganization();
	    result.add(systemOrganization);
	    return result;
	}
	 
	
	
	for (OrganizationHeader org: orgs) {
	    Integer id = org.getId();
	    
	    for (Integer orgId : orgIds) {
		
		if (orgId.equals(id)) {
		    result.add(org);
		}
	    }
	}
	
	// If result is empty the return the system organization
	if (result.isEmpty()) {
	    OrganizationHeader systemOrganization = getSystemOrganization();
	    result.add(systemOrganization);
	    return result;
	}
	
	return result;
	
    }
    
    /**
     * Return all organizations
     * @return
     * @throws ApplicationException
     */
    private static List<OrganizationHeader> getOrganizations() throws ApplicationException {
	return getOrganizationService().sysFindAll();
    }
    
    /**
     * Return list of UI by user
     * @param user
     * @return
     * @throws ApplicationException
     */
    public static List<IInterfaceConfig> getUserInterfacesByUser(User user) throws ApplicationException {
	
	// Get all UIs from configuration
	List<IInterfaceConfig> uiList = InterfaceConfigManager.getInterfaces();
	
	if (uiList == null) {
	    return new ArrayList<IInterfaceConfig>();
	}
	if (uiList.isEmpty()) {
	    return uiList;
	}

	
	// Get UIs of the user
	List<String> uis = getUserService().sysGetUserInterfaceIds(user);
	
	// If the user hasn't UIs then return all UIs
	if (uis == null || uis.isEmpty() ) {
	    return uiList;
	}
	

	// Create list of UIS by array of IDs
	List<IInterfaceConfig> result = new ArrayList<IInterfaceConfig>();
	
	for (IInterfaceConfig ui: uiList) {
	    String id = ui.getId();
	    
	    for (String u : uis) {
		
		if (u.equals(id)) {
		    result.add(ui);
		}
	    }
	}
	
	// If result is empty the return all UIs
	if (result.isEmpty()) {
	    return uiList;
	}
	
	return result;
    }


    public static void load() throws ApplicationException {
	loadSystemInfo();
	
	//Migrate to loadSystemInfo because it is system data 
	//loadDefaultData();
	//loadLookupData();
	
	loadModulteContext();
    }

    public static void refresh() throws ApplicationException {
	load();
    }

    public static void loadSystemInfo() throws ApplicationException {

	try {
		SystemInfoService systemInfoService = (SystemInfoService) getService(SystemInfoService.class);
		SystemInfo systemInfo = systemInfoService.load();

		setSystemInfo(systemInfo);

		if (systemInfo == null) {
		    logWarn(logger, "System Info not found");
		    return;
		}
		
		EnterpriseContextService enterpriseContextService = (EnterpriseContextService) getService(EnterpriseContextService.class);
		EnterpriseContext context = enterpriseContextService.load();
		setContext(context);
		
		loadDefaultData();
		loadLookupData();
		
		
		if (context == null) {
		    logWarn(logger, "Enterprise Context not found");
		}
		
		SystemPreference systemPreference = loadSystemPreference();
		boolean isSystemInit = systemInfo.isSystemInit();
		if (!isSystemInit) {
		    systemInfoService.initSystem();
		    systemInfo.setSystemInit(true);
		    systemInfoService.store(systemInfo);
		    initRest();
		} else {
		    systemInfoService.checkSystem();
		}
		
		if (!isSystemInit || !systemPreference.isValid()) {
		    storeSystemPreference(systemPreference);
		}
	} catch (ApplicationException e) {
	    throw e;
	} catch (Throwable e) {
	    throw new ApplicationException(e);
	}
	

    }
    
    protected static void initRest() {
	try {
	    // TODO: STUB !!!
	    String restServiceClassName = "org.plazmaforge.bsolution.product.common.services.ProductManagerService";
	    Class restServiceClass = ClassUtilsExt.getClass(restServiceClassName);
	    Object restService = getService(restServiceClass);
	    Integer periodId = EnterpriseEnvironment.getPeriodId();
	    ClassUtilsExt.invoke(restServiceClass, "calculateRest", Integer.class, restService, periodId);
 
	} catch (Throwable ex) {
	    logError(logger, ex);
	}
    }
    
    public static void loadDefaultData() throws ApplicationException {
	PartnerTypeService service = (PartnerTypeService) getService(PartnerTypeService.class);
	try {
	    EnterpriseEnvironment.getContext().setDefualtPartnerType(service.sysFindById(PartnerType.DEFAULT_TYPE_ID));
	} catch (Exception ex) {
	    // We use catch because the error is not fatal
	    logError(logger, ex);
	}
    }
    
    public static void loadLookupData() throws ApplicationException {
	PeriodTypeService service = (PeriodTypeService) getService(PeriodTypeService.class);
	try {
	    EnterpriseEnvironment.getContext().setPeriodTypes(service.sysFindAll());
	} catch (Exception ex) {
	    // We use catch because the error is not fatal
	    logError(logger, ex);
	}
    }
    

    public static SystemPreference loadSystemPreference() throws ApplicationException {
	SystemPreferenceService systemPreferenceService = (SystemPreferenceService) getService(SystemPreferenceService.class);
	SystemPreference systemPreference = systemPreferenceService.load();
	
	SystemFormat systemFormat = PlatformEnvironment.getSystemFormat();
	systemPreference.populateFormat(systemFormat);
	
	return systemPreference;
    }

    
    public static void storeSystemPreference() throws ApplicationException {
	SystemPreferenceService systemPreferenceService = getSystemPreferenceService();
	SystemPreference systemPreference = systemPreferenceService.load();
	
	storeSystemPreference(systemPreference);
    }

    public static void storeSystemPreference(SystemPreference systemPreference) throws ApplicationException {
	SystemFormat systemFormat = PlatformEnvironment.getSystemFormat();
	systemPreference.loadFormat(systemFormat);
	getSystemPreferenceService().store(systemPreference);
    }
    
    private static SystemPreferenceService getSystemPreferenceService() {
	return (SystemPreferenceService) getService(SystemPreferenceService.class);
    }
    
    
    public static void loadModulteContext() throws ApplicationException {
	loadContactContext();
	loadBankContext();
	loadProjectContext();
	loadTaskContext();
    }
    
    public static void loadContactContext() throws ApplicationException {
	ContactEnvironment.refresh();
    }
    
    public static void loadBankContext() throws ApplicationException {
	BankEnvironment.refresh();
    }

    public static void loadProjectContext() throws ApplicationException {
	ProjectEnvironment.refresh();
    }

    public static void loadTaskContext() throws ApplicationException {
	TaskEnvironment.refresh();
    }

    public static void loadPeriod(Integer periodId) throws ApplicationException {
	PeriodService service = (PeriodService) getService(PeriodService.class);
	Period period = service.sysFindById(periodId);

	getContext().setPeriod(period);
    }

    public static String getStatusText(SessionContext context) {
	String ui = getUserInterfaceName(context);
	ui = StringUtils.isEmpty(ui) ? "" : (" / " + ui);
	return getOrganizationName(context) + ui + " / " + getUsername(context) + " / " + getPeriodName();
    }
    
    
    public static String getUsername(SessionContext context) {
	return getUser(context) == null ? null : getUser(context).getLogin();
    }


    public static Integer getPeriodId() {
	return getContext().getPeriodId();
    }

    public static String getPeriodName() {
	return getContext().getPeriodName();
    }

    public static Date getPeriodStartDate() {
	return getContext().getPeriodStartDate();
    }

    public static Date getPeriodEndDate() {
	return getContext().getPeriodEndDate();
    }

    public static int getPeriodStartYear() {
	return getYear(getPeriodStartDate());
    }

    public static int getPeriodEndYear() {
	return getYear(getPeriodEndDate());
    }

    public static Date getYearPeriodStartDate() {
	return getDate(getPeriodStartYear(), Calendar.JANUARY, 1);
    }

    public static Date getYearPeriodEndDate() {
	return getDate(getPeriodEndYear(), Calendar.DECEMBER, 31);
    }

    public static Integer getPayrollPeriodId() {
	return getContext().getPeriodId();
    }

    public static String getPayrollPeriodName() {
	return getContext().getPayrollPeriodName();
    }

    public static Currency getCurrency() {
	return getContext().getCurrency();
    }

    public static Integer getCurrencyId() {
	return getContext().getCurrencyId();
    }

    public static Unit getUnit() {
	return getContext().getUnit();
    }

    public static Integer getUnitId() {
	return getContext().getUnitId();
    }

    public static float getTaxPercent() {
	return getContext().getTaxPercent();
    }

    /**
     * Get current client date (temporable setting user)
     * @return
     */
    public static Date getDate() {
	return new Date();
    }

    /**
     * Get current calendar
     * @return
     */
    public static Calendar getCalendar() {
	return getCalendar(getDate());
    }

    /**
     * Get calendar by date
     * @param date
     * @return
     */
    public static Calendar getCalendar(Date date) {
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	return c;
    }

    /**
     * Get current year
     * @return
     */
    public static int getYear() {
	return getYear(getDate());
    }

    /**
     * Get year by date
     * @param date
     * @return
     */
    public static int getYear(Date date) {
	return getCalendar(date).get(Calendar.YEAR);
    }

    /**
     * Get currenct month. Java implementation. (0 - 11)
     * @return
     */
    public static int getMonth() {
	return getMonth(getDate());
    }

    /**
     * Get month by date. Java implementation. (0 - 11)
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
	return getCalendar(date).get(Calendar.MONTH);
    }

    /**
     * Get current gregorian month. (1 - 12)
     * @return
     */
    public static int getGregorianMonth() {
	return getMonth() + 1;
    }

    /**
     * Get <code>Date</code> by year, month, date
     * @param year
     * @param month
     * @param date
     * @return
     */
    public static Date getDate(int year, int month, int date) {
	Calendar c = Calendar.getInstance();
	c.set(year, month, date);
	return c.getTime();
    }

    /**
     * Get real current system date (server date)
     * Example for SQL Server: SELECT SYDATE from temp
     * @return
     */
    public static Date getSystemDate() {
	return new Date();
    }

    public static String getCurrencySymbol() {
	return "\u00A4";
    }

    public static String getCurrencyLabel() {
	return LibraryResources.getInstance().getString("currency.label");
    }

    //---

    public static PartnerTitle getPartner() {
	return getContext().getPartner();
    }

    public static PartnerTitle getCustomer() {
	return getContext().getCustomer() == null ? getPartner() : getContext().getCustomer();
    }

    public static PartnerTitle getSupplier() {
	return getContext().getSupplier() == null ? getPartner() : getContext().getSupplier();
    }

    public static ContactTitle getResponsible() {
	return getContext().getResponsible();
    }

    public static MtrlResponsible getMtrlResponsible() {
	return getContext().getMtrlResponsible();
    }

    public static Warehouse getWharehouse() {
	return getContext().getWarehouse();
    }

    public static Warehouse getIncomeWharehouse() {
	return getContext().getIncomeWarehouse() == null ? getWharehouse() : getContext().getIncomeWarehouse();
    }

    public static Warehouse getOutcomeWharehouse() {
	return getContext().getOutcomeWarehouse() == null ? getWharehouse() : getContext().getOutcomeWarehouse();
    }

    ////
    
    public static boolean isInternationalAttributes() {
	return getContext().isInternationalAttributes();
    }
 
    public static boolean isAutoSetCurrencyRate() {
	return getContext().isAutoSetCurrencyRate();
    }

    public static PartnerType getDefualtPartnerType() {
	return getContext().getDefualtPartnerType();
    }
    
    public static boolean isCalculateAccounting() {
	return getContext().isCalculateAccounting();
    }
    
    public static boolean isMultiCurrencies() {
	return getContext().isMultiCurrencies();
    }
    
    public static boolean isProjectInDocument() {
	return getContext().isProjectInDocument();
    }
    
 }
