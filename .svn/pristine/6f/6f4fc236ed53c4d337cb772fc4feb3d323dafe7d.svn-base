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
 * Created on 16.12.2007
 *
 */

package org.plazmaforge.framework.client.swt.app;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.action.IProcess;
import org.plazmaforge.framework.action.IProcessRunner;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;


/** 
 * @author Oleh Hapon
 * $Id: SWTProcessRunner.java,v 1.5 2010/12/05 07:52:26 ohapon Exp $
 */

public class SWTProcessRunner implements IProcessRunner {

    
    public static final String PROCESSING_MESSAGE = Messages.getString("SWTProcessRunner.processing");
	
	
    /** true if we use confirm dialog **/
    private boolean confirmDialog;
    
    /** confirm message **/
    private String confirmMessage;
    

    /** true if we use result dialog **/
    private boolean resultDialog;
    
    /** result message **/
    private String resultMessage;
    
    
    /** processing message **/
    private String processingMessage;
    

    private Shell shell;
    
    static {
	
	// HARD CODE
	// Initialize Toolkit Manager
	SWTEnvironment.initToolkitManager();
	
    }
    
    public SWTProcessRunner() {
	super();
	confirmDialog = false;
	resultDialog = false;
	confirmMessage = Messages.getString("SWTProcessRunner.confirm");
	resultMessage = Messages.getString("SWTProcessRunner.result");
    }

    ////
    
    public boolean isConfirmDialog() {
        return confirmDialog;
    }

    public void setConfirmDialog(boolean confirmDialog) {
        this.confirmDialog = confirmDialog;
    }

    public String getConfirmMessage() {
        return confirmMessage;
    }

    public void setConfirmMessage(String confirmMessage) {
        this.confirmMessage = confirmMessage;
    }

    ////
    
    public boolean isResultDialog() {
        return resultDialog;
    }

    public void setResultDialog(boolean resultDialog) {
        this.resultDialog = resultDialog;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }


    ////
    

    public String getProcessingMessage() {
	if (processingMessage == null) {
	    return PROCESSING_MESSAGE;
	}
        return processingMessage;
    }

    public void setProcessingMessage(String processingMessage) {
        this.processingMessage = processingMessage;
    }

    ////
    
    

    protected Shell getShell() {
	if (shell == null) {
	    shell = SWTEnvironment.getShell();
	}
	return shell;
    }

    
    

    public void setShell(Shell shell) {
        this.shell = shell;
    }


    public void run(final IProcess process) throws ApplicationException {
	
	// CONFIRM DIALOG
	if (supportDialog(isConfirmDialog(), getConfirmMessage())) {
	    if (!openConfirmDialog()) {
		return;
	    }
	}

	    
	    
	ProgressMonitorDialog monitorDialog = new ProgressMonitorDialog(getShell());
	try {
	    monitorDialog.run(true, false, new IRunnableWithProgress() {

		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		    monitor.beginTask(getProcessingMessage(), -1);
		    try {
			process.run();
		    } catch (Exception ex) {
			throw new InvocationTargetException(ex);
		    }
		}
	    });

	    
	    // RESULT DIALOG
	    if (!supportDialog(isResultDialog(), getResultMessage())) {
		return;
	    }
	    openResultDialog();
	    
	    
	} catch (InvocationTargetException ex) {
	    
	    Throwable cause = ex.getCause();
	    if (cause != null) {
		if (cause instanceof ApplicationException) {
		    throw (ApplicationException) cause;
		}
		throw new ApplicationException(cause);
	    }
	    
	    throw new ApplicationException(ex);
	    
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    protected boolean openConfirmDialog() {
	return openConfirmDialogToolkit();
    }
    
    protected void openResultDialog() {
	openResultDialogToolkit();
    }


    // DISABLE: 2010-05-11. Reason: The SWT Toolkit Manager uses JFace MessageDialog.
    /*
    protected boolean openConfirmDialogJFace() {
	return MessageDialog.openQuestion(getShell(), "", getConfirmMessage());
    }
    
    protected void openResultDialogJFace() {
	MessageDialog.openInformation(getShell(), "Information", getResultMessage());
    }
    */
    
    protected boolean openConfirmDialogToolkit() {
	return Toolkit.openConfirmYesNoDialog("", getConfirmMessage());
    }	
    
    protected void openResultDialogToolkit() {
	Toolkit.openMessageDialog("Information", getResultMessage());
    }
    
    
    protected boolean supportDialog(boolean flag, String str) {
	return flag && !isEmpty(str);
    }
    
    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }
    
    
}

