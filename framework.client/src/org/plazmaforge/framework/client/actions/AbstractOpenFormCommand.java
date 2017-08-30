package org.plazmaforge.framework.client.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.AssociationManager;

public abstract class AbstractOpenFormCommand {
    

    public void execute(String command) throws ApplicationException {
	
	// If empty command then return
	if (command == null) {
	    return;
	}
	
	
	StringTokenizer t = new StringTokenizer(command, ", :;");
	int k = -1;
	String formName = null;
	String formPackage = null;
	List<String> arguments = new ArrayList<String>();
	while (t.hasMoreTokens()) {
	    k++;
	    String token = t.nextToken();
	    if (k == 0) {
		//formName = token;
		int pos = token.indexOf("/");
		
		if (pos < 0) {
		    // "/" not found - use simple form name
		    formName = token;
		} else {
		    if (pos != 0) {
			// "/" is not first position
			formPackage = token.substring(0, pos);
		    }
		    if (pos < token.length()) {
			// "/" is not last position
			formName = token.substring(pos + 1);
		    }
		}
		if (formName == null) {
		    break;
		}
	    } else {
		arguments.add(token);
	    }
	}
	
	// If no arguments then return
	if (formName == null) {
	    return;
	}
	
	Serializable identifier = null;
	identifier = getIdentifier(arguments);
	
	Class formClass = getFormClass(formPackage, formName); // AssociationManager.getAssociationCreator().createElement(formPackage, formName, IListForm.class);
	
	if (formClass == null) {
	    throw new ApplicationException("Form [" + formName + "] not found.\nCommand: [" + command + "]");
	}
	
	
	// disable: 2010-04-20 because it does't work
	// problem with association id
	// For example UserListForm -> User -> USER, but it is not SYS_USER
	
	checkForm(formClass);
	
	if (Toolkit.activeListForm(formClass, identifier)) {
	    return;
	}
	IForm form = getForm(formClass);
	
	if (form == null) {
	    throw new ApplicationException("Error intialization form [" + formClass + "].\nCommand: [" + command + "]");
	}
	
	
	form.setIdentifier(identifier);
	form.setArguments(arguments);
	Toolkit.openForm(null, form);
	
	
    }
    
    protected IForm getForm(Class formClass) throws ApplicationException {
	return Toolkit.getForm(null, formClass, getFormType());
    }

    protected Class getFormClass(String formPackage, String formName) {
	if (formName == null) {
	    return null;
	}
	
	// If package is null we use form name as form class
	if (formPackage == null) {
	    return Toolkit.getFormClass(formName);
	}
	
	// if package is not null we use association for create form class 
	return AssociationManager.getAssociationCreator().createElement(formPackage, formName, getFormTypeClass());
    }
    
    protected Serializable getIdentifier(List<String> arguments) {
	if (arguments == null || arguments.size() == 0) {
	    return null;
	}
	StringBuffer buf = new StringBuffer();
	for (int i = 0; i < arguments.size(); i++) {
	    if (i > 0) {
		buf.append(",");
	    }
	    buf.append(arguments.get(i));
	}
	return buf.toString();
    }
    
    
     
    protected void checkForm(Class formClass) throws ApplicationException {
	Toolkit.checkSecureForm(formClass);
    }

    protected abstract Class getFormTypeClass();
    
    protected abstract int getFormType();
}
