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
package org.plazmaforge.bsolution.base.server.services;


import java.sql.SQLException;
import java.sql.Statement;

import org.plazmaforge.bsolution.base.common.services.SystemInfoExecutor;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.dao.AbstractSQLExecutor;


/**
 * @author Oleh Hapon
 * Date: 04.09.2004
 * Time: 10:21:32
 * $Id: SystemInfoExecutorImpl.java,v 1.4 2010/12/05 07:55:58 ohapon Exp $
 */
public class SystemInfoExecutorImpl extends AbstractSQLExecutor implements SystemInfoExecutor {

    public void setPriodId(Integer periodId) throws SQLException, FinderException {
        Statement st = null;
        try {
            st = createStatement();
            if (st.executeUpdate("UPDATE ENTERPRISE_CONTEXT SET PERIOD_ID = " + periodId) < 1) {
                throw new FinderException("Can't update [enterprise context]");
            }
        } finally {
            close(st);
        }
    }
}
