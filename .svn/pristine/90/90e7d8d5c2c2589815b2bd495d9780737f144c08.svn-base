package org.plazmaforge.bs.project.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.widget.TextArea;
import org.plazmaforge.framework.uwt.widget.CheckBox;
import org.plazmaforge.framework.uwt.form.EditForm;

public class ProjectStatusEditForm_Gen extends EditForm {


  public ProjectStatusEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ProjectStatusEditForm");
    setType("EditForm");
    setTitle(getString("ProjectStatusEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("ProjectStatusEditForm.codeLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(100);
    textField1.setProperty("code");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("ProjectStatusEditForm.nameLabel.text"));
    content.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setWidth(200);
    textField2.setProperty("name");
    content.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("ProjectStatusEditForm.descriptionLabel.text"));
    content.add(label3);
    
    TextArea textArea1 = new TextArea();
    textArea1.setWidth(200);
    textArea1.setProperty("description");
    content.add(textArea1);
    
    Label label4 = new Label();
    label4.setText(getString("ProjectStatusEditForm.startStatusLabel.text"));
    content.add(label4);
    
    CheckBox checkBox1 = new CheckBox();
    checkBox1.setProperty("start");
    content.add(checkBox1);
    
    Label label5 = new Label();
    label5.setText(getString("ProjectStatusEditForm.finishStatusLabel.text"));
    content.add(label5);
    
    CheckBox checkBox2 = new CheckBox();
    checkBox2.setProperty("finish");
    content.add(checkBox2);
    
    return content;
  
  }

}