package org.plazmaforge.bs.document.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.panel.TabPanel;
import org.plazmaforge.framework.uwt.layout.GridData;
import org.plazmaforge.framework.uwt.widget.Style.HorizontalAlign;
import org.plazmaforge.framework.uwt.widget.panel.TabItem;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.widget.CheckBox;
import org.plazmaforge.framework.uwt.widget.IntegerField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class DocumentTypeEditForm_Gen extends EditForm {


  public DocumentTypeEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("DocumentTypeEditForm");
    setType("EditForm");
    setTitle(getString("DocumentTypeEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    TabPanel tabPanel1 = new TabPanel();
    GridData layoutData1 = new GridData(HorizontalAlign.FILL);
    tabPanel1.setLayoutData(layoutData1);
    
    
    TabItem tabItem1 = new TabItem();
    tabItem1.setTitle(getString("DocumentTypeEditForm.generalTabItem.text"));
    
    GridLayout layout2 = new GridLayout();
    layout2.setColumnCount(2);
    tabItem1.setLayout(layout2);
    
    Label label1 = new Label();
    label1.setText(getString("DocumentTypeEditForm.entityLabel.text"));
    tabItem1.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setProperty("name");
    tabItem1.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("DocumentTypeEditForm.sectionLabel.text"));
    tabItem1.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setProperty("documentSection");
    tabItem1.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("DocumentTypeEditForm.categoryLabel.text"));
    tabItem1.add(label3);
    
    TextField textField3 = new TextField();
    textField3.setProperty("documentCategory");
    tabItem1.add(textField3);
    
    Label label4 = new Label();
    label4.setText(getString("DocumentTypeEditForm.useNumeratorLabel.text"));
    tabItem1.add(label4);
    
    CheckBox checkBox1 = new CheckBox();
    checkBox1.setProperty("useNumerator");
    tabItem1.add(checkBox1);
    
    Label label5 = new Label();
    label5.setText(getString("DocumentTypeEditForm.documentNoPrefixLabel.text"));
    tabItem1.add(label5);
    
    TextField textField4 = new TextField();
    textField4.setProperty("documentNoPrefix");
    tabItem1.add(textField4);
    
    Label label6 = new Label();
    label6.setText(getString("DocumentTypeEditForm.documentNoSuffixLabel.text"));
    tabItem1.add(label6);
    
    TextField textField5 = new TextField();
    textField5.setProperty("documentNoSuffix");
    tabItem1.add(textField5);
    
    Label label7 = new Label();
    label7.setText(getString("DocumentTypeEditForm.lastDocumentNumberLabel.text"));
    tabItem1.add(label7);
    
    IntegerField integerField1 = new IntegerField();
    integerField1.setProperty("lastDocumentNumber");
    tabItem1.add(integerField1);
    
    Label label8 = new Label();
    label8.setText(getString("DocumentTypeEditForm.documentNoReadOnlyLabel.text"));
    tabItem1.add(label8);
    
    CheckBox checkBox2 = new CheckBox();
    checkBox2.setProperty("documentNoReadOnly");
    tabItem1.add(checkBox2);
    
    Label label9 = new Label();
    label9.setText(getString("DocumentTypeEditForm.documentDateReadOnlyLabel.text"));
    tabItem1.add(label9);
    
    CheckBox checkBox3 = new CheckBox();
    checkBox3.setProperty("documentDateReadOnly");
    tabItem1.add(checkBox3);
    tabPanel1.addItem((TabItem) tabItem1);
    
    TabItem tabItem2 = new TabItem();
    tabItem2.setTitle(getString("DocumentTypeEditForm.statusTabItem.text"));
    
    tabPanel1.addItem((TabItem) tabItem2);
    
    TabItem tabItem3 = new TabItem();
    tabItem3.setTitle(getString("DocumentTypeEditForm.dependencyTabItem.text"));
    
    tabPanel1.addItem((TabItem) tabItem3);
    content.add(tabPanel1);
    
    return content;
  
  }

}