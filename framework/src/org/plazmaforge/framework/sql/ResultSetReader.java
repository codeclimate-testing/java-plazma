/*
 * Created on 10.01.2004
 *
 */
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

package org.plazmaforge.framework.sql;

import java.sql.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Oleh Hapon $Id: ResultSetReader.java,v 1.2 2010/04/28 06:34:42 ohapon Exp $
 */

/**
 * Reader data from <code>ResultSet</code> to <code>Object[]</code>
 */
public class ResultSetReader {

    /** The <code>ResultSet</code> being readParameters. */
    private final ResultSet rs;

    /**
     * The indices into the <code>ResultSet</code>. Start value is 1.
     */
    private int[] columnIndices;

    /** Describes how to handle "blob" type data. */
    private ResultSetReaderInfo info = null;

    /**
     * The number of columns to readParameters. This may or may not be the
     * same as the number of columns in the <code>ResultSet</code>.
     * 
     * @see columnIndices.
     */
    private int columnCount;

    /**
     * <code>true</code> if an error occured reading a column in th
     * previous row.
     */
    private boolean errorOccured = false;

    /** Metadata for the <code>ResultSet</code> */
    private ResultSetMetaData rsmd;

    public ResultSetReader(ResultSet rs) throws SQLException {
	this(rs, null, null);
    }

    public ResultSetReader(ResultSet rs, ResultSetReaderInfo info)
	    throws SQLException {
	this(rs, info, null);
    }

    public ResultSetReader(ResultSet rs, int[] columnIndices)
	    throws SQLException {
	this(rs, null, columnIndices);
    }

    public ResultSetReader(ResultSet rs, ResultSetReaderInfo info,
	    int[] columnIndices) throws SQLException {
	super();
	if (rs == null) {
	    throw new IllegalArgumentException("ResultSet is null");
	}
	this.rs = rs;
	this.info = info != null ? info : new ResultSetReaderInfo();
	if (columnIndices != null && columnIndices.length == 0) {
	    columnIndices = null;
	}
	this.columnIndices = columnIndices;
	rsmd = rs.getMetaData();
	columnCount = columnIndices != null ? columnIndices.length : rsmd
		.getColumnCount();
    }

    /**
     * Read data from <code>ResultSet</code> to <code>List</code>
     * 
     * @return
     * @throws SQLException
     */
    public List readData() throws SQLException {
	List list = new ArrayList();
	Object[] row = null;
	int limitRow = -1;
	if (info != null) {
	    limitRow = info.getLimitRow();
	}
	if (limitRow < 0) {
	    while ((row = readRow()) != null) {
		list.add(row);
	    }
	} else {
	    int r = 0;
	    while ((r < limitRow) && (row = readRow()) != null) {
		list.add(row);
		r++;
	    }
	}

	return list;
    }

    /**
     * Read next row
     * 
     * @return
     * @throws SQLException
     */
    public Object[] readRow() throws SQLException {
	errorOccured = false;
	if (rs.next()) {
	    return doRead();
	}
	return null;
    }

    /**
     * Retrieve whether an error occured reading a column in the previous
     * row.
     * 
     * @return <code>true</code> if error occured.
     */
    public boolean getColumnError() {
	return errorOccured;
    }

    private Object[] doRead() {
	Object[] row = new Object[columnCount];
	for (int i = 0; i < columnCount; ++i) {
	    int idx = columnIndices != null ? columnIndices[i] : i + 1;
	    try {
		final int columnType = rsmd.getColumnType(idx);
		// final String columnClassName = rsmd.getColumnClassName(idx);
		switch (columnType) {
		case Types.NULL:
		    row[i] = null;
		    break;

		// TODO: When JDK1.4 is the earliest JDK supported
		// boolean data type.
		case Types.BIT:
		case 16:
		    // case Types.BOOLEAN:
		    row[i] = rs.getObject(idx);
		    if (row[i] != null && !(row[i] instanceof Boolean)) {
			if (row[i] instanceof Number) {
			    if (((Number) row[i]).intValue() == 0) {
				row[i] = Boolean.FALSE;
			    } else {
				row[i] = Boolean.TRUE;
			    }
			} else {
			    row[i] = Boolean.valueOf(row[i].toString());
			}
		    }
		    break;

		case Types.TIME:
		    row[i] = rs.getTime(idx);
		    break;

		case Types.DATE:
		    // row[i] = rs.getDate(idx);
		    // Use getObject(int) rather than getDate(int) as
		    // Oracle stores a TimeStamp in Date columns rather
		    // than a Date object.
		    row[i] = rs.getObject(idx);
		    break;

		case Types.TIMESTAMP:
		    row[i] = rs.getTimestamp(idx);
		    break;

		case Types.BIGINT:
		    row[i] = rs.getObject(idx);
		    if (row[i] != null && !(row[i] instanceof Long)) {
			if (row[i] instanceof Number) {
			    row[i] = new Long(((Number) row[i]).longValue());
			} else {
			    row[i] = new Long(row[i].toString());
			}
		    }
		    break;

		case Types.DOUBLE:
		case Types.FLOAT:
		case Types.REAL:
		    row[i] = rs.getObject(idx);
		    if (row[i] != null && !(row[i] instanceof Double)) {
			if (row[i] instanceof Number) {
			    Number nbr = (Number) row[i];
			    row[i] = new Double(nbr.doubleValue());
			} else {
			    row[i] = new Double(row[i].toString());
			}
		    }
		    break;

		case Types.DECIMAL:
		case Types.NUMERIC:
		    row[i] = rs.getObject(idx);
		    if (row[i] != null && !(row[i] instanceof BigDecimal)) {
			if (row[i] instanceof Number) {
			    Number nbr = (Number) row[i];
			    row[i] = new BigDecimal(nbr.doubleValue());
			} else {
			    row[i] = new BigDecimal(row[i].toString());
			}
		    }
		    break;

		case Types.INTEGER:
		case Types.SMALLINT:
		case Types.TINYINT:
		    row[i] = rs.getObject(idx);
		    if (rs.wasNull()) {
			row[i] = null;
		    }
		    if (row[i] != null && !(row[i] instanceof Integer)) {
			if (row[i] instanceof Number) {
			    row[i] = new Integer(((Number) row[i]).intValue());
			} else {
			    row[i] = new Integer(row[i].toString());
			}
		    }
		    break;

		// TODO: Hard coded -. JDBC/ODBC bridge JDK1.4
		// brings back -9 for nvarchar columns in
		// MS SQL Server tables.
		// -8 is ROWID in Oracle.
		case Types.CHAR:
		case Types.VARCHAR:
		case Types.LONGVARCHAR:
		case -9:
		case -8:
		    row[i] = rs.getString(idx);
		    if (rs.wasNull()) {
			row[i] = null;
		    }
		    break;

		case Types.BINARY:
		    if (info.isReadBinary()) {
			row[i] = rs.getString(idx);
		    } else {
			row[i] = "<Binary>";
		    }
		    break;

		case Types.VARBINARY:
		    if (info.isReadVarBinary()) {
			row[i] = rs.getString(idx);
		    } else {
			row[i] = "<VarBinary>";
		    }
		    break;

		case Types.LONGVARBINARY:
		    if (info.isReadLongVarBinary()) {
			row[i] = rs.getString(idx);
		    } else {
			row[i] = "<LongVarBinary>";
		    }
		    break;

		case Types.BLOB:
		    if (info.isReadBlobs()) {
			row[i] = null;
			Blob blob = rs.getBlob(idx);
			if (blob != null) {
			    int len = (int) blob.length();
			    if (len > 0) {
				int bytesToRead = len;
				if (!info.isReadCompleteBlobs()) {
				    bytesToRead = info.getReadBlobsSize();
				}
				if (bytesToRead > len) {
				    bytesToRead = len;
				}
				row[i] = new String(blob.getBytes(1,
					bytesToRead));
			    }
			}
		    } else {
			row[i] = "<Blob>";
		    }
		    break;

		case Types.CLOB:
		    if (info.isReadClobs()) {
			row[i] = null;
			Clob clob = rs.getClob(idx);
			if (clob != null) {
			    int len = (int) clob.length();
			    if (len > 0) {
				int charsToRead = len;
				if (!info.isReadCompleteClobs()) {
				    charsToRead = info.getReadClobsSize();
				}
				if (charsToRead > len) {
				    charsToRead = len;
				}
				row[i] = clob.getSubString(1, charsToRead);
			    }
			}
		    } else {
			row[i] = "<Clob>";
		    }
		    break;

		case Types.OTHER:
		    if (info.isReadSQLOther()) {
			// Running getObject on a java class attempts
			// to load the class in memory which we don't want.
			// getString() just gets the value without loading
			// the class (at least under PostgreSQL).
			// row[i] = rs.getObject(idx);
			row[i] = rs.getString(idx);
		    } else {
			row[i] = "<Other>";
		    }
		    break;

		default:
		    if (info.isReadAllOther()) {
			row[i] = rs.getObject(idx);
		    } else {
			row[i] = "<Unknown(" + columnType + ")>";
		    }
		}
	    } catch (Throwable th) {
		errorOccured = true;

		// TODO:
		// row[i] = "<Error>";
		row[i] = null;

		StringBuffer msg = new StringBuffer("Error reading column data");
		msg.append(", column index = ").append(idx);

	    }
	}

	return row;
    }

}
