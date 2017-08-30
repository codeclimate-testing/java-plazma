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
 * Created on 12.07.2007
 *
 */

package org.plazmaforge.bsolution.payroll.client.swt.forms;




import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/** 
 * @author Oleh Hapon
 * $Id: EmployeeVacationAverangeEditForm.java,v 1.2 2010/04/28 06:31:06 ohapon Exp $
 */

public class EmployeeVacationAverangeEditForm extends AbstractEditForm {
    
    private Label monthLabel;
    
    private Label workDayLabel;
    
    private Label vacationDayLabel;
    
    private Label addVacationDayLabel;
    
    private Label amountLabel;
    
    
    private XIntegerField monthField;
    
    private XIntegerField workDayField;
    
    private XIntegerField vacationDayField;
    
    private XIntegerField addVacationDayField;
    
    private XCurrencyField amountField;
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public EmployeeVacationAverangeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("EmployeeVacationAverangeEditForm.title")); //$NON-NLS-1$
	setDataSourceSupport(false);
	
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
       	monthLabel = new Label(this, SWT.NONE);
	monthLabel.setText(Messages.getString("EmployeeVacationAverangeEditForm.monthLabel.text")); //$NON-NLS-1$

    	monthField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 100;
    	monthField.setLayoutData(gridData);
    	
    	
    	workDayLabel = new Label(this, SWT.NONE);
    	workDayLabel.setText(Messages.getString("EmployeeVacationAverangeEditForm.workDayLabel.text")); //$NON-NLS-1$

    	workDayField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	workDayField.setLayoutData(gridData);
    	
    	
	vacationDayLabel = new Label(this, SWT.NONE);
    	vacationDayLabel.setText(Messages.getString("EmployeeVacationAverangeEditForm.vacationDayLabel.text")); //$NON-NLS-1$

    	vacationDayField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	vacationDayField.setLayoutData(gridData);

    	
	addVacationDayLabel = new Label(this, SWT.NONE);
	addVacationDayLabel.setText(Messages.getString("EmployeeVacationAverangeEditForm.addVacationDayLabel.text")); //$NON-NLS-1$

	addVacationDayField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	addVacationDayField.setLayoutData(gridData);

    	
    	amountLabel = new Label(this, SWT.NONE);
    	amountLabel.setText(Messages.getString("EmployeeVacationAverangeEditForm.amountLabel.text")); //$NON-NLS-1$

    	amountField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 100;
    	amountField.setLayoutData(gridData);
    	
    	this.setSize(new Point(470, 108));
    	
    }
    
    protected void bindControls() {
	bindControl(monthField, "month", monthLabel, REQUIRED);
	bindControl(workDayField, "workDay");
	bindControl(vacationDayField, "vacationDay");
	bindControl(addVacationDayField, "addVacationDay");
	bindControl(amountField, "amount");
    }
    
    
    
}  //  @jve:decl-index=0:visual-constraint="10,10"




