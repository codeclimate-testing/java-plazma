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
package org.plazmaforge.bsolution.base.common.beans;

import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.platform.structure.PartContext;


/**
 * @author Oleh Hapon Date: 04.09.2004 Time: 9:20:27 $Id: SystemInfo.java,v 1.6 2010/12/05 07:55:59 ohapon Exp $
 */
public class SystemInfo extends BaseEntity implements PartContext {


    /** OrganizationHeader * */
    private OrganizationHeader organization;

    
    private boolean systemInit;

    private String appVersion;

    private String dbVersion;

    
    public OrganizationHeader getOrganization() {
	return organization;
    }

    public void setOrganization(OrganizationHeader organization) {
	this.organization = organization;
    }
    
    public Integer getOrganizationId() {
	return organization == null ? null : organization.getId();
    }

    public String getOrganizationName() {
	return organization == null ? null : organization.getName();
    }

    public String getAppVersion() {
	return appVersion;
    }

    public void setAppVersion(String appVersion) {
	this.appVersion = appVersion;
    }

    public String getDbVersion() {
	return dbVersion;
    }

    public void setDbVersion(String dbVersion) {
	this.dbVersion = dbVersion;
    }

    public boolean isSystemInit() {
	return systemInit;
    }

    public void setSystemInit(boolean init) {
	this.systemInit = init;
    }

    
    
    
}
