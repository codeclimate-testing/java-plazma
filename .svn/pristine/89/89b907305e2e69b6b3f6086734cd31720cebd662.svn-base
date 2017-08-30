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

package org.plazmaforge.bsolution.base.client.swt.forms.common;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.acceptors.OrganizationAcceptorUtilities;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.dialogs.AbstractReportDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: PeriodReportDialog.java,v 1.5 2010/12/05 07:57:23 ohapon Exp $
 */

public class PeriodReportDialog extends AbstractReportDialog {

    private Label startDateLabel;
    private Label endDateLabel;
    
    private XDateCombo startDateField;
    private XDateCombo endDateField;    
    
   
    public PeriodReportDialog(Shell parent) {
	super(parent);
    }
    
    protected void configureShell(Shell newShell) {
	super.configureShell(newShell);
	newShell.setText(Messages.getString("PeriodReportDialog.title"));
    }
    
    protected void createContent(Composite parent) {
	GridLayout gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	parent.setLayout(gridLayout);
    	GridData gridData;
    	
    	startDateLabel = new Label(parent, SWT.NONE);
    	startDateLabel.setText(Messages.getString("PeriodReportDialog.startDate")); //$NON-NLS-1$
    	gridData = new GridData(100, SWT.DEFAULT);    	
    	startDateLabel.setLayoutData(gridData);
    	
    	startDateField = new XDateCombo(parent, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	startDateField.setLayoutData(gridData);
    	
    	endDateLabel = new Label(parent, SWT.NONE);
    	endDateLabel.setText(Messages.getString("PeriodReportDialog.endDate")); //$NON-NLS-1$
    	gridData = new GridData(100, SWT.DEFAULT);
    	endDateLabel.setLayoutData(gridData);
    	
    	endDateField = new XDateCombo(parent, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	endDateField.setLayoutData(gridData);
    	
    	
    	
	Date date1 = EnterpriseEnvironment.getYearPeriodStartDate();
	//Date date2 = EnterpriseEnvironment.getYearPeriodEndDate();
	Date date2 = EnterpriseEnvironment.getDate(EnterpriseEnvironment.getYear(), Calendar.DECEMBER, 31);
	
	startDateField.setDate(date1);
	endDateField.setDate(date2);
    	
    	
    }
    
    public Map<String, Object> readParameters() throws ApplicationException {
        Map<String, Object> parameters = new HashMap<String, Object>();
	OrganizationAcceptorUtilities.initPeriodParameters(parameters, startDateField.getDate(), endDateField.getDate());
        return parameters;
    }
}
