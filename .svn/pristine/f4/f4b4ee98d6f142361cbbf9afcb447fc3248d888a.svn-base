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
package org.plazmaforge.bsolution.contact.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.plazmaforge.framework.client.swt.SWTUtils;

/** 
 * @author Oleh Hapon
 * $Id: PhoneGroupPanel.java,v 1.3 2010/04/28 06:31:05 ohapon Exp $
 */

public class PhoneGroupPanel extends Composite {

    private PhonePanel phonePanel;
    
    private PhonePanel faxPanel;    
    
    public PhoneGroupPanel(Composite parent, int style) {
	super(parent, style);
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 0;
	gridLayout.marginTop = 0;
    	setLayout(gridLayout);
    	
    	phonePanel = new PhonePanel(this, SWT.NONE);
    	faxPanel = new PhonePanel(this, SWT.NONE);
    	
    	faxPanel.getPhoneStringLabel().setText("Fax");
    	
    	SWTUtils.setMaxWidth(getFixedLabels());
    }

    public PhonePanel getFaxPanel() {
        return faxPanel;
    }

    public PhonePanel getPhonePanel() {
        return phonePanel;
    }
    
    public Control[] getFixedLabels() {
	return new Control[] {phonePanel.getPhoneStringLabel(), faxPanel.getPhoneStringLabel()};
    }
    
    
}