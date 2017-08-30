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

package org.plazmaforge.framework.core;

/**
 * 
 * @author Oleh Hapon
 */
public class FileFormat {

    public static final String TXT = "TXT";
    
    public static final String CSV = "CSV";
    
    public static final String XML = "XML";
    
    public static final String HTML = "HTML";
    
    public static final String XLS = "XLS";
    
    public static final String RTF = "RTF";

    public static final String PDF = "PDF";
    
    public static final String ODT = "ODT";
    
    public static final String SQL = "SQL";
    

    

    public static final String DATABASE_TXT = "DATABASE.TXT";
    
    public static final String DATABASE_CSV = "DATABASE.CSV";
    
    public static final String DATABASE_XML = "DATABASE.XML";
    
    public static final String DATABASE_HTML = "DATABASE.HTML";
    
    public static final String DATABASE_XLS = "DATABASE.XLS";
    
    public static final String DATABASE_RTF = "DATABASE.RTF";
    
    public static final String DATABASE_PDF = "DATABASE.PDF";
    

    private static final String[] ALL_FILE_EXTENSIONS = {"*.*"};
    
    /////////////////////////////////////////////////////////////////////////////////////
    //
    // BASE FORMATS
    //
    //////////////////////////////////////////////////////////////////////////////////////

    public static final FileFormat TXT_FORMAT = new FileFormat(TXT, "TXT", "Text Format", new String[] {"*.txt"});
    
    public static final FileFormat CSV_FORMAT = new FileFormat(CSV, "CSV", "Comma Separated Values", new String[] {"*.csv", "*.txt"});
    
    public static final FileFormat XML_FORMAT = new FileFormat(XML, "XML", "Extensible Markup Language", new String[] {"*.xml"});
    
    public static final FileFormat HTML_FORMAT = new FileFormat(HTML, "HTML", "HyperText Markup Language", new String[] {"*.html", "*.htm"});
    
    public static final FileFormat XLS_FORMAT = new FileFormat(XLS, "XLS", "Excel File Format", new String[] {"*.xls"});
    
    public static final FileFormat RTF_FORMAT = new FileFormat(RTF, "RTF", "Rich Text Format", new String[] {"*.rtf"});
    
    public static final FileFormat PDF_FORMAT = new FileFormat(PDF, "PDF", "Portable Document Format", new String[] {"*.pdf"});
    
    public static final FileFormat ODT_FORMAT = new FileFormat(ODT, "ODT", "Open Document Format", new String[] {"*.odt"});
    
    public static final FileFormat SQL_FORMAT = new FileFormat(SQL, "SQL", "Structured Query Language", new String[] {"*.sql", "*.txt"});
    
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////
    
    
    
    private String id;
    
    private String name;
    
    private String description;
    
    private String[] fileExtensions;
    
    private String[] filterNames;
    
    /**
     * Internal type of format
     */
    private int type;
    
    
    public FileFormat(String id) {
	super();
	if (id == null) {
	    throw new IllegalArgumentException("Format ID must be not null");
	}
	this.id = id;
    }

    public FileFormat(String id, String name) {
	this(id);
	this.name = name;
    }

    public FileFormat(String id, String name, String description) {
	this(id, name);
	this.description = description;
    }

    public FileFormat(String id, String name, String description, String[] fileExtensions) {
	this(id, name);
	this.description = description;
	this.fileExtensions = fileExtensions;
    }

    public FileFormat(String id, String name, String[] fileExtensions) {
	this(id, name);
	this.fileExtensions = fileExtensions;
    }

    public FileFormat(String id, String name, String description, String[] fileExtensions, String[] filterNames) {
	this(id, name);
	this.name = name;
	this.description = description;
	this.fileExtensions = fileExtensions;
	this.filterNames = filterNames;
    }

    public FileFormat(String id, String name, String[] fileExtensions, String[] filterNames) {
	this(id, name);
	this.name = name;
	this.fileExtensions = fileExtensions;
	this.filterNames = filterNames;
    }
    
    public FileFormat(String id, String name, String description, String[] fileExtensions, int type) {
	this(id, name);
	this.name = name;
	this.description = description;
	this.fileExtensions = fileExtensions;
	this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
	if (name == null) {
	    return id;
	}
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getFileExtensions() {
	if (fileExtensions == null) {
	    fileExtensions = ALL_FILE_EXTENSIONS;
	}
        return fileExtensions;
    }

    public void setFileExtensions(String[] fileExtensions) {
        this.fileExtensions = fileExtensions;
    }

    public String[] getFilterNames() {
        return filterNames;
    }

    public void setFilterNames(String[] filterNames) {
        this.filterNames = filterNames;
    }

    public String getDefaultFileExtension() {
	if (fileExtensions == null || fileExtensions.length == 0 ){
	    return null;
	}
	return fileExtensions[0];
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String toString() {
	return getName();
    }
    
}
