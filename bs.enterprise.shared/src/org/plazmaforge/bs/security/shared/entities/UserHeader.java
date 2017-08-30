package org.plazmaforge.bs.security.shared.entities;

import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * 
 * @author ohapon
 *
 */
public class UserHeader extends BaseEntity {

    private static final long serialVersionUID = -2870977736188950857L;

    private String name;

    private String login;
    
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }
    
}
