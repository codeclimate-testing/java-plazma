package org.plazmaforge.bs.contact.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.widget.ComboBox;
import org.plazmaforge.framework.uwt.form.EditForm;

public class RegionEditForm_Gen extends EditForm {


  public RegionEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("RegionEditForm");
    setType("EditForm");
    setTitle(getString("RegionEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("RegionEditForm.nameLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(200);
    textField1.setProperty("name");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("RegionEditForm.countryLabel.text"));
    content.add(label2);
    
    ComboBox comboBox1 = new ComboBox();
    comboBox1.setWidth(200);
    comboBox1.setProperty("country");
    comboBox1.setDataType("base/Country");
    content.add(comboBox1);
    
    return content;
  
  }

}