package org.plazmaforge.framework.client.swt.controls;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.forms.AbstractFormDecorator;


public class OzCalendar  extends Composite {

    
    private static SimpleDateFormat sdf = new SimpleDateFormat("d MMM");
    private static SimpleDateFormat dfCaption = new SimpleDateFormat("d MMMM yyyy");
    private static SimpleDateFormat dfCaptionMonth = new SimpleDateFormat("MMMM yyyy");
    private static SimpleDateFormat timeDataFormat = new SimpleDateFormat("HH:mm");
    

    private IOzCalendarMenuBuilder menuBuilder;
    private List<IOzCalendarListener> listeners = new ArrayList<IOzCalendarListener>(); 
    
    IOzCalendarSource sources[];
    private Date startDate;
    private Date endDate;
    
    List<OzTaskDay> arrDays;
    private int countWeek;
    private Calendar tmpcal;
    OzTaskDay focusDay;
    private Font fontCaption;
    ToolBar navigateBar;
    private Label labelDayCaption;
    private Label labelWeekCaption;
    private boolean isMonth;

    

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public OzCalendar(Composite parent, int style) {
	super(parent, style);
	sources = null;
	startDate = null;
	endDate = null;
	arrDays = new ArrayList<OzTaskDay>();
	countWeek = 6;
	focusDay = null;
	navigateBar = null;
	isMonth = false;
	setBackground(Display.getDefault().getSystemColor(1));
	
	GridLayout mainLayout = new GridLayout(7, true);
	mainLayout.horizontalSpacing = mainLayout.verticalSpacing = mainLayout.marginHeight = mainLayout.marginWidth = 0;
	
	setLayout(mainLayout);
	
	createControlPanel();
	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf.applyPattern("EEEE");
	tmpcal = Calendar.getInstance();
	tmpcal.set(7, tmpcal.getFirstDayOfWeek());
	fontCaption = null;
	for (int i = 0; i < 7; i++) {
	    String text = sdf.format(tmpcal.getTime());
	    text = (new StringBuilder(String.valueOf(text.substring(0, 1).toUpperCase()))).append(text.substring(1)).toString();
	    
	    Composite headerComp = new Composite(this, 2048);
	    
	    GridLayout gl = new GridLayout(1, true);
	    gl.horizontalSpacing = gl.verticalSpacing = gl.marginHeight = gl.marginWidth = 0;
	    headerComp.setLayout(gl);
	    CLabel lblCaption = new CLabel(headerComp, 0x1000000);
	    if (fontCaption == null) {
		fontCaption = lblCaption.getFont();
		FontData fds[] = fontCaption.getFontData();
		for (int j = 0; j < fds.length; j++)
		    fds[j].setStyle(1);

		fontCaption = new Font(null, fds);
	    }
	    if (fontCaption != null)
		lblCaption.setFont(fontCaption);
	    lblCaption.setText(text);
	    GridData gd = new GridData();
	    gd.grabExcessHorizontalSpace = true;
	    gd.horizontalAlignment = 4;
	    lblCaption.setLayoutData(gd);
	    headerComp.setLayoutData(gd);
	    tmpcal.add(7, 1);
	}

	addDisposeListener(new DisposeListener() {

	    public void widgetDisposed(DisposeEvent e) {
		if (fontCaption != null)
		    fontCaption.dispose();
	    }

	});
	
	// Initialize view
	doWeekView();
    }

    private void createControlPanel() {
	
	Composite navigatePanel = new Composite(this, 2048);
	
	GridData gd = new GridData();
	gd.grabExcessHorizontalSpace = true;
	gd.horizontalAlignment = 4;
	gd.horizontalSpan = 7;
	navigatePanel.setLayoutData(gd);
	navigatePanel.setBackground(Display.getDefault().getSystemColor(1));
	navigatePanel.setLayout(new GridLayout(4, false));
	ToolBar tb = new ToolBar(navigatePanel, 0);
	tb.setBackground(Display.getDefault().getSystemColor(1));
	ToolItem buttonPrev = new ToolItem(tb, 8);
	//setImage(buttonPrev, "icons/prev.gif");
	setImage(buttonPrev, "/org/plazmaforge/framework/client/images/eclipse/page/previous.gif");
	buttonPrev.addSelectionListener(new SelectionAdapter() {

	    public void widgetSelected(SelectionEvent e) {
		goPrev();
	    }

	});
	ToolItem buttonToday = new ToolItem(tb, 8);
	//setImage(buttonToday, "icons/today.gif");
	setImage(buttonToday, "/org/plazmaforge/framework/client/images/fw/date.png");
	buttonToday.addSelectionListener(new SelectionAdapter() {

	    public void widgetSelected(SelectionEvent e) {
		goToday();
	    }

	});
	ToolItem buttonNext = new ToolItem(tb, 8);
	//setImage(buttonNext, "icons/next.gif");
	setImage(buttonNext, "/org/plazmaforge/framework/client/images/eclipse/page/next.gif");
	buttonNext.addSelectionListener(new SelectionAdapter() {

	    public void widgetSelected(SelectionEvent e) {
		goNext();
	    }

	});

	Color color = new Color(null, 25, 76, 127);
	labelDayCaption = new Label(navigatePanel, 0);
	labelDayCaption.setBackground(Display.getDefault().getSystemColor(1));
	labelDayCaption.setForeground(color);
	labelDayCaption.setFont(JFaceResources.getHeaderFont());
	tb = new ToolBar(navigatePanel, 0);
	tb.setBackground(Display.getDefault().getSystemColor(1));
	ToolItem weekView = new ToolItem(tb, 8);
	weekView.setText(Messages.getString("Week")); // WEEK_VIEW
	weekView.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		doWeekView();
	    }
	});

	ToolItem monthView = new ToolItem(tb, 8);
	monthView.setText(Messages.getString("Month")); // MONTH_VIEW
	monthView.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		doMonthView();
	    }
	});

	labelWeekCaption = new Label(navigatePanel, 0x20000);
	labelWeekCaption.setBackground(Display.getDefault().getSystemColor(1));
	labelWeekCaption.setForeground(color);
	gd = new GridData();
	gd.grabExcessHorizontalSpace = true;
	gd.horizontalAlignment = 0x1000008;
	labelWeekCaption.setLayoutData(gd);
	labelWeekCaption.setFont(JFaceResources.getHeaderFont());
    }

    
    public int getCountWeek() {
	return countWeek;
    }

    public void setCountWeek(int countWeek) {
	this.countWeek = countWeek;
    }

  
    /**
     * Switch to Week view  
     */
    protected void doWeekView() {
	Date today = null;
	if (focusDay != null)
	    today = focusDay.getDate();
	if (today == null)
	    today = startDate;
	if (today == null)
	    today = new Date();
	tmpcal.setTime(today);
	if (focusDay == null)
	    tmpcal.add(6, 6);
	setWeek(tmpcal.get(1), tmpcal.get(3), 1);
	setActive(today);
    }
  
    /**
     * Switch to Month view
     */
    protected void doMonthView() {
	Date today = null;
	if (focusDay != null)
	    today = focusDay.getDate();
	if (today == null)
	    today = startDate;
	if (today == null)
	    today = new Date();
	tmpcal.setTime(today);
	if (focusDay == null)
	    tmpcal.add(6, 6);
	setMonth(tmpcal.get(1), tmpcal.get(2));
	setActive(today);
    }
    
    public void goPrev() {
	tmpcal.setTime(startDate);
	if (isMonth) {
	    tmpcal.add(5, 6);
	    tmpcal.set(5, 1);
	}
	tmpcal.add(isMonth ? 2 : 5, isMonth ? -1 : -7);
	if (isMonth)
	    setMonth(tmpcal.get(1), tmpcal.get(2));
	else
	    setStartDate(tmpcal.getTime());
    }

    public void goNext() {
	tmpcal.setTime(startDate);
	if (isMonth) {
	    tmpcal.add(5, 6);
	    tmpcal.set(5, 1);
	}
	tmpcal.add(isMonth ? 2 : 3, 1);
	if (isMonth)
	    setMonth(tmpcal.get(1), tmpcal.get(2));
	else
	    setStartDate(tmpcal.getTime());
    }

    public void goToday() {
	setDate(new Date());
    }

    public void setDate(Date date) {
	tmpcal.setTime(date);
	tmpcal.set(11, 0);
	tmpcal.set(10, 0);
	tmpcal.set(12, 0);
	tmpcal.set(13, 0);
	tmpcal.set(14, 0);
	date = tmpcal.getTime();
	if (date.compareTo(startDate) < 0 || date.compareTo(endDate) > 0)
	    if (isMonth)
		setMonth(tmpcal.get(1), tmpcal.get(2));
	    else
		setWeek(tmpcal.get(1), tmpcal.get(3), countWeek);
	setActive(date);
    }

    protected void updateCaption() {
	String text = "";
	tmpcal.setTime(startDate);
	if (isMonth) {
	    tmpcal.add(5, 6);
	    tmpcal.set(5, 1);
	    text = dfCaptionMonth.format(tmpcal.getTime());
	} else {
	    text = (new StringBuilder(String.valueOf(dfCaption.format(startDate))))
		    .append(" - ").append(dfCaption.format(endDate)).toString();
	}
	labelDayCaption.setText(text);
	text = Messages.getString("Week")+ " "; // "WEEK";
	text = (new StringBuilder(String.valueOf(text))).append(tmpcal.get(3))
		.toString();
	if (countWeek > 1)
	    text = (new StringBuilder(String.valueOf(text))).append(" - ")
		    .append((tmpcal.get(3) + countWeek) - 1).toString();
	labelWeekCaption.setText(text);
    }
    
   

    public void setMonth(int year, int month) {
	isMonth = true;
	countWeek = 6;
	tmpcal.set(year, month, 1, 0, 0, 0);
	tmpcal.set(14, 0);
	tmpcal.set(5, 1);
	int firstDay = tmpcal.get(7) - tmpcal.getFirstDayOfWeek();
	if (firstDay < 0)
	    firstDay += 7;
	tmpcal.add(5, -firstDay);
	setStartDate(tmpcal.getTime());
    }

    public void setWeek(int year, int week, int weekCount) {
	isMonth = false;
	countWeek = weekCount;
	tmpcal.set(year, 0, 1, 0, 0, 0);
	tmpcal.set(3, week);
	tmpcal.set(14, 0);
	int firstDay = tmpcal.get(7) - tmpcal.getFirstDayOfWeek();
	if (firstDay < 0)
	    firstDay += 7;
	tmpcal.add(5, -firstDay);
	setStartDate(tmpcal.getTime());
    }

    public void setStartDate(Date date) {
	startDate = tmpcal.getTime();
	tmpcal.add(5, 7 * countWeek - 1);
	endDate = tmpcal.getTime();
	buildDays();
    }

    public void setWeek(int year, int week) {
	setWeek(year, week, 1);
    }

    protected void setActive(OzTaskDay activeDay) {
	focusDay = activeDay;
	for (OzTaskDay taskDay: arrDays) {
	    taskDay.setActive(taskDay == focusDay);
	}
    }

    public OzTaskDay getActiveTaskDay() {
	return focusDay;
    }

    public Date getActiveDate() {
	Date date = focusDay == null ? null : focusDay.getDate() ;
	return date == null ? new Date() : date;
    }
    
    public void setActive(Date date) {
	boolean isActive = false;
	for (OzTaskDay taskDay: arrDays) {
	    Date taskDate = taskDay.getDate();
	    isActive = taskDate.getYear() == date.getYear()
		    && taskDate.getMonth() == date.getMonth()
		    && taskDate.getDate() == date.getDate();
	    taskDay.setActive(isActive);
	}
    }

    public IOzCalendarSource[] getSources() {
	return sources;
    }

    public void setSource(IOzCalendarSource source) {
	setSources(new IOzCalendarSource[] { source });
    }

    public void setSources(IOzCalendarSource sources[]) {
	this.sources = sources;
	update();
    }


    public void update() {
	buildDays();
    }

    private void buildDays() {
	
	// Dispose old days
	for (OzTaskDay taskDay: arrDays) {
	    taskDay.dispose();
	}
	arrDays.clear();
	
	if (startDate == null || endDate == null) {
	    return;
	}
	    
	OzCalendarEvent events[] = new OzCalendarEvent[0];
	List<OzCalendarEvent> listEvents = new ArrayList<OzCalendarEvent>();
	if (sources != null && sources.length > 0) {
	    tmpcal.setTime(endDate);
	    tmpcal.add(5, 1);
	    for (int i = 0; i < sources.length; i++) {
		OzCalendarEvent event[] = sources[i].getEventsForPeriod(startDate, tmpcal.getTime());
		listEvents.addAll(Arrays.asList(event));
	    }

	    events = (OzCalendarEvent[]) listEvents.toArray(new OzCalendarEvent[listEvents.size()]);
	    Arrays.sort(events, new Comparator<OzCalendarEvent>() {

		public int compare(OzCalendarEvent ev1, OzCalendarEvent ev2) {
		    return ev1.getStart().compareTo(ev2.getStart());
		}

	    });
	}

	OzTaskDay taskDate;
	for (Date currDate = (Date) startDate.clone(); currDate.compareTo(endDate) <= 0; arrDays.add(taskDate)) {
	    taskDate = new OzTaskDay(this, (Date) currDate.clone());
	    currDate.setDate(currDate.getDate() + 1);
	    taskDate.setLayoutData(new GridData(4, 4, true, true));
	    addEventsForDate(taskDate, events);
	}

	updateCaption();
	layout(true, true);
    }

    private void addEventsForDate(OzTaskDay taskDate, OzCalendarEvent events[]) {
	Date start = taskDate.getDate();
	tmpcal.setTime(start);
	tmpcal.add(5, 1);
	Date end = tmpcal.getTime();
	OzCalendarEvent adpcalendarevent[];
	int j = (adpcalendarevent = events).length;
	for (int i = 0; i < j; i++) {
	    OzCalendarEvent event = adpcalendarevent[i];
	    List<OzPeriod> list = event.getDatesForPeriod(start, end);
	    if (list.size() > 0)
		taskDate.addEvent(event, ((OzPeriod) list.get(0)).start, ((OzPeriod) list.get(0)).end);
	}

	taskDate.update();
    }

  
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    private void setImage(ToolItem item, String fileName) {
	if (item == null || fileName == null) {
	    return;
	}
	Image image = getImage(fileName);
	if (image == null) {
	    return;
	}
	item.setImage(image);
    }

    protected Image getImage(String path) {
	return SWTResourceManager.getImage(getClass(), path);
    }

    public static Image getImage(Class klass, String path) {
	return SWTResourceManager.getImage(klass, path);
    }

    public static Image getResourceImage(String path) {
	return getImage(AbstractFormDecorator.class, path);
    }

    private Color getColor(int red, int green, int blue) {
	return new Color(Display.getCurrent(), red, green, blue);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public class OzTaskDay {

	Color activeColor;
	Color inActiveColor;
	Color captionActiveColor;
	Color eventColor;
	Color activeEventColor;
	Color captionInActiveColor;
	Canvas dayComp;
	Composite eventsComp;
	Date date;
	CLabel lblCaption;
	CLabel activeEventLabel;
	private ScrolledComposite scrCompos;
	private MouseAdapter mouseListener;
	Menu menu;

	public OzTaskDay(final OzCalendar cal, Date date) {
	    activeColor = getColor(255, 249, 189);
	    inActiveColor = Display.getDefault().getSystemColor(1);
	    captionActiveColor = getColor(245, 228, 156);
	    eventColor = getColor(179, 188, 240);
	    activeEventColor = getColor(255, 242, 0);
	    captionInActiveColor = Display.getDefault().getSystemColor(22);
	    dayComp = null;
	    eventsComp = null;
	    this.date = null;
	    lblCaption = null;
	    activeEventLabel = null;
	    menu = null;
	    mouseListener = new MouseAdapter() {

		public void mouseDown(MouseEvent e) {
		    if (e.widget != null && (e.widget instanceof CLabel) && (e.widget.getData() instanceof OzCalendarEvent))
			activeEventLabel = (CLabel) e.widget;
		    cal.setActive(OzTaskDay.this);
		}

		public void mouseUp(MouseEvent e) {
		    OzCalendarEvent calendarEvent = getCalendarEvent(e);
		    cal.setSelectedEvent(calendarEvent);
		    
		    if (e.button == 3) {
			showMenu(calendarEvent);
			return;
		    }
		    fireEventSelected(calendarEvent);
		}

		public void mouseDoubleClick(MouseEvent e) {
		    if (e.widget == activeEventLabel) {
			OzCalendarEvent calendarEvent = getCalendarEvent(e);
			fireEventDoubleClicked(calendarEvent);
		    }
		}

	    };

	    this.date = date;
	    dayComp = new Canvas(cal, 2048);
	    
	    GridLayout gl = new GridLayout(1, false);
	    gl.horizontalSpacing = gl.verticalSpacing = gl.marginHeight = gl.marginWidth = 0;
	    dayComp.setLayout(gl);
	    lblCaption = new CLabel(dayComp, 0x20000);
	    lblCaption.addMouseListener(mouseListener);
	    lblCaption.setText(OzCalendar.sdf.format(date));
	    GridData gd = new GridData();
	    gd.grabExcessHorizontalSpace = true;
	    gd.horizontalAlignment = 4;
	    lblCaption.setLayoutData(gd);
	    scrCompos = new ScrolledComposite(dayComp, 512);
	    gd = new GridData();
	    gd.grabExcessHorizontalSpace = true;
	    gd.horizontalAlignment = 4;
	    gd.grabExcessVerticalSpace = true;
	    gd.verticalAlignment = 4;
	    eventsComp = new Composite(scrCompos, 0);
	    scrCompos.setContent(eventsComp);
	    scrCompos.setLayout(new FillLayout());
	    scrCompos.setExpandHorizontal(true);
	    scrCompos.setExpandVertical(true);
	    scrCompos.setLayoutData(gd);
	    gl = new GridLayout(1, false);
	    gl.marginWidth = 2;
	    gl.verticalSpacing = 2;
	    gl.marginHeight = 2;
	    eventsComp.setLayout(gl);
	    eventsComp.setBackground(Display.getDefault().getSystemColor(1));
	    eventsComp.addMouseListener(mouseListener);
	    scrCompos.setBackground(Display.getDefault().getSystemColor(1));
	    update();
	}

	private OzCalendarEvent getCalendarEvent(MouseEvent e) {
	    if (e == null) {
		return null;
	    }
	    OzCalendarEvent calendarEvent = null;
	    if (e.widget != null && (e.widget instanceof CLabel) && (e.widget.getData() instanceof OzCalendarEvent)) {
		calendarEvent = (OzCalendarEvent) e.widget.getData();
	    }
	    return calendarEvent;
	}
	
	public Date getDate() {
	    return date;
	}

	public void addEvent(OzCalendarEvent event, Date start, Date end) {
	    CLabel label = new CLabel(eventsComp, 16392);
	    GridData gd = new GridData();
	    gd.grabExcessHorizontalSpace = true;
	    gd.horizontalAlignment = 4;
	    label.setLayoutData(gd);
	    label.setBackground(eventColor);

	    String text = event.getSummury();
	    if (!event.isAllDayEvent()) {
		text = (new StringBuilder(String.valueOf(getPrefix(event,
			start, end)))).append(text).toString();
	    }

	    label.setText(text);
	    label.setToolTipText(event.getSummury());
	    label.setData(event);
	    label.addMouseListener(mouseListener);
	}

	public OzCalendarEvent getActiveEvent() {
	    if (activeEventLabel != null)
		return (OzCalendarEvent) activeEventLabel.getData();
	    else
		return null;
	}

	private String getPrefix(OzCalendarEvent event, Date evStart, Date evEnd) {
	    String pref = "";
	    Date start = getDate();
	    tmpcal.setTime(start);
	    tmpcal.add(5, 1);
	    Date end = tmpcal.getTime();
	    if (start.compareTo(evStart) <= 0 && end.compareTo(evEnd) >= 0)
		pref = (new StringBuilder(String
			.valueOf(OzCalendar.timeDataFormat.format(event
				.getStart())))).append(" ").toString();
	    else if (start.compareTo(evStart) > 0 && end.compareTo(evEnd) < 0)
		pref = "\u2194 ";
	    else if (start.compareTo(evStart) <= 0 && end.compareTo(evEnd) < 0)
		pref = (new StringBuilder("\u2190 ")).append(
			OzCalendar.timeDataFormat.format(event.getStart()))
			.toString();
	    else if (start.compareTo(evStart) > 0 && end.compareTo(evEnd) >= 0)
		pref = (new StringBuilder("\u2192 ")).append(
			OzCalendar.timeDataFormat.format(evEnd)).toString();
	    return pref;
	}

	public void update() {
	    Point p = eventsComp.computeSize(-1, -1);
	    scrCompos.setMinSize(p.x, p.y);
	}

	public void setLayoutData(Object obj) {
	    dayComp.setLayoutData(obj);
	}

	public void setActive(boolean isActive) {
	    Color color = isActive ? activeColor : inActiveColor;
	    dayComp.setBackground(color);
	    eventsComp.setBackground(color);
	    lblCaption.setBackground(isActive ? captionActiveColor
		    : captionInActiveColor);
	    Control acontrol[];
	    int j = (acontrol = eventsComp.getChildren()).length;
	    for (int i = 0; i < j; i++) {
		Control ctrl = acontrol[i];
		if (ctrl instanceof CLabel)
		    ctrl.setBackground(!isActive || ctrl != activeEventLabel ? eventColor : activeEventColor);
	    }

	}

	public void showMenu(OzCalendarEvent calendarEvent) {
	    if (menu != null && !menu.isDisposed()) {
		menu.dispose();
	    }

	    menu = new Menu(eventsComp.getShell(), 8);
	    if (menuBuilder != null) {
		menuBuilder.buildMenu(calendarEvent, menu);
	    }
	    menu.setVisible(true);
	}

	public void addMenuItem(final String ID, String txt) {
	    MenuItem item = new MenuItem(menu, 64);
	    item.setText(txt);
	    item.addSelectionListener(new SelectionAdapter() {

		public void widgetSelected(SelectionEvent e) {
		    // TODO
		}

	    });
	}

	

	public void dispose() {
	    dayComp.dispose();
	}

    }

    ///////////////////////////////////////////////////////////

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }


    public IOzCalendarMenuBuilder getMenuBuilder() {
        return menuBuilder;
    }

    public void setMenuBuilder(IOzCalendarMenuBuilder menuBuilder) {
        this.menuBuilder = menuBuilder;
    }

    public void addCalendarListener(IOzCalendarListener listener) {
	listeners.add(listener);
    }
    
    protected void fireEventSelected(OzCalendarEvent event) {
	for (IOzCalendarListener l : listeners) {
	    l.eventSelected(event);
	}
    }
    
    protected void fireEventDoubleClicked(OzCalendarEvent event) {
	for (IOzCalendarListener l : listeners) {
	    l.eventDoubleClicked(event);
	}
    }

    
    ///////////////////////////////////////////////////////////
    
    private OzCalendarEvent selectedEvent;
    
    
    public OzCalendarEvent getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(OzCalendarEvent selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    ///////////////////////////////////////////////////////////
    
    public static interface IOzCalendarMenuBuilder {
	
	void buildMenu(OzCalendarEvent event, Menu menu);
	
    }
 
    public static interface IOzCalendarListener {
	
	void eventSelected(OzCalendarEvent event);
	
	void eventDoubleClicked(OzCalendarEvent event);
    }
    
    public static class OzCalendarAdapter implements IOzCalendarListener {
	
	public void eventSelected(OzCalendarEvent event) {
	    
	}
	
	public void eventDoubleClicked(OzCalendarEvent event) {
	    
	}
    }

}
