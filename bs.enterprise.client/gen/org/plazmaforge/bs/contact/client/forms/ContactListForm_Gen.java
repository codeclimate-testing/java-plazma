package org.plazmaforge.bs.contact.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.form.ListForm;

public class ContactListForm_Gen extends ListForm {


  public ContactListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ContactListForm");
    setType("ListForm");
    setTitle(getString("ContactListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("ContactListForm.codeColumn.text"));
    column1.setWidth(50);
    column1.setProperty("code");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("ContactListForm.nameColumn.text"));
    column2.setWidth(300);
    column2.setProperty("name");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("ContactListForm.contactTypeColumn.text"));
    column3.setWidth(200);
    column3.setProperty("contactTypeName");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("ContactListForm.partnerColumn.text"));
    column4.setWidth(100);
    column4.setProperty("partnerName");
    column4.setDataType("String");
    table1.addColumn(column4);
    
    TableColumn column5 = new TableColumn();
    column5.setText(getString("ContactListForm.phoneColumn.text"));
    column5.setWidth(100);
    column5.setProperty("phoneString");
    column5.setDataType("String");
    table1.addColumn(column5);
    
    TableColumn column6 = new TableColumn();
    column6.setText(getString("ContactListForm.cityColumn.text"));
    column6.setWidth(100);
    column6.setProperty("cityName");
    column6.setDataType("String");
    table1.addColumn(column6);
    
    TableColumn column7 = new TableColumn();
    column7.setText(getString("ContactListForm.addressColumn.text"));
    column7.setWidth(100);
    column7.setProperty("localityAddressString");
    column7.setDataType("String");
    table1.addColumn(column7);
    
    TableColumn column8 = new TableColumn();
    column8.setText(getString("ContactListForm.responsibleColumn.text"));
    column8.setWidth(100);
    column8.setProperty("responsibleName");
    column8.setDataType("String");
    table1.addColumn(column8);
    
    content.add(table1);
    
    return content;
  
  }

}