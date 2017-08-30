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
 * Created on 30.11.2003
 *
 */
package org.plazmaforge.framework.util;

import javax.swing.table.TableModel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Export Utilities
 * 
 * @author Oleh Hapon
 */
public class ExportUtils {

    /**
     * Export <code>TableModel</code> to CSV
     * 
     * @param data
     * @param fileName
     * @param colDelim
     * @param strQuote
     * @throws IOException
     */
    public static void exportCSV(TableModel data, String fileName,
	    String colDelim, String strQuote) throws IOException {

	BufferedWriter w = null;
	try {
	    int colCount = data.getColumnCount();
	    int rowCount = data.getRowCount();
	    w = new BufferedWriter(new FileWriter(fileName));
	    StringBuffer buf = new StringBuffer();
	    for (int row = 0; row < rowCount; row++) {
		StringBuffer rb = new StringBuffer();
		for (int col = 0; col < colCount; col++) {
		    Object val = data.getValueAt(row, col);
		    if (col > 0)
			rb.append(colDelim);
		    if (val instanceof String) {
			rb.append(strQuote);
			rb.append(replaceSpecSymbol((String) val));
			rb.append(strQuote);
		    } else {
			rb.append(val);
		    }
		}
		buf.append(rb);
		buf.append('\n');
	    }
	    w.write(buf.toString());
	    w.flush();
	} finally {
	    try {
		if (w != null) {
		    w.close();
		}
	    } catch (IOException ex) {
		//
	    }
	}
    }

    /**
     * Export <code>TableModel</code> to XML
     * 
     * @param data
     * @param fileName
     * @param tableTag
     * @param rowTag
     * @param colTag
     * @throws IOException
     */
    public static void exportXML(TableModel data, String fileName,
	    String tableTag, String rowTag, String colTag) throws IOException {

	BufferedWriter w = null;
	try {
	    int colCount = data.getColumnCount();
	    int rowCount = data.getRowCount();

	    w = new BufferedWriter(new FileWriter(fileName));
	    StringBuffer buf = new StringBuffer();
	    if (!StringUtils.isEmpty(tableTag)) {
		buf.append("<");
		buf.append(tableTag);
		buf.append(">");
	    }
	    for (int row = 0; row < rowCount; row++) {
		StringBuffer rb = new StringBuffer();
		buf.append("\n<");
		buf.append(rowTag);
		buf.append(">");

		for (int col = 0; col < colCount; col++) {
		    if (col == 0) {
			rb.append("\n ");
		    }
		    rb.append("<");
		    rb.append(colTag);
		    rb.append(">");

		    Object val = data.getValueAt(row, col);
		    rb.append(val);

		    rb.append("</");
		    rb.append(colTag);
		    rb.append(">");
		}
		buf.append(rb);
		buf.append("\n</");
		buf.append(rowTag);
		buf.append(">");
	    }
	    if (!StringUtils.isEmpty(tableTag)) {
		buf.append("\n</");
		buf.append(tableTag);
		buf.append(">");
	    }
	    w.write(buf.toString());
	    w.flush();
	} finally {
	    try {
		if (w != null) {
		    w.close();
		}
	    } catch (IOException ex) {
		//
	    }
	}
    }

    private static String replaceSpecSymbol(String str) {
	if (str == null)
	    return null;
	StringBuffer buf = new StringBuffer();
	int len = str.length();
	for (int i = 0; i < len; i++) {
	    char ch = str.charAt(i);
	    if (ch == '\n') {
		buf.append("\\n");
	    } else if (ch == '\t') {
		buf.append("\\t");
	    } else if (ch == '\r') {
		buf.append("\\r");
	    } else if (ch == '\b') {
		buf.append("\\b");
	    } else {
		buf.append(ch);
	    }
	}
	return buf.toString();
    }

}
