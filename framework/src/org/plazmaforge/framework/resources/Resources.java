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


import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.KeyStroke;

import org.plazmaforge.framework.action.ActionConstants;
import org.plazmaforge.framework.util.StringUtils;

/**
 * @author Oleh Hapon Date: 19.01.2004 Time: 9:10:23 $Id: Resources.java,v 1.3 2010/04/28 06:34:40 ohapon Exp $
 */

public abstract class Resources implements ActionConstants {

    public static final String CLASS_NAME_PREFIX = "@";

    private ResourceBundle bundle;

    private String imagePath;

    private ArrayList bundles;

    protected Resources(String resourceName, Locale locale, ClassLoader loader) {
	super();
	init(resourceName, locale, loader);
    }

    public final void init(String resourceName) {
	init(resourceName, null, null);
    }

    public final void init(String resourceName, Locale locale,
	    ClassLoader loader) {
	if (StringUtils.isEmpty(resourceName)) {
	    throw new IllegalArgumentException("ResourceName is empty");
	}
	if (locale == null) {
	    locale = Locale.getDefault();
	}
	if (loader == null) {
	    loader = this.getClass().getClassLoader();
	}

	int pos = resourceName.indexOf(";");
	bundle = ResourceBundle.getBundle((pos < 0) ? resourceName
		: resourceName.substring(0, pos), locale, loader);
	imagePath = getString("path.images");
	if (pos < 0) {
	    return;
	}

	StringTokenizer t = new StringTokenizer(resourceName.substring(pos),
		";");
	while (t.hasMoreTokens()) {
	    addResourceBundle(t.nextToken());
	}
    }

    protected Resources() {

    }

    protected Resources(String resourceName, Locale locale) {
	this(resourceName, locale, null);
    }

    protected Resources(String resourceName, ClassLoader loader) {
	this(resourceName, null, loader);
    }

    protected Resources(String resourceName) {
	this(resourceName, null, null);
    }

    private ArrayList getBundles() {
	if (bundles == null) {
	    bundles = new ArrayList();
	}
	return bundles;
    }

    public void addResourceBundle(String resourceName, Locale locale,
	    ClassLoader loader) {
	if (StringUtils.isEmpty(resourceName)) {
	    throw new IllegalArgumentException("ResourceName is empty");
	}
	if (locale == null) {
	    locale = Locale.getDefault();
	}
	if (loader == null) {
	    loader = this.getClass().getClassLoader();
	}
	ResourceBundle bundle = ResourceBundle.getBundle(resourceName, locale,
		loader);
	getBundles().add(bundle);

    }

    public void addResourceBundle(String resourceName, Locale locale) {
	addResourceBundle(resourceName, locale, null);
    }

    public void addResourceBundle(String resourceName) {
	addResourceBundle(resourceName, null);
    }

    public KeyStroke getKeyStroke(Action action) {
	final String fullKey = action.getClass().getName();
	String accel = getResourceString(fullKey, ACCELERATOR);
	if (accel.length() > 0) {
	    return KeyStroke.getKeyStroke(accel);
	}
	return null;
    }

    public JMenu createMenu(String key) throws MissingResourceException {
	JMenu menu = new JMenu();
	final String fullKey = key;
	menu.setText(getResourceString(fullKey, NAME));
	String mn = getResourceString(fullKey, MNEMONIC);
	if (!StringUtils.isEmpty(mn)) {
	    menu.setMnemonic(mn.charAt(0));
	}
	return menu;
    }

    public void setupAction(Action action, boolean showColoricons) {
	if (action == null) {
	    throw new IllegalArgumentException("Action is null");
	}

	final String actionClassName = action.getClass().getName();
	final String key = actionClassName;
	action.putValue(Action.NAME, getResourceString(key, NAME));
	action.putValue(Action.SHORT_DESCRIPTION, getResourceString(key,
		TOOLTIP));

	Icon icon = null;

	try {
	    icon = getIcon(key, ROLLOVER_IMAGE);
	    action.putValue(Action.SMALL_ICON, icon);
	} catch (MissingResourceException ex) {
	    try {
		icon = getIcon(key, IMAGE);
		action.putValue(Action.SMALL_ICON, icon);
	    } catch (MissingResourceException ignore) {
	    }
	}
    }

    public ImageIcon getIcon(String keyName) {
	return getIcon(keyName, "image");
    }

    public ImageIcon getIcon(Class objClass, String propName) {
	return getIcon(objClass.getName(), propName);
    }

    public ImageIcon getIcon(String keyName, String propName) {
	if (keyName == null) {
	    throw new IllegalArgumentException("KeyName is null");
	}
	if (propName == null) {
	    throw new IllegalArgumentException("PropName is null");
	}

	ImageIcon icon = null;

	String rsrcName = getResourceString(keyName, propName);

	if (!StringUtils.isEmpty(rsrcName)) {
	    icon = createIcon(rsrcName);
	    if (icon == null) {
		// log error
	    }
	} else {
	    // log error
	}

	return icon;
    }

    public ResourceBundle getResourceBundle() {
	return bundle;
    }

    private ResourceBundle getLibraryResourceBundle() {
	return LibraryResources.getInstance().getResourceBundle();
    }

    public ImageIcon createIcon(String fileName) {
	if (!StringUtils.isEmpty(fileName)) {
	    URL url = getClass().getResource(getImagePathName(fileName));
	    if (url != null) {
		return new ImageIcon(url);
	    }
	}
	return null;
    }

    public String getString(String key) throws MissingResourceException {

	try {
	    return getResourceBundle().getString(key);

	} catch (MissingResourceException e) {
	    try {
		return getLibraryResourceBundle().getString(key);
	    } catch (MissingResourceException ex) {
		if (bundles == null || bundles.isEmpty()) {
		    throw e;
		}
		Iterator it = bundles.iterator();
		while (it.hasNext()) {
		    try {
			return ((ResourceBundle) it.next()).getString(key);
		    } catch (MissingResourceException exx) {

		    }

		}
		throw e;

	    }
	}
    }

    private String getResourceString(String keyName, String propName)
	    throws MissingResourceException {
	return getString(keyName + CLASS_NAME_PREFIX + propName);
    }

    public String getImageString(String key) {
	return getResourceString(key, IMAGE);
    }

    public String getTooltipString(String key) {
	return getResourceString(key, TOOLTIP);
    }

    private String getImagePathName(String fileName) {
	if (fileName == null)
	    return null;
	return fileName.startsWith("/") ? fileName : imagePath + fileName;
    }

}
