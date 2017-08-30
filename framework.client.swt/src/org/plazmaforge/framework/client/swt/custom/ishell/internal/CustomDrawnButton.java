
package org.plazmaforge.framework.client.swt.custom.ishell.internal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


/**
 * A simple button control which needs to be subclassed to draw a specific
 * kind of button. This base class provides the event handling.
 * 
 */

public abstract class CustomDrawnButton extends Canvas
{
  private boolean pressed;
  private final Display display;
  private boolean drawnMouseIn = false;


  public CustomDrawnButton(Composite parent, int style)
  {
    super(parent, style);
    this.display = getDisplay();

    addListener(SWT.Paint, new Listener()
    {
      public void handleEvent(Event event)
      {
        boolean mouseIn = mouseIn();
        onPaint(event, pressed && mouseIn);
        drawnMouseIn = mouseIn;
      }
    });

    addListener(SWT.MouseDown, new Listener()
    {
      public void handleEvent(Event event)
      {
        if(event.button == 1)
        {
          pressed = true;
          redraw();
        }
        else if(event.button == 3 && (event.stateMask & SWT.BUTTON1) != 0) // chord click
        {
          pressed = false;
          redraw();
        }
      }
    });

    addListener(SWT.MouseUp, new Listener()
    {
      public void handleEvent(Event event)
      {
        if(pressed && (event.stateMask & SWT.BUTTON1) != 0)
        {
          pressed = false;
          if(mouseIn())
          {
            Event selectionEvent = new Event();
            notifyListeners(SWT.Selection, selectionEvent);
          }
          if(!isDisposed()) redraw();
        }
      }
    });
    
    addListener(SWT.MouseMove, new Listener()
    {
      public void handleEvent(Event event)
      {
        if(!pressed) return;
        boolean mouseIn = mouseIn();
        if(mouseIn == drawnMouseIn) return;
        redraw();
      }
    });
  }
  
  
  private boolean mouseIn()
  {
    Point p = toControl(display.getCursorLocation());
    if(p.x < -1 || p.y < -1) return false;
    Point size = getSize();
    return p.x <= size.x+1 && p.y <= size.y+1;
  }


  public Point computeSize(int wHint, int hHint, boolean changed)
  {
    checkWidget();
    if(wHint == SWT.DEFAULT) wHint = 0;
    if(hHint == SWT.DEFAULT) hHint = 0;
    return new Point(wHint, hHint);
  }


  public boolean setFocus()
  {
    checkWidget();
    return false;
  }


  public boolean isReparentable ()
  {
    checkWidget();
    return false;
  }
  
  
  protected abstract void onPaint(Event event, boolean pressed);
}
