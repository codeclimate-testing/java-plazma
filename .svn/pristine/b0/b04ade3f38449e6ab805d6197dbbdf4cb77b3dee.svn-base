
package org.plazmaforge.framework.client.swt.custom.ishell.internal;

import java.util.ResourceBundle;


/**
 * Manages the localized strings for the InternalShell implementation.
 *
 */

public class LocalizedStrings
{
  public static final String POPUP_RESTORE  = "popup.restore";
  public static final String POPUP_MOVE     = "popup.move";
  public static final String POPUP_SIZE     = "popup.size";
  public static final String POPUP_MINIMIZE = "popup.minimize";
  public static final String POPUP_MAXIMIZE = "popup.maximize";
  public static final String POPUP_CLOSE    = "popup.close";


  private static final ResourceBundle b = loadResourceBundle();


  private static ResourceBundle loadResourceBundle()
  {
    String name = LocalizedStrings.class.getName();
    name = name.substring(0, name.lastIndexOf('.'));
    name += ".strings";
    return ResourceBundle.getBundle(name);
  }


  public static String get(String key)
  {
    return b.getString(key);
  }
}
