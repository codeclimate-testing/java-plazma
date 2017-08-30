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

/* 
 * Created on 25.07.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms;


import org.eclipse.core.runtime.IProgressMonitorWithBlocking;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ProgressIndicator;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.base.EnterpriseConstants;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.client.swt.SWTResourceManager;

/** 
 * @author Oleh Hapon
 * $Id: SplashForm.java,v 1.2 2010/04/28 06:31:00 ohapon Exp $
 */

public class SplashForm extends Composite  implements EnterpriseConstants {

    private static String DEFAULT_TASKNAME = ""; //JFaceResources.getString("ProgressMonitorDialog.message");
    
    private Image image;
    
    private ProgressIndicator progressIndicator;
    
    private ProgressMonitor progressMonitor = new ProgressMonitor();
    
    private String task;
    
    
    public SplashForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }

    
    private void initialize() {
	    
	    Composite bar = new Composite(this, SWT.NONE);
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.marginWidth = 0;
	    gridLayout.verticalSpacing = 2;
	    gridLayout.marginTop = 2;
	    gridLayout.marginBottom = 0; // 2;
	    gridLayout.marginHeight = 2;
	    
	    gridLayout.horizontalSpacing = 0;
	    
	    bar.setLayout(gridLayout);
	    
	    Label versionLabel = new Label(bar, SWT.NONE);
	    versionLabel.setAlignment(SWT.CENTER);
	    GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
	    versionLabel.setLayoutData(gridData);
	    versionLabel.setText(APP_NAME + " " + VERSION + " " + (AppEnvironment.isDemo() ? "Demo" : ""));
	    versionLabel.setFont(SWTResourceManager.getBoldFont(versionLabel.getFont()));
	    
	    Label copyrightLabel = new Label(bar, SWT.CENTER);
	    copyrightLabel.setAlignment(SWT.CENTER);
	    gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
	    copyrightLabel.setLayoutData(gridData);
	    
	    copyrightLabel.setText(COPYRIGHT);
	    
	    progressIndicator = new ProgressIndicator(bar);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	    progressIndicator.setLayoutData(gridData);
	 
	    Label label = new Label(this, SWT.NONE);
	    image = SWTResourceManager.getImage(getClass(), "/org/plazmaforge/framework/client/images/about.jpg");
	    label.setImage(image);
	    
	    FormLayout layout = new FormLayout();
	    this.setLayout(layout);
	    
	    FormData labelData = new FormData();
	    labelData.right = new FormAttachment(100, 0);
	    labelData.bottom = new FormAttachment(100, 0);
	    label.setLayoutData(labelData);
	    
	    FormData progressData = new FormData();
	    progressData.left = new FormAttachment(0, 0);//5
	    progressData.right = new FormAttachment(100, 0);//-5
	    progressData.bottom = new FormAttachment(100, 0);//-5
	    bar.setLayoutData(progressData);
	    bar.pack();
	
    }
    
    public void dispose () {
	image.dispose();
	super.dispose();
    }
    
    public void run(IRunnableWithProgress progress) {
	try {
            //aboutToRun();
            //Let the progress monitor know if they need to update in UI Thread
	    boolean fork = true;
            progressMonitor.forked = fork;
            ModalContext.run(progress, fork, progressMonitor, getShell().getDisplay());
	} catch (Exception e) {
	    e.printStackTrace();
        } finally {
            //finishedRun();
        }
    }
    
   
    
    private class ProgressMonitor implements IProgressMonitorWithBlocking {
	
        private String fSubTask = "";

        private boolean fIsCanceled;

        protected boolean forked = false;

        protected boolean locked = false;

        public void beginTask(String name, int totalWork) {
	    if (progressIndicator.isDisposed()) {
		return;
	    }
	    if (name == null) {
		task = "";
	    } else {
		task = name;
	    }
	    String s = task;
	    if (s.length() <= 0) {
		s = DEFAULT_TASKNAME;
	    }
	    // setMessage(s);
	    if (!forked) {
		update();
	    }
	    if (totalWork == UNKNOWN) {
		progressIndicator.beginAnimatedTask();
	    } else {
		progressIndicator.beginTask(totalWork);
	    }
	}

        public void done() {
            if (!progressIndicator.isDisposed()) {
                progressIndicator.sendRemainingWork();
                progressIndicator.done();
            }
        }

        public void setTaskName(String name) {
	    if (name == null) {
		task = "";
	    } else {
		task = name;
	    }
	    String s = task;
	    if (s.length() <= 0) {
		s = DEFAULT_TASKNAME;
	    }
	    // setMessage(s);
	    if (!forked) {
		update();
	    }
	}

        public boolean isCanceled() {
            return fIsCanceled;
        }

        public void setCanceled(boolean b) {
	    fIsCanceled = b;
	    if (locked) {
		clearBlocked();
	    }
	}

        public void subTask(String name) {
            /*
            if (subTaskLabel.isDisposed()) {
		return;
	    }
	    */
            if (name == null) {
		fSubTask = "";//$NON-NLS-1$
	    } else {
		fSubTask = name;
	    }
            /*
            subTaskLabel.setText(shortenText(fSubTask, subTaskLabel));
	    if (!forked) {
		subTaskLabel.update();
	    }
	    */
        }

        public void worked(int work) {
            internalWorked(work);
        }

        public void internalWorked(double work) {
	    if (!progressIndicator.isDisposed()) {
		progressIndicator.worked(work);
	    }
	}

        public void clearBlocked() {
            locked = false;
            //updateForClearBlocked();
        }

        public void setBlocked(IStatus reason) {
            locked = true;
            //updateForSetBlocked(reason);
        }
    }
    
  
}
