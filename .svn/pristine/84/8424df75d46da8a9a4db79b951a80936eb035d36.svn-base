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
 * Created on 11.07.2007
 *
 */

package org.plazmaforge.bsolution.personality.client.swt.forms;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.personality.client.swt.forms.IPersonableForm;
import org.plazmaforge.bsolution.personality.common.beans.IPersonHeader;
import org.plazmaforge.bsolution.personality.common.services.PersonItemService;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.IOwnCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AbstractPersonableList.java,v 1.5 2010/12/05 07:57:19 ohapon Exp $
 */

public abstract class AbstractPersonableList extends AbstractListForm implements IPersonableForm, IOwnCriteriaImplementator {

    private Integer personId;
    
    public AbstractPersonableList(Composite parent, int style) {
	super(parent, style);
    }

    public Integer getPersonId() {
	if (personId == null) {
	    return getLocalPersonId();
	}
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    
    public IPersonHeader getPerson() {
	return (IPersonHeader) getParentEntity();
    }
    
    protected Integer getLocalPersonId() {
	Integer personId = (Integer) getParentEntityId();
	if (personId != null) {
	    return personId;
	}
	IPersonHeader person = getPerson();
	if (person == null) {
	    return null;
	}
	return person.getId();
    }
    
    /**
     * Get PersonItemService
     * @return
     */
    private PersonItemService getPersonItemService() {
	return (PersonItemService) getEntityService();
    }

    /**
     * Load data by Person ID
     */
    protected List loadDataList() throws ApplicationException {
	return getPersonItemService().findByPersonId(getPersonId());
	
    }
    
    protected List loadDataList(Criteria criteria) throws ApplicationException {
	return getPersonItemService().findByPersonId(getPersonId(), criteria);
    }

    /**
     * Get PersonableForm. Set Person ID
     */
    protected void initEditForm(IEditForm form) throws ApplicationException {
	super.initEditForm(form);
	if (form == null) {
	    return;
	}
	if (!(form instanceof IPersonableForm)) {
	    return;
	}
	((IPersonableForm) form).setPersonId(getPersonId());
    }
    

    protected String getTitleString() {
	return getPerson() == null ? null : getPerson().getName();
    }
    
}
