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
package org.plazmaforge.bs.contact.shared.entities;

import org.plazmaforge.framework.ext.model.Dictionary;


/**
 * 
 * @author ohapon
 *
 */
public class LocalityType extends Dictionary {

    private static final long serialVersionUID = -8697357494893667122L;
    
    public static final Integer CITY = new Integer(1);

    public LocalityType() {
    }
    
    public LocalityType(Integer id) {
        setId(id);
    }
    
    public boolean isCity() {
	return CITY.equals(getId());
    }
}
