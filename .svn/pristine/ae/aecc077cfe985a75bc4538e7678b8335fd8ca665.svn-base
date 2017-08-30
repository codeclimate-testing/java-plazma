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

package org.plazmaforge.bsolution.document.client.swt.forms;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.document.DocumentEnvironment;
import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.document.common.beans.DocumentStatus;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.bsolution.finance.common.beans.Contract;
import org.plazmaforge.bsolution.finance.common.beans.IPayReasonDocument;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.services.PartnerService;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.IDataListProvider;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AbstractDocumentEditForm.java,v 1.5 2010/12/05 07:57:19 ohapon Exp $
 */
public abstract class AbstractDocumentEditForm extends AbstractEditForm {

    private XComboEdit partnerField;
    private XComboEdit documentStatusField;
    
    public AbstractDocumentEditForm(Composite parent, int style) {
	super(parent, style);
    }


    /**
     * Returns the <code>Document</code>
     * @return
     */
    protected Document getDocument() {
        return (Document) this.getEntity();
    }
    
    protected DocumentType getDocumentType() {
	Document document = getDocument();
	if (document == null) {
	    return null;
	}
	return document.getDocumentType();
    }
  
    /**
     * Initialize data
     */
    protected void initData() throws ApplicationException {
        super.initData();
        initDocument();
    }
    

  

    /**
     * Initialize the <code>Document</code>
     *
     */
    protected void initDocument() {
	DocumentEnvironment.initDocument(getDocument(), getEntityCode(), getSessionContext());
    }
    
    protected OrganizationHeader getOrganization() {
	return EnterpriseEnvironment.getOrganization(getSessionContext());
    }
    
  
    protected boolean isIntertationalAttributes() {
	return EnterpriseEnvironment.isInternationalAttributes();
    }

    protected boolean isMultiCurrencies() {
	return EnterpriseEnvironment.isMultiCurrencies();
    }

    protected boolean isProjectInDocument() {
	return EnterpriseEnvironment.isProjectInDocument();
    }

    
    ////////////////////////////////////////////////////////////////////////////////////////
    
    protected void initPartnerField(XComboEdit partnerField) {
	partnerField.setAssociationValueClass(Partner.class);
	this.partnerField = partnerField;
    }

    protected void initContractDocumentField(XComboEdit contractDocumentField) {
	if (contractDocumentField == null) {
	    return;
	}
 	contractDocumentField.setDisplayValueProperty("title");
    	contractDocumentField.setAssociationValueClass(Contract.class);
   }
    
    protected void initReasonDocumentField(XComboEdit reasonDocumentField) {
	if (reasonDocumentField == null) {
	    return;
	}
    	reasonDocumentField.setDisplayValueProperty("title");
    	reasonDocumentField.setAssociationValueClass(Document.class);
    }    
    
    //
    
    protected void initDocumentStatusField(XComboEdit documentStatusField) {
	if (documentStatusField == null) {
	    return;
	}
	this.documentStatusField = documentStatusField;
	documentStatusField.setService(new StatusProvider());
	documentStatusField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    		updateDocumentStatus();
    	    }
    	});
    }    
    
    protected void initResponsibleField(XComboEdit responsibleField) {
	if (responsibleField == null) {
	    return;
	}
	responsibleField.setAssociationValueClass(Contact.class);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    protected OrganizationHeader getDocumentOrganization() {
	return getOrganization();
    }
    
    protected Integer getDocumentOrganizationId() {
	return getDocument().getOrganizationId();
    }

    
    
    
    protected IPartnerTitle getDocumentPartner() {
	return getDocument().getPartner();
    }
    
    protected Integer getDocumentPartnerId() {
	IPartnerTitle partner = getDocument().getPartner();
	if (partner == null) {
	    return null;
	}
	return partner.getId();
    }
    
    protected Integer getPartnerId(IPartnerTitle partner) {
	return partner == null ? null : partner.getId();
    }


    //
    
    protected boolean updatePartnerableField(XComboEdit field, IPartnerTitle partner, boolean isChangePartner) {
	if (field == null) {
	    return false;
	}
	Integer partnerId = null;
	if (partner != null) {
	    partnerId = partner.getId();
	}
	if (partnerId == null) {
	    field.setParentEntityId(null);
	    field.setParentEntity(null);
	    field.removeAll();
	    field.setEnabled(false);
	    return false;
	}
	
	boolean isRealChangePartner = !partnerId.equals(field.getParentEntityId());
	
	field.setParentEntityId(partnerId);
	field.setParentEntity(partner);
	if (!field.isEnabled()) {
	    field.setEnabled(true);
	}
	return isChangePartner && isRealChangePartner;
    }
    
    protected IPartnerTitle getPartnerFieldValue() {
	return partnerField == null ? null : (IPartnerTitle) partnerField.getValue();
    }

    //
    
    protected PartnerService getPartnerService() {
	return (PartnerService) getService(PartnerService.class);
    }

    protected boolean isUseNumerator() {
	DocumentType documenType = getDocumentType();
	return documenType == null ? false: documenType.isUseNumerator();
    }
    
    protected boolean isDocumentCodeReadOnly() {
	DocumentType documenType = getDocumentType();
	if (documenType == null) {
	    return false;
	}
	return documenType.isUseNumerator() && documenType.isDocumentNoReadOnly();
    }

    protected boolean isDocumentDateReadOnly() {
	DocumentType documenType = getDocumentType();
	if (documenType == null) {
	    return false;
	}
	return documenType.isDocumentDateReadOnly();
    }
    
    private class StatusProvider implements IDataListProvider<DocumentStatus> {
	
	public List<DocumentStatus> getDataList() throws ApplicationException {
	    return DocumentEnvironment.getDocumentStatusesByType(getEntityCode());
	}
    }

    protected void updateDocumentStatus() {
	if (documentStatusField == null) {
	    return;
	}
	updateDocumentStatus(getDocument(), (DocumentStatus) documentStatusField.getValue());
    }
    
    protected void updateDocumentStatus(Document document, DocumentStatus documentStatus) {
	updatePayReasonDocumentStatus(document, documentStatus);
    }
    
    protected void updatePayReasonDocumentStatus(Document document, DocumentStatus documentStatus) {
	if (document == null || !(document instanceof IPayReasonDocument)) {
	    return;
	}
	boolean isPaidStatus = documentStatus != null && DocumentStatus.PAID_STATUS.equals(documentStatus.getCode());
	((IPayReasonDocument) document).setPaid(isPaidStatus);
    }

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected SessionContext getSessionContext() {
	return SessionEnvironment.getContext();
    }

    public Integer getContextOrganizationId() {
	return EnterpriseEnvironment.getOrganizationId(getSessionContext());
    }

    public Integer getContextUserId() {
	return EnterpriseEnvironment.getUserId(getSessionContext());
    }
    
    public Integer getContextResponsibleId() {
	return EnterpriseEnvironment.getResponsibleId(getSessionContext());
    }

    public Integer getDefaultResponsibleId() {
	return EnterpriseEnvironment.getDefaultResponsibleId(getSessionContext());
    }

    public ContactTitle getDefaultResponsible() {
	return EnterpriseEnvironment.getDefaultResponsible(getSessionContext());
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
}
