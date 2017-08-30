package org.plazmaforge.bsolution.organization.common.services;

import java.util.List;

import org.plazmaforge.bsolution.organization.common.beans.Organization;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.EntityService;


/**
 * 
 * @author ohapon
 *
 */
public interface OrganizationService extends EntityService<Organization, Integer> {

   void addOrganizationToSystem(final Integer id) throws DAOException;
   
   void removeOrganizationFromSystem(final Integer id) throws DAOException;
   
   Object sysFindHeaderById(Integer id) throws DAOException;
   
   List<OrganizationHeader> sysFindAll() throws DAOException;
}
