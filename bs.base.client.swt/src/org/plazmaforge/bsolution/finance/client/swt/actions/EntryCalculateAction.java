package org.plazmaforge.bsolution.finance.client.swt.actions;

import java.util.HashMap;
import java.util.Map;


import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.finance.common.services.EntryCalculateService;
import org.plazmaforge.framework.client.swt.action.SWTProcessAction;
import org.plazmaforge.framework.client.swt.app.SWTProcessRunner;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.util.StringUtils;

public class EntryCalculateAction extends SWTProcessAction {
    
    public void executeProcess() throws ApplicationException {
	
	EntryCalculateService service = (EntryCalculateService) ServiceFactory.getService(EntryCalculateService.class);
	Map parameters = new HashMap();
	parameters.put("ORGANIZATION_ID", EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext()));
	parameters.put("PERIOD_ID", EnterpriseEnvironment.getPayrollPeriodId());
	Map outParameters = service.calculate(parameters);

	String message = getMessage(outParameters);
	if (!StringUtils.isEmpty(message)) {
	    getRunner().setResultMessage(message);
	}
	
    }
    
    protected void initRunner(SWTProcessRunner runner) {
	runner.setConfirmDialog(true);
	runner.setResultDialog(true);
	
	runner.setConfirmMessage(Messages.getString("EntryCalculateAction.confirm"));
	runner.setResultMessage(Messages.getString("EntryCalculateAction.result"));
    }

    
    protected String getMessage(Map parameters) {
	if (parameters == null) {
	    return null;
	}
	Object value = parameters.get("MESSAGE");
	if (value instanceof String) {
	    return (String) value;
	}
	return null;
    }
    
}