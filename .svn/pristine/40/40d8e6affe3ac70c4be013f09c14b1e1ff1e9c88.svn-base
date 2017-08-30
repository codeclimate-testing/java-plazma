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

import org.plazmaforge.framework.core.FileFormat;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.csv.CSVExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.csv.DatabaseCSVExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.html.DatabaseHTMLExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.html.HTMLExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.odt.ODTExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.rtf.DatabaseRTFExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.rtf.RTFExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.sql.SQLExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.xls.DatabaseXLSExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.xls.XLSExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.xml.DatabaseXMLExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.xml.XMLExporter;


/** 
 * @author Oleh Hapon
 * $Id: ExportFactory.java,v 1.4 2010/05/12 14:54:24 ohapon Exp $
 */

public class ExportFactory {
    
    

    private ExportFactory() {
	
    }

    /**
     * Return <code>IExporter</code> by format
     * @param format
     * @return
     */
    public static IExporter getExporter(String format) {
	if (FileFormat.XML.equals(format)) {
	    return new XMLExporter();
	} else if (FileFormat.CSV.equals(format)) {
	    return new CSVExporter();
	} else if (FileFormat.HTML.equals(format)) {
	    return new HTMLExporter();
	} else if (FileFormat.SQL.equals(format)) {
	    return new SQLExporter();
	} else if (FileFormat.XLS.equals(format)) {
	    return new XLSExporter();
	} else if (FileFormat.RTF.equals(format)) {
	    return new RTFExporter();
	} else if (FileFormat.ODT.equals(format)) {
	    return new ODTExporter();	    
	} else if (FileFormat.DATABASE_XML.equals(format)) {
	    return new DatabaseXMLExporter();
	} else if (FileFormat.DATABASE_CSV.equals(format)) {
	    return new DatabaseCSVExporter();
	} else if (FileFormat.DATABASE_HTML.equals(format)) {
	    return new DatabaseHTMLExporter();
	} else if (FileFormat.DATABASE_XLS.equals(format)) {
	    return new DatabaseXLSExporter();
	} else if (FileFormat.DATABASE_RTF.equals(format)) {
	    return new DatabaseRTFExporter();
	}
	return null;
    }

}
