package org.plazmaforge.bsolution.payroll.server.services;


import org.plazmaforge.bsolution.document.server.services.AbstractDocumentService;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeResult;
import org.plazmaforge.bsolution.payroll.common.services.EmployeeResultService;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.Filter;
import org.plazmaforge.framework.core.criteria.NullFilter;
import org.plazmaforge.framework.core.criteria.ValueFilter;
import org.plazmaforge.framework.ext.service.OwnCriteriaService;

public class ERMEmployeeResultService extends AbstractDocumentService<EmployeeResult, Integer> implements EmployeeResultService, OwnCriteriaService {
	
    protected Class getEntityClass() {
        return EmployeeResult.class;
    }

    protected void addPeriodFilter(Integer periodId, Criteria criteria) {
	Filter condition1 = new ValueFilter(getPeriodIdProperty(), periodId);
	Filter condition2 = new NullFilter(getPeriodIdProperty());
	criteria.addOrFilter(condition1, condition2);
    }
    
}
