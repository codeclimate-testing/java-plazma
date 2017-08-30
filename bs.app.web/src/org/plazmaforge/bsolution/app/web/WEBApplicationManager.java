package org.plazmaforge.bsolution.app.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.plazmaforge.bsolution.base.ApplicationManagerExecutor;
import org.plazmaforge.bsolution.base.EnterpriseConstants;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.EntityEnvironment;
import org.plazmaforge.framework.platform.PlatfromClientApplicationManager;
import org.plazmaforge.framework.util.ErrorTranslator;
import org.plazmaforge.framework.util.IEntityManager;

public class WEBApplicationManager extends PlatfromClientApplicationManager implements EnterpriseConstants {


    protected final Log logger = LogFactory.getLog(getClass());
    
    private ApplicationManagerExecutor executor = new ApplicationManagerExecutor();

    
    
    
    protected void splashShow() throws ApplicationException {
	// EMPTY
     }
    
    protected void splashHide() throws ApplicationException {
	// EMPTY
    }
    
    protected void dialogShow() throws ApplicationException {

	// LoginDialog
	// InputDialog
	
    }
    
    protected boolean isLogin() {
	// TODO: Stub
	return true;
    }

    /*
    protected boolean isAvailableCustomParameters() {
	return EnterpriseEnvironment.isAvailableCustomParameters();
    }
    */

    protected boolean isSupportInputDialog() {
	return AppEnvironment.isInputDialog();
    }

    public void registerPackages() throws ApplicationException {
    	executor.registerPackages();
    }
    
    protected void initSystem() throws ApplicationException {
	executor.initSystem();
    }
    
    protected void loadEntities()  throws ApplicationException {
	executor.loadEntities();
    }
	
    protected void initEnvironment() throws ApplicationException {
	super.initEnvironment();
	executor.initEnvironment();
	updateStatusBar();
    }
 	
    public void updateStatusBar() {
	// NO UPDATE STATUS BAR
    }    
    
   protected void initContext() throws ApplicationException {
	
       super.initContext();
	
	// ---------------------------------------------------------------------------------------
	//
	// TODO: TEST CONTEXT INITIALIZATION
	//
	// ---------------------------------------------------------------------------------------
       
	//PathAssociationCreator associationCreator = (PathAssociationCreator) AssociationManager.getAssociationCreator();
	//associationCreator.addType(IListForm.class, "client.rich.forms", IListForm.SUFFIX);
	//associationCreator.addType(IEditForm.class, "client.rich.forms", IEditForm.SUFFIX);

	
	ErrorTranslator.setEntityManager(new IEntityManager() {
	    public String getEntityName(String id) {
		return EntityEnvironment.getEntityNameById(id);
	    }
	    public boolean isMasterEntity(String id) {
		return EntityEnvironment.isMasterEntity(id);
	    }	    
	});
	
	
	
	
	
    } 
    

}
