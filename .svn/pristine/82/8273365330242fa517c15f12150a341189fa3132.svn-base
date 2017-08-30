package org.plazmaforge.bsolution.organization.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.organization.common.beans.Organization;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.bsolution.organization.common.services.OrganizationService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.util.DBUtils;

public class OrganizationServiceImpl extends AbstractEntityService<Organization, Integer> implements OrganizationService {

    protected Class getEntityClass() {
       return Organization.class;
    }

    protected Class getEntityHeaderClass() {
       return OrganizationHeader.class;
    }
    
    /**
     * Special system (non secure) findHeaderById(id) method
     */
    public Object sysFindHeaderById(Integer id) throws DAOException {
	return findHeaderById(id);
    }
 
    /**
     * Special system (non secure) findAll method 
     */
    public List<OrganizationHeader> sysFindAll() throws DAOException {
	return  new ArrayList<OrganizationHeader>(findAll());
    }
    
    
    public void addOrganizationToSystem(Integer id) throws DAOException {
	doAddOrganizationToSystem(getConnection(), id);
    }

    public void removeOrganizationFromSystem(Integer id) throws DAOException {
	doRemoveOrganizationFromSystem(getConnection(), id);
    }
    
    protected void doAddOrganizationToSystem(Connection cn, Integer id) throws DAOException {
	try {
	    DBUtils.execute(cn, "INSERT INTO ORGANIZATION (ID) VALUES (" + id + ")");
	} catch (SQLException ex) {
	    throw new DAOException(ex);
	}
    }

    protected void doRemoveOrganizationFromSystem(Connection cn, Integer id) throws DAOException {
	try {
	    DBUtils.execute(cn, "DELETE FROM ORGANIZATION WHERE ID = " + id);
	} catch (SQLException ex) {
	    throw new DAOException(ex);
	}
    }


}
