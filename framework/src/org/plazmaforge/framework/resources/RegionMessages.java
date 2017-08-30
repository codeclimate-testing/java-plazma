package org.plazmaforge.framework.resources;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class RegionMessages {

    
    
    public static final String IDN_KEY = "idn";
    
    public static final String COMPANY_IDN_KEY = "company.idn";
    
    public static final String PERSON_IDN_KEY = "person.idn";
    
    public static final String NEC_KEY = "nec";
    
    public static final String SWIFT_KEY = "swift";
    
    public static final String BIC_KEY = SWIFT_KEY;
    
    
    
    
    
    private static final String BUNDLE_NAME = "org.plazmaforge.framework.resources.region"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private RegionMessages() {
    }

    public static String getString(String key) {
	try {
	    return RESOURCE_BUNDLE.getString(key);
	} catch (MissingResourceException e) {
	    return "!" + key + "!";
	}
    }
}
