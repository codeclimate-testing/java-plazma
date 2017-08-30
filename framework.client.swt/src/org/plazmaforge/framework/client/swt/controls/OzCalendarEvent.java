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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OzCalendarEvent {

    private String id;
    
    private String type;
    
    
    private Date start;
    
    private Date end;
    
    private String text;
    
    private String summury;
    
    private boolean allDayEvent;
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStart() {
        return start;
    }
    
    public void setStart(Date start) {
        this.start = start;
    }
    
    public Date getEnd() {
        return end;
    }
    
    public void setEnd(Date end) {
        this.end = end;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getSummury() {
        return summury;
    }
    
    public void setSummury(String summury) {
        this.summury = summury;
    }
    
    
    ////
    
    public boolean isAllDayEvent() {
        return allDayEvent;
    }
    public void setAllDayEvent(boolean allDayEvent) {
        this.allDayEvent = allDayEvent;
    }
    
    public List<OzPeriod> getDatesForPeriod(Date periodStart, Date periodEnd) {
	List<OzPeriod> ret = new ArrayList<OzPeriod>();
	// TODO: Must analyze period date
	if (this.start.before(periodEnd) && (this.end.after(periodStart) || equals(end, periodStart)) ) {
	    OzPeriod period = new OzPeriod();
	    period.start = this.start;
	    period.end = this.end;
	    ret.add(period);
	}
	return ret;
    }

    private boolean equals(Date d1, Date d2) {
	if (d1 == null || d2 == null) {
	    return false;
	}
	return d1.getYear() == d2.getYear()
	    && d1.getMonth() == d2.getMonth()
	    && d1.getDate() == d2.getDate();
    }
}
