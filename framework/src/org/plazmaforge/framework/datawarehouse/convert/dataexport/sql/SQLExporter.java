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
 * Created on 10.09.2007
 *
 */

package org.plazmaforge.framework.datawarehouse.convert.dataexport.sql;


import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractLineExporter;


/** 
 * @author Oleh Hapon
 * $Id: SQLExporter.java,v 1.11 2010/05/21 08:37:04 ohapon Exp $
 */

public class SQLExporter extends AbstractLineExporter {

    
    
    protected void exportRowCell(DSField column, Object value) {
	int columnCount = getDataSet().getFieldCount();
	String text = getFixedStringValue(columnIndex, value);
	print(text);
	if (this.columnIndex < columnCount - 1) {
	    print(",");
	}
    }
    
    protected void exportStartRow() {
	println();
	String tableName = getDataSet().getName();
	print("INSERT INTO " + tableName + " (");
	
	int columnCount = getDataSet().getFieldCount();
	for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
	    DSField column = getDataSet().getField(columnIndex);
	    String columnName = column.getName(); 
	    print(columnName);
	    if (columnIndex < columnCount - 1) {
		print(", ");
	    }
	}
	
	print(") VALUES (");
    }
    
    protected void exportEndRow() {
	print(");");
    }
    
    protected String getFileExt() {
	return ".sql";
    }
    
    protected boolean isQuoteColumn(int columnIndex) {
	DSField column = getDataSet().getField(columnIndex);
	return isQuoteColumn(column);
    }
    
    protected boolean isQuoteColumn(DSField column) {
	String type = column.getDataType();
	if (type == null) {
	    return false;
	}
	return isLikeString(type); 
    }

    
    // ADD: 2010-05-19
    protected String formatValue(DSField column, Object value) {
	String result = super.formatValue(column, value);
	if (result == null) {
	    return result;
	}
	if (isQuoteColumn(column)) {
	    return "'" + result + "'";
	}
	return result;
    }

    
    public void setNumberPattern(String numberPattern) {
	throw new UnsupportedOperationException("setNumberPattern doesn't support");
	// Using 'Number Pattern' is not good idea to export to SQL format
    }
    
    protected boolean isNormalizeNumberFormat() {
	return true; // Always true for SQL Export
    }
}
