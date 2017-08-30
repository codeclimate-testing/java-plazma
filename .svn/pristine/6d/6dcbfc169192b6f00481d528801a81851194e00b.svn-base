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
import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class DashboardWidget extends Composite implements IDashboardWidget {

    
    private String id;
    
    private String name;
    
    private String description;
    
    
    
    private boolean errorState;
    
    
    public DashboardWidget(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    public DashboardWidget(Composite parent) {
	super(parent, SWT.BORDER);
	initialize();
    }
    
    private void initialize() {
	GridData gridData = createLayoutData();
	setLayoutData(gridData);
	createContent();
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
    
    protected void createContent() {
	
    }
    
    protected GridData createLayoutData() {
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	return gridData;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isErrorState() {
        return errorState;
    }
    
    public void setErrorState(boolean errorState) {
        this.errorState = errorState;
    }


    ///////////////////////////////////////////////////////////////////////////////////
    
    public void load() throws ApplicationException {
	//do nothing
    }
    
    
    
    
    
}
