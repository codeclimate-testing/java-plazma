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

package org.plazmaforge.framework.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormConstants;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class SWTFormDecorator extends AbstractFormDecorator implements ISWTFormDecorator, IFormConstants  {

    private Composite content;
    
    private CoolBar coolBar;
    
    private CoolItem coolItem;
    
    private ToolBar toolBar;
    
    private Composite statusBar;
    
    
    private Label statusLabel;
    
    
    public SWTFormDecorator(Composite parent, int style) {
	super(parent, style);
	initialize();
    }

    public SWTFormDecorator(Composite parent) {
	super(parent);
	initialize();
    }

    private void initialize() {
    	
    	GridLayout gridLayout;
    	Composite composite;
    	FillLayout fillLayout;
    	
    	GridData gridData;

    	gridLayout = new GridLayout();
    	gridLayout.verticalSpacing = 0;
    	gridLayout.marginHeight = 0;
    	gridLayout.marginWidth = 0;
    	setLayout(gridLayout);

    	/*
    	composite = new Composite(this, SWT.NONE);
    	
  
    	fillLayout = new FillLayout();
    	fillLayout.type = org.eclipse.swt.SWT.HORIZONTAL;
    	
    	//initFillLayout(fillLayout);
    	
    	composite.setLayout(fillLayout);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	composite.setLayoutData(gridData);
    	
    	//coolBar = createCoolBar(composite);
  	 */

 	content = new Composite(this, SWT.BORDER);
    	content.setLayout(new FillLayout());
    	content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true)); 
    	

    	statusBar = new Composite(this, SWT.BORDER);
    	gridLayout = new GridLayout();
    	gridLayout.marginHeight = 0;
    	gridLayout.numColumns = 3;
    	statusBar.setLayout(gridLayout);
    	statusBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	statusLabel = new Label(statusBar, SWT.NONE);
    	statusLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	statusLabel.setText("View");
    	
    	//createStatusToolPanel(statusBar);
    	//createStatusSummaryPanel(statusBar);
    	
    	this.setSize(new Point(307, 290));
    	
	addTraverseListener(new TraverseListener() {
	    public void keyTraversed(TraverseEvent e) {
		if (e.keyCode == SWT.F1) {
		    doAction(HELP_ACTION);
		} else if (e.keyCode == SWT.ESC) {
		    //doAction(CANCEL_ACTION);
		    //getForm()
		    //if (getListForm() != null && (getListForm().isChooseState() || isModal())) {
			// doAction(CLOSE_ACTION);
		    //} else {
			e.doit = false;
		    //}
		    
		} else if (e.keyCode == SWT.CR && e.stateMask == SWT.CTRL) {
		    doAction(SAVE_ACTION);
		}

      	    }
    	});    	
    }


    public void init() throws ApplicationException {

	setTitle("Form");

	// Initialize form
	initForm();

    }

    protected void checkFormClass(IForm form) {

    }

    public void initForm() throws ApplicationException {
	if (getForm() == null) {
	    return;
	}

	String title = getForm().getTitle();
	if (title != null) {
	    setTitle(title);
	}
	getForm().init();
    }

    public void initToolBar() throws ApplicationException {
	
    }
    
    public void initMenuBar() throws ApplicationException {
	// stub
    }

    
    public void open() {
	
	// SPECIAL FOR ECLIPSE RCP :)
	getParent().getParent().layout();
	
	super.open();
	setFormFocus();
	
    }
    
    
    public Composite getContent() {
        return content;
    }


    public Composite getStatusBar() {
        return statusBar;
    }

    public CoolBar getCoolBar() {
        return coolBar;
    }
    
    public ToolBar getToolBar() {
        return toolBar;
    }
    
    public Table getTable() {
	return null;
    }

    ////
    
    public void setStatusSummaryText(String text) {
	
    }
    
    public void setStatusText(String text) {
	
    }
    
    public String getStatusText() {
	return "";
    }
}
