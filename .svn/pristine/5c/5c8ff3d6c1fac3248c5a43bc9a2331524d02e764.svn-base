/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 *
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

package org.plazmaforge.framework.client.swing.controls;

import java.awt.*;

/**
 * Created 23.05.2006
 */
public class XGradientPercentLabel extends XLabel {
    
    private GradientPercentPainter painter = new GradientPercentPainter();

    public XGradientPercentLabel() {

    }

    public void paint(Graphics g) {

        painter.setX(this.getX());
        painter.setX(this.getY());
        painter.setWidth(this.getWidth());
        painter.setHeight(this.getHeight());

        painter.paint(g);
    }

    public Color getGradientColor() {
        return painter.getGradientColor();
    }

    public void setGradientColor(Color gradientColor) {
        painter.setGradientColor(gradientColor);
    }

    public float getPercent() {
        return painter.getPercent();
    }

    public void setPercent(float percent) {
        painter.setPercent(percent);
    }


}
