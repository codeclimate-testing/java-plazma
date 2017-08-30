package org.plazmaforge.bsolution.employee.server.services;

import org.plazmaforge.bsolution.employee.common.beans.Employee;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.employee.common.services.EmployeeService;
import org.plazmaforge.bsolution.organization.server.services.AbstractOrganizableService;
import org.plazmaforge.framework.ext.service.OwnCriteriaService;

public class EmployeeServiceImpl extends AbstractOrganizableService<Employee, Integer> implements EmployeeService, OwnCriteriaService {

    protected Class getEntityClass() {
	return Employee.class;
    }

    protected Class getEntityHeaderClass() {
	return EmployeeHeader.class;
    }

}
