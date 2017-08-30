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
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;

public class TextDashboardWidget extends DashboardWidget {

    private Label label;
    
    public TextDashboardWidget(Composite parent, int style) {
	super(parent, style);
    }

    public TextDashboardWidget(Composite parent) {
	super(parent);
    } 

    
    protected void createContent() {
	GridLayout layout = new GridLayout(1, false);
	setLayout(layout);
	label = new Label(this, SWT.NONE);
	label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
	label.setText("    ");
    }
    
    protected void updateLabel() {
	if (label == null) {
	    return;
	}
	String text = StringUtils.nullIfEmpty(getName());
	if (text == null) {
	    text = "<No data>";
	}
	label.setText(text);
	String description = StringUtils.nullIfEmpty(getDescription());
	if (description != null) {
	    label.setToolTipText(description);
	}
	layout();
    }
    
    public void load() throws ApplicationException {
	updateLabel();
    }
    
}
