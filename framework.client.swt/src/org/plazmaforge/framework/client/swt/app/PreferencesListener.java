package org.plazmaforge.framework.client.swt.app;

import java.util.Properties;

public interface PreferencesListener {

    void loadPreferences(Properties preferences);
    
    void storePreferences(Properties preferences);
    
    void modifyPreferences(Properties preferences);
}
