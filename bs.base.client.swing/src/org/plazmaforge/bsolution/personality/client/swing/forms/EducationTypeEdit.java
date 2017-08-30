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
import org.plazmaforge.bsolution.personality.common.beans.EducationType;
import org.plazmaforge.bsolution.personality.common.services.EducationTypeService;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;



/**
 * @author Oleh Hapon
 * Date: 26.09.2004
 * Time: 10:16:36
 * $Id: EducationTypeEdit.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class EducationTypeEdit extends EXTEditForm {

    private JLabel nameLabel;
    private XTextField nameField;


    public EducationTypeEdit() throws ApplicationException {
        super(GUIPersonalityEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(EducationType.class);
        this.setEntityServiceClass(EducationTypeService.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        nameLabel = new JLabel(getString("panel.label-name.text"));

        nameField = new XTextField(50);
        nameField.setMaxChar(50);

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(nameLabel);

        gbc.gridy = 0;
        editPanel.addByX(nameField);

        add(editPanel);
    }

    private EducationType getEducationType() {
        return (EducationType) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getEducationType().getName());
        nameField.setText(getEducationType().getName());
    }


    protected void populateData() throws ApplicationException {
        getEducationType().setName(nameField.getText());
    }


}