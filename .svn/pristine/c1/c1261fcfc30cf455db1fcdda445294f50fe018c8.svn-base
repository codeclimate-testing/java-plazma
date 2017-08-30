/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

/**
 * 
 */
package org.plazmaforge.bs.web.client;

import org.plazmaforge.bs.ApplicationFormCreator;
import org.plazmaforge.framework.core.data.Customizer;
import org.plazmaforge.framework.uwt.form.IForm;
import org.plazmaforge.framework.uwt.gxt.core.XFormCreator;

import com.google.gwt.core.client.GWT;

/**
 * @author ohapon
 *
 */
public class WebApplicationFormCreator extends ApplicationFormCreator {

    private XFormCreator innerFormCreator;
    
    public WebApplicationFormCreator(Customizer formCustomirer) {
	super(formCustomirer);
    }

    @Override
    public IForm<?> createForm(String type) {
	if (innerFormCreator == null) {
	    innerFormCreator = GWT.create(XFormCreator.class);
	}
	IForm<?> form = innerFormCreator.createForm(type);
	return form;
    }

}
