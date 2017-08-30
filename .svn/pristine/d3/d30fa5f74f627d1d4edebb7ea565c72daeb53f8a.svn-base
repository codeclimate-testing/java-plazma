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
import org.plazmaforge.framework.uwt.widget.DateTimeField;
import org.plazmaforge.framework.uwt.widget.LookupField;
import org.plazmaforge.framework.uwt.widget.PercentField;
import org.plazmaforge.framework.uwt.form.EditForm;

public class TaskEditForm_Gen extends EditForm {


  public TaskEditForm_Gen() {
  }
  
  @Override
  public void createUI() {
    
    super.createUI();
    
    setName("TaskEditForm");
    setType("EditForm");
    setTitle(getString("TaskEditForm.title"));
  
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
    tabItem1.setTitle(getString("TaskEditForm.generalTabItem.text"));
    
    GridLayout layout2 = new GridLayout();
    layout2.setColumnCount(4);
    tabItem1.setLayout(layout2);
    
    Label label1 = new Label();
    label1.setText(getString("TaskEditForm.nameLabel.text"));
    tabItem1.add(label1);
    
    TextField textField1 = new TextField();
    textField1.setWidth(200);
    GridData layoutData2 = new GridData(3, 1, HorizontalAlign.FILL, GridData.DEFAULT_VERTICAL_ALIGN, false, false);
    textField1.setLayoutData(layoutData2);
    textField1.setProperty("name");
    tabItem1.add(textField1);
    
    Label label2 = new Label();
    label2.setText(getString("TaskEditForm.taskNoLabel.text"));
    tabItem1.add(label2);
    
    TextField textField2 = new TextField();
    textField2.setWidth(200);
    textField2.setProperty("taskNo");
    tabItem1.add(textField2);
    
    Label label3 = new Label();
    label3.setText(getString("TaskEditForm.taskTypeLabel.text"));
    tabItem1.add(label3);
    
    ComboBox comboBox1 = new ComboBox();
    comboBox1.setWidth(200);
    comboBox1.setProperty("taskType");
    comboBox1.setDataType("project/TaskType");
    tabItem1.add(comboBox1);
    
    Label label4 = new Label();
    label4.setText(getString("TaskEditForm.startDateTimeLabel.text"));
    tabItem1.add(label4);
    
    DateTimeField dateTimeField1 = new DateTimeField();
    dateTimeField1.setWidth(200);
    dateTimeField1.setProperty("startDateTime");
    dateTimeField1.setDataType("DateTime");
    tabItem1.add(dateTimeField1);
    
    Label label5 = new Label();
    label5.setText(getString("TaskEditForm.taskPriorityLabel.text"));
    tabItem1.add(label5);
    
    ComboBox comboBox2 = new ComboBox();
    comboBox2.setWidth(200);
    comboBox2.setProperty("taskPriority");
    comboBox2.setDataType("task/TaskPriority");
    tabItem1.add(comboBox2);
    
    Label label6 = new Label();
    label6.setText(getString("TaskEditForm.endDateTimeLabel.text"));
    tabItem1.add(label6);
    
    DateTimeField dateTimeField2 = new DateTimeField();
    dateTimeField2.setWidth(200);
    dateTimeField2.setProperty("endDateTime");
    dateTimeField2.setDataType("DateTime");
    tabItem1.add(dateTimeField2);
    
    Label label7 = new Label();
    label7.setText(getString("TaskEditForm.actualEndDateTimeLabel.text"));
    tabItem1.add(label7);
    
    DateTimeField dateTimeField3 = new DateTimeField();
    dateTimeField3.setWidth(200);
    dateTimeField3.setProperty("actualEndDateTime");
    dateTimeField3.setDataType("DateTime");
    tabItem1.add(dateTimeField3);
    
    Label label8 = new Label();
    label8.setText(getString("TaskEditForm.reporterLabel.text"));
    tabItem1.add(label8);
    
    LookupField lookupField1 = new LookupField();
    lookupField1.setWidth(200);
    lookupField1.setProperty("reporter");
    lookupField1.setDataType("contact/ContactTitle");
    tabItem1.add(lookupField1);
    
    Label label9 = new Label();
    label9.setText(getString("TaskEditForm.responsibleLabel.text"));
    tabItem1.add(label9);
    
    LookupField lookupField2 = new LookupField();
    lookupField2.setWidth(200);
    lookupField2.setProperty("responsible");
    lookupField2.setDataType("contact/ContactTitle");
    tabItem1.add(lookupField2);
    
    Label label10 = new Label();
    label10.setText(getString("TaskEditForm.projectLabel.text"));
    tabItem1.add(label10);
    
    LookupField lookupField3 = new LookupField();
    lookupField3.setWidth(200);
    lookupField3.setProperty("project");
    lookupField3.setDataType("project/ProjectHeader");
    tabItem1.add(lookupField3);
    
    Label label11 = new Label();
    label11.setText(getString("TaskEditForm.documentLabel.text"));
    tabItem1.add(label11);
    
    LookupField lookupField4 = new LookupField();
    lookupField4.setWidth(200);
    lookupField4.setProperty("document");
    lookupField4.setDataType("document/DocumentHeader");
    tabItem1.add(lookupField4);
    
    Label label12 = new Label();
    label12.setText(getString("TaskEditForm.projectStatusLabel.text"));
    tabItem1.add(label12);
    
    LookupField lookupField5 = new LookupField();
    lookupField5.setWidth(200);
    lookupField5.setProperty("projectStatus");
    lookupField5.setDataType("project/ProjectStatus");
    tabItem1.add(lookupField5);
    
    Label label13 = new Label();
    label13.setText(getString("TaskEditForm.percentCompleteLabel.text"));
    tabItem1.add(label13);
    
    PercentField percentField1 = new PercentField();
    percentField1.setWidth(200);
    percentField1.setProperty("percentComplete");
    tabItem1.add(percentField1);
    
    Label label14 = new Label();
    label14.setText(getString("TaskEditForm.reminderDateTimeLabel.text"));
    tabItem1.add(label14);
    
    DateTimeField dateTimeField4 = new DateTimeField();
    dateTimeField4.setWidth(200);
    dateTimeField4.setProperty("reminderDateTime");
    tabItem1.add(dateTimeField4);
    
    Label label15 = new Label();
    label15.setText(getString("TaskEditForm.partnerLabel.text"));
    tabItem1.add(label15);
    
    LookupField lookupField6 = new LookupField();
    lookupField6.setWidth(200);
    lookupField6.setProperty("partner");
    lookupField6.setDataType("partner/PartnerTitle");
    tabItem1.add(lookupField6);
    tabPanel1.addItem((TabItem) tabItem1);
    content.add(tabPanel1);
    
    return content;
  
  }

}