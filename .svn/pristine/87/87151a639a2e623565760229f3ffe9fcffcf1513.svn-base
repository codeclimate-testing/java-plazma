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
package org.plazmaforge.bs.project.shared.entities;

import org.plazmaforge.framework.ext.model.ComplexEntity;
import org.plazmaforge.framework.ext.model.IHistoryEntity;
import org.plazmaforge.framework.ext.model.IStringPresentation;

/**
 * 
 * @author ohapon
 *
 */
public class ProjectTitle extends ComplexEntity implements IHistoryEntity, IStringPresentation {

    private static final long serialVersionUID = 385717354341382712L;
    

    private String projectNo;

    private String name;

    public String getProjectNo() {
	return projectNo;
    }

    public void setProjectNo(String projectNo) {
	this.projectNo = projectNo;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
    
    public String getStringPresentation() {
	return getName();
    }
    
    public String getCodeStringPresentation() {
	if (isEmpty(getProjectNo())) {
	    return getName();
	}
	return getProjectNo().trim() + (isEmpty(getName()) ? "" : (" " + getName()));
	
    }

}
