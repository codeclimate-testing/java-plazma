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
 * Created on 27.12.2007
 *
 */

package org.plazmaforge.bsolution.base.common;

/** 
 * @author Oleh Hapon
 * $Id: MoveConstants.java,v 1.3 2010/04/28 06:24:31 ohapon Exp $
 */

public interface MoveConstants {

    String NONE = "NONE";
    
    
    String REGISTER = "REGISTER";
    
    String REST = "REST";
    
    
    String INPUT = "INPUT";
    
    String OUTPUT = "OUTPUT";
    
    
    String ROTATE = "ROTATE";


    
    // Special constants for orders (sale, purchase)
    
    String ORDER_INPUT = "ORDER_INPUT";
    
    String ORDER_OUTPUT = "ORDER_OUTPUT";

    
    String[] ARRAY = {NONE, REGISTER, REST, INPUT, OUTPUT, ROTATE, ORDER_INPUT, ORDER_OUTPUT};
}
