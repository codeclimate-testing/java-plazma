package org.plazmaforge.bsolution.payroll.server.services;

import java.sql.SQLException;
import java.util.List;

import org.plazmaforge.bsolution.payroll.common.beans.EmployeePayroll;
import org.plazmaforge.bsolution.payroll.common.services.EmployeePayrollService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.RemoveException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.util.DBUtils;

public class ERMEmployeePayrollService extends AbstractEntityService<EmployeePayroll, Integer> implements EmployeePayrollService {

    protected Class getEntityClass() {
        return EmployeePayroll.class;
    }

 
    public void removeByEmployee(Integer employeeId) throws DAOException, RemoveException {
	try {
	    DBUtils.execute(getConnection(), "DELETE FROM EMPLOYEE_PAYROLL WHERE EMPLOYEE_ID = ?", new Object[] {employeeId});
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }

    public void removeByEmployeeAndPeriod(Integer employeeId, Integer periodId) throws DAOException, RemoveException {
	try {
	    DBUtils.execute(getConnection(), "DELETE FROM EMPLOYEE_PAYROLL WHERE EMPLOYEE_ID = ? AND PERIOD_ID = ?", new Object[] {employeeId, periodId});
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }


    public List findByEmployee(Integer employeeId) throws DAOException {
	return findByEmployee(employeeId, null);
    }
    
    
    public List findByEmployee(final Integer employeeId, final Criteria criteria) throws DAOException {
	criteria.addFilter("employeeId", employeeId);
	return getEntityManager().findAll(getEntityClass(), criteria);
    }
    
    
    public List findByEmployeeAndPeriod(Integer employeeId, Integer periodId) throws DAOException {
	return findByEmployeeAndPeriod(employeeId, periodId, null);
    }
    
    
    public List findByEmployeeAndPeriod(final Integer employeeId, final Integer periodId, final Criteria criteria) throws DAOException {
	criteria.addFilter("employeeId", employeeId);
	criteria.addFilter("periodId", periodId);
	return getEntityManager().findAll(getEntityClass(), criteria);
    }
    

}
