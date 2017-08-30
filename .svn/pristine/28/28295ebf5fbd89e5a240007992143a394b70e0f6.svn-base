package org.plazmaforge.bs.organization.shared.services;

import java.util.List;

import org.plazmaforge.bs.organization.shared.entities.Organization;
import org.plazmaforge.bs.organization.shared.entities.OrganizationHeader;
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
