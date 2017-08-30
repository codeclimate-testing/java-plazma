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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEditFormDecorator;
import org.plazmaforge.framework.client.forms.IFormConstants;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.SystemInfo;


/** 
 * @author Oleh Hapon
 *
 */

public class SWTEditFormDecorator extends AbstractFormDecorator implements ISWTEditFormDecorator, IEditFormDecorator, IFormConstants {

    
    private Composite content;
    private Composite buttonBar;
    private Composite statusBar;
    
    private Label statusLabel;
    
    private Button okButton; // OK
    private Button cancelButton; // CANCEL
    private Button applyButton; // APPLY
    
    
    public SWTEditFormDecorator(Composite parent) {
	this(parent, SWT.NONE);
	//initialize();
    }
    
    public SWTEditFormDecorator(Composite parent, int style) {
	super(parent, style);
	initialize();
    }

    private void initialize() {
    	
    	GridLayout gridLayout;
    	
    	GridData gridData;
    	Composite composite;
    	FillLayout fillLayout;
    	gridLayout = new GridLayout();
    	gridLayout.verticalSpacing = 0;
    	gridLayout.marginHeight = 0;
    	gridLayout.marginWidth = 0;
    	setLayout(gridLayout);

    	composite = new Composite(this, SWT.NONE);
    	fillLayout = new FillLayout();
    	fillLayout.marginWidth = 1;
    	composite.setLayout(fillLayout);
    	composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	
    	coolBar = createCoolBar(composite);
    	
 	content = new Composite(this, SWT.BORDER);
    	content.setLayout(new FillLayout());
    	content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true)); 
    	
    	buttonBar = new Composite(this, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.marginHeight = 2;
    	gridLayout.marginTop = 5;
    	gridLayout.marginBottom = 5;
    	gridLayout.numColumns = 3; //isSupportedApplyButton() ? 3 : 2;
    	buttonBar.setLayout(gridLayout);
    	buttonBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    	int BUTTON_WIDTH = 90; // stub
    	// OK
    	okButton = new Button(buttonBar, SWT.NONE);
    	okButton.addSelectionListener(new SelectionAdapter() {
    		public void widgetSelected(SelectionEvent e) {
    		    doAction(OK_ACTION);
    		}
    	});
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
    	gridData.widthHint = BUTTON_WIDTH;
    	//gridData.minimumWidth = 100;
    	okButton.setLayoutData(gridData);
    	okButton.setText(Messages.getString("Form.okButton.text")); //$NON-NLS-1$

    	
    	// CANCEL
    	cancelButton = new Button(buttonBar, SWT.NONE);
    	cancelButton.addSelectionListener(new SelectionAdapter() {
    		public void widgetSelected(SelectionEvent e) {
    		    doAction(CANCEL_ACTION);
    		}
    	});
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.widthHint = BUTTON_WIDTH;
    	cancelButton.setLayoutData(gridData);
    	cancelButton.setText(Messages.getString("Form.cancelButton.text")); //$NON-NLS-1$

    	// APPLY
    	if (isSupportedApplyButton()) {
    	    applyButton = new Button(buttonBar, SWT.NONE);
            applyButton.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        	    doAction(SAVE_ACTION);
            	}
            });
            gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
            //gridData.horizontalIndent = 20;
            gridData.widthHint = BUTTON_WIDTH;
            applyButton.setLayoutData(gridData);
            applyButton.setText(Messages.getString("Form.applyButton.text")); //$NON-NLS-1$
    	}

    	
    	statusBar = new Composite(this, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.marginHeight = 0;
    	statusBar.setLayout(gridLayout);
    	gridData = new  GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.heightHint = 5;
    	statusBar.setLayoutData(gridData);

    	this.setSize(new Point(500, 390));
    	
    	
	addTraverseListener(new TraverseListener() {
	    public void keyTraversed(TraverseEvent e) {
		if (e.keyCode == SWT.F1) {
		    doAction(HELP_ACTION);
		} else if (e.keyCode == SWT.ESC) {
		    // NEW CLOSE
		    e.doit = false;
		    doAction(CANCEL_ACTION);
		} else if (e.keyCode == SWT.CR && e.stateMask == SWT.CTRL) {
		    doAction(OK_ACTION);
		}

      	    }
    	});
    	
    }
    protected boolean isSupportedApplyButton() {
	return true; //isForceUpdate(); /*false*/
    }
    
      
    protected ToolBar createToolBar(CoolBar parent) {

    	toolBarManager = newToolBarManager();
    	coolBarManager.add(toolBarManager);
    	toolBarManager.add(createAction(HELP_ACTION, Messages.getString("Form.help"), HELP_IMAGE));
    	
	//initSize(coolItem, toolBar);
	
	return null;
    }
    
    
    protected void initFillLayout(FillLayout fillLayout) {
	if (fillLayout == null) {
	    return;
	}
	if (SystemInfo.isWindows) {
	    return;
	}
	fillLayout.marginHeight = 0;
    }    
    
    public Composite getContent() {
        return content;
    }


    public Composite getStatusBar() {
        return statusBar;
    }

    protected String getDecoratorTitle() {
	return Messages.getString("Form.title");
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
    
    protected IEditForm getEditForm() {
	return (IEditForm) getForm();
    }
    
    public void initActions() throws ApplicationException {
	super.initActions();
	updateActions();
    }
    
    public void initToolBar() throws ApplicationException {
	createToolBar(coolBar);
    }
    
    public void initMenuBar() throws ApplicationException {
	// stub
    }

    protected void updateActions() throws ApplicationException {
	if (getEditForm() == null) {
	    return;
	}
	setEnabledDropDownActions(!getEditForm().isAddMode());
    }
    
    
    public void setStatusText(String text) {
	if (statusLabel == null) {
	     return;
	}
	statusLabel.setText(text);
    }
    
    public String getStatusText() {
	if (statusLabel == null) {
	    return ""; 
	}
	return statusLabel.getText();
    }
    
    public void setStatusSummaryText(String text) {
	//STUB
    }
 
    public void open() {
	//layout();
	pack();
	center();
	super.open();
	setFormFocus();
    }

  
    
}
