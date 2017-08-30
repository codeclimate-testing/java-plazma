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

package org.plazmaforge.bsolution.personality.client.swing.forms;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import org.plazmaforge.bsolution.personality.client.swing.GUIPersonalityEnvironment;
import org.plazmaforge.bsolution.personality.common.beans.PersonJob;
import org.plazmaforge.bsolution.personality.common.services.PersonJobService;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/**
 * @author Oleh Hapon
 * Date: 27.09.2004
 * Time: 8:06:32
 * $Id: PersonJobEdit.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class PersonJobEdit extends AbstractPersonableEdit {

    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JLabel organizationLabel;
    private JLabel positionLabel;

    private XDateField startDateField;
    private XDateField endDateField;
    private XTextField organizationField;
    private XTextField positionField;


    public PersonJobEdit() throws ApplicationException {
        super(GUIPersonalityEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(PersonJob.class);
        this.setEntityServiceClass(PersonJobService.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        startDateLabel = new JLabel(getString("panel.label-start-date.text"));
        endDateLabel = new JLabel(getString("panel.label-end-date.text"));
        organizationLabel = new JLabel(getString("panel.label-organization.text"));
        positionLabel = new JLabel(getString("panel.label-position.text"));

        startDateField = new XDateField();
        endDateField = new XDateField();
        organizationField = new XTextField(30);
        positionField = new XTextField(30);

        GridBagPanel editPanel = new GridBagPanel();
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(startDateLabel);
        editPanel.addByY(endDateLabel);
        editPanel.addByY(organizationLabel);
        editPanel.addByY(positionLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        editPanel.add(startDateField);
        editPanel.addByY(endDateField);
        editPanel.addByY(organizationField);
        editPanel.addByY(positionField);

        add(editPanel);


    }

    private PersonJob getPersonJob() {
        return (PersonJob) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        //appendTitle(details.getName());
        startDateField.setDate(getPersonJob().getEndDate());
        endDateField.setDate(getPersonJob().getEndDate());
        organizationField.setText(getPersonJob().getOrganization());
        positionField.setText(getPersonJob().getPosition());
    }


    protected void populateData() throws ApplicationException {
        getPersonJob().setStartDate(startDateField.getDate());
        getPersonJob().setEndDate(endDateField.getDate());
        getPersonJob().setOrganization(organizationField.getText());
        getPersonJob().setPosition(positionField.getText());
    }


}
