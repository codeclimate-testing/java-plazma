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

package org.plazmaforge.framework.datawarehouse.convert.dataexport.xls;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.DSException;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractExporter;


/** 
 * @author Oleh Hapon
 * $Id: XLSExporter.java,v 1.6 2010/12/05 07:51:34 ohapon Exp $
 */

public class XLSExporter extends AbstractExporter {

    protected HSSFWorkbook workbook;

    protected HSSFSheet sheet;

    protected HSSFRow row;

    protected HSSFCell cell;

    protected HSSFCellStyle emptyCellStyle;

    
    
    public  void execute() throws ApplicationException {
	if (!isValid()) {
	    return;
	}
	
	try {
	    init();

	    openWorkbook();
	    exportBody();
	    closeWorkbook();

	} catch (Exception ex) {
	    if (ex instanceof ApplicationException){
		throw (ApplicationException) ex;
	    }
	    throw new ApplicationException(ex);
	}
    }
    
    public String getFileExt() {
	return ".xls";
    }
    
    protected void openWorkbook() {
	workbook = new HSSFWorkbook();
	emptyCellStyle = workbook.createCellStyle();
	emptyCellStyle.setFillForegroundColor((new HSSFColor.WHITE()).getIndex());
	// emptyCellStyle.setFillPattern(backgroundMode);
	// dataFormat = workbook.createDataFormat();
	
	//createSheet(getDataSet().getDisplayName());
	createSheet(getDataSetDisplayName());
	
    }

    protected void createSheet(String name) {
	sheet = workbook.createSheet(name);
    }

    protected void exportBody() throws DSException {
	
	if (isIncludeHeaders()) exportColumnHeader();
	rowIndex = 0;
	while (getDataSet().next()) {
	    rowIndex++;
	    rowPosition++;
	    row = sheet.createRow(rowPosition);
	    exportRow();
	}
	
	if (isIncludeHeaders()) exportColumnFooter();
    }
    
    private boolean isInitColumnHeader = false;
    protected void exportColumnHeader() {
//	if (!isInitColumnHeader) {
//	    return;
//	}
	isInitColumnHeader = true;
	this.rowPosition++;
	row = sheet.createRow(rowPosition);
	int columnCount = getDataSet().getFieldCount();
	for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
	    DSField column = getDataSet().getField(columnIndex);
	    String value = column.getDisplayName();
	    this.columnIndex = columnIndex;
	    exportHeaderCell(column, value);
	}	
    }
    
    protected void exportColumnFooter() {
	
    }
    
    protected void exportHeaderCell(DSField column, Object value) {
	cell = row.createCell((short) columnIndex);
	//cell.setEncoding(HSSFCell.ENCODING_UTF_16); TODO: POI-3.6
	
	if (column.getDisplaySize() > 0) {
	    sheet.setColumnWidth((short) columnIndex, (short) (column.getDisplaySize() * 20)); 
	}
	String text = value == null ? null : value.toString();
	if (text != null) {
	    cell.setCellValue(text);
	}
    }
    
    protected void exportRow() throws DSException {
	int columnCount = getDataSet().getFieldCount();
	Object[] values = getDataSet().getRecord();
	for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
	    DSField column = getDataSet().getField(columnIndex);
	    Object value = values[columnIndex];
	    this.columnIndex = columnIndex;
	    exportRowCell(column, value);
	}
	onProcessDataRow();
    }
    
    protected void exportRowCell(DSField column, Object value) {
	cell = row.createCell((short) columnIndex);
	//cell.setEncoding(HSSFCell.ENCODING_UTF_16); TODO: POI-3.6
	
//	if (!isInitColumnHeader && rowIndex == 0) {
//	    if (column.getDisplaySize() > 0) {
//		sheet.setColumnWidth((short) columnIndex, (short) column.getDisplaySize()); 
//	    } 
//	}
	setCellValue(cell, value);
    }
    
    protected void setCellValue(HSSFCell cell, Object value) {
	if (value == null ) {
	    return;
	}
	
	if (isNumberColumn(columnIndex)) {
	    double doubleValue = ((Number) value).doubleValue();
	    cell.setCellValue(doubleValue);
	    return;
	}
	
	if (isDateColumn(columnIndex)) {
	    Date dateValue = (Date) value;
	    cell.setCellValue(dateValue);
	    return;
	}
	
	String text = getStringValue(columnIndex, value);
	if (text != null) {
	    cell.setCellValue(text);
	}
	
    }
    
    protected void closeWorkbook() throws ApplicationException {
	OutputStream os = null;
	try {
	    os = new FileOutputStream(getNormalizeFileName());
	    workbook.write(os);
	    os.flush();
	} catch (IOException e) {
	    throw new ApplicationException("Error generating XLS file", e);
	} finally {
	    if (os != null) {
		try {
		    os.close();
		} catch (IOException e) {
		    //
		}
	    }
	}
    }
    
    
    protected String getFileEncoding() {
	return null;
    }

}
