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

package org.plazmaforge.framework.client.swt.views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;



import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.plazmaforge.framework.client.swt.controls.XCombo;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.ext.structure.DatePeriod;
import org.plazmaforge.framework.ext.structure.PeriodUtils;
import org.plazmaforge.framework.util.DateUtils;

/** 
 * @author Oleh Hapon
 * $Id: ExtPeriodDialog.java,v 1.7 2010/12/05 07:52:25 ohapon Exp $
 */

public class ExtPeriodDialog extends Dialog {

    
    public static final int ALL_MODE = 0;
    
    public static final int YEAR_MODE = 1;
    
    public static final int QUARTER_MODE = 2;
    
    public static final int MONTH_MODE = 3;
    
    public static final int PERIOD_MODE = 4;
    
    public static final int DEFAULT_MODE = PERIOD_MODE;
    
    
    private int mode = DEFAULT_MODE;
    
    private boolean singleMode = false;
    
    private Label startDateLabel;
    private Label endDateLabel;
    
    
    private Spinner yearModeYearField;
    private XCombo quarterModeQuarterField;
    private Spinner quarterModeYearField;
    private XCombo monthModeMonthField;
    private Spinner monthModeYearField;
    
    private XCombo datePeriodField;
    private XDateCombo startDateField;
    private XDateCombo endDateField;
    
    private XCombo systemPeriodField;

    
    private Button allButton;
    private Button yearButton;
    private Button quarterButton;
    private Button monthButton;
    private Button periodButton;
    private Button systemPeriodButton;
    
    private boolean resetFilter;
    private Date startDate;
    private Date endDate;
    
    private boolean allButonMode;
    
    private boolean systemPeriodMode;
    
    private boolean resetButonMode;
    
    public ExtPeriodDialog(Shell parentShell) {
	super(parentShell);
    }

    protected void configureShell(Shell newShell) {
	super.configureShell(newShell);
	newShell.setText(Messages.getString("ExtPeriodDialog.title")); //$NON-NLS-1$
    }
    
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, Messages.getString("ExtPeriodDialog.cancel"), false); //$NON-NLS-1$
        if (isResetButonMode()) {
            createButton(parent, IDialogConstants.CLIENT_ID, Messages.getString("ExtPeriodDialog.reset"), false); //$NON-NLS-1$
        }
    }

    
    protected void createHeaderPanel(Composite parent) {
	
    }

    protected void createFooterPanel(Composite parent) {
	
    }

    protected Control createDialogArea(Composite parent) {
	
        // top level composite
        GridLayout gridLayout;
        
        Composite parentComposite = (Composite) super.createDialogArea(parent);
        parentComposite.setLayout(new FillLayout());
        
        Composite composite = new Composite(parentComposite, SWT.BORDER);
                
        gridLayout = new GridLayout();
        gridLayout.numColumns = 3;
        composite.setLayout(gridLayout);

        // HEADER PANEL
        createHeaderPanel(composite);

        if (allButonMode) {
	    allButton = new Button(composite, SWT.RADIO);
	    allButton.setText(Messages.getString("ExtPeriodDialog.allButton.text")); //$NON-NLS-1$
	    allButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    selectAllMode();
		}
	    });
	    GridData gd = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	    allButton.setLayoutData(gd);
	}

        
        yearButton = new Button(composite, SWT.RADIO);
        yearButton.setText(Messages.getString("ExtPeriodDialog.yearButton.text")); //$NON-NLS-1$
        yearButton.addSelectionListener(new SelectionAdapter(){
            public void widgetSelected(SelectionEvent e) {
        	selectYearMode();
            }
        });
 
        yearModeYearField = new Spinner(composite, SWT.BORDER);
        GridData gd = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
        gd.widthHint = 100;
	yearModeYearField.setLayoutData(gd);

        quarterButton = new Button(composite, SWT.RADIO);
        quarterButton.setText(Messages.getString("ExtPeriodDialog.quarterButton.text")); //$NON-NLS-1$
        quarterButton.addSelectionListener(new SelectionAdapter(){
            public void widgetSelected(SelectionEvent e) {
        	selectQuarterMode();
            }
        });
        

        quarterModeQuarterField = new XCombo(composite, SWT.BORDER);
        quarterModeQuarterField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        quarterModeYearField = new Spinner(composite, SWT.BORDER);
	quarterModeYearField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

        monthButton = new Button(composite, SWT.RADIO);
        monthButton.setText(Messages.getString("ExtPeriodDialog.monthButton.text")); //$NON-NLS-1$
        monthButton.addSelectionListener(new SelectionAdapter(){
            public void widgetSelected(SelectionEvent e) {
        	selectMonthMode();
            }
        });
        

        monthModeMonthField = new XCombo(composite, SWT.BORDER);
        monthModeMonthField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        monthModeYearField = new Spinner(composite, SWT.BORDER);
        monthModeYearField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

        
        Label label = new Label(composite, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

        periodButton = new Button(composite, SWT.RADIO);
        periodButton.setText(Messages.getString("ExtPeriodDialog.periodButton.text")); //$NON-NLS-1$
        periodButton.addSelectionListener(new SelectionAdapter(){
            public void widgetSelected(SelectionEvent e) {
        	selectPeriodMode();
            }
        });
        

        datePeriodField = new XCombo(composite, SWT.BORDER);
        datePeriodField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
        datePeriodField.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	selectDatePeriodField();
            }
        });

        startDateLabel = new Label(composite, SWT.NONE);
	startDateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
        startDateLabel.setText(Messages.getString("ExtPeriodDialog.startDateLabel.text")); //$NON-NLS-1$

        startDateField = new XDateCombo(composite, SWT.BORDER);
        startDateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
        startDateField.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	selectDateField();
            }
        });

        endDateLabel = new Label(composite, SWT.NONE);
        endDateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
        endDateLabel.setText(Messages.getString("ExtPeriodDialog.endDateLabel.text")); //$NON-NLS-1$

        endDateField = new XDateCombo(composite, SWT.BORDER);
        endDateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
        endDateField.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	selectDateField();
            }
        });

        
        label = new Label(composite, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        
        // FOOTER PANEL
        createFooterPanel(composite);
        

        /*
        systemPeriodButton = new Button(composite, SWT.RADIO);
        systemPeriodButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
        systemPeriodButton.setText("System period");
        systemPeriodButton.addSelectionListener(new SelectionAdapter(){
            public void widgetSelected(SelectionEvent e) {
        	selectSystemPeriodMode();
            }
        });

        systemPeriodField = new CCombo(composite, SWT.BORDER);
        systemPeriodField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
        

        setSystemPeriodModeVisible(isSystemPeriodMode());
        */

        //new Label(composite, SWT.NONE);

        
        //setDefaultMode();
        initMode();
        
        initDatePeriodControl();
        initYearSpinner(yearModeYearField);
        initYearSpinner(quarterModeYearField);
        initYearSpinner(monthModeYearField);
        
        initQuarterControl(); 
        initMonthControl(); 
        
        parent.pack();
        
        return composite;
    }
    
    protected void initData() {
	Calendar calendar = Calendar.getInstance();
	Date date = calendar.getTime();
	
	if (startDate == null) {
	    startDate = date;
	}
	if (endDate == null) {
	    endDate = date;
	}

	if (startDate != null) {
	    startDateField.setDate(startDate);
	    calendar.setTime(startDate);
	}
	if (endDate != null) {
	    endDateField.setDate(endDate);
	}
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);
	int grMonth = month + 1;
	int quarter = DateUtils.getQuarterByMonth(grMonth);
	
	yearModeYearField.setSelection(year);
	quarterModeYearField.setSelection(year);
	monthModeYearField.setSelection(year);
	
	quarterModeQuarterField.setSelection(quarter - 1); //select(quarter - 1);
	monthModeMonthField.setSelection(month); // select(month);
	
    }

    public int getMode() {
	if (mode  < YEAR_MODE || mode > PERIOD_MODE) {
	    mode = DEFAULT_MODE;
	}
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
    
    public boolean isSingleMode() {
        return singleMode;
    }

    public void setSingleMode(boolean singleMode) {
        this.singleMode = singleMode;
    }

    public void initMode() {
	if (mode == YEAR_MODE) {
	    setYearMode();
	} else if (mode == QUARTER_MODE) {
	    setQuarterMode();
	} else if (mode == MONTH_MODE) {
	    setMonthMode();
	} else if (mode == PERIOD_MODE) {
	    setPeriodMode();
	} else {
	    setDefaultMode();
	}
    }

    public void setDefaultMode() {
	setPeriodMode();
    }

    public void setYearMode() {
	yearButton.setSelection(true);
	if (isSingleMode()) {
	    quarterButton.setEnabled(false);
	    monthButton.setEnabled(false);
	    periodButton.setEnabled(false);
	}
	selectYearMode();
    }

    public void setQuarterMode() {
	quarterButton.setSelection(true);
	if (isSingleMode()) {
	    yearButton.setEnabled(false);
	    monthButton.setEnabled(false);
	    periodButton.setEnabled(false);
	}
	
	selectQuarterMode();
    }

    public void setMonthMode() {
	monthButton.setSelection(true);
	if (isSingleMode()) {
	    yearButton.setEnabled(false);
	    quarterButton.setEnabled(false);
	    periodButton.setEnabled(false);
	}
	selectMonthMode();
    }

    
    public void setPeriodMode() {
	periodButton.setSelection(true);
	if (isSingleMode()) {
	    yearButton.setEnabled(false);
	    quarterButton.setEnabled(false);
	    monthButton.setEnabled(false);
	}
	selectPeriodMode();
    }
    
    
    
    public void create() {
	super.create();
	initData();
    }

    
    protected void setYearModeEnabled(boolean enabled) {
	yearModeYearField.setEnabled(enabled);
    }
    
    protected void setQuarterModeEnabled(boolean enabled) {
	quarterModeQuarterField.setEnabled(enabled);
	quarterModeYearField.setEnabled(enabled);
    }

    protected void setMonthModeEnabled(boolean enabled) {
	monthModeMonthField.setEnabled(enabled);
	monthModeYearField.setEnabled(enabled);
    }

    protected void setPeriodModeEnabled(boolean enabled) {
	datePeriodField.setEnabled(enabled);
	startDateField.setEnabled(enabled);
	endDateField.setEnabled(enabled);
    }
    
    protected void setSystemPeriodModeEnabled(boolean enabled) {
	if (systemPeriodField != null) systemPeriodField.setEnabled(enabled);
    }


    //
    protected void setSystemPeriodModeVisible(boolean visible) {
	if (systemPeriodButton != null) systemPeriodButton.setVisible(visible);
	if (systemPeriodField != null) systemPeriodField.setVisible(visible);
    }

    //
    protected void disableAll() {
	setYearModeEnabled(false);
	setQuarterModeEnabled(false);
	setMonthModeEnabled(false);
	setPeriodModeEnabled(false);
	setSystemPeriodModeEnabled(false);
    }

    protected void selectAllMode() {
	disableAll();
	resetFilter = true;
    }

    protected void selectYearMode() {
	disableAll();
	setYearModeEnabled(true);
    }
    
    protected void selectQuarterMode() {
	disableAll();
	setQuarterModeEnabled(true);
    }

    
    protected void selectMonthMode() {
	disableAll();
	setMonthModeEnabled(true);
    }

    protected void selectPeriodMode() {
	disableAll();
	setPeriodModeEnabled(true);
    }

    protected void selectSystemPeriodMode() {
	disableAll();
	setSystemPeriodModeEnabled(true);
    }

    
    
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isSystemPeriodMode() {
        return systemPeriodMode;
    }

    public void setSystemPeriodMode(boolean systemPeriodMode) {
        this.systemPeriodMode = systemPeriodMode;
    }

    protected void okPressed() {
	populateData();
	super.okPressed();
    }
    
    protected void resetPressed() {
	selectPeriodMode();
	startDateField.setDate(null);
	endDateField.setDate(null);
    }
    
    protected void buttonPressed(int buttonId) {
	if (IDialogConstants.CLIENT_ID == buttonId) {
	    resetPressed();
	} else {
	    super.buttonPressed(buttonId);
	}
    }
    
    protected void populateData() {
	
	setResetFilter(false);
	
	if (yearButton.getSelection()) {
	    int year = yearModeYearField.getSelection();
	    Calendar calendar = Calendar.getInstance();
	    Calendar calendar1 = (Calendar) calendar.clone();
	    Calendar calendar2 = (Calendar) calendar.clone();
	    
	    calendar1.set(Calendar.DAY_OF_MONTH, 1);
	    calendar1.set(Calendar.MONTH, Calendar.JANUARY);
	    calendar1.set(Calendar.YEAR, year);
	    
	    calendar2.set(Calendar.DAY_OF_MONTH, 31);
	    calendar2.set(Calendar.MONTH, Calendar.DECEMBER);
	    calendar2.set(Calendar.YEAR, year);

	    setStartDate(calendar1.getTime());
	    setEndDate(calendar2.getTime());
	    return;

	} if (quarterButton.getSelection()) {
	    int year = quarterModeYearField.getSelection();
	    int quarter = quarterModeQuarterField.getSelectionIndex() + 1;
	    int grMonth = 1; // Gregorian month
	    if (quarter >= 1 && quarter <= 4) {
		grMonth = (quarter - 1) * 3 + 1; 
	    }
	    
	    int month1 = grMonth - 1; // Java month begin
	    int month2 = month1 + 2; // Java month end
	    
	    Calendar calendar = Calendar.getInstance();
	    Calendar calendar1 = (Calendar) calendar.clone();
	    Calendar calendar2 = (Calendar) calendar.clone();
	    
	    calendar1.set(Calendar.DAY_OF_MONTH, 1);
	    calendar1.set(Calendar.MONTH, month1);
	    calendar1.set(Calendar.YEAR, year);
	    
	    //
	    if (month2 == Calendar.DECEMBER) { // Last month of year
		month2 = Calendar.JANUARY; // Set first month of next year
		year = year + 1; // Set next year
	    } else {
		month2 = month2 + 1; // Set next month
	    }
	    
	    // Set first day of next month
	    calendar2.set(Calendar.DAY_OF_MONTH, 1);
	    calendar2.set(Calendar.MONTH, month2);
	    calendar2.set(Calendar.YEAR, year);
	    
	    // Decrement one day
	    calendar2.add(Calendar.DAY_OF_MONTH, -1);

	    setStartDate(calendar1.getTime());
	    setEndDate(calendar2.getTime());
	    return;

	} if (monthButton.getSelection()) {
	    int year = yearModeYearField.getSelection();
	    int month = monthModeMonthField.getSelectionIndex();
	    
	    Calendar calendar = Calendar.getInstance();
	    Calendar calendar1 = (Calendar) calendar.clone();
	    Calendar calendar2 = (Calendar) calendar.clone();
	    
	    calendar1.set(Calendar.DAY_OF_MONTH, 1);
	    calendar1.set(Calendar.MONTH, month);
	    calendar1.set(Calendar.YEAR, year);
	    
	    if (month == Calendar.DECEMBER) { // Last month of year
		month = Calendar.JANUARY; // Set first month of next year
		year = year + 1; // Set next year
	    } else {
		month = month + 1; // Set next month
	    }
	    
	    // Set first day of next month
	    calendar2.set(Calendar.DAY_OF_MONTH, 1);
	    calendar2.set(Calendar.MONTH, month);
	    calendar2.set(Calendar.YEAR, year);
	    
	    // Decrement one day
	    calendar2.add(Calendar.DAY_OF_MONTH, -1);

	    setStartDate(calendar1.getTime());
	    setEndDate(calendar2.getTime());
	    return;
	    
	} else if (allButton!= null && allButton.getSelection()) {
	    setResetFilter(true);
	    setStartDate(null);
	    setEndDate(null);
	    return;
	}
	
	setStartDate(startDateField.getDate());
	setEndDate(endDateField.getDate());
    }
    
    protected void initYearSpinner(Spinner spinner) {
	spinner.setMinimum(1900);
	spinner.setMaximum(3000);
    }
    
    protected void initQuarterControl() {
	String quarter = Messages.getString("ExtPeriodDialog.quarter"); //$NON-NLS-1$
	quarterModeQuarterField.add("1 " + quarter);
	quarterModeQuarterField.add("2 " + quarter);
	quarterModeQuarterField.add("3 " + quarter);
	quarterModeQuarterField.add("4 " + quarter);
    }
    
    protected void initMonthControl() {
	SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
	String[] months = sdf.getDateFormatSymbols().getMonths();
	for (String month : months) {
	    monthModeMonthField.add(month);
	}
    }

    
    protected void initDatePeriodControl() {
	List<DatePeriod> periods = createDefaultDatePeriodList();
	datePeriodField.setData(periods);
	for (DatePeriod period :  periods) {
	    datePeriodField.add(period.getName());
	}
	isDateSelecting = true;
	datePeriodField.setSelection(0); //select(0);
	isDateSelecting = false;
    }
    
    protected DatePeriod getSelectionDatePeriod() {
	int index = datePeriodField.getSelectionIndex();
	if (index < 0) {
	    return null;
	}
	List<DatePeriod> periods = (List<DatePeriod>) datePeriodField.getData();
	if (periods == null) {
	    return null;
	}
	return periods.get(index);
    }
    
    protected List<DatePeriod> createDefaultDatePeriodList() {
	List<DatePeriod> periods = new ArrayList<DatePeriod>();
	
	periods.add(new DatePeriod(null, Messages.getString("ExtPeriodDialog.none"))); //$NON-NLS-1$
	
	periods.add(new DatePeriod(DatePeriod.TODAY, Messages.getString("ExtPeriodDialog.today"))); //$NON-NLS-1$
	periods.add(new DatePeriod(DatePeriod.YESTERDAY, Messages.getString("ExtPeriodDialog.yesterday"))); //$NON-NLS-1$
	periods.add(new DatePeriod(DatePeriod.TOMORROW, Messages.getString("ExtPeriodDialog.tomorrow"))); //$NON-NLS-1$
	
	periods.add(new DatePeriod(DatePeriod.CURRENT_WEEK, Messages.getString("ExtPeriodDialog.current.week"))); //$NON-NLS-1$
	periods.add(new DatePeriod(DatePeriod.LAST_WEEK, Messages.getString("ExtPeriodDialog.last.week"))); //$NON-NLS-1$
	periods.add(new DatePeriod(DatePeriod.NEXT_WEEK, Messages.getString("ExtPeriodDialog.next.week"))); //$NON-NLS-1$
	
	periods.add(new DatePeriod(DatePeriod.CURRENT_MONTH, Messages.getString("ExtPeriodDialog.current.month"))); //$NON-NLS-1$
	periods.add(new DatePeriod(DatePeriod.LAST_MONTH, Messages.getString("ExtPeriodDialog.last.month"))); //$NON-NLS-1$
	periods.add(new DatePeriod(DatePeriod.NEXT_MONTH, Messages.getString("ExtPeriodDialog.next.month"))); //$NON-NLS-1$

	periods.add(new DatePeriod(DatePeriod.CURRENT_YEAR, Messages.getString("ExtPeriodDialog.current.year"))); //$NON-NLS-1$
	periods.add(new DatePeriod(DatePeriod.LAST_YEAR, Messages.getString("ExtPeriodDialog.last.year"))); //$NON-NLS-1$
	periods.add(new DatePeriod(DatePeriod.NEXT_YEAR, Messages.getString("ExtPeriodDialog.next.year"))); //$NON-NLS-1$
	
	return periods;
    }
    
    private boolean isDateSelecting;
    
    protected void selectDateField() {
	isDateSelecting = true;
	datePeriodField.setSelection(0); //.select(0);
	isDateSelecting = false;
    }
    
    protected void selectDatePeriodField() {
      	if (isDateSelecting) {
	    return;
	}
	DatePeriod datePeriod = getSelectionDatePeriod();
	if (datePeriod == null) {
	    return;
	}
	PeriodUtils.initDatePeriod(datePeriod);
	startDateField.setDate(datePeriod.getStartDate());
	endDateField.setDate(datePeriod.getEndDate());
    }

    public boolean isResetButonMode() {
        return resetButonMode;
    }

    public void setResetButonMode(boolean resetButonMode) {
        this.resetButonMode = resetButonMode;
    }

    public boolean isAllButonMode() {
        return allButonMode;
    }

    public void setAllButonMode(boolean allButonMode) {
        this.allButonMode = allButonMode;
    }

    public boolean isResetFilter() {
        return resetFilter;
    }

    public void setResetFilter(boolean resetPeriod) {
        this.resetFilter = resetPeriod;
    }
    

    
    
}
