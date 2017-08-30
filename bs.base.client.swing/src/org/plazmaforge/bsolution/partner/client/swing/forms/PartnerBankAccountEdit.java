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

import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.plazmaforge.bsolution.bank.client.swing.forms.BankList;
import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.bank.common.beans.IBankHeader;
import org.plazmaforge.bsolution.bank.common.services.BankAccountService;
import org.plazmaforge.bsolution.partner.client.swing.GUIPartnerEnvironment;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/** 
 * @author Oleh Hapon
 * Date: 16.07.2004
 * Time: 9:04:51
 * $Id: PartnerBankAccountEdit.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 */
public class PartnerBankAccountEdit extends AbstractPartnerableEdit {

    private JLabel bankNameLabel;
    private JLabel nameLabel;
    private JLabel accountNoLabel;
    private JLabel defCheckLabel;


    private XComboEdit bankComboEdit;
    private JTextField nameField;
    private JTextField accountNoField;
    private JCheckBox defCheckBox;

    private boolean isDef;
    private Integer defBankAccountId;
    
    public PartnerBankAccountEdit() throws ApplicationException {
        super(GUIPartnerEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(BankAccount.class);
        this.setEntityServiceClass(BankAccountService.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        bankNameLabel = new JLabel(getString("panel.label-bank.text"));
        nameLabel = new JLabel(getString("panel.label-name.text"));
        accountNoLabel = new JLabel(getString("panel.label-account-no.text"));
        defCheckLabel =  new JLabel(getString("panel.label-default.text"));


        bankComboEdit = new XComboEdit();
        nameField = new JTextField(30);
        accountNoField = new JTextField(30);
        defCheckBox = new JCheckBox();

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(bankNameLabel);
        editPanel.addByY(nameLabel);
        editPanel.addByY(accountNoLabel);
        editPanel.addByY(defCheckLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.add(bankComboEdit);
        gbc.fill = GridBagConstraints.NONE;
        editPanel.addByY(nameField);
        editPanel.addByY(accountNoField);
        editPanel.addByY(defCheckBox);

        add(editPanel);
        bankComboEdit.initListFormAction(this, BankList.class);

    }

    private BankAccount getBankAccount() {
        return (BankAccount) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getBankAccount().getName());
        bankComboEdit.setValue(getBankAccount().getBank());
        nameField.setText(getBankAccount().getName());
        accountNoField.setText(getBankAccount().getAccountNo());
        isDef = this.equalsInteger(defBankAccountId, getBankAccount().getId());
        defCheckBox.setSelected(isDef);
    }


    protected void populateData() throws ApplicationException {
        getBankAccount().setBank((IBankHeader) bankComboEdit.getValue());
        getBankAccount().setName(nameField.getText());
        getBankAccount().setAccountNo(accountNoField.getText());
        
    }
    
    protected Object createData() throws ApplicationException {
        getBankAccount().setPartner(this.getPartner());
        Integer id = (Integer) super.createData();
        changeDef(id);
        return id;
    }

    protected void storeData() throws ApplicationException {
        Integer id = getBankAccount().getId();    	
        changeDef(id);
    }
    
    private void changeDef(Integer id) {
	if (isDef != defCheckBox.isSelected()) {
	    if (defCheckBox.isSelected()) {
		setDefBankAccountId(id);
	    }
	}
    }

    public Integer getDefBankAccountId() {
	return defBankAccountId;
    }

    public void setDefBankAccountId(Integer defBankAccountId) {
	this.defBankAccountId = defBankAccountId;
    }

    private boolean equalsInteger(Integer i1, Integer i2) {
	if (i1 == null || i2 == null) {
	    return false;
	}
	return i1.equals(i2);
    }

}
