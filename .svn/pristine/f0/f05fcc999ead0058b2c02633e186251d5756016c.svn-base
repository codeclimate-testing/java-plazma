package org.plazmaforge.bsolution.payroll.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.plazmaforge.bsolution.payroll.common.services.PayrollCalculateService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ERMPayrollCalculateService extends JdbcDaoSupport implements PayrollCalculateService {

    public void calculate(Map parameters) throws ApplicationException {
	if (parameters == null) {
	    throw new ApplicationException("Parameters not found");
	}
	Integer periodId = (Integer) parameters.get("PERIOD_ID");
	if (periodId == null) {
	    throw new ApplicationException("[PERIOD_ID] is null");
	}
	Integer organizationId = (Integer) parameters.get("ORGANIZATION_ID");
	if (organizationId == null) {
	    throw new ApplicationException("[ORGANIZATION_ID] is null");
	}
	
	try {
	    calculate(getConnection(), organizationId, periodId);
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.toString());
	}
	
    }

    public void calculate(Connection cn, Integer organizationId, Integer periodId) throws SQLException {
	PayrollCalculateExecutor executor = new PayrollCalculateExecutor();
	executor.setConnection(cn);
	executor.calculate(periodId, organizationId);
    }

    
    @Override
    public void setInfo(String info)  {
	
    }
    
    @Override
    public String getInfo() {
	return null;
    }

}
