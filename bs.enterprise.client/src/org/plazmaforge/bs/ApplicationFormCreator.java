package org.plazmaforge.bs;

import org.plazmaforge.framework.core.data.Customizer;
import org.plazmaforge.framework.core.data.object.Creator;
import org.plazmaforge.framework.uwt.form.IForm;

public abstract class ApplicationFormCreator implements Creator {
    
    
    
    private Customizer formCustomirer;
    
    public ApplicationFormCreator(Customizer formCustomirer) {
	super();
	this.formCustomirer = formCustomirer;
    }

    public Object create(String type) {
	IForm<?> form = createForm(type);
	if (form == null) {
	    return null;
	}
	//form.init();
	customizeForm(form);
	return form;
    }
    
    protected abstract IForm<?> createForm(String type);
    
    protected void customizeForm(IForm<?> form) {
	if (formCustomirer == null) {
	    return;
	}
	formCustomirer.customize(form);
    }

}
