package org.plazmaforge.bs.partner.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class IndustryListForm_Gen extends ListForm {


  public IndustryListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("IndustryListForm");
    setType("ListForm");
    setTitle(getString("IndustryListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("IndustryListForm.nameColumn.text"));
    column1.setWidth(200);
    column1.setProperty("name");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    content.add(table1);
    
    return content;
  
  }

}