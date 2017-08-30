package org.plazmaforge.bs.contact.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.widget.ComboBox;
import org.plazmaforge.framework.uwt.form.EditForm;

public class CityEditForm_Gen extends EditForm {


  public CityEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("CityEditForm");
    setType("EditForm");
    setTitle(getString("CityEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("CityEditForm.nameLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(200);
    textField1.setProperty("name");
    content.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("CityEditForm.regionLabel.text"));
    content.add(label2);
    
    ComboBox comboBox1 = new ComboBox();
    comboBox1.setWidth(200);
    comboBox1.setProperty("region");
    comboBox1.setDataType("contact/Region");
    content.add(comboBox1);
    
    Label label3 = new Label();
    label3.setText(getString("CityEditForm.countryLabel.text"));
    content.add(label3);
    
    ComboBox comboBox2 = new ComboBox();
    comboBox2.setWidth(200);
    comboBox2.setProperty("country");
    comboBox2.setDataType("base/Country");
    content.add(comboBox2);
    
    return content;
  
  }

}