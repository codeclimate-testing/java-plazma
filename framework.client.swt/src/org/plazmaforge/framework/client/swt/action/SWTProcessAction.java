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
 * Created on 03.10.2009
 *
 */

package org.plazmaforge.framework.client.swt.action;

import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.action.DefaultAction;
import org.plazmaforge.framework.action.IProcess;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.client.swt.app.SWTProcessRunner;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * The special action with SWTProgressRunner.
 * The SWTProgressRunner uses progress monitor.
 * 
 * @author Oleh Hapon
 * $Id: SWTProcessAction.java,v 1.4 2010/12/05 07:52:26 ohapon Exp $
 */

public abstract class SWTProcessAction extends DefaultAction {

    
    /** 
     * Process Runner
     */
    SWTProcessRunner runner;

    /** 
     * Execute the process.
     * Dont't update GUI in this method. (ERROR: Invalid thread access)
     * To update GUI use finalizeProcess method. 
     * @throws ApplicationException
     */
    protected abstract void executeProcess() throws ApplicationException;
    
    
    /**
     * Execute action
     */
    public void execute() throws ApplicationException {
	
	if (!prepareProcess()) {
	    return;
	}
	
	IProcess process = createProcess();
	if (process == null) {
	    return;
	}
	
    	runner = createRunner();
    	if (runner == null) {
    	    return;
    	}
    	
    	initRunner(runner);
    	
    	runner.run(process);

    	finalizeProcess();
    }
    
    /**
     * Create SWT Process Runner
     * @return
     */
    protected SWTProcessRunner createRunner() {
	return new SWTProcessRunner() {
	    public String getResultMessage() {
		String message = createResultMessage();
	        return message == null ? super.getResultMessage() : message;
	    }
	};
    }
    
    protected SWTProcessRunner getRunner() {
        return runner;
    }


    /**
     * Initialize SWT Process Runner 
     * @param runner
     */
    protected void initRunner(SWTProcessRunner runner) {
    	runner.setResultDialog(true);
    }

    
    /**
     * Create process
     * @return
     */
    protected IProcess createProcess() {
    	IProcess process = new IProcess() {
    	    public void run() throws ApplicationException {
    		executeProcess();
    	    }
    	};
    	return process;
    }

    /**
     * Prepare process
     * @return true if process is ready
     * @throws ApplicationException
     */
    protected boolean prepareProcess() throws ApplicationException  {
	return true;
    }

    /**
     * Finalize Process.
     * For example close resources, update GUI.
     * @throws ApplicationException
     */
    protected void finalizeProcess() throws ApplicationException  {
	
    }

    
    protected Shell getShell() {
	return SWTEnvironment.getShell();
    }

    protected String createResultMessage() {
	return null;
    }

}
