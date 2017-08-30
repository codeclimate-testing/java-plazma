package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class UnitEditForm_Gen extends EditForm {


  public UnitEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("UnitEditForm");
    setType("EditForm");
    setTitle(getString("UnitEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("UnitEditForm.codeLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(100);
    textField1.setProperty("code");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("UnitEditForm.nameLabel.text"));
    content.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setWidth(100);
    textField2.setProperty("name");
    content.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("UnitEditForm.fullNameLabel.text"));
    content.add(label3);
    
    TextField textField3 = new TextField();
    textField3.setWidth(200);
    textField3.setProperty("fullName");
    content.add(textField3);
    
    return content;
  
  }

}