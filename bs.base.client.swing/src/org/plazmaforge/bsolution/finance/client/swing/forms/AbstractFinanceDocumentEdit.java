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
 * Created on 24.07.2005
 *
 */
package org.plazmaforge.bsolution.finance.client.swing.forms;

import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentEdit;
import org.plazmaforge.bsolution.finance.FinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerableForm;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerHeader;
import org.plazmaforge.framework.client.swing.forms.Form;
import org.plazmaforge.framework.resources.Resources;


/**
 * @author hapon
 * 
 */
public abstract class AbstractFinanceDocumentEdit extends AbstractDocumentEdit {

    public AbstractFinanceDocumentEdit() {
	super();
    }

    public AbstractFinanceDocumentEdit(Resources resources) {
	super(resources);
    }

    protected FinanceDocument getFinanceDocument() {
	return (FinanceDocument) this.getDocument();
    }

    /**
     * Initialize Document
     */
    protected void initDocument() {
	FinanceEnvironment.initFinanceDocument(getFinanceDocument(), getEntityCode(), getEnterpriseContext());
    }

    /**
     * Initialize PartnerableForm
     * 
     * @param form
     * @param partner
     */
    protected void initPartnerableForm(Form form, IPartnerHeader partner) {
	PartnerableForm partnerableForm = (PartnerableForm) form;
	partnerableForm.setPartner(partner);
    }

}
