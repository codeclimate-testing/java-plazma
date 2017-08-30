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
 * Created on 15.09.2007
 *
 */

package org.plazmaforge.framework.datawarehouse.convert.dataexport.xml;

import java.io.File;

import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractDatabaseExporter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractExporter;


/** 
 * @author Oleh Hapon
 * $Id: DatabaseXMLExporter.java,v 1.2 2010/04/28 06:34:40 ohapon Exp $
 */

public class DatabaseXMLExporter extends AbstractDatabaseExporter {

    public String getFileExt() {
	return ".xml";
    }
    
    protected String generateDataSetFileName(String outputDirectory, String tableName) {
	String fileName = outputDirectory + File.separator + tableName.toLowerCase() + getFileExt();
	return fileName;
    }
    
    protected AbstractExporter createDataSetExporter() {
	XMLExporter dataSetExporter =  new XMLExporter();
	dataSetExporter.setIncludeHeaders(true);
	return dataSetExporter;
	    
    }
    
}

