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
 * Created on 13.06.2007
 *
 */

package org.plazmaforge.bsolution.bank.client.swt.forms;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.bank.BankContext;
import org.plazmaforge.bsolution.bank.BankEnvironment;
import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.bank.common.beans.PaymentDocument;
import org.plazmaforge.bsolution.bank.common.services.BankAccountService;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.finance.client.swt.forms.AbstractFinanceDocumentEditForm;
import org.plazmaforge.bsolution.partner.client.swt.forms.PartnerBankAccountListForm;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.partner.common.services.PartnerService;
import org.plazmaforge.framework.client.models.LoadEvent;
import org.plazmaforge.framework.client.models.LoadListener;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.core.data.Item;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AbstractPaymentDocumentEditForm.java,v 1.5 2010/12/05 07:57:18 ohapon Exp $
 */

public abstract class AbstractPaymentDocumentEditForm extends AbstractFinanceDocumentEditForm {

    private boolean isUpdateForm;
    
    private XComboEdit organizationBankAccountField;
    
    private XComboEdit partnerBankAccountField;
    
    private BankAccountHelper bankAccountHelper;
    
    
    protected Date documentDate;
    
    protected Date paymentDate;
    
    public AbstractPaymentDocumentEditForm(Composite parent, int style) {
	super(parent, style);
    }
    
    
    protected void initBankAccountField(final XComboEdit field) {
	if (field == null) {
	    return;
	}
	field.setSupportService(false);
	field.setListFormClass(PartnerBankAccountListForm.class);
	field.setDisplayValueProperty("accountNo");
	//bankAccountField.setTrimText(false); // Disable trim text: getText(). AccountNo is CHAR() field in table.
    }    
    
    protected PaymentDocument getPaymentDocument() {
	return (PaymentDocument) getEntity();
    }


    
    protected BankAccountService getBankAccountService() {
	return (BankAccountService) getService(BankAccountService.class);
    }
    
    ////
    
    public BankAccount getBankAccount(IPartnerTitle partner) {
	return getBankAccountHelper().getBankAccount(partner);
    }
    
    public List getBankAccountsByPartner(IPartnerTitle partner) {
	return getBankAccountHelper().getBankAccountsByPartner(partner);
    }
    

    ////
    
    protected void loadBankAccountField(XComboEdit bankAccountField, IPartnerTitle partner) {
	updateBankAccountField(bankAccountField, partner);
	getBankAccountHelper().loadBankAccountsByPartnerField(bankAccountField, partner);
    }

    protected void updateBankAccountField(XComboEdit bankAccountField, IPartnerTitle partner) {
	updateBankAccountField(bankAccountField, partner, false);
    }
    
    protected void updateBankAccountField(XComboEdit bankAccountField, IPartnerTitle partner, boolean isChangePartner) {
	
	boolean isDefaultLoad = updatePartnerableField(bankAccountField, partner, isChangePartner);
	
	if (isChangePartner) {
	    getBankAccountHelper().loadBankAccountsByPartnerField(bankAccountField, partner);
	}
	
	if (isDefaultLoad) {
	    bankAccountField.setValue(getBankAccountHelper().getBankAccount(partner));
	}
	
    }

    
    ////

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Organization
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void initOrganizationBankAccountField(final XComboEdit field) {
	this.organizationBankAccountField = field;
	if (field == null) {
	    return;
	}
	
	field.addLoadListener((new LoadListener() {
	    public void load(LoadEvent e) {
		if (!isUpdateForm) {
		    return;
		}
		field.setDataList(getBankAccountsByPartner(getDocumentOrganization()));
	    }
	}));

	
	field.addUpdateListener((new UpdateListener() {
	    public void update(UpdateEvent e) {
		onOrganizationBankAccountFieldAction();
	    }
	}));
	

	
    }
    
    protected void onOrganizationBankAccountFieldAction() {
	if (!organizationBankAccountField.isModify()) {
	    return;
	}
	updateBankAccountField(organizationBankAccountField, getDocumentOrganization());
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Partner
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void initPartnerBankAccountField(final XComboEdit field) {
	this.partnerBankAccountField = field;
	if (field == null) {
	    return;
	}

	field.addLoadListener((new LoadListener() {
	    public void load(LoadEvent e) {
		if (!isUpdateForm) {
		    return;
		}
		field.setDataList(getBankAccountsByPartner(getPartnerFieldValue()));
	    }
	}));
	
	field.addUpdateListener((new UpdateListener() {
	    public void update(UpdateEvent e) {
		onPartnerBankAccountFieldAction();
	    }
	}));
	
	
    }
    
    protected void onPartnerBankAccountFieldAction() {
	if (!partnerBankAccountField.isModify()) {
	    return;
	}
	updateBankAccountField(partnerBankAccountField, getPartnerFieldValue());
    }    
    

    ////
    
    
    protected void beforeUpdateForm() throws ApplicationException {
	isUpdateForm = false;
	super.beforeUpdateForm();
	loadBankAccountField(organizationBankAccountField, getDocumentOrganization());
	loadBankAccountField(partnerBankAccountField, getDocumentPartner());
    }
    
    protected void afterUpdateForm() throws ApplicationException {
	super.afterUpdateForm();
	isUpdateForm = true;
    }
      
    protected void initPartnerField(final XComboEdit partnerField) {
	super.initPartnerField(partnerField);
	partnerField.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		IPartnerTitle partner = (IPartnerTitle) partnerField.getValue();
		updateBankAccountField(partnerBankAccountField, partner, true);
	    }
	});
    }
    
    protected void initDocument() {
	BankEnvironment.initPaymentDocument(getPaymentDocument(), getEntityCode(), SessionEnvironment.getContext());
    }


    public BankAccountHelper getBankAccountHelper() {
	if (bankAccountHelper == null) {
	    final AbstractPaymentDocumentEditForm thisForm = this;
	    bankAccountHelper = new BankAccountHelper(new BankAccountHelperProvider() {
		
		public PartnerService getPartnerService() {
		    return thisForm.getPartnerService();
		}
		
		public BankAccountService getBankAccountService() {
		    return thisForm.getBankAccountService();
		}
		    
		public IPartnerTitle getDocumentOrganization() {
		    return thisForm.getDocumentOrganization();
		}
		    
		public IPartnerTitle getDocumentPartner() {
		    return thisForm.getDocumentPartner();
		}
	    });
	}
        return bankAccountHelper;
    }

    
 
    protected boolean isInvoiceReason() {
	return BankEnvironment.getContext().hasPaymentReasonDocument(BankContext.INVOICE_REASON_DOCUMENT);
    }
    
    protected boolean isOrderReason() {
	return BankEnvironment.getContext().hasPaymentReasonDocument(BankContext.ORDER_REASON_DOCUMENT);
    }

    protected boolean isInvoiceAndOrderReason() {
	return isInvoiceReason() && isOrderReason();
    }


    protected String getChooseReasonDocument() {
	List<Item> docs = new ArrayList<Item>();
	docs.add(new Item(BankContext.INVOICE_REASON_DOCUMENT, Messages.getString("PaymentDocumentEditForm.invoice")));
	docs.add(new Item(BankContext.ORDER_REASON_DOCUMENT, Messages.getString("PaymentDocumentEditForm.order")));
	Object doc = getChooseObject(docs);
	if (doc == null) {
	    return null;
	}
	return (String) ((Item) doc).getKey();
    }

    protected void updatePaymentDate(XDateCombo documentDateField, XDateCombo paymentDateField) {
	if (!equals(paymentDate, paymentDateField.getDate())) {
	    return;
	}
	if (equals(documentDate, documentDateField.getDate())) {
	    return;
	}
	documentDate = documentDateField.getDate();
	paymentDate = documentDate;
	paymentDateField.setDate(paymentDate);
    }
 
}
