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
 * $Id: AbstractLineExporter.java,v 1.2 2010/04/28 06:34:36 ohapon Exp $
 */

public abstract class AbstractLineExporter extends AbstractExporter {

    
       
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
    
    protected void exportColumnHeader() {
	
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
	    this.columnIndex = columnIndex;
	    exportRowCell(column, value);
	}
	
	exportEndRow();
	onProcessDataRow();

    }
    
    protected void exportRowCell(DSField column, Object value) {
	//
    }
    
    protected void exportStartRow() {
    }
    
    protected void exportEndRow() {
    }
    
    protected void exportStartBody() {
	//
    }
    
    protected void exportEndBody() {
	//
    }

  
}
