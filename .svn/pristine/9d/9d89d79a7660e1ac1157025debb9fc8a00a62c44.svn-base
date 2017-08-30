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
 * Cretaed on 15.04.2006
 */

package org.plazmaforge.framework.platform;

import org.plazmaforge.framework.core.exception.ApplicationException;

public class PlatfromClientApplicationManager extends
	PlatformApplicationManager {

    public void onStartProcess() throws ApplicationException {
	splashShow();
    }

    public void onEndProcess() throws ApplicationException {
	splashHide();
    }

    /*
    protected void onBeforeLogin() throws ApplicationException {
	super.onBeforeLogin();
	//dialogShow();
    }
    */

    protected void onAfterLogin() throws ApplicationException {
	updateStatusBar();
	initEnvironment();
    }

    
    protected void login() throws ApplicationException {
	dialogShow();
    }
    
    protected void splashShow() throws ApplicationException {
    }

    protected void splashHide() throws ApplicationException {
    }

    protected void dialogShow() throws ApplicationException {
    }

    public void updateStatusBar() {
    }

}
