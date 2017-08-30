package org.plazmaforge.bs.partner.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class PartnerCategoryEditForm_Gen extends EditForm {


  public PartnerCategoryEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("PartnerCategoryEditForm");
    setType("EditForm");
    setTitle(getString("PartnerCategoryEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("PartnerCategoryEditForm.nameLabel.text"));
    content.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setProperty("name");
    content.add(textField1);
    
    return content;
  
  }

}