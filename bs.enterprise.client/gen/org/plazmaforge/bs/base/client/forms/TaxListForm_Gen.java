package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.widget.Style.HorizontalAlign;
import org.plazmaforge.framework.uwt.form.ListForm;

public class TaxListForm_Gen extends ListForm {


  public TaxListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("TaxListForm");
    setType("ListForm");
    setTitle(getString("TaxListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("TaxListForm.codeColumn.text"));
    column1.setWidth(200);
    column1.setProperty("code");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("TaxListForm.nameColumn.text"));
    column2.setWidth(200);
    column2.setProperty("name");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("TaxListForm.taxPercentColumn.text"));
    column3.setProperty("taxPercent");
    column3.setDataType("Float");
    column3.setFormat("#0.00");
    column3.setAlign(HorizontalAlign.RIGHT);
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("TaxListForm.amountColumn.text"));
    column4.setProperty("amount");
    column4.setDataType("Float");
    column4.setFormat("#0.00");
    column4.setAlign(HorizontalAlign.RIGHT);
    table1.addColumn(column4);
    
    content.add(table1);
    
    return content;
  
  }

}