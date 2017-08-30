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
 * Created on 07.02.2006
 */

package org.plazmaforge.framework.report.service.spring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.config.object.IReportConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.IReport;
import org.plazmaforge.framework.report.ReportEngineFactory;
import org.plazmaforge.framework.report.ReportFactory;
import org.plazmaforge.framework.report.ReportService;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class ReportServiceImpl extends JdbcDaoSupport implements ReportService {

    
   
    
    ////
    
    
    public Object fillReport(String reportName, Map parameters) throws ApplicationException {
	IReportConfig reportConfig = ReportFactory.getReportConfigByName(reportName);
	if (reportConfig == null) {
	    return null;
	}
	IReport report = ReportFactory.getReportByConfig(reportConfig);
	if (report == null) {
	    return null;
	}
	
	// TODO: Must use special report service of the report
	// We use the acceptor only for client side
	
	if (report.getAcceptor() == null) {
	    report.setAcceptor(ReportFactory.getReportAcceptor(reportConfig));
	}
	
	return fillReport(report, parameters);
    }


    public Object fillReport(Class reportClass, String reportName, Map parameters) throws ApplicationException {
	Connection cn = null;
	try {
	    cn = getConnection();
	    return ReportEngineFactory.getReportEngine(reportClass).doFillReport(reportClass, reportName, parameters, cn);
	} finally {
	    //handleCloseConnection(cn);
	}
    }

    public Object fillReport(IReport report, Map parameters) throws ApplicationException {
	Connection cn = null;
	try {
	    cn = getConnection();
	    return ReportEngineFactory.getReportEngine(report).doFillReport(report, parameters, cn);
	} finally {
	    //handleCloseConnection(cn);
	}
    }

    
    
    public List<Object[]>  getSQLResult(Connection cn, String sql, Map parameters) throws ApplicationException {
	ResultSet rs = null;
	Statement stm = null;
	List<Object[]> rows = new ArrayList<Object[]>();
	try {
	    stm = cn.createStatement();
	    rs = stm.executeQuery(sql);
	    ResultSetMetaData md = rs.getMetaData();
	    int columnCount = md.getColumnCount();
	    if (columnCount == 0) {
		return rows;
	    }
	    Object[] row = null;
	    while (rs.next()) {
		row = new Object[columnCount];
		for (int i = 0; i < columnCount; i++) {
		    row[i] = rs.getObject(i + 1);
		}
		rows.add(row);
	    }
	} catch (SQLException ex) {
	    throw new ApplicationException(ex);
	} finally {
	    handleCloseResultSet(rs);
	    handleCloseStatement(stm);
	}
	return rows;
    }
    
    public Object getSQLValue(Connection cn, String sql, Map parameters) throws ApplicationException {
	ResultSet rs = null;
	Statement stm = null;
	try {
	
	    stm = cn.createStatement();
	    rs = stm.executeQuery(sql);
	    ResultSetMetaData md = rs.getMetaData();
	    if (md.getColumnCount() == 0) {
		return null;
	    }
	    if (rs.next()) {
		return rs.getObject(1);
	    }
	} catch (SQLException ex) {
	    throw new ApplicationException(ex);
	} finally {
	    handleCloseResultSet(rs);
	    handleCloseStatement(stm);
	}
	return null;
    }
    
    protected void handleCloseResultSet(ResultSet rs) {
	try {
	    if (rs != null) {
		rs.close();
	    }
	} catch (SQLException ex) {
	    ex.printStackTrace();

	}
    }
    
    protected void handleCloseStatement(Statement stm) {
	try {
	    if (stm != null) {
		stm.close();
	    }
	} catch (SQLException ex) {
	    ex.printStackTrace();

	}
    }


    @Override
    public void setInfo(String info) {
	// TODO Auto-generated method stub
	
    }


    @Override
    public String getInfo() {
	// TODO Auto-generated method stub
	return null;
    }
    

}
