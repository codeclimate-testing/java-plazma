package org.plazmaforge.bsolution.project.server.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.organization.server.services.AbstractResponsableService;
import org.plazmaforge.bsolution.project.common.beans.Task;
import org.plazmaforge.bsolution.project.common.services.TaskService;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.ICalendarEvent;

public class ERMTaskService extends AbstractResponsableService<Task, Integer> implements TaskService {

    protected Class getEntityClass() {
        return Task.class;
    }
    
    public List<ICalendarEvent> findCalendarEvents(Date startDate, Date endDate, Map<String, Object> parameters) throws ApplicationException {
	if (startDate == null) {
	    return null;
	}
	if (endDate != null && endDate.before(startDate)) {
	    // Reset incorrect early endDate
	    endDate = null;
	}
	Integer organizationId = (Integer) parameters.get("ORGANIZATION_ID");
	Integer responsibleId = (Integer) parameters.get("RESPONSIBLE_ID");
	Criteria criteria = (Criteria) parameters.get(Criteria.CRITERIA);
	List list = findByOrganizationId(organizationId, responsibleId, criteria);
	if (list == null) {
	    return null;
	}
	List<ICalendarEvent> events = new ArrayList<ICalendarEvent>();
	int count = list.size();
	for (int i = 0; i < count; i++) {
	    ICalendarEvent event = (ICalendarEvent) list.get(i);
	    
	    // TODO: Must use SQL (ICriteria) for date range
	    Date eventDate = event.getEventDate();
	    if (eventDate == null || eventDate.before(startDate) || (endDate != null && eventDate.after(endDate)) ) {
		continue;
	    }
	    
	    
	    events.add(event);
	}
	return events;
    }

}
