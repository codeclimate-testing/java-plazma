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

package org.plazmaforge.bsolution.base.client.swt.forms;


import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Period;
import org.plazmaforge.bsolution.base.common.beans.PeriodType;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.structure.PeriodUtils;
import org.plazmaforge.framework.util.DateUtils;

/** 
 * @author Oleh Hapon
 * $Id: PeriodEditForm.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class PeriodEditForm extends AbstractEditForm {


    private Label startDateLabel;

    private Label endDateLabel;

    private Label nameLabel;
    
    
    private XDateCombo startDateField;
    
    private XDateCombo endDateField;    
    
    private XTextField nameField;

    
    private Date startDate;
    
    private Date endDate;

    
    private String periodTypeCode;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PeriodEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("PeriodEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 4;
	setLayout(gridLayout);
    	
    	
    	startDateLabel = new Label(this, SWT.NONE);
	startDateLabel.setText(Messages.getString("PeriodEditForm.startDateLabel.text")); //$NON-NLS-1$

    	startDateField = new XDateCombo(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	startDateField.setLayoutData(gridData);
    	
    	endDateLabel = new Label(this, SWT.NONE);
	endDateLabel.setLayoutData(new GridData());
    	endDateLabel.setText(Messages.getString("PeriodEditForm.endDateLabel.text")); //$NON-NLS-1$

    	endDateField = new XDateCombo(this, SWT.BORDER);    	
    	endDateField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	
    	this.setSize(new Point(470, 108));

    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setLayoutData(new GridData());
    	nameLabel.setText(Messages.getString("PeriodEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	nameField.setLayoutData(gridData);
    	nameField.setEditable(false);
    	
    	startDateField.addFocusListener(new FocusAdapter(){
    	    public void focusLost(FocusEvent e) {
    		generatePeriodName();
    	    }
    	});
    	
    	endDateField.addFocusListener(new FocusAdapter(){
    	    public void focusLost(FocusEvent e) {
    		generatePeriodName();
    	    }
    	});

    }
    
    protected void bindControls() {
	bindControl(startDateField, "startDate", startDateLabel, REQUIRED);
	bindControl(endDateField, "endDate", endDateLabel, REQUIRED);	
	bindControl(nameField, "name");
    }
    
    private void generatePeriodName() {
	if (equals(startDate, startDateField.getDate()) && equals(endDate, endDateField.getDate())) {
	    return;
	}
	startDate = startDateField.getDate();
	endDate = endDateField.getDate();
	nameField.setText(DateUtils.getPeriodName(startDate, endDate));
	
	periodTypeCode = PeriodUtils.getPeriodType(startDate, endDate);
    }
    
    private Period getPeriod() {
	return (Period) getEntity();
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	startDate = startDateField.getDate();
	endDate = endDateField.getDate();
    }
    
    public void updateData()  throws ApplicationException {
	generatePeriodName();
	super.updateData();
	if (periodTypeCode != null) {
	    PeriodType periodType = EnterpriseEnvironment.getContext().getPeriodType(periodTypeCode);
	    if  (periodType == null) {
		periodType = EnterpriseEnvironment.getContext().getCustomPeriodType();
	    }
	    
	    if (periodType == null) {
		throw new RuntimeException("PeriodType is null");
	    }
	    getPeriod().getPeriodType().setId(periodType.getId());
	}
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"

