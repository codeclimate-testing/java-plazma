package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.ComboBox;
import org.plazmaforge.framework.uwt.widget.DateField;
import org.plazmaforge.framework.uwt.widget.NumberField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class CurrencyRateEditForm_Gen extends EditForm {


  public CurrencyRateEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("CurrencyRateEditForm");
    setType("EditForm");
    setTitle(getString("CurrencyRateEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    layout1.setColumnCount(2);
    content.setLayout(layout1);
    
    Label label1 = new Label();
    label1.setText(getString("CurrencyRateEditForm.baseCurrencyLabel.text"));
    content.add(label1);
    
    ComboBox comboBox1 = new ComboBox();
    comboBox1.setProperty("baseCurrency");
    comboBox1.setDataType("base/Currency");
    content.add(comboBox1);
    
    Label label2 = new Label();
    label2.setText(getString("CurrencyRateEditForm.currencyLabel.text"));
    content.add(label2);
    
    ComboBox comboBox2 = new ComboBox();
    comboBox2.setProperty("currency");
    comboBox2.setDataType("base/Currency");
    content.add(comboBox2);
    
    Label label3 = new Label();
    label3.setText(getString("CurrencyRateEditForm.dateLabel.text"));
    content.add(label3);
    
    DateField dateField1 = new DateField();
    dateField1.setProperty("date");
    content.add(dateField1);
    
    Label label4 = new Label();
    label4.setText(getString("CurrencyRateEditForm.rateLabel.text"));
    content.add(label4);
    
    NumberField numberField1 = new NumberField();
    numberField1.setProperty("rate");
    content.add(numberField1);
    
    return content;
  
  }

}