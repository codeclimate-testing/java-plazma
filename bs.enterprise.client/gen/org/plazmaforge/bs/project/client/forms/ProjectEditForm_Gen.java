package org.plazmaforge.bs.project.client.forms;

import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.panel.TabPanel;
import org.plazmaforge.framework.uwt.layout.GridData;
import org.plazmaforge.framework.uwt.widget.Style.HorizontalAlign;
import org.plazmaforge.framework.uwt.widget.panel.TabItem;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.widget.ComboBox;
import org.plazmaforge.framework.uwt.widget.LookupField;
import org.plazmaforge.framework.uwt.widget.DateField;
import org.plazmaforge.framework.uwt.widget.PercentField;
import org.plazmaforge.framework.uwt.widget.CurrencyField;
import org.plazmaforge.framework.uwt.widget.TextArea;
import org.plazmaforge.framework.uwt.widget.Style.VerticalAlign;
import org.plazmaforge.framework.uwt.form.EditForm;

public class ProjectEditForm_Gen extends EditForm {


  public ProjectEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("ProjectEditForm");
    setType("EditForm");
    setTitle(getString("ProjectEditForm.title"));
  
  }
  
  @Override
  public Composite createContent() {
    
    Composite content = super.createContent();
    GridLayout layout1 = new GridLayout();
    content.setLayout(layout1);
    
    TabPanel tabPanel1 = new TabPanel();
    GridData layoutData1 = new GridData(HorizontalAlign.FILL);
    tabPanel1.setLayoutData(layoutData1);
    
    
    TabItem tabItem1 = new TabItem();
    tabItem1.setTitle(getString("ProjectEditForm.generalTabItem.text"));
    
    GridLayout layout2 = new GridLayout();
    layout2.setColumnCount(4);
    tabItem1.setLayout(layout2);
    
    Label label1 = new Label();
    label1.setText(getString("ProjectEditForm.nameLabel.text"));
    tabItem1.add(label1);
    
    TextField textField1 = new TextField();
    GridData layoutData2 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    textField1.setLayoutData(layoutData2);
    textField1.setProperty("name");
    tabItem1.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("ProjectEditForm.projectNoLabel.text"));
    tabItem1.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setWidth(200);
    textField2.setProperty("projectNo");
    tabItem1.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("ProjectEditForm.projectTypeLabel.text"));
    tabItem1.add(label3);
    
    ComboBox comboBox1 = new ComboBox();
    comboBox1.setWidth(200);
    comboBox1.setProperty("projectType");
    comboBox1.setDataType("project/ProjectType");
    tabItem1.add(comboBox1);
    
    Label label4 = new Label();
    label4.setText(getString("ProjectEditForm.contractNoLabel.text"));
    tabItem1.add(label4);
    
    LookupField lookupField1 = new LookupField();
    lookupField1.setWidth(200);
    lookupField1.setProperty("contractDocument");
    lookupField1.setDataType("document/DocumentHeader");
    lookupField1.setDisplayProperty("title");
    tabItem1.add(lookupField1);
    
    Label label5 = new Label();
    label5.setText(getString("ProjectEditForm.responsibleLabel.text"));
    tabItem1.add(label5);
    
    LookupField lookupField2 = new LookupField();
    lookupField2.setWidth(200);
    lookupField2.setProperty("responsible");
    lookupField2.setDataType("contact/ContactTitle");
    tabItem1.add(lookupField2);
    
    Label label6 = new Label();
    label6.setText(getString("ProjectEditForm.partnerLabel.text"));
    tabItem1.add(label6);
    
    LookupField lookupField3 = new LookupField();
    lookupField3.setWidth(200);
    lookupField3.setProperty("partner");
    lookupField3.setDataType("partner/PartnerTitle");
    tabItem1.add(lookupField3);
    
    Label label7 = new Label();
    label7.setText(getString("ProjectEditForm.projectStatusLabel.text"));
    tabItem1.add(label7);
    
    LookupField lookupField4 = new LookupField();
    lookupField4.setWidth(200);
    lookupField4.setProperty("projectStatus");
    lookupField4.setDataType("project/ProjectStatus");
    tabItem1.add(lookupField4);
    
    Label label8 = new Label();
    label8.setText(getString("ProjectEditForm.startDateLabel.text"));
    tabItem1.add(label8);
    
    DateField dateField1 = new DateField();
    dateField1.setProperty("startDate");
    tabItem1.add(dateField1);
    
    Label label9 = new Label();
    label9.setText(getString("ProjectEditForm.propabilityLabel.text"));
    tabItem1.add(label9);
    
    PercentField percentField1 = new PercentField();
    percentField1.setProperty("propability");
    tabItem1.add(percentField1);
    
    Label label10 = new Label();
    label10.setText(getString("ProjectEditForm.endDateLabel.text"));
    tabItem1.add(label10);
    
    DateField dateField2 = new DateField();
    dateField2.setProperty("endDate");
    tabItem1.add(dateField2);
    
    Label label11 = new Label();
    label11.setText(getString("ProjectEditForm.actualEndDateLabel.text"));
    tabItem1.add(label11);
    
    DateField dateField3 = new DateField();
    dateField3.setProperty("actualDate");
    tabItem1.add(dateField3);
    tabPanel1.addItem((TabItem) tabItem1);
    
    TabItem tabItem2 = new TabItem();
    tabItem2.setTitle(getString("ProjectEditForm.financeTabItem.text"));
    
    GridLayout layout3 = new GridLayout();
    layout3.setColumnCount(6);
    tabItem2.setLayout(layout3);
    
    Label label12 = new Label();
    label12.setText(getString("ProjectEditForm.currencyLabel.text"));
    tabItem2.add(label12);
    
    LookupField lookupField5 = new LookupField();
    lookupField5.setProperty("currency");
    lookupField5.setDataType("base/Currency");
    tabItem2.add(lookupField5);
    
    Label label13 = new Label();
    label13.setText(getString("ProjectEditForm.currencyRateLabel.text"));
    tabItem2.add(label13);
    
    CurrencyField currencyField1 = new CurrencyField();
    currencyField1.setProperty("currencyRate");
    tabItem2.add(currencyField1);
    
    Label label14 = new Label();
    label14.setText(getString("ProjectEditForm.currencyRateDateLabel.text"));
    tabItem2.add(label14);
    
    DateField dateField4 = new DateField();
    dateField4.setProperty("currencyRateDate");
    tabItem2.add(dateField4);
    
    Label label15 = new Label();
    GridData layoutData3 = new GridData(4, 1, GridData.DEFAULT_HORIZONTAL_ALIGN, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    label15.setLayoutData(layoutData3);
    tabItem2.add(label15);
    
    Label label16 = new Label();
    label16.setText(getString("ProjectEditForm.currencyAmountLabel.text"));
    tabItem2.add(label16);
    
    CurrencyField currencyField2 = new CurrencyField();
    currencyField2.setProperty("currencyAmount");
    tabItem2.add(currencyField2);
    
    Label label17 = new Label();
    GridData layoutData4 = new GridData(6, 1, GridData.DEFAULT_HORIZONTAL_ALIGN, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    label17.setLayoutData(layoutData4);
    tabItem2.add(label17);
    
    Label label18 = new Label();
    label18.setText(getString("ProjectEditForm.discountPercentLabel.text"));
    tabItem2.add(label18);
    
    PercentField percentField2 = new PercentField();
    percentField2.setProperty("discountPercent");
    tabItem2.add(percentField2);
    
    Label label19 = new Label();
    label19.setText(getString("ProjectEditForm.discountAmountLabel.text"));
    tabItem2.add(label19);
    
    CurrencyField currencyField3 = new CurrencyField();
    currencyField3.setProperty("currencyDiscountAmount");
    tabItem2.add(currencyField3);
    
    Label label20 = new Label();
    label20.setText(getString("ProjectEditForm.currencyTotalLabel.text"));
    tabItem2.add(label20);
    
    CurrencyField currencyField4 = new CurrencyField();
    currencyField4.setProperty("currencyTotal");
    tabItem2.add(currencyField4);
    
    Label label21 = new Label();
    GridData layoutData5 = new GridData(6, 1, GridData.DEFAULT_HORIZONTAL_ALIGN, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    label21.setLayoutData(layoutData5);
    tabItem2.add(label21);
    
    Label label22 = new Label();
    label22.setText(getString("ProjectEditForm.taxPercentLabel.text"));
    tabItem2.add(label22);
    
    LookupField lookupField6 = new LookupField();
    lookupField6.setDataType("base/Tax");
    tabItem2.add(lookupField6);
    
    Label label23 = new Label();
    label23.setText(getString("ProjectEditForm.taxAmountLabel.text"));
    tabItem2.add(label23);
    
    CurrencyField currencyField5 = new CurrencyField();
    currencyField5.setProperty("currencyTaxTotal");
    tabItem2.add(currencyField5);
    
    Label label24 = new Label();
    label24.setText(getString("ProjectEditForm.currencyTotalWithTaxLabel.text"));
    tabItem2.add(label24);
    
    CurrencyField currencyField6 = new CurrencyField();
    currencyField6.setProperty("currencyTotalWithTax");
    tabItem2.add(currencyField6);
    tabPanel1.addItem((TabItem) tabItem2);
    
    TabItem tabItem3 = new TabItem();
    tabItem3.setTitle(getString("ProjectEditForm.descriptionTabItem.text"));
    
    GridLayout layout4 = new GridLayout();
    tabItem3.setLayout(layout4);
    
    TextArea textArea1 = new TextArea();
    GridData layoutData6 = new GridData(1, 1, HorizontalAlign.FILL, VerticalAlign.FILL, true, true);
    textArea1.setLayoutData(layoutData6);
    textArea1.setProperty("description");
    tabItem3.add(textArea1);
    tabPanel1.addItem((TabItem) tabItem3);
    content.add(tabPanel1);
    
    return content;
  
  }

}