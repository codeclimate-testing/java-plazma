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
 * Created on 06.07.2005
 *
 */
package org.plazmaforge.bsolution.personality.client.swing.forms;

import org.plazmaforge.bsolution.personality.common.beans.PersonableItem;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;




/**
 * @author hapon
 * 
 * AbstractPersonableEdit form for person's entity 
 */
public abstract class AbstractPersonableEdit extends EXTEditForm implements PersonableForm {

    /** Person ID **/
    private Integer personId;

    public AbstractPersonableEdit() {
	super();
    }

    public AbstractPersonableEdit(Resources resources) {
	super(resources);
    }

    public Integer getPersonId() {
	return personId;
    }

    public void setPersonId(Integer personId) {
	this.personId = personId;
    }

    protected void initData() throws ApplicationException {
	super.initData();
	((PersonableItem) this.getEntity()).setPersonId(this.getPersonId());
    }

}
