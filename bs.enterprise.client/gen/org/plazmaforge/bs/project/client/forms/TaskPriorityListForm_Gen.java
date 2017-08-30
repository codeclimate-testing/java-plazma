package org.plazmaforge.bs.project.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class TaskPriorityListForm_Gen extends ListForm {


  public TaskPriorityListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("TaskPriorityListForm");
    setType("ListForm");
    setTitle(getString("TaskPriorityListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("TaskPriorityListForm.nameColumn.text"));
    column1.setWidth(200);
    column1.setProperty("name");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("TaskPriorityListForm.codeColumn.text"));
    column2.setWidth(100);
    column2.setProperty("code");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("TaskPriorityListForm.orderNumberColumn.text"));
    column3.setWidth(100);
    column3.setProperty("orderNumber");
    column3.setDataType("Integer");
    table1.addColumn(column3);
    
    content.add(table1);
    
    return content;
  
  }

}