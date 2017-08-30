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
public class GradientPercentPainter {

    private int x;

    private int y;

    private int width;

    private int height;

    private Color gradientColor;

    private float percent;

    public GradientPercentPainter() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getGradientColor() {
        if (gradientColor == null) {
            gradientColor = Color.LIGHT_GRAY;
        }
        return gradientColor;
    }

    public void setGradientColor(Color gradientColor) {
        this.gradientColor = gradientColor;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    protected String getPercentString() {
        return "" + (int) percent + " %";
    }

    public void paint(Graphics g) {


        int gw = 0;
        if (getPercent() > 100) {
            gw = getWidth();
        } else if (getPercent() >= 0 && getPercent() <= 100) {
            gw = (int) ((float) getWidth() / 100 * getPercent());
        }
        Color color = g.getColor();
        g.setColor(getGradientColor());
        g.fillRect(getX(), getY(), getX() + gw, getY() + getHeight());
        g.setColor(color);

        paintString(g);

    }

    public void paintString(Graphics g) {
        int xd = 10; // TODO: STUB
        int yd = 10; // TODO: STUB
        int xt = getWidth() - xd;
        int yt = getHeight() - yd;
        xt = (int) (getX() +  (float) xt / 2);
        yt = (int) (getY() + (float) yt / 2 + yd);
        g.drawString(getPercentString(), xt, yt);
    }

}
