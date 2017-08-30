package org.plazmaforge.bs.document.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class DocumentStatusListForm_Gen extends ListForm {


  public DocumentStatusListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("DocumentStatusListForm");
    setType("ListForm");
    setTitle(getString("DocumentStatusListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("DocumentStatusListForm.documentColumn.text"));
    column1.setWidth(300);
    column1.setProperty("documentType");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("DocumentStatusListForm.codeColumn.text"));
    column2.setWidth(200);
    column2.setProperty("code");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("DocumentStatusListForm.nameColumn.text"));
    column3.setWidth(200);
    column3.setProperty("name");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    content.add(table1);
    
    return content;
  
  }

}