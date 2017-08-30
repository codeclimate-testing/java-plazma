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
 * Created on 10.08.2007
 *
 */

package org.plazmaforge.framework.core.criteria;


/** 
 * @author Oleh Hapon
 * $Id: CriteriaSorter.java,v 1.1 2010/12/05 07:51:26 ohapon Exp $
 */

public class CriteriaSorter extends CriteriaElement implements ICriteriaSorter {

    private String order = ICriteria.ASC;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
	this.order = ICriteria.ASC.equals(order) ? ICriteria.ASC : ICriteria.DESC;
    }
    
    public boolean isDown() {
	return ICriteria.ASC.equals(order);
    }
    
    public void setDown(boolean down) {
	this.order = down ? ICriteria.ASC : ICriteria.DESC;
    }
    
    public int getOrderInt() {
	return ICriteria.ASC.equals(order) ? 1 : -1;
    }
}
