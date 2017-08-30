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

/*
 * Created on 20.04.2006
 *
 */

package org.plazmaforge.bsolution.base.server.services;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.service.impl.AbstractSQLCompressionExecutor;


public abstract class BaseCompressionExecutor extends
	AbstractSQLCompressionExecutor {

    protected void executeCompression(Statement stm, Serializable data)
	    throws SQLException, ApplicationException {
	int periodId = ((Integer) data).intValue();
	executeCompression(stm, periodId);
    }

    protected void beforeCompression(Statement stm, Serializable data)
	    throws SQLException, ApplicationException {
	int periodId = ((Integer) data).intValue();
	beforeCompression(stm, periodId);
    }

    protected void afterCompression(Statement stm, Serializable data)
	    throws SQLException, ApplicationException {

	Object[] prm = (Object[]) data;

	int organizationId = getInt(prm[0]);
	int prevPeriodId = getInt(prm[1]);
	int currPeriodId = getInt(prm[2]);
	int newPeriodId = getInt(prm[3]);

	afterCompression(stm, organizationId, prevPeriodId, currPeriodId,
		newPeriodId);
    }

    protected int getInt(Object prm) {
	if (prm == null) {
	    return -1;
	}
	return ((Integer) prm).intValue();
    }

    protected String getNextValueSQL() {
	return getNextValueSQL("register_sequence");
    }

    public abstract void executeCompression(Statement stm, int periodId)
	    throws SQLException, ApplicationException;

    public abstract void beforeCompression(Statement stm, int periodId)
	    throws SQLException, ApplicationException;

    public abstract void afterCompression(Statement stm, int organizationId,
	    int prevPeriodId, int curPeriodId, int newPeriodId)
	    throws SQLException, ApplicationException;

}
