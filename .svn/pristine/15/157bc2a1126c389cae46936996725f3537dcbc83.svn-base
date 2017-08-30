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
package org.plazmaforge.bs.project.shared.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.plazmaforge.bs.base.shared.entities.Currency;
import org.plazmaforge.bs.base.shared.entities.CurrencyHolder;
import org.plazmaforge.bs.base.shared.entities.ICurrencyHolder;
import org.plazmaforge.bs.base.shared.entities.ITaxHolder;
import org.plazmaforge.bs.base.shared.entities.TaxHolder;
import org.plazmaforge.bs.document.shared.entities.DocumentHeader;
import org.plazmaforge.bs.partner.shared.entities.PartnerTitle;
import org.plazmaforge.framework.ext.model.IStatusEntity;
//import org.plazmaforge.framework.platform.EntityEnvironment;
//import org.plazmaforge.framework.util.MoneyEnvironment;

/**
 * 
 * @author ohapon
 *
 */
public class Project extends ProjectHeader implements ICurrencyHolder, ITaxHolder, IStatusEntity  {

    private static final long serialVersionUID = -1068565906041328365L;
    
    
    private CurrencyHolder currencyHolder = new CurrencyHolder();
    
    private TaxHolder taxHolder = new TaxHolder();
    
    
    private Date startDate;

    private Date endDate;

    private Date actualEndDate;

    private String description;

    private DocumentHeader contractDocument;

    private double propability;

    private PartnerTitle partner;

    private ProjectStage projectStage;

    private ProjectStatus projectStatus;

    private ProjectType projectType;

 


    
    private double amount;

    private double taxAmount;

    private double amountWithTax;
    

    private double discountPercent;
    

    private double discountAmount;
    
    private double currencyDiscountAmount;


    private double currencyAmount;

    private double currencyTaxAmount;

    private double currencyAmountWithTax;
    

    

    
    ////
    
    
    
    private double total;

    private double totalWithTax;

    private double taxTotal;
    
    
    ////
    
    private double currencyTotal;

    private double currencyTotalWithTax;

    private double currencyTaxTotal;
    

    ////
    
    
    
    
    private List<ProjectContactLink> projectContactLinks;

    private List<ProjectStageLink> projectStageLinks;
    
    
    public Date getActualEndDate() {
	return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
	this.actualEndDate = actualEndDate;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    public double getAmountWithTax() {
	return amountWithTax;
    }

    public void setAmountWithTax(double amountWithTax) {
	this.amountWithTax = amountWithTax;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    
    // --
    
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

    // --

    

    public double getCurrencyAmount() {
	return currencyAmount;
    }

    public void setCurrencyAmount(double currencyAmount) {
	this.currencyAmount = currencyAmount;
    }

    public double getCurrencyAmountWithTax() {
	return currencyAmountWithTax;
    }

    public void setCurrencyAmountWithTax(double currencyAmountWithTax) {
	this.currencyAmountWithTax = currencyAmountWithTax;
    }

    public double getCurrencyDiscountAmount() {
	return currencyDiscountAmount;
    }

    public void setCurrencyDiscountAmount(double currencyDiscountAmount) {
	this.currencyDiscountAmount = currencyDiscountAmount;
    }


    public double getCurrencyTaxAmount() {
	return currencyTaxAmount;
    }

    public void setCurrencyTaxAmount(double currencyTaxAmount) {
	this.currencyTaxAmount = currencyTaxAmount;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public double getDiscountAmount() {
	return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
	this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
	return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
	this.discountPercent = discountPercent;
    }

    public PartnerTitle getPartner() {
	return partner;
    }

    public void setPartner(PartnerTitle partner) {
	this.partner = partner;
    }

    public ProjectStage getProjectStage() {
	return projectStage;
    }

    public void setProjectStage(ProjectStage projectStage) {
	this.projectStage = projectStage;
    }

    public ProjectStatus getProjectStatus() {
	return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
	this.projectStatus = projectStatus;
    }

    public ProjectType getProjectType() {
	return projectType;
    }

    public void setProjectType(ProjectType projectType) {
	this.projectType = projectType;
    }

    public double getPropability() {
	return propability;
    }

    public void setPropability(double propability) {
	this.propability = propability;
    }

 

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public double getTaxAmount() {
	return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
	this.taxAmount = taxAmount;
    }

    public DocumentHeader getContractDocument() {
        return contractDocument;
    }

    public void setContractDocument(DocumentHeader contractDocument) {
        this.contractDocument = contractDocument;
    }
    
    public String getContractDocumentNo() {
        return contractDocument == null ? null : contractDocument.getDocumentNo();
    }


    public String getPartnerName() {
	return partner == null ? null : getPartner().getName();
    }

    public String getProjectStatusName() {
	return projectStatus == null ? null : getProjectStatus().getName();
    }

    
    // --
    
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
    
    // --
    
    //
    
    public List<ProjectContactLink> getProjectContactLinks() {
	if (projectContactLinks == null) {
	    projectContactLinks = new ArrayList<ProjectContactLink>();
	}
        return projectContactLinks;
    }

    public void setProjectContactLinks(List<ProjectContactLink> projectContactLinks) {
        this.projectContactLinks = projectContactLinks;
    }

    public void addProjectContactLink(ProjectContactLink projectContactLink) {
	projectContactLink.setProject(this);
        getProjectContactLinks().add(projectContactLink);
    }
    
    //
    
    public List<ProjectStageLink> getProjectStageLinks() {
        return projectStageLinks;
    }

    public void setProjectStageLinks(List<ProjectStageLink> projectStageLinks) {
        this.projectStageLinks = projectStageLinks;
    }   

    public void addProjectStageLink(ProjectStageLink projectStageLink) {
	projectStageLink.setProject(this);
        getProjectStageLinks().add(projectStageLink);
    }  

    public void init() {
	super.init();

	// Force initialize
	getProjectContactLinks().size();
	getProjectStageLinks().size();
    }

    ////
    
    public double getCurrencyTotal() {
        return currencyTotal;
    }

    public double getCurrencyTotalWithTax() {
        return currencyTotalWithTax;
    }

    public double getCurrencyTaxTotal() {
        return currencyTaxTotal;
    }

    public void setCurrencyTotal(double currencyTotal) {
        this.currencyTotal = currencyTotal;
    }

    public void setCurrencyTotalWithTax(double currencyTotalWithTax) {
        this.currencyTotalWithTax = currencyTotalWithTax;
    }

    public void setCurrencyTaxTotal(double currencyTaxTotal) {
        this.currencyTaxTotal = currencyTaxTotal;
    }
    
    
    ////
    

    public double getTotal() {
        return total;
    }

    public double getTotalWithTax() {
        return totalWithTax;
    }

    public double getTaxTotal() {
        return taxTotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTotalWithTax(double totalWithTax) {
        this.totalWithTax = totalWithTax;
    }

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

  

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // CALCULTE BLOCK
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    
    /**
     * Calculate finance of the project
     */
    public void calculate() {
	
	// !!! WARNING
	// You have to set next values before calculation process:
	// - currencyTaxAmount
	// - currencyTaxTotal  
	
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
	setCurrencyAmountWithTax(getCurrencyAmount() + getCurrencyTaxAmount()); // SWITCH
    }

    public void calculateNationalAmountValues() {
	//TODO
	/*
	setDiscountAmount(MoneyEnvironment.roundMoney(getCurrencyDiscountAmount() * getCurrencyRate()));
	setAmount(MoneyEnvironment.roundMoney(getCurrencyAmount() * getCurrencyRate()));
	setTaxAmount(MoneyEnvironment.roundMoney(getCurrencyTaxAmount()	* getCurrencyRate()));
	setAmountWithTax(getAmount() + getTaxAmount());
	*/
    }

    public void calculateCurrencyTotalValues() {
	//TODO
	/*
	setCurrencyTotal(getCurrencyAmount() - getCurrencyDiscountAmount());
	setCurrencyTotalWithTax(getCurrencyTotal() + getCurrencyTaxTotal());
	*/
    }

    public void calculateNationalTotalValues() {
	//TODO
	/*
	setTaxTotal(MoneyEnvironment.roundMoney(getCurrencyTaxTotal() * getCurrencyRate()));
	setTotal(getAmount() - getDiscountAmount());
	setTotalWithTax(getTotal() + getTaxTotal());
	*/
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////


}
