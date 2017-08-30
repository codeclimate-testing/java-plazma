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

package org.plazmaforge.bsolution.organization.client.swt.forms;


import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.finance.common.beans.Contract;
import org.plazmaforge.bsolution.organization.OrganizationEnvironment;
import org.plazmaforge.bsolution.organization.common.beans.IOrganizable;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: AbstractOrganizableEditForm.java,v 1.4 2010/12/05 07:57:22 ohapon Exp $
 */

public abstract class AbstractOrganizableEditForm extends AbstractEditForm implements IOrganizableForm {

    
    public AbstractOrganizableEditForm(Composite parent, int style) {
	super(parent, style);
    }

    public Integer getOrganizationId() {
        return getOrganizable() == null ? null : getOrganizable().getOrganizationId();
    }

    /**
     * Returns the <code>Organizable</code>
     * @return
     */
    protected IOrganizable getOrganizable() {
        return (IOrganizable) getEntity();
    }
    

    /**
     * Initialize data
     */
    protected void initData() throws ApplicationException {
        super.initData();
        OrganizationEnvironment.initOrganizable(getOrganizable(), getSessionContext());
    }
    
    protected void initPartnerField(XComboEdit partnerField) {
	partnerField.setAssociationValueClass(Partner.class);
    }
    
    // See AbstractDocumentEditForm
    
    protected void initContractField(XComboEdit contractField) {
	if (contractField == null) {
	    return;
	}
 	contractField.setDisplayValueProperty("title");
    	contractField.setAssociationValueClass(Contract.class);
   }
    
   // See AbstractDocumentEditForm
    
    protected void initDocumentField(XComboEdit documentField) {
	if (documentField == null) {
	    return;
	}
    	documentField.setDisplayValueProperty("title");
    	documentField.setAssociationValueClass(Document.class);
    }    
    
    protected void initResponsibleField(XComboEdit responsibleField) {
	if (responsibleField == null) {
	    return;
	}
	responsibleField.setAssociationValueClass(Contact.class);
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