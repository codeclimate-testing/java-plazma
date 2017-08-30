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
 * Created on 15.05.2006
 *
 */

package org.plazmaforge.bsolution.finance.client.swing.forms;

import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.bsolution.document.common.services.DocumentTypeService;
import org.plazmaforge.bsolution.finance.client.swing.GUIFinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocumentType;
import org.plazmaforge.bsolution.finance.common.services.FinanceDocumentTypeService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class FinanceDocumentTypeEdit extends EXTEditForm {

    private JLabel documentTypeLabel;

    private JLabel moveTypeLabel;

    private JLabel includetaxInAmountLabel;

    private XComboBox documentTypeField;

    private XTextField moveTypeField;

    private JCheckBox includetaxInAmountField;

    public FinanceDocumentTypeEdit() throws ApplicationException {
	super(GUIFinanceEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(FinanceDocumentType.class);
	this.setEntityServiceClass(FinanceDocumentTypeService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	documentTypeLabel = new JLabel(getString("panel.label-document-type.text"));
	moveTypeLabel = new JLabel(getString("panel.label-move-type.text"));
	includetaxInAmountLabel = new JLabel(getString("panel.label-include-tax-in-amount.text"));

	documentTypeField = new XComboBox(getDocumentTypeService().findAll());
	moveTypeField = new XTextField(30);
	moveTypeField.setMaxChar(30);
	includetaxInAmountField = new JCheckBox();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(documentTypeLabel);
	editPanel.addByY(moveTypeLabel);
	editPanel.addByY(includetaxInAmountLabel);

	gbc.gridy = 0;
	editPanel.addByX(documentTypeField);
	editPanel.addByY(moveTypeField);
	editPanel.addByY(includetaxInAmountField);

	add(editPanel);
    }

    private FinanceDocumentType getFinanceDocumentType() {
	return (FinanceDocumentType) this.getEntity();
    }

    private DocumentTypeService getDocumentTypeService() {
	return (DocumentTypeService) getSERVICE(DocumentTypeService.class);
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getFinanceDocumentType().getName());
	documentTypeField.setValue(getFinanceDocumentType().getDocumentType());
	moveTypeField.setText(getFinanceDocumentType().getMoveType());
	includetaxInAmountField.setSelected(getFinanceDocumentType().isIncludeTaxInAmount());
    }

    protected void populateData() throws ApplicationException {
	getFinanceDocumentType().setDocumentType((DocumentType) documentTypeField.getValue());
	getFinanceDocumentType().setMoveType(moveTypeField.getText());
	getFinanceDocumentType().setIncludeTaxInAmount(includetaxInAmountField.isSelected());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getFinanceDocumentType().getMoveType(), moveTypeLabel.getText());
	checkError(buf);
    }

}
