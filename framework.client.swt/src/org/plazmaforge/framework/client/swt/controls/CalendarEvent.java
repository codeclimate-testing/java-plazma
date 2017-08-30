package org.plazmaforge.framework.client.swt.controls;

import java.util.Date;

import org.eclipse.swt.widgets.Event;

/**
 * Instances of this class are sent as a result of an event in a <code>CCalendar</code>. 
 */
//[WD]
public class CalendarEvent extends Event {
	/** Selected date in the calendar */
	public Date selection;
}
