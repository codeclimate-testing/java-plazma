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
package org.plazmaforge.bsolution.goods.client.swing.forms;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.IEnterValueHolder;
import org.plazmaforge.bsolution.organization.client.swing.forms.DepartmentList;
import org.plazmaforge.bsolution.organization.client.swing.forms.ResponsibleList;
import org.plazmaforge.bsolution.organization.common.beans.Department;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.product.common.beans.PriceType;
import org.plazmaforge.bsolution.sale.common.beans.SalePlan;
import org.plazmaforge.bsolution.sale.common.beans.SalePlanItem;
import org.plazmaforge.bsolution.sale.common.services.SalePlanService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.AbstractChildType;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.GUIEnvironment;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.client.swing.gui.table.AbstractStateTableModel;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/*
 * Created 24.07.2006
 */
public class SalePlanEdit extends AbstractGoodsDocumentEdit implements IEnterValueHolder {

    private JLabel departmentLabel;                 // Department	
    private JLabel priceTypeLabel;                  // PriceType
    private JLabel responsibleLabel;                // Responsible

    private XComboEdit departmentComboEdit;         // Department
    private XComboEdit priceTypeComboEdit;          // PriceType
    private XComboEdit responsibleComboEdit;        // Responsible


    public SalePlanEdit() {
        super();
        initialize();
    }

    private void initialize() {
        this.setEntityClass(SalePlan.class);
        this.setEntityServiceClass(SalePlanService.class);
        this.setEntityCode(SalePlan.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));
        getParentPane().setLayout(new BorderLayout());
        setParentTabbedPane(createMasterTabbedPane());
        setChildrenTabbedPane(createItemsTabbedPane());
        addParentTabbedPane();
        addChildrenTabbedPane();
    }

    private JTabbedPane createMasterTabbedPane() throws ApplicationException {
        JTabbedPane tp = new JTabbedPane();
        tp.addTab(getString("panel.title.common.text"), createCommonPanel());
        tp.addTab(getString("panel.title.note.text"), createNotePanel());
        return tp;
    }

    private JPanel createCommonPanel() throws ApplicationException {

        GridBagPanel editPanel = new GridBagPanel();

        codeLabel = new JLabel(getString("panel.label-code.text"));
        dateLabel = new JLabel(getString("panel.label-date.text"));

        departmentLabel = new JLabel(getString("panel.label-department.text"));		
        priceTypeLabel = new JLabel(getString("panel.label-price-type.text"));
        responsibleLabel = new JLabel(getString("panel.label-responsible.text"));

		
        currencyLabel = new JLabel(getString("panel.label-currency.text"));
        currencyRateLabel = new JLabel(getString("panel.label-currency-rate.text"));
        currencyRateDateLabel = new JLabel(getString("panel.label-currency-rate-date.text"));
		
        currencyTotalLabel = new JLabel(getString("panel.label-currency-total.text"));
        currencyTaxTotalLabel = new JLabel(getString("panel.label-currency-tax-total.text"));
        currencyTotalWithTaxLabel = new JLabel(getString("panel.label-currency-total-with-tax.text"));        

        codeField = new XTextField(10);
        codeField.setMaxChar(10);
        dateField = new XDateField();

        departmentComboEdit = new XComboEdit();
        departmentComboEdit.setColumns(30);
        priceTypeComboEdit = new XComboEdit();
        priceTypeComboEdit.setColumns(30);
        responsibleComboEdit = new XComboEdit(true);
        responsibleComboEdit.setColumns(30);
		
        currencyComboBox = new XComboBox(getCurrencyService().findAll());
        currencyRateField = new XNumberField();
        currencyRateDateField = new XDateField();
		
        currencyTotalField = new XCurrencyField();
        currencyTotalField.setEditable(false);
        currencyTaxTotalField = new XCurrencyField();
        currencyTaxTotalField.setEditable(false);
        currencyTotalWithTaxField = new XCurrencyField();
        currencyTotalWithTaxField.setEditable(false);        

        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.add(codeLabel);
        editPanel.addByX(codeField);
        editPanel.addByX(dateLabel);
        editPanel.addByX(dateField);

        gbc.gridx = 0;
        editPanel.addByY(priceTypeLabel);
        gbc.gridwidth = 5;

        editPanel.addByX(priceTypeComboEdit);

        gbc.gridx = 0;
        gbc.gridwidth = 1;
        editPanel.addByY(responsibleLabel);
        gbc.gridwidth = 5;
        editPanel.addByX(responsibleComboEdit);

        gbc.gridx = 0;
        gbc.gridwidth = 1;
        editPanel.addByY(departmentLabel);
        gbc.gridwidth = 5;
        editPanel.addByX(departmentComboEdit);


        gbc.gridx = 0;
        gbc.gridwidth = 1;
        editPanel.addByY(currencyLabel);
        editPanel.addByX(currencyComboBox);
        editPanel.addByX(currencyRateLabel);
        editPanel.addByX(currencyRateField);
        editPanel.addByX(currencyRateDateLabel);
        editPanel.addByX(currencyRateDateField);

        gbc.gridx = 0;
        gbc.gridwidth = 1;
        editPanel.addByY(currencyTotalLabel);
        editPanel.addByX(currencyTotalField);
        editPanel.addByX(currencyTaxTotalLabel);
        editPanel.addByX(currencyTaxTotalField);
        editPanel.addByX(currencyTotalWithTaxLabel);
        editPanel.addByX(currencyTotalWithTaxField);
        

        departmentComboEdit.initListFormAction(this, DepartmentList.class);		
        //priceTypeComboEdit.initListFormAction(this, PriceTypeList.class);
        responsibleComboEdit.initListFormAction(this, ResponsibleList.class, "employeeName");


        return editPanel;
    }



    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
        JTabbedPane tp = createTabbedPane(650, 200);
        tp.addTab(getString("table-product-item.name"), createItemPanel());
        return tp;
    }


    private JComponent createItemPanel() throws ApplicationException {
        productItemTable = createChildTable(createItemTableModel());
        productItemTable.getColumn(getString("table-product-item.column-currency-price.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
        productItemTable.getColumn(getString("table-product-item.column-currency-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
        productItemTable.getColumn(getString("table-product-item.column-currency-tax-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
        JScrollPane scroll  = new JScrollPane(productItemTable);
        this.registerEntityType(scroll, new ProductItemType());
        return scroll;
    }

    protected TableModel createItemTableModel() throws ApplicationException {
        java.util.List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table-product-item.column-product-name.name"));
        d.setFieldName("productName");
        d.setColumnClass(String.class);
        d.setSize(45);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table-product-item.column-unit.name"));
        d.setFieldName("unitName");
        d.setColumnClass(String.class);
        d.setSize(10);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table-product-item.column-unit-rate.name"));
        d.setFieldName("unitRate");
        d.setColumnClass(Double.class);
        d.setSize(10);
        columns.add(d);


        d = new ColumnProperty();
        d.setName(getString("table-product-item.column-quantity.name"));
        d.setFieldName("quantity");
        d.setColumnClass(Float.class);
        d.setSize(15);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table-product-item.column-currency-price.name"));
        d.setFieldName("enterCurrencyPrice");
        d.setColumnClass(Float.class);
        d.setSize(15);
        columns.add(d);


        d = new ColumnProperty();
        d.setName(getString("table-product-item.column-currency-amount.name"));
        d.setFieldName("enterCurrencyAmount");
        d.setColumnClass(Double.class);
        d.setSize(20);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table-product-item.column-currency-tax-amount.name"));
        d.setFieldName("currencyTaxAmount");
        d.setColumnClass(Float.class);
        d.setSize(15);
        columns.add(d);

        return createObjectTableModel(SalePlanItem.class, columns);
    }



    private SalePlan getSalePlan() {
        return (SalePlan) this.getEntity();
    }


    protected void updateView() throws ApplicationException {
        //appendTitle(getSalePlan().getStorableName());
        codeField.setText(getSalePlan().getDocumentNo());
        dateField.setDate(getSalePlan().getDocumentDate());
		
        departmentComboEdit.setValue(getSalePlan().getDepartment());
        priceTypeComboEdit.setValue(getSalePlan().getPriceType());
//        responsibleComboEdit.setValue(getSalePlan().getMtrlResponsible());
		
        currencyComboBox.setValue(getSalePlan().getCurrency());
        currencyRateField.setValue(getSalePlan().getCurrencyRate());
        currencyRateDateField.setDate(getSalePlan().getCurrencyRateDate());

        currencyTotalField.setValue(getSalePlan().getCurrencyTotal());
        currencyTaxTotalField.setValue(getSalePlan().getCurrencyTaxTotal());
        currencyTotalWithTaxField.setValue(getSalePlan().getCurrencyTotalWithTax());        

        noteField.setText(getSalePlan().getNote());
        AbstractStateTableModel productItemModel = (AbstractStateTableModel) productItemTable.getModel();
        productItemModel.addData(getSalePlan().getProductItems());
    }

    private void updateAmount() {
        getSalePlan().calculateGeneral();
        currencyTotalField.setValue(getSalePlan().getCurrencyTotal());
        currencyTaxTotalField.setValue(getSalePlan().getCurrencyTaxTotal());
        currencyTotalWithTaxField.setValue(getSalePlan().getCurrencyTotalWithTax());        
    }

    protected void afterRefreshChildData() throws ApplicationException {
        updateAmount();
    }


    protected void populateData() throws ApplicationException {
        getSalePlan().setDocumentNo(codeField.getText());
        getSalePlan().setDocumentDate(dateField.getDate());

        getSalePlan().setDepartment((Department) departmentComboEdit.getValue());		
        getSalePlan().setPriceType((PriceType) priceTypeComboEdit.getValue());
//        getSalePlan().setMtrlResponsible((MtrlResponsible) responsibleComboEdit.getValue());

		
        getSalePlan().setCurrency((org.plazmaforge.bsolution.base.common.beans.Currency) currencyComboBox.getValue());
        getSalePlan().setCurrencyRate(currencyRateField.doubleValue());
        getSalePlan().setCurrencyRateDate(currencyRateDateField.getDate());

        getSalePlan().setCurrencyTotal(currencyTotalField.doubleValue());
        getSalePlan().setCurrencyTaxTotal(currencyTaxTotalField.doubleValue());
        getSalePlan().setCurrencyTotalWithTax(currencyTotalWithTaxField.doubleValue());        

        getSalePlan().setNote(noteField.getText());
        getSalePlan().calculateGeneral();
    }





    protected class ProductItemType extends AbstractChildType {
        public JTable getTable() {
            return productItemTable;
        }
        public EditForm getEditForm() throws ApplicationException {
            return getEDIT(SalePlanItemEdit.class);
        }
    }




    protected void validateData() throws ApplicationException {
        super.validateData();
        StringBuffer buf = new StringBuffer();
        validateRequiredField(buf, getSalePlan().getDocumentDate(), dateLabel.getText());
        checkError(buf);
    }

    protected void initData() throws ApplicationException {
        super.initData();
//        getSalePlan().setMtrlResponsible(EnterpriseEnvironment.getMtrlResponsible());
    }  
}
