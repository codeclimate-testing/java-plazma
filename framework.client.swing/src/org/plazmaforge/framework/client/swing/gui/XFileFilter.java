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
package org.plazmaforge.framework.client.swing.gui;

import javax.swing.filechooser.FileFilter;
import java.util.Hashtable;
import java.util.Enumeration;
import java.io.File;

/**
 * @author Oleh Hapon Date: 13.11.2003 Time: 9:25:24
 */

public class XFileFilter extends FileFilter {

    private Hashtable filters = null;

    private String description = null;

    private String fullDescription = null;

    private boolean useExtensionsInDescription = true;

    public XFileFilter() {
	this.filters = new Hashtable();
    }

    public XFileFilter(String extension) {
	this(extension, null);
    }

    public XFileFilter(String extension, String description) {
	this();
	if (extension != null)
	    addExtension(extension);
	if (description != null)
	    setDescription(description);
    }

    public XFileFilter(String[] filters) {
	this(filters, null);
    }

    public XFileFilter(String[] filters, String description) {
	this();
	for (int i = 0; i < filters.length; i++) {
	    addExtension(filters[i]);
	}
	if (description != null)
	    setDescription(description);
    }

    public boolean accept(File f) {
	if (f != null) {
	    if (f.isDirectory()) {
		return true;
	    }
	    String extension = getExtension(f);
	    if (extension != null && filters.get(getExtension(f)) != null) {
		return true;
	    }
	}
	return false;
    }

    public String getExtension(File f) {
	if (f != null) {
	    String filename = f.getName();
	    int i = filename.lastIndexOf('.');
	    if (i > 0 && i < filename.length() - 1) {
		return filename.substring(i + 1).toLowerCase();
	    }
	}
	return null;
    }

    public void addExtension(String extension) {
	if (filters == null) {
	    filters = new Hashtable(5);
	}
	filters.put(extension.toLowerCase(), this);
	fullDescription = null;
    }

    public String getDescription() {
	if (fullDescription == null) {
	    if (description == null || isExtensionListInDescription()) {
		fullDescription = description == null ? "(" : description
			+ " (";
		// build the description from the extension list
		Enumeration extensions = filters.keys();
		if (extensions != null) {
		    fullDescription += "." + (String) extensions.nextElement();
		    while (extensions.hasMoreElements()) {
			fullDescription += ", ."
				+ (String) extensions.nextElement();
		    }
		}
		fullDescription += ")";
	    } else {
		fullDescription = description;
	    }
	}
	return fullDescription;
    }

    public void setDescription(String description) {
	this.description = description;
	fullDescription = null;
    }

    public void setExtensionListInDescription(boolean b) {
	useExtensionsInDescription = b;
	fullDescription = null;
    }

    public boolean isExtensionListInDescription() {
	return useExtensionsInDescription;
    }

}
