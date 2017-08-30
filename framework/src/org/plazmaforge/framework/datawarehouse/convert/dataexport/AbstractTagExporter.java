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

package org.plazmaforge.framework.datawarehouse.convert.dataexport;

import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.DSException;

/** 
 * @author Oleh Hapon
 * $Id: AbstractTagExporter.java,v 1.2 2010/04/28 06:34:36 ohapon Exp $
 */

public abstract class AbstractTagExporter extends AbstractExporter {
    
  
    
    
    
    protected String BODY_TAG = "table";
    
    protected String ROW_TAG = "tr";
    
    protected String HEADER_ROW_TAG = ROW_TAG;
    
    protected String CELL_TAG = "td";
    
    protected String HEADER_CELL_TAG = CELL_TAG;
    
    protected String TAG_TAB = " ";
	
  
    
    protected boolean isValid() {
	return super.isValid();
    }
    
 
    protected String getEmptyValue() {
	return EMPTY_VALUE;
    }

  

    // --------------------------------------- BODY -------------------------------------------------------------
    protected void exportBody() throws DSException {
	exportStartBody(); // START
	
	if (isIncludeHeaders()) exportColumnHeader();
	rowIndex = 0;
	while (getDataSet().next()) {
	    rowIndex++;
	    exportRow();
	}
	if (isIncludeHeaders()) exportColumnFooter();

	exportEndBody(); // END
    }

    protected void exportStartBody() {
	printStartTag(BODY_TAG);
    }
    
    protected void exportEndBody() {
	println();
	printEndTag(BODY_TAG);
	println();
    }

    
    // --------------------------------------- COLUMN HEADER -------------------------------------------------------    
    protected void exportColumnHeader() {

	exportStartColumnHeader();
	
	int columnCount = getDataSet().getFieldCount();
	for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
	    DSField column = getDataSet().getField(columnIndex);
	    String value = column.getDisplayName();
	    if (columnIndex == 0) {
		print(" ");
	    }
	    this.columnIndex = columnIndex;
	    exportHeaderCell(column, value);
	}

	exportEndColumnHeader();
    }
    
    protected void exportStartColumnHeader() {
	println();
	print(TAG_TAB);
	printStartTag(HEADER_ROW_TAG);
    }

    protected void exportEndColumnHeader() {
	println();
	print(TAG_TAB);
	printEndTag(HEADER_ROW_TAG);
    }

    protected void exportHeaderCell(DSField column, Object value) {
	String text = value == null ? getEmptyValue() : value.toString(); 
	if (columnIndex == 0) {
	    println();
	    print(TAG_TAB);
	    print(TAG_TAB);
	}
	printStartTag(HEADER_CELL_TAG, getHeaderCellAttributes(column, value));
	print(text);
	printEndTag(HEADER_CELL_TAG);
    }

    protected String getHeaderCellAttributes(DSField column, Object value) {
	return null;
    }
    
    protected void exportColumnFooter() {

    }

    
    protected void exportRow() throws DSException {

	exportStartRow();
	
	int columnCount = getDataSet().getFieldCount();
	Object[] values = getDataSet().getRecord();
	for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
	    DSField column = getDataSet().getField(columnIndex);
	    Object value = values[columnIndex];
	    if (columnIndex == 0) {
		print(" ");
	    }
	    this.columnIndex = columnIndex;
	    exportRowCell(column, value);
	}
	
	exportEndRow();
	onProcessDataRow();

    }

    protected void exportStartRow() {
	println();
	print(TAG_TAB);
	printStartTag(ROW_TAG);
    }
    
    protected void exportEndRow() {
	println();
	print(TAG_TAB);
	printEndTag(ROW_TAG);
    }

    protected void exportRowCell(DSField column, Object value) {
	String text = value == null ? getNullValue() : getStringValue(columnIndex, value);
	if (columnIndex == 0) {
	    println();
	    print(TAG_TAB);
	    print(TAG_TAB);
	}
	printStartTag(CELL_TAG, getRowCellAttributes(column, value));
	print(text);
	printEndTag(CELL_TAG);
    }
    
    protected String getRowCellAttributes(DSField column, Object value) {
	return null;
    }
  
    protected void printTag(String tag, String attributes) {
	printStartTag(tag, attributes);
    }

    protected void printStartTag(String tag, String attributes) {
	print("<" + tag + (attributes == null ? "" : " " + attributes.trim()) + ">");
    }

    protected void printStartTag(String tag) {
	printStartTag(tag, null);
    }
    
    protected void printEndTag(String tag) {
	print("</" + tag + ">");
    }

     
 


}
