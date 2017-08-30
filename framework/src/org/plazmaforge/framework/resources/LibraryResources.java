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
package org.plazmaforge.framework.resources;

/**
 * @author Oleh Hapon Date: 19.01.2004 Time: 9:18:57 $Id: LibraryResources.java,v 1.2 2010/04/28 06:34:40 ohapon Exp $
 */

public class LibraryResources extends Resources implements ResourcesConstants {

    public static final String RESOURCE_PACKAGE = LibraryResources.class
	    .getPackage().getName();

    public static final String RESOURCE_NAME = RESOURCE_PACKAGE + ".library";

    public static final String CALENDAR_RESOURCE_NAME = RESOURCE_PACKAGE
	    + ".calendar";

    private static LibraryResources libraryResources;

    public synchronized static LibraryResources getInstance() {
	if (libraryResources == null) {
	    libraryResources = new LibraryResources();
	}
	return libraryResources;
    }

    private LibraryResources() {
	super(LibraryResources.RESOURCE_NAME, LibraryResources.class
		.getClassLoader());
    }

}
