
package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.awt.Color;


public class Pen {

    public static final byte LINE_STYLE_SOLID  = 0;
    public static final byte LINE_STYLE_DASHED = 1;
    public static final byte LINE_STYLE_DOTTED = 2;
    public static final byte LINE_STYLE_DOUBLE = 3;

    
    private double lineWidth;
    
    private byte lineStyle = LINE_STYLE_SOLID;
    
    private Color lineColor;

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public byte getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(byte lineStyle) {
        this.lineStyle = lineStyle;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
    
    
    
    
}
