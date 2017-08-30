/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

/* 
 * Created on 22.03.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.Environment;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.dialogs.ChooseDialog;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.config.ConfigUtils;
import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.configurer.FormConfigurer;
import org.plazmaforge.framework.config.configurer.ReportConfigurer;
import org.plazmaforge.framework.config.object.FormConfig;
import org.plazmaforge.framework.config.object.IConfigIdentifier;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.config.object.IFormConfig;
import org.plazmaforge.framework.config.object.IAcceptorConfig;
import org.plazmaforge.framework.config.object.IReportConfig;
import org.plazmaforge.framework.config.object.ReportConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.EntityObject;
import org.plazmaforge.framework.platform.PlatformEnvironment;
import org.plazmaforge.framework.report.ReportAcceptorFactory;


/** 
 * @author Oleh Hapon
 * $Id: ReportEditForm.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class ReportEditForm extends AbstractEditForm {

    private Label idLabel;
    private Label nameLabel;
    private Label descriptionLabel;
    private Label pathLabel;
    private Label fileNameLabel;
    
    private Label regionLabel;
    private Label countryLabel;
    private Label languageLabel;
    
    private Label acceptorLabel;
    private Label independentLabel;
    
    
    //private XTextField idField;
    private XTextField nameField;
    private XTextField descriptionField;
    private XComboEdit pathField;
    private XTextField fileNameField;
    
    private XTextField regionField;
    private XTextField countryField;
    private XTextField languageField;
    
    private XComboEdit acceptorField;
    private XCheckBox independentField;
    
    private Button fileBrowseButton;
   
    ////
    
    private Composite itemPanel;

    private Table formsTable;
    
    private TabFolder tabFolder;
    
    ////

    private boolean isAbsolute;
    
    private List<IAcceptorConfig> reportAcceptors;
    
    private List<IEntityConfig> entities;

    /**
     * Forms of report
     */
    private List<FormDescriptor> formList;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public ReportEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("ReportEditForm.title")); //$NON-NLS-1$
	
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 3;
	setLayout(gridLayout);
    	
    	
    	idLabel = new Label(this, SWT.NONE);
	idLabel.setText(Messages.getString("ReportEditForm.idLabel.text")); //$NON-NLS-1$
	setRequiredLabel(idLabel);

    	//idField = new XTextField(this, SWT.BORDER);
    	//gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	//gridData.widthHint = 100;
    	
    	//idField.setLayoutData(gridData /*new GridData(100, SWT.DEFAULT)*/);
    	//idField.setTextLimit(20);

    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("ReportEditForm.nameLabel.text")); //$NON-NLS-1$
	setRequiredLabel(nameLabel);

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	gridData.widthHint = 300;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	
    	////
    	
    	descriptionLabel = new Label(this, SWT.NONE);
    	descriptionLabel.setText(Messages.getString("ReportEditForm.descriptionLabel.text")); //$NON-NLS-1$

    	descriptionField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	descriptionField.setLayoutData(gridData);
    	descriptionField.setTextLimit(50);
    	
	//
    	Label label = new Label(this, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
    	//    	
    	
    	pathLabel = new Label(this, SWT.NONE);
    	pathLabel.setText(Messages.getString("ReportEditForm.pathLabel.text")); //$NON-NLS-1$

    	pathField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	pathField.setLayoutData(gridData);
    	pathField.setTextLimit(50);
    	pathField.setSupportService(false);
    	//
    	
    	fileNameLabel = new Label(this, SWT.NONE);
    	fileNameLabel.setText(Messages.getString("ReportEditForm.fileNameLabel.text")); //$NON-NLS-1$
    	setRequiredLabel(fileNameLabel);

    	fileNameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	fileNameField.setLayoutData(gridData);
    	fileNameField.setTextLimit(50);
    	
    	fileBrowseButton = new Button(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	fileNameField.setLayoutData(gridData);
    	fileBrowseButton.setText(Messages.getString("ReportEditForm.fileBrowseButton.text")); //$NON-NLS-1$
    	
    	//
    	if (isSupportLocaleReport()) {
    	    
    	    label = new Label(this, SWT.NONE);
    	    label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
    	    
    	    //
        	
	    regionLabel = new Label(this, SWT.NONE);
	    regionLabel.setText(Messages.getString("ReportEditForm.regionLabel.text")); //$NON-NLS-1$

	    regionField = new XTextField(this, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	    regionField.setLayoutData(gridData);
	    regionField.setTextLimit(50);

	    //

	    countryLabel = new Label(this, SWT.NONE);
	    countryLabel.setText(Messages.getString("ReportEditForm.countryLabel.text")); //$NON-NLS-1$

	    countryField = new XTextField(this, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	    countryField.setLayoutData(gridData);
	    countryField.setTextLimit(50);

	    //

	    languageLabel = new Label(this, SWT.NONE);
	    languageLabel.setText(Messages.getString("ReportEditForm.languageLabel.text")); //$NON-NLS-1$

	    languageField = new XTextField(this, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	    languageField.setLayoutData(gridData);
	    languageField.setTextLimit(50);

	    //
	}
    	
    	//
    	label = new Label(this, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
    	//
    	
    	acceptorLabel = new Label(this, SWT.NONE);
    	acceptorLabel.setText(Messages.getString("ReportEditForm.acceptorLabel.text")); //$NON-NLS-1$

    	acceptorField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	acceptorField.setLayoutData(gridData);
    	acceptorField.setSupportService(false);
 
    	//
    	
	independentLabel = new Label(this, SWT.NONE);
	independentLabel.setText(Messages.getString("ReportEditForm.independentLabel.text")); //$NON-NLS-1$

	independentField = new XCheckBox(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	independentField.setLayoutData(gridData);
    	
    	//
    	
	ItemToolBar itemToolPanel = new ItemToolBar(this, SWT.NONE, PWT.ADD_BUTTON | PWT.DELETE_BUTTON);
	itemToolPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	itemToolPanel.setForm(this);
  
    	createItemPanel(this);
    	
    	this.setSize(new Point(470, 108));
    	
    	registerEntityProvider(tabFolder.getItem(0), new ReportFormProvider());
    	
    	setEntityClass(ReportConfig.class);
    	setDataSourceSupport(false);
    	
     	fileBrowseButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			chooseFile();
		}
	});

    }

    protected Object getSelectedEntityProviderKey() {
        int index = tabFolder.getSelectionIndex();
        return tabFolder.getItem(index);
    }
    
    private void createItemPanel(Composite parent) {
	
        TableColumn codeTableColumn;
        TableColumn nameTableColumn;
        
        GridLayout gridLayout;

        TabItem formsTabItem;
               
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2);
        gridData.heightHint = 120;
        itemPanel = new Composite(parent, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        itemPanel.setLayout(gridLayout);
        itemPanel.setLayoutData(gridData);
        

        
        tabFolder = new TabFolder(itemPanel, SWT.NONE);
        tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        formsTabItem = new TabItem(tabFolder, SWT.NONE);
        formsTabItem.setText(Messages.getString("ReportEditForm.formsTabItem.text")); //$NON-NLS-1$

         
        //formsTable = new Table(itemPanel, SWTToolkit.TABLE_STYLE);
        formsTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        formsTable.setHeaderVisible(true);
        formsTable.setLinesVisible(true);
        formsTabItem.setControl(formsTable);
        
        codeTableColumn = new TableColumn(formsTable, SWT.NONE);
        codeTableColumn.setWidth(100);
        codeTableColumn.setText(Messages.getString("ReportEditForm.codeTableColumn.text")); //$NON-NLS-1$

        nameTableColumn = new TableColumn(formsTable, SWT.NONE);
        nameTableColumn.setWidth(300);
        nameTableColumn.setText(Messages.getString("ReportEditForm.nameTableColumn.text")); //$NON-NLS-1$

    }

    protected class ReportFormProvider extends TableEntityProvider {
	
	public ReportFormProvider() {
	    setEntityClass(FormDescriptor.class);
	    setSupportEditForm(false);
	}
	
	public IEditForm getEditForm() {
	    return null;
	}
	
	protected Table getTable() {
	    return formsTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "id");
	    bindColumn(1, "name");
	}
	
	public Serializable createEntity(Object entity) throws ApplicationException {
	    FormDescriptor d = (FormDescriptor) entity;
	    d.getForm().setCreated();
	    d.setCreated();
	    formList.add(d);
	    return null;
	}
	
	public void removeEntity(Object entity) throws ApplicationException {
	    FormDescriptor d = (FormDescriptor) entity;
	    d.getForm().setDeleted();
	}
	
	protected List loadDataList(Object parentEntity) throws ApplicationException {
	    
	    // Create form list
	    formList = new ArrayList<FormDescriptor>();
	    List<IFormConfig> forms = ConfigurerManager.getFormsByReport(getReportConfig());
	    if (forms == null) {
		return formList;
	    }
	  
	    // Get form entities
	    List<IEntityConfig> entities = getEntities();
	    boolean hasEntities = entities != null && !entities.isEmpty(); 
	    Class listFormType = getController().getListFormType();
	    for (IFormConfig form: forms) {
		FormDescriptor d = new FormDescriptor(form);
		if (hasEntities) {
		    //TODO: STUB !!!
		    IEntityConfig entity = null; //ConfigurerManager.getEntityByObject(entities, form, listFormType);
		    d.setName(entity.getName());
		}
		formList.add(d);
	    }
	    return formList;
	}
    }
    
    public void doItemAddAction()  throws ApplicationException {

	// Get form entities
	List<IEntityConfig> entities = getEntities();
	if (entities == null) {
	    return;
	}
	ChooseDialog dialog = new ChooseDialog(getShell());
	dialog.setItemLabelProperty("name");
        dialog.setList(entities);
        dialog.open();
	Object selectedItem = dialog.getSelectedItem();
	if (selectedItem == null) {
	    return;
	}
	
	IEntityConfig entity = (IEntityConfig) selectedItem;
	FormConfigurer configurer = getFormConfigurer();
	
	//DODO: STUB !!!
	String formId = null; //ConfigurerManager.getObjectIdByEntity(configurer, entity, getController().getListFormType());
	
	IFormConfig form = configurer.getObjectById(formId);
	
	if (existsForm(formId)) {
	    openMessageDialog("Duplicate form");
	    return;
	}
	if (form == null) {
	    form = new FormConfig();
	    form.setId(formId);
	}

	FormDescriptor d = new FormDescriptor(form);
	d.setName(entity.getName());
	
	doUpdateItem(d, PWT.ADD_MODE);
    }
    
    private boolean existsForm(String formId) {
	if (formList == null || formId == null) {
	    return false;
	}
	for (FormDescriptor d: formList) {
	    if (d.getForm().getId().equals(formId)) {
		return true;
	    }
	}
	return false;
    }
    public class FormDescriptor extends EntityObject {
	
	private IFormConfig form;
	
	private String name;

	
	public FormDescriptor(IFormConfig form) {
	    if (form == null) {
		throw new IllegalArgumentException("Form must be not null");
	    }
	    this.form = form;
	}
	
	public IFormConfig getForm() {
	    return form;
	}

	public String getId() {
	    return form.getId();
	}
	
	public String getCode() {
	    return form.getCode();
	}

	public String getName() {
	    return name == null ? form.getName() : name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	
	
	
	
    }
    
    protected void bindControls() {
	//bindControl(idField, "id", idLabel, REQUIRED);
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(descriptionField, "description");
	bindControl(fileNameField, "fileName", fileNameLabel, REQUIRED);
	
	bindControl(regionField, "region");
	bindControl(countryField, "country");
	bindControl(languageField, "language");
	
	bindControl(independentField, "independent");
    }

    private boolean isSupportLocaleReport() {
	return false;
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	
	initPathField();
	initAcceptorField();
	
	// Disable path
	initDisableField(pathField);
	
//	if (!isAddMode()) {
//	    initDisableField(idField);
//	}
	
	String path = getReportConfig().getPath();
	pathField.setText(path == null ? "" : path);
	String acceptor = getReportConfig().getAcceptor();
	acceptorField.setText(acceptor == null ? "" : acceptor);
	//isAbsolute = getReportConfig().isAbsolutePath();
    }
    
    protected void disableControls() {
	//initDisableField(idField);
	initDisableField(nameField);
	initDisableField(descriptionField);
	
	initDisableField(pathField);
	initDisableField(fileNameField);
	    
	initDisableField(regionField);
	initDisableField(countryField);
	initDisableField(languageField);
	    
	initDisableField(acceptorField);
	initDisableField(independentField);
	
	fileBrowseButton.setEnabled(false);
    }
    
    public void updateData() throws ApplicationException {
	super.updateData();
	//String code = idField.getText().trim();
	//getReportConfig().setCode(code);
	
	getReportConfig().setPath(pathField.getText());
	String acceptor = acceptorField.getText();
	if (acceptor != null){
	    acceptor = acceptor.trim();
	    if (acceptor.isEmpty()) {
		acceptor = null;
	    }
	}
	getReportConfig().setAcceptor(acceptor);
	//getReportConfig().setAbsolutePath(isAbsolute);
	
    }
    
    private void initPathField() {
	if (pathField == null) {
	    return;
	}
	String path = PlatformEnvironment.getReportStoragePath();
	if (path == null || path.trim().length() == 0) {
	    return;
	}
	try {
	    File file = new File(path);
	    if (file.exists() && file.isDirectory()) {
		File[] files = file.listFiles(new PathFilter());
		if (files == null || files.length == 0) {
		    return;
		}
		for (File f : files) {
		    if (!f.isDirectory()) {
			continue;
		    }
		    String name = f.getName();
		    pathField.add(name);
		}
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
    
    private void initAcceptorField() {
	List<IAcceptorConfig> acceptors = getReportAcceptors();
	if (acceptors == null) {
	    return;
	}
	for (IAcceptorConfig c: acceptors) {
	    String currCode = c.getConfigId();
	    acceptorField.add(currCode);
	}
    }
    
    class PathFilter implements FilenameFilter {
	
	public boolean accept (File dir, String name) {
	    // TODO: Stub
	    if ("CVS".equals(name)) {
		return false;
	    }
	    return true;
	}
    }	
    
    private List<IAcceptorConfig> getReportAcceptors() {
	if (reportAcceptors == null) {
	    reportAcceptors = ReportAcceptorFactory.getInstance().getObjects();
	}
	return reportAcceptors; 
    }
    
    /**
     * Return list of entities that have ListForm
     * @return
     */
    private List<IEntityConfig> getEntities() {
	if (entities == null) {
	    entities = Environment.getEntityManager().getEntityConfigListByTypeAndForm(null);
	}
	return entities; 
    }
    
    protected ReportConfig getReportConfig() {
	return (ReportConfig) getEntity();
    }
    
    protected ReportConfigurer getReportConfigurer() {
	return ((ReportConfigurer) ConfigurerManager.getConfigurer(ReportConfigurer.NAME));
    }
    
    protected FormConfigurer getFormConfigurer() {
	return (FormConfigurer) ConfigurerManager.getConfigurer(FormConfigurer.NAME);
    }
    
    protected void validateControls(StringBuffer buf) throws ApplicationException {
	super.validateControls(buf);
	if (!isAddMode()) {
	    return;
	}
	
//	String code = idField.getText().trim();
//	String id = ConfigUtils.generateIdByCode(code);
//	
//	if (getReportConfigurer().getObjectByCode(code) != null) {
//	    buf.append("\n Duplicate Code");
//	    return;
//	}
//	
//	if (getReportConfigurer().getObjectById(id) != null) {
//	    buf.append("\n Duplicate ID");
//	}
	
	String name = nameField.getText().trim();
	if (getReportConfigurer().getObjectByName(name) != null) {
	    buf.append("\n Duplicate Name");
	}
    }
    
    protected void initData() throws ApplicationException {
	getReportConfig().setCustom(true);
    }
    
    protected void createData() throws ApplicationException {
	getReportConfigurer().addObject(getReportConfig());
	getReportConfigurer().storeObjects();
	
	//reconnectForm();
    }
    
    protected void loadData() throws ApplicationException {
	Object entity = getForwardEntity();
	setEntity(entity);
	
	if (isAddMode()) {
	    newData();
	}
    }

    protected void storeData() throws ApplicationException {
	getReportConfigurer().storeObjects();
	storeForms();
    }
    
    protected void storeForms() throws ApplicationException {
	if (formList == null) {
	    return;
	}
	IReportConfig report = getReportConfig();
	boolean isStoreForm = false;
	for (FormDescriptor d: formList ) {
	    IFormConfig form = d.getForm();
	    if (form.isDeleted() && !d.isCreated()) {
		removeReportFromForm(form, report);
		isStoreForm = true;
	    } else if (form.isCreated()) {
		getFormConfigurer().addObject(form);
		form.setNormal();
		addReportToForm(form, report);
		isStoreForm = true;
	    }
	}
	if (isStoreForm) {
	    getFormConfigurer().storeObjects();
	}
    }
    
    protected void removeReportFromForm(IFormConfig form, IReportConfig report) {
	form.removeReportConfig(report);
    }
    
    protected void addReportToForm(IFormConfig form, IReportConfig report) {
	form.addReportConfig(report);
    }
    
    protected void chooseFile() {
	FileDialog fileDialog = new FileDialog(getShell(), SWT.SAVE);
	fileDialog.setFilterExtensions(new String[] {"*.jasper"});
	String storagePath = PlatformEnvironment.getReportStoragePath();
	File storageDir = new File(storagePath);
	String canonicalStoragePath = null;
	try {
	    if (storageDir.exists() && storageDir.isDirectory()) {
		canonicalStoragePath = storageDir.getCanonicalPath();
	    }
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
	if (canonicalStoragePath != null) {
	    fileDialog.setFilterPath(canonicalStoragePath);
	}
	String fileName = fileDialog.open();
	if (fileName != null && fileName.trim().length() != 0) {
	    if (canonicalStoragePath == null) {
		isAbsolute = true;
		pathField.setText("");
	    } else {
		if (fileName.startsWith(canonicalStoragePath)) {
		    isAbsolute = false;
		    int index = canonicalStoragePath.length();
		    if (fileName.length() == index) {
			fileName = "";
		    } else {
			fileName = fileName.substring(index + 1);
			index = fileName.lastIndexOf(File.separator);
			if (index > -1) {
			    String path = fileName.substring(0, index);
			    fileName = fileName.substring(index + 1);
			    pathField.setText(path);
			}
			 
		    }
		} else {
		    isAbsolute = true;
		    pathField.setText("");
		}
		fileNameField.setText(fileName);
	    }
	    
	}
    }
    
}
