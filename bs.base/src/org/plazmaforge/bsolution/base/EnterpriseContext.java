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
import java.util.List;

import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.beans.Period;
import org.plazmaforge.bsolution.base.common.beans.PeriodType;
import org.plazmaforge.bsolution.base.common.beans.Tax;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.bsolution.partner.common.beans.PartnerType;
import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.platform.structure.PartContext;

public class EnterpriseContext extends BaseEntity implements PartContext {

    
    public static final Integer DEFAULT_PERIOD_ID = new Integer(1);

    public static final Integer DEFAULT_PAYROLL_PERIOD_ID = new Integer(1);

    public static final Integer DEFAULT_CURRENCY_ID = new Integer(1);

    public static final Integer DEFAULT_UNIT_ID = new Integer(1);

    public static final Integer DEFAULT_TAX_ID = new Integer(1);

    public static final float DEFAULT_TAX_PERCENT = 20;

    
    
    /** Current period * */
    private Period period;

    /** Current payroll period * */
    private Period payrollPeriod;

    /** National currency * */
    private Currency currency;

    /** Currency unit * */
    private Unit unit;

    /** Currency tax * */
    private Tax tax;

    
 // ---

    private PartnerTitle partner;

    private PartnerTitle supplier;

    private PartnerTitle customer;

    private ContactTitle responsible;

    private MtrlResponsible mtrlResponsible;

    private Warehouse warehouse;

    private Warehouse incomeWarehouse;

    private Warehouse outcomeWarehouse;

    // ---
    
    private boolean calculateAccounting;
    
    ////
    
    private boolean multiCurrencies;
    
    private boolean autoSetCurrencyRate;
    
    private boolean internationalAttributes;
    
    private boolean projectInDocument;
    
    private boolean autoCalculateProdRest;
    
    
    private PartnerType defualtPartnerType;
    

    /**
     * List of period types (MONTH, QUARTER, YEAR, CUSTOM)
     */
    private List<PeriodType> periodTypes;
    
    /**
     * CUSTOM period type
     */
    private PeriodType customPeriodType;
    
    
    public Integer getPeriodId() {
	return period == null ? null : period.getId();
    }

 

    public Integer getUnitId() {
	return unit == null ? null : unit.getId();
    }

    public Integer getCurrencyId() {
	return currency == null ? null : currency.getId();
    }

    public String getPeriodName() {
	return period == null ? null : period.getName();
    }

    public Date getPeriodStartDate() {
	return period == null ? null : period.getStartDate();
    }

    public Date getPeriodEndDate() {
	return period == null ? null : period.getEndDate();
    }

    public String getPayrollPeriodName() {
	return payrollPeriod == null ? null : payrollPeriod.getName();
    }

 
    public String getUnitName() {
	return unit == null ? null : unit.getName();
    }

    public String getCurrencyName() {
	return currency == null ? null : currency.getName();
    }

    public Currency getCurrency() {
	return currency;
    }

    public void setCurrency(Currency currency) {
	this.currency = currency;
    }

    public Period getPayrollPeriod() {
	return payrollPeriod;
    }

    public void setPayrollPeriod(Period payrollPeriod) {
	this.payrollPeriod = payrollPeriod;
    }

    public Period getPeriod() {
	return period;
    }

    public void setPeriod(Period period) {
	this.period = period;
    }

    public float getTaxPercent() {
	return getTax() == null ? 0 : getTax().getTaxPercent();
    }

 

    public Unit getUnit() {
	return unit;
    }

    public void setUnit(Unit unit) {
	this.unit = unit;
    }

    public Tax getTax() {
	return tax;
    }

    public void setTax(Tax tax) {
	this.tax = tax;
    }
    
    
 // ---

    public PartnerTitle getCustomer() {
	return customer;
    }

    public void setCustomer(PartnerTitle customer) {
	this.customer = customer;
    }

    public Warehouse getIncomeWarehouse() {
	return incomeWarehouse;
    }

    public void setIncomeWarehouse(Warehouse incomeWarehouse) {
	this.incomeWarehouse = incomeWarehouse;
    }

    public MtrlResponsible getMtrlResponsible() {
	return mtrlResponsible;
    }

    public void setMtrlResponsible(MtrlResponsible mtrlResponsible) {
	this.mtrlResponsible = mtrlResponsible;
    }

    public Warehouse getOutcomeWarehouse() {
	return outcomeWarehouse;
    }

    public void setOutcomeWarehouse(Warehouse outcomeWarehouse) {
	this.outcomeWarehouse = outcomeWarehouse;
    }

    public PartnerTitle getPartner() {
	return partner;
    }

    public void setPartner(PartnerTitle partner) {
	this.partner = partner;
    }

    public ContactTitle getResponsible() {
	return responsible;
    }

    public void setResponsible(ContactTitle responsible) {
	this.responsible = responsible;
    }

    public Warehouse getWarehouse() {
	return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
	this.warehouse = warehouse;
    }

    public PartnerTitle getSupplier() {
	return supplier;
    }

    public void setSupplier(PartnerTitle supplier) {
	this.supplier = supplier;
    }

    public boolean isCalculateAccounting() {
        return calculateAccounting;
    }

    public void setCalculateAccounting(boolean calculateAccounting) {
        this.calculateAccounting = calculateAccounting;
    }

    
    public boolean isMultiCurrencies() {
        return multiCurrencies;
    }

    public void setMultiCurrencies(boolean multiCurrencies) {
        this.multiCurrencies = multiCurrencies;
    }

    
    public boolean isAutoSetCurrencyRate() {
        return autoSetCurrencyRate;
    }

    public void setAutoSetCurrencyRate(boolean autoSetCurrencyRate) {
        this.autoSetCurrencyRate = autoSetCurrencyRate;
    }

    public boolean isInternationalAttributes() {
        return internationalAttributes;
    }

    public void setInternationalAttributes(boolean internationalAttributes) {
        this.internationalAttributes = internationalAttributes;
    }

    public boolean isProjectInDocument() {
        return projectInDocument;
    }

    public void setProjectInDocument(boolean projectInDocument) {
        this.projectInDocument = projectInDocument;
    }

    public boolean isAutoCalculateProdRest() {
        return autoCalculateProdRest;
    }

    public void setAutoCalculateProdRest(boolean autoCalculateProdRest) {
        this.autoCalculateProdRest = autoCalculateProdRest;
    }
    
    // ---

   

    public PartnerType getDefualtPartnerType() {
	return defualtPartnerType;
    }

    public void setDefualtPartnerType(PartnerType defualtPartnerType) {
	this.defualtPartnerType = defualtPartnerType;
    }



    public List<PeriodType> getPeriodTypes() {
	if (periodTypes == null) {
	    periodTypes = new ArrayList<PeriodType>();
	}
        return periodTypes;
    }



    public void setPeriodTypes(List<PeriodType> periodTypes) {
        this.periodTypes = periodTypes;
        if (isEmptyPeriodTypes()) {
            this.customPeriodType = null;
        }
	for (PeriodType t: periodTypes) {
	    if (PeriodType.CUSTOM.equals(t.getCode())) {
		this.customPeriodType = t;
		return;
	    }
	}
	this.customPeriodType = null;
    }
    
    public PeriodType getPeriodType(String type) {
	if (type == null || isEmptyPeriodTypes()) {
	    return customPeriodType;
	}
	for (PeriodType t: periodTypes) {
	    if (type.equals(t.getCode())) {
		return t;
	    }
	}
	return null;
    }

    public boolean isEmptyPeriodTypes() {
	return periodTypes == null || periodTypes.isEmpty();
    }
    
    public PeriodType getCustomPeriodType() {
        return customPeriodType;
    }

    
    
}
