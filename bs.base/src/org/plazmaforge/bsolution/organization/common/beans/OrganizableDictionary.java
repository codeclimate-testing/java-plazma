package org.plazmaforge.bsolution.organization.common.beans;

import org.plazmaforge.framework.ext.model.Dictionary;


public class OrganizableDictionary extends Dictionary implements IOrganizable {

    private IOrganizationTitle organization;
    
    public IOrganizationTitle getOrganization() {
	return organization;
    }

    public void setOrganization(IOrganizationTitle organization) {
	this.organization = organization;
    }
    
    public Integer getOrganizationId() {
	return organization == null ? null : organization.getId();
    }

}
