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


package org.plazmaforge.bs.base.shared.entities;

import org.plazmaforge.framework.ext.model.Dictionary;
import org.plazmaforge.framework.ext.model.IStatusEntity;


/**
 * 
 * @author ohapon
 *
 */
public class Status extends Dictionary implements IStatusEntity {

    private static final long serialVersionUID = 2493278035085881516L;
    

    private boolean start;

    private boolean finish;

    private String color;

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = isEmpty(color) ? null : color;
    }

    public boolean isFinish() {
	return finish;
    }

    public void setFinish(boolean finish) {
	this.finish = finish;
    }

    public boolean isStart() {
	return start;
    }

    public void setStart(boolean start) {
	this.start = start;
    }

}
