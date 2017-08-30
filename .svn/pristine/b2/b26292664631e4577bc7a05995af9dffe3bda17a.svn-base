package org.plazmaforge.bs.document.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class DocumentTypeListForm_Gen extends ListForm {


  public DocumentTypeListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("DocumentTypeListForm");
    setType("ListForm");
    setTitle(getString("DocumentTypeListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("DocumentTypeListForm.codeColumn.text"));
    column1.setWidth(200);
    column1.setProperty("code");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("DocumentTypeListForm.nameColumn.text"));
    column2.setWidth(300);
    column2.setProperty("name");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("DocumentTypeListForm.documentSectionColumn.text"));
    column3.setWidth(200);
    column3.setProperty("documentSection");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("DocumentTypeListForm.documentCategoryColumn.text"));
    column4.setWidth(200);
    column4.setProperty("documentCategory");
    column4.setDataType("String");
    table1.addColumn(column4);
    
    content.add(table1);
    
    return content;
  
  }

}