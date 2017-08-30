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

package org.plazmaforge.framework.launcher;

import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.net.URLClassLoader;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;
import java.io.IOException;

/**
 * @author Oleh Hapon Date: 03.06.2006 Time: 16:33:14 $Id: Classpath.java,v 1.2 2010/04/28 06:34:43 ohapon Exp $
 */

public class Classpath {

    private List<File> elements = new ArrayList<File>();

    public Classpath() {
    }

    public Classpath(String initial) {
	addClasspath(initial);
    }

    public boolean addComponent(String component) {
	if (component == null) {
	    return false;
	}
	try {
	    File f = new File(component);
	    if (f.exists()) {
		File key = f.getCanonicalFile();
		if (!elements.contains(key)) {
		    elements.add(key);
		    return true;
		}
	    }
	} catch (IOException e) {
	    // Stub
	}
	return false;
    }

    public boolean addComponent(File component) {
	if (component == null) {
	    return false;
	}
	try {
	    if (component.exists()) {
		File key = component.getCanonicalFile();
		if (!elements.contains(key)) {
		    elements.add(key);
		    return true;
		}
	    }
	} catch (IOException e) {
	    // Stub
	}
	return false;
    }

    public boolean addClasspath(String s) {
	if (s == null) {
	    return false;
	}
	boolean added = false;
	StringTokenizer t = new StringTokenizer(s, File.pathSeparator);
	while (t.hasMoreTokens()) {
	    added |= addComponent(t.nextToken());
	}
	return added;
    }

    public String toString() {
	StringBuffer cp = new StringBuffer(1024);
	int cnt = elements.size();
	if (cnt >= 1) {
	    cp.append(elements.get(0).getPath());
	}
	for (int i = 1; i < cnt; i++) {
	    cp.append(File.pathSeparatorChar);
	    cp.append(elements.get(i).getPath());
	}
	return cp.toString();
    }

    public URL[] getUrls() {
	int cnt = elements.size();
	URL[] urls = new URL[cnt];
	for (int i = 0; i < cnt; i++) {
	    try {
		
		//urls[i] = elements.get(i).toURL();
		
		// WARNING !!!
		// Do not use the problematic File.toURL() method.  Instead, use
		// file.toURI().toURL()
	        // or
		// new URL(file.toURI())
		// Bug ID:  4496398 
		
		urls[i] = elements.get(i).toURI().toURL();
	    } catch (MalformedURLException e) {
		// Stub
	    }
	}
	return urls;
    }

    public ClassLoader getClassLoader() {
	URL[] urls = getUrls();

	/*
	ClassLoader parent = null; // Thread.currentThread().getContextClassLoader();
	if (parent == null) {
	    parent = Classpath.class.getClassLoader();
	}
	if (parent == null) {
	    parent = ClassLoader.getSystemClassLoader();
	}
	*/
	
	
	return new URLClassLoader(urls, null /*parent*/);
	// return new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
    }

    public List<File> getElements() {
	return elements;
    }

}
