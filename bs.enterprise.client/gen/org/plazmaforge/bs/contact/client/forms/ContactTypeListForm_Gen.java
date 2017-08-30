package org.plazmaforge.bs.contact.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class ContactTypeListForm_Gen extends ListForm {


  public ContactTypeListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ContactTypeListForm");
    setType("ListForm");
    setTitle(getString("ContactTypeListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("ContactTypeListForm.codeColumn.text"));
    column1.setWidth(200);
    column1.setProperty("code");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("ContactTypeListForm.nameColumn.text"));
    column2.setWidth(200);
    column2.setProperty("name");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    content.add(table1);
    
    return content;
  
  }

}