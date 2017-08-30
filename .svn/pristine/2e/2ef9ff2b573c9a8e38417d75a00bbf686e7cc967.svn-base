package org.plazmaforge.bsolution.pim.server.services;

import org.plazmaforge.bsolution.pim.PIMContext;
import org.plazmaforge.bsolution.pim.common.beans.PIMAppointmentPriority;
import org.plazmaforge.bsolution.pim.common.beans.PIMAppointmentType;
import org.plazmaforge.bsolution.pim.common.services.PIMContextService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class ERMPIMContextService extends AbstractEntityService<PIMContext, Integer> implements PIMContextService {

    protected Class getEntityClass() {
	return PIMContext.class;
    }

    public PIMContext load() throws DAOException, FinderException {
	PIMContext context =  new PIMContext(); // findById(ID);
	context.setAppointmentType(findAppointmentType());
	context.setAppointmentPriority(findAppointmentPriority());
	return context;
    }
    
    protected PIMAppointmentType findAppointmentType() throws DAOException, FinderException {
	return getEntityManager().load(PIMAppointmentType.class, "code", PIMAppointmentType.APPOINTMENT_TYPE);
    }

    protected PIMAppointmentPriority findAppointmentPriority() throws DAOException, FinderException {
	return getEntityManager().load(PIMAppointmentPriority.class, "code", PIMAppointmentPriority.NORMAL_PRIORITY);
    }
}
