package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.MessageBox;
import org.plazmaforge.framework.uwt.widget.tool.ToolBar;
import org.plazmaforge.framework.uwt.widget.tool.ToolItem;
import org.plazmaforge.framework.uwt.event.SelectionListener;
import org.plazmaforge.framework.uwt.event.SelectionEvent;
import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class CountryListForm_Gen extends ListForm {


  public CountryListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("CountryListForm");
    setType("ListForm");
    setTitle(getString("CountryListForm.title"));
    
    ToolBar toolBar1 = new ToolBar();
    
    ToolItem toolItem1 = new ToolItem();
    toolItem1.addSelectionListener(new SelectionListener() {
      public void select(SelectionEvent event) {
        MessageBox.information("Select button");
      }
    });
    toolItem1.setIcon("widget/refresh.gif");
    toolItem1.setToolTip("Refresh");
    toolBar1.addItem(toolItem1);
    setToolBar(toolBar1);
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("CountryListForm.codeColumn.text"));
    column1.setWidth(100);
    column1.setProperty("code");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("CountryListForm.code3Column.text"));
    column2.setWidth(100);
    column2.setProperty("code3");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("CountryListForm.numericColumn.text"));
    column3.setWidth(100);
    column3.setProperty("numericCode");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("CountryListForm.nameColumn.text"));
    column4.setWidth(300);
    column4.setProperty("name");
    column4.setDataType("String");
    table1.addColumn(column4);
    
    content.add(table1);
    
    return content;
  
  }

}