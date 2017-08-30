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

package org.plazmaforge.bsolution.base.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.framework.client.forms.IFormController;
import org.plazmaforge.framework.client.swt.controls.Dashboard;
import org.plazmaforge.framework.client.swt.controls.TextDashboardWidget;
import org.plazmaforge.framework.client.swt.forms.AbstractForm;
import org.plazmaforge.framework.client.swt.forms.SWTFormController;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class DashboardForm extends AbstractForm implements IMyForm {

    /** Organization ID **/
    private Integer organizationId;
    
    private Dashboard dashboard; 
    
    public DashboardForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }

    private void initialize() {
	
	setTitle("Dashboard"); //$NON-NLS-1$
	GridLayout gridLayout = new GridLayout();
	setLayout(gridLayout);
	
	dashboard = new Dashboard(this, SWT.NONE);
	dashboard.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	populateDashboard();
	
	setAutoConfigureAssociation(false);

    }
    
    protected void populateDashboard() {
	if (dashboard == null) {
	    return;
	}
	
	// TODO: Test: Add widgets to Dashboard
	TextDashboardWidget widget = null;
	for (int i = 1; i <= 7; i++) {
	    widget = new TextDashboardWidget(dashboard.getContent());
	    widget.setName("Widget " + i );
	    widget.setDescription("Widget Description " + i);
	}
	
	// TODO: Test: Add actions to Dashboard
	org.eclipse.jface.action.Action action = null;
	for (int i = 1; i <= 7; i++) {
	    action = createAction("Action " + i);
	    dashboard.addAction(action);
	}
	
    }
    
    protected IFormController createController() {
	SWTFormController controller = new SWTFormController();
	controller.setForm(this);
	return controller;
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	getParent().layout(); // SPECIAL FOR ECLIPSE RCP and single windows :)
    }
    
    protected void updateTitle(String title) {
	if (isMyFormMode()) {
	    //getDecorator().setTitle(Messages.getString("MyPIMCalendarForm.title"));
	    return;
	}
	super.updateTitle(title);
    }
    
    public void init() throws ApplicationException {
	super.init();
	
	// Load data from source
	doLoadData();

    }

    protected void loadData() throws ApplicationException {
	if (dashboard == null) {
	    return;
	}
	dashboard.load();
    }
      
    /////////////////////////////////////////////////////////////////////////
    
    // TODO: Test
    private org.eclipse.jface.action.Action createAction(String text) {
	// JFace Action
	org.eclipse.jface.action.Action action = new org.eclipse.jface.action.Action() {
	    public void run() {
		// do nothing
	    }
	};
	action.setText(text);
	return action;
    }
    
}
