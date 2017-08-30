package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class PeriodListForm_Gen extends ListForm {


  public PeriodListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("PeriodListForm");
    setType("ListForm");
    setTitle(getString("PeriodListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("PeriodListForm.startDateColumn.text"));
    column1.setWidth(100);
    column1.setProperty("startDate");
    column1.setDataType("Date");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("PeriodListForm.endDateColumn.text"));
    column2.setWidth(100);
    column2.setProperty("endDate");
    column2.setDataType("Date");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("PeriodListForm.nameColumn.text"));
    column3.setWidth(200);
    column3.setProperty("name");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    content.add(table1);
    
    return content;
  
  }

}