package org.plazmaforge.bs.project.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class TaskResultEditForm_Gen extends EditForm {


  public TaskResultEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("TaskResultEditForm");
    setType("EditForm");
    setTitle(getString("TaskResultEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("TaskResultEditForm.codeLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(100);
    textField1.setProperty("code");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("TaskResultEditForm.nameLabel.text"));
    content.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setWidth(200);
    textField2.setProperty("name");
    content.add(textField2);
    
    return content;
  
  }

}