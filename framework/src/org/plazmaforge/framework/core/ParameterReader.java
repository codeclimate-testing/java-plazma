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
 * Created on 22.09.2003
 *
 */
package org.plazmaforge.framework.core;

/**
 * @author Oleh Hapon
 */
public class ParameterReader {

    // Int
    public static int getInt(Object prm, int def) {
	int value = def;
	try {
	    value = ((Integer) prm).intValue();
	} catch (Exception ex) {
	    value = def;
	}
	return value;
    }

    public static int getInt(Object prm) {
	return getInt(prm, 0);
    }

    // Float
    public static float getFloat(Object prm, float def) {
	float value = def;
	try {
	    value = ((Float) prm).floatValue();
	} catch (Exception ex) {
	    value = def;
	}
	return value;
    }

    public static float getFloat(Object prm) {
	return getFloat(prm, 0.0f);
    }

    // Double
    public static double getDouble(Object prm, double def) {
	double value = def;
	try {
	    value = ((Double) prm).doubleValue();
	} catch (Exception ex) {
	    value = def;
	}
	return value;
    }

    public static double getDouble(Object prm) {
	return getDouble(prm, 0.0d);
    }

    // Boolean
    public static boolean getBoolean(Object prm, boolean def) {
	boolean value = def;
	try {
	    value = ((Boolean) prm).booleanValue();
	} catch (Exception ex) {
	    value = def;
	}
	return value;
    }

    public static boolean getBoolean(Object prm) {
	return getBoolean(prm, false);
    }

    // String
    public static String getString(Object prm, String def) {
	String value = def;
	try {
	    value = (String) prm;
	} catch (Exception ex) {
	    value = def;
	}
	return value;
    }

    public static String getString(Object prm) {
	return getString(prm, "");
    }

    public static String getStringNull(Object prm) {
	return getString(prm, null);
    }

    /*
     String parameter reader
     */

    // Int
    public static int getInt(String prm, int def) {
	int val = def;
	try {
	    val = Integer.parseInt(prm);
	} catch (Exception ex) {
	    val = def;
	}
	return val;
    }

    public static int getInt(String prm) {
	return getInt(prm, 0);
    }

    // Float
    public static float getFloat(String prm, float def) {
	float val = def;
	try {
	    val = Float.parseFloat(prm);
	} catch (Exception ex) {
	    val = def;
	}
	return val;
    }

    public static float getFloat(String prm) {
	return getFloat(prm, 0.0f);
    }

    // Double
    public static double getDouble(String prm, double def) {
	double val = def;
	try {
	    val = Double.parseDouble(prm);
	} catch (Exception ex) {
	    val = def;
	}
	return val;
    }

    public static double getDouble(String prm) {
	return getDouble(prm, 0.0d);
    }

}
