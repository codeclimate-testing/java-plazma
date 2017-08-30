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
import org.plazmaforge.bsolution.personality.common.beans.Familiarity;
import org.plazmaforge.bsolution.personality.common.beans.PersonFamily;
import org.plazmaforge.bsolution.personality.common.services.PersonFamilyService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/**
 * @author Oleh Hapon
 * Date: 26.09.2004
 * Time: 21:43:09
 * $Id: PersonFamilyEdit.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class PersonFamilyEdit extends AbstractPersonableEdit {

    private JLabel nameLabel;
    private JLabel familiarityLabel;
    private JLabel birthDateLabel;

    private XTextField nameField;
    private XComboEdit familiarityComboEdit;
    private XDateField birthDateField;


    public PersonFamilyEdit() throws ApplicationException {
        super(GUIPersonalityEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(PersonFamily.class);
        this.setEntityServiceClass(PersonFamilyService.class);
    }

    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));

        nameLabel = new JLabel(getString("panel.label-name.text"));
        familiarityLabel = new JLabel(getString("panel.label-familiarity.text"));
        birthDateLabel = new JLabel(getString("panel.label-birth-date.text"));

        nameField = new XTextField(30);
        familiarityComboEdit = new XComboEdit();
        birthDateField = new XDateField();

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(nameLabel);
        editPanel.addByY(familiarityLabel);
        editPanel.addByY(birthDateLabel);		

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.add(nameField);
        editPanel.addByY(familiarityComboEdit);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        editPanel.addByY(birthDateField);
		

        add(editPanel);

        familiarityComboEdit.initListFormAction(this, FamiliarityList.class);
    }

    private PersonFamily getPersonFamily() {
        return (PersonFamily) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        //appendTitle(details.getName());
        familiarityComboEdit.setValue(getPersonFamily().getFamiliarity());
        birthDateField.setDate(getPersonFamily().getBirthDate());
        nameField.setText(getPersonFamily().getName());
    }


    protected void populateData() throws ApplicationException {
        getPersonFamily().setFamiliarity((Familiarity) familiarityComboEdit.getValue());
        getPersonFamily().setBirthDate(birthDateField.getDate());
        getPersonFamily().setName(nameField.getText());
    }

}
