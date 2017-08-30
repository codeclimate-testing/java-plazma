package org.plazmaforge.bsolution.base.common.acceptors;

import java.util.Map;

import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.framework.core.DefaultAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class OrganizationPeriodAcceptor extends DefaultAcceptor {

    public Map<String, Object> readParameters() throws ApplicationException {
	// TODO: Must use context parameter. SessionEnvironment.getContext() !!!
	OrganizationAcceptorUtilities.initOrganizationParameters(getParameters(), SessionEnvironment.getContext());
	OrganizationAcceptorUtilities.initPeriodParameters(getParameters());
	return getParameters();
    }
}
