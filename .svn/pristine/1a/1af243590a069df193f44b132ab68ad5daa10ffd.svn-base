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
import org.plazmaforge.bsolution.partner.common.services.ActivityTypeService;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;

/**
 * Created on 24.05.2006
 */
public class ActivityTypeEdit extends EXTEditForm {

    private JLabel codeLabel;
    private JLabel nameLabel;

    private XTextField codeField;
    private XTextField nameField;


    public ActivityTypeEdit() {
        super(GUIPartnerEnvironment.getResources());
        initialize();
    }

    private void initialize() {
        this.setEntityClass(ActivityType.class);
        this.setEntityServiceClass(ActivityTypeService.class);
    }


    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        codeLabel = new JLabel(getString("panel.label-code.text"));
        nameLabel = new JLabel(getString("panel.label-name.text"));

        codeField = new XTextField(10);
        codeField.setMaxChar(10);
        nameField = new XTextField(30);
        nameField.setMaxChar(30);

        GridBagPanel editPanel = new GridBagPanel();
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(codeLabel);
        editPanel.addByY(nameLabel);

        gbc.gridy = 0;
        editPanel.addByX(codeField);
        editPanel.addByY(nameField);

        add(editPanel);
    }

    private ActivityType getActivityType() {
        return (ActivityType) getEntity();
    }


    protected void updateView() throws ApplicationException {
        appendTitle(getActivityType().getName());
        codeField.setText(getActivityType().getCode());
        nameField.setText(getActivityType().getName());
    }

    protected void populateData() throws ApplicationException {
        getActivityType().setCode(codeField.getText());
        getActivityType().setName(nameField.getText());
    }

}
