package org.plazmaforge.bs.document.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.LookupField;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class DocumentStatusEditForm_Gen extends EditForm {


  public DocumentStatusEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("DocumentStatusEditForm");
    setType("EditForm");
    setTitle(getString("DocumentStatusEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("DocumentStatusEditForm.documentLabel.text"));
    content.add(label1);
    
    LookupField lookupField1 = new LookupField();
    lookupField1.setWidth(200);
    lookupField1.setProperty("documentType");
    lookupField1.setDataType("document/DocumentType");
    content.add(lookupField1);
    
    Label label2 = new Label();
    label2.setText(getString("DocumentStatusEditForm.codeLabel.text"));
    content.add(label2);
    
    TextField textField1 = new TextField();
    textField1.setWidth(200);
    textField1.setProperty("code");
    content.add(textField1);
    
    Label label3 = new Label();
    label3.setText(getString("DocumentStatusEditForm.nameLabel.text"));
    content.add(label3);
    
    TextField textField2 = new TextField();
    textField2.setWidth(200);
    textField2.setProperty("name");
    content.add(textField2);
    
    return content;
  
  }

}