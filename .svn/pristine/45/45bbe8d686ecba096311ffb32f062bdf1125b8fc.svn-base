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
package org.plazmaforge.bsolution.finance.common.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.finance.FinanceEnvironment;
import org.plazmaforge.framework.util.MoneyEnvironment;


/**
 * @author Oleh Hapon
 * 
 * The Finance document.
 * 
 */
public class FinanceDocument extends Document implements ICurrencyHolder, ITaxHolder {

    

    
    /** Currency **/
    private CurrencyHolder currencyHolder = new CurrencyHolder();
    
    /** Currency Amount **/
    private ValueHolder currencyAmountHolder = new ValueHolder();
    
    /** National Amount **/
    private ValueHolder amountHolder = new ValueHolder();

    /** Currency Total **/
    private ValueHolder currencyTotalHolder = new ValueHolder();
    
    /** National Total
     * <code>total = amount + [addAmount]</code> 
     * <code>[addAmount]</code> is additional amount of concrete document
     * For example [addAmount] can be delivery
     **/
    private ValueHolder totalHolder = new ValueHolder();
    
    /** Tax **/
    private TaxHolder taxHolder = new TaxHolder();
    
    


    /**
     * Accounting entries
     */
    protected List<EntryItem> entryItems;

    /**
     * Move by partners
     */
    private List<PartnerMove> partnerMoves;

    /**
     * Move by products
     */
    private List<ProductMove> productMoves;

    /**
     * Move by wharehouses 
     */
    private List<WarehouseMove> warehouseMoves;

    /**
     * Move by employees
     */
    private List<EmployeeMove> employeeMoves;

    /**
     * Move by contractors (partner + employee)
     */
    private List<ContractorMove> contractorMoves;
    
    
    

    /**
     * Value is true when the document includes tax in amount
     */
    private Boolean includeTaxInAmount;

    
    private Boolean bothTaxAmount;


    
    // Currency 
    
    public Currency getCurrency() {
	return currencyHolder.getCurrency(); 
    }

    public void setCurrency(Currency currency) {
	currencyHolder.setCurrency(currency);
    }


    public double getCurrencyRate() {
	return currencyHolder.getCurrencyRate();
    }

    public void setCurrencyRate(double currencyRate) {
	currencyHolder.setCurrencyRate(currencyRate);
    }

    public Date getCurrencyRateDate() {
	return currencyHolder.getCurrencyRateDate();
    }

    public void setCurrencyRateDate(Date currencyRateDate) {
	currencyHolder.setCurrencyRateDate(currencyRateDate);
    }

    public String getCurrencyCode() {
	return currencyHolder.getCurrencyCode();
    }

    public String getCurrencyName() {
	return currencyHolder.getCurrencyName();
    }

    
    // Currency Amount
    
    public double getCurrencyAmount() {
	return currencyAmountHolder.getValue();
    }

    public void setCurrencyAmount(double currencyAmount) {
	currencyAmountHolder.setValue(currencyAmount);
    }

    public double getCurrencyAmountWithTax() {
	return currencyAmountHolder.getValueWithTax();
    }

    public void setCurrencyAmountWithTax(double currencyWithoutAmount) {
	currencyAmountHolder.setValueWithTax(currencyWithoutAmount);
    }

    public double getCurrencyTaxAmount() {
	return currencyAmountHolder.getTaxValue();
    }

    public void setCurrencyTaxAmount(double currencyTaxAmount) {
	currencyAmountHolder.setTaxValue(currencyTaxAmount);
    }

    
    // Amount
    
    public double getAmount() {
	return amountHolder.getValue();
    }

    public void setAmount(double amount) {
	amountHolder.setValue(amount);
    }

    public double getAmountWithTax() {
	return amountHolder.getValueWithTax();
    }

    public void setAmountWithTax(double withoutAmount) {
	amountHolder.setValueWithTax(withoutAmount);
    }

    public double getTaxAmount() {
	return amountHolder.getTaxValue(); 
    }

    public void setTaxAmount(double taxAmount) {
	amountHolder.setTaxValue(taxAmount);
    }

    

    // Currency Total
    
    public double getCurrencyTotal() {
	return currencyTotalHolder.getValue();
    }

    public void setCurrencyTotal(double currencyTotal) {
	currencyTotalHolder.setValue(currencyTotal);
    }

    public double getCurrencyTotalWithTax() {
	return currencyTotalHolder.getValueWithTax();
    }

    public void setCurrencyTotalWithTax(double currencyTotalWithTax) {
	currencyTotalHolder.setValueWithTax(currencyTotalWithTax);
    }

    public double getCurrencyTaxTotal() {
	return currencyTotalHolder.getTaxValue();
    }

    public void setCurrencyTaxTotal(double currencyTaxTotal) {
	currencyTotalHolder.setTaxValue(currencyTaxTotal);
    }
    
    

    
    public double getTotal() {
	return totalHolder.getValue();
    }

    public void setTotal(double total) {
	totalHolder.setValue(total);
    }

    public double getTotalWithTax() {
	return totalHolder.getValueWithTax();
    }

    public void setTotalWithTax(double withoutTotal) {
	totalHolder.setValueWithTax(withoutTotal);
    }

    public double getTaxTotal() {
	return totalHolder.getTaxValue();
    }

    public void setTaxTotal(double taxTotal) {
	totalHolder.setTaxValue(taxTotal);
    }

    


    
    
    

    
    
    


    public List<EntryItem> getEntryItems() {
	if (entryItems == null) {
	    entryItems = new ArrayList<EntryItem>();
	}
	return entryItems;
    }

    public void setEntryItems(List<EntryItem> entryItems) {
	this.entryItems = entryItems;
    }

    // Tax
    
    public boolean isTax() {
	return taxHolder.isTax();
    }

    public void setTax(boolean tax) {
	taxHolder.setTax(tax);
    }

    public Integer getTaxId() {
	return taxHolder.getTaxId(); 
    }

    public void setTaxId(Integer taxId) {
	taxHolder.setTaxId(taxId);
    }

    public float getTaxPercent() {
	return taxHolder.getTaxPercent();
    }

    public void setTaxPercent(float taxPercent) {
	taxHolder.setTaxPercent(taxPercent);
    }
    
    

    public double getDocumentAmount() {
	return this.getAmountWithTax();
    }

    public double getCurrencyDocumentAmount() {
	return this.getCurrencyAmountWithTax();
    }

    public double getDocumentTotal() {
	return this.getTotalWithTax();
    }

    public double getCurrencyDocumentTotal() {
	return this.getCurrencyTotalWithTax();
    }

    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // CALCULTE BLOCK
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////    

    
    /**
     * Calculate finance document
     */
    public void calculate() {
	calculateAmountValues(); // all amount values (currency/national)
	calculateTotalValues();  // all total values (currency/national)
    }

    /**
     * Calculate all amount values (currency/national)
     */
    public void calculateAmountValues() {
	calculateCurrencyAmountValues();
	calculateNationalAmountValues();
    }

    /**
     * Calculate all total values (currency/national)
     */
    public void calculateTotalValues() {
	calculateCurrencyTotalValues();
	calculateNationalTotalValues();
    }

    public void calculateCurrencyAmountValues() {
	if (isIncludeTaxInAmount()) {
	    setCurrencyAmount(getCurrencyAmountWithTax() - getCurrencyTaxAmount()); // SWITCH
	} else {
	    setCurrencyAmountWithTax(getCurrencyAmount() + getCurrencyTaxAmount()); // SWITCH
	}
    }

    public void calculateNationalAmountValues() {
	setAmount(MoneyEnvironment.roundMoney(getCurrencyAmount() * getCurrencyRate()));
	setTaxAmount(MoneyEnvironment.roundMoney(getCurrencyTaxAmount()	* getCurrencyRate()));
	setAmountWithTax(getAmount() + getTaxAmount());
    }

    public void calculateCurrencyTotalValues() {
	setCurrencyTaxTotal(getCurrencyTaxAmount());
	setCurrencyTotal(getCurrencyAmount());
	setCurrencyTotalWithTax(getCurrencyAmountWithTax());
    }

    public void calculateNationalTotalValues() {
	setTaxTotal(getTaxAmount());
	setTotal(getAmount());
	setTotalWithTax(getAmountWithTax());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    

    public void init() {
	super.init();

	// Force initialize
	getEntryItems().size();
	getPartnerMoves().size();
	getProductMoves().size();
	getWarehouseMoves().size();

	getContractorMoves().size();
	getEmployeeMoves().size();
    }

    public void addEntryItem(EntryItem item) {
	item.setOwner(this);
	getEntryItems().add(item);

    }

    public List<PartnerMove> getPartnerMoves() {
	if (partnerMoves == null) {
	    partnerMoves = new ArrayList<PartnerMove>();
	}
	return partnerMoves;
    }

    public void setPartnerMoves(List<PartnerMove> partnerMoves) {
	this.partnerMoves = partnerMoves;
    }

    public void addPartnerMove(PartnerMove move) {
	move.setOwner(this);
	getPartnerMoves().add(move);
    }

    public List<ProductMove> getProductMoves() {
	if (productMoves == null) {
	    productMoves = new ArrayList<ProductMove>();
	}
	return productMoves;
    }

    public void setProductMoves(List<ProductMove> productMoves) {
	this.productMoves = productMoves;
    }

    public void addProductMove(ProductMove move) {
	move.setOwner(this);
	getProductMoves().add(move);
    }

    public List<WarehouseMove> getWarehouseMoves() {
	if (warehouseMoves == null) {
	    warehouseMoves = new ArrayList<WarehouseMove>();
	}
	return warehouseMoves;
    }

    public void setWarehouseMoves(List<WarehouseMove> warehouseMoves) {
	this.warehouseMoves = warehouseMoves;
    }

    public void addWarehouseMove(WarehouseMove move) {
	move.setOwner(this);
	getWarehouseMoves().add(move);
    }

    public List<ContractorMove> getContractorMoves() {
	if (contractorMoves == null) {
	    contractorMoves = new ArrayList<ContractorMove>();
	}
	return contractorMoves;
    }

    public void setContractorMoves(List<ContractorMove> contractorMoves) {
	this.contractorMoves = contractorMoves;
    }

    public void addContractorMove(ContractorMove move) {
	move.setOwner(this);
	getContractorMoves().add(move);
    }

    public List<EmployeeMove> getEmployeeMoves() {
	if (employeeMoves == null) {
	    employeeMoves = new ArrayList<EmployeeMove>();
	}
	return employeeMoves;
    }

    public void setEmployeeMoves(List<EmployeeMove> employeeMoves) {
	this.employeeMoves = employeeMoves;
    }

    public void addEmployeeMove(EmployeeMove move) {
	move.setOwner(this);
	getEmployeeMoves().add(move);
    }

    public Integer getPartnerId() {
	if (partnerMoves == null || partnerMoves.size() == 0) {
	    return null;
	}
	return partnerMoves.get(0).getPartnerId();
    }

    public Integer getWarehouseId() {
	if (warehouseMoves == null || warehouseMoves.size() == 0) {
	    return null;
	}
	return warehouseMoves.get(0).getWarehouseId();
    }

    public Integer getContractorId() {
	if (contractorMoves == null || contractorMoves.size() == 0) {
	    return null;
	}
	return contractorMoves.get(0).getContractorId();
    }

    public Integer getEmployeeId() {
	if (employeeMoves == null || employeeMoves.size() == 0) {
	    return null;
	}
	return employeeMoves.get(0).getEmployeeId();
    }

    // --------------------------------------------------------------------------------------------------
    //
    // Enter methods
    //
    // --------------------------------------------------------------------------------------------------

    public boolean isIncludeTaxInAmount() {
	if (includeTaxInAmount == null) {
	    includeTaxInAmount = FinanceEnvironment.isIncludeTaxInAmount(this
		    .getClass());
	}
	return includeTaxInAmount;
    }

    public void setIncludeTaxInAmount(boolean includeTaxInAmount) {
	this.includeTaxInAmount = includeTaxInAmount;
    }

    public boolean isBothTaxAmount() {
	if (bothTaxAmount == null) {
	    bothTaxAmount = FinanceEnvironment.isBothTaxAmount(this.getClass());
	}
	return bothTaxAmount;
    }

    public void setBothTaxAmount(boolean bothTaxAmount) {
	this.bothTaxAmount = bothTaxAmount;
    }

    public void setEnterAmount(double enterAmount) {
	if (isIncludeTaxInAmount()) {
	    setAmountWithTax(enterAmount);
	} else {
	    setAmount(enterAmount);
	}
    }

    public double getEnterAmount() {
	return isIncludeTaxInAmount() ? getAmountWithTax() : getAmount();
    }

    public void setCurrencyEnterAmount(double currencyEnterAmount) {
	if (isIncludeTaxInAmount()) {
	    setCurrencyAmountWithTax(currencyEnterAmount);
	} else {
	    setCurrencyAmount(currencyEnterAmount);
	}
    }

    public double getCurrencyEnterAmount() {
	return isIncludeTaxInAmount() ? getCurrencyAmountWithTax()
		: getCurrencyAmount();
    }

    public void setEnterTotal(double enterAmount) {
	if (isIncludeTaxInAmount()) {
	    setTotalWithTax(enterAmount);
	} else {
	    setTotal(enterAmount);
	}
    }

    public double getEnterTotal() {
	return isIncludeTaxInAmount() ? getTotalWithTax() : getTotal();
    }

    public void setCurrencyEnterTotal(double currencyEnterTotal) {
	if (isIncludeTaxInAmount()) {
	    setCurrencyTotalWithTax(currencyEnterTotal);
	} else {
	    setCurrencyTotal(currencyEnterTotal);
	}
    }

    public double getCurrencyEnterTotal() {
	return isIncludeTaxInAmount() ? getCurrencyTotalWithTax()
		: getCurrencyTotal();
    }
    
    
    ///////////////////////////////
    
    
    public static boolean isIncludeTaxInAmountByClass(Class klass) {
	return FinanceEnvironment.isIncludeTaxInAmount(klass);
    }
    
    ////
    
    public static String getEnterTotalProperty(Class klass) {
	return isIncludeTaxInAmountByClass(klass) ? "totalWithTax" : "total";
    }
    
    public static String getCurrencyEnterTotalProperty(Class klass) {
	return isIncludeTaxInAmountByClass(klass) ? "currencyTotalWithTax" : "currencyTotal";
    }

    ////
    
    public static String getEnterAmountProperty(Class klass) {
	return isIncludeTaxInAmountByClass(klass) ? "amountWithTax" : "amount";
    }
    
    public static String getCurrencyAmountTotalProperty(Class klass) {
	return isIncludeTaxInAmountByClass(klass) ? "currencyAmountWithTax" : "currencyAmount";
    }

    public boolean isCalculateAccountEntry() {
	return true;
    }

}
