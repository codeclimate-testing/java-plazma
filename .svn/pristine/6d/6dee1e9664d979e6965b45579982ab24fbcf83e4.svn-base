package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class CurrencyListForm_Gen extends ListForm {


  public CurrencyListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("CurrencyListForm");
    setType("ListForm");
    setTitle(getString("CurrencyListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("CurrencyListForm.codeColumn.text"));
    column1.setWidth(100);
    column1.setProperty("code");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("CurrencyListForm.nameColumn.text"));
    column2.setWidth(200);
    column2.setProperty("name");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("CurrencyListForm.numericCodeColumn.text"));
    column3.setWidth(100);
    column3.setProperty("numericCode");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("CurrencyListForm.fullNameColumn.text"));
    column4.setWidth(200);
    column4.setProperty("fullName");
    column4.setDataType("String");
    table1.addColumn(column4);
    
    content.add(table1);
    
    return content;
  
  }

}