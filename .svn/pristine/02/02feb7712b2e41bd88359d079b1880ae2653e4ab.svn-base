package org.plazmaforge.bsolution.organization.client.swing.forms;


import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.organization.client.swing.GUIOrganizationEnvironment;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.bsolution.organization.common.services.OrganizationService;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerEdit;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.framework.app.IAppManager;
import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.forms.EditableMode;
import org.plazmaforge.framework.client.swing.forms.ListableMode;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.PlatfromClientApplicationManager;

/**
 * @author Oleh Hapon
 * Date: 28.05.2006
 * Time: 10:13:27
 * $Id: OrganizationList.java,v 1.2 2010/12/05 07:56:45 ohapon Exp $
 */
public class OrganizationList extends EXTListForm {

    public OrganizationList() throws ApplicationException {
        super(GUIOrganizationEnvironment.getResources());
        initialize();
    }

    public OrganizationList(Window window) throws ApplicationException {
        super(window, GUIOrganizationEnvironment.getResources());
        initialize();
    }

    private void initialize() {
        this.setEntityClass(OrganizationHeader.class);
        this.setEntityServiceClass(OrganizationService.class);
        this.setEntityEditFormClass(PartnerEdit.class);
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
        List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table.column-code.name"));
        d.setFieldName("code");
        d.setColumnClass(String.class);
        d.setSize(10);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-name.name"));
        d.setFieldName("name");
        d.setColumnClass(String.class);
        d.setSize(40);
        columns.add(d);


        return columns;
    }

    int mode;
    
    public void doEditCommand(int mode) throws ApplicationException {
    	this.mode = mode;

        if (mode == EditableMode.EDIT) {
            super.doEditCommand(mode);
            return;
        }

        // Add new Organization
        PartnerList partnerList = (PartnerList) getLIST(PartnerList.class, SwingEnvironment.getFrame(), ListableMode.CHOOSE);
        PartnerHeader partner = (PartnerHeader) partnerList.showList();
        if (partner == null) {
            return;
        }
        Integer id = partner.getId();
        ((OrganizationService) getEntityService()).addOrganizationToSystem(id);

        doRefreshRow(true, id, mode);

    }

    protected void afterEditForm(EditForm editForm)  throws ApplicationException {
    	super.afterEditForm(editForm);
    	if (this.mode != EditableMode.EDIT) {
    		return;
    	}
    	Partner partner = (Partner) editForm.getEntity();
    	if (partner == null) {
    		return;
    	}
    	Integer id = partner.getId();
    	if (id == null) {
    		return;
    	}
    	SessionContext context = SessionEnvironment.getContext();
    	if (id.equals(EnterpriseEnvironment.getOrganizationId(context))) {
	    EnterpriseEnvironment.loadOrganization(context);
	    IAppManager manager = SwingEnvironment.getApplication().getAppManager();
	    if (manager != null && manager instanceof PlatfromClientApplicationManager) {
		((PlatfromClientApplicationManager) manager).updateStatusBar();
	    }
	}
    }    

}
