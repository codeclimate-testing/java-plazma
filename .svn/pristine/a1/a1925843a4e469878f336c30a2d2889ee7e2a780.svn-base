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

package org.plazmaforge.framework.platform.service.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.dao.AbstractSQLExecutor;
import org.plazmaforge.framework.platform.service.SQLCompressionExecutor;


/**
 * Abstract compression executor
 * 
 * @author hapon
 * 
 */
public abstract class AbstractSQLCompressionExecutor extends
	AbstractSQLExecutor implements SQLCompressionExecutor {

    /** Parameters * */
    Map parameters = new HashMap();

    /**
     * Get parameters
     * 
     * @return
     */
    protected Map getParameters() {
	if (parameters == null) {
	    parameters = new HashMap();
	}
	return parameters;
    }

    /**
     * Set parameters
     */
    public void setParameters(Map parameters) {
	this.parameters = parameters;
    }

    public void setParameter(Object key, Object value) {
	getParameters().put(key, value);
    }

    /**
     * Compression period by data
     */
    public void compression(Serializable data) throws ApplicationException {
	Statement stm = null;
	try {
	    stm = createStatement();
	    this.executeCompression(stm, data);
	} catch (SQLException ex) {
	    throw new DAOException(ex);
	} finally {
	    close(stm);
	}
    }

    public void beforeCompression(Serializable data)
	    throws ApplicationException {
	Statement stm = null;
	try {
	    stm = createStatement();
	    this.beforeCompression(stm, data);
	} catch (SQLException ex) {
	    throw new DAOException(ex);
	} finally {
	    close(stm);
	}
    }

    public void afterCompression(Serializable data) throws ApplicationException {
	Statement stm = null;
	try {
	    stm = createStatement();
	    this.afterCompression(stm, data);
	} catch (SQLException ex) {
	    throw new DAOException(ex);
	} finally {
	    close(stm);
	}
    }

    /**
     * Execute compression period by data
     * 
     * @param data
     * @throws SQLException
     */
    protected abstract void executeCompression(Statement stm, Serializable data)
	    throws SQLException, ApplicationException;

    /**
     * Before compression
     * 
     * @param data
     * @throws ApplicationException
     */
    protected abstract void beforeCompression(Statement stm, Serializable data)
	    throws SQLException, ApplicationException;

    /**
     * After compression
     * 
     * @param data
     * @throws ApplicationException
     */
    protected abstract void afterCompression(Statement stm, Serializable data)
	    throws SQLException, ApplicationException;

}