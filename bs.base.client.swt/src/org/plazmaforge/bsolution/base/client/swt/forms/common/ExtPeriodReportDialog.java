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
 * Created on 12.08.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms.common;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.acceptors.OrganizationAcceptorUtilities;
import org.plazmaforge.framework.client.swt.views.ExtPeriodDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.IReportDialog;


/** 
 * @author Oleh Hapon
 * $Id: ExtPeriodReportDialog.java,v 1.4 2010/12/05 07:57:23 ohapon Exp $
 */

public class ExtPeriodReportDialog extends ExtPeriodDialog implements IReportDialog {

    private Map<String, Object> parameters = new HashMap<String, Object>();
    
    public ExtPeriodReportDialog(Shell parentShell) {
	super(parentShell);
    }

  
    protected Map<String, Object> getParameters() {
        return parameters;
    }

    public boolean isStartReport() throws ApplicationException {
        return (open() == OK) ? true : false;
    }
    
    protected void initData() {
	Date date1 = EnterpriseEnvironment.getYearPeriodStartDate();
	//Date date2 = EnterpriseEnvironment.getYearPeriodEndDate();
	Date date2 = EnterpriseEnvironment.getDate(EnterpriseEnvironment.getYear(), Calendar.DECEMBER, 31);
	
	setStartDate(date1);
	setEndDate(date2);
	
	super.initData();
    }
    
    public Map<String, Object> readParameters() throws ApplicationException {
        Map<String, Object> parameters = new HashMap<String, Object>();
	OrganizationAcceptorUtilities.initPeriodParameters(parameters, getStartDate(), getEndDate());
        return parameters;
    }

}
