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

package org.plazmaforge.bsolution.pim.common.beans;

import java.util.Date;

import org.plazmaforge.bsolution.security.common.beans.UserHeader;
import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.util.StringUtils;

public class PIMNote extends BaseEntity {

    private UserHeader user;
    
    private Date noteDateTime;
    
    private String text;

    public UserHeader getUser() {
        return user;
    }

    public void setUser(UserHeader user) {
        this.user = user;
    }

    public Date getNoteDateTime() {
        return noteDateTime;
    }

    public void setNoteDateTime(Date noteDateTime) {
        this.noteDateTime = noteDateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getLabel() {
	return StringUtils.shortString(text, 100); 
    }
}
