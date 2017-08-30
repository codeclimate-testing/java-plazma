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

package org.plazmaforge.framework.datawarehouse.convert.dataimport.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.plazmaforge.framework.core.datastorage.DSArrayDataSet;
import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.type.Types;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.AbstractImporter;

/**
 * 
 * @author Oleh Hapon
 * $Id: CSVImporter.java,v 1.15 2010/12/05 07:51:32 ohapon Exp $
 */
public class CSVImporter extends AbstractImporter {
    
    public static final String COLUMN_PREFIX = "COLUMN_";
    
    ///////////////////////////////////////////////////////////////
    
    private Map<String, Integer> columnNames = new LinkedHashMap<String, Integer>();

    private List<String> values;

    private char buffer[] = new char[1024];
    private int position;
    private int bufSize;
    
    // Only for loading default columns
    private int startColumnIndex = 1;
    
    public CSVImporter() {
    }

    

    protected String getFileExt() {
	return ".csv";
    }
    
    protected void importMetaData() throws ApplicationException {
	DSArrayDataSet dataSet = new DSArrayDataSet();
	setDataSet(dataSet);
	
    }
    
    protected boolean isBlankRow() {
	if (values == null || values.isEmpty()) {
	    return true;
	}
	if (values.size() == 1) {
	    if (isEmpty(values.get(0))) {
		return true;
	    }
	}
	return false;
    }
    
    protected void importBody() throws ApplicationException {
	DSArrayDataSet dataSet = (DSArrayDataSet) getDataSet();
	boolean initDataSetColumns = false;
	boolean firstRow = true;
	int columnCount = 0;
	List<Object[]> rows = new ArrayList<Object[]>();
	while (next()) {
	    
	    // Initialize columns
	    if (firstRow) {
		
		while (true) {
		    if (!isBlankRow()) {
			if (columnNames.isEmpty()) {
			    loadDefaultColumns(); 
			}
			initDataSetColumns(dataSet);
			columnCount = dataSet.getFieldCount();
			initDataSetColumns = true;
			firstRow = false;
			break;
		    }
		    if (!next()) {
			break;
		    }
		}
	    }
	    
	    if (firstRow) {
		break;
	    }
	    
	    Object values[] = new Object[columnCount];
	    for (int i = 0; i < columnCount; i++) {
		int columnIndex = i;
		DSField column = dataSet.getField(columnIndex);
		Object val = getValue(column.getName(), column.getDataType());
		values[i] =  val;
	    }
	    rows.add(values);
	    
	}
	
	if (!initDataSetColumns) {
	    initDataSetColumns(dataSet);
	}
	
	dataSet.setData(rows);
    }
    
    protected void initDataSetColumns(DSArrayDataSet dataSet) {
	Set<Map.Entry<String, Integer>> cls = columnNames.entrySet();
	List<DSField> columns = new ArrayList<DSField>();
	for (Map.Entry<String, Integer> c : cls) {
	    String columnName = c.getKey();
	    Integer columnIndex = c.getValue();

	    DSField column = new DSField();
	    column.setName(columnName);
	    column.setCaption(columnName);

	    //TODO: WHY!!!
	    column.setDataType(Types.StringType);

	    columns.add(column);
	}

	dataSet.setFields(columns);

    }    

   
    protected /*boolean*/ void moveFirst() throws ApplicationException {
	if (isProcessingStarted()) {
	    return /*false*/;
	}
	if (!next()) {
	    return /*false*/;
	}
	
	while (true) {
	    if (!isBlankRow()) {
		
		// If columns was setting then return
		if (!columnNames.isEmpty()) {
		    return;
		}
		
		if (isUseFirstRowAsHeader()) {
		    loadHeaderColumns();
		} else {
		    loadDefaultColumns();
		}
		
		//if (columnNames.isEmpty()) {
		//    loadDefaultColumns(); 
		//}
		
		return /*true*/;
	    }
	    if (!next()) {
		return /*false*/;
	    }
	}
    }
    
    public String[] loadColumns() throws ApplicationException {
	if (isProcessingStarted()) {
	    throw new ApplicationException("Can not loading columns because process was started");
	}
	if (!isValid()) {
	    return new String[0];
	}
	init();
	
	openInput();
	
	/*boolean flag = */moveFirst();
	
	closeInput();
	
	//if (!flag) {
	//    return new String[0];
	//}
	
	return getColumnNames();
    }
    
    protected void loadDefaultColumns() {
	columnNames.clear();
	if (values == null) {
	    return;
	}
	int k = 0;
	for (int i = 0; i < values.size(); i++) {
	    k = i + getStartColumnIndex();
	    String name = COLUMN_PREFIX + k;
	    this.columnNames.put(name, new Integer(i));
	}
    }    
    
    protected void loadHeaderColumns() {
	columnNames.clear();
	for (int i = 0; i < values.size(); i++) {
	    String name = (String) values.get(i);
	    this.columnNames.put(name, new Integer(i));
	}
    }

    public boolean next() throws ApplicationException {
	try {
	    if (!isProcessingStarted()) {
		if (isUseFirstRowAsHeader()) {
		    
		    // oha
		    boolean hasRow = parseRow();
		    if (!hasRow) {
			setProcessingStarted();
			return false;
		    }
		    
		    
		    //////////////////////////////////
		    if (!columnNames.isEmpty()) {
			setProcessingStarted();
			return parseRow();
		    }
		    /////////////////////////////////
		    

		    // Ignore blank row at top
		    if (!isBlankRow()) {
			loadHeaderColumns();
			
			//for (int i = 0; i < values.size(); i++) {
			//    String name = (String) values.get(i);
			//    this.columnNames.put(name, new Integer(i));
			//}
			
			setProcessingStarted();
		    }

		} else {
		    setProcessingStarted();
		}
		
	    }

	    return parseRow();
	} catch (IOException e) {
	    throw new ApplicationException(e);
	}
    }

    public Object getValue(String column, String type) throws ApplicationException {

	Integer columnIndex = (Integer) columnNames.get(column);
	if (columnIndex == null && column.startsWith(COLUMN_PREFIX)) {
	    columnIndex = Integer.valueOf(column.substring(COLUMN_PREFIX.length())); // 7
	    columnIndex = columnIndex - getStartColumnIndex(); //oha
	}
	if (columnIndex == null)
	    throw new ApplicationException("Unknown column name : " + column);

	if (values.size() > columnIndex.intValue()) {
	    String value = (String) values.get(columnIndex.intValue());
	    try {
		return convert(value, type);
	    } catch (Exception e) {
		throw new ApplicationException("Unable to get value for column '" + column + "' of type '" + type + "'", e);
	    }
	}
	return null;
    }
	
    

    /**
     * Parses a row of CSV data and extracts the fields it contains
     */
    private boolean parseRow() throws IOException {
	int pos = 0;
	int startFieldPos = 0;
	boolean insideQuotes = false;
	boolean hadQuotes = false;
	boolean misplacedQuote = false;
	char c;
	values = new ArrayList<String>();

	String row = getRow();
	if (row == null)// || row.length() == 0)
	    return false;

	while (pos < row.length()) {
	    c = row.charAt(pos);

	    if (c == '"') {
		// already inside a text containing quotes
		if (!insideQuotes) {
		    if (!hadQuotes) {
			insideQuotes = true;
			hadQuotes = true;
		    } else
			// the field contains a bad string, like
			// "fo"o", instead of "fo""o"
			misplacedQuote = true;
		}
		// found a quote when already inside quotes, expecting two
		// consecutive quotes, otherwise it means
		// it's a closing quote
		else {
		    if (pos + 1 < row.length() && row.charAt(pos + 1) == '"')
			pos++;
		    else
			insideQuotes = false;
		}
	    }
	    // field delimiter found, copy the field contents to the field array
	    if (c == getFieldDelimiterChar() && !insideQuotes) {
		String field = row.substring(startFieldPos, pos);
		// if an illegal quote was found, the entire field is considered
		// illegal
		if (misplacedQuote) {
		    misplacedQuote = false;
		    hadQuotes = false;
		    field = "";
		}
		// if the field was between quotes, remove them and turn any
		// escaped quotes inside the text into normal quotes
		else if (hadQuotes) {
		    field = field.trim();
		    if (field.startsWith("\"") && field.endsWith("\"")) {
			field = field.substring(1, field.length() - 1);
			field = replaceAll(field, "\"\"", "\"");
		    } else
			field = "";
		    hadQuotes = false;
		}

		values.add(field);
		startFieldPos = pos + 1;
	    }

	    pos++;
	    // if the record delimiter was found inside a quoted field, it is
	    // not an actual record delimiter,
	    // so another line should be read
	    if ((pos == row.length()) && insideQuotes) {
		row = row + getRecordDelimiter() + getRow();
	    }
	}

	// end of row was reached, so the final characters form the last field
	// in the record
	String field = row.substring(startFieldPos, pos);
	if (field == null)
	    return true;

	if (misplacedQuote)
	    field = "";
	else if (hadQuotes) {
	    field = field.trim();
	    if (field.startsWith("\"") && field.endsWith("\"")) {
		field = field.substring(1, field.length() - 1);
		field = replaceAll(field, "\"\"", "\"");
	    } else
		field = "";
	}
	values.add(field);

	return true;
    }

    /**
     * Reads a row from the stream. A row is a sequence of characters separated
     * by the record delimiter.
     */
    private String getRow() throws IOException {
	StringBuffer row = new StringBuffer();
	char c;

	while (true) {
	    try {
		c = getChar();

		// searches for the first character of the record delimiter
		if (c == getRecordDelimiter().charAt(0)) {
		    int i;
		    char[] temp = new char[getRecordDelimiter().length()];
		    temp[0] = c;
		    boolean isDelimiter = true;
		    // checks if the following characters in the stream form the
		    // record delimiter
		    for (i = 1; i < getRecordDelimiter().length() && isDelimiter; i++) {
			temp[i] = getChar();
			if (temp[i] != getRecordDelimiter().charAt(i))
			    isDelimiter = false;
		    }

		    if (isDelimiter)
			return row.toString();

		    row.append(temp, 0, i);
		}

		row.append(c);
	    } catch (ApplicationException e) {
		if (row.length() == 0) {
		    return null;
		} else {
		    return row.toString();
		}
	    }

	} // end while
    }

    /**
     * Reads a character from the stream.
     * 
     * @throws IOException if any I/O error occurs
     * @throws ApplicationException if end of stream has been reached
     */
    private char getChar() throws IOException, ApplicationException {
	// end of buffer, fill a new buffer
	if (position + 1 > bufSize) {
	    bufSize = reader.read(buffer);
	    position = 0;
	    if (bufSize == -1)
		throw new ApplicationException("No more chars");
	}

	return buffer[position++];
    }

    /**
     * Specifies an array of strings representing column names matching field
     * names in the report template
     */
    public void setColumnNames(String[] columnNames) {
	if (isProcessingStarted()) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
	if (columnNames == null) {
	    this.columnNames.clear();
	    return;
	}
	for (int i = 0; i < columnNames.length; i++)
	    this.columnNames.put(columnNames[i], new Integer(i));
    }

    public String[] getColumnNames() {
	return (String[]) this.columnNames.keySet().toArray(new String[0]);
    }

    private String replaceAll(String string, String substring, String replacement) {
	StringBuffer result = new StringBuffer();
	int index = string.indexOf(substring);
	int oldIndex = 0;
	while (index >= 0) {
	    result.append(string.substring(oldIndex, index));
	    result.append(replacement);
	    index += substring.length();
	    oldIndex = index;

	    index = string.indexOf(substring, index);
	}

	if (oldIndex < string.length())
	    result.append(string.substring(oldIndex, string.length()));

	return result.toString();
    }

    public List<String> getRowValues() {
	return values;
    }



    public int getStartColumnIndex() {
        return startColumnIndex;
    }



    public void setStartColumnIndex(int startColumnIndex) {
	if (startColumnIndex < 0 || startColumnIndex > 1) {
	    throw new IllegalArgumentException("Index must be 0 or 1");
	}
        this.startColumnIndex = startColumnIndex;
    }

    ////
    
    
}
