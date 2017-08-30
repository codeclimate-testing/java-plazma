package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class CurrencyEditForm_Gen extends EditForm {


  public CurrencyEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("CurrencyEditForm");
    setType("EditForm");
    setTitle(getString("CurrencyEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("CurrencyEditForm.codeLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setProperty("code");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("CurrencyEditForm.numericCodeLabel.text"));
    content.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setProperty("numericCode");
    content.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("CurrencyEditForm.nameLabel.text"));
    content.add(label3);
    
    TextField textField3 = new TextField();
    textField3.setProperty("name");
    content.add(textField3);
    
    Label label4 = new Label();
    label4.setText(getString("CurrencyEditForm.fullNameLabel.text"));
    content.add(label4);
    
    TextField textField4 = new TextField();
    textField4.setWidth(200);
    textField4.setProperty("fullName");
    content.add(textField4);
    
    return content;
  
  }

}