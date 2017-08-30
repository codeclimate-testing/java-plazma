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
 * Created on 11.09.2007
 *
 */

package org.plazmaforge.framework.datawarehouse.convert.dataexport.rtf;

import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractLineExporter;


/** 
 * @author Oleh Hapon
 * $Id: RTFExporter.java,v 1.3 2010/04/28 06:34:34 ohapon Exp $
 */

public class RTFExporter extends AbstractLineExporter {

    

    protected void exportStartBody() {
	print("{\\rtf1\\ansi\\deff0\n");
	// create font and color tables
	print("{\\fonttbl ");
	print("}\n");
	
	print("{\\colortbl ");
	print(";}\n");

    }
    
    protected void exportEndBody() {
	print("}\n");
    }
    
    
    protected void exportColumnHeader() {
	
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
	String text = value == null ? "" : value.toString();
	print("\\pard\\intbl");
	printUnicodeText(" " + text);
	print("\\cell");
    }
    
    
    protected void exportRowCell(DSField column, Object value) {
	String text = getFixedStringValue(columnIndex, value);
	print("\\pard\\intbl");
	//print(" " + text);
	printUnicodeText(" " + text);
	print("\\cell");
    }
    
    
    protected void exportStartRow() {
	print("\\trowd");
	

	int columnCount = getDataSet().getFieldCount();
	int w = 0;
	for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
	    DSField column = getDataSet().getField(columnIndex);
	    if (column != null /*&& column.getDisplaySize() > 0*/) {
		int displaySize = column.getDisplaySize();
		if (displaySize <= 0) {
		    displaySize = 1; // FIX 2009-01-26
		}
		w+= displaySize;
	    }
	    print("\\cellx" + w * 10);

	}
    }
    
    protected void exportEndRow() {
	print("\\pard\\intbl\\row");
    }
    
  
    protected String getFileExt() {
	return ".rtf";
    }
    
    
    private void printUnicodeText(String source) {
	StringBuffer resultBuffer = new StringBuffer();
	for (int i = 0; i < source.length(); i++) {
	    long ch = source.charAt(i);
	    if (ch > 127) {
		resultBuffer.append("\\u" + ch + '?');
		//resultBuffer.append('\\').append((char) ch);
	    } else {
		if (ch == '\n') {
		    resultBuffer.append("\\line ");
		} else if (ch == '\\' || ch == '{' || ch == '}') {
		    resultBuffer.append('\\').append((char) ch);
		} else {
		    resultBuffer.append((char) ch);
		}
	    }
	}
	print(resultBuffer.toString());
    }

    protected String getFileEncoding() {
	return null;
    }
}
