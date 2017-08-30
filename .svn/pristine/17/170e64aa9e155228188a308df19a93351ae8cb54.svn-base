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

package org.plazmaforge.framework.datawarehouse.convert.dataexport.csv;


import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.type.Types;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractLineExporter;


/** 
 * @author Oleh Hapon
 * $Id: CSVExporter.java,v 1.8 2010/05/21 08:37:04 ohapon Exp $
 */

public class CSVExporter extends AbstractLineExporter {

    private boolean firstLine = true;
    
    
    protected String getLineDelimiter() {
	return getRecordDelimiter();
    }
    
    protected void exportColumnHeader() {
	exportHedearRow();
    }
   
    protected void exportHedearRow() {
	
	exportStartRow();

	int columnCount = getDataSet().getFieldCount();
	for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
	    DSField column = getDataSet().getField(columnIndex);
	    Object value = column.getDisplayName();
	    this.columnIndex = columnIndex;
	    exportHeaderCell(column, value);
	}
	
	exportEndRow();

    }
    
    protected void exportHeaderCell(DSField column, Object value) {
	int columnCount = getDataSet().getFieldCount();
	String text = value == null ? "" : value.toString();
	print(text);
	if (columnIndex < columnCount - 1) {
	    print(getFieldDelimiter());
	}
    }

    protected void exportRowCell(DSField column, Object value) {
	int columnCount = getDataSet().getFieldCount();
	String text = getFixedStringValue(columnIndex, value);
	print(text);
	if (columnIndex < columnCount - 1) {
	    print(getFieldDelimiter());
	}
    }
    
    protected void exportStartRow() {
	
	// Special fix because we have blank line before data
	
	if (firstLine) {
	    firstLine = false;
	    return;
	}
	println();
    }
    
    protected String getFileExt() {
	return ".csv";
    }
    
    protected String formatValue(DSField column, Object value) {
	String result = super.formatValue(column, value);
	if (result == null) {
	    return result;
	}
	if (isQuoteText() && isColumnType(column, Types.StringType)) {
	    return "'" + result + "'";
	}
	
	return result;
    }
    

}
