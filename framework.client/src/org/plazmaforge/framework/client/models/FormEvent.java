package org.plazmaforge.framework.client.models;

import java.util.EventObject;

import org.plazmaforge.framework.client.forms.IForm;

public class FormEvent extends EventObject {

    public FormEvent(IForm form) {
	super(form);
    }

    public IForm getForm() {
	return (IForm) getSource();
    }
}
