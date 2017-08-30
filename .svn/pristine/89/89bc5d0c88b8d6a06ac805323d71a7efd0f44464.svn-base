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
package org.plazmaforge.bsolution.employee.client.swing.forms;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.plazmaforge.bsolution.employee.client.swing.GUIEmployeeEnvironment;
import org.plazmaforge.bsolution.employee.common.beans.JobPosition;
import org.plazmaforge.bsolution.employee.common.services.JobPositionService;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;



/**
 * @author Oleh Hapon
 * Date: 02.03.2004
 * Time: 11:02:41
 * $Id: PositionEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class PositionEdit extends EXTEditForm {

    private JLabel nameLabel;
    private JTextField nameField;

    public PositionEdit() throws ApplicationException {
        super(GUIEmployeeEnvironment.getResources());
        initialize();
    }

    private void initialize() {
        this.setEntityClass(JobPosition.class);
        this.setEntityServiceClass(JobPositionService.class);
    }
    
    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));

        nameLabel = new JLabel(getString("panel.label-name.text"));
        nameField = new JTextField(25);

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(nameLabel);
        gbc.gridy = 0;
        editPanel.addByX(nameField);
        
        add(editPanel);
    }

    private JobPosition getPostion() {
        return (JobPosition) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getPostion().getName());
        nameField.setText(getPostion().getName());
    }

    protected void populateData() throws ApplicationException {
        getPostion().setName(nameField.getText());
    }


}
