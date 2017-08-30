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
 * Created on 27.03.2008
 *
 */

package org.plazmaforge.framework.report.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @author Oleh Hapon
 * $Id: ReportContext.java,v 1.2 2010/04/28 06:34:33 ohapon Exp $
 */

public class ReportContext {

    private List<DataEntity> entities = new ArrayList<DataEntity>();

    private Map<String, DataEntity> entitieMap = new HashMap<String, DataEntity>();

    public void addEntity(DataEntity entity) {
	entities.add(entity);
	entitieMap.put(entity.getName() + "." + entity.getId(), entity);
    }
    
    public DataEntity getEntity(String name, Serializable id) {
	return entitieMap.get(name + "." + id);
    }
}
