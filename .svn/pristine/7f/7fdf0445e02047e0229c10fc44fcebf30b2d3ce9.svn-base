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


import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * Dashboard
 * 
 * @author ohapon
 *
 */
public class Dashboard extends Composite {

    
    private static final int V_ALIGNMENT = SWT.FILL;
    
    private Composite header;
    private DashboardContainer content;
    private Composite toolBar;
    
    
    public Dashboard(Composite parent, int style) {
	super(parent, style);
	
	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	setLayout(layout);
	
	// Header panel
	toolBar = createHeader(this);

	// Content panel
	content = createContent(this);
	
	// ToolBar panel
	toolBar = createToolBar(this);

    }
    
    protected Composite createHeader(Composite parent) {
	Composite c = new Composite(parent, SWT.BORDER);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	c.setLayoutData(gridData);
	GridLayout layout = new GridLayout();
	c.setLayout(layout);

	Label label = new Label(c, SWT.NONE);
	label.setText("Dashboard");
	return c;
    }
    
    protected DashboardContainer createContent(Composite parent) {
	DashboardContainer c = new DashboardContainer(parent, SWT.BORDER);
	GridData gridData = new GridData(SWT.FILL, V_ALIGNMENT, true, true);
	c.setLayoutData(gridData);
	return c;
    }
    
    protected Composite createToolBar(Composite parent) {
	Composite c = new Composite(parent, SWT.BORDER);
	GridData gridData = new GridData(SWT.FILL, V_ALIGNMENT, false, true);
	c.setLayoutData(gridData);
	
	GridLayout layout = new GridLayout(1, false);
	c.setLayout(layout);
	return c;
    }
    
    /**
     * Get dashboard widgets
     */
    public IDashboardWidget[] getWidgets() {
	return content.getWidgets();
    }
    
    public void load() throws ApplicationException {
	IDashboardWidget[] widgets = getWidgets();
	if (widgets.length == 0) {
	    return;
	}
	for (IDashboardWidget widget: widgets) {
	    try {
		widget.load();
	    } catch (ApplicationException ex) {
		widget.setErrorState(true);
	    }
	}
	layout();
    }

    public DashboardContainer getContent() {
        return content;
    }

    public void addAction(Action action) {
	if (action == null) {
	    return;
	}
	String text = action.getText();
	ImageDescriptor imageDescriptor = action.getImageDescriptor();
	Image image = imageDescriptor == null ? null : imageDescriptor.createImage();
	if (text == null && image == null) {
	    return;
	}
	//ToolButton button = new ToolButton(toolBar, SWT.NONE); 
	Button button = new Button(toolBar, SWT.NONE);
	if (text != null) {
	    button.setText(text);
	}
	if (image != null) {
	    button.setImage(image);
	}
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	button.setLayoutData(gridData);
    }
    
}
