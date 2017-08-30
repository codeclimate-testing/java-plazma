package org.plazmaforge.bs.project.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;
import org.plazmaforge.framework.uwt.widget.Style.HorizontalAlign;
import org.plazmaforge.framework.uwt.form.ListForm;

public class ProjectListForm_Gen extends ListForm {


  public ProjectListForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ProjectListForm");
    setType("ListForm");
    setTitle(getString("ProjectListForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    FitLayout layout1 = new FitLayout();
    layout1.setType("FitLayout");
    content.setLayout(layout1);
    
    Table table1 = new Table();
    
    TableColumn column1 = new TableColumn();
    column1.setText(getString("ProjectListForm.projectNoColumn.text"));
    column1.setWidth(100);
    column1.setProperty("projectNo");
    column1.setDataType("String");
    table1.addColumn(column1);
    
    TableColumn column2 = new TableColumn();
    column2.setText(getString("ProjectListForm.nameColumn.text"));
    column2.setWidth(300);
    column2.setProperty("name");
    column2.setDataType("String");
    table1.addColumn(column2);
    
    TableColumn column3 = new TableColumn();
    column3.setText(getString("ProjectListForm.partnerColumn.text"));
    column3.setWidth(200);
    column3.setProperty("partnerName");
    column3.setDataType("String");
    table1.addColumn(column3);
    
    TableColumn column4 = new TableColumn();
    column4.setText(getString("ProjectListForm.projectStatusColumn.text"));
    column4.setWidth(100);
    column4.setProperty("projectStatusName");
    column4.setDataType("String");
    table1.addColumn(column4);
    
    TableColumn column5 = new TableColumn();
    column5.setText(getString("ProjectListForm.startDateColumn.text"));
    column5.setWidth(100);
    column5.setProperty("startDate");
    column5.setDataType("String");
    table1.addColumn(column5);
    
    TableColumn column6 = new TableColumn();
    column6.setText(getString("ProjectListForm.endDateColumn.text"));
    column6.setWidth(100);
    column6.setProperty("endDate");
    column6.setDataType("String");
    table1.addColumn(column6);
    
    TableColumn column7 = new TableColumn();
    column7.setText(getString("ProjectListForm.currencyTotalWithTaxColumn.text"));
    column7.setWidth(120);
    column7.setProperty("currencyTotalWithTax");
    column7.setDataType("Float");
    column7.setAlign(HorizontalAlign.RIGHT);
    table1.addColumn(column7);
    
    TableColumn column8 = new TableColumn();
    column8.setText(getString("ProjectListForm.currencyColumn.text"));
    column8.setWidth(70);
    column8.setProperty("currencyName");
    column8.setDataType("String");
    table1.addColumn(column8);
    
    TableColumn column9 = new TableColumn();
    column9.setText(getString("ProjectListForm.totalWithTaxColumn.text"));
    column9.setWidth(120);
    column9.setProperty("totalWithTax");
    column9.setDataType("Float");
    column9.setAlign(HorizontalAlign.RIGHT);
    table1.addColumn(column9);
    
    TableColumn column10 = new TableColumn();
    column10.setText(getString("ProjectListForm.responsibleColumn.text"));
    column10.setWidth(200);
    column10.setProperty("responsibleName");
    column10.setDataType("String");
    table1.addColumn(column10);
    
    content.add(table1);
    
    return content;
  
  }

}