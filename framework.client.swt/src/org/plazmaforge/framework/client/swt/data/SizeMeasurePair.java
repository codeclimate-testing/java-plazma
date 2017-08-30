
package org.plazmaforge.framework.client.swt.data;



/**
 * A pair of one horizontal and one vertical SizeMeasure.
 *
 */

public final class SizeMeasurePair
{
  private SizeMeasure hsize, vsize;


  public SizeMeasurePair(SizeMeasure m) { hsize = m; vsize = m; }

  public SizeMeasurePair(SizeMeasure h, SizeMeasure v) { hsize = h; vsize = v; }

  public SizeMeasurePair(SizeMeasurePair p) { hsize = p.hsize; vsize = p.vsize; }


  public void setAll(SizeMeasure m) { hsize = m; vsize = m; }
  
  public void setHorizonal(SizeMeasure m) { hsize = m; }
  public SizeMeasure getHorizonal() { return hsize; }

  public void setVertical(SizeMeasure m) { vsize = m; }
  public SizeMeasure getVertical() { return vsize; }
  
  
  public String toString() { return hsize + " " + vsize; }
}
