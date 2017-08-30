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

package org.plazmaforge.framework.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReportStorage {

    public static final String CLASS_PROTOCOL = "class://";

    public static final String FILE_PROTOCOL = "file://";

    public static final String HTTP_PROTOCOL = "http://";

    public static final String FTP_PROTOCOL = "ftp://";

    
    
    public File getFile(IReport report, String template) {
	if (template == null) {
	    return null;
	}
	if (template.startsWith(FILE_PROTOCOL)) {
	    String fileName = template.substring(FILE_PROTOCOL.length());
	    File file = new File(fileName);
	    if (file.exists()) {
		return file;
	    }
	    return null;
	}
	return null;

    }

    
    public InputStream getInputStream(IReport report, String template) {
	if (template == null) {
	    return null;
	}
	if (template.startsWith(CLASS_PROTOCOL)) {
	    return getClassInputStream(report, template.substring(CLASS_PROTOCOL.length()));
	} else if (template.startsWith(FILE_PROTOCOL)) {
	    return getFileInputStream(report, template.substring(FILE_PROTOCOL.length()));
	} else {
	    return getClassInputStream(report, template);
	}
    }

    protected InputStream getClassInputStream(IReport report, String template) {
	return report.getClass().getResourceAsStream(template);
    }

    protected InputStream getFileInputStream(IReport report, String template) {
	InputStream is = null;
	try {
	    is = new FileInputStream(template);
	} catch (FileNotFoundException ex) {
	    //
	}
	return is;

    }

}
