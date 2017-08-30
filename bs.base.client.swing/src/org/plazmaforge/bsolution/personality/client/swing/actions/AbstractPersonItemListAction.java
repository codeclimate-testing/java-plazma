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
 * Created on 08.07.2005
 *
 */
package org.plazmaforge.bsolution.personality.client.swing.actions;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.JDialog;

import org.plazmaforge.bsolution.personality.client.swing.forms.AbstractPersonableList;
import org.plazmaforge.framework.client.swing.actions.AcceptorAction;
import org.plazmaforge.framework.client.swing.forms.ListableMode;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;



/**
 * @author hapon
 *
 */
public abstract class AbstractPersonItemListAction  extends GUIPersonalityAction implements AcceptorAction {
    

    private IAcceptor acceptor;

    public void perform(ActionEvent e) throws ApplicationException {
        if (acceptor == null) return;
        Map parameters = acceptor.readParameters();
        if (parameters == null) return;
        Object prm = parameters.get(IAcceptor.ID);
        Integer personId = (Integer) prm;
        
        AbstractPersonableList listForm = createPersonItemList((JDialog) parameters.get("DIALOG"));
        listForm.initListableMode(ListableMode.LIST);
        listForm.setPersonId(personId);
        listForm.showList();
    }

    public IAcceptor getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(IAcceptor acceptor) {
        this.acceptor = acceptor;
    }
    
    protected abstract AbstractPersonableList createPersonItemList(JDialog dialog) throws ApplicationException;
}
