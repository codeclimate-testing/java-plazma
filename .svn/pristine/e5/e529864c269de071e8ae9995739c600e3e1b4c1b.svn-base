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
 * Created on 09.07.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms.common;


import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.finance.common.beans.OperationRegister;
import org.plazmaforge.framework.client.swt.controls.XCombo;

/** 
 * @author Oleh Hapon
 * $Id: XOperationTypeCombo.java,v 1.2 2010/04/28 06:31:07 ohapon Exp $
 */

public class XOperationTypeCombo extends XCombo {

    
    public XOperationTypeCombo(Composite parent, int style) {
	super(parent, style);
    }

    public XOperationTypeCombo(Composite parent, int style, int toolStyle) {
	super(parent, style, toolStyle);
    }
    
    public void init() {
	super.init();
	addValue(OperationRegister.DEBIT, Messages.getString("XOperationTypeCombo.operation.type.debit")); //$NON-NLS-1$
	addValue(OperationRegister.CREDIT, Messages.getString("XOperationTypeCombo.operation.type.credit")); //$NON-NLS-1$
    }
    
    
     
}

