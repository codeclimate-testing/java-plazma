package org.plazmaforge.bs.contact.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.ComboBox;
import org.plazmaforge.framework.uwt.layout.GridData;
import org.plazmaforge.framework.uwt.widget.Style.HorizontalAlign;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class LocalityEditForm_Gen extends EditForm {


  public LocalityEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("LocalityEditForm");
    setType("EditForm");
    setTitle(getString("LocalityEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(3);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("LocalityEditForm.countryLabel.text"));
    content.add(label1);
    
    ComboBox comboBox1 = new ComboBox();
    GridData layoutData1 = new GridData(2, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    comboBox1.setLayoutData(layoutData1);
    comboBox1.setProperty("country");
    comboBox1.setDataType("base/Country");
    content.add(comboBox1);
    
    Label label2 = new Label();
    label2.setText(getString("LocalityEditForm.regionLabel.text"));
    content.add(label2);
    
    ComboBox comboBox2 = new ComboBox();
    GridData layoutData2 = new GridData(2, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    comboBox2.setLayoutData(layoutData2);
    comboBox2.setProperty("region");
    comboBox2.setDataType("contact/Region");
    content.add(comboBox2);
    
    Label label3 = new Label();
    label3.setText(getString("LocalityEditForm.nameLabel.text"));
    content.add(label3);
    
    ComboBox comboBox3 = new ComboBox();
    comboBox3.setWidth(50);
    comboBox3.setProperty("localityType");
    comboBox3.setDataType("contact/LocalityType");
    content.add(comboBox3);
    
    TextField textField1 = new TextField();
    GridData layoutData3 = new GridData(HorizontalAlign.FILL);
    textField1.setLayoutData(layoutData3);
    textField1.setProperty("name");
    content.add(textField1);
    
    return content;
  
  }

}