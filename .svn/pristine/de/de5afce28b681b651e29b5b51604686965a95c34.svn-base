package org.plazmaforge.bs.organization.server.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bs.organization.shared.entities.Organization;
import org.plazmaforge.bs.organization.shared.entities.OrganizationHeader;
import org.plazmaforge.bs.organization.shared.services.OrganizationService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.util.DBUtils;

public class OrganizationServiceImpl extends AbstractEntityService<Organization, Integer> implements OrganizationService {

    protected Class<Organization> getEntityClass() {
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
	try {
	    logCallMethod("addOrganizationToSystem(Integer)");
	    DBUtils.execute(getConnection(), "INSERT INTO ORGANIZATION (ID) VALUES (" + id + ")");
	} catch (SQLException ex) {
	    logError("Service error", ex);
	    throw new DAOException(ex);
	}
    }

    public void removeOrganizationFromSystem(Integer id) throws DAOException {
	try {
	    logCallMethod("removeOrganizationFromSystem(Integer)");
	    DBUtils.execute(getConnection(), "DELETE FROM ORGANIZATION WHERE ID = " + id);
	} catch (SQLException ex) {
	    logError("Service error", ex);
	    throw new DAOException(ex);
	}
    }
    


}
