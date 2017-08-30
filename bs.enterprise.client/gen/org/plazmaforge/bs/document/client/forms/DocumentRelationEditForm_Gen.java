package org.plazmaforge.bs.document.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.LookupField;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class DocumentRelationEditForm_Gen extends EditForm {


  public DocumentRelationEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("DocumentRelationEditForm");
    setType("EditForm");
    setTitle(getString("DocumentRelationEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("DocumentRelationEditForm.parentTypeLabel.text"));
    content.add(label1);
    
    LookupField lookupField1 = new LookupField();
    lookupField1.setWidth(200);
    lookupField1.setProperty("parentType");
    lookupField1.setDataType("document/DocumentType");
    content.add(lookupField1);
    
    Label label2 = new Label();
    label2.setText(getString("DocumentRelationEditForm.childTypeLabel.text"));
    content.add(label2);
    
    LookupField lookupField2 = new LookupField();
    lookupField2.setWidth(200);
    lookupField2.setProperty("childType");
    lookupField2.setDataType("document/DocumentType");
    content.add(lookupField2);
    
    Label label3 = new Label();
    label3.setText(getString("DocumentRelationEditForm.creatorClassLabel.text"));
    content.add(label3);
    
    TextField textField1 = new TextField();
    textField1.setWidth(200);
    textField1.setProperty("creatorClass");
    content.add(textField1);
    
    return content;
  
  }

}