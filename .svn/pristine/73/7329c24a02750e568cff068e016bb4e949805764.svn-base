
package org.plazmaforge.framework.client.swt.layout;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.plazmaforge.framework.client.swt.SWTUtils;
import org.plazmaforge.framework.client.swt.data.DataDecoder;
import org.plazmaforge.framework.client.swt.data.IntFraction;
import org.plazmaforge.framework.client.swt.data.SizeMeasure;



/**
 * A utility class which creates SWT FormData objects from simple string
 * descriptions.
 *
 */

public class FormDataCreator
{
  private static final SizeMeasure DEFAULT_HINT     = new SizeMeasure(SWT.DEFAULT);
  private static final SizeMeasure DEFAULT_OFFSET   = new SizeMeasure(0);
  private static final IntFraction DEFAULT_FRACTION = new IntFraction(0, 1);


  public enum FormDataAlignment
  {
    DEFAULT (SWT.DEFAULT), TOP (SWT.TOP), BOTTOM (SWT.BOTTOM), LEFT (SWT.LEFT), RIGHT (SWT.RIGHT), CENTER (SWT.CENTER);
    
    public final int style;
    FormDataAlignment(int style) { this.style = style; }
  };
  
  
  private Composite parent;
  private int embase;
  private HashMap<String, Control> siblings;

  
  public FormDataCreator(Composite parent)
  {
    this.parent = parent;
    this.embase = SWTUtils.computeEMBase(parent);
  }
  
  
  public FormDataCreator put(String name, Control control)
  {
    if(siblings == null) siblings = new HashMap<String, Control>();
    siblings.put(name, control);
    return this;
  }
  
  
  public FormDataCreator layout(Control control, String spec, String width, String height)
  {
    Control[] siblingsList = parent.getChildren();
    int siblingsIndex = 0;
    for(int i=0; i<siblingsList.length; i++)
    {
      if(siblingsList[i] == control)
      {
        siblingsIndex = i;
        break;
      }
    }
    FormData fd = createFormData(embase, spec, null, null, null, null, width, height, siblings, siblingsList, siblingsIndex);
    control.setLayoutData(fd);
    return this;
  }

  
  public FormDataCreator layout(Control control, String spec)
  {
    return layout(control, spec, null, null);
  }


  public static FormData createFormData(Control control, String spec, String width, String height) 
  {
    int siblingsIndex = 0;
    Composite parent = control.getParent();
    Control[] children = parent.getChildren();
    for(int i=0; i<children.length; i++)
    {
      if(children[i] == control)
      {
        siblingsIndex = i;
        break;
      }
    }
    return createFormData(SWTUtils.computeEMBase(parent), spec, null, null, null, null, width, height, null, children, siblingsIndex);
  }


  public static FormData createFormData(Control control, String spec)
  {
    return createFormData(control, spec, null, null);
  }


  public static FormData createFormData(int embase, String spec, String left, String right, String top, String bottom, String width, String height, Map<String, Control> siblings, Control[] siblingsList, int siblingsIndex) 
  {
    if(spec != null && spec.length() > 0)
    {
      String[] specParts = DataDecoder.decodeStringArray(spec, ",", true, false);
      if(specParts.length > 0)
      {
        if(left == null) left = specParts[0];
        if(specParts.length > 1)
        {
          if(right == null) right = specParts[1];
          if(specParts.length > 2)
          {
            if(top == null) top = specParts[2];
            if(specParts.length > 3)
            {
              if(bottom == null) bottom = specParts[3];
            }
          }
        }
      }
    }
    int widthInt  = DataDecoder.decodeLength(width, DEFAULT_HINT).compute(embase);
    int heightInt = DataDecoder.decodeLength(height, DEFAULT_HINT).compute(embase);
    FormData data = new FormData(widthInt, heightInt);
    data.left   = FormDataCreator.createFormAttachment(left,   embase, siblings, siblingsList, siblingsIndex);
    data.right  = FormDataCreator.createFormAttachment(right,  embase, siblings, siblingsList, siblingsIndex);
    data.top    = FormDataCreator.createFormAttachment(top,    embase, siblings, siblingsList, siblingsIndex);
    data.bottom = FormDataCreator.createFormAttachment(bottom, embase, siblings, siblingsList, siblingsIndex);

    return data;
  }

  
  private static FormAttachment createFormAttachment(String combined, int embase, Map<String, Control> siblings, Control[] siblingsList, int siblingsIndex) 
  {
    String controlID = null;
    String pos       = null;
    String offset    = null;
    String align     = null;

    if(combined != null)
    {
      StringTokenizer tok = new StringTokenizer(combined, "+-", true);
      String prefix = null;
      while(tok.hasMoreTokens())
      {
        String token = tok.nextToken();
        if(token.equals("+") || token.equals("-")) prefix = token;
        else
        {
          token = token.trim();
          if(prefix != null)
          {
            token = prefix + token;
            prefix = null;
          }
          if(token.length() == 0) continue;
          else
          {
            char c0 = token.charAt(0);
            if((c0 == '+' || c0 == '-' || Character.isDigit(c0)) && Character.isLetter(token.charAt(token.length()-1)))
              offset = token;
            else
            {
              if(token.startsWith("+")) token = token.substring(1);
              if(Character.isDigit(token.charAt(0))) pos = token;
              else
              {
                int sep = token.lastIndexOf(':');
                if(sep > 0)
                {
                  controlID = token.substring(0, sep);
                  align = token.substring(sep+1);
                }
                else controlID = token;
              }
            }
          }
        }
      }
    }

    if(controlID == null && pos == null && offset == null && align == null) return null;
    
    FormAttachment fa = new FormAttachment(0);

    fa.offset = DataDecoder.decodeLength(offset, DEFAULT_OFFSET).compute(embase);
    if(pos == null)
    {
      if(controlID == null || controlID.length() != 0)
      {
        fa.numerator   = fa.offset < 0 ? 1 : 0;
        fa.denominator = 1;
      }
    }
    else
    {
      IntFraction fraction = DataDecoder.decodeFraction(pos, DEFAULT_FRACTION);
      fa.numerator   = fraction.numerator;
      fa.denominator = fraction.denominator;
    }
    fa.alignment = DataDecoder.decodeEnum(align, FormDataAlignment.class, FormDataAlignment.DEFAULT).style;
    if(controlID != null && controlID.length() != 0)
    {
      if(controlID.equals(":prev"))
      {
        if(siblingsIndex > 0 && siblingsList != null) fa.control = siblingsList[siblingsIndex-1];
      }
      else if(controlID.equals(":next"))
      {
        if(siblingsList != null && siblingsIndex < siblingsList.length-1) fa.control = siblingsList[siblingsIndex+1];
      }
      else if(siblings != null)
      {
        fa.control = siblings.get(controlID);
      }
    }

    return fa;    
  }
}
