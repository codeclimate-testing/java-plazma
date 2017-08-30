
package org.plazmaforge.framework.client.swt.custom.ishell.internal;

import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.widgets.Event;


/**
 * A listener which receives events when a change occurs on a DesktopForm.
 *
 */

public interface DesktopListener extends SWTEventListener
{
  public void shellCreated(Event event);
  
  public void shellDisposed(Event event);
  
  public void shellActivated(Event event);
}
