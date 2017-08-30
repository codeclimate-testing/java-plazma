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
 * Created on 24.06.2005
 *
 */
package org.plazmaforge.bsolution.contact.client.swing.forms;

import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.framework.client.swing.forms.EXTChildEditForm;
import org.plazmaforge.framework.resources.Resources;



/**
 * @author hapon
 *
 * AbstractContactableItemEdit form
 *
 */
public abstract class AbstractContactableItemEdit extends EXTChildEditForm implements ContactableItemEdit {

    
    
    public AbstractContactableItemEdit() {
        super();
    }
    
    public AbstractContactableItemEdit(Resources resources) {
        super(resources);
    }
    
    
    private ContactableElement contactable;

    
    public ContactableElement getContactable() {
        return contactable;
    }

    public void setContactable(ContactableElement contactable) {
        this.contactable = contactable;
    }
    
}
