package org.plazmaforge.bs.project.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.widget.LookupField;
import org.plazmaforge.framework.uwt.widget.SpinnerField;
import org.plazmaforge.framework.uwt.widget.TextArea;
import org.plazmaforge.framework.uwt.form.EditForm;

public class ProjectStageEditForm_Gen extends EditForm {


  public ProjectStageEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ProjectStageEditForm");
    setType("EditForm");
    setTitle(getString("ProjectStageEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("ProjectStageEditForm.codeLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(100);
    textField1.setProperty("code");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("ProjectStageEditForm.nameLabel.text"));
    content.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setWidth(200);
    textField2.setProperty("name");
    content.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("ProjectStageEditForm.projectStageGroupLabel.text"));
    content.add(label3);
    
    LookupField lookupField1 = new LookupField();
    lookupField1.setWidth(200);
    lookupField1.setProperty("projectStageGroup");
    lookupField1.setDataType("project/ProjectStageGroup");
    content.add(lookupField1);
    
    Label label4 = new Label();
    label4.setText(getString("ProjectStageEditForm.projectTypeLabel.text"));
    content.add(label4);
    
    LookupField lookupField2 = new LookupField();
    lookupField2.setWidth(200);
    lookupField2.setProperty("projectType");
    lookupField2.setDataType("project/ProjectType");
    content.add(lookupField2);
    
    Label label5 = new Label();
    label5.setText(getString("ProjectStageEditForm.orderNumberLabel.text"));
    content.add(label5);
    
    SpinnerField spinnerField1 = new SpinnerField();
    spinnerField1.setProperty("orderNumber");
    content.add(spinnerField1);
    
    Label label6 = new Label();
    label6.setText(getString("ProjectStageEditForm.fromBeginLabel.text"));
    content.add(label6);
    
    SpinnerField spinnerField2 = new SpinnerField();
    spinnerField2.setProperty("fromBegin");
    content.add(spinnerField2);
    
    Label label7 = new Label();
    label7.setText(getString("ProjectStageEditForm.averangeDurationLabel.text"));
    content.add(label7);
    
    SpinnerField spinnerField3 = new SpinnerField();
    spinnerField3.setProperty("averangeDuration");
    content.add(spinnerField3);
    
    Label label8 = new Label();
    label8.setText(getString("ProjectStageEditForm.descriptionLabel.text"));
    content.add(label8);
    
    TextArea textArea1 = new TextArea();
    textArea1.setWidth(200);
    textArea1.setProperty("description");
    content.add(textArea1);
    
    return content;
  
  }

}