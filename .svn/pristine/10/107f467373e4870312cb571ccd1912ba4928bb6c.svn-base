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

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;

import org.plazmaforge.framework.util.SystemBrowser;


public class XLinkLabel extends XLabel {

    private String link;

    public XLinkLabel(String text, Icon icon, int horizontalAlignment) {
	super(text, icon, horizontalAlignment);
	initialize();
    }

    public XLinkLabel(String text, int horizontalAlignment) {
	super(text, horizontalAlignment);
	initialize();
    }

    public XLinkLabel(String text) {
	super(text);
	initialize();
    }

    public XLinkLabel(Icon image, int horizontalAlignment) {
	super(image, horizontalAlignment);
	initialize();
    }

    public XLinkLabel(Icon image) {
	super(image);
	initialize();
    }

    public XLinkLabel() {
	super();
	initialize();
    }

    public XLinkLabel(int fixedWidth) {
	super(fixedWidth);
	initialize();
    }

    public String getLink() {
	return link;
    }

    public void setLink(String link) {
	this.link = link;
    }

    private void initialize() {
	this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	this.addMouseListener(new MouseListener() {

	    public void mouseClicked(MouseEvent e) {
		if (link == null) {
		    return;
		}
		SystemBrowser.displayURL(link);
	    }

	    public void mousePressed(MouseEvent e) {

	    }

	    public void mouseReleased(MouseEvent e) {

	    }

	    public void mouseEntered(MouseEvent e) {

	    }

	    public void mouseExited(MouseEvent e) {

	    }

	});
    }

}
