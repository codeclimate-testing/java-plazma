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
 * Created on 06.08.2003
 *
 */
package org.plazmaforge.framework.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleh Hapon
 */

/**
 * This is conatiner for parameter
 */
public class DataTransfer {

    // Standard parameter
    // OBJECT
    public static final String PRM_ID        = "object.id";
    public static final String PRM_DATA      = "object.data";
    public static final String PRM_LIST      = "object.list";
    public static final String PRM_OWNER     = "object.owner";
    public static final String PRM_PARENT    = "object.parent";
    public static final String PRM_CONTAINER = "object.shell";

    // STATE
    public static final String PRM_MODE      = "state.mode";
    public static final String PRM_IS_CYCLE  = "state.cycle";
    public static final String PRM_IS_SAVE   = "state.stored";

    // APPLICATION
    public static final String PRM_DESKTOP   = "app.desktop";
    public static final String PRM_FRAME     = "app.frame";
    public static final String PRM_TOOLBAR   = "app.toolbar";
    public static final String PRM_MENUBAR   = "app.menubar";
    public static final String PRM_STATUSBAR = "app.statusbar";
    public static final String PRM_MODAL     = "app.modal";



    protected Map map;
    
    protected Object data;

    public DataTransfer() {
        map = new HashMap();
    }

    public DataTransfer(Map map) {
        this.map = map;
    }


    public Object getValue(Object key) {
        return map.get(key);
    }

    public void putValue(Object key, Object value){
        map.put(key, value);
    }
    
    /**
     *
     * @param key
     * @return
     */
    public Object getParameter(String key) {
        return map.get(key);
    }

    /**
     *
     * @param key
     * @param value
     */
    public void setParameter(String key, Object value) {
        map.put(key, value);
    }


    // Int
    public int getInt(String key, int def) {
        return ParameterReader.getInt(key,def);
    }

    public int getInt(String key) {
        return ParameterReader.getInt(key);
    }


    public void setInt(String key, int value) {
        map.put(key, new Integer(value));
    }

    // Float
    public float getFloat(String key, float def) {
        return ParameterReader.getFloat(key,def);
    }

    public float getFloat(String key) {
        return ParameterReader.getFloat(key);
    }


    public void setFloat(String key, float value) {
        map.put(key, new Float(value));
    }

    // Double
    public double getDouble(String key, double def) {
        return ParameterReader.getDouble(key, def);
    }

    public double getDouble(String key) {
        return ParameterReader.getDouble(key);
    }


    public void setDouble(String key, double value) {
        map.put(key, new Double(value));
    }

    // Boolean
    public boolean getBoolean(String key, boolean def) {
        return ParameterReader.getBoolean(key, def);
    }

    public boolean getBoolean(String key) {
        return ParameterReader.getBoolean(key);
    }

    public void setBoolean(String key, boolean value) {
        map.put(key, new Boolean(value));
    }


    // String
    public String getString(String key, String def) {
	return ParameterReader.getString(key, def);
    }

    public String getString(String key) {
	return ParameterReader.getStringNull(key);
    }

    public void setString(String key, String value) {
	map.put(key, value);
    }



}
