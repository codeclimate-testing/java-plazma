package org.plazmaforge.bs.organization.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class DepartmentListForm_Gen extends ListForm {


  public DepartmentListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("DepartmentListForm");
    setType("ListForm");
    setTitle(getString("DepartmentListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("DepartmentListForm.codeColumn.text"));
    column1.setWidth(100);
    column1.setProperty("code");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("DepartmentListForm.nameColumn.text"));
    column2.setWidth(300);
    column2.setProperty("name");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    content.add(table1);
    
    return content;
  
  }

}