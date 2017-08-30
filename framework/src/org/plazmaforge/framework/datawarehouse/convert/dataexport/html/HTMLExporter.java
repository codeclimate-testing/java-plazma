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

package org.plazmaforge.framework.datawarehouse.convert.dataexport.html;

import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractTagExporter;


/** 
 * @author Oleh Hapon
 * $Id: HTMLExporter.java,v 1.2 2010/04/28 06:34:35 ohapon Exp $
 */

public class HTMLExporter extends AbstractTagExporter {

    public HTMLExporter() {
	super();
	BODY_TAG = "table";
	ROW_TAG = "tr";
	CELL_TAG = "td";
	HEADER_CELL_TAG = "th";
    }

     
    protected boolean isValid() {
	return super.isValid();
    }
    
    protected void exportMetaData() {
	
    }

    
       
    protected String getHeaderCellAttributes(DSField column, Object value) {
	return getColumnAlign(column);
    }
    
    protected String getRowCellAttributes(DSField column, Object value) {
	return getColumnAlign(column);
    }
    
    protected String getColumnAlign(DSField column) {
	if (column == null) {
	   return null; 
	}
	int align = column.getAlign();
	if (DSField.RIGHT_ALIGN == align) {
	    return "align='right'";
	} else if (DSField.CENTER_ALIGN == align) {
	    return "align='center'";
	}
	return null;
    }

    protected String getFileExt() {
	return ".html";
    }
    
}
