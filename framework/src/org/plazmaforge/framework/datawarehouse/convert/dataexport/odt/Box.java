
package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

public class Box {
    
    private int topPadding;
    
    private int leftPadding;
    
    private int bottomPadding;
    
    private int rightPadding;

    
    private Pen topPen;
    
    private Pen leftPen;
    
    private Pen bottomPen;
    
    private Pen rightPen;
		
    public int getBottomPadding() {
        return bottomPadding;
    }

    public void setBottomPadding(int bottomPadding) {
        this.bottomPadding = bottomPadding;
    }

    public int getLeftPadding() {
        return leftPadding;
    }

    public void setLeftPadding(int leftPadding) {
        this.leftPadding = leftPadding;
    }

    public int getRightPadding() {
        return rightPadding;
    }

    public void setRightPadding(int rightPadding) {
        this.rightPadding = rightPadding;
    }

    public int getTopPadding() {
        return topPadding;
    }

    public void setTopPadding(int topPadding) {
        this.topPadding = topPadding;
    }

    public Pen getBottomPen() {
        return bottomPen;
    }

    public void setBottomPen(Pen bottomPen) {
        this.bottomPen = bottomPen;
    }

    public Pen getLeftPen() {
        return leftPen;
    }

    public void setLeftPen(Pen leftPen) {
        this.leftPen = leftPen;
    }

    public Pen getRightPen() {
        return rightPen;
    }

    public void setRightPen(Pen rightPen) {
        this.rightPen = rightPen;
    }

    public Pen getTopPen() {
        return topPen;
    }

    public void setTopPen(Pen topPen) {
        this.topPen = topPen;
    }

    
}
