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

import java.io.Serializable;
import java.util.Date;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IFormConstants;
import org.plazmaforge.framework.client.forms.IFormDecorator;
import org.plazmaforge.framework.client.swt.controls.OzCalendar;
import org.plazmaforge.framework.client.swt.controls.OzCalendarEvent;
import org.plazmaforge.framework.client.swt.forms.AbstractFormDecorator;
import org.plazmaforge.framework.client.swt.forms.IEntitySelector;

public class CalendarHelper implements IFormConstants {

    public static void initCalendarMenu(Menu menu) {
	if (menu == null) {
	    return;
	}
	menu.setData("calendar", "true");
    }
    
    public static void initCalendarEditForm(OzCalendar ozCalendar, IEditForm form, IFormDecorator parentFormDecorator) {
	if (form == null) {
	    return;
	}
	if (form.getMode() != PWT.ADD_MODE) {
	    return;
	}
	AbstractFormDecorator decorator = (AbstractFormDecorator) parentFormDecorator;
	if (decorator == null) {
	    return;
	}
	Object actionOwner = decorator.getActionOwner();
	if (actionOwner == null || !(actionOwner instanceof MenuItem)) {
	    return;
	}
	MenuItem menuItem = (MenuItem) actionOwner;
	Menu menu = (Menu) menuItem.getParent();
	Object marker = menu.getData("calendar");
	if (marker == null) {
	    return;
	}
	Date activeDate = null;
	if ("true".equals(marker)) {
	    activeDate = ozCalendar.getActiveDate();
	}
	form.setData("activeDate", activeDate);
    }
    
    public static void buildCalendarMenu(OzCalendarEvent event, Menu menu, IFormDecorator decorator) {
	if (decorator == null) {
	    return;
	}
	initCalendarMenu(menu);
	createMenuItem(menu, ADD_ACTION, decorator);
	createMenuItem(menu, EDIT_ACTION, decorator);
	createMenuItem(menu, DEL_ACTION, decorator);
    }
    
    public static void createMenuItem(Menu menu, String actionId, IFormDecorator decorator) {
	if (decorator == null) {
	    return;
	}
	AbstractFormDecorator formDecorator = (AbstractFormDecorator) decorator;
	IAction action = formDecorator.getGlobalAction(actionId);
	if (action == null) {
	    return;
	}
	formDecorator.createMenuItem(menu, action);
    }
    
    public static Date getActiveDate(IEditForm form) {
	return (Date) form.getData("activeDate");
    }
    
    public static IEntitySelector createEntitySelector(OzCalendar calendar) {
	return new CalendarSelector(calendar);
    }
    
    public static class CalendarSelector implements IEntitySelector {

	private OzCalendar ozCalendar;
	
	public CalendarSelector(OzCalendar ozCalendar) {
	    this.ozCalendar = ozCalendar;
	}

	public Object getSelectedEntity() {
	    return null;
	}

	public Serializable getSelectedEntityId() {
	    OzCalendarEvent event = ozCalendar.getSelectedEvent();
	    Integer id = null;
	    if (event == null || event.getId() == null) {
		return id;
	    }
	    try {
		id = Integer.valueOf(event.getId());
	    } catch(NumberFormatException e) {
	    }
	    return id;
	}

	public boolean isSelected() {
	    return ozCalendar.getSelectedEvent() != null;
	}
	
    }
}
