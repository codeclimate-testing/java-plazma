
package org.plazmaforge.framework.client.swt.data;


/**
 * Contains a decoded size which can depend on "em" and "%" measures.
 * 
 */

public final class SizeMeasure
{
  public final double baseSize;
  public final double emFactor;
  public final double scaleFactor;

  
  public SizeMeasure(double baseSize, double emFactor, double scaleFactor)
  {
    this.baseSize = baseSize;
    this.emFactor= emFactor;
    this.scaleFactor = scaleFactor;
  }
  
  
  public SizeMeasure(double baseSize)
  {
    this.baseSize = baseSize;
    this.emFactor= 0.0;
    this.scaleFactor = 0.0;
  }
  
  
  public int compute(int emSize, int scaleSize)
  {
    double d = baseSize + (emFactor * emSize);
    if(scaleSize > 0) d += (scaleFactor * scaleSize);
    if(d < 0) return (int)(d - 0.5);
    else return (int)(d + 0.5);
  }

  
  public int compute(int emSize)
  {
    return compute(emSize, 0);
  }

  
  public String toString()
  {
    if(scaleFactor != 0) return (scaleFactor*100)+"%";
    else if(emFactor != 0) return emFactor+"em";
    else return baseSize+"px";
  }
}
