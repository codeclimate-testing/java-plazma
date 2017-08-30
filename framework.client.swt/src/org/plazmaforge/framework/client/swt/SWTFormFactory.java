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

package org.plazmaforge.framework.client.swt;

import java.lang.reflect.Constructor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.framework.client.IFormFactory;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.swt.forms.ISWTFormDecorator;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 *
 */

public class SWTFormFactory implements IFormFactory {
    
    protected final Log logger = LogFactory.getLog(getClass());
    
    
    
    
    public IForm getForm(String formName) throws ApplicationException {
	return getForm(formName, null);
    }
    
    public IForm getForm(String formName, Object parent) throws ApplicationException {
	return getForm(getFormClass(formName), parent);
    }

    public IForm getForm(Class formClass) throws ApplicationException{
	return getForm(formClass, null);
    }
    
    
    public IForm getForm(Class formClass, Object parent) throws ApplicationException {
	if (formClass == null) {
	    return null;
	}
	ISWTFormDecorator d = (ISWTFormDecorator) parent;
	IForm form = null;
	try {
	   Constructor constructor = formClass.getConstructor(new Class[] {Composite.class, Integer.TYPE});
	   if (constructor == null) {
	       throw new ApplicationException("Form initialization error [" + formClass + "]: Constructor not found");
	   }
	   form = (IForm) constructor.newInstance(new Object[] {d.getContent(), SWT.NONE});
           form.setDecorator(d);
	} catch (Exception ex) {
	    throw new ApplicationException("Form initialization error [" + formClass + "]: " + ex.getCause());
	}
	return form;
    }    

    // TODO: STUB !!!
    public Class getFormClass(String formName) {
	if ("CountryList".equals(formName)) {
	    return null; //CountryList.class; 
	} else if ("CompanyEdit".equals(formName)) {
	    return null; //CountryEdit.class;
	}
        return null;
    }
    
    public Class getListFormType() {
	return IListForm.class;
    }
    
    public Class getEditFormType() {
	return IEditForm.class;
    }    
}
