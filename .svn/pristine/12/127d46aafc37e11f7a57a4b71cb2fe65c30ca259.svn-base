package org.plazmaforge.bs.contact.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.panel.TabPanel;
import org.plazmaforge.framework.uwt.layout.GridData;
import org.plazmaforge.framework.uwt.widget.Style.HorizontalAlign;
import org.plazmaforge.framework.uwt.widget.panel.TabItem;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.widget.LookupField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class ContactEditForm_Gen extends EditForm {


  public ContactEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ContactEditForm");
    setType("EditForm");
    setTitle(getString("ContactEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    content.setLayout(layout1);
    
    TabPanel tabPanel1 = new TabPanel();
    GridData layoutData1 = new GridData(HorizontalAlign.FILL);
    tabPanel1.setLayoutData(layoutData1);
    
    
    TabItem tabItem1 = new TabItem();
    tabItem1.setTitle(getString("ContactEditForm.generalTabItem.text"));
    
    GridLayout layout2 = new GridLayout();
    layout2.setColumnCount(4);
    tabItem1.setLayout(layout2);
    
    Label label1 = new Label();
    label1.setText(getString("ContactEditForm.codeLabel.text"));
    tabItem1.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(100);
    textField1.setProperty("code");
    tabItem1.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("ContactEditForm.titleNameLabel.text"));
    tabItem1.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setWidth(200);
    textField2.setProperty("titleName");
    tabItem1.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("ContactEditForm.firstNameLabel.text"));
    tabItem1.add(label3);
    
    TextField textField3 = new TextField();
    GridData layoutData2 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    textField3.setLayoutData(layoutData2);
    textField3.setProperty("firstName");
    tabItem1.add(textField3);
    
    Label label4 = new Label();
    label4.setText(getString("ContactEditForm.lastNameLabel.text"));
    tabItem1.add(label4);
    
    TextField textField4 = new TextField();
    GridData layoutData3 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    textField4.setLayoutData(layoutData3);
    textField4.setProperty("lastName");
    tabItem1.add(textField4);
    
    Label label5 = new Label();
    label5.setText(getString("ContactEditForm.fullNameLabel.text"));
    tabItem1.add(label5);
    
    TextField textField5 = new TextField();
    GridData layoutData4 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    textField5.setLayoutData(layoutData4);
    textField5.setProperty("fullName");
    tabItem1.add(textField5);
    
    Label label6 = new Label();
    label6.setText(getString("ContactEditForm.partnerLabel.text"));
    tabItem1.add(label6);
    
    LookupField lookupField1 = new LookupField();
    GridData layoutData5 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    lookupField1.setLayoutData(layoutData5);
    tabItem1.add(lookupField1);
    
    Label label7 = new Label();
    label7.setText(getString("ContactEditForm.departmentLabel.text"));
    tabItem1.add(label7);
    
    LookupField lookupField2 = new LookupField();
    GridData layoutData6 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    lookupField2.setLayoutData(layoutData6);
    lookupField2.setProperty("department");
    lookupField2.setDataType("organization/Department");
    tabItem1.add(lookupField2);
    
    Label label8 = new Label();
    label8.setText(getString("ContactEditForm.positionLabel.text"));
    tabItem1.add(label8);
    
    LookupField lookupField3 = new LookupField();
    GridData layoutData7 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    lookupField3.setLayoutData(layoutData7);
    lookupField3.setProperty("jobPosition");
    lookupField3.setDataType("contact/JobPosition");
    tabItem1.add(lookupField3);
    tabPanel1.addItem((TabItem) tabItem1);
    content.add(tabPanel1);
    
    return content;
  
  }

}