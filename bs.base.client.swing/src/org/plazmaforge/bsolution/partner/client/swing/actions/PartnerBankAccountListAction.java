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

package org.plazmaforge.bsolution.partner.client.swing.actions;


import javax.swing.*;

import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerBankAccountList;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.swing.actions.AcceptorAction;
import org.plazmaforge.framework.client.swing.forms.ListableMode;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.event.ActionEvent;
import java.util.Map;

/**
 * @author Oleh Hapon
 * Date: 15.07.2004
 * Time: 9:37:04
 * $Id: PartnerBankAccountListAction.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 */
public class PartnerBankAccountListAction extends GUIPartnerAction implements AcceptorAction {

    private IAcceptor acceptor;

    public void perform(ActionEvent e) throws ApplicationException {
        if (acceptor == null) return;
        Map parameters = acceptor.readParameters();
        if (parameters == null) return;
        PartnerBankAccountList f = new PartnerBankAccountList((JDialog) parameters.get("DIALOG"));
        f.initListableMode(ListableMode.LIST);
        Partner partner = (Partner) parameters.get(IAcceptor.ENTITY);
        f.setPartner(partner);
        
        f.setDefBankAccountId(partner.getBankAccountId());
        
        f.showList();
        
        partner.setBankAccountId(f.getDefBankAccountId());
    }

    public IAcceptor getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(IAcceptor acceptor) {
        this.acceptor = acceptor;
    }
}
