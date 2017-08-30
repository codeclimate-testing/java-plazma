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

import java.util.HashMap;
import java.util.Map;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.acceptors.OrganizationAcceptorUtilities;
import org.plazmaforge.framework.client.swt.dialogs.AbstractReportDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 */

public class YearReportDialog extends AbstractReportDialog {

    private Label yearLabel;
    
    private Spinner yearField;
   
    ////
    
    private int year;

    public YearReportDialog(Shell parent) {
	super(parent);
    }
    
    protected void configureShell(Shell newShell) {
	super.configureShell(newShell);
	newShell.setText(Messages.getString("YearReportDialog.title"));
    }
    
    protected void createContentPanel(Composite parent) {
	GridLayout gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	parent.setLayout(gridLayout);
    	GridData gridData;
    	
    	yearLabel = new Label(parent, SWT.NONE);
    	yearLabel.setText(Messages.getString("YearReportDialog.year")); //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	yearLabel.setLayoutData(gridData);
    	
    	yearField = new Spinner(parent, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 80;
    	yearField.setLayoutData(gridData);
    	
    	initYearSpinner(yearField);
    }
    
    protected void initYearSpinner(Spinner spinner) {
	spinner.setMinimum(1900);
	spinner.setMaximum(3000);
    }
    
    protected void initData() {
	super.initData();
	int year = EnterpriseEnvironment.getPeriodStartYear();
	setYear(year);
	yearField.setSelection(year);
    }
    
    protected void populateData() {
	super.populateData();
	setYear(yearField.getSelection());
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public Map<String, Object> readParameters() throws ApplicationException {
        Map<String, Object> prms = new HashMap<String, Object>();
        OrganizationAcceptorUtilities.initYearParameter(prms, getYear());
        return prms;
    }
    
}
