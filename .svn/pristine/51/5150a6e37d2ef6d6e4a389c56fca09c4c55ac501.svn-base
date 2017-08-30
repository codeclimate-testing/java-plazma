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

package org.plazmaforge.bsolution.personality.common.beans;


import java.util.Date;

/**
 * @author Oleh Hapon
 * Date: 26.09.2004
 * Time: 14:46:44
 * $Id: PersonFamily.java,v 1.2 2010/04/28 06:24:20 ohapon Exp $
 */
public class PersonFamily extends AbstractPersonableItem {

    private Familiarity familiarity;
    private String name;
    private Date  birthDate;


    public Familiarity getFamiliarity() {
        return familiarity;
    }
    
    public void setFamiliarity(Familiarity familiarity) {
        this.familiarity = familiarity;
    }
    
    public String getFamiliarityName() {
        return getFamiliarity() == null ? null : getFamiliarity().getName();
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


}
