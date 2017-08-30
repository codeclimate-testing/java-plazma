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
 * Created on 12.06.2007
 *
 */

package org.plazmaforge.bsolution.partner.client.swt.forms;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.partner.common.services.PartnerableService;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.IOwnCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AbstractPartnerableListForm.java,v 1.5 2010/12/05 07:57:19 ohapon Exp $
 */

public abstract class AbstractPartnerableListForm extends AbstractListForm implements IOwnCriteriaImplementator {

    public AbstractPartnerableListForm(Composite parent, int style) {
	super(parent, style);
    }
    
    public IPartnerTitle getPartner() {
	return (IPartnerTitle) getParentEntity();
    }

    protected PartnerableService getPartnerableService() {
        return (PartnerableService) getEntityService();
    }
    
    protected Integer getPartnerId() {
	Integer partnerId = (Integer) getParentEntityId();
	if (partnerId != null) {
	    return partnerId;
	}
	IPartnerTitle partner = getPartner();
	if (partner == null) {
	    return null;
	}
	return partner.getId();
    }
    
    protected List loadDataList() throws ApplicationException {
	Integer partnerId = getPartnerId();
	if (partnerId == null) {
	    return null;
	}
        return getPartnerableService().findByPartnerId(partnerId);
    }
    
    protected List loadDataList(Criteria criteria) throws ApplicationException {
	Integer partnerId = getPartnerId();
	if (partnerId == null) {
	    return null;
	}
        return getPartnerableService().findByPartnerId(partnerId, criteria);
    }
    
    
    protected String getTitleString() {
	return getPartner() == null ? null : getPartner().getName();
    }
}
