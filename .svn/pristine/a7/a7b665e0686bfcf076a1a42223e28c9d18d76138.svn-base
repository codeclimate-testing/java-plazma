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

/**
 * 07.02.2006
 */
package org.plazmaforge.framework.report;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.Service;


public interface ReportService extends Service {

    // Stub
    Object fillReport(Class klass, String reportName, Map parameters) throws ApplicationException;

    // Stub
    // Object fillReport(Report report) throws ApplicationException;

    Object fillReport(String reportName, Map parameters) throws ApplicationException;
    
    
    List<Object[]>  getSQLResult(Connection cn, String sql, Map parameters) throws ApplicationException;
    
    Object getSQLValue(Connection cn, String sql, Map parameters) throws ApplicationException;

}
