package org.plazmaforge.framework.client.swt.controls;

/**
 * Classes which implement this interface provide methods that deal with the
 * events that are generated in a <code>CCalendar</code> control.<p>
 * 
 * After creating an instance of a class that implements this interface it can
 * be added to a calendar using the <code>addCalendarListener</code> method and
 * removed using the <code>removeSelectionListener</code> method. When events
 * occurs in a calendar the appropriate method will be invoked.
 */
//[WD]
public interface CalendarListener {
	/**
	 * Sent when a double click on a date occurs in the calendar.<p>
	 * 
	 * The <code>widget</code> field of the event contains the CCalendar control
	 * at the origine of the event. The <code>selection</code> field contains the
	 * new selected date in the calendar. 
	 * 
	 * @param e an event containing information about the selection
	 */
	public void calendarDoubleClick(CalendarEvent e);

	/**
	 * Sent when selection occurs in the calendar.<p>
	 * 
	 * The <code>widget</code> field of the event contains the CCalendar control
	 * at the origine of the event. The <code>selection</code> field contains the
	 * new selected date in the calendar. 
	 * 
	 * @param e an event containing information about the selection
	 */
	public void calendarSelectionChanged(CalendarEvent e);
}
