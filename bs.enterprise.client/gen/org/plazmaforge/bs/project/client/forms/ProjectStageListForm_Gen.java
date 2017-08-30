package org.plazmaforge.bs.project.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class ProjectStageListForm_Gen extends ListForm {


  public ProjectStageListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ProjectStageListForm");
    setType("ListForm");
    setTitle(getString("ProjectStageListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("ProjectStageListForm.nameColumn.text"));
    column1.setWidth(200);
    column1.setProperty("name");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("ProjectStageListForm.orderNumberColumn.text"));
    column2.setWidth(100);
    column2.setProperty("orderNumber");
    column2.setDataType("Integer");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("ProjectStageListForm.fromBeginColumn.text"));
    column3.setWidth(100);
    column3.setProperty("fromBegin");
    column3.setDataType("Integer");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("ProjectStageListForm.averangeDurationColumn.text"));
    column4.setWidth(100);
    column4.setProperty("averangeDuration");
    column4.setDataType("Integer");
    table1.addColumn(column4);
    
    content.add(table1);
    
    return content;
  
  }

}