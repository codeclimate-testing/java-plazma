package org.plazmaforge.bsolution.base.client.swing.actions;

import java.awt.event.ActionEvent;

import org.plazmaforge.bsolution.base.client.swing.forms.PermissionList;
import org.plazmaforge.bsolution.base.client.swing.forms.RoleList;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.forms.ListableMode;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class PermissionListAction extends GUIBaseAction {

    public void perform(ActionEvent e) throws ApplicationException {

	RoleList roleList = new RoleList(SwingEnvironment.getFrame());
	roleList.setCenter(true);
	Role role = (Role) roleList.showList();

	if (role == null) {
	    return;
	}

	PermissionList permissionList = new PermissionList(SwingEnvironment
		.getFrame());
	permissionList.initListableMode(ListableMode.LIST);
	permissionList.setRole(role);
	permissionList.setCenter(true);
	permissionList.showList();

	// GUIAppFormManager.showListForm(PermissionList.class);
    }
}
