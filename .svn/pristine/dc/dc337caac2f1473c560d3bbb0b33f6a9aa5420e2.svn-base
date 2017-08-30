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

/*
 * Created on 26.01.2005
 *
 */
package org.plazmaforge.framework.client.swing.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * @author Oleh Hapon
 *
 */
public class GridBagPanel extends JPanel {

    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    
//    public GridBagPanel(LayoutManager layout, boolean isDoubleBuffered) {
//        super(layout, isDoubleBuffered);
//        initialize();        
//    }
//
//    public GridBagPanel(LayoutManager layout) {
//        super(layout);
//        initialize();        
//    }
//
//    public GridBagPanel(boolean isDoubleBuffered) {
//        super(isDoubleBuffered);
//        initialize();        
//    }

    public GridBagPanel() {
        //super();
        super(new GridBagLayout());
        initialize();
    }
    
    private void initialize() {
        setBorder(GUIEnvironment.createEmptyBorder());
        //super.setLayout(new GridBagLayout());
        gridBagConstraints.anchor = GUIEnvironment.getGridLayoutLabelAnchor();
        gridBagConstraints.insets = GUIEnvironment.createGridLayoutInsets();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;        
    }
    
    public GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }
    
    /*
    public void setLayout(LayoutManager mgr) {
        throw new IllegalArgumentException();
    }
    */
    
    public Component add(Component comp) {
        super.add(comp, gridBagConstraints);
        return comp;
    }
    
    public void addByX(Component comp) {
        gridBagConstraints.gridx++;
        add(comp);
    }
    
    public void addByY(Component comp) {
        gridBagConstraints.gridy++;
        add(comp);
    }
	
	public void addSeparator(int width) {
		addSeparator(0, width);
	}
	
	public void addSeparator(int x, int width) {
		
		// store
		int oldX = gridBagConstraints.gridx;
		int oldWidth = gridBagConstraints.gridwidth;
		int oldFill = gridBagConstraints.fill;
		
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridwidth = width;
		
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		addByY(new JSeparator());
		
		// restore
		gridBagConstraints.gridx = oldX;
		gridBagConstraints.gridwidth = oldWidth;
		gridBagConstraints.fill = oldFill;
		
	}
	
    
}
