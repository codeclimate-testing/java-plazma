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

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.plazmaforge.bsolution.base.client.swing.forms.LanguageList;
import org.plazmaforge.bsolution.base.common.beans.Language;
import org.plazmaforge.bsolution.personality.client.swing.GUIPersonalityEnvironment;
import org.plazmaforge.bsolution.personality.common.beans.PersonLanguage;
import org.plazmaforge.bsolution.personality.common.services.PersonLanguageService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;



/**
 * @author Oleh Hapon
 * Date: 27.09.2004
 * Time: 8:56:06
 * $Id: PersonLanguageEdit.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class PersonLanguageEdit extends AbstractPersonableEdit {

    private JLabel languageLabel;
    private JLabel easyLabel;

    private XComboEdit languageComboEdit;
    private JCheckBox easyCheckBox;


    public PersonLanguageEdit() throws ApplicationException {
        super(GUIPersonalityEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(PersonLanguage.class);
        this.setEntityServiceClass(PersonLanguageService.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));

	languageLabel = new JLabel(getString("panel.label-language.text"));
	easyLabel = new JLabel(getString("panel.label-easy.text"));

	languageComboEdit = new XComboEdit();
	languageComboEdit.setColumns(30);
	easyCheckBox = new JCheckBox();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(languageLabel);
	editPanel.addByY(easyLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	editPanel.add(languageComboEdit);
	editPanel.addByY(easyCheckBox);

	add(editPanel);

	languageComboEdit.initListFormAction(this, LanguageList.class);
    }

    private PersonLanguage getPersonLanguage() {
        return (PersonLanguage) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getPersonLanguage().getLanguageName());
        languageComboEdit.setValue(getPersonLanguage().getLanguage());
        easyCheckBox.setSelected(getPersonLanguage().isEasy());
    }


    protected void populateData() throws ApplicationException {
        getPersonLanguage().setLanguage((Language) languageComboEdit.getValue());
        getPersonLanguage().setEasy(easyCheckBox.isSelected());
    }

}
