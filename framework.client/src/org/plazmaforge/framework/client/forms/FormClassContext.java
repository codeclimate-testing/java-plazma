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
 * Created on 25.09.2007
 *
 */

package org.plazmaforge.framework.client.forms;

import java.io.Serializable;

/** 
 * @author Oleh Hapon
 * $Id: FormClassContext.java,v 1.2 2010/04/28 06:35:42 ohapon Exp $
 */

public class FormClassContext {

    private Class formClass;
    
    private Serializable identifier;

    public Class getFormClass() {
        return formClass;
    }

    public void setFormClass(Class formClass) {
        this.formClass = formClass;
    }

    public Serializable getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Serializable identifier) {
        this.identifier = identifier;
    }
    
    
}
