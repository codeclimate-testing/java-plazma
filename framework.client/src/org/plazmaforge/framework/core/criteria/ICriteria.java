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

import java.io.Serializable;

/** 
 * @author Oleh Hapon
 * $Id: ICriteria.java,v 1.1 2010/12/05 07:51:26 ohapon Exp $
 */

public interface ICriteria extends Serializable {

    String CRITERIA = "CRITERIA";
    
    /**
     * Ascending sort order.
     */
    String ASC = "ASC";

    /**
     * Descending sort order.
     */
    String DESC = "DESC";

    /**
     * Operator
     */
    String AND = "AND";
    String OR = "OR";
    
    /**
     * Clause
     */
    String EQ = "=";
    String NEQ = "<>";
    String LIKE = "LIKE";
    String NOTLIKE = "NOT LIKE";
    String LT = "<";
    String LTE = "<=";
    String GT = ">";
    String GTE = ">=";
    String IN = "IN";
    String NIN = "NOT IN";
    String ISNULL = "IS NULL";
    String ISNOTNULL = "IS NOT NULL";

    
    
    CriteriaFilterSet getFilterSet();

    void setFilterSet(CriteriaFilterSet filterSet);

    CriteriaSorterSet getSorterSet();

    void setSorterSet(CriteriaSorterSet sorterSet);

    
    
    int getFrom();
    
    void setFrom(int from);
    
    int getSize();
    
    void setSize(int size);
    
    
    boolean isPaging();
    
    boolean hasFilter();
    
    boolean hasSorter();
    
}