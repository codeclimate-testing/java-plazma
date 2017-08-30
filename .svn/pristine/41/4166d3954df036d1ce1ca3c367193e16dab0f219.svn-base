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

package org.plazmaforge.framework.core.data;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.ext.model.BaseEntity;


public class TransferSource extends BaseEntity {

    private String code;
    
    private String name;
    
    private String importerClassName;
    
    private String exporterClassName;
    
    
    private List<TransferSourceAttribute> attributes;

    public void init() {
	getAttributes().size();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImporterClassName() {
        return importerClassName;
    }

    public void setImporterClassName(String importerClassName) {
        this.importerClassName = importerClassName;
    }

    public String getExporterClassName() {
        return exporterClassName;
    }

    public void setExporterClassName(String exporterClassName) {
        this.exporterClassName = exporterClassName;
    }

    public List<TransferSourceAttribute> getAttributes() {
	if (attributes == null) {
	    attributes = new ArrayList<TransferSourceAttribute>();
	}
        return attributes;
    }

    public void setAttributes(List<TransferSourceAttribute> attributes) {
        this.attributes = attributes;
    }
    
    public void addAttribute(TransferSourceAttribute attribute) {
	attribute.setSource(this);
	getAttributes().add(attribute);
    }
    
    public void removeAttribute(TransferSourceAttribute attribute) {
	attribute.setSource(null);
	getAttributes().remove(attribute);
    }

    
    
}
