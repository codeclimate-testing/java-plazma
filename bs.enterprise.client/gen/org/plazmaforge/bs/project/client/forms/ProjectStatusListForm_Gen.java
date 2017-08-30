package org.plazmaforge.bs.project.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class ProjectStatusListForm_Gen extends ListForm {


  public ProjectStatusListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ProjectStatusListForm");
    setType("ListForm");
    setTitle(getString("ProjectStatusListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("ProjectStatusListForm.nameColumn.text"));
    column1.setWidth(200);
    column1.setProperty("name");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("ProjectStatusListForm.descriptionColumn.text"));
    column2.setWidth(200);
    column2.setProperty("description");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("ProjectStatusListForm.codeColumn.text"));
    column3.setWidth(100);
    column3.setProperty("code");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("ProjectStatusListForm.startColumn.text"));
    column4.setWidth(100);
    column4.setProperty("start");
    column4.setDataType("Boolean");
    table1.addColumn(column4);
    
    TableColumn column5 = new TableColumn();
    column5.setText(getString("ProjectStatusListForm.finishColumn.text"));
    column5.setWidth(100);
    column5.setProperty("finish");
    column5.setDataType("Boolean");
    table1.addColumn(column5);
    
    content.add(table1);
    
    return content;
  
  }

}