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
 * Created on 08.08.2007
 *
 */

package org.plazmaforge.framework.core.criteria;

/** 
 * @author Oleh Hapon
 * $Id: ICriteriaFilter.java,v 1.1 2010/12/05 07:51:26 ohapon Exp $
 */

public interface ICriteriaFilter extends ICriteriaElement {

    // AND, OR
    String getOperator();
    
    void setOperator(String operator);
    
    // =, <>, >=, <=, NULL, NOT NULL
    String getClause();
    
    void setClause(String clause);
    
    
    Object getValue();
    
    void setValue(Object value);
    
    Class getValueClass();

    void setValueClass(Class valueClass);
    
    String getValueString();

    void setValueString(String valueString);
    
    
    boolean isEmpty();
    
    boolean isFilter(Object inputValue);
    
    Object clone();
    
}
