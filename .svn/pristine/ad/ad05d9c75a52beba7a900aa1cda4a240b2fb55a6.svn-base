/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

package org.plazmaforge.bsolution.carservice.server.services;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlFindReport;
import org.plazmaforge.bsolution.carservice.common.services.CarMtrlFindReportService;
import org.plazmaforge.bsolution.document.common.beans.DocumentHeader;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.goods.server.services.AbstractGoodsDocumentService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.springframework.orm.hibernate3.HibernateCallback;

public class CarMtrlFindReportServiceImpl extends AbstractGoodsDocumentService<CarMtrlFindReport, Integer> implements CarMtrlFindReportService {

    protected Class getEntityClass() {
        return CarMtrlFindReport.class;
    }

    protected void preparePartnerMove(final FinanceDocument document) {
        //preparePartnerMoveByPartnerableDocument((PartnerableDocument) document);
    }


    protected void prepareWarehouseMove(FinanceDocument document) {
        //prepareWarehouseMoveByWarehouseDocument((WarehouseDocument) document);
    }

    protected void initializeEntityList(Session session, List list) {
	super.initializeEntityList(session, list);
	if (isEmpty(list)) {
	    return;
	}
	int size = list.size();
	for (int i= 0; i < size; i++) {
	    loadCarServOrder(session, list.get(i));
	}
    }
 
    // AFTER INIT
    protected void doAfterInit(Session session, final Object entity) throws HibernateException, SQLException, ApplicationException {
	CarMtrlFindReport carMtrlFindReport = getCastEntity(entity);
	loadCarServOrder(session, carMtrlFindReport);
	super.doAfterInit(session, entity);
    }

    protected void loadCarServOrder(Session session, Object entity) {
	if (entity == null) {
	    return;
	}
	if (entity instanceof CarMtrlFindReport) {
	    CarMtrlFindReport carMtrlFindReport = (CarMtrlFindReport) entity;
	    loadCarServOrder(session, carMtrlFindReport);
	}
    }
    
    
    protected void loadCarServOrder(Session session, CarMtrlFindReport carMtrlFindReport) {
	if (carMtrlFindReport == null) {
	    return;
	}
	DocumentHeader request = carMtrlFindReport.getCarMtrlFindRequest();
	if (request == null) {
	    return;
	}
	DocumentHeader carServOrder = getCarServOrderByRequestId(session, request.getId());
	if (carServOrder != null) {
	    carMtrlFindReport.setCarServOrder(carServOrder);
	}
    }
    
    protected DocumentHeader getCarServOrderByRequestId(Session session, Integer requestId) {
	if (requestId == null) {
	    return null;
	}
	SQLQuery query = session.createSQLQuery("SELECT CAR_SERV_ORDER_ID FROM CAR_MTRL_FIND_REQUEST WHERE ID = " + requestId );
	List list = query.list();
	if (isEmpty(list)) {
	    return null;
	}
	Integer id = (Integer) list.get(0);
	return (DocumentHeader) session.load(DocumentHeader.class, id);
    }

    
    protected DocumentHeader getCarServOrderById(Session session, Integer id) {
	return (DocumentHeader) session.load(DocumentHeader.class, id);
    }
    
    
    /////
    
    
    public DocumentHeader findCarServOrderByRequestId(final Integer requestId) throws DAOException {
	return (DocumentHeader) getHibernateTemplate().execute(new HibernateCallback() {
	    public Object doInHibernate(Session session) throws HibernateException, SQLException {
		DocumentHeader order = getCarServOrderByRequestId(session, requestId);
		return order;
	    }
	});
    }

}
