package org.plazmaforge.bsolution.base.client.swing.forms;


import javax.swing.*;

import org.plazmaforge.bsolution.bank.BankContext;
import org.plazmaforge.bsolution.bank.client.swing.forms.common.XPaymentTypeComboBox;
import org.plazmaforge.bsolution.bank.client.swing.forms.common.XTaxPrintTypeComboBox;
import org.plazmaforge.bsolution.bank.common.beans.PaymentType;
import org.plazmaforge.bsolution.bank.common.beans.TaxPrintType;
import org.plazmaforge.bsolution.bank.common.services.BankContextService;
import org.plazmaforge.bsolution.base.EnterpriseContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.beans.Period;
import org.plazmaforge.bsolution.base.common.beans.SystemInfo;
import org.plazmaforge.bsolution.base.common.beans.Tax;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.base.common.services.SystemInfoService;
import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.employee.client.swing.forms.EmployeeList;
import org.plazmaforge.bsolution.organization.client.swing.forms.ResponsibleList;
import org.plazmaforge.bsolution.organization.client.swing.forms.StorableList;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.project.ProjectContext;
import org.plazmaforge.bsolution.project.TaskContext;
import org.plazmaforge.bsolution.project.client.swing.forms.ProjectList;
import org.plazmaforge.bsolution.project.client.swing.forms.ProjectStageList;
import org.plazmaforge.bsolution.project.client.swing.forms.ProjectStateList;
import org.plazmaforge.bsolution.project.client.swing.forms.ProjectTypeList;
import org.plazmaforge.bsolution.project.client.swing.forms.TaskPriorityList;
import org.plazmaforge.bsolution.project.client.swing.forms.TaskResultList;
import org.plazmaforge.bsolution.project.client.swing.forms.TaskStateList;
import org.plazmaforge.bsolution.project.client.swing.forms.TaskTypeList;
import org.plazmaforge.bsolution.project.common.beans.ProjectHeader;
import org.plazmaforge.bsolution.project.common.beans.ProjectStage;
import org.plazmaforge.bsolution.project.common.beans.ProjectStatus;
import org.plazmaforge.bsolution.project.common.beans.ProjectType;
import org.plazmaforge.bsolution.project.common.beans.TaskPriority;
import org.plazmaforge.bsolution.project.common.beans.TaskResult;
import org.plazmaforge.bsolution.project.common.beans.TaskStatus;
import org.plazmaforge.bsolution.project.common.beans.TaskType;
import org.plazmaforge.bsolution.project.common.services.ProjectContextService;
import org.plazmaforge.bsolution.project.common.services.TaskContextService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;

/**
 * @author Oleh Hapon Date: 28.05.2006 Time: 10:49:48 $Id: SystemInfoEdit.java,v 1.2 2010/12/05 07:56:44 ohapon Exp $
 */
public class SystemInfoEdit extends EXTEditForm {

    private JLabel periodLabel;

    private JLabel payrollPeriodLabel;

    private JLabel currencyLabel;

    private JLabel unitLabel;

    private JLabel taxLabel;

    private JLabel partnerLabel;

    private JLabel supplierLabel;

    private JLabel customerLabel;

    private JLabel responsibleLabel;

    private JLabel materialResponsibleLabel;

    private JLabel warehouseLabel;

    private JLabel incomeWarehouseLabel;

    private JLabel outcomeWarehouseLabel;

    // BANK
    private JLabel bankPartnerLabel;

    private JLabel bankIncomePartnerLabel;

    private JLabel bankOutcomePartnerLabel;

    private JLabel paymentTypeLabel;

    private JLabel taxPrintTypeLabel;

    // PROJECT
    private JLabel projectPartnerLabel;

    private JLabel projectResponsibleLabel;

    private JLabel projectStageLabel;

    private JLabel projectStateLabel;

    private JLabel projectTypeLabel;

    private JLabel projectCurrencyLabel;

    // TASK
    private JLabel taskPartnerLabel;

    private JLabel taskResponsibleLabel;

    private JLabel projectLabel;

    private JLabel taskPriorityLabel;

    private JLabel taskStateLabel;

    private JLabel taskTypeLabel;

    private JLabel taskResultLabel;

    private XComboEdit periodField;

    private XComboEdit payrollPeriodField;

    private XComboEdit currencyField;

    private XComboEdit unitField;

    private XComboEdit taxField;

    private XComboEdit partnerField;

    private XComboEdit supplierField;

    private XComboEdit customerField;

    private XComboEdit responsibleField;

    private XComboEdit materialResponsibleField;

    private XComboEdit warehouseField;

    private XComboEdit incomeWarehouseField;

    private XComboEdit outcomeWarehouseField;

    // BANK
    private XComboEdit bankPartnerField;

    private XComboEdit bankIncomePartnerField;

    private XComboEdit bankOutcomePartnerField;

    private XPaymentTypeComboBox paymentTypeField;

    private XTaxPrintTypeComboBox taxPrintTypeField;

    // PROJECT
    private XComboEdit projectPartnerField;

    private XComboEdit projectResponsibleField;

    private XComboEdit projectStageField;

    private XComboEdit projectStateField;

    private XComboEdit projectTypeField;

    private XComboEdit projectCurrencyField;

    // TASK
    private XComboEdit taskPartnerField;

    private XComboEdit taskResponsibleField;

    private XComboEdit projectField;

    private XComboEdit taskPriorityField;

    private XComboEdit taskStateField;

    private XComboEdit taskTypeField;

    private XComboEdit taskResultField;

    private EnterpriseContext enterpriseContext;
    
    private BankContext bankContext;

    private BankContextService bankContextService;

    private ProjectContext projectContext;

    private ProjectContextService projectContextService;

    private TaskContext taskContext;

    private TaskContextService taskContextService;

    public SystemInfoEdit() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(SystemInfo.class);
	this.setEntityServiceClass(SystemInfoService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));
	setLayout(new BorderLayout());

	add(createMasterTabbedPane());
    }

    private JTabbedPane createMasterTabbedPane() throws ApplicationException {
	JTabbedPane tp = new JTabbedPane();
	tp.addTab(getString("panel.title.common.text"), createCommonPanel());
	tp
		.addTab(getString("panel.title.adding.text"),
			createAdditionalPanel());
	tp.addTab(getString("panel.title.bank.text"), createBankPanel());
	tp.addTab(getString("panel.title.project.text"), createProjectPanel());
	tp.addTab(getString("panel.title.task.text"), createTaskPanel());
	return tp;
    }

    private JPanel createCommonPanel() throws ApplicationException {

	periodLabel = new JLabel(getString("panel.label-period.text"));
	payrollPeriodLabel = new JLabel(
		getString("panel.label-payroll-period.text"));
	currencyLabel = new JLabel(getString("panel.label-currency.text"));
	unitLabel = new JLabel(getString("panel.label-unit.text"));
	taxLabel = new JLabel(getString("panel.label-tax.text"));

	periodField = new XComboEdit();
	periodField.setColumns(30);

	payrollPeriodField = new XComboEdit();
	payrollPeriodField.setColumns(30);

	currencyField = new XComboEdit();
	currencyField.setColumns(30);

	unitField = new XComboEdit();
	unitField.setColumns(30);

	taxField = new XComboEdit();
	taxField.setColumns(30);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(periodLabel);
	editPanel.addByY(payrollPeriodLabel);
	editPanel.addByY(currencyLabel);
	editPanel.addByY(unitLabel);
	editPanel.addByY(taxLabel);

	gbc.gridy = 0;
	editPanel.addByX(periodField);
	editPanel.addByY(payrollPeriodField);
	editPanel.addByY(currencyField);
	editPanel.addByY(unitField);
	editPanel.addByY(taxField);

	periodField.initListFormAction(this, PeriodList.class);
	payrollPeriodField.initListFormAction(this, PeriodList.class);
	currencyField.initListFormAction(this, CurrencyList.class);
	unitField.initListFormAction(this, UnitList.class);
	taxField.initListFormAction(this, TaxList.class);

	return editPanel;
    }

    private JPanel createAdditionalPanel() throws ApplicationException {

	partnerLabel = new JLabel(getString("panel.label-partner.text"));
	supplierLabel = new JLabel(getString("panel.label-supplier.text"));
	customerLabel = new JLabel(getString("panel.label-customer.text"));
	responsibleLabel = new JLabel(getString("panel.label-responsible.text"));
	materialResponsibleLabel = new JLabel(
		getString("panel.label-material-responsible.text"));
	warehouseLabel = new JLabel(getString("panel.label-storable.text"));
	incomeWarehouseLabel = new JLabel(
		getString("panel.label-income-storable.text"));
	outcomeWarehouseLabel = new JLabel(
		getString("panel.label-outcome-storable.text"));

	partnerField = new XComboEdit(true, 30);
	supplierField = new XComboEdit(true, 30);
	customerField = new XComboEdit(true, 30);
	responsibleField = new XComboEdit(true, 30);
	materialResponsibleField = new XComboEdit(true, 30);
	warehouseField = new XComboEdit(true, 30);
	incomeWarehouseField = new XComboEdit(true, 30);
	outcomeWarehouseField = new XComboEdit(true, 30);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(partnerLabel);
	editPanel.addByY(supplierLabel);
	editPanel.addByY(customerLabel);
	editPanel.addByY(responsibleLabel);
	editPanel.addByY(materialResponsibleLabel);
	editPanel.addByY(warehouseLabel);
	editPanel.addByY(incomeWarehouseLabel);
	editPanel.addByY(outcomeWarehouseLabel);

	gbc.gridy = 0;
	editPanel.addByX(partnerField);
	editPanel.addByY(supplierField);
	editPanel.addByY(customerField);
	editPanel.addByY(responsibleField);
	editPanel.addByY(materialResponsibleField);
	editPanel.addByY(warehouseField);
	editPanel.addByY(incomeWarehouseField);
	editPanel.addByY(outcomeWarehouseField);

	partnerField.initListFormAction(this, PartnerList.class);
	supplierField.initListFormAction(this, PartnerList.class);
	customerField.initListFormAction(this, PartnerList.class);

	responsibleField.initListFormAction(this, EmployeeList.class);
	materialResponsibleField
		.initListFormAction(this, ResponsibleList.class);

	warehouseField.initListFormAction(this, StorableList.class);
	incomeWarehouseField.initListFormAction(this, StorableList.class);
	outcomeWarehouseField.initListFormAction(this, StorableList.class);

	return editPanel;
    }

    private JPanel createBankPanel() throws ApplicationException {

	bankPartnerLabel = new JLabel(
		getString("panel.label-bank-partner.text"));
	bankIncomePartnerLabel = new JLabel(
		getString("panel.label-bank-income-partner.text"));
	bankOutcomePartnerLabel = new JLabel(
		getString("panel.label-bank-outcome-partner.text"));

	paymentTypeLabel = new JLabel(
		getString("panel.label-payment-type.text"));
	taxPrintTypeLabel = new JLabel(
		getString("panel.label-tax-print-type.text"));

	bankPartnerField = new XComboEdit(true, 30);
	bankIncomePartnerField = new XComboEdit(true, 30);
	bankOutcomePartnerField = new XComboEdit(true, 30);
	paymentTypeField = new XPaymentTypeComboBox();
	taxPrintTypeField = new XTaxPrintTypeComboBox();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(bankPartnerLabel);
	editPanel.addByY(bankIncomePartnerLabel);
	editPanel.addByY(bankOutcomePartnerLabel);
	editPanel.addByY(paymentTypeLabel);
	editPanel.addByY(taxPrintTypeLabel);

	gbc.gridy = 0;
	editPanel.addByX(bankPartnerField);
	editPanel.addByY(bankIncomePartnerField);
	editPanel.addByY(bankOutcomePartnerField);

	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByY(paymentTypeField);
	editPanel.addByY(taxPrintTypeField);

	bankPartnerField.initListFormAction(this, PartnerList.class);
	bankIncomePartnerField.initListFormAction(this, PartnerList.class);
	bankOutcomePartnerField.initListFormAction(this, PartnerList.class);

	return editPanel;
    }

    private JPanel createProjectPanel() throws ApplicationException {

	projectPartnerLabel = new JLabel(
		getString("panel.label-project-partner.text"));
	projectResponsibleLabel = new JLabel(
		getString("panel.label-project-responsible.text"));
	projectStageLabel = new JLabel(
		getString("panel.label-project-stage.text"));
	projectStateLabel = new JLabel(
		getString("panel.label-project-state.text"));
	projectTypeLabel = new JLabel(
		getString("panel.label-project-type.text"));
	projectCurrencyLabel = new JLabel(
		getString("panel.label-project-currency.text"));

	projectPartnerField = new XComboEdit(true, 30);
	projectResponsibleField = new XComboEdit(true, 30);
	projectStageField = new XComboEdit(true, 30);
	projectStateField = new XComboEdit(true, 30);
	projectTypeField = new XComboEdit(true, 30);
	projectCurrencyField = new XComboEdit(true, 30);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(projectPartnerLabel);
	editPanel.addByY(projectResponsibleLabel);
	editPanel.addByY(projectStageLabel);
	editPanel.addByY(projectStateLabel);
	editPanel.addByY(projectTypeLabel);
	editPanel.addByY(projectCurrencyLabel);

	gbc.gridy = 0;
	editPanel.addByX(projectPartnerField);
	editPanel.addByY(projectResponsibleField);
	editPanel.addByY(projectStageField);
	editPanel.addByY(projectStateField);
	editPanel.addByY(projectTypeField);
	editPanel.addByY(projectCurrencyField);

	projectPartnerField.initListFormAction(this, PartnerList.class);
	projectResponsibleField.initListFormAction(this, EmployeeList.class);
	projectStageField.initListFormAction(this, ProjectStageList.class);
	projectStateField.initListFormAction(this, ProjectStateList.class);
	projectTypeField.initListFormAction(this, ProjectTypeList.class);
	projectCurrencyField.initListFormAction(this, CurrencyList.class);

	return editPanel;
    }

    private JPanel createTaskPanel() throws ApplicationException {

	taskPartnerLabel = new JLabel(
		getString("panel.label-task-partner.text"));
	taskResponsibleLabel = new JLabel(
		getString("panel.label-task-responsible.text"));
	projectLabel = new JLabel(getString("panel.label-project.text"));
	taskPriorityLabel = new JLabel(
		getString("panel.label-task-priority.text"));
	taskStateLabel = new JLabel(getString("panel.label-task-state.text"));
	taskTypeLabel = new JLabel(getString("panel.label-task-type.text"));
	taskResultLabel = new JLabel(getString("panel.label-task-result.text"));

	taskPartnerField = new XComboEdit(true, 30);
	taskResponsibleField = new XComboEdit(true, 30);
	projectField = new XComboEdit(true, 30);
	taskPriorityField = new XComboEdit(true, 30);
	taskStateField = new XComboEdit(true, 30);
	taskTypeField = new XComboEdit(true, 30);
	taskResultField = new XComboEdit(true, 30);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(taskPartnerLabel);
	editPanel.addByY(taskResponsibleLabel);
	editPanel.addByY(projectLabel);
	editPanel.addByY(taskPriorityLabel);
	editPanel.addByY(taskStateLabel);
	editPanel.addByY(taskTypeLabel);
	editPanel.addByY(taskResultLabel);

	gbc.gridy = 0;
	editPanel.addByX(taskPartnerField);
	editPanel.addByY(taskResponsibleField);
	editPanel.addByY(projectField);
	editPanel.addByY(taskPriorityField);
	editPanel.addByY(taskStateField);
	editPanel.addByY(taskTypeField);
	editPanel.addByY(taskResultField);

	taskPartnerField.initListFormAction(this, PartnerList.class);
	taskResponsibleField.initListFormAction(this, EmployeeList.class);
	projectField.initListFormAction(this, ProjectList.class);
	taskPriorityField.initListFormAction(this, TaskPriorityList.class);
	taskStateField.initListFormAction(this, TaskStateList.class);
	taskTypeField.initListFormAction(this, TaskTypeList.class);
	taskResultField.initListFormAction(this, TaskResultList.class);

	return editPanel;
    }

    private SystemInfo getSystemInfo() {
	return (SystemInfo) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	periodField.setValue(getEnterpriseContext().getPeriod());
	payrollPeriodField.setValue(getEnterpriseContext().getPayrollPeriod());
	currencyField.setValue(getEnterpriseContext().getCurrency());
	unitField.setValue(getEnterpriseContext().getUnit());
	taxField.setValue(getEnterpriseContext().getTax());

	// --

	partnerField.setValue(getEnterpriseContext().getPartner());
	supplierField.setValue(getEnterpriseContext().getSupplier());
	customerField.setValue(getEnterpriseContext().getCustomer());
	responsibleField.setValue(getEnterpriseContext().getResponsible());
	materialResponsibleField.setValue(getEnterpriseContext().getMtrlResponsible());
	warehouseField.setValue(getEnterpriseContext().getWarehouse());
	incomeWarehouseField.setValue(getEnterpriseContext().getIncomeWarehouse());
	outcomeWarehouseField.setValue(getEnterpriseContext().getOutcomeWarehouse());

	// --

	bankPartnerField.setValue(getBankContext().getPartner());
	bankIncomePartnerField.setValue(getBankContext().getIncomePartner());
	bankOutcomePartnerField.setValue(getBankContext().getOutcomePartner());
	paymentTypeField.setValue(getBankContext().getPaymentType());
	taxPrintTypeField.setValue(getBankContext().getTaxPrintType());

	// --

	projectPartnerField.setValue(getProjectContext().getPartner());
	projectResponsibleField.setValue(getProjectContext().getResponsible());
	projectStageField.setValue(getProjectContext().getProjectStage());
	projectStateField.setValue(getProjectContext().getProjectStatus());
	projectTypeField.setValue(getProjectContext().getProjectType());
	projectCurrencyField.setValue(getProjectContext().getCurrency());

	// --

	taskPartnerField.setValue(getTaskContext().getPartner());
	taskResponsibleField.setValue(getTaskContext().getResponsible());
	projectField.setValue(getTaskContext().getProject());
	taskPriorityField.setValue(getTaskContext().getTaskPriority());
	taskStateField.setValue(getTaskContext().getTaskStatus());
	taskTypeField.setValue(getTaskContext().getTaskType());
	taskResultField.setValue(getTaskContext().getTaskResult());
    }

    protected void populateData() throws ApplicationException {
	getEnterpriseContext().setPeriod((Period) periodField.getValue());
	getEnterpriseContext().setPayrollPeriod((Period) payrollPeriodField.getValue());
	getEnterpriseContext().setCurrency((Currency) currencyField.getValue());
	getEnterpriseContext().setUnit((Unit) unitField.getValue());
	getEnterpriseContext().setTax((Tax) taxField.getValue());

	// --

	getEnterpriseContext().setPartner((PartnerHeader) partnerField.getValue());
	getEnterpriseContext().setSupplier((PartnerHeader) supplierField.getValue());
	getEnterpriseContext().setCustomer((PartnerHeader) customerField.getValue());
	getEnterpriseContext().setResponsible((ContactHeader) responsibleField.getValue());
	getEnterpriseContext().setMtrlResponsible((MtrlResponsible) materialResponsibleField.getValue());
	getEnterpriseContext().setWarehouse((Warehouse) warehouseField.getValue());
	getEnterpriseContext().setIncomeWarehouse((Warehouse) incomeWarehouseField.getValue());
	getEnterpriseContext().setOutcomeWarehouse((Warehouse) outcomeWarehouseField.getValue());

	// --
	getBankContext()
		.setPartner((PartnerHeader) bankPartnerField.getValue());
	getBankContext().setIncomePartner(
		(PartnerHeader) bankIncomePartnerField.getValue());
	getBankContext().setOutcomePartner(
		(PartnerHeader) bankOutcomePartnerField.getValue());
	getBankContext().setPaymentType(
		(PaymentType) paymentTypeField.getValue());
	getBankContext().setTaxPrintType(
		(TaxPrintType) taxPrintTypeField.getValue());

	// --
	getProjectContext().setPartner(
		(PartnerHeader) projectPartnerField.getValue());
	getProjectContext().setResponsible(
		(ContactHeader) projectResponsibleField.getValue());
	getProjectContext().setProjectStage(
		(ProjectStage) projectStageField.getValue());
	getProjectContext().setProjectStatus(
		(ProjectStatus) projectStateField.getValue());
	getProjectContext().setProjectType(
		(ProjectType) projectTypeField.getValue());
	getProjectContext().setCurrency(
		(Currency) projectCurrencyField.getValue());

	// --
	getTaskContext()
		.setPartner((PartnerHeader) taskPartnerField.getValue());
	getTaskContext().setResponsible(
		(ContactHeader) taskResponsibleField.getValue());
	getTaskContext().setProject((ProjectHeader) projectField.getValue());
	getTaskContext().setTaskPriority(
		(TaskPriority) taskPriorityField.getValue());
	getTaskContext().setTaskStatus((TaskStatus) taskStateField.getValue());
	getTaskContext().setTaskType((TaskType) taskTypeField.getValue());
	getTaskContext().setTaskResult((TaskResult) taskResultField.getValue());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	// validateRequiredField(buf, getSystemInfo().getName(),
        // payrollPeriodLabel.getText());
	checkError(buf);
    }

    protected void loadData(Object value) throws ApplicationException {
	super.loadData(value);
	bankContext = getBankContextService().load();
	projectContext = getProjectContextService().load();
	taskContext = getTaskContextService().load();
    }

    protected void storeData() throws ApplicationException {
	super.storeData();
	getBankContextService().store(getBankContext());
	getProjectContextService().store(getProjectContext());
	getTaskContextService().store(getTaskContext());
	EnterpriseEnvironment.refresh();
    }

    /*
    public EnterpriseContextService getEnterpriseContextService() {
	if (enterpriseContextService == null) {
	    enterpriseContextService = (EnterpriseContextService) getSERVICE(EnterpriseContextService.class);
	}
	return enterpriseContextService;
    }
    */

    public EnterpriseContext getEnterpriseContext() {
	return enterpriseContext;
    }
    
    public BankContextService getBankContextService() {
	if (bankContextService == null) {
	    bankContextService = (BankContextService) getSERVICE(BankContextService.class);
	}
	return bankContextService;
    }

    public BankContext getBankContext() {
	return bankContext;
    }

    public ProjectContextService getProjectContextService() {
	if (projectContextService == null) {
	    projectContextService = (ProjectContextService) getSERVICE(ProjectContextService.class);
	}
	return projectContextService;
    }

    public ProjectContext getProjectContext() {
	return projectContext;
    }

    public TaskContext getTaskContext() {
	return taskContext;
    }

    public TaskContextService getTaskContextService() {
	if (taskContextService == null) {
	    taskContextService = (TaskContextService) getSERVICE(TaskContextService.class);
	}
	return taskContextService;
    }

}
