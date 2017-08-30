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
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerContractVariant;
import org.plazmaforge.bsolution.carservice.common.services.CarInsurerContractVariantService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.service.hibernate.AbstractHibernateEntityService;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarInsurerContractVariantServiceImpl.java,v 1.3 2010/12/05 07:53:47 ohapon Exp $
 */
public class CarInsurerContractVariantServiceImpl extends AbstractHibernateEntityService<CarInsurerContractVariant, Integer> implements CarInsurerContractVariantService {

    protected Class getEntityClass() {
        return CarInsurerContractVariant.class;
    }

    public CarInsurerContractVariant getLastContractByInsurer(final Integer insurerId) throws DAOException, FinderException {
	if (insurerId == null) {
	    return null;
	}
	
	Integer id = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
	    public Object doInHibernate(Session session) throws HibernateException, SQLException {
		SQLQuery query = session.createSQLQuery(
			"SELECT ID FROM CAR_INSURER_CONTRACT_VARIANT WHERE INSURER_ID = " + insurerId 
			+ " AND CONTRACT_DATE = (SELECT MAX(CONTRACT_DATE) FROM CAR_INSURER_CONTRACT_VARIANT WHERE INSURER_ID = " + insurerId + ")");
		List list = query.list();
		if (list == null || list.isEmpty()) {
		    return null;
		}
		return list.get(0);
	    }
	});
	
	if (id == null) {
	    return null;
	}
	
	return findById(id);
    }
}
