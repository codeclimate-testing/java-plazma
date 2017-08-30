package org.plazmaforge.bs.partner.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class FormPropertyEditForm_Gen extends EditForm {


  public FormPropertyEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("FormPropertyEditForm");
    setType("EditForm");
    setTitle(getString("FormPropertyEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("FormPropertyEditForm.nameLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setProperty("name");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("FormPropertyEditForm.fullNameLabel.text"));
    content.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setProperty("fullName");
    content.add(textField2);
    
    return content;
  
  }

}