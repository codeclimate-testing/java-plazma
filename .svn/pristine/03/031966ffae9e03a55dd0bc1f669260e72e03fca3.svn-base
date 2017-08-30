package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.layout.GridData;
import org.plazmaforge.framework.uwt.widget.Style.HorizontalAlign;
import org.plazmaforge.framework.uwt.widget.NumberField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class TaxEditForm_Gen extends EditForm {


  public TaxEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("TaxEditForm");
    setType("EditForm");
    setTitle(getString("TaxEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(4);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("TaxEditForm.codeLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(100);
    GridData layoutData1 = new GridData(3, 1, GridData.DEFAULT_HORIZONTAL_ALIGN, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    textField1.setLayoutData(layoutData1);
    textField1.setProperty("code");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("TaxEditForm.nameLabel.text"));
    content.add(label2);
    
    TextField textField2 = new TextField();
    GridData layoutData2 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    textField2.setLayoutData(layoutData2);
    textField2.setProperty("name");
    content.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("TaxEditForm.taxPercentLabel.text"));
    content.add(label3);
    
    NumberField numberField1 = new NumberField();
    numberField1.setProperty("taxPercent");
    content.add(numberField1);
    
    Label label4 = new Label();
    label4.setText(getString("TaxEditForm.amountLabel.text"));
    content.add(label4);
    
    NumberField numberField2 = new NumberField();
    numberField2.setProperty("amount");
    content.add(numberField2);
    
    return content;
  
  }

}