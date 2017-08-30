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

package org.plazmaforge.bsolution.project;

import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.bsolution.project.common.beans.ProjectStage;
import org.plazmaforge.bsolution.project.common.beans.ProjectStatus;
import org.plazmaforge.bsolution.project.common.beans.ProjectType;
import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.platform.structure.ModuleContext;


/**
 * @author Oleh Hapon
 *
 * $Id: ProjectContext.java,v 1.3 2010/12/05 07:56:00 ohapon Exp $
 * 
 */

public class ProjectContext extends BaseEntity implements ModuleContext {

    private PartnerTitle partner;

    private ContactTitle responsible;

    private ProjectStage projectStage;

    private ProjectStatus projectStatus;

    private ProjectStatus initProjectStatus;
    
    private ProjectType projectType;
    
    private ProjectType initProjectType;    

    private Currency currency;

    public Currency getCurrency() {
	return currency;
    }

    public void setCurrency(Currency currency) {
	this.currency = currency;
    }

    public PartnerTitle getPartner() {
	return partner;
    }

    public void setPartner(PartnerTitle partner) {
	this.partner = partner;
    }

    public ProjectStage getProjectStage() {
	return projectStage;
    }

    public void setProjectStage(ProjectStage projectStage) {
	this.projectStage = projectStage;
    }

    public ProjectStatus getProjectStatus() {
	return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
	this.projectStatus = projectStatus;
    }

    public ProjectStatus getInitProjectStatus() {
        return initProjectStatus;
    }

    public void setInitProjectStatus(ProjectStatus initProjectStatus) {
        this.initProjectStatus = initProjectStatus;
    }

    public ProjectStatus getDefaultProjectStatus() {
        return projectStatus == null ? initProjectStatus : projectStatus;
    }
    
    public ProjectType getProjectType() {
	return projectType;
    }

    public void setProjectType(ProjectType projectType) {
	this.projectType = projectType;
    }

    public ProjectType getInitProjectType() {
        return initProjectType;
    }

    public void setInitProjectType(ProjectType initProjectType) {
        this.initProjectType = initProjectType;
    }

    public ProjectType getDefaultProjectType() {
        return projectType == null ? initProjectType : projectType;
    }
    
    public ContactTitle getResponsible() {
	return responsible;
    }

    public void setResponsible(ContactTitle responsible) {
	this.responsible = responsible;
    }

}
