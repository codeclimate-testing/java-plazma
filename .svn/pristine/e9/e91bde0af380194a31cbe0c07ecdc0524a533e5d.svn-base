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
 * Created on 08.07.2005
 *
 */
package org.plazmaforge.bsolution.personality.client.swing.forms;

import java.awt.Window;

import org.plazmaforge.bsolution.personality.common.services.PersonItemService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;



/**
 * @author hapon
 * 
 * AbstractPersonableList for person's entity
 *
 */

public abstract class AbstractPersonableList extends EXTListForm implements
	PersonableForm {

    /** Person ID */
    private Integer personId;

    public AbstractPersonableList() {
	super();
    }

    public AbstractPersonableList(Resources resources) {
	super(resources);
    }

    public AbstractPersonableList(Window window, Resources resources) {
	super(window, resources);
    }

    /**
     * Get Person ID
     */
    public Integer getPersonId() {
	return personId;
    }

    /**
     * Set Person ID
     */
    public void setPersonId(Integer personId) {
	this.personId = personId;
    }

    /**
     * Get PersonItemService
     * @return
     */
    private PersonItemService getPersonItemService() {
	return (PersonItemService) this.getEntityService();
    }

    /**
     * Load data by Person ID
     */
    protected void loadData() throws ApplicationException {
	refreshTableModel(getPersonItemService().findByPersonId(getPersonId().intValue()));
    }

    /**
     * Get PersonableForm. Set Person ID
     */
    protected EditForm getEditForm() throws ApplicationException {
	EditForm form = super.getEditForm();
	((PersonableForm) form).setPersonId(this.getPersonId());
	return form;
    }

}
