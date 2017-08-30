
package org.plazmaforge.framework.client.swt.data;



/**
 * A quadruple of left, right, top and bottom SizeMeasures.
 *
 */

public final class SizeMeasureQuadruple
{
  private SizeMeasure lsize, rsize, tsize, bsize;


  public SizeMeasureQuadruple(SizeMeasure m) { lsize = m; rsize = m; tsize = m; bsize = m; }

  public SizeMeasureQuadruple(SizeMeasure h, SizeMeasure v) { lsize = h; rsize = h; tsize = v; bsize = v; }

  public SizeMeasureQuadruple(SizeMeasure l, SizeMeasure r, SizeMeasure t, SizeMeasure b) { lsize = l; rsize = r; tsize = t; bsize = b; }

  public SizeMeasureQuadruple(SizeMeasureQuadruple q) { lsize = q.lsize; rsize = q.rsize; tsize = q.tsize; bsize = q.bsize; }


  public void setAll(SizeMeasure m) { lsize = m; rsize = m; tsize = m; bsize = m; }

  public void setHorizonal(SizeMeasure m) { lsize = m; rsize = m; }

  public void setVertical(SizeMeasure m) { tsize = m; bsize = m; }

  public void setLeft(SizeMeasure m) { lsize = m; }
  public SizeMeasure getLeft() { return lsize; }

  public void setRight(SizeMeasure m) { rsize = m; }
  public SizeMeasure getRight() { return rsize; }

  public void setTop(SizeMeasure m) { tsize = m; }
  public SizeMeasure getTop() { return tsize; }

  public void setBottom(SizeMeasure m) { bsize = m; }
  public SizeMeasure getBottom() { return bsize; }


  public String toString() { return lsize + " " + rsize + " " + tsize+ " " + bsize; }
}
