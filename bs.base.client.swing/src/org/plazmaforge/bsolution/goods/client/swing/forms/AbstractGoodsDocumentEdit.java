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
 * Created on 10.08.2005
 *
 */
package org.plazmaforge.bsolution.goods.client.swing.forms;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.plazmaforge.bsolution.base.common.services.CurrencyService;
import org.plazmaforge.bsolution.finance.client.swing.forms.AbstractFinanceDocumentParentEdit;
import org.plazmaforge.bsolution.goods.client.swing.GUIGoodsEnvironment;
import org.plazmaforge.bsolution.product.client.swing.forms.ProductDocumentItemEdit;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;



/**
 * @author Oleh Hapon
 * $Id: AbstractGoodsDocumentEdit.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 */
public abstract class AbstractGoodsDocumentEdit extends AbstractFinanceDocumentParentEdit {

    protected JLabel codeLabel;
    protected JLabel dateLabel;
    protected JLabel currencyLabel;
    protected JLabel currencyRateLabel;
    protected JLabel currencyRateDateLabel;

    protected JLabel contractLabel;
    protected JLabel reasonDocumentLabel;
    protected JLabel reasonLabel;

    protected JLabel currencyAmountLabel;
    protected JLabel currencyTaxAmountLabel;
	
    protected JLabel currencyTotalLabel;
    protected JLabel currencyTaxTotalLabel;
    protected JLabel currencyTotalWithTaxLabel;    


    protected XTextField codeField;
    protected XDateField dateField;
    protected XComboBox currencyComboBox;
    protected XNumberField currencyRateField;
    protected XDateField currencyRateDateField;

    protected XComboEdit contractComboEdit;
    protected XComboEdit reasonDocumentComboEdit;
    protected XTextField reasonField;

    protected XCurrencyField currencyAmountField;
    protected XCurrencyField currencyTaxAmountField;
	
    protected XCurrencyField currencyTotalField;
    protected XCurrencyField currencyTaxTotalField;
    protected XCurrencyField currencyTotalWithTaxField;    

    protected XTextEdit noteField;

    protected JTable productItemTable;
    
    
    public AbstractGoodsDocumentEdit() {
        super(GUIGoodsEnvironment.getResources());
    }

    protected EditForm getEditChildForm() throws ApplicationException {
        EditForm form = super.getEditChildForm();
        ((ProductDocumentItemEdit) form).setProductDocument(this.getProductDocument());
        return form;
    }

    protected CurrencyService getCurrencyService() {
        return (CurrencyService) getSERVICE(CurrencyService.class);
    }
    
    protected JPanel createNotePanel() {
        JPanel editPanel =  new JPanel(new BorderLayout());
        noteField = new XTextEdit();
        editPanel.add(noteField, BorderLayout.CENTER);
        return editPanel;
    }
    
}
