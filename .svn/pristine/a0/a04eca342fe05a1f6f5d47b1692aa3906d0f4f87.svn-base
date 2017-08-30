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
 * 18.02.2006
 */

package org.plazmaforge.framework.report;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.core.AbstractAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;


public abstract class AbstractReportDialogAcceptor extends AbstractAcceptor {

    private IReportDialog reportDialog;

    public AbstractReportDialogAcceptor() {
    }

    public IReportDialog getReportDialog() {
	if (reportDialog == null) {
	    reportDialog = createReportDialog();
	}
	return reportDialog;
    }

    protected abstract IReportDialog createReportDialog();

    public void setReportDialog(IReportDialog reportDialog) {
	this.reportDialog = reportDialog;
    }

    public Map<String, Object> readParameters() throws ApplicationException {
	IReportDialog reportDialog = getReportDialog();
	if (reportDialog == null) {
	    return new HashMap<String, Object>();
	}
	return reportDialog.readParameters();
    }

    public boolean isStartProcess() throws ApplicationException {
	IReportDialog reportDialog = getReportDialog();
	if (reportDialog == null) {
	    return true;
	}
	return reportDialog.isStartReport();
    }
    
    public List<Object[]>  getSQLResult(String sql, Map parameters) throws ApplicationException {
	ReportEngine reportEngine = (ReportEngine) parameters.get(REPORT_ENGINE);
	Connection cn = (Connection) parameters.get(REPORT_CONNECTION);
	if (reportEngine == null || cn == null) {
	    return null;
	}
	return reportEngine.getSQLResult(cn, sql, parameters);
    }
    
    public Object getSQLValue(String sql, Map parameters) throws ApplicationException {
	ReportEngine reportEngine = (ReportEngine) parameters.get(REPORT_ENGINE);
	Connection cn = (Connection) parameters.get(REPORT_CONNECTION);
	if (reportEngine == null || cn == null) {
	    return null;
	}
	return reportEngine.getSQLValue(cn, sql, parameters);
    }

    
    protected ReportEngine getReportEngine(Map prms) {
	return (ReportEngine) prms.get(REPORT_ENGINE);
    }

    protected Connection getConnection(Map prms) {
	return (Connection) prms.get(REPORT_CONNECTION);
    }

}
