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
 * Created on 13.07.2005
 *
 */
package org.plazmaforge.bsolution.partner.client.swing.forms;

import java.awt.Window;

import javax.swing.JDesktopPane;

import org.plazmaforge.bsolution.partner.common.beans.IPartnerHeader;
import org.plazmaforge.bsolution.partner.common.services.PartnerableService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;



/**
 * @author hapon
 *
 */
public abstract class AbstractPartnerableList extends EXTListForm implements PartnerableForm {
    
    private IPartnerHeader partner;
    

    public AbstractPartnerableList() {
        super();
    }
    
    public AbstractPartnerableList(JDesktopPane desktop, Resources resources) {
        super(desktop, resources);
    }
    
    public AbstractPartnerableList(JDesktopPane jDesktopPane, String s) {
        super(jDesktopPane, s);
    }
    
    public AbstractPartnerableList(Resources resources) {
        super(resources);
    }
    
    public AbstractPartnerableList(String s) {
        super(s);
    }
    
    public AbstractPartnerableList(Window window, Resources resources) {
        super(window, resources);
    }
    
    
    
    public IPartnerHeader getPartner() {
        return partner;
    }
    
    public void setPartner(IPartnerHeader partner) {
        this.partner = partner;
    }
    

    protected PartnerableService getPartnerableService() {
        return (PartnerableService) this.getEntityService();
    }
    
    
    protected void loadData() throws ApplicationException {
        refreshTableModel(getPartnerableService().findByPartnerId(getPartner().getId()));
    }
    
    
    protected EditForm getEditForm() throws ApplicationException {
        EditForm form = super.getEditForm();
        ((PartnerableForm) form).setPartner(this.getPartner());
        return form;
    }


}
