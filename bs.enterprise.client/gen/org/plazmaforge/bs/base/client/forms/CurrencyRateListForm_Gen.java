package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class CurrencyRateListForm_Gen extends ListForm {


  public CurrencyRateListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("CurrencyRateListForm");
    setType("ListForm");
    setTitle(getString("CurrencyRateListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("CurrencyRateListForm.baseCurrencyCodeColumn.text"));
    column1.setWidth(100);
    column1.setProperty("baseCurrencyCode");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("CurrencyRateListForm.currencyCodeColumn.text"));
    column2.setWidth(100);
    column2.setProperty("currencyCode");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("CurrencyRateListForm.dateColumn.text"));
    column3.setWidth(200);
    column3.setProperty("date");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("CurrencyRateListForm.rateColumn.text"));
    column4.setWidth(200);
    column4.setProperty("rate");
    column4.setDataType("String");
    table1.addColumn(column4);
    
    content.add(table1);
    
    return content;
  
  }

}