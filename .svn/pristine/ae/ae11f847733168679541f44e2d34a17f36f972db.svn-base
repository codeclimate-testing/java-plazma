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

package org.plazmaforge.bsolution.security.client.swt.forms;


import java.util.Date;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.base.client.SWTClientApplicationManager;
import org.plazmaforge.bsolution.contact.client.swt.forms.ContactListForm;
import org.plazmaforge.bsolution.contact.common.beans.IContactHeader;
import org.plazmaforge.bsolution.contact.common.services.ContactService;
import org.plazmaforge.bsolution.organization.client.swt.forms.OrganizationListForm;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.bsolution.security.common.beans.UserOrganization;
import org.plazmaforge.bsolution.security.common.beans.UserRole;
import org.plazmaforge.bsolution.security.common.services.UserService;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEntityProvider;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;

/** 
 * @author Oleh Hapon
 * $Id: UserEditForm.java,v 1.14 2010/12/05 07:57:22 ohapon Exp $
 */

public class UserEditForm extends AbstractEditForm {

    private Label loginLabel;
    private Label nameLabel;
    private Label currentPasswordLabel;
    private Label passwordLabel;
    private Label confirmPasswordLabel;
    private Label contactLabel;
    
    private XTextField loginField;
    private XTextField nameField;
    private XTextField currentPasswordField;
    private XTextField passwordField;
    private XTextField confirmPasswordField;
    private XComboEdit contactField;

    private Composite itemPanel;

    private Table rolesTable;
    private Table organizationsTable;
    
    private TabFolder tabFolder;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public UserEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	Composite composite;

	GridData gridData;


	setTitle(Messages.getString("UserEditForm.title")); //$NON-NLS-1$

	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
	setLayout(gridLayout);
    	
    	

    	composite = new Composite(this, SWT.NONE);
    	
    	gridLayout = new GridLayout();
       	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	composite.setLayoutData(gridData);
    	
    	int PASSWORD_LIMIT = 30; // 64
    	int FIELD_WIDTH = 250;
    	
    	loginLabel = new Label(composite, SWT.NONE);
	loginLabel.setText(Messages.getString("UserEditForm.codeLabel.text")); //$NON-NLS-1$

    	loginField = new XTextField(composite, SWT.BORDER);
    	loginField.setLayoutData(new GridData(FIELD_WIDTH, SWT.DEFAULT));
    	loginField.setTextLimit(30); //64
    	
    	nameLabel = new Label(composite, SWT.NONE);
	nameLabel.setText(Messages.getString("UserEditForm.nameLabel.text")); //$NON-NLS-1$
	
    	nameField = new XTextField(composite, SWT.BORDER);
    	nameField.setLayoutData(new GridData(FIELD_WIDTH, SWT.DEFAULT));
    	nameField.setTextLimit(30); //50

    	
    	
    	// PASSWORD: BEGIN
    	
    	currentPasswordLabel = new Label(composite, SWT.NONE);
    	currentPasswordLabel.setText(Messages.getString("UserEditForm.currentPasswordLabel.text")); //$NON-NLS-1$

    	currentPasswordField = new XTextField(composite, SWT.BORDER);
    	currentPasswordField.setLayoutData(new GridData(FIELD_WIDTH, SWT.DEFAULT));
    	currentPasswordField.getUIControl().setEchoChar('*');
    	currentPasswordField.setTextLimit(PASSWORD_LIMIT);
    	
    	
    	passwordLabel = new Label(composite, SWT.NONE);
    	passwordLabel.setText(Messages.getString("UserEditForm.passwordLabel.text")); //$NON-NLS-1$

    	passwordField = new XTextField(composite, SWT.BORDER);
    	passwordField.setLayoutData(new GridData(FIELD_WIDTH, SWT.DEFAULT));
    	passwordField.getUIControl().setEchoChar('*');
    	passwordField.setTextLimit(PASSWORD_LIMIT); 

    	confirmPasswordLabel = new Label(composite, SWT.NONE);
    	confirmPasswordLabel.setText(Messages.getString("UserEditForm.confirmPasswordLabel.text")); //$NON-NLS-1$

    	confirmPasswordField = new XTextField(composite, SWT.BORDER);
    	confirmPasswordField.setLayoutData(new GridData(FIELD_WIDTH, SWT.DEFAULT));
    	confirmPasswordField.getUIControl().setEchoChar('*');
    	confirmPasswordField.setTextLimit(PASSWORD_LIMIT);
    	
    	// PASSWORD: END
    	
    	contactLabel = new Label(composite, SWT.NONE);
    	contactLabel.setText(Messages.getString("UserEditForm.employeeLabel.text")); //$NON-NLS-1$

    	contactField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	contactField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	contactField.setValueClass(Integer.class);
    	contactField.setEntityClass(IContactHeader.class);
    	contactField.setServiceClass(ContactService.class);
    	contactField.setListFormClass(ContactListForm.class);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this, SWT.NONE, PWT.ADD_BUTTON | PWT.DELETE_BUTTON);
    	itemToolPanel.setForm(this);
  
    	createItemPanel();
    	
    	
    	this.setSize(new Point(470, 264));
    	
    	registerEntityProvider(tabFolder.getItem(0), new UserRoleProvider());
    	registerEntityProvider(tabFolder.getItem(1), new UserOrganizationProvider());

    	passwordField.getUIControl().addModifyListener(new ModifyListener() {
    	    public void modifyText(ModifyEvent e) {
    		if (!isLoadData) {
    		    return;
    		}
    		modifyPasswordField = true;
	    }
    	});
    	
    	confirmPasswordField.getUIControl().addModifyListener(new ModifyListener() {
    	    public void modifyText(ModifyEvent e) {
    		if (!isLoadData) {
    		    return;
    		}
    		modifyConfirmPasswordField = true;
	    }
    	});
    	
    	
    		
    
    }
    
    private boolean modifyPasswordField;
    private boolean modifyConfirmPasswordField;
    private boolean modifyPassword;
    
    
    protected void bindControls() {
	bindControl(loginField, "login");
	bindControl(nameField, "name", nameLabel, REQUIRED);
    }

    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
	
        TableColumn newColumnTableColumn;
        GridLayout gridLayout;

        TabItem rolesTabItem;
        TabItem organizationsTabItem;
               
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 120;
        itemPanel = new Composite(this, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        itemPanel.setLayout(gridLayout);
        itemPanel.setLayoutData(gridData);
        

        
        tabFolder = new TabFolder(itemPanel, SWT.NONE);
        tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        rolesTabItem = new TabItem(tabFolder, SWT.NONE);
        rolesTabItem.setText(Messages.getString("UserEditForm.rolesTabItem.text")); //$NON-NLS-1$

         
        //rolesTable = new Table(itemPanel, SWTToolkit.TABLE_STYLE);
        rolesTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        rolesTable.setHeaderVisible(true);
        rolesTable.setLinesVisible(true);
        rolesTabItem.setControl(rolesTable);
        
        //rolesTable.setLayoutData(gridData2);

        newColumnTableColumn = new TableColumn(rolesTable, SWT.NONE);
        newColumnTableColumn.setWidth(300);
        newColumnTableColumn.setText(Messages.getString("UserEditForm.nameTableColumn.text")); //$NON-NLS-1$

        
        
        
        
        organizationsTabItem = new TabItem(tabFolder, SWT.NONE);
        organizationsTabItem.setText(Messages.getString("UserEditForm.organizationsTabItem.text")); //$NON-NLS-1$

         
        organizationsTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        organizationsTable.setHeaderVisible(true);
        organizationsTable.setLinesVisible(true);
        organizationsTabItem.setControl(organizationsTable);
        
        newColumnTableColumn = new TableColumn(organizationsTable, SWT.NONE);
        newColumnTableColumn.setWidth(300);
        newColumnTableColumn.setText(Messages.getString("UserEditForm.nameTableColumn.text")); //$NON-NLS-1$

        
    }

    
    
    protected User getUser() {
	return (User) getEntity();
    }
    
    protected class UserRoleProvider extends TableEntityProvider {
	
	public UserRoleProvider() {
	    setParentEntityClass(User.class);
	    setListProperty("userRoleList");
	    setAddMethod("addUserRole");
	    
	    setEntityClass(UserRole.class);
	    setSupportEditForm(false);
	}
	
	public IEditForm getEditForm() {
	    return null;
	}
	
	protected Table getTable() {
	    return rolesTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "roleName");
	    
	}
	
	
	
    }
    
    protected class UserOrganizationProvider extends TableEntityProvider {
	
	public UserOrganizationProvider() {
	    setParentEntityClass(User.class);
	    setListProperty("userOrganizationList");
	    setAddMethod("addUserOrganization");
	    setEntityClass(UserOrganization.class);
	    setSupportEditForm(false);
	}
	
	public IEditForm getEditForm() {
	    return null;
	}

	protected Table getTable() {
	    return organizationsTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "organizationName");
	    
	}
	
	
	
    }
    
    
    public void doItemAddAction()  throws ApplicationException {
	
	IEntityProvider provider = getSelectedEntityProvider();
	if (provider instanceof UserRoleProvider) {
	    doItemAddListForm(RoleListForm.class);
	} else if (provider instanceof UserOrganizationProvider) {
	    doItemAddListForm(OrganizationListForm.class);
	}
	
	
    }
   
    
    public void doItemEditAction()  throws ApplicationException {
	
    }
    
    
    protected Object getItemEntityFromListForm(IListForm listForm) {
	
	Object entity = super.getItemEntityFromListForm(listForm);
	if (entity == null) {
	    return null;
	}
	
	if (listForm instanceof RoleListForm) {

	    Role role = (Role) entity;
	    if (getUser().isExistRole(role)) {
		openMessageDialog(Messages.getString("UserEditForm.duplicateRole") + " [" + role.getName() + "]");
		return null;
	    }

		
	    // SPECIFY FOR USER ROLE
	    UserRole userRole = new UserRole();
	    userRole.setRole(role);
		
	    return userRole;

	    
	    
	    
	} else if (listForm instanceof OrganizationListForm) {

	    OrganizationHeader organization = (OrganizationHeader) entity;
	    Integer organizationId = organization.getId();
	    String organizationName = organization.getName();
	    
	    if (getUser().isExistOrganization(organizationId)) {
		openMessageDialog(Messages.getString("UserEditForm.duplicateOrganization") + " [" + organization.getName() + "]");
		return null;
	    }

		
	    // SPECIFY FOR USER ORGANIZATION
	    UserOrganization userOrganization = new UserOrganization();
	    userOrganization.setOrganizationId(organizationId);
	    userOrganization.setOrganizationName(organizationName);
		
	    return userOrganization;

	}
	

	return entity;


    }
    
    protected Object getSelectedEntityProviderKey() {
        int index = tabFolder.getSelectionIndex();
        return tabFolder.getItem(index);
    }
    
    
    protected void initData() throws ApplicationException {
	getUser().setRegDate(new Date());
    }
    
    private boolean isLoadData;
    
    protected void beforeUpdateForm() throws ApplicationException {
	setVisibleControl(currentPasswordLabel, !isNewMode());
	setVisibleControl(currentPasswordField, !isNewMode());
	
	if (isNewMode()) {
    	    passwordLabel.setText(Messages.getString("UserEditForm.passwordLabel.text"));
    	} else {
    	    initNoEditableField(loginField);
    	    passwordLabel.setText(Messages.getString("UserEditForm.newPasswordLabel.text"));
    	}
	layout();
    }
    
    protected void afterUpdateForm() throws ApplicationException {
	isLoadData = true;
	contactField.setValue(getContactById(getUser().getContactId()));
    }

       
    protected void afterUpdateData() throws ApplicationException {
	IContactHeader contact = (IContactHeader) contactField.getValue();
	getUser().setContactId(contact == null ? null : contact.getId());
	
	if (!isModifyPassword()) {
	    return;
	}
	getUser().setChangePassword(true);
	getUser().setPassword(passwordField.getText().trim());
    }
    
    protected void afterStoreData() throws ApplicationException {
	
	if (isNewMode()) {
	    return;
	}
	
	User user = getUser();
	
	// If modify user is current user then update user in system
	SessionContext context = SessionEnvironment.getContext();
	if (!context.isCurrentUser(user)) {
	    return;
	}
	
	// Get user form DB and update user
	user = getUserService().findById(user.getId());
	EnterpriseEnvironment.updateUser(user);
	
	// Update UI (status bar)
	SWTClientApplicationManager manager = new SWTClientApplicationManager();
    	manager.updateStatusBar();
	
    }
    
    
    protected void validateControls(StringBuffer buf) throws ApplicationException {
	modifyPassword = false;
	
	String login = loginField.getText().trim();
	validateLogin(buf, login);
	
	super.validateControls(buf);
	
	String currentPassword = getCurrentPassword();
	String password = getPassword();
	String confirmPassword = getConfirmPassword();
	
	if (isNewMode() || (isModifyAllPasswordFields() && !isAllPasswordsEmpty(password, confirmPassword))) {
	    modifyPassword = true;
	}
	if (modifyPassword) {
	    if (!isNewMode()) {
		validateCurrentPassword(buf, login, currentPassword);
	    }
	    validatePasswords(buf, password, confirmPassword);
	}
	
	validateEmptyRoles(buf);
    }

    private boolean validateCurrentPassword(StringBuffer buf, String login, String currentPassword) throws ApplicationException {
	if (isEmpty(currentPassword) || !getUserService().existsPassword(login, currentPassword)) {
	    addError(buf, Messages.getString("UserEditForm.passwordNotFound"));
	    return false;
	}
	return true;
    }
    
    
    private boolean validatePasswords(StringBuffer buf, String password, String confirmPassword) {
	if (isEmpty(password)) {
	    addRequiredFieldError(buf, passwordLabel.getText());
	    return false;
	} else if (isEmpty(confirmPassword)) {
	    addError(buf, Messages.getString("UserEditForm.passwordsNotMatch"));
	    return false;
	}
	if (!validatePassword(buf, password)) {
	    return false;
	}
	if (!StringUtils.equals(password, confirmPassword)) {
	    addError(buf, Messages.getString("UserEditForm.passwordsNotMatch"));
	    return false;
	}
	return true;
    }

    private boolean validateLogin(StringBuffer buf, String login) throws ApplicationException {
	
	if (!isNewMode()) {
	    return true;
	}
	
	if (isEmpty(login)) {
	    addRequiredFieldError(buf, loginLabel.getText());
	    return false;
	}
	
	if (getUserService().existsUser(login)) {
	    addError(buf, Messages.getString("UserEditForm.duplicateLogin"));
	    return false;
	}
	
	// TODO Must validate login
	return true;
    }

    private boolean validatePassword(StringBuffer buf, String password) {
	
	// TODO Must validate password
	return true;
    }
    
 
    private boolean isModifyPasswordField() {
	return modifyPasswordField;
    }
    
    private boolean isModifyConfirmPasswordField() {
	return modifyConfirmPasswordField;
    }

    private boolean isModifyAllPasswordFields() {
	return isModifyPasswordField() || isModifyConfirmPasswordField();
    }
	
    private boolean isAllPasswordsEmpty(String password, String confirmPassword) {
	return isEmpty(password) && isEmpty(confirmPassword);
    }
    
    private boolean isModifyPassword() {
	return modifyPassword;
    }


    private String getCurrentPassword() {
	return currentPasswordField == null ? null : currentPasswordField.getText().trim();
    }

    private String getPassword() {
	return passwordField.getText().trim();
    }
    
    private String getConfirmPassword() {
	return confirmPasswordField.getText().trim();
    }

    
    private void validateEmptyRoles(StringBuffer buf) {
	if (getUser().isEmptyUserRoles()) {
	    addError(buf, Messages.getString("UserEditForm.noRoles"));
	}
    }

    private UserService getUserService() {
	return (UserService) getEntityService();
    }

    private IContactHeader getContactById(Integer contactId) throws ApplicationException {
	if (contactId == null) {
	    return null;
	}
	return getContactService().findById(contactId);
    }

    private ContactService getContactService() {
	return (ContactService) getService(ContactService.class);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"


