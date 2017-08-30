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
 * Created on 15.04.2006
 */

package org.plazmaforge.framework.platform.structure.impl.spring;

import org.plazmaforge.framework.platform.structure.Framework;
import org.plazmaforge.framework.platform.structure.FrameworkContext;
import org.plazmaforge.framework.platform.structure.impl.AbstractFramework;


public class SpringFramework extends AbstractFramework implements Framework {

    public static final String ID = "SPRING";

    public String getDescription() {
	return "Spring Framework";
    }

    public String getId() {
	return ID;
    }

    public String getName() {
	return "Spring";
    }

    protected FrameworkContext createContext() {
	SpringContext ctx = new SpringContext();
	return ctx;
    }

    public SpringContext getSpringContext() {
	return (SpringContext) getContext();
    }

}
