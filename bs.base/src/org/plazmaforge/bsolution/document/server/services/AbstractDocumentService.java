package org.plazmaforge.bsolution.document.server.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.plazmaforge.bsolution.base.common.beans.Period;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.bsolution.organization.server.services.AbstractOrganizableService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.Order;

public abstract class AbstractDocumentService<E, PK extends Serializable> extends AbstractOrganizableService<E, PK> {

    
    
    public static final String PARTNER_ID_PROPERTY = "partnerId";
    
    public static final String PERIOD_ID_PROPERTY = "periodId";
    
    public static final String DATE_PROPERTY = "documentDate";
    
    
    
    private String partnerIdProperty = PARTNER_ID_PROPERTY;
    
    private String periodIdProperty = PERIOD_ID_PROPERTY;
    
    private String dateProperty = DATE_PROPERTY;
    
    
    
    
    
    public String getPartnerIdProperty() {
        return partnerIdProperty;
    }

    public void setPartnerIdProperty(String partnerIdProperty) {
        this.partnerIdProperty = partnerIdProperty;
    }
    

    public String getPeriodIdProperty() {
        return periodIdProperty;
    }

    public void setPeriodIdProperty(String periodIdProperty) {
        this.periodIdProperty = periodIdProperty;
    }
    

    public String getDateProperty() {
        return dateProperty;
    }

    public void setDateProperty(String dateProperty) {
        this.dateProperty = dateProperty;
    }
    
    
    ////
    
    public List findByPartnerId(Integer partnerId) throws DAOException {
	return findByPartnerId(partnerId, null);
    }
    
    public List findByPartnerId(final Integer partnerId, final Criteria criteria) {
	criteria.addFilter(getPartnerIdProperty(), partnerId);
	return getEntityManager().findAll(getEntityClass(), criteria);
    }
    
    
    ////
    

    /**
     * Find documents by organizationId (my company) and periodId
     * @param organizationId
     * @param periodId
     * @return documents
     * @throws DAOException
     */
    public List findByOrganizationIdAndPeriodId(Integer organizationId, Integer periodId) throws DAOException {
	return findByOrganizationIdAndPeriodId(organizationId, periodId, null);
    }
    
    
    ////
    
    
    public List findByOrganizationIdAndPeriodId(Integer organizationId, Integer periodId, Integer partnerId) throws DAOException {
	return findByOrganizationIdAndPeriodId(organizationId, periodId, partnerId, null);
    }
    
    
    /**
     * Find documents by organizationId (my company), periodId and partnerId
     * @param organizationId
     * @param periodId
     * @param partnerId
     * @return documents
     * @throws DAOException
     */
    public List findByOrganizationIdAndPeriodId(final Integer organizationId, final Integer periodId, final Integer partnerId, final Criteria criteria) throws DAOException {
	addOrganizationFilter(organizationId, criteria);
	addPeriodFilter(periodId, criteria);
	addPartnerFilter(partnerId, criteria);
	return getEntityManager().findAll(getEntityClass(), criteria);
    }
    
    ////
    
    protected void addOrganizationFilter(Integer organizationId, Criteria criteria) {
	if (organizationId == null) {
	    return;
	}
	criteria.addFilter(getOrganizationIdProperty(), organizationId);
    }

    protected void addPeriodFilter(Integer periodId, Criteria criteria) {
	if (periodId == null) {
	    return;
	}
	criteria.addFilter(getPeriodIdProperty(), periodId);
    }

    protected void addPartnerFilter(Integer partnerId, Criteria criteria) {
	if (partnerId == null) {
	    return;
	}
	criteria.addFilter(getPartnerIdProperty(), partnerId);
    }
    
    protected void addDateOrder(Criteria criteria) {
	criteria.addOrder(new Order(getDateProperty()));
    }
    
    ////
    
    /**
     * @deprecated
     * @param organization
     * @param period
     * @return documents
     * @throws DAOException
     */
    public List findByOrganizationIdAndPeriodId(OrganizationHeader organization, Period period) throws DAOException {
        return findByOrganizationIdAndPeriodId(organization.getId(), period.getId());
    }


    /**
     * Find documents by organizationId (my company) and date interval
     * @param organizationId
     * @param startDate
     * @param endDate
     * @return documents
     * @throws DAOException
     */
    public List findByOrganizationIdAndInterval(Integer organizationId, Date startDate, Date endDate) throws DAOException {
	return findByOrganizationIdAndInterval(organizationId, startDate, endDate, null);
    }

    
    ////
    
    public List findByOrganizationIdAndInterval(final Integer organizationId, final Date startDate, final Date endDate, final Integer partnerId) throws DAOException {
	return findByOrganizationIdAndInterval(organizationId, startDate, endDate, partnerId, null);
    }
    
    
    /**
     * Find documents by organizationId (my company), date interval and partnerId
     * @param organizationId
     * @param startDate
     * @param endDate
     * @param partnerId
     * @return documents
     * @throws DAOException
     */
    public List findByOrganizationIdAndInterval(final Integer organizationId, final Date startDate, final Date endDate, final Integer partnerId, final Criteria criteria) throws DAOException {
	
	addOrganizationFilter(organizationId, criteria);
	addPartnerFilter(partnerId, criteria);

	//if (startDate == null && endDate == null) {
        //    return criteria.list();
        //}

        if (startDate != null) {
            criteria.addFilter(getDateProperty(), startDate, ">=");
        }
        if (endDate != null) {
            criteria.addFilter(getDateProperty(), endDate, "<=");
        }

        //addDateOrder(criteria)
	return getEntityManager().findAll(getEntityClass(), criteria);
	
    }
    

}
