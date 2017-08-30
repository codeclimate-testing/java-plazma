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

package org.plazmaforge.framework.datawarehouse.convert;

/**
 * The Configurer of Import/Export
 * 
 * @author ohapon
 *
 * $Id: IConfigurer.java,v 1.1 2010/05/15 12:02:01 ohapon Exp $
 */
public interface IConfigurer {
    
    String TABLE_NAME = "table.name";
    
    String TABLE_NAMES = "table.names";
    
    String DIRECTORY_NAME = "directory.name";
    
    String COLUMN_MAPPINGS = "column.mappings";
    
    String TRANSFER_ACTION = "transfer.action";
    
    String TRANSFER_CLEAR_TABLE = "transfer.clear.table";
    
    String TRANSFER_AUTOINCREMENT_PK = "transfer.autoincrement.pk";
    
    
    Object getProperty(String key);
    
    void getProperty(String key, Object value);

}
