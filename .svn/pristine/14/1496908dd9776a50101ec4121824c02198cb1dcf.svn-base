package org.plazmaforge.bsolution.base.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Period;
import org.plazmaforge.bsolution.base.common.beans.PeriodType;
import org.plazmaforge.bsolution.base.common.services.PeriodService;
import org.plazmaforge.bsolution.base.common.services.SystemInfoExecutor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.CreateException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.platform.service.CompressionExecutor;
import org.plazmaforge.framework.platform.service.SQLCompressionExecutor;
import org.plazmaforge.framework.util.DateUtils;

public class PeriodServiceImpl  extends AbstractEntityService<Period, Integer> implements PeriodService {

    protected Class getEntityClass() {
	return Period.class;
    }

    public Period sysFindById(Integer id) throws DAOException, FinderException {
	return findById(id);
    }
    
    public Period findByPeriod(final Date d1, final Date d2) throws DAOException, FinderException {
	Period period = getEntityManager().load(Period.class, new String[] {"startDate", "endDate"}, new Date[] {d1, d2});
	if (period == null) {
	    throw new FinderException("Period [start_date = " + d1 + " , end_date = " + d2 + "] not found");
	}
	return period;
    }

    public Integer registerPeriod(final Integer organizationId, final Integer currPeriodId, final CompressionExecutor[] executors) throws DAOException, FinderException, CreateException {
	try {
	    return registerPeriod(getConnection(), organizationId, currPeriodId, executors);
	} catch (DAOException ex) {
	    throw ex;
	} catch (FinderException ex) {
	    throw ex;
	} catch (CreateException ex) {
	    throw ex;
	} catch (ApplicationException ex) {
	    throw new RuntimeException(ex);
	}

    }

    ////
    
    private Integer registerPeriod(Connection cn, Integer organizationId, Integer currPeriodId, CompressionExecutor[] executors) throws ApplicationException {

	Integer newPeriodId = null;
	try {

	    // TODO: 
	    // We use MONTH period type by default
	    // But user have to input period type in UI
	    // because we can use different period types (MONTH, QUARTER, YEAR)
	    
	    String periodTypeCode = PeriodType.MONTH;
	    PeriodType periodType = EnterpriseEnvironment.getContext().getPeriodType(periodTypeCode);
	    if (periodType == null) {
		periodType = EnterpriseEnvironment.getContext().getPeriodType(PeriodType.CUSTOM);
	    }
	    if (periodType == null) {
		throw new ApplicationException("Period type is unknown");
	    }
	    
	    
	    if (executors == null || executors.length == 0) {
		System.out.println("COMPRESSION IS ZERO");
		return null;
	    }

	    System.out.println("before start...");
	    for (int i = 0; i < executors.length; i++) {
		SQLCompressionExecutor executor = (SQLCompressionExecutor) executors[i];
		executor.setConnection(cn);
		executor.beforeCompression(currPeriodId);
	    }
	    //session.flush(); // ???

	    System.out.println("before complete");
	    for (int i = 0; i < executors.length; i++) {
		SQLCompressionExecutor executor = (SQLCompressionExecutor) executors[i];
		executor.setConnection(cn);
		executor.compression(currPeriodId);
	    }
	    //session.flush(); // ???

	    Period currPeriod = (Period) findById(/*session, */currPeriodId); // ***
	    Integer prevPeriodId = null;
	    if (currPeriod.getPrevPeriodId() != null) {
		prevPeriodId = currPeriod.getPrevPeriodId();
	    }
	    Date endDate = currPeriod.getEndDate();

	    newPeriodId = createNewPeriod(cn, organizationId, prevPeriodId, currPeriodId, endDate, periodType);
	    //session.flush();

	    Object[] prm = new Object[4];
	    prm[0] = organizationId;
	    prm[1] = prevPeriodId;
	    prm[2] = currPeriodId;
	    prm[3] = newPeriodId;

	    for (int i = 0; i < executors.length; i++) {
		SQLCompressionExecutor executor = (SQLCompressionExecutor) executors[i];
		executor.setConnection(cn);
		executor.afterCompression(prm);
	    }

	    //session.flush(); // ???

	    if (newPeriodId != null) {
		SystemInfoExecutor sd = getSystemInfoExecutor();
		sd.setConnection(cn);
		sd.setPriodId(newPeriodId);
	    }
	    //session.flush(); // ???

	} catch (SQLException e) {
	    throw new DAOException(e);
	}
	return newPeriodId;
    }


    protected Integer createNewPeriod(Connection cn, Integer organizationId, Integer prevPeriodId, Integer curPeriodId, Date endDate, PeriodType periodType) throws ApplicationException {

	Integer newPeriodId = null;

	Calendar calendar = Calendar.getInstance();
	calendar.setTime(endDate);
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);
	
	// TODO: Implement only for MONTH period type
	
	// Next month
	if (month == Calendar.DECEMBER) {
	    month = Calendar.JANUARY;
	    year++;
	} else {
	    month++;
	}
	Calendar c1 = Calendar.getInstance();
	c1.set(year, month, 1, 0, 0, 0);
	
	// Next month + 1
	if (month == Calendar.DECEMBER) {
	    month = Calendar.JANUARY;
	    year++;
	} else {
	    month++;
	}
	
	Calendar c2 = Calendar.getInstance();
	c2.set(year, month, 1, 0, 0, 0);
	c2.add(Calendar.DAY_OF_MONTH, -1);

	Date d1 = new Date(c1.getTimeInMillis());
	Date d2 = new Date(c2.getTimeInMillis());
	
	try {
	    newPeriodId = findByPeriod(d1, d2).getId(); // ***
	    System.out.println("Period [startDate = " + d1 + " AND endDate = " + d2 + "] is found!");
	} catch (FinderException e) {
	    Period newPeriod = new Period();
	    newPeriod.setStartDate(d1);
	    newPeriod.setEndDate(d2);
	    newPeriod.setName(DateUtils.getPeriodName(newPeriod.getStartDate(), newPeriod.getEndDate()));
	    newPeriod.setPeriodType(periodType);
	    newPeriod.setPrevPeriodId(curPeriodId);
	    newPeriodId = ((Integer) create(newPeriod)); // ***
	}
	return newPeriodId;

    }

    protected SystemInfoExecutor getSystemInfoExecutor() {
	SystemInfoExecutor executor = new SystemInfoExecutorImpl();
	return executor;
    }

}
