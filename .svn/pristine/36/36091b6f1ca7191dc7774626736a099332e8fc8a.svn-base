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

package org.plazmaforge.bsolution.partner.client.swing.forms;


import javax.swing.*;

import org.plazmaforge.bsolution.partner.client.swing.GUIPartnerEnvironment;
import org.plazmaforge.bsolution.partner.common.beans.ActivityType;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.beans.PartnerActivityTypeLink;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.forms.EXTChildEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 27.05.2006
 * Time: 17:49:25
 * $Id: PartnerActivityTypeLinkEdit.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 */
public class PartnerActivityTypeLinkEdit extends EXTChildEditForm {

    private JLabel activityTypeLabel;
    private XComboEdit activityTypeComboEdit;

    public PartnerActivityTypeLinkEdit() throws ApplicationException {
        super(GUIPartnerEnvironment.getResources());
        initialize();
    }

    private void initialize() {
        this.setEntityClass(PartnerActivityTypeLink.class);
    }

    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));

        activityTypeLabel = new JLabel(getString("panel.label-activity-type.text"));
        activityTypeComboEdit = new XComboEdit();
        activityTypeComboEdit.setColumns(30);

        GridBagPanel editPanel = new GridBagPanel();
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(activityTypeLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        editPanel.add(activityTypeComboEdit);

        activityTypeComboEdit.initListFormAction(this, ActivityTypeList.class);
        add(editPanel);
    }

    private PartnerActivityTypeLink getPartnerActivityTypeLink() {
        return (PartnerActivityTypeLink) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getPartnerActivityTypeLink().getActivityTypeName());
        activityTypeComboEdit.setValue(getPartnerActivityTypeLink().getActivityType());
    }

    private Partner partner;

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    protected void populateData() throws ApplicationException {
        getPartnerActivityTypeLink().setActivityType((ActivityType) activityTypeComboEdit.getValue());
    }

    protected void addChild() throws ApplicationException {
        getPartner().addPartnerActivityTypeLink(getPartnerActivityTypeLink());
    }

}
