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

package org.plazmaforge.framework.client.swt.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.plazmaforge.framework.ext.structure.TimeSheet;
import org.plazmaforge.framework.util.FormatUtils;

public class CTimeSheet extends Composite {

    private Label daysLabel;
    private Label hoursLabel;
    private Label workMinutesLabel;
    
    private Spinner daysField;
    private Spinner hoursField;
    private Spinner minutesField;
    
    public CTimeSheet(Composite parent, int style) {
	super(parent, style);
	intitialize();
    }

    private void intitialize() {
	GridData gridData;

	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 0;
	gridLayout.marginTop = 0;
	gridLayout.marginLeft = 0;
	gridLayout.marginRight = 0;
	gridLayout.marginWidth = 0;
	gridLayout.marginHeight = 0;
	
    	gridLayout.numColumns = 6;
    	
    	setLayout(gridLayout);
 	daysField = new Spinner(this, SWT.BORDER);
    	daysLabel = new Label(this, SWT.NONE);
    	daysLabel.setText(Messages.getString("days"));
    	
    	hoursField = new Spinner(this, SWT.BORDER);
 	gridData = new GridData();
 	gridData.horizontalIndent = 10;
 	hoursField.setLayoutData(gridData);
    	hoursLabel = new Label(this, SWT.NONE);
    	hoursLabel.setText(Messages.getString("hours"));

    	minutesField = new Spinner(this, SWT.BORDER);
 	gridData = new GridData();
 	gridData.horizontalIndent = 10;
 	minutesField.setLayoutData(gridData);
    	workMinutesLabel = new Label(this, SWT.NONE);
    	workMinutesLabel.setText(Messages.getString("minutes"));
    }
    
    public void setDays(int days) {
	daysField.setSelection(days);
    }
    
    public void setHours(int hours) {
	hoursField.setSelection(hours);
    }

    public void setMinutes(int minutes) {
	minutesField.setSelection(minutes);
    }

    public int getDays() {
	return daysField.getSelection();
    }
    
    public int getHours() {
	return hoursField.getSelection();
    }

    public int getMinutes() {
	return minutesField.getSelection();
    }
    
    public void setTimeSheet(int days, int hours, int minutes) {
	setDays(days);
	setHours(hours);
	setMinutes(minutes);
    }
    
    public void setTimeSheet(TimeSheet timeSheet) {
	if (timeSheet == null) {
	    setTimeSheet(0, 0, 0);
	    return;
	}
	setTimeSheet(timeSheet.getDays(), timeSheet.getHours(), timeSheet.getMinutes());
    }
    
    public TimeSheet getTimeSheet() {
	return new TimeSheet(getDays(), getHours(), getMinutes());
    }
    
    public String getFormatTime() {
	return FormatUtils.formatTimeSheet(getDays(), getHours(), getMinutes());
    }
}
