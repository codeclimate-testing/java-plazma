package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.DateField;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.layout.GridData;
import org.plazmaforge.framework.uwt.widget.Style.HorizontalAlign;
import org.plazmaforge.framework.uwt.form.EditForm;

public class PeriodEditForm_Gen extends EditForm {


  public PeriodEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("PeriodEditForm");
    setType("EditForm");
    setTitle(getString("PeriodEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(4);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("PeriodEditForm.startDateLabel.text"));
    content.add(label1);
    
    DateField dateField1 = new DateField();
    dateField1.setProperty("startDate");
    content.add(dateField1);
    
    Label label2 = new Label();
    label2.setText(getString("PeriodEditForm.endDateLabel.text"));
    content.add(label2);
    
    DateField dateField2 = new DateField();
    dateField2.setProperty("endDate");
    content.add(dateField2);
    
    Label label3 = new Label();
    label3.setText(getString("PeriodEditForm.nameLabel.text"));
    content.add(label3);
    
    TextField textField1 = new TextField();
    textField1.setWidth(200);
    GridData layoutData1 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    textField1.setLayoutData(layoutData1);
    textField1.setProperty("name");
    content.add(textField1);
    
    return content;
  
  }

}