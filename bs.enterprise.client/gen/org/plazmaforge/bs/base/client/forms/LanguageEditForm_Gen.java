package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class LanguageEditForm_Gen extends EditForm {


  public LanguageEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("LanguageEditForm");
    setType("EditForm");
    setTitle(getString("LanguageEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("LanguageEditForm.codeLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(100);
    textField1.setProperty("code");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("LanguageEditForm.code3Label.text"));
    content.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setWidth(100);
    textField2.setProperty("code3");
    content.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("LanguageEditForm.numericCodeLabel.text"));
    content.add(label3);
    
    TextField textField3 = new TextField();
    textField3.setWidth(100);
    textField3.setProperty("numericCode");
    content.add(textField3);
    
    Label label4 = new Label();
    label4.setText(getString("LanguageEditForm.nameLabel.text"));
    content.add(label4);
    
    TextField textField4 = new TextField();
    textField4.setWidth(200);
    textField4.setProperty("name");
    content.add(textField4);
    
    return content;
  
  }

}