package org.plazmaforge.bs.partner.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class PartnerTypeListForm_Gen extends ListForm {


  public PartnerTypeListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("PartnerTypeListForm");
    setType("ListForm");
    setTitle(getString("PartnerTypeListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("PartnerTypeListForm.nameColumn.text"));
    column1.setWidth(200);
    column1.setProperty("name");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("PartnerTypeListForm.fullNameColumn.text"));
    column2.setWidth(300);
    column2.setProperty("fullName");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    content.add(table1);
    
    return content;
  
  }

}