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
package org.plazmaforge.framework.report;


import org.plazmaforge.framework.core.exception.ApplicationException;


import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author Oleh Hapon Date: 01.07.2004 Time: 20:38:51 $Id: ReportEngine.java,v 1.7 2010/12/05 07:51:25 ohapon Exp $
 */
public interface ReportEngine {

    int COMPILE_FILE_TYPE = 1;
    
    int DESIGN_FILE_TYPE = 2;
    
    int PRINT_FILE_TYPE = 3;
    

    
    
    Object fillReport(Class klass, String name, Map parameters) throws ApplicationException;

    Object fillReport(IReport report) throws ApplicationException;

    void viewReport(Class klass, String name, Map parameters)throws ApplicationException;

    void viewReport(Object reportData) throws ApplicationException;

    //void viewReport(String title, JTable table) throws ApplicationException;

    void executeReport(IReport report) throws ApplicationException;

    
    File getFile(IReport report) throws ApplicationException;
    
    File getFile(IReport report, int fileType) throws ApplicationException;
    
    
    InputStream getInputStream(IReport report) throws ApplicationException;
    
    InputStream getInputStream(IReport report, int fileType) throws ApplicationException;
    

    Object doFillReport(Class klass, String name, Map parameters, Connection cn) throws ApplicationException;

    Object doFillReport(IReport report, Connection cn) throws ApplicationException;

    Object doFillReport(IReport report, Map parameters, Connection cn) throws ApplicationException;

    
    Object createDataSourceByMapArray(Object[] mapArray)  throws ApplicationException;
    
    
    List<Object[]>  getSQLResult(Connection cn, String sql, Map parameters) throws ApplicationException;
    
    Object getSQLValue(Connection cn, String sql, Map parameters) throws ApplicationException;
    
    
}
