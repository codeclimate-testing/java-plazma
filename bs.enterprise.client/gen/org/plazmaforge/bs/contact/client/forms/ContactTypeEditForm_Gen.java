package org.plazmaforge.bs.contact.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class ContactTypeEditForm_Gen extends EditForm {


  public ContactTypeEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ContactTypeEditForm");
    setType("EditForm");
    setTitle(getString("ContactTypeEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("ContactTypeEditForm.codeLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setProperty("code");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("ContactTypeEditForm.nameLabel.text"));
    content.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setProperty("name");
    content.add(textField2);
    
    return content;
  
  }

}