package org.plazmaforge.bsolution.helloplazma.common.beans;

import org.plazmaforge.framework.ext.model.BaseEntity;

public class Hello extends BaseEntity {

    private String message;

    public Hello() {

    }


    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

}

