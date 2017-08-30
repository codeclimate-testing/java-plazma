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
 * Created on 24.08.2007
 *
 */

package org.plazmaforge.framework.datawarehouse.convert.dataexport;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.Format;
import java.text.NumberFormat;

import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.convert.AbstractConverter;


/** 
 * @author Oleh Hapon
 * $Id: AbstractExporter.java,v 1.12 2010/12/05 07:51:24 ohapon Exp $
 */

public abstract class AbstractExporter extends AbstractConverter implements IExporter {

    
    protected int columnIndex = -1;
    
    protected int rowIndex = -1;
    
    /** Real row position. If no column header then rowPosition = rowIndex **/
    protected int rowPosition = -1;
    
    

    protected StringBuffer buf;
    
    


    
    
    public  void execute() throws ApplicationException {
	if (!isValid()) {
	    return;
	}
	init();
	
	//buf = new StringBuffer(); // migrate to 'createOutput()' method: 2010-05-13
	openOutput();
	
	exportMetaData();
	exportBody();
	
	flushOutput();
	closeOutput();
    }
    
    protected void openOutput() throws ApplicationException {
	buf = new StringBuffer();
    }

    
    protected void flushOutput() throws ApplicationException {
	Writer writer = null;
	try {
	    //OutputStream os = new FileOutputStream(getNormalizeFileName());
	    //writer = new OutputStreamWriter(os);
	    
	    writer = createWriter();
	    writer.write(buf.toString());
	    writer.flush();
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	} finally {
	    try {
		if (writer != null) {
		    writer.close();
		}
	    } catch (IOException ioe) {

	    }
	}
    }
    
    protected void closeOutput() throws ApplicationException {
	// do norhing
    }
    
    protected boolean isValid() {
	return getDataSet() != null;
    }

  
    
  
    protected void exportMetaData() throws ApplicationException {
	
    }
    
    protected void exportBody() throws ApplicationException {
	
    }
    
   
    ////
    
    protected void println() {
	println("");
    }
    
    protected void print(String str) {
	buf.append(str);
    }

    protected void println(String str) {
	buf.append(str);
	buf.append(DEFAULT_LINE_DELIMITER);
    }
    
    protected String getLineDelimiter() {
	return DEFAULT_LINE_DELIMITER;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
    //
    // Writer
    //
    ///////////////////////////////////////////////////////////////////////////////////
    
    protected FileOutputStream createFileOutputStream() throws ApplicationException {
	try {
	    return new FileOutputStream(getNormalizeFileName());
	} catch (FileNotFoundException ex) {
	    throw new ApplicationException(ex);
	}
    }
 
    protected OutputStream createOutputStream() throws ApplicationException {
	return createFileOutputStream();
    }
    
    protected Writer createWriter() throws ApplicationException {
	OutputStream os = createOutputStream();
	return createWriter(os, getFileEncoding());
    }
    
    protected Writer createWriter(OutputStream os, String fileEncoding) throws ApplicationException {
	if (fileEncoding == null) {
	    return createBufferedWriter(new OutputStreamWriter(os));
	}
	try {
	    return createBufferedWriter(new OutputStreamWriter(os, fileEncoding));
	} catch (UnsupportedEncodingException ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    protected BufferedWriter createBufferedWriter(Writer writer) throws ApplicationException {
	return new BufferedWriter(writer);
    }
    
    protected String getCannotModifyMessage() {
	return "Cannot modify '" + getSimpleName() + "' properties after data writing has started";
    }

    

    
    protected String getColumnType(int columnIndex) {
	if (getDataSet() == null) {
	    return null;
	}
	return getDataSet().getFieldType(columnIndex);
    }
    
    protected boolean isStringColumn(int columnIndex) {
	String type = getColumnType(columnIndex);
	return isString(type);
    }

    protected boolean isNumberColumn(int columnIndex) {
	String type = getColumnType(columnIndex);
	return isLikeNumber(type);
    }
    
    protected boolean isDateColumn(int columnIndex) {
	String type = getColumnType(columnIndex);
	return isDate(type);
    }
    
    protected boolean isTimeColumn(int columnIndex) {
	String type = getColumnType(columnIndex);
	return isTime(type);
    }
    
    protected boolean isTimestampColumn(int columnIndex) {
	String type = getColumnType(columnIndex);
	return isTimestamp(type);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    protected String getStringValue(int columnIndex, Object value) {
	if (value == null) {
	    return null;
	}
	DSField column = getDataSet().getField(columnIndex);
	return formatValue(column, value);
    }

    /**
     * Format value by column
     * @param column
     * @param value
     * @return
     */
    protected String formatValue(DSField column, Object value) {

	if (value == null) {
	    return null;
	}

	// Format value by pattern
	Format format = column.getFormat();
	if (format != null) {
	    return format.format(value);
	}

	
	String type = column.getDataType();
	if (type == null) {
	    return value.toString();
	}
	
	// Special hack
	if (column.getSize() > 0 && column.getScale() > 0 && isLikeDecimal(type)) {
	    int decimal = column.getScale();
	    NumberFormat numberFormat = getDecimalFormat(decimal);
	    if (numberFormat != null) {
		return numberFormat.format(value);
	    }
	}
	
	return formatValue(type, value);	

    }

    
    /**
     * Format value by class
     * @param type
     * @param value
     * @return
     */
    protected String formatValue(String type, Object value) {
	if (value == null) {
	    return null;
	}
	if (type == null) {
	    return value.toString();
	}

	if (isInteger(type)) {
	    return formatInteger(value);

	} else if (isLikeNumber(type)) {
	    return formatNumber(value);

	} else if (isTime(type)) {
	    return formatTime(value);
	    
	} else if (isTimestamp(type)) {
	    return formatTimestamp(value);
	    
	} else if (isDate(type)) {
	    return formatDate(value);
	}
	
	return value.toString();
    }
    
    
    protected String formatValue(Class valueClass, Object value) {
  	if (value == null) {
  	    return null;
  	}
  	if (valueClass == null) {
  	    return value.toString();
  	}

  	if (isIntegerNumber(valueClass)) {
  	    return formatInteger(value);

  	} else if (isNumber(valueClass)) {
  	    return formatNumber(value);

  	} else if (isTime(valueClass)) {
  	    return formatTime(value);
  	    
  	} else if (isTimestamp(valueClass)) {
  	    return formatTimestamp(value);
  	    
  	} else if (isDate(valueClass)) {
  	    return formatDate(value);
  	}
  	
  	return value.toString();
      }    
    protected String formatNumber(Object value) {
	return getNumberFormat().format(value);
    }

    protected String formatInteger(Object value) {
	return getIntegerFormat().format(value);
    }

    protected String formatTime(Object value) {
	return getTimeFormat().format(value); // TODO: Disable. Must analyze
	//return value.toString();
    }
    
    protected String formatTimestamp(Object value) {
	return getTimestampFormat().format(value); // TODO: Disable. Must analyze
	//return value.toString();
    }
    

    protected String formatDate(Object value) {
	return getDateFormat().format(value);
    }
    
    
    protected String getFixedStringValue(int columnIndex, Object value) {
	return getFixedString(getStringValue(columnIndex, value));
    }
    
    protected String getFixedString(String str) {
	//ADD : 2010-05-19
	if (str != null && isTrim()) {
	    str = str.trim();
	}
	return str == null ? getNullValue(): str;
    }
    
       

    protected void onProcessDataRow() {
	countDataRow();
    }

    
    
    
}
