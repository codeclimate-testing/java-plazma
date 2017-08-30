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

package org.plazmaforge.framework.client.views;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import org.plazmaforge.framework.client.models.IDataModel;
import org.plazmaforge.framework.util.ClassUtilsExt;


/** 
 * @author Oleh Hapon
 *
 */

public abstract class AbstractView implements IView {
    
    private IDataModel dataModel;
    
    private IViewHolder viewHolder;

    public IDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(IDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public IViewHolder getViewHolder() {
        return viewHolder;
    }

    public void setViewHolder(IViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    protected Serializable getEntityId(Object entity) {
	return viewHolder.getEntityId(entity);
    }
    
    protected List getModelDataList() {
	return getDataModel().getDataList();
    }

    protected void setModelDataList(List dataList) {
	getDataModel().setDataList(dataList);
    }

    protected Object getBeanValue(String propertyName, Object obj) {
	if (obj == null) {
	    return null;
	}
	return getBeanValue(obj.getClass(), propertyName, obj);
    }
	
    protected Object getBeanValue(Class klass, String propertyName, Object obj) {
	try {
	    if (obj == null) {
		return null;
	    }
	    return ClassUtilsExt.getBeanValue(klass, propertyName, obj);
	} catch (Exception ex) {
	    return null;
	}
    }
    
    protected Integer getIntegerValue(Properties prop, String key) {
	if (key == null || prop == null) {
	    return null;
	}
	try {
	    String value = prop.getProperty(key);
	    if (value == null) {
		return null;
	    }
	    return Integer.parseInt(value);
	} catch (NumberFormatException ex) {
	    //
	}
	return null;
    }
    
    /**
     * Return true if force focus after set position
     * @return
     */
    protected boolean isForceFocus(){
	return false;
    }

}
