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

package org.plazmaforge.bsolution.contact.common.beans;

import org.plazmaforge.bsolution.organization.common.beans.IOrganizable;

public interface IContactHeader extends IOrganizable {

    void setCode(String code);

    Byte getGender();

    void setGender(Byte gender);
    
    String getName();

    void setName(String name);

    String getFirstName();

    void setFirstName(String firstName) ;

    String getLastName() ;

    void setLastName(String lastName) ;

    String getMiddleName() ;

    void setMiddleName(String middleName) ;
    
    String getTitleName();

    void setTitleName(String titleName);
}
