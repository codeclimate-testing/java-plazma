package org.plazmaforge.bs.project.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class TaskListForm_Gen extends ListForm {


  public TaskListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("TaskListForm");
    setType("ListForm");
    setTitle(getString("TaskListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("TaskListForm.taskPriorityColumn.text"));
    column1.setWidth(100);
    column1.setProperty("description");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("TaskListForm.taskNoColumn.text"));
    column2.setWidth(100);
    column2.setProperty("description");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("TaskListForm.nameColumn.text"));
    column3.setWidth(300);
    column3.setProperty("name");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("TaskListForm.startDateTimeColumn.text"));
    column4.setWidth(100);
    column4.setProperty("startDateTime");
    column4.setDataType("Date");
    table1.addColumn(column4);
    
    TableColumn column5 = new TableColumn();
    column5.setText(getString("TaskListForm.endDateTimeColumn.text"));
    column5.setWidth(100);
    column5.setProperty("endDateTime");
    column5.setDataType("Date");
    table1.addColumn(column5);
    
    TableColumn column6 = new TableColumn();
    column6.setText(getString("TaskListForm.percentCompleteColumn.text"));
    column6.setWidth(100);
    column6.setProperty("percentComplete");
    column6.setDataType("Float");
    table1.addColumn(column6);
    
    TableColumn column7 = new TableColumn();
    column7.setText(getString("TaskListForm.reporterColumn.text"));
    column7.setWidth(200);
    column7.setProperty("reporterName");
    column7.setDataType("String");
    table1.addColumn(column7);
    
    TableColumn column8 = new TableColumn();
    column8.setText(getString("TaskListForm.responsibleColumn.text"));
    column8.setWidth(200);
    column8.setProperty("responsibleName");
    column8.setDataType("String");
    table1.addColumn(column8);
    
    TableColumn column9 = new TableColumn();
    column9.setText(getString("TaskListForm.partnerColumn.text"));
    column9.setWidth(200);
    column9.setProperty("partnerName");
    column9.setDataType("String");
    table1.addColumn(column9);
    
    content.add(table1);
    
    return content;
  
  }

}