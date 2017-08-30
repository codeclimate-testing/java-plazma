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

package org.plazmaforge.framework.datawarehouse.convert.dataexport.xml;

import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractTagExporter;


/** 
 * @author Oleh Hapon
 * $Id: XMLExporter.java,v 1.4 2010/05/26 11:20:04 ohapon Exp $
 */

public class XMLExporter extends AbstractTagExporter {

    public static String PROVIDER = "Plazma Forge";
    
    public static String VERSION = "1.0";
    
  
    public XMLExporter() {
	super();
	BODY_TAG = "dataset";
	ROW_TAG = "record";
	HEADER_ROW_TAG = "meta";
	
	CELL_TAG = "value";
	HEADER_CELL_TAG = "column";
    }

   
    
    protected boolean isValid() {
	return super.isValid();
    }
    
    protected void exportMetaData() {
	println("<?xml version=\"1.0\" encoding=\"" + getEncoding() + "\"?>");
    }
    
    protected void exportStartBody() {
	printStartTag(BODY_TAG, " provider=\"" + PROVIDER +"\" version=\"" + VERSION + "\"");
    }


    protected String getHeaderCellAttributes(DSField column, Object value) {
	if (column == null) {
	    return null;
	}
	
	String attrs = "";
	
	if (column.getDataType() != null) {
	    attrs += " data-type='" + column.getDataType() + "'";
	}

	if (column.getNativeType() != null) {
	    attrs += " native-type='" + column.getNativeType() + "'";
	}

	if (column.isFixedType() && column.getSize() > 0) {
	    attrs += " size='" + column.getSize() + "'";
	    if (column.getScale() > 0) {
		attrs += " scale='" + column.getScale() + "'";
	    }
	}

	return attrs.trim();
    }
    
    protected String getRowCellAttributes(DSField column, Object value) {
	if (column == null) {
	    return null;
	}
	if (value == null) {
	    return " is-null='true'";
	}
	return null;
    }
       
    protected String getFileExt() {
	return ".xml";
    }

  
}
