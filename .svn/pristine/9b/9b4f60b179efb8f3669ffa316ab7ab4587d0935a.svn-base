package org.plazmaforge.bs.document.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class DocumentRelationListForm_Gen extends ListForm {


  public DocumentRelationListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("DocumentRelationListForm");
    setType("ListForm");
    setTitle(getString("DocumentRelationListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("DocumentRelationListForm.parentTypeCodeColumn.text"));
    column1.setWidth(200);
    column1.setProperty("parentTypeCode");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("DocumentRelationListForm.parentTypeNameColumn.text"));
    column2.setWidth(300);
    column2.setProperty("parentTypeName");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("DocumentRelationListForm.childTypeCodeColumn.text"));
    column3.setWidth(200);
    column3.setProperty("childTypeCode");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("DocumentRelationListForm.childTypeNameColumn.text"));
    column4.setWidth(300);
    column4.setProperty("childTypeName");
    column4.setDataType("String");
    table1.addColumn(column4);
    
    content.add(table1);
    
    return content;
  
  }

}